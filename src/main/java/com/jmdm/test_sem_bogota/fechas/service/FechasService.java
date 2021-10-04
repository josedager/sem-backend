/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmdm.test_sem_bogota.fechas.service;

import com.jmdm.test_sem_bogota.fechas.dto.FechaDTO;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

/**
 *
 * @author José M Dager Montoya
 */
@Service
public class FechasService {

    public ArrayList<FechaDTO> timeInWord(String filePath) throws IOException {
        BufferedReader bfReader = Files.newBufferedReader(Paths.get(filePath));
        String lineaUno;
        String lineaDos;
        String decenas[] = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        String unidades[] = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        ArrayList<FechaDTO> resultado = new ArrayList<>();
        while ((lineaUno = bfReader.readLine()) != null && (lineaDos = bfReader.readLine()) != null) {
            try {
                String timeInWord = "";
                String timePart = "past";
                String horaOriginal = lineaUno;
                String minutosOriginal = lineaDos;
                
                int hora = Integer.valueOf(horaOriginal);
                int minutos = Integer.valueOf(minutosOriginal);
                
                if ((hora >= 1 && hora <= 12) && (minutos >= 0 && minutos < 60)) {
                    if(minutos>30){
                        minutos = 60 - minutos;
                        timePart = "to";
                    }
                    
                    String horaLetra = unidades[hora];
                    String minutosLetra = minutos <= 19 ? unidades[minutos] : decenas[minutos / 10] + " " + unidades[minutos % 10];
                    
                    if(minutos == 0){
                        timeInWord = horaLetra + " o' clock";
                    }
                    else{
                        minutosLetra = minutos == 15 ? "quarter" : minutos == 30 ? "half" : minutosLetra;
                        timeInWord = minutosLetra + " " + timePart + " " + horaLetra;
                    }
                    resultado.add(new FechaDTO(horaOriginal, minutosOriginal, timeInWord));
                }
            } catch (NumberFormatException error) {
                System.out.println("No es un número");
            }
        }
        return resultado;
    }

}
