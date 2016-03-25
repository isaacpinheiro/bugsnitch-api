package br.ufabc.bugsnitch.dao;

import java.util.List;
import javax.persistence.EntityManager;

import br.ufabc.bugsnitch.util.EntityManagerUtil;
import br.ufabc.bugsnitch.model.UsuarioProjeto;

public class UsuarioProjetoDAO {
	
	private EntityManager em;
	
	public UsuarioProjetoDAO(){
		this.em = EntityManagerUtil.getEntityManager();
	}
	
	public UsuarioProjeto find(Long id){
		
		UsuarioProjeto obj = null;
		
		try{
			
			obj = em.find(UsuarioProjeto.class, id);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return obj;
		
	}
	
	public void save(UsuarioProjeto obj){
		
		try{
			
			em.getTransaction().begin();
			em.merge(obj);
			em.getTransaction().commit();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void delete(UsuarioProjeto obj){
		
		try{
			
			em.getTransaction().begin();
			em.remove(obj);
			em.getTransaction().commit();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<UsuarioProjeto> findAll(){
		
		List<UsuarioProjeto> obj = null;
		
		try{
			
			obj = em.createQuery("select t from UsuarioProjeto t").getResultList();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return obj;
		
	}
	
}
