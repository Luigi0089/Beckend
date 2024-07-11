package it.corso.controller;

import java.security.Key;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import it.corso.dto.UtenteLoginResponseDto;
import it.corso.dto.UtenteRegistrazioneDto;
import it.corso.dto.UtenteUpdateDto;
import it.corso.dto.UtenteUpdatePasswordDto;
import it.corso.model.Ruolo;
import it.corso.model.Utente;
import it.corso.service.UtenteService;
import it.corso.service.dto.UtenteLoginRequestDto;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/utente")
public class UtenteController {

	@Autowired
	private UtenteService utenteService;
	
	@POST
	 @Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response login (@RequestBody UtenteLoginRequestDto utenteLoginRequestDto) {
		  
	    try {
	    	
	    	if (utenteService.Login(utenteLoginRequestDto)) {
	        return Response.ok(utenteService.issueToken(utenteLoginRequestDto.getEmail())).build();
	      }
	
	    } catch (Exception e) {e.printStackTrace();  // Log dello stack trace per debug
        return Response.status(Response.Status.BAD_REQUEST)
                .entity("Errore nel processare la richiesta: " + e.getMessage())
                .build();}
	
	    	return Response.status (Response.Status. BAD_REQUEST).build();
	  	}
	
	@POST
	@Path("/reg")
	@Consumes(MediaType.APPLICATION_JSON) //quando passiamo dati
	public Response utenteRegistrazione(@Valid @RequestBody UtenteRegistrazioneDto utente) {
		
		try {
			System.out.println("\n\n sono nel controlloer\n\n");
			if(!Pattern.matches("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,20}",utente.getPassword())) {
				
				return Response.status(Response.Status.BAD_REQUEST).build();
			}
			// se esiste da errore
			if(utenteService.existUtenteByEmail(utente.getEmail())) {
				return Response.status(Response.Status.BAD_REQUEST).build();
			}
			// altrimenti lo crea
			utenteService.UtenteRegistrazione(utente);
			return Response.status(Response.Status.OK).build();
			
		}catch(Exception e) {
			System.out.println("siamo nel catch");
			return Response.status(Response.Status.BAD_REQUEST).build();
			
		}
	}
	
	
	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserById(@PathParam("id") int id) {
		try {
			Utente utente= utenteService.getUtenteById(id);
			return Response.status(Response.Status.OK).entity(utente).build();
			
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).build();
			}
	}
	
	@GET
	@Path("/get/all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUtenti() {
		try {
			List<Utente> utentiList=utenteService.getUtenti();
			return Response.status(Response.Status.OK).entity(utentiList).build();
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).build();
			}
	}
	
	@PUT
	@Path("/update")
	public Response updateUtente(@RequestBody UtenteUpdateDto utente) {
		try {
			utenteService.updateUtenteData(utente);
			return Response.status(Response.Status.OK).build();
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).build();
			}
	}
	
	
	@PUT
	@Path("/password")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updatePasswordUtente(@Valid @RequestBody UtenteUpdatePasswordDto utente) {
		try {
			if(utenteService.updateUtentePassword(utente))
			{
				
			return Response.status(Response.Status.OK).build();
			}
			else
				return Response.status(Response.Status.BAD_REQUEST).build();
			
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).build();
			}
	}
	
	@DELETE
	@Path("/delete/{email}")
	public Response deletUtente(@PathParam("email") String email) {
		
		try {
			
			utenteService.deleteUtente(email);
			return Response.status(Response.Status.OK).build();
			
			
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).build();
			
		}
	}
}
