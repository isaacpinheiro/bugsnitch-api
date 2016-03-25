package br.ufabc.bugsnitch.dao;

import java.util.List;
import javax.persistence.EntityManager;

import br.ufabc.bugsnitch.util.EntityManagerUtil;
import br.ufabc.bugsnitch.model.Registro;

public class RegistroDAO {
	
	private EntityManager em;
	
	public RegistroDAO(){
		this.em = EntityManagerUtil.getEntityManager();
	}
	
	public Registro find(Long id){
		
		Registro obj = null;
		
		try{
			
			obj = em.find(Registro.class, id);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return obj;
		
	}
	
	public void save(Registro obj){
		
		try{
			
			em.getTransaction().begin();
			em.merge(obj);
			em.getTransaction().commit();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void delete(Registro obj){
		
		try{
			
			em.getTransaction().begin();
			em.remove(obj);
			em.getTransaction().commit();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Registro> findAll(){
		
		List<Registro> obj = null;
		
		try{
			
			obj = em.createQuery("select t from Registro t").getResultList();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return obj;
		
	}
	
}
