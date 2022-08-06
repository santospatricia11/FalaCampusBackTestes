package br.edu.ifpb.dac.falacampus.presentation.control;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

//Testes da tela de Cadastrar Comentário
class CommentControllerSystemTest {

	@Test
	void savingCommentWithValidFields() {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver browser =  new ChromeDriver();
		browser.navigate().to("http://localhost:3000/createComment");
		
		pause(browser,30);
		
		WebElement inputTitle = browser.findElement(By.id("inputCommentTitle"));		
		inputTitle.sendKeys("Biblioteca");
		
		pause(browser,30);
		
		WebElement message = browser.findElement(By.id("MessageTextarea"));
		message.sendKeys("Os livros da biblioteca sao muito bons e o ambiente é agradavel");
		
		pause(browser,30);
		
		WebElement selectType = browser.findElement(By.id("selectCommentType"));
		Select select = new Select(selectType);
		select.selectByIndex(3);
		
		pause(browser,30);
		
		WebElement selectAuthor = browser.findElement(By.id("inputUserAuthor"));
		Select select1 = new Select(selectAuthor);
		select1.selectByIndex(19);
		
		pause(browser,30);
		
		WebElement selectDepartment = browser.findElement(By.id("inputDepartamentDestination"));
		Select select2 = new Select(selectDepartment);
		select2.selectByIndex(1);
		
		pause(browser,40);
		
		WebElement buttonSave = browser.findElement(By.id("button_salvar"));
		buttonSave.click();	
		
		pause(browser,30);
	}
	
	@Test
	void tryingToSaveCommentWithInvalidFields() {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver browser =  new ChromeDriver();
		browser.navigate().to("http://localhost:3000/createComment");
		
		pause(browser,30);
		
		WebElement inputTitle = browser.findElement(By.id("inputCommentTitle"));		
		inputTitle.sendKeys("A");
		
		pause(browser,30);
		
		WebElement message = browser.findElement(By.id("MessageTextarea"));
		message.sendKeys("Oi");
		
		pause(browser,40);
		
		WebElement buttonSave = browser.findElement(By.id("button_salvar"));
		buttonSave.click();		
		
		pause(browser,60);
	}
	
	@Test
	void tryingToSaveCommentWithInvalidTitleField() { // Título: 5 - 50 caracteres

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver browser =  new ChromeDriver();
		browser.navigate().to("http://localhost:3000/createComment");
		
		pause(browser,30);
		
		WebElement inputTitle = browser.findElement(By.id("inputCommentTitle"));		
		inputTitle.sendKeys("Ola");
		
		pause(browser,30);
		
		WebElement message = browser.findElement(By.id("MessageTextarea"));
		message.sendKeys("Os computadores do Laboratório de ADS estão muito bons");
		
		pause(browser,30);
		
		WebElement selectType = browser.findElement(By.id("selectCommentType"));
		Select select = new Select(selectType);
		select.selectByIndex(3);
		
		pause(browser,30);
		
		WebElement selectAuthor = browser.findElement(By.id("inputUserAuthor"));
		Select select1 = new Select(selectAuthor);
		select1.selectByIndex(19);
		
		pause(browser,30);
		
		WebElement selectDepartment = browser.findElement(By.id("inputDepartamentDestination"));
		Select select2 = new Select(selectDepartment);
		select2.selectByIndex(4);
		
		pause(browser,40);
		
		WebElement buttonSave = browser.findElement(By.id("button_salvar"));
		buttonSave.click();	
		
		pause(browser,50);
	}
	
	@Test
	void tryingToSaveCommentWithInvalidMessageField() { // Mensagem: 10 - 255 caracteres

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver browser =  new ChromeDriver();
		browser.navigate().to("http://localhost:3000/createComment");
		
		pause(browser,30);
		
		WebElement inputTitle = browser.findElement(By.id("inputCommentTitle"));		
		inputTitle.sendKeys("Computadores");
		
		pause(browser,30);
		
		WebElement message = browser.findElement(By.id("MessageTextarea"));
		message.sendKeys("Oi");
		
		pause(browser,30);
		
		WebElement selectType = browser.findElement(By.id("selectCommentType"));
		Select select = new Select(selectType);
		select.selectByIndex(3);
		
		pause(browser,30);
		
		WebElement selectAuthor = browser.findElement(By.id("inputUserAuthor"));
		Select select1 = new Select(selectAuthor);
		select1.selectByIndex(19);
		
		pause(browser,30);
		
		WebElement selectDepartment = browser.findElement(By.id("inputDepartamentDestination"));
		Select select2 = new Select(selectDepartment);
		select2.selectByIndex(4);
		
		pause(browser,40);
		
		WebElement buttonSave = browser.findElement(By.id("button_salvar"));
		buttonSave.click();	
		
		pause(browser,50);
	}
	
	@Test
	void tryingToSaveCommentWithoutSelectingCommentType() { // sem tipo de comentário

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver browser =  new ChromeDriver();
		browser.navigate().to("http://localhost:3000/createComment");
		
		pause(browser,30);
		
		WebElement inputTitle = browser.findElement(By.id("inputCommentTitle"));		
		inputTitle.sendKeys("Computadores");
		
		pause(browser,30);
		
		WebElement message = browser.findElement(By.id("MessageTextarea"));
		message.sendKeys("Os computadores do Laboratório de ADS estão muito bons");
		
		pause(browser,30);
		
		WebElement selectAuthor = browser.findElement(By.id("inputUserAuthor"));
		Select select1 = new Select(selectAuthor);
		select1.selectByIndex(19);
		
		pause(browser,30);
		
		WebElement selectDepartment = browser.findElement(By.id("inputDepartamentDestination"));
		Select select2 = new Select(selectDepartment);
		select2.selectByIndex(4);
		
		pause(browser,40);
		
		WebElement buttonSave = browser.findElement(By.id("button_salvar"));
		buttonSave.click();	
		
		pause(browser,50);
	}
	
	@Test
	void tryingToSaveCommentWithoutSelectingCommentAuthor() { // sem autor do comentário

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver browser =  new ChromeDriver();
		browser.navigate().to("http://localhost:3000/createComment");
		
		pause(browser,30);
		
		WebElement inputTitle = browser.findElement(By.id("inputCommentTitle"));		
		inputTitle.sendKeys("Computadores");
		
		pause(browser,30);
		
		WebElement message = browser.findElement(By.id("MessageTextarea"));
		message.sendKeys("Os computadores do Laboratório de ADS estão muito bons");
		
		pause(browser,30);
		
		WebElement selectType = browser.findElement(By.id("selectCommentType"));
		Select select = new Select(selectType);
		select.selectByIndex(3);
		
		pause(browser,30);
		
		WebElement selectDepartment = browser.findElement(By.id("inputDepartamentDestination"));
		Select select2 = new Select(selectDepartment);
		select2.selectByIndex(4);
		
		pause(browser,40);
		
		WebElement buttonSave = browser.findElement(By.id("button_salvar"));
		buttonSave.click();	
		
		pause(browser,50);
	}
	
	@Test
	void tryingToSaveCommentWithoutSelectingDepartamentDestination() { // sem o Departamento de destino

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver browser =  new ChromeDriver();
		browser.navigate().to("http://localhost:3000/createComment");
		
		pause(browser,30);
		
		WebElement inputTitle = browser.findElement(By.id("inputCommentTitle"));		
		inputTitle.sendKeys("Computadores");
		
		pause(browser,30);
		
		WebElement message = browser.findElement(By.id("MessageTextarea"));
		message.sendKeys("Os computadores do Laboratório de ADS estão muito bons");
		
		pause(browser,30);
		
		WebElement selectType = browser.findElement(By.id("selectCommentType"));
		Select select = new Select(selectType);
		select.selectByIndex(3);
		
		pause(browser,30);
		
		WebElement selectAuthor = browser.findElement(By.id("inputUserAuthor"));
		Select select1 = new Select(selectAuthor);
		select1.selectByIndex(19);
		
		pause(browser,40);
		
		WebElement buttonSave = browser.findElement(By.id("button_salvar"));
		buttonSave.click();	
		
		pause(browser,50);
	}
	
	@Test
	void testingCancelButtonOnTheCreateCommentScreen() {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver browser =  new ChromeDriver();
		browser.navigate().to("http://localhost:3000/createComment");
		
		pause(browser,30);
		
		WebElement inputTitle = browser.findElement(By.id("inputCommentTitle"));		
		inputTitle.sendKeys("Laboratório de Informática");
		
		pause(browser,30);
		
		WebElement message = browser.findElement(By.id("MessageTextarea"));
		message.sendKeys("Mensagem cancelada");
		
		pause(browser,30);
		
		WebElement selectType = browser.findElement(By.id("selectCommentType"));
		Select select = new Select(selectType);
		select.selectByIndex(2);
		
		pause(browser,40);
		
		WebElement buttonCancel = browser.findElement(By.id("button_cancelar"));
		buttonCancel.click();
		browser.navigate().to("http://localhost:3000");
		
		pause(browser,30);
	}
	
	private void pause(WebDriver browser, int time) {
		browser.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
}
