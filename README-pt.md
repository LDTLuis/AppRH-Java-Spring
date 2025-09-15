# AppRH - Aplicação de Gestão de Vagas e Funcionários

## Descrição

O AppRH é uma aplicação web completa para gestão de Recursos Humanos, desenvolvida com Java e Spring Boot. O sistema permite o cadastro e gerenciamento de **Vagas**, **Candidatos**, **Funcionários** e **Dependentes**.

A aplicação foi atualizada para incluir um sistema de **autenticação e autorização** com Spring Security, definindo perfis de acesso para diferentes tipos de usuários (por exemplo, `ROLE_ADMIN`). Além disso, foi implementada uma funcionalidade de **busca** para facilitar a localização de vagas e funcionários.

## Tecnologias Utilizadas

* **Linguagem:** Java
* **Framework:** Spring Boot
* **Segurança:** Spring Security
* **Front-end:** Thymeleaf
* **Persistência de Dados:** Spring Data JPA
* **Banco de Dados:** MySQL
* **Estilização:** Bootstrap
* **Gerenciador de Dependências:** Maven

## Práticas Adotadas

* **Padrão MVC (Model-View-Controller)**
* **Autenticação e Autorização com Spring Security**
* **Spring Data JPA Repositories**
* **Validação de Dados**
* **Relacionamento entre Entidades**
* **Maven Wrapper**

## Como Executar

1.  **Pré-requisitos:**
    * JDK 8 ou superior.
    * Um servidor de banco de dados MySQL em execução.

2.  **Configuração do Banco de Dados:**
    * Crie um schema no seu MySQL (por exemplo, `apprh`).
    * Atualize as credenciais de conexão (URL, username, password) no arquivo `src/main/resources/application.properties`.

3.  **Execução:**
    * Clone o repositório.
    * Navegue até o diretório raiz do projeto em um terminal.
    * Execute o comando a seguir para iniciar a aplicação:
        ```bash
        ./mvnw spring-boot:run
        ```
    * A aplicação estará disponível no seu navegador em `http://localhost:8080`.

## Como Usar o Sistema

Antes de tudo, certifique-se de que você **configurou o banco de dados** e **iniciou a aplicação**. Na primeira execução, um usuário `admin` com a senha `123` será criado automaticamente.

1.  **Acesse e Faça Login:**
    * Abra seu navegador e acesse `http://localhost:8080`.
    * Você será redirecionado para a página de login. Use as credenciais `admin` / `123` para entrar.
2.  **Cadastrar um Novo Usuário (Admin):**
    * Após o login, acesse a rota `/cadastrarUsuario` para criar novos usuários para o sistema.
3.  **Buscar Vagas ou Funcionários:**
    * Na página inicial, utilize a barra de busca para encontrar vagas ou funcionários pelo nome.
4.  **Gerenciar Vagas e Funcionários:**
    * Utilize os menus e botões para cadastrar, listar, editar e deletar vagas, funcionários e seus respectivos candidatos e dependentes, como nas versões anteriores.

## Principais Rotas da Aplicação

A aplicação serve páginas HTML renderizadas e protegidas por autenticação.

### Autenticação e Usuários
* **`GET /login`**: Página de login.
* **`GET /cadastrarUsuario`**: Formulário para criar um novo usuário (acesso restrito).
* **`POST /cadastrarUsuario`**: Salva o novo usuário.

### Busca
* **`POST /buscar`**: Processa a busca por vagas e funcionários.

### Gestão de Vagas
* **`GET /vagas`**: Lista todas as vagas de emprego.
* **`GET /cadastrarVaga`**: Exibe o formulário para criar uma nova vaga.
* **`POST /cadastrarVaga`**: Salva a nova vaga.
* **`GET /vaga/{codigo}`**: Exibe os detalhes de uma vaga e seus candidatos.
* **`POST /vaga/{codigo}`**: Adiciona um novo candidato a uma vaga.
* **`GET /editar-vaga`**: Exibe o formulário para editar uma vaga.
* **`POST /editar-vaga`**: Salva as alterações da vaga.

### Gestão de Funcionários
* **`GET /funcionarios`**: Lista todos os funcionários.
* **`GET /cadastrarFuncionario`**: Exibe o formulário para criar um novo funcionário.
* **`POST /cadastrarFuncionario`**: Salva o novo funcionário.
* **`GET /funcionarios/{id}`**: Exibe os detalhes de um funcionário e seus dependentes.
* **`POST /funcionarios/{id}`**: Adiciona um novo dependente a um funcionário.
* **`GET /editar-funcionario`**: Exibe o formulário para editar um funcionário.
* **`POST /editar-funcionario`**: Salva as alterações do funcionário.
