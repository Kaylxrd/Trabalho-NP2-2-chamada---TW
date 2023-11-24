package br.edu.unichristus.backend.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CampusDTO {
	
	private Long id;
	private String localizacao;
	private String cursos;
	private String qtdLaboratorios;
	private String qtdBibliotecas;
	

}
