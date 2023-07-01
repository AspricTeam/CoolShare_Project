package com.example.coolshare_project.service;

import com.example.coolshare_project.mapper.FileMapper;
import com.example.coolshare_project.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.io.File;

public class DownLoadFileServiseImpl implements DownLoadFileServise{
    @Autowired
    FileMapper fileMapper;
    @Override
    public File DownloadFile() {

//        String filePath = path;//"/path/to/file"
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
//        FileSystemResource fileResource = new FileSystemResource(new File(filePath));
//        FileSystemResource fileResource;
//        headers.setContentDispositionFormData("attachment", fileResource.getFilename());
        return null;
    }
}
