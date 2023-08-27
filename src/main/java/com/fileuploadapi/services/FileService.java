package com.fileuploadapi.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface FileService {

    //method for uploading image
    public String uploadImage(String path, MultipartFile file);
}
