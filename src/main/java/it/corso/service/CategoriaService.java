package it.corso.service;

import java.util.List;

import it.corso.dto.CategoriaDto;

public interface CategoriaService {

	List<CategoriaDto> getAllCategorie();
	
	void deleteCategoria(int id)throws UnauthorizedException, ObjectNotFoundException;
	
	CategoriaDto getCategoriaById(int id);
	
	void creaCategoria(CategoriaDto catogoriaDto);
}
