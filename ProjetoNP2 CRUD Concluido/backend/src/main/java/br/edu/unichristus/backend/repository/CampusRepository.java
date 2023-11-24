package br.edu.unichristus.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unichristus.backend.data.model.Campus;

public interface CampusRepository extends JpaRepository<Campus, Long>{

	Campus findByLocalizacao (String localizacao);
}
