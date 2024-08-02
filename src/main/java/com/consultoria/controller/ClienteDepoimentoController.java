package com.consultoria.controller;

import com.consultoria.exception.ResourceNotFoundException;
import com.consultoria.model.ClienteDepoimento;
import com.consultoria.service.ClienteDepoimentoService;
import org.hibernate.annotations.processing.Find;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/depoimentos")
//@CrossOrigin (origins = "http://127.0.0.1:5500") SALVAR PARA TESTES FUTUROS QUANDO DER ERRO DE CORS
public class ClienteDepoimentoController {
    @Autowired //ver se fica melhor Autowired ou Acess
    private ClienteDepoimentoService service;

    @GetMapping("/{id}")
    public ClienteDepoimento findById(@PathVariable UUID id) {
        Optional<ClienteDepoimento> depoimento = service.findById(id);
        if (depoimento.isEmpty()) {
            throw new ResourceNotFoundException("Depoimento não encontrado com ID: " + id);
        }
        return depoimento.get();
    }

    @GetMapping /// url, id variavel.
    public List<ClienteDepoimento> listClient() {
        return service.listartodos();
    }

    @PostMapping
    public ClienteDepoimento salvar(@RequestBody ClienteDepoimento depoimento) {
        return service.salvar(depoimento);
    }
}
