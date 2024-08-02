package com.consultoria.service;

import com.consultoria.model.Servico;
import com.consultoria.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Lógica de negócio para gerenciar serviços oferecidos pela empresa.
@Service
public class ServicoService {
    @Autowired
    private ServicoRepository repository;

    public List<Servico> listarTodos() {
        return repository.findAll();
    }

    public Servico salvar(Servico servico) {
        return repository.save(servico);
    }
}