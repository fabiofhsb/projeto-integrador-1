package com.api.projeto.integrador.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.projeto.integrador.models.ControleDeGado;
import com.api.projeto.integrador.services.ControleDeGadoService;

@RestController
@RequestMapping("/animal")
public class ControleDeGadoController {

    @Autowired
    private ControleDeGadoService controleDeGadoService;

    @GetMapping
    public ResponseEntity<String> teste() {
    	return ResponseEntity.ok("Teste");
    }
    
    @PostMapping
    public ResponseEntity<ControleDeGado> salvar(@RequestBody ControleDeGado controleDeGado) {
        ControleDeGado controleDeGadoSalvo = controleDeGadoService.salvar(controleDeGado);
        return ResponseEntity.ok(controleDeGadoSalvo);
    }

    @GetMapping("/produtor/{numeroProdutor}")
    public ResponseEntity<List<ControleDeGado>> buscarPorNumeroProdutor(@PathVariable int numeroProdutor) {
        List<ControleDeGado> controleDeGado = controleDeGadoService.buscarPorNumeroProdutor(numeroProdutor);
        return ResponseEntity.ok(controleDeGado);
    }

    @GetMapping("/disponiveis/{data}")
    public ResponseEntity<Integer> calcularCabeçasDisponiveis(@PathVariable @DateTimeFormat(iso = ISO.DATE) Date data) {
        int cabeçasDisponiveis = controleDeGadoService.calcularCabeçasDisponiveis(data);
        return ResponseEntity.ok(cabeçasDisponiveis);
    }

}
