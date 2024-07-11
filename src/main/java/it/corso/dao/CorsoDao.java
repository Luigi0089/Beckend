package it.corso.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.corso.model.Categoria;
import it.corso.model.Corso;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public interface CorsoDao extends CrudRepository<Corso, Integer> {
	
	boolean existsByNomeAndDescrizioneBreve(String nome, String descrizione_breve);
	
	//Corso findByNomeAndDescrizione_breve(String nome, String descrizione_breve);
	
	
	
	

}
