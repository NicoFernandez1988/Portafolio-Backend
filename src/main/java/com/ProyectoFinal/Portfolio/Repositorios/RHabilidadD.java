
package com.ProyectoFinal.Portfolio.Repositorios;

import com.ProyectoFinal.Portfolio.Entidades.HabilidadDura;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RHabilidadD extends JpaRepository<HabilidadDura, Integer> {
    public Optional<HabilidadDura> findByHabilidadD(String habilidadD);
    public boolean existsByHabilidadD(String habilidadD);
}
