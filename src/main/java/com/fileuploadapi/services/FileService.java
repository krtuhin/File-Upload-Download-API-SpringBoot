package com.fileuploadapi.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.InputStream;

@Service
public interface FileService {

    //method for uploading image
    public String uploadImage(String path, MultipartFile file);

    //method to get file
    public InputStream getFile(String path, String fileName) throws FileNotFoundException;
}
