package br.ufabc.bugsnitch.dao;

import java.util.List;
import javax.persistence.EntityManager;

import br.ufabc.bugsnitch.util.EntityManagerUtil;
import br.ufabc.bugsnitch.model.Projeto;

public class ProjetoDAO {
	
	private EntityManager em;
	
	public ProjetoDAO(){
		this.em = EntityManagerUtil.getEntityManager();
	}
	
	public Projeto find(Long id){
		
		Projeto obj = null;
		
		try{
			
			obj = em.find(Projeto.class, id);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return obj;
		
	}
	
	public void save(Projeto obj){
		
		try{
			
			em.getTransaction().begin();
			em.merge(obj);
			em.getTransaction().commit();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void delete(Projeto obj){
		
		try{
			
			em.getTransaction().begin();
			em.remove(obj);
			em.getTransaction().commit();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Projeto> findAll(){
		
		List<Projeto> obj = null;
		
		try{
			
			obj = em.createQuery("select t from Projeto t").getResultList();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return obj;
		
	}
	
}
