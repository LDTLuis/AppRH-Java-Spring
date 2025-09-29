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
public class LoginControllerTest {

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
    public void testLoginComSucesso() {

        driver.get(baseUrl + "/login");

        driver.findElement(By.name("username")).sendKeys("luis");
        driver.findElement(By.name("password")).sendKeys("123");

        driver.findElement(By.cssSelector("button[type='submit']")).click();

        String expectedTitle = "| App RH - Login |";
        String actualTitle = driver.getTitle();

        assertEquals(expectedTitle, actualTitle);
    }

    @Test
    public void testLoginComFalha() {
        driver.get(baseUrl + "/login");

        driver.findElement(By.name("username")).sendKeys("usuarioinvalido");
        driver.findElement(By.name("password")).sendKeys("senhainvalida");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        boolean mensagemDeErroVisivel = driver.findElement(By.className("alert-danger")).isDisplayed();

        assertEquals(true, mensagemDeErroVisivel);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}