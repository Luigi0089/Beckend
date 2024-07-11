package it.corso.dto;

import java.util.ArrayList;
import java.util.List;

import it.corso.enums.Tipologia;
import it.corso.model.Ruolo;
import jakarta.validation.constraints.Pattern;

public class UtenteUpdateDto {

	@Pattern(regexp="[a-zA-Z\\èàùìò]{1,50}", message= "nome con caratteri non ammessi")
	private String nome;
	
	@Pattern(regexp="[a-zA-Z\\èàùìò]{1,50}", message= "nome con caratteri non ammessi")
	private String cognome;
	
	@Pattern(regexp="[A-z0-9\\.\\+_-]+@[A-z0-9\\._-]+\\.[A-z]{2,8}",message= "mail non valida")
	private String email;
	
	
	private RuoloDto ruolo;
	
	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCognome() {
		return cognome;
	}


	public void setCognome(String cognome) {
		this.cognome = cognome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

  public void setRuoloID( int id) {
	 ruolo.setId(id);
  }
  
  public int getRuoloId(){
	  return ruolo.getId();
  }
  
	public Tipologia getRuoloTipologia() {
		return ruolo.getTipologia();
	}



	public void setTipologia(Tipologia tipologia) {
		ruolo.setTipologia(tipologia);
	}

  


}
