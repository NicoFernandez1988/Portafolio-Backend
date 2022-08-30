
package com.ProyectoFinal.Portfolio.Controladores;


import com.ProyectoFinal.Portfolio.Dto.dtoHabilidadD;
import com.ProyectoFinal.Portfolio.Entidades.HabilidadDura;
import com.ProyectoFinal.Portfolio.Seguridad.Controlador.Mensaje;
import com.ProyectoFinal.Portfolio.Servicios.SHabilidadD;
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
@RequestMapping("/habilidadD")
@CrossOrigin(origins = "https://portafolio-integrador.web.app")
//@CrossOrigin(origins = "http://localhost:4200")
public class CHabilidadD {
    @Autowired
    SHabilidadD sHabilidadD;
    
    @GetMapping("/lista")
    public ResponseEntity<List<HabilidadDura>> list(){
        List<HabilidadDura> list = sHabilidadD.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoHabilidadD dtohabiD){
        if(StringUtils.isBlank(dtohabiD.getHabilidadD()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(sHabilidadD.existsByHabilidadD(dtohabiD.getHabilidadD()))
            return new ResponseEntity (new Mensaje("Esa habilidad ya existe"), HttpStatus.BAD_REQUEST);
        
        HabilidadDura habilidadDura = new HabilidadDura (dtohabiD.getHabilidadD(), dtohabiD.getPorcentajeD());
        sHabilidadD.save(habilidadDura);
        
        return new ResponseEntity(new Mensaje("Habilidad agregada correctamente"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoHabilidadD dtohabiD){
        if(!sHabilidadD.existsById(id))
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        
        if(sHabilidadD.existsByHabilidadD(dtohabiD.getHabilidadD()) && sHabilidadD.getByHabilidadD(dtohabiD.getHabilidadD()).get().getId() != id)
                return new ResponseEntity(new Mensaje("Esa habilidad ya existe"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(dtohabiD.getHabilidadD()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        HabilidadDura habilidadDura = sHabilidadD.getOne(id).get();
        habilidadDura.setHabilidadD(dtohabiD.getHabilidadD());
        habilidadDura.setPorcentajeD((dtohabiD.getPorcentajeD()));
        
        sHabilidadD.save(habilidadDura);
        return new ResponseEntity(new Mensaje("Habilidad actualizada"), HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<HabilidadDura> getById(@PathVariable("id") int id){
        if(!sHabilidadD.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        HabilidadDura habilidadDura = sHabilidadD.getOne(id).get();
        return new ResponseEntity(habilidadDura, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sHabilidadD.existsById(id)){
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.NOT_FOUND);
        }
        sHabilidadD.delete(id);
        
        return new ResponseEntity(new Mensaje("Habilidad eliminada con exito"), HttpStatus.OK);
    }
}
