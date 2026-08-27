# Rede Semente

## Sobre o projeto

A **Rede Semente** é uma plataforma comunitária que conecta mulheres microempreendedoras, especialmente aquelas em situação de informalidade, a pessoas dispostas a apoiá-las com recursos financeiros, conhecimento e oportunidades.

### O problema

Microempreendedoras informais frequentemente não conseguem acessar crédito formal para comprar equipamentos, matéria-prima e ferramentas necessárias para seus negócios — seja pela falta de CNPJ, histórico de crédito, garantias ou documentação financeira. Ao mesmo tempo, existem pessoas dispostas a apoiar essas empreendedoras, mas falta um mecanismo confiável para conectar esse apoio a negócios produtivos e acompanhar o que acontece depois da doação.

### A solução

A Rede Semente oferece um fluxo estruturado e transparente:

1. Uma microempreendedora cadastra uma **proposta**, descrevendo o equipamento ou recurso que precisa e o valor estimado.
2. Um grupo de membras da comunidade vota para validar a proposta.
3. Após atingir os votos necessários, a proposta fica disponível para receber doações da comunidade.
4. Ao atingir o valor necessário, a proposta é aprovada e a microempreendedora inicia a compra do equipamento.
5. A microempreendedora comprova a compra e o recebimento do equipamento.
6. A proposta é concluída, e a comunidade acompanha todo o histórico e impacto gerado.

> 🌱 Este projeto nasceu como parte do WoHackathon 2ª edição, onde recebeu o 1º lugar na Trilha Oracle. Esta versão é uma reconstrução simplificada, feita para consolidar aprendizado de desenvolvimento backend ponta a ponta.

---

## Tecnologias utilizadas

- **Kotlin** — linguagem principal do backend
- **Spring Boot** — framework backend
- **Spring Data JPA / Hibernate** — persistência de dados
- **PostgreSQL** — banco de dados relacional
- **Thymeleaf** — motor de templates para o frontend
- **Gradle** — gerenciador de dependências e build

---

## Estrutura do projeto

```
src/main/kotlin/com/redesemente/rede_semente/
├── controller/    → recebe requisições HTTP e decide o que responder
├── model/         → entidades (tabelas do banco) e enums
├── repository/    → interfaces de acesso ao banco de dados
└── service/       → regras de negócio da aplicação
```

### Modelo de dados

- **Usuario**: pode ser `MICROEMPREENDEDORA` ou `APOIADOR`
- **Proposta**: pedido de apoio publicado por uma microempreendedora
- **Voto**: registro de um voto de validação em uma proposta
- **Doacao**: registro de uma doação feita a uma proposta

---

## Como rodar o projeto localmente

Este projeto usa um banco de dados **local** — ou seja, cada máquina que for rodar o projeto precisa ter o PostgreSQL instalado e configurado individualmente. Siga o passo a passo abaixo.

### 1. Pré-requisitos

- **Java 21** (ou superior)
- **IntelliJ IDEA** (Community é suficiente)
- **PostgreSQL** instalado localmente
  - Windows: [postgresql.org/download/windows](https://www.postgresql.org/download/windows/)
  - Mac: [Postgres.app](https://postgresapp.com/)
- Um cliente de banco de dados de sua preferência para visualizar os dados (ex: DBeaver, pgAdmin)

### 2. Clonar o repositório

```bash
git clone <url-do-repositorio>
```

Abra a pasta clonada no IntelliJ IDEA.

### 3. Criar o banco de dados

Com o PostgreSQL rodando, crie um banco chamado `rede_semente`. Você pode fazer isso via linha de comando, pgAdmin, DBeaver, ou qualquer cliente SQL de sua preferência:

```sql
CREATE DATABASE rede_semente;
```

### 4. Configurar o `application.properties`

Por segurança, o arquivo `application.properties` **não é versionado** neste repositório (ele contém credenciais de acesso ao banco). Em vez disso, existe um arquivo de exemplo: `src/main/resources/application.properties.example`.

1. Copie esse arquivo e renomeie a cópia para `application.properties`, na mesma pasta
2. Preencha `spring.datasource.username` e ajuste a autenticação de senha conforme seu ambiente:
   - **Windows**: normalmente `username=postgres`, com senha definida na instalação
   - **Mac (Postgres.app)**: normalmente o usuário é o mesmo do seu usuário do sistema (ex: `seu.nome`), geralmente sem senha

Este projeto está configurado para ler a senha do banco a partir de uma **variável de ambiente** chamada `DB_PASSWORD`, em vez de deixá-la escrita diretamente no arquivo. Configure essa variável de ambiente no seu sistema operacional com o valor da sua senha do PostgreSQL (caso seu ambiente não use senha, como é comum no Postgres.app do Mac, deixe o campo de senha vazio no `application.properties`).

### 5. Rodar o projeto

No IntelliJ, abra o arquivo `RedeSementeApplication.kt` e clique no botão de "play" ao lado da função `main`.

Se tudo estiver configurado corretamente, o Hibernate criará automaticamente todas as tabelas no banco `rede_semente` na primeira execução.

### 6. Acessar

Com o projeto rodando, acesse:

```
http://localhost:8080
```

---

## Status do projeto

🚧 Em desenvolvimento — este é um projeto de aprendizado, construído passo a passo, ainda sem deploy em produção.

### Já implementado

- [x] Modelagem de dados: `Usuario`, `Proposta`, `Voto`, `Doacao`
- [x] Camada de acesso a dados (`Repository`)
- [x] Regras de negócio iniciais (`Service`): cadastro, votação e doação com atualização automática de status

### Próximos passos

- [ ] Controllers e telas (Thymeleaf) para cadastro e listagem
- [ ] Refinar regra de contagem de votos por proposta específica
- [ ] Deploy em ambiente de nuvem
