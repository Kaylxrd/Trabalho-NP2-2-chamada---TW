package br.edu.unichristus.backend.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursoDTO {

	private Long id;
	private String name;
	private String semestres;
	private String vagas;
	private String campus;
}
