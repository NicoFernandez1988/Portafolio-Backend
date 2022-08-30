
package com.ProyectoFinal.Portfolio.Seguridad.Repositorio;

import com.ProyectoFinal.Portfolio.Seguridad.Entity.Rol;
import com.ProyectoFinal.Portfolio.Seguridad.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolRepositorio extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
    
}
