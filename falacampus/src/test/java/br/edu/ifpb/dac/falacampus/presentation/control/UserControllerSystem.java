package br.edu.ifpb.dac.falacampus.presentation.control;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ifpb.dac.falacampus.business.service.UserService;
import br.edu.ifpb.dac.falacampus.model.entity.User;
/*
 * Testes da tela criar usuário
 */
class UserControllerSystem {
	private static WebDriver driver;
	private static final String URL = "http://localhost:3000/createUser";

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
	void createUserWithInvalidFields() throws InterruptedException {
		driver.get(URL);

		WebElement name = driver.findElement(By.id("inputUserName"));
		name.sendKeys("Patricia");

		WebElement email = driver.findElement(By.id("inputEmail"));
		email.sendKeys("patricia@pereira");

		WebElement matricula = driver.findElement(By.id("inputRegistration"));
		matricula.sendKeys("12345666999");

		WebElement papel = driver.findElement(By.id("selectRole"));
		Select select = new Select(papel);
		select.selectByIndex(1);

		WebElement senha = driver.findElement(By.id("inputPassword"));
		senha.sendKeys("AAee#12345666999*");

		WebElement departament = driver.findElement(By.id("inputIdDepartament"));
		Select select1 = new Select(departament);
		select1.selectByIndex(2);
		
		WebElement saveButton = driver.findElement(By.id("buttonSalvar"));
		saveButton.click();

		Thread.sleep(3000);
		
		driver.close();
	}

	@Test
	void createUserWithValidFields() throws InterruptedException {
		driver.get(URL);

		WebElement name = driver.findElement(By.id("inputUserName"));
		name.sendKeys("Patricia");

		WebElement email = driver.findElement(By.id("inputEmail"));
		email.sendKeys("patricia@pereira.com");

		WebElement matricula = driver.findElement(By.id("inputRegistration"));
		matricula.sendKeys("12345666999");

		WebElement papel = driver.findElement(By.id("selectRole"));
		Select select = new Select(papel);
		select.selectByIndex(1);

		WebElement senha = driver.findElement(By.id("inputPassword"));
		senha.sendKeys("AAee#12345666999*");

		WebElement departament = driver.findElement(By.id("inputIdDepartament"));
		Select select1 = new Select(departament);
		select1.selectByIndex(2);
		
		WebElement saveButton = driver.findElement(By.id("buttonSalvar"));
		saveButton.click();

		Thread.sleep(3000);
		
		driver.close();
	} 

	@Test
	void createUserWithInvalid() throws InterruptedException {
		driver.get(URL);

		WebElement name = driver.findElement(By.id("inputUserName"));
		name.sendKeys("Patricia");

		WebElement email = driver.findElement(By.id("inputEmail"));
		email.sendKeys("patricia@pereira.com");

		WebElement matricula = driver.findElement(By.id("inputRegistration"));
		matricula.sendKeys("12345666999");

		WebElement papel = driver.findElement(By.id("selectRole"));
		Select select = new Select(papel);
		select.selectByIndex(1);

		WebElement senha = driver.findElement(By.id("inputPassword"));
		senha.sendKeys("ee#12345666999");

		WebElement departament = driver.findElement(By.id("inputIdDepartament"));
		Select select1 = new Select(departament);
		select1.selectByIndex(2);
		
		WebElement saveButton = driver.findElement(By.id("buttonSalvar"));
		saveButton.click();

		Thread.sleep(3000);
		
		driver.close();
	}

	@Test
	void cancelarButtonCreateUser() throws InterruptedException {
		driver.get(URL);

		WebElement cancel = driver.findElement(By.id("buttonCancelar"));
		cancel.click();
		
		driver.navigate().to("http://localhost:3000");
		

	}
	@Test
	void createNovoUser() throws InterruptedException {
		driver.get(URL);

		driver.get("http://localhost:3000/viewUsers");
		WebElement cadastrarNovoUser = driver.findElement(By.id("idNovoUser"));
		Thread.sleep(3000);
		cadastrarNovoUser.click();

		WebElement name = driver.findElement(By.id("inputUserName"));
		name.sendKeys("Patricia");

		WebElement email = driver.findElement(By.id("inputEmail"));
		email.sendKeys("patricia@pereira.com");

		WebElement matricula = driver.findElement(By.id("inputRegistration"));
		matricula.sendKeys("12345666999");

		WebElement papel = driver.findElement(By.id("selectRole"));
		Select select = new Select(papel);
		select.selectByIndex(1);

		WebElement senha = driver.findElement(By.id("inputPassword"));
		senha.sendKeys("AAee#12345666999*");

		WebElement departament = driver.findElement(By.id("inputIdDepartament"));
		Select select1 = new Select(departament);
		select1.selectByIndex(1);

		WebElement saveButton = driver.findElement(By.id("buttonSalvar"));
		saveButton.click();
		driver.get("http://localhost:3000");
		driver.close();
	

	}



}
