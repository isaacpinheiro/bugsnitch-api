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
@Table(name = "registro")
public class Registro implements Serializable {
	
	public static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_registro", nullable = false)
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_hora", nullable = false)
	private Date dataHora;
	
	@Column(name = "resumo", nullable = false)
	private String resumo;
	
	@Column(name = "prioridade", nullable = false)
	private String prioridade;
	
	@Column(name = "severidade", nullable = false)
	private String severidade;
	
	@Column(name = "status", nullable = false)
	private Boolean status;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario_projeto", referencedColumnName = "id_usuario_projeto")
	private UsuarioProjeto usuarioProjeto;
	
	public Registro(){
		
	}
	
	public void setId(Long id){
		this.id = id;
	}
	
	public Long getId(){
		return this.id;
	}
	
	public void setDataHora(Date dataHora){
		this.dataHora = dataHora;
	}
	
	public Date getDataHora(){
		return this.dataHora;
	}
	
	public void setResumo(String resumo){
		this.resumo = resumo;
	}
	
	public String getResumo(){
		return this.resumo;
	}
	
	public void setPrioridade(String prioridade){
		this.prioridade = prioridade;
	}
	
	public String getPrioridade(){
		return this.prioridade;
	}
	
	public void setSeveridade(String severidade){
		this.severidade = severidade;
	}
	
	public String getSeveridade(){
		return this.severidade;
	}
	
	public void setStatus(Boolean status){
		this.status = status;
	}
	
	public Boolean getStatus(){
		return this.status;
	}
	
	public void setUsuarioProjeto(UsuarioProjeto usuarioProjeto){
		this.usuarioProjeto = usuarioProjeto;
	}
	
	public UsuarioProjeto getUsuarioProjeto(){
		return this.usuarioProjeto;
	}
	
}
