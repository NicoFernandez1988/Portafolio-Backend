
package com.ProyectoFinal.Portfolio.Dto;

import javax.validation.constraints.NotBlank;


public class dtoHabilidadD {
     @NotBlank
    private String habilidadD;
    @NotBlank
    private int porcentajeD;

    public dtoHabilidadD() {
    }

    public dtoHabilidadD(String habilidadD, int porcentajeD) {
        this.habilidadD = habilidadD;
        this.porcentajeD = porcentajeD;
    }

    public String getHabilidadD() {
        return habilidadD;
    }

    public void setHabilidadD(String habilidadD) {
        this.habilidadD = habilidadD;
    }

    public int getPorcentajeD() {
        return porcentajeD;
    }

    public void setPorcentajeD(int porcentajeD) {
        this.porcentajeD = porcentajeD;
    }
    
    
    
}
