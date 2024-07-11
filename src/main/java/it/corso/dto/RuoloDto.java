package it.corso.dto;

import it.corso.enums.Tipologia;

public class RuoloDto {
	
	private int id;
	
	private Tipologia tipologia;

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
