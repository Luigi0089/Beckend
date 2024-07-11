package it.corso.service;

import java.util.List;

import it.corso.dto.UtenteLoginResponseDto;
import it.corso.dto.UtenteRegistrazioneDto;
import it.corso.dto.UtenteUpdateDto;
import it.corso.dto.UtenteUpdatePasswordDto;
import it.corso.model.Utente;
import it.corso.service.dto.UtenteLoginRequestDto;

public interface UtenteService {
	
  void UtenteRegistrazione(UtenteRegistrazioneDto utente);
	
	Utente getUtenteById(int id);
	
	void updateUtenteData(UtenteUpdateDto utente);
	
	boolean updateUtentePassword(UtenteUpdatePasswordDto utente);
	
	void deleteUtente(String email);
	
	boolean existUtenteByEmail( String email);

	Utente getUtenteByEmail(String email);

	List<Utente> getUtenti();

	public UtenteLoginResponseDto issueToken( String email);
	
	public boolean Login(UtenteLoginRequestDto utenteLoginRequestDto);
		
	
}
