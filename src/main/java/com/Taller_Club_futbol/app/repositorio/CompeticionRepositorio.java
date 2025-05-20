package com.Taller_Club_futbol.app.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Taller_Club_futbol.app.entidades.Competicion;

@Repository
public interface CompeticionRepositorio extends JpaRepository<Competicion, Long> {
}
