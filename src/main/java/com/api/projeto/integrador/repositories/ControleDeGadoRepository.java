package com.api.projeto.integrador.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.projeto.integrador.models.ControleDeGado;

public interface ControleDeGadoRepository extends JpaRepository<ControleDeGado, String> {

	List<ControleDeGado> findByNumeroProdutor(int numeroProdutor);

	List<ControleDeGado> findByDataNascimentoBefore(Date dataNascimento);
	
	List<ControleDeGado> findByNumeroIdentificacao(String numeroIdentificacao);
}
