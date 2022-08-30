
package com.ProyectoFinal.Portfolio.Dto;

import javax.validation.constraints.NotBlank;


public class dtoProyecto {
    @NotBlank
    private String tituloP;
    @NotBlank
    private String tecnologia;
    @NotBlank
    private String imagen;
    @NotBlank
    private String descripcionP;

    public dtoProyecto() {
    }

    public dtoProyecto(String tituloP, String tecnologia, String imagen, String descripcionP) {
        this.tituloP = tituloP;
        this.tecnologia = tecnologia;
        this.imagen = imagen;
        this.descripcionP = descripcionP;
    }

    public String getTituloP() {
        return tituloP;
    }

    public void setTituloP(String tituloP) {
        this.tituloP = tituloP;
    }

    public String getTecnologia() {
        return tecnologia;
    }

    public void setTecnologia(String tecnologia) {
        this.tecnologia = tecnologia;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getDescripcionP() {
        return descripcionP;
    }

    public void setDescripcionP(String descripcionP) {
        this.descripcionP = descripcionP;
    }
    
    
}
