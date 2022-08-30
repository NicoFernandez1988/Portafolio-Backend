
package com.ProyectoFinal.Portfolio.Controladores;

import com.ProyectoFinal.Portfolio.Dto.dtoPersona;
import com.ProyectoFinal.Portfolio.Entidades.Persona;
import com.ProyectoFinal.Portfolio.Seguridad.Controlador.Mensaje;
import com.ProyectoFinal.Portfolio.Servicios.ImpPersonaServicio;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/datosperso")
@CrossOrigin(origins = "https://portafolio-integrador.web.app")
//@CrossOrigin(origins = "http://localhost:4200")
public class PortalControladorPersona{

    @Autowired  
    ImpPersonaServicio sPersona;
    
   @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list(){
        List<Persona> list = sPersona.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoPersona dtoperso){
        if(StringUtils.isBlank(dtoperso.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(sPersona.existsByNombre(dtoperso.getNombre()))
            return new ResponseEntity (new Mensaje("Esa persona existe"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(dtoperso.getApellido()))
            return new ResponseEntity(new Mensaje("El apellido es obligatorio"), HttpStatus.BAD_REQUEST);
        if(sPersona.existsByNombre(dtoperso.getApellido()))
            return new ResponseEntity (new Mensaje("Esa persona existe"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(dtoperso.getImagen()))
            return new ResponseEntity(new Mensaje("La imagen es obligatoria"), HttpStatus.BAD_REQUEST);
        if(sPersona.existsByNombre(dtoperso.getImagen()))
            return new ResponseEntity (new Mensaje("Esa persona existe"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(dtoperso.getTitulo()))
            return new ResponseEntity(new Mensaje("El titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        if(sPersona.existsByNombre(dtoperso.getTitulo()))
            return new ResponseEntity (new Mensaje("Esa persona existe"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(dtoperso.getProvincia()))
            return new ResponseEntity(new Mensaje("La provincia es obligatorio"), HttpStatus.BAD_REQUEST);
        if(sPersona.existsByNombre(dtoperso.getProvincia()))
            return new ResponseEntity (new Mensaje("Esa persona existe"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(dtoperso.getPais()))
            return new ResponseEntity(new Mensaje("El pais es obligatorio"), HttpStatus.BAD_REQUEST);
        if(sPersona.existsByNombre(dtoperso.getPais()))
            return new ResponseEntity (new Mensaje("Esa persona existe"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(dtoperso.getTelefono()))
            return new ResponseEntity(new Mensaje("El telefono es obligatorio"), HttpStatus.BAD_REQUEST);
        if(sPersona.existsByNombre(dtoperso.getTelefono()))
            return new ResponseEntity (new Mensaje("Esa persona existe"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(dtoperso.getCorreo()))
            return new ResponseEntity(new Mensaje("El correo es obligatorio"), HttpStatus.BAD_REQUEST);
        if(sPersona.existsByNombre(dtoperso.getCorreo()))
            return new ResponseEntity (new Mensaje("Esa persona existe"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(dtoperso.getDescripcion()))
            return new ResponseEntity(new Mensaje("La descripcion es obligatoria"), HttpStatus.BAD_REQUEST);
        if(sPersona.existsByNombre(dtoperso.getDescripcion()))
            return new ResponseEntity (new Mensaje("Esa persona existe"), HttpStatus.BAD_REQUEST);
        
        Persona persona = new Persona (dtoperso.getNombre(), dtoperso.getApellido(), dtoperso.getImagen(), dtoperso.getTitulo(), dtoperso.getProvincia(), dtoperso.getPais(), dtoperso.getTelefono(), dtoperso.getCorreo(), dtoperso.getDescripcion());
        sPersona.save(persona);
        
        return new ResponseEntity(new Mensaje("Persona agregada correctamente"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPersona dtoperso){
        if(!sPersona.existsById(id))
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        
        if(sPersona.existsByNombre(dtoperso.getNombre()) && sPersona.getByNombre(dtoperso.getNombre()).get().getId() != id)
                return new ResponseEntity(new Mensaje("Esa persona ya existe"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(dtoperso.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Persona persona = sPersona.getOne(id).get();
        persona.setNombre((dtoperso.getNombre()));
        persona.setApellido(dtoperso.getApellido());
        persona.setImagen((dtoperso.getImagen()));
        persona.setTitulo(dtoperso.getTitulo());
        persona.setProvincia((dtoperso.getProvincia()));
        persona.setPais(dtoperso.getPais());
        persona.setTelefono(dtoperso.getTelefono());
        persona.setCorreo((dtoperso.getCorreo()));
        persona.setDescripcion((dtoperso.getDescripcion()));
        
        sPersona.save(persona);
        return new ResponseEntity(new Mensaje("Datos personales actualizados"), HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id){
        if(!sPersona.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Persona persona = sPersona.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sPersona.existsById(id)){
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.NOT_FOUND);
        }
        sPersona.delete(id);
        
        return new ResponseEntity(new Mensaje("Persona eliminada con exito"), HttpStatus.OK);
    }
}
