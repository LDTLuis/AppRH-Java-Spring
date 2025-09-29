package com.AppRH.AppRH.controllers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UsuarioControllerTest {

    @LocalServerPort
    private int port;

    private WebDriver driver;
    private String baseUrl;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        baseUrl = "http://localhost:" + port;
    }

    @Test
    public void testCadastroDeNovoUsuarioComSucesso() {

        driver.get(baseUrl + "/cadastrar-usuario");

        String novoLogin = "usuarioDeTeste" + System.currentTimeMillis();
        driver.findElement(By.name("login")).sendKeys(novoLogin);
        driver.findElement(By.name("senha")).sendKeys("senha1234");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        String expectedTitle = "| App RH - Login |";
        String actualTitle = driver.getTitle();

        assertEquals(expectedTitle, actualTitle);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}