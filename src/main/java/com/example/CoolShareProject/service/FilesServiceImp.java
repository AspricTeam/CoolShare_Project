package com.example.CoolShareProject.service;

import com.example.CoolShareProject.entity.Files;
import com.example.CoolShareProject.mapper.FileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
@Service
public class FilesServiceImp implements FilesService{
    @Autowired
    private FileMapper fileMapper;
    String defalut_save_path="F:\\CoolShare_Files";
    @Override
    public Files uploadnewfile(String u_id, String f_name, String f_ispublic, String f_pwd, MultipartFile file) {
        //服务器存储逻辑

        String path=defalut_save_path+"\\"+u_id+"\\";
        try{
            byte[] fileBytes = file.getBytes();
            File savedfile = new File(path+"\\"+f_name);
            FileCopyUtils.copy(file.getBytes(), savedfile);
            OutputStream outputStream = new FileOutputStream(savedfile);
            outputStream.write(fileBytes);
            long f_size_byte = savedfile.length();
            Files filesadd=new Files();

            filesadd.setF_size_byte(f_size_byte);

            int id=Integer.valueOf(u_id);

            filesadd.setF_name(f_name);

            Date currentDate = new Date();
            Timestamp timestamp = new Timestamp(currentDate.getTime());
            filesadd.setF_upload_time(timestamp);

            int ispublic=Integer.valueOf(f_ispublic);
            filesadd.setF_ispublic(ispublic);

            if (!f_pwd.equals(null) || f_pwd!=""){
                filesadd.setF_pwd(f_pwd);
            }

            filesadd.setF_download_time(0);



            //加入数据库
            int f_id=fileMapper.addFile(filesadd);
            fileMapper.RelateUF(String.valueOf(id),u_id);

            return filesadd;
        }catch (Exception e){
            Files filesfailed=new Files();
            filesfailed.setF_id(0);
            return filesfailed;
        }
    }

    @Override
    public ArrayList<Files> getRootFiles(String u_id) {
        ArrayList<Files> resUsers=fileMapper.getFilesByUid(u_id);
        return resUsers;
    }

    @Override
    public int deleteFileById(String f_id, String u_id) {

        //磁盘删除
        String filename=fileMapper.getFileNameById(f_id);
        File file = new File(defalut_save_path+"\\"+u_id+"\\"+filename);
        file.delete();
        //数据库删除
        int stat=fileMapper.deleteFileById(f_id,u_id);
        if (stat!=1)
            return -2;
        else
            return stat;
    }

    @Override
    public int renameFileById(String f_id, String newname) {

        //磁盘重命名
        String u_id=fileMapper.getUidByFileId(f_id);
        String oldname=fileMapper.getFileNameById(f_id);

        File oldFile = new File(defalut_save_path+"\\"+u_id+"\\"+oldname);
        File newFile = new File(defalut_save_path+"\\"+u_id+"\\"+newname);
        if (oldFile.exists()) {
            oldFile.renameTo(newFile);
        }else {
            return -3;
        }//数据库更改
        int stat=fileMapper.renameFileById(f_id,newname);
        if (stat!=0){
            return 1;
        }else{
            return -2;
        }

    }

    @Override
    public String getFileNameById(String f_id) {
        return fileMapper.getFileNameById(f_id);
    }

    @Override
    public String getUidByFileId(String f_id) {
        return fileMapper.getUidByFileId(f_id);
    }

    @Override
    public ArrayList<Files> searchFile(String u_id, String f_name) {
        try {
            return fileMapper.searchFile(u_id,f_name);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }

    }

    @Override
    public Files getFileInfoById(String f_id) {
        return fileMapper.getFileInfoById(f_id);
    }

    @Override
    public File getFileOfFid(String f_id,String f_pwd) {
        try {
            Files fileinfo=fileMapper.getFileInfoById(f_id);
            String filepwd=fileinfo.getF_pwd();
            //密码验证
            if (!filepwd.equals("")){//存在密码则验证
                if (!filepwd.equals(f_pwd)){
                    return null;
                }
            }
            String u_id=fileMapper.getUidByFileId(f_id);
            String filename=fileinfo.getF_name();
            String path=defalut_save_path+"\\"+u_id+"\\"+filename;
            File downloadedfile=new File(path);
            return downloadedfile;
        }catch (Exception e){
            return null;
        }

    }


}
