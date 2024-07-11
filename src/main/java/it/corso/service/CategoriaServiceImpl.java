package it.corso.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



import it.corso.dao.CategoriaDao;
import it.corso.dto.CategoriaDto;
import it.corso.model.Categoria;

public class CategoriaServiceImpl implements CategoriaService {

	CategoriaDao categoriaDao;
	
	@Override
	 public List<CategoriaDto>  getAllCategorie() {
	  
	 
	List<Categoria> categorie = (List<Categoria>) categoriaDao.findAll();
	  List<CategoriaDto> categorieDto = new ArrayList<>();
	  
	  for(Categoria categoria:categorie) {
		  CategoriaDto categoriaDto=new CategoriaDto();
		  categoriaDto.setId(categoria.getId());
		  categoriaDto.setNomeCategoria(categoria.getNomeCategoria());
		  categorieDto.add(categoriaDto);
	  }
		
		 
		
		return categorieDto;

	}

	@Override
	public void deleteCategoria(int id) throws UnauthorizedException, ObjectNotFoundException {
		Optional<Categoria> categoriaOptional =categoriaDao.findById(id);
		if(!categoriaOptional.isEmpty()) {
			
			Categoria categoria=categoriaOptional.get();
			
			if(!categoria.getCorsi().isEmpty()) {
				categoriaDao.delete(categoria);
			}
			else {
				throw new UnauthorizedException();
			}
			
		}
		
		else {
			throw new ObjectNotFoundException();
			
		}
		
	}

	@Override
	public CategoriaDto getCategoriaById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void creaCategoria(CategoriaDto catogoriaDto) {
		// TODO Auto-generated method stub
		
	}

}
