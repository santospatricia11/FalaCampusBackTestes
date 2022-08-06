package br.edu.ifpb.dac.falacampus.presentation.control;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//Testes da tela de Listar Comentários
class CommentControllerSystemTest2 {

	@Test
	void createNewComment() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver browser =  new ChromeDriver();
		browser.navigate().to("http://localhost:3000/viewComments");
		
		pause(browser,40);
		
		WebElement buttonCreateNewComment = browser.findElement(By.id("cadastrar_comentario"));
		
		pause(browser,30);
		
		buttonCreateNewComment.click();
		
		pause(browser,30);
		
	}
	
	@Test
	void deleteComment() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver browser =  new ChromeDriver();
		browser.navigate().to("http://localhost:3000/viewComments");
		
		pause(browser,30);
		
		// lista com todos os botoes excluir
		List<WebElement> excluir = browser.findElements(By.id("button_excluir"));
		 
		pause(browser,40);
		
		// Excluir a primeira linha
     	excluir.get(0).click();
     	
     	pause(browser,30);
		
		browser.navigate().to("http://localhost:3000/viewComments");
		
	}
	
	@Test
	void answerComment() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver browser =  new ChromeDriver();
		browser.navigate().to("http://localhost:3000/viewComments");
		
		pause(browser,30);
		
		// lista com todos os botoes responder
		List<WebElement> responder = browser.findElements(By.id("button_responder"));
		 
		pause(browser,40);
		
		// responder a primeira linha
		responder.get(0).click();
		
		pause(browser,30);
				
	}
	
	@Test
	void updateComment() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver browser =  new ChromeDriver();
		browser.navigate().to("http://localhost:3000/viewComments");
		
		pause(browser,30);
		
		// lista com todos os botoes editar
		List<WebElement> editar = browser.findElements(By.id("button_editar"));
		 
		pause(browser,40);
		
		// editar a primeira linha
		editar.get(0).click();
		
		pause(browser,30);
	}
	
	private void pause(WebDriver browser, int time) {
		browser.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

}
