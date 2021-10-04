/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmdm.test_sem_bogota.fechas.controller;

import com.jmdm.test_sem_bogota.fechas.dto.FechaDTO;
import com.jmdm.test_sem_bogota.fechas.service.FechasService;
import com.jmdm.test_sem_bogota.files.service.FileUploadService;
import java.io.IOException;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author José M Dager Montoya
 */

@RestController
@RequestMapping("/fechas")
@CrossOrigin
public class FechasController {
    
    @Autowired
    private FileUploadService filesService;
    
    @Autowired
    private FechasService fechasService;

    @PostMapping("/timeInWord")
    public ArrayList<FechaDTO> upload(@RequestParam MultipartFile file) throws IOException {
        String filePath = this.filesService.upload(file);
        return this.fechasService.timeInWord(filePath);
    }
    
}
