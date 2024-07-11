package it.corso.model;

import java.util.ArrayList;
import java.util.List;

import it.corso.enums.NomeCategoria;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="categoria")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_CA")
	private int id;
	
	@Column(name="nome_categoria")
	@Enumerated(EnumType.STRING)
	private NomeCategoria nomeCategoria;
	
	 public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public NomeCategoria getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(NomeCategoria nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	@OneToMany(mappedBy = "categoria", cascade = CascadeType.REFRESH)
		
	 private List<Corso> corsi = new ArrayList<>();

	public List<Corso> getCorsi() {
		return corsi;
	}


	
	

}
