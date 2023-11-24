package br.edu.unichristus.backend.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CampusLowDTO {
	
	@JsonProperty("nome")
	private String localizacao;
	
	private String cursos;
	private String qtdLaboratorios;
	private String qtdBibliotecas;

}