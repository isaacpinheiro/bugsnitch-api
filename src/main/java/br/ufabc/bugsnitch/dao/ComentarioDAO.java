package br.ufabc.bugsnitch.dao;

import java.util.List;
import javax.persistence.EntityManager;

import br.ufabc.bugsnitch.util.EntityManagerUtil;
import br.ufabc.bugsnitch.model.Comentario;

public class ComentarioDAO {
	
	private EntityManager em;
	
	public ComentarioDAO(){
		this.em = EntityManagerUtil.getEntityManager();
	}
	
	public Comentario find(Long id){
		
		Comentario obj = null;
		
		try{
			
			obj = em.find(Comentario.class, id);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return obj;
		
	}
	
	public void save(Comentario obj){
		
		try{
			
			em.getTransaction().begin();
			em.merge(obj);
			em.getTransaction().commit();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void delete(Comentario obj){
		
		try{
			
			em.getTransaction().begin();
			em.remove(obj);
			em.getTransaction().commit();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Comentario> findAll(){
		
		List<Comentario> obj = null;
		
		try{
			
			obj = em.createQuery("select t from Comentario t").getResultList();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return obj;
		
	}
	
}
