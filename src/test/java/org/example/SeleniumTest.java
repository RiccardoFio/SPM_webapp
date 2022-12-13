package org.example;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.Console;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class SeleniumTest {
    WebDriver driver=new ChromeDriver();

    @BeforeEach
    void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

/*
    @BeforeAll
    public static void setup(){
        String projectPath=System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver",projectPath+"/chromedriver");
    }*/
    @AfterEach
    void tearDown() throws Exception {
        driver.close();
        driver.quit();
    }

    @Test
    @Tag("AcceptanceTest")
    void checkTitleTomCatSite() throws InterruptedException {
        driver.get("http://localhost:8080/SPM_webapp/");

        Thread.sleep(3000);

        String at = driver.getTitle();
        String et = "SPM Lab Lecture";

        Thread.sleep(4000);

        assertEquals(et,at);
    }
}
