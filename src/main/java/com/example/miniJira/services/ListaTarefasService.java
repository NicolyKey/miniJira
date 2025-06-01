package com.example.miniJira.services;

import com.example.miniJira.model.ListaTarefas;
import com.example.miniJira.model.Usuario;
import com.example.miniJira.repository.ListaTarefasRepository;
import com.example.miniJira.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ListaTarefasService {
    @Autowired
    private ListaTarefasRepository listaRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public ListaTarefas criarLista(ListaTarefas lista) {
        lista.setDataCriacao(new Date());
        lista.setUltimaAtualizacao(new Date());

        ListaTarefas novaLista = listaRepository.save(lista);

        Usuario usuario = usuarioRepository.findById(lista.getCriadorId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        usuario.getListasCriadas().add(novaLista.getId());
        usuarioRepository.save(usuario);

        return novaLista;
    }

    public List<ListaTarefas> listarPorCriador(String criadorId) {
        return listaRepository.findByCriadorId(criadorId);
    }
}
