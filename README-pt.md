# AppRH - Aplicação de Gestão de Vagas

## Descrição

O AppRH é uma aplicação web para gestão de Recursos Humanos, desenvolvida com Java e Spring Boot. O sistema permite o cadastro, listagem, detalhamento e exclusão de vagas de emprego, bem como a associação de candidatos a essas vagas.

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
2.  **Cadastrar uma Vaga:**
    * Na página inicial, clique no botão "Cadastrar Vaga".
    * Preencha os detalhes da vaga (Nome, Descrição, Data, Salário) e clique em "Salvar".
3.  **Listar Vagas:**
    * Na página inicial, clique em "Listar Vagas" para ver todas as vagas cadastradas.
4.  **Ver Detalhes e Adicionar Candidatos:**
    * Na lista de vagas, clique no nome da vaga desejada para ver seus detalhes.
    * Na página de detalhes, você verá um formulário para "Adicionar Candidato".
    * Preencha os dados do candidato (RG, Nome, E-mail) e clique em "Adicionar" para associá-lo à vaga.
5.  **Excluir:**
    * Tanto na lista de vagas quanto na lista de candidatos (dentro dos detalhes de uma vaga), haverá opções para deletar os registros.

## Principais Rotas da Aplicação

Esta aplicação não expõe uma API RESTful com endpoints JSON. Em vez disso, ela serve páginas HTML renderizadas. As principais rotas são:

* **`GET /`**: Página inicial da aplicação.
* **`GET /vagas`**: Lista todas as vagas de emprego cadastradas.
* **`GET /cadastrarVaga`**: Exibe o formulário para criar uma nova vaga.
* **`POST /cadastrarVaga`**: Processa o envio do formulário e salva a nova vaga no banco de dados.
* **`GET /vaga/{codigo}`**: Exibe os detalhes de uma vaga específica e a lista de candidatos associados a ela.
* **`POST /vaga/{codigo}`**: Processa o formulário de adição de um novo candidato a uma vaga específica.
* **`GET /deletarVaga`**: Deleta uma vaga pelo código.
* **`GET /deletarCandidato`**: Deleta um candidato pelo seu RG.
