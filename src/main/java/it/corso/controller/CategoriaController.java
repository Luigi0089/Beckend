package it.corso.controller;

import java.util.List;
import it.corso.service.*;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import it.corso.dto.CategoriaDto;
import it.corso.service.CategoriaService;
import it.corso.service.UnauthorizedException;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllCategorie() {
		
		try {
			List<CategoriaDto> categorieDto=categoriaService.getAllCategorie();
		
			return Response.status(Response.Status.OK).entity(categorieDto).build();
		
		} catch (Exception e) { 
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}
	
	
	@DELETE
	@Path("/{id}")
	public Response deleteCategorie(@PathParam("id") int id) {
		
		
			
				try {
					categoriaService.deleteCategoria(id);
					
					return Response.status(Response.Status.OK).build();
					
				} catch (it.corso.service.ObjectNotFoundException e) {
					
					return Response.status(Response.Status.NOT_FOUND).build();
				}catch(UnauthorizedException e) {
					
					return Response.status(Response.Status.FORBIDDEN).build();
					}
		
	}
}
	
	


