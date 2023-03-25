package com.portfolio.mm.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.mm.Entity.Experiencia;

@Repository
public interface RExperiencia extends JpaRepository<Experiencia, Integer>{
	public Optional<Experiencia> findByNombreE(String nombreE);
	public boolean existsByNombre(String nombreE);
}
