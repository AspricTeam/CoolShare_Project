package com.example.coolshare_project.Controller;

import com.example.coolshare_project.service.UploadFileService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
public class UploadController {
    @PostMapping("/upload")
    public String handleUpload(
                               @RequestParam("f_id") String f_id,
                               @RequestParam("path") String path,
                               @RequestParam("file") MultipartFile file) {
        //验证Seesion
        UploadFileService uploadfile;
        // 传递userId、path和file参数给Service层方法
        // 处理上传逻辑
        // 返回相应的结果或重定向到其他页面
        return "uploadSuccess";
    }
}
