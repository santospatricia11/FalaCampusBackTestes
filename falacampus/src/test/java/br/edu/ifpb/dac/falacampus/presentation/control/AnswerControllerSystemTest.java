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
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

class AnswerControllerSystemTest {

	private static WebDriver driver;
	private static final String URL = "http://localhost:3000/createAnswer";
	
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
	@DisplayName("Screen Create Answer Valid")
	void createAnswerWithValidField() throws InterruptedException {
		driver.get(URL);
		
		WebElement selectComment = driver.findElement(By.id("selectCommentType"));
		Select selectComentario = new Select(selectComment);
		selectComentario.selectByIndex(2);
		
		WebElement inputAnswer = driver.findElement(By.id("MessageTextarea"));
		inputAnswer.sendKeys("Aqui estamos nnn hhju yyy colocando a resposta para o comentário selecionado no sistema FalaCampus.");
		
		WebElement selectAuthor = driver.findElement(By.id("inputAutor"));
		Select selectAutor = new Select(selectAuthor);
		selectAutor.selectByIndex(2);	
		
		WebElement buttonSave = driver.findElement(By.id("btn-answer"));
		buttonSave.click();
		
		Thread.sleep(5000);
		String toastTitle = driver.findElement(By.className("toast-title")).getText();
		String toastMessage = driver.findElement(By.className("toast-message")).getText();
		System.out.println("Title of the toast message is: "+toastTitle);
		System.out.println("Message of the toast message is: "+toastMessage);
		
		Assert.assertEquals(toastTitle, "Sucesso");
		Assert.assertEquals(toastMessage, "Comentário respondido!");
		Thread.sleep(5000);
		
	}
	
	@Test
	@DisplayName("Resposta curta")
	void createAnswerWithInvalidField() throws InterruptedException {
		driver.get(URL);
		
		WebElement selectComment = driver.findElement(By.id("selectCommentType"));
		Select selectComentario = new Select(selectComment);
		selectComentario.selectByIndex(3);
		
		WebElement inputAnswer = driver.findElement(By.id("MessageTextarea"));
		inputAnswer.sendKeys("Ok");//Resposta muito curta
		
		WebElement selectAuthor = driver.findElement(By.id("inputAutor"));
		Select selectAutor = new Select(selectAuthor);
		selectAutor.selectByIndex(3);	
		
		WebElement buttonSave = driver.findElement(By.id("btn-answer"));
		buttonSave.click();
		
		Thread.sleep(5000);
		String toastTitle = driver.findElement(By.className("toast-title")).getText();
		String toastMessage = driver.findElement(By.className("toast-message")).getText();
		System.out.println("Title of the toast message is: "+toastTitle);
		System.out.println("Message of the toast message is: "+toastMessage);
		
		Assert.assertEquals(toastTitle, "Erro");
		Assert.assertEquals(toastMessage, "A Mensagem da Resposta deve ter no mínimo 10 e no máximo 255 caracteres!");
		Thread.sleep(5000);
		
	}
	
	
	@Test
	void pressButtonCancel() throws InterruptedException {
		driver.get(URL);
		Thread.sleep(4000);
		WebElement buttonCancel = driver.findElement(By.id("btn-cancel"));
		buttonCancel.click();
		
		Thread.sleep(2000);
		driver.close();
	
	}

}
