package br.edu.ifpb.dac.falacampus.testeselenium;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ifpb.dac.falacampus.business.service.UserService;
import br.edu.ifpb.dac.falacampus.model.entity.User;

class ListaUserSelenium {
	private static WebDriver driver;

	@Autowired
	private UserService userService;

	private User user;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	void listarUser() {
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://localhost:3000/viewUsers");
		
		WebElement name = driver.findElement(By.id("inputUserName"));
		name.sendKeys("Patricia");
		
//		WebElement pesquisar= driver.findElement(By.className("btn btn-info"));
//		pesquisar.click();
		WebElement pesquisar = driver.findElement(By.cssSelector("button[type='btn btn-info']"));
		pesquisar.click();


	}
	
	
	@Test
	void cadastrarNovoUser() {
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		
		driver.get("http://localhost:3000/viewUsers");
		WebElement cadastrarNovoUser = driver.findElement(By.cssSelector("btn btn-success btn-cadastrar']"));
		cadastrarNovoUser.click();
		driver.get("http://localhost:3000/crateUser");
	}
	

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
