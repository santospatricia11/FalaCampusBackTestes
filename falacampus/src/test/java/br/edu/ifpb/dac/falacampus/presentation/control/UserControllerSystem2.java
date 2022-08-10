package br.edu.ifpb.dac.falacampus.presentation.control;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

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
 * Testes da tela listar usuário
 */
class UserControllerSystem2 {
	private static WebDriver driver;
	private static final String URL = "http://localhost:3000/viewUsers";

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
	void testButtonSearchUser() throws InterruptedException {
		driver.get(URL);

		WebElement name = driver.findElement(By.id("inputUserName"));
		name.sendKeys("Patricia");

		WebElement pesquisar = driver.findElement(By.id("idPesquisar"));
		pesquisar.click();

		Thread.sleep(2000);
		driver.close();
	}

	@Test
	void testButtonCreateNewUser() throws InterruptedException {
		driver.get(URL);

		WebElement cadastrarNovoUser = driver.findElement(By.id("idNovoUser"));
		cadastrarNovoUser.click();

		Thread.sleep(3000);
		driver.navigate().to("http://localhost:3000/createUser");
		Thread.sleep(2000);
		driver.close();
	}

	@Test
	void updateUser() throws InterruptedException {
		driver.get(URL);

		Thread.sleep(3000);
		List<WebElement> editar = driver.findElements(By.id("idEdit"));

		editar.get(1).click();
		Thread.sleep(3000);
		driver.close();

	}

	@Test
	void deleteUser() throws InterruptedException {
		driver.get(URL);

		Thread.sleep(3000);

		// lista com todos os botoes excluir
		List<WebElement> excluir = driver.findElements(By.id("idExcluir"));

		Thread.sleep(3000);

		// Excluir a primeira linha
		excluir.get(0).click();

		Thread.sleep(3000);

		driver.navigate().to("http://localhost:3000/viewUser");
	}

	// Testando o botão Cancelar - Tela Atualizar Usuario
	@Test
	void testingCancelButtonOnTheUpdateUserScreen() throws InterruptedException {

		driver.get(URL);
		Thread.sleep(3000);
		// lista com todos os botoes editar
		List<WebElement> editar = driver.findElements(By.id("idEdit"));
		Thread.sleep(3000);

		// editar a primeira linha
		editar.get(1).click();

		Thread.sleep(3000);

	}

}
