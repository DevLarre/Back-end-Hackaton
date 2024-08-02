package com.consultoria.service;

import com.consultoria.model.Lead;
import com.consultoria.repository.LeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Lógica de negócio para gerenciar leads de contato.
@Service
public class LeadService {
    @Autowired
    private LeadRepository repository;

    public Lead salvar(Lead lead) {
        return repository.save(lead);
    }

    public List<Lead> listarLead() {
        return repository.findAll();
    }
}
