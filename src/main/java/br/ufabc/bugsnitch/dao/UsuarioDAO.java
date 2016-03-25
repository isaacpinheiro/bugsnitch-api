package br.ufabc.bugsnitch.dao;

import java.util.List;
import javax.persistence.EntityManager;

import br.ufabc.bugsnitch.util.EntityManagerUtil;
import br.ufabc.bugsnitch.model.Usuario;

public class UsuarioDAO {
	
	private EntityManager em;
	
	public UsuarioDAO(){
		this.em = EntityManagerUtil.getEntityManager();
	}
	
	public Usuario find(Long id){
		
		Usuario obj = null;
		
		try{
			
			em.getTransaction().begin();
			obj = em.find(Usuario.class, id);
			em.getTransaction().commit();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return obj;
		
	}
	
	public void save(Usuario obj){
		
		try{
			
			em.getTransaction().begin();
			em.merge(obj);
			em.getTransaction().commit();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void delete(Usuario obj){
		
		try{
			
			em.getTransaction().begin();
			em.remove(obj);
			em.getTransaction().commit();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> findAll(){
		
		List<Usuario> obj = null;
		
		try{
			
			obj = em.createQuery("select t from Usuario t").getResultList();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return obj;
		
	}
	
}
