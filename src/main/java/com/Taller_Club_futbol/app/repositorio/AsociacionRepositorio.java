package com.Taller_Club_futbol.app.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Taller_Club_futbol.app.entidades.Asociacion;

@Repository
public interface AsociacionRepositorio extends JpaRepository<Asociacion, Long> {
}
