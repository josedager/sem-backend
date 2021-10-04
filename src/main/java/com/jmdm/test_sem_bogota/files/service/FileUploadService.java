/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmdm.test_sem_bogota.files.service;

import java.io.File;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author José M Dager Montoya
 */
@Service
public class FileUploadService {
    
    @Value("${uploadPath}")
    private String path;

    public String upload(MultipartFile file) throws IOException {
        String filePath = this.path+file.getOriginalFilename();
        System.out.println(filePath);
        file.transferTo(new File(filePath));
        return filePath;
    }
}
