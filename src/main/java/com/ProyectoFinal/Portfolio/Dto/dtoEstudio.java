
package com.ProyectoFinal.Portfolio.Dto;

import javax.validation.constraints.NotBlank;


public class dtoEstudio {
    @NotBlank
    private String nombreInsti;
    @NotBlank
    private String nombreCerti;
    @NotBlank
    private String descripcionEst;

    public dtoEstudio() {
    }

    public dtoEstudio(String nombreInsti, String nombreCerti, String descripcionEst) {
        this.nombreInsti = nombreInsti;
        this.nombreCerti = nombreCerti;
        this.descripcionEst = descripcionEst;
    }

    public String getNombreInsti() {
        return nombreInsti;
    }

    public void setNombreInsti(String nombreInsti) {
        this.nombreInsti = nombreInsti;
    }

    public String getNombreCerti() {
        return nombreCerti;
    }

    public void setNombreCerti(String nombreCerti) {
        this.nombreCerti = nombreCerti;
    }

    public String getDescripcionEst() {
        return descripcionEst;
    }

    public void setDescripcionEst(String descripcionEst) {
        this.descripcionEst = descripcionEst;
    }
    
    
    
}
