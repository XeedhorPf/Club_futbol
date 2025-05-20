package com.Taller_Club_futbol.app.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Taller_Club_futbol.app.entidades.Entrenador;

@Repository
public interface EntrenadorRepositorio extends JpaRepository<Entrenador, Long> {
}
