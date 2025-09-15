# AppRH - Vacancy and Employee Management Application

## Description

AppRH is a complete web application for Human Resources management, developed with Java and Spring Boot. The system allows for the registration and management of **Vacancies**, **Candidates**, **Employees**, and **Dependents**.

The application has been updated to include an **authentication and authorization** system with Spring Security, defining access profiles for different types of users (e.g., `ROLE_ADMIN`). Additionally, a **search** functionality has been implemented to facilitate finding vacancies and employees.

## Technologies Used

* **Language:** Java
* **Framework:** Spring Boot
* **Security:** Spring Security
* **Front-end:** Thymeleaf
* **Data Persistence:** Spring Data JPA
* **Database:** MySQL
* **Styling:** Bootstrap
* **Dependency Manager:** Maven

## Adopted Practices

* **MVC (Model-View-Controller) Pattern**
* **Authentication and Authorization with Spring Security**
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

First, make sure you have **configured the database** and **started the application**. On the first run, an `admin` user with the password `123` will be created automatically.

1.  **Access and Log In:**
    * Open your browser and go to `http://localhost:8080`.
    * You will be redirected to the login page. Use the credentials `admin` / `123` to sign in.
2.  **Register a New User (Admin):**
    * After logging in, access the `/cadastrarUsuario` route to create new users for the system.
3.  **Search for Vacancies or Employees:**
    * On the main page, use the search bar to find vacancies or employees by name.
4.  **Manage Vacancies and Employees:**
    * Use the menus and buttons to register, list, edit, and delete vacancies, employees, and their respective candidates and dependents, just as in previous versions.

## Main Application Routes

The application serves rendered HTML pages protected by authentication.

### Authentication and Users
* **`GET /login`**: Login page.
* **`GET /cadastrarUsuario`**: Form to create a new user (restricted access).
* **`POST /cadastrarUsuario`**: Saves the new user.

### Search
* **`POST /buscar`**: Processes the search for vacancies and employees.

### Vacancy Management
* **`GET /vagas`**: Lists all job vacancies.
* **`GET /cadastrarVaga`**: Displays the form to create a new vacancy.
* **`POST /cadastrarVaga`**: Saves the new vacancy.
* **`GET /vaga/{codigo}`**: Displays the details of a vacancy and its candidates.
* **`POST /vaga/{codigo}`**: Adds a new candidate to a vacancy.
* **`GET /editar-vaga`**: Displays the form to edit a vacancy.
* **`POST /editar-vaga`**: Saves the changes to the vacancy.

### Employee Management
* **`GET /funcionarios`**: Lists all employees.
* **`GET /cadastrarFuncionario`**: Displays the form to create a new employee.
* **`POST /cadastrarFuncionario`**: Saves the new employee.
* **`GET /funcionarios/{id}`**: Displays the details of an employee and their dependents.
* **`POST /funcionarios/{id}`**: Adds a new dependent to an employee.
* **`GET /editar-funcionario`**: Displays the form to edit an employee.
* **`POST /editar-funcionario`**: Saves the changes to the employee.
