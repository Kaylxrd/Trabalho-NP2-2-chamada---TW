package br.edu.unichristus.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unichristus.backend.data.dto.CampusDTO;
import br.edu.unichristus.backend.data.dto.UserDTO;
import br.edu.unichristus.backend.service.CampusService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/v1/campus")
public class CampusController {

	@Autowired
	private CampusService campusService;
	
	//GET -> Listar campus
	@Operation(summary = "Lista dados de todos os campus | role: [ADMIN]", tags = "Campus")
	@GetMapping
	public ResponseEntity<?> findAll(){
		return ResponseEntity.ok(campusService.findAll());
	}
	
	@Operation(summary = "Retorna os dados de um usuário a partir do ID | role: [ADMIN]", tags = "Campus")
	@ApiResponses({ 
		@ApiResponse(responseCode = "200", description = "Usuário retornado com sucesso"),
		@ApiResponse(responseCode = "404", description = "Usuário não encontrado"),
		@ApiResponse(responseCode = "500", description = "Erro interno no servidor - unichristus.backend.service.user.notfound.exception") })
	@GetMapping("/{id}")
	public CampusDTO findById(@PathVariable("id") Long id) {
		return campusService.findById(id);
	}
	
	//POST -> Adicionar campus
	
	@Operation(summary = "Cadastra os dados de um campus | role: [ADMIN]", tags = "Campus")
	@PostMapping
	public CampusDTO create(@RequestBody CampusDTO campus) {
		return campusService.save(campus);
	}
	
	//PUT -> Editar campus
	
	@Operation(summary = "Edita os dados de um campus | role: [ADMIN]", tags = "Campus")
	@PutMapping 
	public CampusDTO update(@RequestBody CampusDTO campus) {
		return campusService.save(campus);
	}
	
	//DELETE -> Deletar campus
	
	@Operation(summary = "Deleta um campus | role: [ADMIN]", tags = "Campus")
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		campusService.delete(id);
	}
	
	

}