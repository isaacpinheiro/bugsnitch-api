package br.ufabc.bugsnitch.resource;

import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.PathParam;

import br.ufabc.bugsnitch.dao.RegistroDAO;
import br.ufabc.bugsnitch.model.Registro;

@Path("registro")
public class RegistroResource {
	
	private RegistroDAO rDAO = null;
	
	public RegistroResource(){
		this.rDAO = new RegistroDAO();
	}
	
	@GET
	@Path("{id}")
	@Produces("application/json")
	public Registro listOne(@PathParam("id") String id){
		Registro registro = rDAO.find(Long.parseLong(id));
		return registro;
	}
	
	@GET
	@Produces("application/json")
	public List<Registro> listAll(){
		List<Registro> registros = rDAO.findAll();
		return registros;
	}
	
	@POST
	@Consumes("application/json")
	public void insert(Registro registro){
		rDAO.save(registro);
	}
	
	@DELETE
	@Path("{id}")
	public void delete(@PathParam("id") String id){
		Registro registro = rDAO.find(Long.parseLong(id));
		rDAO.delete(registro);
	}
	
}
