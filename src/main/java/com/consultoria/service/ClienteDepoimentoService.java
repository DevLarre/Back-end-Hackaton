package com.consultoria.service;

import com.consultoria.model.ClienteDepoimento;
import com.consultoria.repository.ClienteDepoimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

//Essa classe define a lógica de negócio para gerenciar os depoimentos dos clientes.
@Service
public class ClienteDepoimentoService {
    @Autowired
    private ClienteDepoimentoRepository repository;

    public List<ClienteDepoimento> listartodos() {
        return repository.findAll();
    }

    public ClienteDepoimento salvar(ClienteDepoimento depoimento) {
        return repository.save(depoimento);
    }

    public Optional<ClienteDepoimento> findById(UUID id) {
        return repository.findById(id);
    }
}
