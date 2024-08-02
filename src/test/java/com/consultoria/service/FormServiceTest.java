package com.consultoria.service;

import com.consultoria.model.Form;
import com.consultoria.repository.FormRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FormServiceTest {

    @Mock
    private FormRepository repository;

    @InjectMocks
    private FormService service;

    private Form form;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        form = new Form();
        form.setId(UUID.randomUUID());
        form.setEmpresa("João");
        form.setNome("Silva");
        form.setTelefone("123456789");
        form.setEmail("joao.silva@example.com");
        form.setMensagem("Esta é uma mensagem de teste com mais de 30 caracteres.");
    }

    @Test
    void listarTodos() {
        when(repository.findAll()).thenReturn(List.of(form));
        List<Form> forms = service.listarTodos();
        assertEquals(1, forms.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    void findById() {
        UUID id = form.getId();
        when(repository.findById(id)).thenReturn(Optional.of(form));
        Optional<Form> foundForm = service.findById(id);
        assertTrue(foundForm.isPresent());
        assertEquals(form.getId(), foundForm.get().getId());
        verify(repository, times(1)).findById(id);
    }

    @Test
    void salvar() {
        when(repository.save(form)).thenReturn(form);
        Form savedForm = service.salvar(form);
        assertNotNull(savedForm);
        assertEquals(form.getNome(), savedForm.getNome());
        verify(repository, times(1)).save(form);
    }

    @Test
    void deletar() {
        UUID id = form.getId();
        doNothing().when(repository).deleteById(id);
        service.deletar(id);
        verify(repository, times(1)).deleteById(id);
    }
}
