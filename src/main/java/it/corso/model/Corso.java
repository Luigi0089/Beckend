package it.corso.model;

import java.util.ArrayList;
import java.util.List;

import it.corso.enums.NomeCategoria;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="corso")
public class Corso {
	
		  
		 @Id 
		 @GeneratedValue(strategy = GenerationType.IDENTITY) 
		 @Column(name = "ID_C") 
		 private int id; 
		  
		 @Column(name = "Nome_Corso") 
		 private String nome; 
		  
		 @Column(name = "Descrizione_breve") 
		 private String descrizioneBreve; 
		  
		 @Column(name = "Descrizione_completa") 
		 private String DescrizioneCompleta; 
		  
		 @Column(name = "Durata") 
		 private int durata; 
		  
		 @ManyToOne(cascade = CascadeType.REFRESH) 
		 @JoinColumn(name = "FK_CA", referencedColumnName = "ID_CA") 
		 private Categoria categoria; 
		  
		 @ManyToMany(mappedBy = "corsi", cascade = CascadeType.REFRESH)
		 private List<Utente> utenti = new ArrayList<>();

		 public int getId() {
				return id;
			}

			public void setId(int id) {
				this.id = id;
			}
		 
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
				return DescrizioneCompleta;
			}

			public void setDescrizioneCompleta(String descrizioneCompleta) {
				DescrizioneCompleta = descrizioneCompleta;
			}

			public Categoria getCategoria() {
				return categoria;
			}

			public void setCategoria(Categoria categoria) {
				this.categoria = categoria;
			}

			public List<Utente> getUtenti() {
				return utenti;
			}

			public void setUtenti(List<Utente> utenti) {
				this.utenti = utenti;
			}

			public int getDurata() {
				return durata;
			}

			public void setDurata(int durata) {
				this.durata = durata;
			}

			public void setCategoria(int id, NomeCategoria nomegatoria) {
				categoria.setId(id);
				categoria.setNomeCategoria(nomegatoria);
			}
			
}
