
package com.ProyectoFinal.Portfolio.Dto;

import javax.validation.constraints.NotBlank;


public class dtoPersona {
    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    @NotBlank
    private String imagen;
    @NotBlank
    private String titulo;
    @NotBlank
    private String provincia;
    @NotBlank
    private String pais;
    @NotBlank
    private String telefono;
    @NotBlank
    private String correo;
    @NotBlank
    private String descripcion;

    public dtoPersona() {
    }

    public dtoPersona(String nombre, String apellido, String imagen, String titulo, String provincia, String pais, String telefono, String correo, String descripcion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.imagen = imagen;
        this.titulo = titulo;
        this.provincia = provincia;
        this.pais = pais;
        this.telefono = telefono;
        this.correo = correo;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
