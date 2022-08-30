
package com.ProyectoFinal.Portfolio.Repositorios;

import com.ProyectoFinal.Portfolio.Entidades.Proyecto;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface RProyecto extends JpaRepository<Proyecto, Integer> {
    public Optional<Proyecto> findByTituloP(String tituloP);
    public boolean existsByTituloP(String tituloP);
}
