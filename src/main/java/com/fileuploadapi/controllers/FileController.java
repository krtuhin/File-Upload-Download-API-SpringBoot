package com.fileuploadapi.controllers;

import com.fileuploadapi.payload.FileResponse;
import com.fileuploadapi.services.impl.FileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileServiceImpl fileService;

    //getting path from application.properties
    @Value("${project.image}")
    String path;

    //handler to upload image
    @PostMapping("/upload")
    public ResponseEntity<FileResponse> fileUpload(@RequestParam("image") MultipartFile file) {

        //uploading image
        String fileName = this.fileService.uploadImage(path, file);

        return ResponseEntity.ok(new FileResponse(fileName, "File uploaded successfully..!"));
    }
}
