package br.edu.unichristus.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.edu.unichristus.backend.converter.DozerConverter;
import br.edu.unichristus.backend.data.dto.CursoDTO;
import br.edu.unichristus.backend.data.dto.CursoLowDTO;
import br.edu.unichristus.backend.data.model.Curso;
import br.edu.unichristus.backend.exception.CommonsException;
import br.edu.unichristus.backend.repository.CursoRepository;

@Service
public class CursoService {

	@Autowired
	private CursoRepository repositoryCurso;
	
	
	public CursoDTO save(CursoDTO dto) {
		if(dto.getName().length() > 100) {
			throw new CommonsException(HttpStatus.BAD_REQUEST, 
					"unichristus.backend.service.user.badrequest.exception", 
					"O nome do curso excede o limite de 100 caracteres.");
		}
		
		/*if(!(repositoryCurso.findBySemestres(dto.getSemestres()) == null)) {
			throw new CommonsException(HttpStatus.CONFLICT, 
					"unichristus.backend.service.user.conflict.exception", 
					"O semestre informado já existe.");
		}
		*/

		if(dto.getId() != null) {
			this.findById(dto.getId());
		}
		
		var curso = DozerConverter.parseObject(dto, Curso.class);
		var cursoDTOSaved = DozerConverter
				.parseObject(repositoryCurso.save(curso), CursoDTO.class);
		
		return cursoDTOSaved;
	}
	
	public void delete(Long id) {
		this.findById(id);
		repositoryCurso.deleteById(id);
	}
	
	
	public CursoDTO findById(Long id) {
		var curso = repositoryCurso.findById(id);
		if(curso == null || curso.isEmpty()) {
			throw new CommonsException(HttpStatus.NOT_FOUND, 
					"unichristus.backend.service.user.notfound.exception",
					"Usuário não encontrado.");
		}
		return DozerConverter.parseObject(curso.get(), CursoDTO.class);
	}
	
	public List<CursoLowDTO> findAll(){
		return DozerConverter.parseListObjects
				(repositoryCurso.findAll(), CursoLowDTO.class);
	}
	
	
	
	
}
