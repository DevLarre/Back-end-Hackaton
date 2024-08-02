package com.consultoria.controller;

import com.consultoria.model.Servico;
import com.consultoria.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicos")
public class ServiceController {
    @Autowired //ver se fica melhor Autowired ou Acess
    private ServicoService service;

    @GetMapping
    public List<Servico> listarTodos() {
        return service.listarTodos();
    }

    @PostMapping
    public Servico salvar(@RequestBody Servico servico) {
        return service.salvar(servico);
    }
}
