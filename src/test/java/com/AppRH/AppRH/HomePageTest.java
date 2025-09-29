package com.AppRH.AppRH;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HomePageTest {

    @LocalServerPort
    private int port;

    private WebDriver driver;

    @BeforeEach
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    /*
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:/Program Files/Google/Chrome/Application/chrome.exe");
        driver = new ChromeDriver(options);
    */
    }

    @Test
    public void testHomePageTitle() {

        String url = "http://localhost:" + port + "/";
        driver.get(url);

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