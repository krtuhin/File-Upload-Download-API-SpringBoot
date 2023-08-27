package com.fileuploadapi.services.impl;

import com.fileuploadapi.services.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {

    //override method for uploading image
    @Override
    public String uploadImage(String path, MultipartFile file) {

        //image name
        String name = file.getOriginalFilename();

        //creating unique name for all files
        String uniqueFileName = UUID.randomUUID() + name.substring(name.lastIndexOf("."));

        //image url to save
        String filePath = path + File.separator + uniqueFileName;

        //if file not exist
        File f = new File(path);

        if (!f.exists()) {
            f.mkdir();
        }

        //copy file into server
        try {
            Files.copy(file.getInputStream(), Paths.get(filePath));

        } catch (IOException e) {

            e.printStackTrace();
        }

        return name;
    }
}
