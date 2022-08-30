
package com.ProyectoFinal.Portfolio.Servicios;

import com.ProyectoFinal.Portfolio.Entidades.HabilidadBlanda;
import com.ProyectoFinal.Portfolio.Repositorios.RHabilidadB;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SHabilidadB {
    @Autowired
    RHabilidadB rHabilidadB;
    
    public List<HabilidadBlanda> list(){
        return rHabilidadB.findAll();
    }
    
    public Optional<HabilidadBlanda> getOne(int id){
        return rHabilidadB.findById(id);
    }
    
    public Optional<HabilidadBlanda> getByHabilidadB(String habilidadB){
        return rHabilidadB.findByHabilidadB(habilidadB);
    }
    
    public void save(HabilidadBlanda habiB){
        rHabilidadB.save(habiB);
    }
    
    public void delete(int id){
        rHabilidadB.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rHabilidadB.existsById(id);
    }
    
    public boolean existsByHabilidadB(String habilidadB){
        return rHabilidadB.existsByHabilidadB(habilidadB);
    }
}
