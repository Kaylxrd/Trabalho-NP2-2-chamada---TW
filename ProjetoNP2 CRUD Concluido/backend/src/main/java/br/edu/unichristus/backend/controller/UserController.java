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

import br.edu.unichristus.backend.data.dto.UserDTO;
import br.edu.unichristus.backend.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
	
	@Autowired
	private UserService service;

	@Operation(summary = "Cadastra os dados de um usuário | role: [ADMIN]", tags = "User")
	@PostMapping
	public UserDTO create(@RequestBody UserDTO user) {
		return service.save(user);
	}
	
	@Operation(summary = "Edita os dados de um usuário | role: [ADMIN]", tags = "User")
	@PutMapping 
	public UserDTO update(@RequestBody UserDTO user) {
		return service.save(user);
	}
	
	@Operation(summary = "Retorna os dados de um usuário a partir do ID | role: [ADMIN]", tags = "User")
	@ApiResponses({ 
		@ApiResponse(responseCode = "200", description = "Usuário retornado com sucesso"),
		@ApiResponse(responseCode = "404", description = "Usuário não encontrado"),
		@ApiResponse(responseCode = "500", description = "Erro interno no servidor - unichristus.backend.service.user.notfound.exception") })
	@GetMapping("/{id}")
	public UserDTO findById(@PathVariable("id") Long id) {
		return service.findById(id);
	}
	
	@Operation(summary = "Deleta um usuário | role: [ADMIN]", tags = "User")
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}
	
	@Operation(summary = "Lista dados de todos os usuários | role: [ADMIN]", tags = "User")
	@GetMapping
	public ResponseEntity<?> findAll(){
		return ResponseEntity.ok(service.findAll());
	}
	
}
