package br.edu.ifpb.dac.falacampus.presentation.control;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

class CommentControllerSystemTest {

	@Test
	void savingCommentWithValidFields() {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver browser =  new ChromeDriver();
		browser.navigate().to("http://localhost:3000/createComment");
		
		WebElement inputTitle = browser.findElement(By.id("inputCommentTitle"));		
		inputTitle.sendKeys("Nataly");
		
		WebElement message = browser.findElement(By.id("MessageTextarea"));
		message.sendKeys("Aqui e o texto");
		
		WebElement selectType = browser.findElement(By.id("selectCommentType"));
		Select select = new Select(selectType);
		select.selectByIndex(3);
		
		WebElement selectAuthor = browser.findElement(By.id("inputUserAuthor"));
		Select select1 = new Select(selectAuthor);
		select1.selectByIndex(2);
		
		WebElement selectDepartment = browser.findElement(By.id("inputDepartamentDestination"));
		Select select2 = new Select(selectDepartment);
		select2.selectByIndex(3);
		
		WebElement buttonSave = browser.findElement(By.id("button_salvar"));
		buttonSave.click();		
	}
	
	@Test
	void testingCancelButtonOnTheCreateCommentScreen() {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver browser =  new ChromeDriver();
		browser.navigate().to("http://localhost:3000/createComment");
		
		WebElement inputTitle = browser.findElement(By.id("inputCommentTitle"));		
		inputTitle.sendKeys("Nataly");
		
		WebElement message = browser.findElement(By.id("MessageTextarea"));
		message.sendKeys("Mensagem cancelada");
		
		WebElement selectType = browser.findElement(By.id("selectCommentType"));
		Select select = new Select(selectType);
		select.selectByIndex(1);
		
		WebElement buttonCancel = browser.findElement(By.id("button_cancelar"));
		buttonCancel.click();
		browser.navigate().to("http://localhost:3000");
	}
	
	@Test
	void tryingToSaveCommentWithInvalidFields() {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver browser =  new ChromeDriver();
		browser.navigate().to("http://localhost:3000/createComment");
		
		WebElement inputTitle = browser.findElement(By.id("inputCommentTitle"));		
		inputTitle.sendKeys("A");
		
		WebElement message = browser.findElement(By.id("MessageTextarea"));
		message.sendKeys("Oi");
		
		WebElement buttonSave = browser.findElement(By.id("button_salvar"));
		buttonSave.click();		
		
		//pause(browser,10);
	}
	
	
	

	private void pause(WebDriver browser, int time) {
		browser.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
}
