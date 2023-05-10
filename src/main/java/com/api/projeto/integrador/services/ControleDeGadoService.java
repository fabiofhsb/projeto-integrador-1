package com.api.projeto.integrador.services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.api.projeto.integrador.models.ControleDeGado;
import com.api.projeto.integrador.repositories.ControleDeGadoRepository;

@Service
public class ControleDeGadoService {

    @Autowired
    private ControleDeGadoRepository controleDeGadoRepository;

    public ControleDeGado salvar(ControleDeGado controleDeGado) {
        return controleDeGadoRepository.save(controleDeGado);
    }

    public List<ControleDeGado> buscarPorNumeroProdutor(int numeroProdutor) {
        return controleDeGadoRepository.findByNumeroProdutor(numeroProdutor);
    }

    public String formatDate(Date data) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(data);
    }

    public int calcularCabeçasDisponiveis(Date data) {
        List<ControleDeGado> gadoAtingido = controleDeGadoRepository.findByDataNascimentoBefore(data);
        int cabeçasDisponiveis = 0;
        for (ControleDeGado controleDeGado : gadoAtingido) {
            long diferenca = data.getTime() - controleDeGado.getDataNascimento().getTime();
            int anos = (int) (diferenca / (1000 * 60 * 60 * 24 * 365.25));
            if (anos >= 3.5) {
                cabeçasDisponiveis++;
            }
        }
        return cabeçasDisponiveis;
    }
    
    public int calcularVitelos(Date data) {
        List<ControleDeGado> gadoAtingido = controleDeGadoRepository.findByDataNascimentoBefore(data);
        int vitelosDisponiveis = 0;
        for (ControleDeGado controleDeGado : gadoAtingido) {
            long diferenca = data.getTime() - controleDeGado.getDataNascimento().getTime();
            int anos = (int) (diferenca / (1000 * 60 * 60 * 24 * 365.25));
            if (anos >= 1) {
            	vitelosDisponiveis++;
            }
        }
        return vitelosDisponiveis;
    }
    
    public Page<ControleDeGado> listarCabeçasDeGadoPaginado(int pagina, int tamanhoPagina) {
        Pageable paginacao = PageRequest.of(pagina, tamanhoPagina);
        return controleDeGadoRepository.findAll(paginacao);
    }

    }

