package br.edu.unichristus.backend.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursoLowDTO {
	
	@JsonProperty("nome")
	private String name;
	
	private String semestres;
	private String vagas;
	private String campus;
	


}