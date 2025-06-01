package com.example.miniJira.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Document(collection = "usuarios")
public class Usuario {
    @Id
    private String id;

    @Field("nome_de_usuario")
    private String nomeUsuario;

    private String email;

    @Field("senha_hash")
    private UUID senhaHash;

    @Field("listas_criadas")
    private List<String> listasCriadas = new ArrayList<>();

    @Field("listas_compartilhadas")
    private List<String> listasCompartilhadas = new ArrayList<>();

    @Field("data_cadastro")
    private Date dataCadastro;
}
