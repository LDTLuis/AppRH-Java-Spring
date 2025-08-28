# AppRH - Aplicação de Gestão de Vagas e Funcionários

## Descrição

O AppRH é uma aplicação web para gestão de Recursos Humanos, desenvolvida com Java e Spring Boot. O sistema permite o cadastro e gerenciamento completo de **Vagas de emprego** (com seus candidatos) e de **Funcionários** (com seus dependentes).

A aplicação utiliza o padrão MVC (Model-View-Controller), com as visualizações sendo renderizadas no lado do servidor através do Thymeleaf.

## Tecnologias Utilizadas

* **Linguagem:** Java
* **Framework:** Spring Boot
* **Front-end:** Thymeleaf
* **Persistência de Dados:** Spring Data JPA
* **Banco de Dados:** MySQL
* **Estilização:** Bootstrap
* **Gerenciador de Dependências:** Maven

## Práticas Adotadas

* **Padrão MVC (Model-View-Controller)**
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

Antes de tudo, certifique-se de que você **configurou o banco de dados** e **iniciou a aplicação** conforme descrito na seção "Como Executar".

1.  **Acesse a Aplicação:** Abra seu navegador e acesse `http://localhost:8080`.
2.  **Gerenciar Vagas:**
    * Na página inicial, use os botões "Cadastrar Vaga" e "Listar Vagas" para criar, visualizar e gerenciar as vagas e seus candidatos.
3.  **Gerenciar Funcionários:**
    * Na página inicial, use os botões "Cadastrar Funcionário" e "Listar Funcionários" para criar e visualizar os funcionários.
4.  **Ver Detalhes e Adicionar Dependentes:**
    * Na lista de funcionários, clique no nome do funcionário para ver seus detalhes.
    * Na página de detalhes, você pode adicionar dependentes, associando-os diretamente ao funcionário.
5.  **Editar e Excluir:**
    * Tanto as vagas quanto os funcionários possuem funcionalidades de edição e exclusão em suas respectivas listas e páginas de detalhes.

## Principais Rotas da Aplicação

A aplicação serve páginas HTML renderizadas. As principais rotas são:

### Gestão de Vagas
* **`GET /vagas`**: Lista todas as vagas de emprego.
* **`GET /cadastrarVaga`**: Exibe o formulário para criar uma nova vaga.
* **`POST /cadastrarVaga`**: Salva a nova vaga.
* **`GET /vaga/{codigo}`**: Exibe os detalhes de uma vaga e seus candidatos.
* **`POST /vaga/{codigo}`**: Adiciona um novo candidato a uma vaga.
* **`GET /editar-vaga`**: Exibe o formulário para editar uma vaga.
* **`POST /editar-vaga`**: Salva as alterações da vaga.
* **`GET /deletarVaga`**: Deleta uma vaga.

### Gestão de Funcionários
* **`GET /funcionarios`**: Lista todos os funcionários.
* **`GET /cadastrarFuncionario`**: Exibe o formulário para criar um novo funcionário.
* **`POST /cadastrarFuncionario`**: Salva o novo funcionário.
* **`GET /funcionarios/{id}`**: Exibe os detalhes de um funcionário e seus dependentes.
* **`POST /funcionarios/{id}`**: Adiciona um novo dependente a um funcionário.
* **`GET /editar-funcionario`**: Exibe o formulário para editar um funcionário.
* **`POST /editar-funcionario`**: Salva as alterações do funcionário.
* **`GET /deletarFuncionario`**: Deleta um funcionário.
* **`GET /deletarDependente/{id}`**: Deleta um dependente.
