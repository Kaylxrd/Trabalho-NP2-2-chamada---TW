package br.edu.unichristus.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.edu.unichristus.backend.converter.DozerConverter;
import br.edu.unichristus.backend.data.dto.CampusDTO;
import br.edu.unichristus.backend.data.dto.CampusLowDTO;
import br.edu.unichristus.backend.data.model.Campus;
import br.edu.unichristus.backend.exception.CommonsException;
import br.edu.unichristus.backend.repository.CampusRepository;

@Service
public class CampusService {

	@Autowired
	CampusRepository campusRepository;
	
	public CampusDTO save(CampusDTO dto) {
		if(dto.getLocalizacao().length() > 100) {
			throw new CommonsException(HttpStatus.BAD_REQUEST, 
					"unichristus.backend.service.user.badrequest.exception", 
					"A localizacao do campus excede o limite de 100 caracteres.");
		}
		
		if(!(campusRepository.findByLocalizacao(dto.getLocalizacao()) == null)) {
			throw new CommonsException(HttpStatus.CONFLICT, 
					"unichristus.backend.service.user.conflict.exception", 
					"A localização informada já existe.");
		}
		
		
		if(dto.getId() != null) {
			this.findById(dto.getId());
		}
		
		var campus = DozerConverter.parseObject(dto, Campus.class);
		var campusDTOSaved = DozerConverter
				.parseObject(campusRepository.save(campus), CampusDTO.class);
		
		return campusDTOSaved;
	}
	
	public void delete(Long id) {
		this.findById(id);
		campusRepository.deleteById(id);
	}
	
	public CampusDTO findById(Long id) {
		var campus = campusRepository.findById(id);
		if(campus == null || campus.isEmpty()) {
			throw new CommonsException(HttpStatus.NOT_FOUND, 
					"unichristus.backend.service.user.notfound.exception",
					"Campus não encontrado.");
		}
		return DozerConverter.parseObject(campus.get(), CampusDTO.class);
	}
	
	public List<CampusLowDTO> findAll(){
		return DozerConverter.parseListObjects
				(campusRepository.findAll(), CampusLowDTO.class);
	}
	
	
}
