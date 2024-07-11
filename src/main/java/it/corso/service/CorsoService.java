package it.corso.service;

import java.util.List;

import it.corso.dto.CorsoCreazioneDto;
import it.corso.dto.CorsoGetDto;
import it.corso.dto.CorsoUpdateDto;
import it.corso.model.Corso;



public interface CorsoService {
	
	boolean existCosoByNomeAndDescrizione_breve(String nome, String descrizione_breve);
	
	 void CorsoCreazione(CorsoCreazioneDto corso);
		
		CorsoGetDto getCorsoById(int id);
		
		void updateCorsoData(CorsoUpdateDto corso);
		
		void deleteCorso(int id);


		List<CorsoGetDto> getCorsi();
}
