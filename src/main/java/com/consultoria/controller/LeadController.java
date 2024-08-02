package com.consultoria.controller;

import com.consultoria.model.Lead;
import com.consultoria.service.LeadService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leads")
public class LeadController {
    @Autowired
    private LeadService service;

    @Operation(summary = "Post para leads", description = "Endpoind utilizado para leads")
    @PostMapping
    public Lead salvar(@RequestBody Lead lead) {
        return service.salvar(lead);
    }

    @GetMapping
    public List<Lead> listarLead() {
        return service.listarLead();
    }
}