package com.example.miniJira.controller;

import com.example.miniJira.model.ListaTarefas;
import com.example.miniJira.services.ListaTarefasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/listas")
public class ListaTarefasController {
    @Autowired
    private ListaTarefasService listaService;

    @PostMapping
    public ListaTarefas criarLista(@RequestBody ListaTarefas lista) {
        return listaService.criarLista(lista);
    }

    @GetMapping("/criador/{criadorId}")
    public List<ListaTarefas> listarPorCriador(@PathVariable String criadorId) {
        return listaService.listarPorCriador(criadorId);
    }
}
