package com.api.projeto.integrador.models;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CONTROLE_DE_GADO")
public class ControleDeGado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@Column(name = "numero_produtor")
	private int numeroProdutor;

	@Column(name = "cpf_produtor")
	private String cpfProdutor;
	
	@Column(name = "numero_propriedade")
	private String numeroPropriedade;

	@Column(name = "numero_identificacao")
	private String numeroIdentificacao;

	@Column(name = "nome_animal")
	private String nomeAnimal;

	@Column(name = "data_nascimento")
	private Date dataNascimento;

	@Column
	private String sexo;

	@Column
	private double peso;

	// Construtor vazio
	public ControleDeGado() {
	}

	// Construtor com campos
	public ControleDeGado(int numeroProdutor, String cpfProdutor, String numeroIdentificacao, String nomeAnimal,
			Date dataNascimento, String sexo, double peso) {
		this.numeroProdutor = numeroProdutor;
		this.cpfProdutor = cpfProdutor;
		this.numeroIdentificacao = numeroIdentificacao;
		this.nomeAnimal = nomeAnimal;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.peso = peso;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public int getNumeroProdutor() {
		return numeroProdutor;
	}

	public void setNumeroProdutor(int numeroProdutor) {
		this.numeroProdutor = numeroProdutor;
	}

	public String getCpfProdutor() {
		return cpfProdutor;
	}

	public void setCpfProdutor(String cpfProdutor) {
		this.cpfProdutor = cpfProdutor;
	}
	
	public String getNumeroPropriedade() {
		return numeroPropriedade;
	}

	public void setNumeroPropriedade(String numeroPropriedade) {
		this.numeroPropriedade = numeroPropriedade;
	}

	public String getNumeroIdentificacao() {
		return numeroIdentificacao;
	}

	public void setNumeroIdentificacao(String numeroIdentificacao) {
		this.numeroIdentificacao = numeroIdentificacao;
	}

	public String getNomeAnimal() {
		return nomeAnimal;
	}

	public void setNomeAnimal(String nomeAnimal) {
		this.nomeAnimal = nomeAnimal;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
	    return id + "," + nomeAnimal + "," + dataNascimento + "," + peso;
	}


}

