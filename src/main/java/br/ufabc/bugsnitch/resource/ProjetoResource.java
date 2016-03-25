package br.ufabc.bugsnitch.resource;

import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.PathParam;

import br.ufabc.bugsnitch.dao.ProjetoDAO;
import br.ufabc.bugsnitch.model.Projeto;

@Path("projeto")
public class ProjetoResource {
	
	private ProjetoDAO pDAO = null;
	
	public ProjetoResource(){
		this.pDAO = new ProjetoDAO();
	}
	
	@GET
	@Path("{id}")
	@Produces("application/json")
	public Projeto listOne(@PathParam("id") String id){
		Projeto projeto = pDAO.find(Long.parseLong(id));
		return projeto;
	}
	
	@GET
	@Produces("application/json")
	public List<Projeto> listAll(){
		List<Projeto> projetos = pDAO.findAll();
		return projetos;
	}
	
	@POST
	@Consumes("application/json")
	public void insert(Projeto projeto){
		pDAO.save(projeto);
	}
	
	@DELETE
	@Path("{id}")
	public void delete(@PathParam("id") String id){
		Projeto projeto = pDAO.find(Long.parseLong(id));
		pDAO.delete(projeto);
	}
	
}
