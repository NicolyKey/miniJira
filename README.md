<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
</head>
<body>
    <h1>MiniJira</h1>
    <p>Projeto simples de gerenciamento de listas de tarefas com Spring Boot e MongoDB.</p>

    <h2>📋 Descrição</h2>
    <p>MiniJira é uma aplicação backend RESTful construída com Spring Boot que permite criar usuários, listas de tarefas e gerenciar a relação entre eles. Os dados são armazenados em MongoDB.</p>

    <h2>🚀 Tecnologias</h2>
    <ul>
        <li>Java 17</li>
        <li>Spring Boot 3.5</li>
        <li>Spring Data MongoDB</li>
        <li>MongoDB</li>
        <li>Lombok</li>
        <li>Maven</li>
    </ul>

    <h2>🔧 Configuração do ambiente</h2>
    <ol>
        <li><strong>MongoDB</strong>
            <ul>
                <li>Tenha o MongoDB rodando localmente ou remoto.</li>
                <li>Crie a base de dados <code>miniJira</code>.</li>
                <li>Use o MongoDB Compass para visualizar os dados, se desejar.</li>
            </ul>
        </li>
        <li><strong>Configuração da aplicação</strong><br />
            No arquivo <code>src/main/resources/application.properties</code>, configure a conexão com o MongoDB:
            <pre><code>spring.application.name=miniJira
spring.data.mongodb.uri=mongodb://localhost:27017/miniJira
server.port=8000
            </code></pre>
        </li>
        <li><strong>Build e execução</strong><br />
            No terminal, execute:
            <pre><code>mvn clean install
mvn spring-boot:run
            </code></pre>
        </li>
    </ol>

    <h2>🛠 Endpoints principais</h2>

    <h3>Usuários</h3>
    <ul>
        <li><code>POST /api/usuarios</code> — Cria um novo usuário<br />
            <strong>Body exemplo:</strong>
            <pre><code>{
  "id": "string (opcional, se não usar Mongo gerando ID)",
  "nomeUsuario": "joao123",
  "email": "joao@email.com",
  "senhaHash": "uuid-ou-string-de-senha",
  "dataCadastro": "2025-06-01T20:00:00Z"
}
            </code></pre>
        </li>
        <li><code>GET /api/usuarios</code> — Lista todos os usuários</li>
    </ul>

    <h3>Listas de Tarefas</h3>
    <ul>
        <li><code>POST /api/listas</code> — Cria uma nova lista de tarefas associada a um usuário (via <code>criadorId</code>)<br />
            <strong>Body exemplo:</strong>
            <pre><code>{
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
            </code></pre>
        </li>
        <li><code>GET /api/listas/criador/{criadorId}</code> — Lista todas as listas criadas por um usuário</li>
    </ul>

    <h2>🛡 Considerações</h2>
    <ul>
        <li>IDs dos usuários e listas são strings (gerados pelo MongoDB).</li>
        <li>A relação entre usuários e listas é feita via IDs (referência manual).</li>
        <li>Campos como datas devem estar em formato ISO 8601.</li>
        <li>Senha armazenada como hash UUID (ajuste conforme necessidade real de segurança).</li>
    </ul>

    <h2>⚙ Próximos passos</h2>
    <ul>
        <li>Implementar autenticação (JWT, OAuth).</li>
        <li>Validar dados de entrada com Bean Validation (<code>@Valid</code>).</li>
        <li>Tratar erros e exceções com handlers globais.</li>
        <li>Criar endpoints para atualizar e deletar listas e usuários.</li>
        <li>Melhorar modelagem das tarefas e colaboração entre usuários.</li>
    </ul>

    <h2>📞 Contato</h2>
    <p>Para dúvidas, sugestões e contribuições, abra uma issue ou envie mensagem.</p>

</body>
</html>
