package br.ufabc.bugsnitch.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "anexo")
public class Anexo implements Serializable {
	
	public static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_anexo", nullable = false)
	private Long id;
	
	@Column(name = "arquivo", nullable = false)
	private String arquivo;
	
	@ManyToOne
	@JoinColumn(name = "id_registro", referencedColumnName = "id_registro")
	private Registro registro;
	
	@ManyToOne
	@JoinColumn(name = "id_comentario", referencedColumnName = "id_comentario")
	private Comentario comentario;
	
	public Anexo(){
		
	}
	
	public void setId(Long id){
		this.id = id;
	}
	
	public Long getId(){
		return this.id;
	}
	
	public void setArquivo(String arquivo){
		this.arquivo = arquivo;
	}
	
	public String getArquivo(){
		return this.arquivo;
	}
	
	public void setRegistro(Registro registro){
		this.registro = registro;
	}
	
	public Registro getRegistro(){
		return this.registro;
	}
	
	public void setComentario(Comentario comentario){
		this.comentario = comentario;
	}
	
	public Comentario getComentario(){
		return this.comentario;
	}
	
}
