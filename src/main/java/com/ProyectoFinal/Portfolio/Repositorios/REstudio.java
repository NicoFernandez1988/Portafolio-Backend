
package com.ProyectoFinal.Portfolio.Repositorios;

import com.ProyectoFinal.Portfolio.Entidades.Estudio;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface REstudio extends JpaRepository<Estudio, Integer> {
    public Optional<Estudio> findByNombreInsti(String nombreInsti);
    public boolean existsByNombreInsti(String nombreInsti);
    
}
