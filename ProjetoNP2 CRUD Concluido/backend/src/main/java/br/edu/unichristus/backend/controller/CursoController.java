package br.edu.unichristus.backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unichristus.backend.data.dto.CursoDTO;
import br.edu.unichristus.backend.service.CursoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class CursoController {

	@Autowired
	private CursoService cursoService;
	

	//GET -> Vê todos os Cursos
	@Operation (summary = "Lista os dados dos curso | role: [ADMIN]", tags = "Curso")
	@GetMapping(value = "/cursos")
	public ResponseEntity<?> getAllCursos()
	{
		return ResponseEntity.ok(cursoService.findAll());
	}
	
	@Operation(summary = "Retorna os dados de um curso a partir do ID | role: [ADMIN]", tags = "Curso")
	@ApiResponses({ 
		@ApiResponse(responseCode = "200", description = "Curso retornado com sucesso"),
		@ApiResponse(responseCode = "404", description = "Curso não encontrado"),
		@ApiResponse(responseCode = "500", description = "Erro interno no servidor - unichristus.backend.service.curso.notfound.exception") })
	@GetMapping("/{id}")
	public CursoDTO findById(@PathVariable("id") Long id) {
		return cursoService.findById(id);
	}
	
	//Post -> Cadastra um Curso
	@Operation(summary = "Cadastra os dados do Curso | role: [ADMIN]", tags = "Curso")
	@PostMapping
	public CursoDTO create(@RequestBody CursoDTO curso) {
		return cursoService.save(curso);
	}
	
	//Put -> Atualiza o Curso
	@Operation(summary = "Edita os dados de um curso | role: [ADMIN]", tags = "Curso")
	@PutMapping 
	public CursoDTO update(@RequestBody CursoDTO curso) {
		return cursoService.save(curso);
	}
	
	//Delete -> Deleta Curso
	@Operation(summary = "Deleta um curso | role: [ADMIN]", tags = "Curso")
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		cursoService.delete(id);
	}
}
