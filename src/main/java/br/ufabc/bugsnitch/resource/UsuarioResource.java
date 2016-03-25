package br.ufabc.bugsnitch.resource;

import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.PathParam;

import br.ufabc.bugsnitch.dao.UsuarioDAO;
import br.ufabc.bugsnitch.model.Usuario;

@Path("usuario")
public class UsuarioResource {
	
	private UsuarioDAO uDAO = null;
	
	public UsuarioResource(){
		this.uDAO = new UsuarioDAO();
	}
	
	@GET
	@Path("{id}")
	@Produces("application/json")
	public Usuario listOne(@PathParam("id") String id){
		Usuario usuario = uDAO.find(Long.parseLong(id));
		return usuario;
	}
	
	@GET
	@Produces("application/json")
	public List<Usuario> listAll(){
		List<Usuario> usuarios = uDAO.findAll();
		return usuarios;
	}
	
	@POST
	@Consumes("application/json")
	public void insert(Usuario usuario){
		uDAO.save(usuario);
	}
	
	@DELETE
	@Path("{id}")
	public void delete(@PathParam("id") String id){
		Usuario usuario = uDAO.find(Long.parseLong(id));
		uDAO.delete(usuario);
	}
	
}
