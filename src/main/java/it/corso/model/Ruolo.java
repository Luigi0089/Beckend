package it.corso.model;

import java.util.ArrayList;
import java.util.List;

import it.corso.enums.Tipologia;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="ruolo")
public class Ruolo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_G")
	private int id;

	 @Enumerated(EnumType.STRING)
	@Column(name="TIPOLOGIA")
	 private Tipologia tipologia;
	

	@ManyToMany(mappedBy = "ruoli", cascade = CascadeType.REFRESH)
	private List<Utente> utenti = new ArrayList();

	

	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public Tipologia getTipologia() {
		return tipologia;
	}



	public void setTipologia(Tipologia tipologia) {
		this.tipologia = tipologia;
	}


}
