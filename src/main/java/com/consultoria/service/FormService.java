package com.consultoria.service;

import com.consultoria.model.Form;
import com.consultoria.repository.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FormService {
    @Autowired
    private FormRepository repository;

    public List<Form> listarTodos() {
        return repository.findAll();
    }

    public Optional<Form> findById(UUID id) {
        return repository.findById(id);
    }

    public Form salvar(Form form) {
        return repository.save(form);
    }

    public void deletar(UUID id) {
        repository.deleteById(id);
    }
}
