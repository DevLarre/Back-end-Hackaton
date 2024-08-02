package com.consultoria.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/paginas")
public class PaginaController {

    @GetMapping("/home")
    public Map<String, String> getHome() {
        Map<String, String> response = new HashMap<>();
        response.put("title", "Bem-vindo à nossa empresa de consultoria");
        response.put("content", "Está é a página inicial da nossa empresa de consultoria.");
        return response;
    }

    @GetMapping("/sobreadomus")
    public Map<String, String> getSobreADomus() {
        Map<String, String> response = new HashMap<>();
        response.put("title", "Sobre");
        response.put("content", "Esta é a página de contato da nossa empresa de consultoria.");
        return response;
    }

    @GetMapping("/blog")
    public Map<String, String> getBlog() {
        Map<String, String> response = new HashMap<>();
        response.put("title", "Blog");
        response.put("content", "Esta é a página de artigos do nosso blog, ESTÁ PÁGINA NÃO SERÁ ESTATICA, TEMOS QUE MONTAR DIFERENTE.");
        return response;
    }

    @GetMapping("/solucoes")
    public Map<String, String> getSolucoes() {
        Map<String, String> response = new HashMap<>();
        response.put("title", "Soluções");
        response.put("content", "Esta é a página de serviços da nossa empresa de consultoria.");
        return response;
    }

    @GetMapping("/contato")
    public Map<String, String> getContato() {
        Map<String, String> response = new HashMap<>();
        response.put("title", "Contato");
        response.put("content", "Esta é a página de contato da nossa empresa de consultoria.");
        return response;
    }

    @GetMapping("/comeceagora")
    public Map<String, String> getComeceAgora() {
        Map<String, String> response = new HashMap<>();
        response.put("title", "Comece agora");
        response.put("content", "Esta é a página para entrar em contato com a domus.");
        return response;
    }
}