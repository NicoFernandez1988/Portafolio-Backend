
package com.ProyectoFinal.Portfolio.Interfaces;

import com.ProyectoFinal.Portfolio.Entidades.Persona;
import java.util.List;


public interface IPersonaServicio {
    
    public List<Persona> getPersona();
    
    public void savePersona(Persona persona);
    
    public void deletePersona(Long id);
    
    public Persona findPersona(Long id);
    
    
}
