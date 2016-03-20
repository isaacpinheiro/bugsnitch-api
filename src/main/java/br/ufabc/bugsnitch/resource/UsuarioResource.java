package br.ufabc.bugsnitch.resource;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

@Path("/usuario")
public class UsuarioResource {
	
	@GET
	@Produces("application/json")
	public String oi(){
		return "{msg:\"Oi\"}";
	}
	
}
