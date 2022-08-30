
package com.ProyectoFinal.Portfolio.Seguridad.Servicio;

import com.ProyectoFinal.Portfolio.Seguridad.Entity.Rol;
import com.ProyectoFinal.Portfolio.Seguridad.Enums.RolNombre;
import com.ProyectoFinal.Portfolio.Seguridad.Repositorio.IRolRepositorio;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolServicio {
    @Autowired
    IRolRepositorio irolRepositorio;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return irolRepositorio.findByRolNombre(rolNombre);
    }
    
    public void save(Rol rol){
        irolRepositorio.save(rol);
    }
}
