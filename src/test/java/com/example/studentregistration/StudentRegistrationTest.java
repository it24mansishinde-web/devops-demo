
package com.example.studentregistration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class StudentRegistrationTest {

    @LocalServerPort
    private int port;

    private WebDriver driver;

    @BeforeEach
    void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1365,768");

        driver = new ChromeDriver(options);
    }

    @Test
    void registrationPageShouldDisplayForm() {
        driver.get("http://localhost:" + port + "/");

        WebElement form = driver.findElement(By.tagName("form"));
        String pageText = driver.findElement(By.tagName("body")).getText();

        assertTrue(form.isDisplayed(),
                "Registration form should be visible");

        assertTrue(pageText.contains("Student Registration"),
                "Page should display the Student Registration heading");
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
