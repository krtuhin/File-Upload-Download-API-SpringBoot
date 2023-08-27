package com.fileuploadapi.controllers;

import com.fileuploadapi.payload.FileResponse;
import com.fileuploadapi.services.impl.FileServiceImpl;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

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

    //handler to serve image
    @GetMapping(path = "/images/{fileName}", produces = MediaType.APPLICATION_PDF_VALUE)
    public void fileDownload(@PathVariable("fileName") String fileName, HttpServletResponse response) {

        try {
            InputStream is = this.fileService.getFile(this.path, fileName);

            response.setContentType(MediaType.APPLICATION_PDF_VALUE);

            StreamUtils.copy(is, response.getOutputStream());

        } catch (IOException e) {

            throw new RuntimeException(e);
        }
    }
}
