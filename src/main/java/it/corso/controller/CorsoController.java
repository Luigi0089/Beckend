package it.corso.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import it.corso.dto.CorsoCreazioneDto;
import it.corso.dto.CorsoGetDto;
import it.corso.jwt.JWTTokenNeeded;
import it.corso.jwt.Secured;
import it.corso.model.Corso;
import it.corso.model.Utente;
import it.corso.service.CorsoService;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("/corso")
public class CorsoController {
	
	@Autowired 
	CorsoService corsoService;
	
	@POST
	@Secured(role="Admin")
	@JWTTokenNeeded
	@Path("/crea")
	@Consumes(MediaType.APPLICATION_JSON) //quando passiamo dati
	public Response corsoCreazione(@Valid @RequestBody CorsoCreazioneDto corso) {
		
		try {
			
			// se esiste da errore
			if(corsoService.existCosoByNomeAndDescrizione_breve(corso.getNome(), corso.getDescrizioneBreve())) {
				return Response.status(Response.Status.BAD_REQUEST).build();
			}
			// altrimenti lo crea
			corsoService.CorsoCreazione(corso);
			return Response.status(Response.Status.OK).build();
			
		}catch(Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).build();
			
		}
	}
	
	
	@DELETE
	@Secured(role="Admin")
	@JWTTokenNeeded
	@Path("/category/{id}")
	public Response deleteCourseByCategory(@PathParam("id") int id) {
		
		try {

			corsoService.deleteCorso(id);

			return Response.status(Response.Status.OK).build();
			
		} catch(Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}
	
	
	@GET
	@Path("/get/all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUtenti() {
		try {
			List<CorsoGetDto> corsiList=corsoService.getCorsi();
			return Response.status(Response.Status.OK).entity(corsiList).build();
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).build();
			}
	}
	
//	@GET
//	@Path("/get/{id}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response getUtenteById(@PathParam("id") int id) {
//		try {
//			Corso corso=corsoService.getCorsoById(id);
//			return Response.status(Response.Status.OK).entity(utentiList).build();
//		} catch (Exception e) {
//			return Response.status(Response.Status.BAD_REQUEST).build();
//			}
//	}
//	
	

}
