package br.edu.ifpb.dac.falacampus.presentation.control;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class CommentControllerSystemTest2 {

	@Test
	void createNewComment() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver browser =  new ChromeDriver();
		browser.navigate().to("http://localhost:3000/viewComments");
		
		WebElement buttonCreateNewComment = browser.findElement(By.id("cadastrar_comentario"));
		buttonCreateNewComment.click();
		
	}
	
	@Test
	void deleteComment() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver browser =  new ChromeDriver();
		browser.navigate().to("http://localhost:3000/viewComments");
		
		// lista com todos os botoes excluir
		List<WebElement> excluir = browser.findElements(By.id("button_excluir"));
		 
		// Excluir a primeira linha
     	excluir.get(0).click();
		
		browser.navigate().to("http://localhost:3000/viewComments");
		
	}
	
	@Test
	void answerComment() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver browser =  new ChromeDriver();
		browser.navigate().to("http://localhost:3000/viewComments");
		
		// lista com todos os botoes responder
		List<WebElement> responder = browser.findElements(By.id("button_responder"));
		 
		// responder a primeira linha
		responder.get(0).click();
				
	}
	
	@Test
	void updateComment() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver browser =  new ChromeDriver();
		browser.navigate().to("http://localhost:3000/viewComments");
		
		// lista com todos os botoes editar
		List<WebElement> editar = browser.findElements(By.id("button_editar"));
		 
		// editar a primeira linha
		editar.get(0).click();
	}

}
