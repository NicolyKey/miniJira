package com.example.miniJira.repository;

import com.example.miniJira.model.ListaTarefas;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ListaTarefasRepository extends MongoRepository<ListaTarefas, String> {
    List<ListaTarefas> findByCriadorId(String criadorId);
    List<ListaTarefas> findByColaboradoresIdsContaining(String colaboradorId);
}
