package br.ufabc.bugsnitch.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "comentario")
public class Comentario implements Serializable {
	
	public static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_comentario", nullable = false)
	private Long id;
	
	@Column(name = "texto_comentario", nullable = false)
	private String textoComentario;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_hora", nullable = false)
	private Date dataHora;
	
	@ManyToOne
	@JoinColumn(name = "id_registro", referencedColumnName = "id_registro")
	private Registro registro;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario_projeto", referencedColumnName = "id_usuario_projeto")
	private UsuarioProjeto usuarioProjeto;
	
	public Comentario(){
		
	}
	
	public void setId(Long id){
		this.id = id;
	}
	
	public Long getId(){
		return this.id;
	}
	
	public void setTextoComentario(String textoComentario){
		this.textoComentario = textoComentario;
	}
	
	public String getTextoComentario(){
		return this.textoComentario;
	}
	
	public void setDataHora(Date dataHora){
		this.dataHora = dataHora;
	}
	
	public Date getDataHora(){
		return this.dataHora;
	}
	
	public void setRegistro(Registro registro){
		this.registro = registro;
	}
	
	public Registro getRegistro(){
		return this.registro;
	}
	
	public void setUsuarioProjeto(UsuarioProjeto usuarioProjeto){
		this.usuarioProjeto = usuarioProjeto;
	}
	
	public UsuarioProjeto getUsuarioProjeto(){
		return this.usuarioProjeto;
	}
	
}
