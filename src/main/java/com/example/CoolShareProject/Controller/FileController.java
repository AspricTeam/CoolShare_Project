package com.example.CoolShareProject.Controller;

import com.example.CoolShareProject.entity.Files;
import com.example.CoolShareProject.service.FilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class FileController {
    @Autowired
    FilesService filesService;
    @PostMapping("/download")
    public ResponseEntity<Resource> download(String f_id,String pwd) throws IOException {
        File file=filesService.getFileOfFid(f_id,pwd);
        if (file!=null){//下载文件
            byte[] fileContent = java.nio.file.Files.readAllBytes(file.toPath());
            ByteArrayResource resource = new ByteArrayResource(fileContent);
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + file.getName());
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentLength(fileContent.length);
            // 构建响应实体
            ResponseEntity<Resource> responseEntity = ResponseEntity.ok()
                    .headers(headers)
                    .body(resource);
            return responseEntity;
        }else {//无文件
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

    }



    @PostMapping("/upload")
    public Files upload(HttpServletRequest request, HttpSession session, @RequestParam("file") MultipartFile file) {
        //u_id,f_pwd,Cookie
        try {
            //判断是否是登录者
            String islogin = (String) session.getAttribute("name");
            if (islogin.equals("logged")) {
                String u_id = request.getParameter("u_id");
                String f_name = request.getParameter("f_name");
                String f_ispublic = request.getParameter("f_ispublic");
                String f_pwd = request.getParameter("f_pwd");
                //是登录者上传，响应文件id
                Files successedFile = filesService.uploadnewfile(u_id, f_name, f_ispublic, f_pwd, file);
                //文件IO异常，响应0
                return successedFile;
            } else {
                //非登陆者上传，响应-1
                Files failedFile = new Files();
                failedFile.setF_id(-1);
                return failedFile;
            }
        } catch (Exception e) {
            //上传服务器异常，响应-2
            Files failedFile = new Files();
            failedFile.setF_id(-2);
            return failedFile;
        }
    }

    @PostMapping("/loadfiles")
    public FileStructJson loadFiles(HttpSession session, String u_id) {
        FileStructJson res = new FileStructJson();
        try {

            String islogin = (String) session.getAttribute("name");
            if (islogin.equals("logged")) {//登录返回文件
                res.setFiles(filesService.getRootFiles(u_id));
            } else {
                Files failedFile = new Files();
                failedFile.setF_id(-1);
                ArrayList<Files> f = new ArrayList<>();
                f.add(failedFile);
                res.setFiles(f);//不登录返回-1的文件
            }
        } catch (Exception e) {
            System.out.println(e);
            Files failedFile = new Files();
            failedFile.setF_id(-2);
            ArrayList<Files> f = new ArrayList<>();
            f.add(failedFile);
            res.setFiles(f);//服务器错误-2
        } finally {
            return res;
        }
    }
    @PostMapping("/delfile")
    public int delfile(HttpSession session,String f_id, String u_id) {
        try{
            String islogin = (String) session.getAttribute("name");
            if (islogin.equals("logged")) {//删文件
                return filesService.deleteFileById(f_id,u_id);
            }else {
                return 0;//没有权限，未登录
            }
        }catch (Exception e){
            return -1;//服务器错误
        }
    }
    @PostMapping("/renamefile")
    public int renamefile(HttpSession session,String f_id,String newname){
        try{
            String islogin = (String) session.getAttribute("name");
            if (islogin.equals("logged")) {//重命名
                filesService.renameFileById(f_id,newname);
                return 1;
            }else {
                return 0;//没有权限，未登录
            }
        }catch (Exception e){
            return -1;//服务器错误
        }
    }
    @PostMapping("/searchfile")
    public FileStructJson searchfile(HttpSession session,String u_id,String f_name){
        FileStructJson res = new FileStructJson();
        try{
            String islogin = (String) session.getAttribute("name");
            if (islogin.equals("logged")) {//搜索
                res.setFiles(filesService.searchFile(u_id,f_name));

                return res;
            }else {
                Files failedFile = new Files();
                failedFile.setF_id(-1);
                ArrayList<Files> f = new ArrayList<>();
                f.add(failedFile);
                res.setFiles(f);//不登录返回-1的文件
                return res;
            }
        }catch (Exception e){
            Files failedFile = new Files();
            failedFile.setF_id(-2);
            ArrayList<Files> f = new ArrayList<>();
            f.add(failedFile);
            res.setFiles(f);
            return res;     //服务器错误返回-2的文件
        }
    }
    @PostMapping("/filesinfo")
    public Files filesinfo(String f_id){
        Files resfile=new Files();
        try {
            return resfile=filesService.getFileInfoById(f_id);
        }catch (Exception e){
            resfile.setF_id(-1);
            return resfile;//未找到文件
        }
    }
    //测试用合并时可删除########################
        @PostMapping("/login")
        public String login (HttpSession session){
            session.setAttribute("name", "logged");
            System.out.println("有访问");
            return "success";
        }
        @PostMapping("/loginout")
        public String loginout (HttpSession session){
            session.invalidate();
            return "out success";
        }

    //测试用合并时可删除########################
    public static class FileStructJson{
        ArrayList<Files> files;
        public ArrayList<Files> getFiles() {
            return files;
        }
        public void setFiles(ArrayList<Files> files) {
            this.files=files;
        }
    }
    }



