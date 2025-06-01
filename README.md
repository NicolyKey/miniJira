# MiniJira

Projeto simples de gerenciamento de listas de tarefas com Spring Boot e MongoDB.

## 📋 Descrição  
MiniJira é uma aplicação backend RESTful construída com Spring Boot que permite criar usuários, listas de tarefas e gerenciar a relação entre eles. Os dados são armazenados em MongoDB.

## 🚀 Tecnologias  
- Java 17  
- Spring Boot 3.5  
- Spring Data MongoDB  
- MongoDB  
- Lombok  
- Maven  

## 🔧 Configuração do ambiente  

### 1. **MongoDB**  
- Tenha o MongoDB rodando localmente ou remoto.  
- Crie a base de dados `miniJira`.  
- Use o MongoDB Compass para visualizar os dados, se desejar.  

### 2. **Configuração da aplicação**  
No arquivo `src/main/resources/application.properties`, configure a conexão com o MongoDB:  
``properties
spring.application.name=miniJira
spring.data.mongodb.uri=mongodb://localhost:27017/miniJira
server.port=8000 ``

### 3. Build e execução
No terminal, execute:

```
mvn clean install
mvn spring-boot:run
```

### 🛠 Endpoints principais
Usuários
POST /api/usuarios — Cria um novo usuário
Body exemplo:

```
json
{
  "id": "string (opcional)",
  "nomeUsuario": "joao123",
  "email": "joao@email.com",
  "senhaHash": "uuid-ou-string-de-senha",
  "dataCadastro": "2025-06-01T20:00:00Z"
}
```

GET /api/usuarios — Lista todos os usuários

### Listas de Tarefas
POST /api/listas — Cria uma nova lista de tarefas associada a um usuário
Body exemplo:
```
json
{
  "nomeLista": "Sprint 1",
  "criadorId": "id-do-usuario",
  "colaboradoresIds": [],
  "tags": ["backend", "java"],
  "tarefas": [
    {
      "idTarefa": "1",
      "descricao": "Criar endpoint login",
      "concluida": false,
      "dataCriacaoTarefa": "2025-06-01T20:00:00Z",
      "responsavelId": "id-do-usuario",
      "prioridade": 1
    }
  ]
}
```
GET /api/listas/criador/{criadorId} — Lista todas as listas criadas por um usuário

### 🛡 Considerações
- IDs dos usuários e listas são strings (gerados pelo MongoDB).

- A relação entre usuários e listas é feita via IDs (referência manual).

- Campos como datas devem estar em formato ISO 8601.

- Senha armazenada como hash UUID (ajuste conforme necessidade real de segurança).

### ⚙ Próximos passos
Implementar autenticação (JWT, OAuth).

- Validar dados de entrada com Bean Validation (@Valid).

- Tratar erros e exceções com handlers globais.

- Criar endpoints para atualizar e deletar listas e usuários.

- Melhorar modelagem das tarefas e colaboração entre usuários.
