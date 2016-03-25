package br.ufabc.bugsnitch.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "usuario_projeto")
public class UsuarioProjeto implements Serializable {
	
	public static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_usuario_projeto", nullable = false)
	private Long id;
	
	@Column(name = "status", nullable = false)
	private Boolean status;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "id_projeto", referencedColumnName = "id_projeto")
	private Projeto projeto;
	
	public UsuarioProjeto(){
		
	}
	
	public void setId(Long id){
		this.id = id;
	}
	
	public Long getId(){
		return this.id;
	}
	
	public void setStatus(Boolean status){
		this.status = status;
	}
	
	public Boolean getStatus(){
		return this.status;
	}
	
	public void setUsuario(Usuario usuario){
		this.usuario = usuario;
	}
	
	public Usuario getUsuario(){
		return this.usuario;
	}
	
	public void setProjeto(Projeto projeto){
		this.projeto = projeto;
	}
	
	public Projeto getProjeto(){
		return this.projeto;
	}
	
}
