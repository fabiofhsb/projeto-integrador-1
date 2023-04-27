package com.api.projeto.integrador.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
}