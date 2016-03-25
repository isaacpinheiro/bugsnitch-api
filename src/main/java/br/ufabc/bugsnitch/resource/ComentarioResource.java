package br.ufabc.bugsnitch.resource;

import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.PathParam;

import br.ufabc.bugsnitch.dao.ComentarioDAO;
import br.ufabc.bugsnitch.model.Comentario;

@Path("comentario")
public class ComentarioResource {
	
	private ComentarioDAO cDAO = null;
	
	public ComentarioResource(){
		this.cDAO = new ComentarioDAO();
	}
	
	@GET
	@Path("{id}")
	@Produces("application/json")
	public Comentario listOne(@PathParam("id") String id){
		Comentario comentario = cDAO.find(Long.parseLong(id));
		return comentario;
	}
	
	@GET
	@Produces("application/json")
	public List<Comentario> listAll(){
		List<Comentario> comentarios = cDAO.findAll();
		return comentarios;
	}
	
	@POST
	@Consumes("application/json")
	public void insert(Comentario comentario){
		cDAO.save(comentario);
	}
	
	@DELETE
	@Path("{id}")
	public void delete(@PathParam("id") String id){
		Comentario comentario = cDAO.find(Long.parseLong(id));
		cDAO.delete(comentario);
	}
	
}
