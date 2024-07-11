package it.corso.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import it.corso.dao.CategoriaDao;
import it.corso.dao.CorsoDao;
import it.corso.dto.CategoriaDto;
import it.corso.dto.CorsoCreazioneDto;
import it.corso.dto.CorsoGetDto;
import it.corso.dto.CorsoUpdateDto;
import it.corso.model.Categoria;
import it.corso.model.Corso;
import org.springframework.stereotype.Service;

@Service
public class CorsoServiceImpl implements CorsoService {
	
	@Autowired
	private CorsoDao corsoDao;
	
	@Autowired 
	CategoriaDao categoriaDao;
	
	@Override
	public void CorsoCreazione(CorsoCreazioneDto corso) {
		System.out.println("\ncorso nuovo:"+corso.getDescrizioneBreve()+ corso.getDescrizioneBreve());
		
		Corso corso_nuovo=new Corso();
		corso_nuovo.setNome(corso.getNome());
		corso_nuovo.setDescrizioneBreve(corso.getDescrizioneBreve());
		corso_nuovo.setDescrizioneCompleta(corso.getDescrizioneCompleta());
		corso_nuovo.setDurata(corso.getDurata());
		System.out.println("\ncorso nuovo:"+corso_nuovo.getDescrizioneBreve()+ corso_nuovo.getDescrizioneBreve());
		corsoDao.save(corso_nuovo);
	}

//	@Override
//	public CorsoGetDto getCorsoById(int id) {
//		
//	
//		 Optional<Corso> CorsoOptionalDb= corsoDao.findById(id);
//			
//			if(!CorsoOptionalDb.isPresent()) {
//				return new Corso();
//	       }
//			
//			Corso corso_nuovo=new Corso();
//			corso_nuovo.setNome(CorsoOptionalDb.get().getNome());
//			corso_nuovo.setDescrizione_breve(corso.getDescrizione_breve());
//			corso_nuovo.setDescrizione_completa(corso.getDescrizione_completa());
//			corso_nuovo.setDurata(corso.getDurata());
//			
//			return CorsoOptionalDb.get();
//}

	@Override
	public void updateCorsoData(CorsoUpdateDto corso) {
		Corso corso1=new Corso();
		corso1.setNome(corso.getNome());
		corso1.setDescrizioneBreve(corso.getDescrizione_breve());
		Corso corsoDb= null; //corsoDao.findByNomeAndDescrizione_breve(corso1.getNome(),corso1.getDescrizione_breve());
		
		if(corsoDb!=null) {
			
			
			corsoDb.setNome(corso.getNome());
			corsoDb.setDescrizioneBreve(corso.getDescrizione_breve());
			corsoDb.setDescrizioneBreve(corso.getDescrizione_completa());;
			corsoDb.setCategoria(corso.getCategoriaId(),corso.getCategoriaNome());
			corsoDb.setDurata(corso.getDurata());
			//utenteDb.setRuoli(utente.getRuoli());
			
			Categoria ruoliUtente = new Categoria();
	        Optional<Categoria> categoriaDb = categoriaDao.findById(corso.getCategoriaId());
	        
	        if(categoriaDb.isPresent()) {
	          Categoria categoria = categoriaDb.get();
	          
	          categoria.setId(corso.getCategoriaId());
	          categoria.setNomeCategoria(corso.getCategoriaNome());
	          corsoDb.setCategoria(categoria.getId(),categoria.getNomeCategoria());
			corsoDao.save(corsoDb);
		}
		// TODO Auto-generated method stub
		
	}
		
	}

	@Override
	public void deleteCorso(int id) {
		Optional<Corso> corsoOptionalDb = corsoDao.findById(id);
        if(corsoOptionalDb.isPresent()) {
        	corsoDao.delete(corsoOptionalDb.get());
        }
		
	}

	@Override
	public List<CorsoGetDto> getCorsi() {
		
		List<Corso> corsi = (List<Corso>) corsoDao.findAll();
		  List<CorsoGetDto> corsiDto = new ArrayList<>();
		  
		  for(Corso corso:corsi) {
			  CorsoGetDto corsoDto=new CorsoGetDto();
			  corsoDto.setNome(corso.getNome());
			  corsoDto.setDescrizione_breve(corso.getDescrizioneBreve());
			  corsoDto.setDurata(corso.getDurata());
			  corsiDto.add(corsoDto);
		  }
		
		return corsiDto;
	}

	public boolean existCosoByNomeAndDescrizione_breve(String nome, String descrizione_breve) {
		
		return corsoDao.existsByNomeAndDescrizioneBreve(nome, descrizione_breve);
		
	}

	@Override
	public CorsoGetDto getCorsoById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
