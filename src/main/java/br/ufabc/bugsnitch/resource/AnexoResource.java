package br.ufabc.bugsnitch.resource;

import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.PathParam;

import br.ufabc.bugsnitch.dao.AnexoDAO;
import br.ufabc.bugsnitch.model.Anexo;

@Path("anexo")
public class AnexoResource {
	
	private AnexoDAO aDAO = null;
	
	public AnexoResource(){
		this.aDAO = new AnexoDAO();
	}
	
	@GET
	@Path("{id}")
	@Produces("application/json")
	public Anexo listOne(@PathParam("id") String id){
		Anexo anexo = aDAO.find(Long.parseLong(id));
		return anexo;
	}
	
	@GET
	@Produces("application/json")
	public List<Anexo> listAll(){
		List<Anexo> anexos = aDAO.findAll();
		return anexos;
	}
	
	@POST
	@Consumes("application/json")
	public void insert(Anexo anexo){
		aDAO.save(anexo);
	}
	
	@DELETE
	@Path("{id}")
	public void delete(@PathParam("id") String id){
		Anexo anexo = aDAO.find(Long.parseLong(id));
		aDAO.delete(anexo);
	}
	
}
