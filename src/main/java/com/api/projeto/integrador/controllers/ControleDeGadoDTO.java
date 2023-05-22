package com.api.projeto.integrador.controllers;

import java.sql.Date;

public class ControleDeGadoDTO {
	
	    private String numeroIdentificacao;
	    private int numeroProdutor;
	    private Date dataNascimento;
	    // Outros campos, se necessário
	    
		public String getNumeroIdentificacao() {
			return numeroIdentificacao;
		}
		public void setNumeroIdentificacao(String numeroIdentificacao) {
			this.numeroIdentificacao = numeroIdentificacao;
		}
		public int getNumeroProdutor() {
			return numeroProdutor;
		}
		public void setNumeroProdutor(int numeroProdutor) {
			this.numeroProdutor = numeroProdutor;
		}
		public Date getDataNascimento() {
			return dataNascimento;
		}
		public void setDataNascimento(Date dataNascimento) {
			this.dataNascimento = dataNascimento;
		}

	    // Construtores, getters e setters

	    // Métodos adicionais, se necessário
	}


