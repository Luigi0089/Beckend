package it.corso.service;

import java.security.Key;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import it.corso.dao.RuoloDao;
import it.corso.dao.UtenteDao;
import it.corso.dto.UtenteLoginResponseDto;
import it.corso.dto.UtenteRegistrazioneDto;
import it.corso.dto.UtenteUpdateDto;
import it.corso.dto.UtenteUpdatePasswordDto;
import it.corso.model.Ruolo;
import it.corso.model.Utente;
import it.corso.service.dto.UtenteLoginRequestDto;

@Service
public class UtenteServiceImpl implements UtenteService {

	@Autowired
	private UtenteDao utenteDao;
	
	@Autowired
	private RuoloDao ruoloDao;
	
	@Override
	public void UtenteRegistrazione(UtenteRegistrazioneDto utente) {
		System.out.println(utente.getNome()+" "+utente.getEmail()+" "+utente.getPassword());
		// hashing sha-256
		String sha256hex=DigestUtils.sha256Hex(utente.getPassword());
			//settiamo la password ashata
			utente.setPassword(sha256hex);
			
			Utente utente_nuovo=new Utente();
			utente_nuovo.setNome(utente.getNome());
			utente_nuovo.setCognome(utente.getCognome());
			utente_nuovo.setEmail(utente.getEmail());
			utente_nuovo.setPassword(utente.getPassword());
			utenteDao.save(utente_nuovo);
	}

	@Override
	public Utente getUtenteById(int id) {
	Optional<Utente> utenteOptionalDb= utenteDao.findById(id);
		
		if(!utenteOptionalDb.isPresent()) {
			return new Utente();
	}
		
		return utenteOptionalDb.get();
	}

	@Override
	public void updateUtenteData(UtenteUpdateDto utente) {
		Utente utente1=new Utente();
		utente1.setEmail(utente.getEmail());
		Utente utenteDb= utenteDao.findByEmail(utente1.getEmail());
		
		if(utenteDb!=null) {
			
			
			utenteDb.setNome(utente.getNome());
			utenteDb.setCognome(utente.getCognome());
			utenteDb.setEmail(utente.getEmail());
			//utenteDb.setRuoli(utente.getRuoli());
			
			List<Ruolo> ruoliUtente = new ArrayList<>();
	        Optional<Ruolo> ruoloDb = ruoloDao.findById(utente.getRuoloId());
	        
	        if(ruoloDb.isPresent()) {
	          Ruolo ruolo = ruoloDb.get();
	          
	          ruolo.setId(utente.getRuoloId());
	          
	          ruoliUtente.add(ruolo);
	          utenteDb.setRuoli(ruoliUtente);
			utenteDao.save(utenteDb);
		}
		// TODO Auto-generated method stub
		
	}
	}
	
	@Override
	public Utente getUtenteByEmail(String email) {
		
		return utenteDao.findByEmail(email);
	}

	@Override
	public List<Utente> getUtenti() {


		return (List<Utente>) utenteDao.findAll();
	}

	@Override
	public void deleteUtente(String email) {
		Utente utente=getUtenteByEmail(email);
		
		
				utenteDao.delete(utente);	
					
				
		
	}

	@Override
	public boolean existUtenteByEmail(String email) {
		return utenteDao.existsByEmail(email);
		
	}
	
	@Override
	public UtenteLoginResponseDto issueToken( String email) {
	    System.out.println("primo");
			
			byte[] secret= "luigi11111111111111111111111111111111111111111".getBytes();
			Key key= Keys.hmacShaKeyFor(secret);
			
			Utente InformazioniUtente=utenteDao.findByEmail(email);

		    if (InformazioniUtente == null) {
		   
		        throw new IllegalArgumentException("Utente non trovato");
		    }
			Map<String, Object> map= new HashMap<>();
			
			map.put("nome", "InformazioniUtente.getNome()");
			map.put("cognome", "InformazioniUtente.getCognome()");
			map.put("email", "InformazioniUtentee.getEmail");
			
			
			UtenteLoginResponseDto token=new UtenteLoginResponseDto();
			List<String> ruoli=new ArrayList<>();
			List<Ruolo> forech=InformazioniUtente.getRuoli();
			for(Ruolo ruolo : forech ) {
				
			
				ruoli.add(ruolo.getTipologia().name());
				if(ruolo.getTipologia().name()=="Admin") {
					token.setRuolo(1);
				}
			}
			  
			
			map.put("ruoli", ruoli);
			Date creation= new Date();
			Date end = java.sql.Timestamp.valueOf(LocalDateTime.now().plusMinutes(15L));
			
			String tokenJwts =Jwts.builder()
					.setClaims(map)
					.setIssuer("http://localhost:8080")
					.setExpiration(end)
					.signWith(key)
					.compact();
			
			
			token.setToken(tokenJwts);
			token.setTokenCreationTime(creation);
			token.setTtl(end);
			
			return token;
			
		}
	
	@Override
	public boolean Login(UtenteLoginRequestDto utenteLoginRequestDto) {
		
		String password = DigestUtils.sha256Hex(utenteLoginRequestDto.getPassword());
		
		Utente utente = utenteDao.findByEmailAndPassword(utenteLoginRequestDto.getEmail(), password);
		
		
		
		return utente!=null?true:false;
	}

	@Override
	public boolean updateUtentePassword(UtenteUpdatePasswordDto utente) {
		System.out.println("sono nel metodo "+ utente.getEmail()+" "+ utente.getPassword()+ " "+ utente.getVecchiaPassword());
		Utente utente1=new Utente();
		utente1.setEmail(utente.getEmail());
		utente1.setPassword(DigestUtils.sha256Hex(utente.getVecchiaPassword()));
		Utente utenteDb= utenteDao.findByEmailAndPassword(utente1.getEmail(),utente1.getPassword());
		if(utenteDb!=null) {
			
			utenteDb.setPassword(DigestUtils.sha256Hex(utente.getPassword()));
			utenteDao.save(utenteDb);
			return true;
		}
		return false;
		
	}
		

	

}
