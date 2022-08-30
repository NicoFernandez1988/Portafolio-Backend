
package com.ProyectoFinal.Portfolio.Entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Estudio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreInsti;
    private String nombreCerti;
    private String descripcionEst;

    public Estudio() {
    }

    public Estudio(String nombreInsti, String nombreCerti, String descripcionEst) {
        this.nombreInsti = nombreInsti;
        this.nombreCerti = nombreCerti;
        this.descripcionEst = descripcionEst;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
