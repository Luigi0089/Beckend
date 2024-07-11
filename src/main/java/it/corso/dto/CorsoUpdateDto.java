package it.corso.dto;

import it.corso.enums.NomeCategoria;
import jakarta.validation.constraints.Pattern;

public class CorsoUpdateDto {

	@Pattern(regexp="[a-zA-Z\\èàùìò]{1,50}", message= "nome con caratteri non ammessi")
	private String nome; 
	 
	@Pattern(regexp="[a-zA-Z\\èàùìò]{1,100}", message= "nome con caratteri non ammessi")
	 private String descrizione_breve;
	 
	@Pattern(regexp="[a-zA-Z\\èàùìò]{1,10000}", message= "nome con caratteri non ammessi")
	 private String Descrizione_completa; 
	 
	 private int durata;
	 
		private CategoriaDto categoria;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione_breve() {
		return descrizione_breve;
	}

	public void setDescrizione_breve(String descrizione_breve) {
		this.descrizione_breve = descrizione_breve;
	}

	public String getDescrizione_completa() {
		return Descrizione_completa;
	}

	public void setDescrizione_completa(String descrizione_completa) {
		Descrizione_completa = descrizione_completa;
	}

	public int getDurata() {
		return durata;
	}

	public void setDurata(int durata) {
		this.durata = durata;
	}
	 
  public int getCategoriaId() {
	  return categoria.getId();
  }
	 
	 public void setCategoriaId(int id) {
		 categoria.setId(id);
	 }
	 
	  public NomeCategoria  getCategoriaNome() {
		  return categoria.getNomeCategoria();
	  }
	  
	  public void setCategoriaNome(NomeCategoria nomeCategoria) {
		  categoria.setNomeCategoria(nomeCategoria);
	  }
		 
	 
}
