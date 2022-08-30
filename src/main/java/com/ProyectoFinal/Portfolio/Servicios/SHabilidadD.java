
package com.ProyectoFinal.Portfolio.Servicios;

import com.ProyectoFinal.Portfolio.Entidades.HabilidadDura;
import com.ProyectoFinal.Portfolio.Repositorios.RHabilidadD;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SHabilidadD {
    @Autowired
    RHabilidadD rHabilidadD;
    
    public List<HabilidadDura> list(){
        return rHabilidadD.findAll();
    }
    
    public Optional<HabilidadDura> getOne(int id){
        return rHabilidadD.findById(id);
    }
    
    public Optional<HabilidadDura> getByHabilidadD(String habilidadD){
        return rHabilidadD.findByHabilidadD(habilidadD);
    }
    
    public void save(HabilidadDura habiD){
        rHabilidadD.save(habiD);
    }
    
    public void delete(int id){
        rHabilidadD.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rHabilidadD.existsById(id);
    }
    
    public boolean existsByHabilidadD(String habilidadD){
        return rHabilidadD.existsByHabilidadD(habilidadD);
    }
}
