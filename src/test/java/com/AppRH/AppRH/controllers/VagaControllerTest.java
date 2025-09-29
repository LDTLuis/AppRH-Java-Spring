package com.AppRH.AppRH.controllers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class VagaControllerTest {

    @LocalServerPort
    private int port;

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private void performLogin() {
        driver.get("http://localhost:" + port + "/login");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys("admin");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys("admin");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        wait.until(ExpectedConditions.titleIs("| App RH |"));
    }

    @Test
    public void testListarVagas() {

        performLogin();
        driver.get("http://localhost:" + port + "/vagas");
        WebElement tabela = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("table")));
        assertNotNull(tabela);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testEditarVaga() {

        performLogin();

        driver.get("http://localhost:" + port + "/cadastrarVaga");
        String nomeVagaOriginal = "Vaga para Editar " + System.currentTimeMillis();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("nome"))).sendKeys(nomeVagaOriginal);
        driver.findElement(By.name("descricao")).sendKeys("Descrição original.");
        driver.findElement(By.name("data")).sendKeys("2025-10-10");
        driver.findElement(By.name("salario")).sendKeys("3000.00");
        WebElement botaoAdicionar = driver.findElement(By.cssSelector("button[type='submit']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", botaoAdicionar);

        wait.until(ExpectedConditions.urlContains("/vagas"));
        WebElement linkEditar = driver.findElement(By.xpath("//span[contains(text(), '" + nomeVagaOriginal + "')]/ancestor::tr//a[contains(text(),'Editar')]"));
        linkEditar.click();

        wait.until(ExpectedConditions.urlContains("/editar-vaga"));
        String nomeVagaEditado = "Vaga Editada com Sucesso " + System.currentTimeMillis();
        WebElement campoNome = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("nome")));
        campoNome.clear();
        campoNome.sendKeys(nomeVagaEditado);

        WebElement botaoSalvar = driver.findElement(By.cssSelector("button[type='submit']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", botaoSalvar);


        wait.until(ExpectedConditions.urlContains("/vagas"));
        WebElement vagaEditada = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[contains(text(), '" + nomeVagaEditado + "')]")
        ));
        assertNotNull(vagaEditada);
    }

    @Test
    public void testDeletarVaga() {
        performLogin();

        driver.get("http://localhost:" + port + "/cadastrarVaga");
        String nomeVagaParaDeletar = "Vaga para Deletar " + System.currentTimeMillis();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("nome"))).sendKeys(nomeVagaParaDeletar);
        driver.findElement(By.name("descricao")).sendKeys("Descrição qualquer.");
        driver.findElement(By.name("data")).sendKeys("2025-11-11");
        driver.findElement(By.name("salario")).sendKeys("1500.00");
        WebElement botaoAdicionar = driver.findElement(By.cssSelector("button[type='submit']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", botaoAdicionar);

        wait.until(ExpectedConditions.urlContains("/vagas"));
        WebElement linkExcluir = driver.findElement(By.xpath("//span[contains(text(), '" + nomeVagaParaDeletar + "')]/ancestor::tr//a[contains(text(),'Excluir')]"));
        linkExcluir.click();

       wait.until(ExpectedConditions.urlContains("/vagas"));
        boolean vagaDeletada = wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.xpath("//span[contains(text(), '" + nomeVagaParaDeletar + "')]")
        ));
        assertTrue(vagaDeletada);
    }

    @Test
    public void testAdicionarCandidatoVaga() {
        performLogin();

        driver.get("http://localhost:" + port + "/cadastrarVaga");
        String nomeVaga = "Vaga para Candidato " + System.currentTimeMillis();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("nome"))).sendKeys(nomeVaga);
        driver.findElement(By.name("descricao")).sendKeys("Descrição.");
        driver.findElement(By.name("data")).sendKeys("2025-12-01");
        driver.findElement(By.name("salario")).sendKeys("2500.00");
        WebElement botaoAdicionarVaga = driver.findElement(By.cssSelector("button[type='submit']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", botaoAdicionarVaga);


        wait.until(ExpectedConditions.urlContains("/vagas"));
        WebElement linkVaga = driver.findElement(By.xpath("//span[contains(text(), '" + nomeVaga + "')]"));
        linkVaga.click();

        wait.until(ExpectedConditions.urlContains("/vaga/"));
        String nomeCandidato = "Candidato Teste " + System.currentTimeMillis();
        String rgCandidato = String.valueOf(System.currentTimeMillis()).substring(3); // RG único
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("nomeCandidato"))).sendKeys(nomeCandidato);
        driver.findElement(By.name("rg")).sendKeys(rgCandidato);
        driver.findElement(By.name("email")).sendKeys("candidato@teste.com");
        WebElement botaoAdicionarCandidato = driver.findElement(By.cssSelector("button[type='submit']"));
        botaoAdicionarCandidato.click();

        WebElement candidatoAdicionado = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//td[contains(text(), '" + nomeCandidato + "')]")
        ));
        assertNotNull(candidatoAdicionado);
    }
}