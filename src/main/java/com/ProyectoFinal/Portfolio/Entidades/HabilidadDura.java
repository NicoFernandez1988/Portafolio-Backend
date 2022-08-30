
package com.ProyectoFinal.Portfolio.Entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HabilidadDura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String habilidadD;
    private int porcentajeD;

    public HabilidadDura() {
    }

    public HabilidadDura(String habilidadD, int porcentajeD) {
        this.habilidadD = habilidadD;
        this.porcentajeD = porcentajeD;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
