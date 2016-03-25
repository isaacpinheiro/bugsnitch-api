package br.ufabc.bugsnitch.resource;

import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.PathParam;

import br.ufabc.bugsnitch.dao.UsuarioProjetoDAO;
import br.ufabc.bugsnitch.model.UsuarioProjeto;

@Path("usuarioprojeto")
public class UsuarioProjetoResource {
	
	private UsuarioProjetoDAO uDAO = null;
	
	public UsuarioProjetoResource(){
		this.uDAO = new UsuarioProjetoDAO();
	}
	
	@GET
	@Path("{id}")
	@Produces("application/json")
	public UsuarioProjeto listOne(@PathParam("id") String id){
		UsuarioProjeto usuarioProjeto = uDAO.find(Long.parseLong(id));
		return usuarioProjeto;
	}
	
	@GET
	@Produces("application/json")
	public List<UsuarioProjeto> listAll(){
		List<UsuarioProjeto> usuariosProjetos = uDAO.findAll();
		return usuariosProjetos;
	}
	
	@POST
	@Consumes("application/json")
	public void insert(UsuarioProjeto usuarioProjeto){
		uDAO.save(usuarioProjeto);
	}
	
	@DELETE
	@Path("{id}")
	public void delete(@PathParam("id") String id){
		UsuarioProjeto usuarioProjeto = uDAO.find(Long.parseLong(id));
		uDAO.delete(usuarioProjeto);
	}
	
}
