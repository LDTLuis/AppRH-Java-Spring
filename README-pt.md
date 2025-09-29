# AppRH - Aplicação de Gestão de Vagas e Funcionários

## Descrição

O AppRH é uma aplicação web completa para gestão de Recursos Humanos, desenvolvida com Java e Spring Boot. O sistema permite o cadastro e gerenciamento de **Vagas**, **Candidatos**, **Funcionários** e **Dependentes**.

A aplicação conta com um sistema de **autenticação e autorização** via Spring Security, definindo perfis de acesso, e também implementa uma funcionalidade de **busca**. Recentemente, foram adicionados **testes de interface de usuário (UI)** utilizando Selenium para garantir a qualidade e o funcionamento das principais funcionalidades.

## Tecnologias Utilizadas

* **Linguagem:** Java
* **Framework:** Spring Boot
* **Segurança:** Spring Security
* **Front-end:** Thymeleaf
* **Persistência de Dados:** Spring Data JPA
* **Banco de Dados:** MySQL
* **Testes:** Selenium WebDriver
* **Estilização:** Bootstrap
* **Gerenciador de Dependências:** Maven

## Práticas Adotadas

* **Padrão MVC (Model-View-Controller)**
* **Autenticação e Autorização com Spring Security**
* **Testes Automatizados de UI com Selenium**
* **Spring Data JPA Repositories**
* **Validação de Dados**
* **Relacionamento entre Entidades**
* **Maven Wrapper**

## Testes Automatizados

O projeto inclui uma suíte de testes de interface de usuário desenvolvida com Selenium WebDriver. Esses testes simulam a interação de um usuário real com o sistema, validando fluxos críticos.

* **Testes Implementados:**
    * `HomePageTest`: Verifica se a página inicial está carregando corretamente.
    * `LoginControllerTest`: Testa o fluxo de autenticação, incluindo login bem-sucedido e falhas de login.
    * `UsuarioControllerTest`: Valida o processo de cadastro de novos usuários.
    * `VagaControllerTest`: Testa o fluxo completo de CRUD para vagas, incluindo criação, listagem e busca.

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

Antes de tudo, certifique-se de que você **configurou o banco de dados** e **iniciou a aplicação**.

1.  **Acesse e Faça Login:**
    * Abra seu navegador e acesse `http://localhost:8080`.
    * Você será redirecionado para a página de login. Na primeira execução, um usuário administrador é criado automaticamente.
    * **Usuário:** `admin`
    * **Senha:** `admin`

2.  **Cadastrar um Novo Usuário (Admin):**
    * Após o login como administrador, acesse a rota `/cadastrarUsuario` para criar novos usuários para o sistema.

3.  **Buscar Vagas ou Funcionários:**
    * Na página inicial, utilize a barra de busca para encontrar vagas ou funcionários pelo nome.

4.  **Gerenciar Vagas e Funcionários:**
    * Utilize os menus e botões para cadastrar, listar, editar e deletar vagas, funcionários e seus respectivos candidatos e dependentes.

## Principais Rotas da Aplicação

A aplicação serve páginas HTML renderizadas e protegidas por autenticação.

### Autenticação e Usuários
* **`GET /login`**: Página de login.
* **`GET /cadastrarUsuario`**: Formulário para criar um novo usuário (acesso restrito a admins).
* **`POST /cadastrarUsuario`**: Salva o novo usuário.

### Busca
* **`POST /buscar`**: Processa a busca por vagas e funcionários.

### Gestão de Vagas
* **`GET /vagas`**: Lista todas as vagas de emprego.
* **`GET /cadastrarVaga`**: Exibe o formulário para criar uma nova vaga.
* **`GET /vaga/{codigo}`**: Exibe os detalhes de uma vaga e seus candidatos.
* **`GET /editar-vaga`**: Exibe o formulário para editar uma vaga.

### Gestão de Funcionários
* **`GET /funcionarios`**: Lista todos os funcionários.
* **`GET /cadastrarFuncionario`**: Exibe o formulário para criar um novo funcionário.
* **`GET /funcionarios/{id}`**: Exibe os detalhes de um funcionário e seus dependentes.
* **`GET /editar-funcionario`**: Exibe o formulário para editar um funcionário.
