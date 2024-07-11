package it.corso.dto;

import jakarta.validation.constraints.Pattern;

public class CorsoCreazioneDto {
	
	@Pattern(regexp="[a-zA-Z\\èàùìò]{1,50}", message= "nome con caratteri non ammessi")
	private String nome; 
	 
	
	 private String descrizioneBreve;
	 
	
	 private String descrizioneCompleta;
	
	private int durata; 
	 
	 public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizioneBreve() {
		return descrizioneBreve;
	}

	public void setDescrizioneBreve(String descrizioneBreve) {
		this.descrizioneBreve = descrizioneBreve;
	}

	public String getDescrizioneCompleta() {
		return descrizioneCompleta;
	}

	public void setDescrizioneCompleta(String descrizioneCompleta) {
		this.descrizioneCompleta = descrizioneCompleta;
	}

	public int getDurata() {
		return durata;
	}

	public void setDurata(int durata) {
		this.durata = durata;
	}

	
	 
}
