
package com.ProyectoFinal.Portfolio.Controladores;

import com.ProyectoFinal.Portfolio.Dto.dtoEstudio;
import com.ProyectoFinal.Portfolio.Entidades.Estudio;
import com.ProyectoFinal.Portfolio.Seguridad.Controlador.Mensaje;
import com.ProyectoFinal.Portfolio.Servicios.SEstudio;
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
@RequestMapping("/estudios")
@CrossOrigin(origins = "https://portafolio-integrador.web.app")
//@CrossOrigin(origins = "http://localhost:4200")
public class CEstudio {
    @Autowired
    SEstudio sEstudio;
    
     @GetMapping("/lista")
    public ResponseEntity<List<Estudio>> list(){
        List<Estudio> list = sEstudio.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEstudio dtoest){
        if(StringUtils.isBlank(dtoest.getNombreInsti()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(sEstudio.existsByNombreInsti(dtoest.getNombreInsti()))
            return new ResponseEntity (new Mensaje("El estudio existe"), HttpStatus.BAD_REQUEST);
        
        Estudio estudio = new Estudio (dtoest.getNombreInsti(), dtoest.getNombreCerti(), dtoest.getDescripcionEst());
        sEstudio.save(estudio);
        
        return new ResponseEntity(new Mensaje("Estudio agregado correctamente"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEstudio dtoest){
        if(!sEstudio.existsById(id))
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        
        if(sEstudio.existsByNombreInsti(dtoest.getNombreInsti()) && sEstudio.getByNombreInsti(dtoest.getNombreInsti()).get().getId() != id)
                return new ResponseEntity(new Mensaje("Ese estudio ya existe"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(dtoest.getNombreInsti()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Estudio estudio = sEstudio.getOne(id).get();
        estudio.setNombreInsti(dtoest.getNombreInsti());
        estudio.setNombreCerti(dtoest.getNombreCerti());
        estudio.setDescripcionEst(dtoest.getDescripcionEst());
        
        sEstudio.save(estudio);
        return new ResponseEntity(new Mensaje("Estudio actualizado"), HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Estudio> getById(@PathVariable("id") int id){
        if(!sEstudio.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Estudio estudio = sEstudio.getOne(id).get();
        return new ResponseEntity(estudio, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sEstudio.existsById(id)){
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.NOT_FOUND);
        }
        sEstudio.delete(id);
        
        return new ResponseEntity(new Mensaje("Estudio eliminado con exito"), HttpStatus.OK);
    }
    
}
