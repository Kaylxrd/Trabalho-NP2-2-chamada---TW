package br.edu.unichristus.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.edu.unichristus.backend.converter.DozerConverter;
import br.edu.unichristus.backend.data.dto.ProfessorDTO;
import br.edu.unichristus.backend.data.dto.ProfessorLowDTO;
import br.edu.unichristus.backend.data.model.Professor;
import br.edu.unichristus.backend.exception.CommonsException;
import br.edu.unichristus.backend.repository.ProfessorRepository;

@Service
public class ProfessorService {
	
	@Autowired
	private ProfessorRepository professorRepository;
	
	
	public ProfessorDTO save(ProfessorDTO dto) {
		if(dto.getName().length() > 100) {
			throw new CommonsException(HttpStatus.BAD_REQUEST, 
					"unichristus.backend.service.user.badrequest.exception", 
					"O nome do professor excede o limite de 100 caracteres.");
		}
		
		if(!(professorRepository.findByEmail(dto.getEmail()) == null)) {
			throw new CommonsException(HttpStatus.CONFLICT, 
					"unichristus.backend.service.user.conflict.exception", 
					"O email informado já existe.");
		}
		
		if(!(professorRepository.findByLogin(dto.getLogin()) == null)) {
			throw new CommonsException(HttpStatus.CONFLICT, 
					"unichristus.backend.service.user.conflict.exception", 
					"O login informado já existe.");
		}
		
		if(dto.getId() != null) {
			this.findById(dto.getId());
		}
		
		var professor = DozerConverter.parseObject(dto, Professor.class);
		var professorDTOSaved = DozerConverter
				.parseObject(professorRepository.save(professor), ProfessorDTO.class);
		
		return professorDTOSaved;
	}
	
	public void delete(Long id) {
		this.findById(id);
		professorRepository.deleteById(id);
	}
	
	
	
	public ProfessorDTO findById(Long id) {
		var professor = professorRepository.findById(id);
		if(professor == null || professor.isEmpty()) {
			throw new CommonsException(HttpStatus.NOT_FOUND, 
					"unichristus.backend.service.user.notfound.exception",
					"Usuário não encontrado.");
		}
		return DozerConverter.parseObject(professor.get(), ProfessorDTO.class);
	}
	
	public List<ProfessorLowDTO> findAll(){
		return DozerConverter.parseListObjects
				(professorRepository.findAll(), ProfessorLowDTO.class);
	}
}


