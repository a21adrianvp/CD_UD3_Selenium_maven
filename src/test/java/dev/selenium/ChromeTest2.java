package dev.selenium;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChromeTest2 {

    static ChromeDriver driver;

    @BeforeAll
    public static void start() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get("https://www.lidl.es/?utm_campaign=es_ao_sea_g_nf_lidlonline-lidl.es_bd_ex_na_all_brand_own-brand_shop&gad_source=1&gclid=EAIaIQobChMI0c722v6ThAMV2EFBAh017gogEAAYASAAEgLdd_D_BwE");
        try {
            WebElement botonAceptarCookies = driver.findElement(By.id("onetrust-accept-btn-handler"));
            botonAceptarCookies.click();
        } catch (Exception e) {
            System.out.println("El botón de aceptar cookies no está presente.");
        }

    }

    @Test
    public void CPF1() throws InterruptedException {
        // System.out.println(driver.getTitle());
        String txtSearch = "chuletas"; 
        WebElement textImput = driver.findElement(By.id("mainsearch-input"));
        textImput.sendKeys(txtSearch);
        Thread.sleep(3000);
        WebElement botonEnviar = driver.findElement(By.xpath(".//button[@type='submit'][@class='primary']"));
        botonEnviar.click();
        //Thread.sleep(3000);
        WebElement resultadoBusqueda = driver.findElement(By.xpath(".//p[@class='input_text']/b"));
        assertEquals(txtSearch, resultadoBusqueda.getText().replaceAll("\"", ""));
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void CPF2() throws InterruptedException {
        // System.out.println(driver.getTitle());
        String txtSearch = "programacion"; 
        WebElement textImput = driver.findElement(By.id("mainsearch-input"));
        textImput.sendKeys(txtSearch);
        Thread.sleep(3000);
        WebElement botonEnviar = driver.findElement(By.xpath(".//button[@type='submit'][@class='primary']"));
        botonEnviar.click();
        //Thread.sleep(3000);
        WebElement resultadoBusqueda = driver.findElement(By.id("search_results_count"));
        assertNotEquals(txtSearch, resultadoBusqueda.getText());
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void CPF3() throws InterruptedException {
        // System.out.println(driver.getTitle());
        String txtSearch = "programacion"; 
        WebElement textImput = driver.findElement(By.id("mainsearch-input"));
        textImput.sendKeys(txtSearch);
        Thread.sleep(3000);
        WebElement botonEnviar = driver.findElement(By.xpath(".//button[@type='submit'][@class='primary']"));
        botonEnviar.click();
        //Thread.sleep(3000);
        WebElement resultadoBusqueda = driver.findElement(By.id("search_results_count"));
        assertNotEquals(txtSearch, resultadoBusqueda.getText());
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void CPF4() throws InterruptedException {
        WebElement enlaceAyda = driver.findElement(By.className("secondary"));
        enlaceAyda.click();
        Thread.sleep(3000);
        WebElement resultadoOfertas = driver.findElement(By.xpath(".//div[@class='container-principal']//h1"));
        Thread.sleep(3000);
        assertNotEquals(resultadoOfertas.getText(), "Todas las ofertas online");
        Thread.sleep(3000);
        driver.quit();
    }
}