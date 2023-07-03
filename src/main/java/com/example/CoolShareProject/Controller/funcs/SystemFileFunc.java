package com.example.CoolShareProject.Controller.funcs;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class SystemFileFunc {

    public static int saveFile(File file,String path){
        try {
            File dest = new File(path);
            file.renameTo(dest);
            return 0; // 保存文件成功
        } catch (Exception e) {
            e.printStackTrace();
            return -1; // 保存文件失败
        }
    }

    public static int delFile(File file,String path){
        try {
            if (file.delete()) {
                return 0; // 删除文件成功
            } else {
                return -1; // 删除文件失败
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1; // 删除文件失败
        }
    }

}
