package br.com.oab.model;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	private String municipio;

	private String cpfcnpj;

	private String nomePai;

	private String nomeMae;

	private String registroConselhoAtual;

	private Long createdBy;

	private Date createdOn;

	private Long updatedBy;

	private Date updatedOn;

	private Long updatedByInterface;

	private Date updatedOnInterface;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getCpfcnpj() {
		return cpfcnpj;
	}

	public void setCpfcnpj(String cpfcnpj) {
		this.cpfcnpj = cpfcnpj;
	}

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getRegistroConselhoAtual() {
		return registroConselhoAtual;
	}

	public void setRegistroConselhoAtual(String registroConselhoAtual) {
		this.registroConselhoAtual = registroConselhoAtual;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Long getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public Long getUpdatedByInterface() {
		return updatedByInterface;
	}

	public void setUpdatedByInterface(Long updatedByInterface) {
		this.updatedByInterface = updatedByInterface;
	}

	public Date getUpdatedOnInterface() {
		return updatedOnInterface;
	}

	public void setUpdatedOnInterface(Date updatedOnInterface) {
		this.updatedOnInterface = updatedOnInterface;
	}

	@Override
	public String toString() {
		return "Pessoa {id=" + id + ", "
				+ "nome=" + nome + ", "
				+ "municipio=" + municipio + ", "
				+ "cpfcnpj=" + cpfcnpj
				+ ", nomePai=" + nomePai + ", "
				+ "nomeMae=" + nomeMae + ", registroConselhoAtual=" + registroConselhoAtual
				+ ", createdBy=" + createdBy + ", createdOn=" + createdOn + ", updatedBy=" + 
				updatedBy + ", updatedOn="
				+ updatedOn + ", updatedByInterface=" + updatedByInterface + ", "
				+ "updatedOnInterface="
				+ updatedOnInterface + "}";
	}
	
}
