
package com.ProyectoFinal.Portfolio.Dto;

import javax.validation.constraints.NotBlank;


public class dtoHabilidadB {
    @NotBlank
    private String habilidadB;
    @NotBlank
    private int porcentajeB;

    public dtoHabilidadB() {
    }

    public dtoHabilidadB(String habilidadB, int porcentajeB) {
        this.habilidadB = habilidadB;
        this.porcentajeB = porcentajeB;
    }

    public String getHabilidadB() {
        return habilidadB;
    }

    public void setHabilidadB(String habilidadB) {
        this.habilidadB = habilidadB;
    }

    public int getPorcentajeB() {
        return porcentajeB;
    }

    public void setPorcentajeB(int porcentajeB) {
        this.porcentajeB = porcentajeB;
    }
    
    
    
}
