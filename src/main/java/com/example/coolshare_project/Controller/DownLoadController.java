package com.example.coolshare_project.Controller;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RequestMapping("/api")
@RestController
public class DownLoadController {
    @PostMapping("/downloadFile")
    public ResponseEntity<FileSystemResource> downloadFile(String path) {
        String filePath = path;//"/path/to/file"
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        FileSystemResource fileResource = new FileSystemResource(new File(filePath));
        FileSystemResource fileResource;
        headers.setContentDispositionFormData("attachment", fileResource.getFilename());
    }
}
