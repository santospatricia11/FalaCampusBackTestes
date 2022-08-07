package br.edu.ifpb.dac.falacampus.presentation.control;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.assertj.core.api.Assertions;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

class DepartamentControllerSystemTest {


	private static WebDriver driver;
	private static final String URL_CREATE_DEPARTAMENT = "http://localhost:3000/createDepartament";
	private static final String URL_VIEW_DEPARTAMENTS = "http://localhost:3000/viewDepartaments";
	
	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	
	@AfterAll
	static void tearDown() {
		
		driver.quit();
	}

	@Test
	@DisplayName("Screen Create Departament Valid")
	void createDepartamentWithValidField() throws InterruptedException {
		driver.get(URL_CREATE_DEPARTAMENT);
				
		WebElement inputText = driver.findElement(By.id("inputDepartamentName"));
		inputText.sendKeys("Direção Geral");
		
		WebElement buttonSave = driver.findElement(By.id("button-save"));
		buttonSave.click();
		
		Thread.sleep(5000);
		String toastTitle = driver.findElement(By.className("toast-title")).getText();
		String toastMessage = driver.findElement(By.className("toast-message")).getText();
		System.out.println("Title of the toast message is: "+toastTitle);
		System.out.println("Message of the toast message is: "+toastMessage);
		
		Assert.assertEquals(toastTitle, "Sucesso");
		Assert.assertEquals(toastMessage, "Departamento criado com sucesso!");
		
		driver.close();
	}
	
	@Test
	@DisplayName("With 1 character in name field")
	void createDepartamentWithOneCharactersInNameField() throws InterruptedException {
		driver.get(URL_CREATE_DEPARTAMENT);
		
		WebElement inputText = driver.findElement(By.id("inputDepartamentName"));
		inputText.sendKeys("A");
		
		WebElement buttonSave = driver.findElement(By.id("button-save"));
		buttonSave.click();
		
		Thread.sleep(5000);
		String toastTitle = driver.findElement(By.className("toast-title")).getText();
		String toastMessage = driver.findElement(By.className("toast-message")).getText();
		
		Assert.assertEquals(toastTitle, "Erro");
		Assert.assertEquals(toastMessage, "O Nome do Departamento deve ter no mínimo 2 e no máximo 100 caracteres!");
		
		Thread.sleep(2000);
		
		driver.close();
	}
	
	@Test
	@DisplayName("With 102 characters in name field")
	void createDepartamentWithWithCharactersAboveTheMaximum() throws InterruptedException {
		driver.get(URL_CREATE_DEPARTAMENT);
		
		WebElement inputText = driver.findElement(By.id("inputDepartamentName"));
		inputText.sendKeys("Aliquam a eros quis ante aliquet tempus. Vestibulum sagittis,"
				+ " arcu at ultrices bibendum, sem magna malesuada nibh, sit.");
		
		WebElement buttonSave = driver.findElement(By.id("button-save"));
		buttonSave.click();
		
		Thread.sleep(5000);
		String toastTitle = driver.findElement(By.className("toast-title")).getText();
		String toastMessage = driver.findElement(By.className("toast-message")).getText();
		
		Assert.assertEquals(toastTitle, "Erro");
		Assert.assertEquals(toastMessage, "O Nome do Departamento deve ter no mínimo 2 e no máximo 100 caracteres!");
		
		Thread.sleep(2000);
		
		driver.close();
	}
	
	@Test
	@DisplayName("With Empty Name Field")
	void createDepartamentWithEmptyNameField() throws InterruptedException {
		driver.get(URL_CREATE_DEPARTAMENT);
		
		WebElement inputText = driver.findElement(By.id("inputDepartamentName"));
		inputText.sendKeys(" ");
		
		WebElement buttonSave = driver.findElement(By.id("button-save"));
		buttonSave.click();
		
		Thread.sleep(5000);
		String toastTitle = driver.findElement(By.className("toast-title")).getText();
		String toastMessage = driver.findElement(By.className("toast-message")).getText();
		
		Assert.assertEquals(toastTitle, "Erro");
		Assert.assertEquals(toastMessage, "O Nome do Departamento deve ter no mínimo 2 e no máximo 100 caracteres!");
		
		Thread.sleep(2000);
		
		driver.close();
	}
	
	@Test
	void pressButtonCancel() throws InterruptedException {
		driver.get(URL_CREATE_DEPARTAMENT);
		Thread.sleep(5000);
		WebElement buttonCancel = driver.findElement(By.id("buttonCancel"));
		buttonCancel.click();
		
		Thread.sleep(5000);
		driver.close();
	
	}
	
	//Tela listar departamentos
	
	@Test
	@DisplayName("Create new Departament")
	void createNewDepartament() throws InterruptedException {
		driver.get(URL_VIEW_DEPARTAMENTS);
		Thread.sleep(3000);
		WebElement buttonCreateNewDepartament = driver.findElement(By.id("btn-cadastrar"));
		buttonCreateNewDepartament.click();
		Thread.sleep(3000);
	}
	
	@Test
	@DisplayName("Delete Departament")
	void deleteDepartament() throws InterruptedException {
		driver.get(URL_VIEW_DEPARTAMENTS);
		
		Thread.sleep(3000);
		List<WebElement> excluir = driver.findElements(By.id("button_excluir"));
		 
     	excluir.get(6).click();
		
		driver.navigate().to("http://localhost:3000/viewDepartaments");
		
	}
	
	@Test
	@DisplayName("Update Departament")
	void updateComment() throws InterruptedException {
		driver.get(URL_VIEW_DEPARTAMENTS);
		Thread.sleep(3000);
		List<WebElement> editar = driver.findElements(By.id("button_editar"));
		 
		editar.get(1).click();
		Thread.sleep(3000);
	}

}
