/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmdm.test_sem_bogota.fechas.dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author José M Dager Montoya
 */

public class FechaDTO {
    @NotBlank
    private String hora;
    
    @NotBlank
    private String minutos;
    
    @NotBlank
    private String timeInWord;

    public FechaDTO(String hora, String minutos, String timeInWord) {
        this.hora = hora;
        this.minutos = minutos;
        this.timeInWord = timeInWord;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getMinutos() {
        return minutos;
    }

    public void setMinutos(String minutos) {
        this.minutos = minutos;
    }

    public String getTimeInWord() {
        return timeInWord;
    }

    public void setTimeInWord(String timeInWord) {
        this.timeInWord = timeInWord;
    }
    
}
