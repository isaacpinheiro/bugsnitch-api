package br.ufabc.bugsnitch.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "projeto")
public class Projeto implements Serializable {
	
	public static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_projeto", nullable = false)
	private Long id;
	
	@Column(name = "descricao", nullable = false)
	private String descricao;
	
	@Column(name = "area", nullable = false)
	private String area;
	
	@Column(name = "status", nullable = false)
	private String status;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_inicio", nullable = false)
	private Date dataInicio;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_fim", nullable = true)
	private Date dataFim;
	
	public Projeto(){
		
	}
	
	public void setId(Long id){
		this.id = id;
	}
	
	public Long getId(){
		return this.id;
	}
	
	public void setDescricao(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao(){
		return this.descricao;
	}
	
	public void setArea(String area){
		this.area = area;
	}
	
	public String getArea(){
		return this.area;
	}
	
	public void setStatus(String status){
		this.status = status;
	}
	
	public String getStatus(){
		return this.status;
	}
	
	public void setDataInicio(Date dataInicio){
		this.dataInicio = dataInicio;
	}
	
	public Date getDataInicio(){
		return this.dataInicio;
	}
	
	public void setDataFim(Date dataFim){
		this.dataFim = dataFim;
	}
	
	public Date getDataFim(){
		return this.dataFim;
	}
	
}
