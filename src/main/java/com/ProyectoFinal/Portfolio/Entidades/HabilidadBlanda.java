
package com.ProyectoFinal.Portfolio.Entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HabilidadBlanda {
    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    private int id;
    private String habilidadB;
    private int porcentajeB;

    public HabilidadBlanda() {
    }

    public HabilidadBlanda(String habilidadB, int porcentajeB) {
        this.habilidadB = habilidadB;
        this.porcentajeB = porcentajeB;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
