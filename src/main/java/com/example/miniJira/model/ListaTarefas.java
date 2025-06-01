package com.example.miniJira.model;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;
import java.util.List;

@Data
@Document(collection = "listas_tarefas")
public class ListaTarefas {
    @Id
    private String id;
    private String nomeLista;
    private String criadorId;
    private List<String> colaboradoresIds;
    private Date dataCriacao;
    private Date ultimaAtualizacao;
    private List<String> tags;
    private List<Tarefa> tarefas;
}

@Data
class Tarefa {
    private String idTarefa;
    private String descricao;
    private boolean concluida;
    private Date dataCriacaoTarefa;
    private Date dataConclusaoTarefa;
    private String responsavelId;
    private int prioridade;
}
