package com.api.projeto.integrador.controllers;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.projeto.integrador.models.ControleDeGado;
import com.api.projeto.integrador.services.ControleDeGadoService;

@RestController
@RequestMapping("/animal")
public class ControleDeGadoController {

    @Autowired
    private ControleDeGadoService controleDeGadoService;

       
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
    
    public ResponseEntity<Integer> calcularCabeçasDisponiveis(
            @PathVariable @DateTimeFormat(iso = ISO.DATE) Date data,
            @RequestParam(value = "timeZone", defaultValue = "UTC") String timeZoneId) {
        TimeZone timeZone = TimeZone.getTimeZone(timeZoneId);
        Calendar calendar = Calendar.getInstance(timeZone);
        calendar.setTime(data);
        int cabeçasDisponiveis = controleDeGadoService.calcularCabeçasDisponiveis(calendar.getTime());
        return ResponseEntity.ok(cabeçasDisponiveis);
    }
    
    @GetMapping("/vitelos/{data}")
    
    public ResponseEntity<Integer> calcularVitelos(
            @PathVariable @DateTimeFormat(iso = ISO.DATE) Date data,
            @RequestParam(value = "timeZone", defaultValue = "UTC") String timeZoneId) {
        TimeZone timeZone = TimeZone.getTimeZone(timeZoneId);
        Calendar calendar = Calendar.getInstance(timeZone);
        calendar.setTime(data);
        int vitelosDisponiveis = controleDeGadoService.calcularVitelos(calendar.getTime());
        return ResponseEntity.ok(vitelosDisponiveis);
    }
    
@GetMapping("/superPrecoce/{data}")
    
    public ResponseEntity<Integer> calcularNovilhosSuperPrecoce(
            @PathVariable @DateTimeFormat(iso = ISO.DATE) Date data,
            @RequestParam(value = "timeZone", defaultValue = "UTC") String timeZoneId) {
        TimeZone timeZone = TimeZone.getTimeZone(timeZoneId);
        Calendar calendar = Calendar.getInstance(timeZone);
        calendar.setTime(data);
        int NovilhosSuperPrecoceDisponiveis = controleDeGadoService.calcularNovilhosSuperPrecoce(calendar.getTime());
        return ResponseEntity.ok(NovilhosSuperPrecoceDisponiveis);
    }

@GetMapping("/precoce/{data}")

public ResponseEntity<Integer> calcularNovilhosPrecoce(
        @PathVariable @DateTimeFormat(iso = ISO.DATE) Date data,
        @RequestParam(value = "timeZone", defaultValue = "UTC") String timeZoneId) {
    TimeZone timeZone = TimeZone.getTimeZone(timeZoneId);
    Calendar calendar = Calendar.getInstance(timeZone);
    calendar.setTime(data);
    int NovilhosPrecoceDisponiveis = controleDeGadoService.calcularNovilhosPrecoce(calendar.getTime());
    return ResponseEntity.ok(NovilhosPrecoceDisponiveis);
}

@GetMapping("/novilhos/{data}")

public ResponseEntity<Integer> calcularNovilhos(
        @PathVariable @DateTimeFormat(iso = ISO.DATE) Date data,
        @RequestParam(value = "timeZone", defaultValue = "UTC") String timeZoneId) {
    TimeZone timeZone = TimeZone.getTimeZone(timeZoneId);
    Calendar calendar = Calendar.getInstance(timeZone);
    calendar.setTime(data);
    int NovilhosDisponiveis = controleDeGadoService.calcularNovilhos(calendar.getTime());
    return ResponseEntity.ok(NovilhosDisponiveis);
}

@GetMapping("/bois/{data}")

public ResponseEntity<Integer> calcularBois(
        @PathVariable @DateTimeFormat(iso = ISO.DATE) Date data,
        @RequestParam(value = "timeZone", defaultValue = "UTC") String timeZoneId) {
    TimeZone timeZone = TimeZone.getTimeZone(timeZoneId);
    Calendar calendar = Calendar.getInstance(timeZone);
    calendar.setTime(data);
    int boisDisponiveis = controleDeGadoService.calcularBois(calendar.getTime());
    return ResponseEntity.ok(boisDisponiveis);
}

@GetMapping("/touros/{data}")

public ResponseEntity<Integer> calcularTouros(
        @PathVariable @DateTimeFormat(iso = ISO.DATE) Date data,
        @RequestParam(value = "timeZone", defaultValue = "UTC") String timeZoneId) {
    TimeZone timeZone = TimeZone.getTimeZone(timeZoneId);
    Calendar calendar = Calendar.getInstance(timeZone);
    calendar.setTime(data);
    int tourosDisponiveis = controleDeGadoService.calcularTouros(calendar.getTime());
    return ResponseEntity.ok(tourosDisponiveis);
}


       
    @GetMapping("/cabeças-de-gado")
    public Page<ControleDeGado> listarCabeçasDeGadoPaginado(@RequestParam(defaultValue = "0") int page) {
        return controleDeGadoService.listarCabeçasDeGadoPaginado(page, 50);
    }


    @PutMapping("/editar/{data}")
    public ResponseEntity<String> atualizarAnimal(@PathVariable("numeroIdentificacao") String numeroIdentificacao, @RequestBody ControleDeGadoDTO controleDeGadoDTO) {
        try {
            List<ControleDeGado> animais = controleDeGadoService.buscarPorNumeroIdentificacao(numeroIdentificacao);
            if (!animais.isEmpty()) {
                ControleDeGado animal = animais.get(0); // Acessa o primeiro animal da lista
                animal.setNumeroIdentificacao(controleDeGadoDTO.getNumeroIdentificacao());
                animal.setNumeroProdutor(controleDeGadoDTO.getNumeroProdutor());
                animal.setDataNascimento(controleDeGadoDTO.getDataNascimento());

                controleDeGadoService.salvar(animal);
                
                return ResponseEntity.ok("Animal atualizado com sucesso");
            } else {
                return new ResponseEntity<>("Animal não encontrado", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao atualizar animal: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}