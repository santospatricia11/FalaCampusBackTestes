package br.edu.ifpb.dac.falacampus.testeselenium;

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

class CancelarUserSelenium {
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
	void canceleUser() throws InterruptedException {

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

		WebElement departament = driver.findElement(By.id("inputIdDepartament"));
		Select select1 = new Select(departament);
		select1.selectByIndex(2);
		Thread.sleep(5000);
		WebElement cancelar = driver.findElement(By.className("pi pi-times"));
		cancelar.click();

	}

	@Test
	void deleteUser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://localhost:3000/viewUser");

		List<WebElement> excluir = driver.findElements(By.id("idExcluir"));

		// Excluir o primeiro user da list

		excluir.get(2).click();

		driver.navigate().to("http://localhost:3000/viewUser");
		Thread.sleep(5000);
	}

}
