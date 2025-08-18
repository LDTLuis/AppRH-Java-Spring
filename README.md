# AppRH - Job Management Application

## Description

AppRH is a web application for Human Resources management, developed with Java and Spring Boot. The system allows for the creation, listing, detailing, and deletion of job vacancies, as well as associating candidates with these vacancies.

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
2.  **Register a Vacancy:**
    * On the homepage, click the "Cadastrar Vaga" (Register Vacancy) button.
    * Fill in the vacancy details (Name, Description, Date, Salary) and click "Salvar" (Save).
3.  **List Vacancies:**
    * On the homepage, click "Listar Vagas" (List Vacancies) to see all registered job openings.
4.  **View Details and Add Candidates:**
    * In the vacancy list, click on the desired job name to see its details.
    * On the details page, you will see a form to "Adicionar Candidato" (Add Candidate).
    * Fill in the candidate's data (ID, Name, E-mail) and click "Adicionar" (Add) to associate them with the vacancy.
5.  **Delete:**
    * In both the vacancy list and the candidate list (within a vacancy's details), there will be options to delete the records.

## Main Application Routes

This application does not expose a RESTful API with JSON endpoints. Instead, it serves rendered HTML pages. The main routes are:

* **`GET /`**: Application's homepage.
* **`GET /vagas`**: Lists all registered job vacancies.
* **`GET /cadastrarVaga`**: Displays the form to create a new vacancy.
* **`POST /cadastrarVaga`**: Processes the form submission and saves the new vacancy to the database.
* **`GET /vaga/{codigo}`**: Displays the details of a specific vacancy and the list of candidates associated with it.
* **`POST /vaga/{codigo}`**: Processes the form for adding a new candidate to a specific vacancy.
* **`GET /deletarVaga`**: Deletes a vacancy by its code.
* **`GET /deletarCandidato`**: Deletes a candidate by their ID.
