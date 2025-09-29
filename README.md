# AppRH - Vacancy and Employee Management Application

## Description

AppRH is a complete web application for Human Resources management, developed with Java and Spring Boot. The system allows for the registration and management of **Vacancies**, **Candidates**, **Employees**, and **Dependents**.

The application features an **authentication and authorization** system using Spring Security, defining access profiles, and also implements a **search** functionality. Recently, **user interface (UI) tests** using Selenium were added to ensure the quality and functionality of the main features.

## Technologies Used

* **Language:** Java
* **Framework:** Spring Boot
* **Security:** Spring Security
* **Front-end:** Thymeleaf
* **Data Persistence:** Spring Data JPA
* **Database:** MySQL
* **Testing:** Selenium WebDriver
* **Styling:** Bootstrap
* **Dependency Manager:** Maven

## Adopted Practices

* **MVC (Model-View-Controller) Pattern**
* **Authentication and Authorization with Spring Security**
* **Automated UI Testing with Selenium**
* **Spring Data JPA Repositories**
* **Data Validation**
* **Entity Relationships**
* **Maven Wrapper**

## Automated Tests

The project includes a suite of user interface tests developed with Selenium WebDriver. These tests simulate real user interaction with the system, validating critical workflows.

* **Implemented Tests:**
    * `HomePageTest`: Verifies that the home page is loading correctly.
    * `LoginControllerTest`: Tests the authentication flow, including successful login and login failures.
    * `UsuarioControllerTest`: Validates the registration process for new users.
    * `VagaControllerTest`: Tests the complete CRUD flow for vacancies, including creation, listing, and searching.

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

First, make sure you have **configured the database** and **started the application**.

1.  **Access and Log In:**
    * Open your browser and go to `http://localhost:8080`.
    * You will be redirected to the login page. On the first run, an administrator user is created automatically.
    * **User:** `admin`
    * **Password:** `amin`

2.  **Register a New User (Admin):**
    * After logging in as an administrator, access the `/cadastrarUsuario` route to create new users for the system.

3.  **Search for Vacancies or Employees:**
    * On the main page, use the search bar to find vacancies or employees by name.

4.  **Manage Vacancies and Employees:**
    * Use the menus and buttons to register, list, edit, and delete vacancies, employees, and their respective candidates and dependents.

## Main Application Routes

The application serves rendered HTML pages protected by authentication.

### Authentication and Users
* **`GET /login`**: Login page.
* **`GET /cadastrarUsuario`**: Form to create a new user (admin access required).
* **`POST /cadastrarUsuario`**: Saves the new user.

### Search
* **`POST /buscar`**: Processes the search for vacancies and employees.

### Vacancy Management
* **`GET /vagas`**: Lists all job vacancies.
* **`GET /cadastrarVaga`**: Displays the form to create a new vacancy.
* **`GET /vaga/{codigo}`**: Displays the details of a vacancy and its candidates.
* **`GET /editar-vaga`**: Displays the form to edit a vacancy.

### Employee Management
* **`GET /funcionarios`**: Lists all employees.
* **`GET /cadastrarFuncionario`**: Displays the form to create a new employee.
* **`GET /funcionarios/{id}`**: Displays the details of an employee and their dependents.
* **`GET /editar-funcionario`**: Displays the form to edit an employee.
