package br.edu.ifpb.dac.falacampus.testeselenium;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ifpb.dac.falacampus.business.service.UserService;
import br.edu.ifpb.dac.falacampus.model.entity.User;

class CreateUserSelenium {

	private static WebDriver driver;

	@Autowired
	private UserService userService;

	private User user;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	@EnabledOnOs(value = OS.WINDOWS)

	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();

	}

//	@Test

	@Test
	void seveUser() {
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();
		driver.get("http://localhost:3000/createUser");

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
		senha.sendKeys("12345666999");

		WebElement selectDepartment = driver.findElement(By.id("inputIdDepartament"));
		Select select2 = new Select(selectDepartment);
		select2.selectByIndex(2);

		WebElement salvar = driver.findElement(By.className("btn btn-success"));
		salvar.click();

	}

	@Test
	void cancelarButtonCreateUser() {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver browser = new ChromeDriver();
		browser.navigate().to("http://localhost:3000/createUser");

		WebElement cancel = driver.findElement(By.className("btn btn-danger btn-cancel"));
		cancel.click();
		browser.navigate().to("http://localhost:3000");
	}
	@Test
	void updateUser() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver browser =  new ChromeDriver();
		driver.navigate().to("http://localhost:3000/viewUser");

		
		List<WebElement> editar = driver.findElements(By.className("btn btn-warning"));

	
		editar.get(0).click();
	}

	@AfterEach
	void tearDown() {
		driver.quit();

	}
}
