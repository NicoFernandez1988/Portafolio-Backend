
package com.ProyectoFinal.Portfolio.Controladores;

import com.ProyectoFinal.Portfolio.Dto.dtoHabilidadB;
import com.ProyectoFinal.Portfolio.Entidades.HabilidadBlanda;
import com.ProyectoFinal.Portfolio.Seguridad.Controlador.Mensaje;
import com.ProyectoFinal.Portfolio.Servicios.SHabilidadB;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/habilidadB")
@CrossOrigin(origins = "https://portafolio-integrador.web.app")
//@CrossOrigin(origins = "http://localhost:4200")
public class CHabilidadB {
    @Autowired
    SHabilidadB sHabilidadB;
    
     @GetMapping("/lista")
    public ResponseEntity<List<HabilidadBlanda>> list(){
        List<HabilidadBlanda> list = sHabilidadB.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoHabilidadB dtohabiB){
        if(StringUtils.isBlank(dtohabiB.getHabilidadB()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(sHabilidadB.existsByHabilidadB(dtohabiB.getHabilidadB()))
            return new ResponseEntity (new Mensaje("Esa habilidad ya existe"), HttpStatus.BAD_REQUEST);
        
        HabilidadBlanda habilidadBlanda = new HabilidadBlanda (dtohabiB.getHabilidadB(), dtohabiB.getPorcentajeB());
        sHabilidadB.save(habilidadBlanda);
        
        return new ResponseEntity(new Mensaje("Habilidad agregada correctamente"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoHabilidadB dtohabiB){
        if(!sHabilidadB.existsById(id))
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        
        if(sHabilidadB.existsByHabilidadB(dtohabiB.getHabilidadB()) && sHabilidadB.getByHabilidadB(dtohabiB.getHabilidadB()).get().getId() != id)
                return new ResponseEntity(new Mensaje("Esa habilidad ya existe"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(dtohabiB.getHabilidadB()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        HabilidadBlanda habilidadBlanda = sHabilidadB.getOne(id).get();
        habilidadBlanda.setHabilidadB(dtohabiB.getHabilidadB());
        habilidadBlanda.setPorcentajeB((dtohabiB.getPorcentajeB()));
        
        sHabilidadB.save(habilidadBlanda);
        return new ResponseEntity(new Mensaje("Habilidad actualizada"), HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<HabilidadBlanda> getById(@PathVariable("id") int id){
        if(!sHabilidadB.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        HabilidadBlanda habilidadBlanda = sHabilidadB.getOne(id).get();
        return new ResponseEntity(habilidadBlanda, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sHabilidadB.existsById(id)){
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.NOT_FOUND);
        }
        sHabilidadB.delete(id);
        
        return new ResponseEntity(new Mensaje("Habilidad eliminada con exito"), HttpStatus.OK);
    }
}
