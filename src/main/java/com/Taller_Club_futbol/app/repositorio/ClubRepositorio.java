package com.Taller_Club_futbol.app.repositorio;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.Taller_Club_futbol.app.entidades.Club;

@Repository
	public interface ClubRepositorio extends JpaRepository<Club, Long> {}

