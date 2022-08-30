
package com.ProyectoFinal.Portfolio.Repositorios;


import com.ProyectoFinal.Portfolio.Entidades.Persona;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRepositorio extends JpaRepository<Persona, Integer> {
    public Optional<Persona> findByNombre(String nombreP);
    public boolean existsByNombre(String nombreP);
    
}
