/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmdm.test_sem_bogota.files.controller;

import com.jmdm.test_sem_bogota.files.service.FileUploadService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author José M Dager Montoya
 */
@RestController
@RequestMapping("/files")
@CrossOrigin
public class FilesController {

    @Autowired
    private FileUploadService filesService;

    @PostMapping("/upload")
    public void upload(@RequestParam MultipartFile file) throws IOException {
        this.filesService.upload(file);
    }
}
