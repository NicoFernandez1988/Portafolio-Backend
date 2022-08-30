
package com.ProyectoFinal.Portfolio.Seguridad.Servicio;

import com.ProyectoFinal.Portfolio.Seguridad.Entity.Usuario;
import com.ProyectoFinal.Portfolio.Seguridad.Repositorio.IUsuarioRepositorio;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioServicio {
    @Autowired
    IUsuarioRepositorio iusuarioRepositorio;
    
    public Optional<Usuario> getByNombreUsuario (String nombreUsuario){
        return iusuarioRepositorio.findByNombreUsuario(nombreUsuario);
    }
    
    public boolean existsByNombreUsuario(String nombreUsuario){
        return iusuarioRepositorio.existsByNombreUsuario(nombreUsuario);
    }
    
    public boolean existsByEmail(String email){
        return iusuarioRepositorio.existsByEmail(email);
    }
    
    public void save(Usuario usuario){
        iusuarioRepositorio.save(usuario);
    }
}
