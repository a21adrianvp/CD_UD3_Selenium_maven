package dev.selenium;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class ChromeTest {

    static ChromeDriver driver;
    
    @BeforeAll
    public static void start(){
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
    }

    @Test
    public void basicOptions() throws InterruptedException {
        // System.out.println(driver.getTitle());
        WebElement textImput = driver.findElement(By.id("my-text-id"));
        textImput.sendKeys("adrian");

        Thread.sleep(2000);
        WebElement botonSubmit = driver.findElement(By.className("btn-outline-primary"));
        botonSubmit.click();

        WebElement mensaje = driver.findElement(By.className("display-6"));
        System.out.println(mensaje.getText());
        assertEquals("Form submitted",mensaje.getText());
    }

    @Test
    public void elementosForm() throws InterruptedException{
        WebElement checkBox= driver.findElement(By.id("my-check-1"));
        assertTrue(checkBox.isSelected());

        WebElement palabra = driver.findElement(By.name("my-disabled"));
        palabra.sendKeys("HOLA");
        assertEquals("HOLA", palabra.getText());        
    }

    @Test
    public void checkFichero() throws InterruptedException{
        driver.get("https://the-internet.herokuapp.com/upload");
        String nameImage="imagen.jpg";

        File uploadFile = new File("src/test/files/imagen.jpg");

        WebElement fileInput = driver.findElement(By.cssSelector("input[type=file]"));
        fileInput.sendKeys(uploadFile.getAbsolutePath());
        Thread.sleep(2000);

        driver.findElement(By.id("file-submit")).click();
        Thread.sleep(2000);

        WebElement subido=driver.findElement(By.id("uploaded-files"));

        assertEquals(nameImage,subido.getText());
    }

    @Test
    public void selectForm(){
        WebElement seleccion = driver.findElement(By.className("form-select"));
        Select comboSelect = new Select(seleccion);
        comboSelect.selectByVisibleText("Two");
    }

    @Test
    public void calendario(){
        WebElement dia = driver.findElement(By.name("my-date"));
        dia.sendKeys("01/03/2024");
        dia.sendKeys(Keys.TAB);
    }

    @Test
    public void ratio(){
        WebElement ratio;
    }

    @AfterAll
    public static void end(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }

}