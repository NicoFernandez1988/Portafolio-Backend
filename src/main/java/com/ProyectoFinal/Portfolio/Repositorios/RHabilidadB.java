
package com.ProyectoFinal.Portfolio.Repositorios;

import com.ProyectoFinal.Portfolio.Entidades.HabilidadBlanda;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RHabilidadB extends JpaRepository<HabilidadBlanda, Integer> {
    public Optional<HabilidadBlanda> findByHabilidadB(String habilidadB);
    public boolean existsByHabilidadB(String habilidadB);
    
}
