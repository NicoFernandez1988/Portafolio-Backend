
package com.ProyectoFinal.Portfolio.Servicios;

import com.ProyectoFinal.Portfolio.Entidades.Persona;
import com.ProyectoFinal.Portfolio.Repositorios.IPersonaRepositorio;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpPersonaServicio{

    @Autowired 
    IPersonaRepositorio rPersona;
    
    public List<Persona> list(){
        return rPersona.findAll();
    }
    
    public Optional<Persona> getOne(int id){
        return rPersona.findById(id);
    }
    
    public Optional<Persona> getByNombre(String nombreP){
        return rPersona.findByNombre(nombreP);
    }
    
    public void save(Persona perso){
        rPersona.save(perso);
    }
    
    public void delete(int id){
        rPersona.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rPersona.existsById(id);
    }
    
    public boolean existsByNombre(String nombreP){
        return rPersona.existsByNombre(nombreP);
    }

    
    
    
    
}
