
package com.ProyectoFinal.Portfolio.Servicios;

import com.ProyectoFinal.Portfolio.Entidades.Estudio;
import com.ProyectoFinal.Portfolio.Repositorios.REstudio;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SEstudio {
    @Autowired
    REstudio rEstudio;
    
    public List<Estudio> list(){
        return rEstudio.findAll();
    }
    
    public Optional<Estudio> getOne(int id){
        return rEstudio.findById(id);
    }
    
    public Optional<Estudio> getByNombreInsti(String nombreInsti){
        return rEstudio.findByNombreInsti(nombreInsti);
    }
    
    public void save(Estudio estu){
        rEstudio.save(estu);
    }
    
    public void delete(int id){
        rEstudio.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rEstudio.existsById(id);
    }
    
    public boolean existsByNombreInsti(String nombreInsti){
        return rEstudio.existsByNombreInsti(nombreInsti);
    }

}
