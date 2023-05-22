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
    
    public List<ControleDeGado> buscarPorNumeroIdentificacao(String numeroIdentificacao) {
        return controleDeGadoRepository.findByNumeroIdentificacao(numeroIdentificacao);
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
            double anos = (double) (diferenca / (1000 * 60 * 60 * 24 * 365.25));
            if (anos >= 2.5) {
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
            int meses = (int) (diferenca / (1000 * 60 * 60 * 24 * 30.44));
            if (meses < 10) {
            	vitelosDisponiveis++;
            }
        }
        return vitelosDisponiveis;
    }
    
    public int calcularNovilhosSuperPrecoce(Date data) {
        List<ControleDeGado> gadoAtingido = controleDeGadoRepository.findByDataNascimentoBefore(data);
        int NovilhosSuperPrecoceDisponiveis = 0;
        for (ControleDeGado controleDeGado : gadoAtingido) {
            long diferenca = data.getTime() - controleDeGado.getDataNascimento().getTime();
            int meses = (int) (diferenca / (1000 * 60 * 60 * 24 * 30.44));
            if (meses >= 10 && meses < 15) {
            	NovilhosSuperPrecoceDisponiveis++;
            }
        }
        return NovilhosSuperPrecoceDisponiveis;
    }
    
    public int calcularNovilhosPrecoce(Date data) {
        List<ControleDeGado> gadoAtingido = controleDeGadoRepository.findByDataNascimentoBefore(data);
        int NovilhosPrecoceDisponiveis = 0;
        for (ControleDeGado controleDeGado : gadoAtingido) {
            long diferenca = data.getTime() - controleDeGado.getDataNascimento().getTime();
            int meses = (int) (diferenca / (1000 * 60 * 60 * 24 * 30.44));
            if (meses >= 15 && meses < 24) {
            	NovilhosPrecoceDisponiveis++;
            }
        }
        return NovilhosPrecoceDisponiveis;
    }
    
    public int calcularNovilhos(Date data) {
        List<ControleDeGado> gadoAtingido = controleDeGadoRepository.findByDataNascimentoBefore(data);
        int NovilhosDisponiveis = 0;
        for (ControleDeGado controleDeGado : gadoAtingido) {
            long diferenca = data.getTime() - controleDeGado.getDataNascimento().getTime();
            int meses = (int) (diferenca / (1000 * 60 * 60 * 24 * 30.44));
            if (meses >= 24 && meses < 30) {
            	NovilhosDisponiveis++;
            }
        }
        return NovilhosDisponiveis;
    }
    
    public int calcularBois(Date data) {
        List<ControleDeGado> gadoAtingido = controleDeGadoRepository.findByDataNascimentoBefore(data);
        int boisDisponiveis = 0;
        for (ControleDeGado controleDeGado : gadoAtingido) {
            long diferenca = data.getTime() - controleDeGado.getDataNascimento().getTime();
            int meses = (int) (diferenca / (1000 * 60 * 60 * 24 * 30.44));
            if (meses >= 30 && meses < 60) {
            	boisDisponiveis++;
            }
        }
        return boisDisponiveis;
    }
    
    public int calcularTouros(Date data) {
        List<ControleDeGado> gadoAtingido = controleDeGadoRepository.findByDataNascimentoBefore(data);
        int tourosDisponiveis = 0;
        for (ControleDeGado controleDeGado : gadoAtingido) {
            long diferenca = data.getTime() - controleDeGado.getDataNascimento().getTime();
            int anos = (int) (diferenca / (1000 * 60 * 60 * 24 * 365.25));
            if (anos >= 5 && anos <= 15) {
            	tourosDisponiveis++;
            }
        }
        return tourosDisponiveis;
    }
    
 
    
    public Page<ControleDeGado> listarCabeçasDeGadoPaginado(int pagina, int tamanhoPagina) {
        Pageable paginacao = PageRequest.of(pagina, tamanhoPagina);
        return controleDeGadoRepository.findAll(paginacao);
    }

    }


