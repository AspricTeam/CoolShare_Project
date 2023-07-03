package com.example.CoolShareProject.service;

import com.example.CoolShareProject.entity.Files;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;

@Service
public interface FilesService {

    public Files uploadnewfile(String u_id, String f_name, String f_ispublic, String f_pwd, MultipartFile file);

    public ArrayList<Files> getRootFiles(String u_id);

    public int deleteFileById(String f_id,String u_id);

    public int renameFileById(String f_id,String newname);

    public String getFileNameById(String  f_id);

    public String getUidByFileId(String f_id);

    public ArrayList<Files> searchFile(String u_id,String f_name);

    public Files getFileInfoById(String f_id);

    public File getFileOfFid(String f_id,String f_pwd);
}
