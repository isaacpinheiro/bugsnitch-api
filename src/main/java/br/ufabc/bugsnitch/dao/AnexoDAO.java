package br.ufabc.bugsnitch.dao;

import java.util.List;
import javax.persistence.EntityManager;

import br.ufabc.bugsnitch.util.EntityManagerUtil;
import br.ufabc.bugsnitch.model.Anexo;

public class AnexoDAO {
	
	private EntityManager em;
	
	public AnexoDAO(){
		this.em = EntityManagerUtil.getEntityManager();
	}
	
	public Anexo find(Long id){
		
		Anexo obj = null;
		
		try{
			
			obj = em.find(Anexo.class, id);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return obj;
		
	}
	
	public void save(Anexo obj){
		
		try{
			
			em.getTransaction().begin();
			em.merge(obj);
			em.getTransaction().commit();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void delete(Anexo obj){
		
		try{
			
			em.getTransaction().begin();
			em.remove(obj);
			em.getTransaction().commit();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Anexo> findAll(){
		
		List<Anexo> obj = null;
		
		try{
			
			obj = em.createQuery("select t from Anexo t").getResultList();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return obj;
		
	}
	
}
