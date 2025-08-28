# AppRH - Vacancy and Employee Management Application

## Description

AppRH is a web application for Human Resources management, developed with Java and Spring Boot. The system allows for the complete registration and management of **Job Vacancies** (with their candidates) and **Employees** (with their dependents).

The application uses the MVC (Model-View-Controller) pattern, with the views being rendered on the server-side using Thymeleaf.

## Technologies Used

* **Language:** Java
* **Framework:** Spring Boot
* **Front-end:** Thymeleaf
* **Data Persistence:** Spring Data JPA
* **Database:** MySQL
* **Styling:** Bootstrap
* **Dependency Manager:** Maven

## Adopted Practices

* **MVC (Model-View-Controller) Pattern**
* **Spring Data JPA Repositories**
* **Data Validation**
* **Entity Relationships**
* **Maven Wrapper**

## How to Run

1.  **Prerequisites:**
    * JDK 8 or higher.
    * A running MySQL database server.

2.  **Database Configuration:**
    * Create a schema in your MySQL (e.g., `apprh`).
    * Update the connection credentials (URL, username, password) in the `src/main/resources/application.properties` file.

3.  **Execution:**
    * Clone the repository.
    * Navigate to the project's root directory in a terminal.
    * Run the following command to start the application:
        ```bash
        ./mvnw spring-boot:run
        ```
    * The application will be available in your browser at `http://localhost:8080`.

## How to Use the System

First, make sure you have **configured the database** and **started the application** as described in the "How to Run" section.

1.  **Access the Application:** Open your browser and go to `http://localhost:8080`.
2.  **Manage Vacancies:**
    * On the homepage, use the "Cadastrar Vaga" (Register Vacancy) and "Listar Vagas" (List Vacancies) buttons to create, view, and manage vacancies and their candidates.
3.  **Manage Employees:**
    * On the homepage, use the "Cadastrar Funcionário" (Register Employee) and "Listar Funcionários" (List Employees) buttons to create and view employees.
4.  **View Details and Add Dependents:**
    * In the employee list, click on an employee's name to see their details.
    * On the details page, you can add dependents, associating them directly with the employee.
5.  **Edit and Delete:**
    * Both vacancies and employees have edit and delete functionalities available in their respective lists and detail pages.

## Main Application Routes

The application serves rendered HTML pages. The main routes are:

### Vacancy Management
* **`GET /vagas`**: Lists all job vacancies.
* **`GET /cadastrarVaga`**: Displays the form to create a new vacancy.
* **`POST /cadastrarVaga`**: Saves the new vacancy.
* **`GET /vaga/{codigo}`**: Displays the details of a vacancy and its candidates.
* **`POST /vaga/{codigo}`**: Adds a new candidate to a vacancy.
* **`GET /editar-vaga`**: Displays the form to edit a vacancy.
* **`POST /editar-vaga`**: Saves the changes to the vacancy.
* **`GET /deletarVaga`**: Deletes a vacancy.

### Employee Management
* **`GET /funcionarios`**: Lists all employees.
* **`GET /cadastrarFuncionario`**: Displays the form to create a new employee.
* **`POST /cadastrarFuncionario`**: Saves the new employee.
* **`GET /funcionarios/{id}`**: Displays the details of an employee and their dependents.
* **`POST /funcionarios/{id}`**: Adds a new dependent to an employee.
* **`GET /editar-funcionario`**: Displays the form to edit an employee.
* **`POST /editar-funcionario`**: Saves the changes to the employee.
* **`GET /deletarFuncionario`**: Deletes an employee.
* **`GET /deletarDependente/{id}`**: Deletes a dependent.
