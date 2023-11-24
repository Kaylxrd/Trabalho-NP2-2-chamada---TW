package br.edu.unichristus.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unichristus.backend.data.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long>{

	Curso findBySemestres(String semestres);
}
