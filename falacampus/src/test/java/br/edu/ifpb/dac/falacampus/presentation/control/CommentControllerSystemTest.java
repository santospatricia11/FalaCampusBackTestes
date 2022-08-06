package br.edu.ifpb.dac.falacampus.presentation.control;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

class CommentControllerSystemTest {
	
	//Método para pausar algumas partes do testes
	private void pause(WebDriver browser, int time) {
		browser.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	//****Testes da Tela de Cadastrar Comentário****
	
	@Test
	void savingCommentWithValidFields() {

		//Comentário com todos os campos válidos
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver browser = new ChromeDriver();
		browser.navigate().to("http://localhost:3000/createComment");

		pause(browser, 30);

		WebElement inputTitle = browser.findElement(By.id("inputCommentTitle"));
		inputTitle.sendKeys("Biblioteca");

		pause(browser, 30);

		WebElement message = browser.findElement(By.id("MessageTextarea"));
		message.sendKeys("Os livros da biblioteca sao muito bons e o ambiente é agradavel");

		pause(browser, 30);

		WebElement selectType = browser.findElement(By.id("selectCommentType"));
		Select select = new Select(selectType);
		select.selectByIndex(3);

		pause(browser, 30);

		WebElement selectAuthor = browser.findElement(By.id("inputUserAuthor"));
		Select select1 = new Select(selectAuthor);
		select1.selectByIndex(19);

		pause(browser, 30);

		WebElement selectDepartment = browser.findElement(By.id("inputDepartamentDestination"));
		Select select2 = new Select(selectDepartment);
		select2.selectByIndex(1);

		pause(browser, 40);

		WebElement buttonSave = browser.findElement(By.id("button_salvar"));
		buttonSave.click();

		pause(browser, 30);
	}

	// Comentário com todos os campos inválidos
	@Test
	void tryingToSaveCommentWithInvalidFields() {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver browser = new ChromeDriver();
		browser.navigate().to("http://localhost:3000/createComment");

		pause(browser, 30);

		WebElement inputTitle = browser.findElement(By.id("inputCommentTitle"));
		inputTitle.sendKeys("A");

		pause(browser, 30);

		WebElement message = browser.findElement(By.id("MessageTextarea"));
		message.sendKeys("Oi");

		pause(browser, 40);

		WebElement buttonSave = browser.findElement(By.id("button_salvar"));
		buttonSave.click();

		pause(browser, 60);
	}

	// Título: 5 - 50 caracteres; campo obrigatório
	@Test
	void tryingToSaveCommentWithoutTheTitleField() {

		// Campo Título Nulo/Vazio

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver browser = new ChromeDriver();
		browser.navigate().to("http://localhost:3000/createComment");

		pause(browser, 30);

		WebElement inputTitle = browser.findElement(By.id("inputCommentTitle"));
		inputTitle.sendKeys(""); // sem preencher

		pause(browser, 30);

		WebElement message = browser.findElement(By.id("MessageTextarea"));
		message.sendKeys("Os computadores do Laboratório de ADS estão muito bons");

		pause(browser, 30);

		WebElement selectType = browser.findElement(By.id("selectCommentType"));
		Select select = new Select(selectType);
		select.selectByIndex(3);

		pause(browser, 30);

		WebElement selectAuthor = browser.findElement(By.id("inputUserAuthor"));
		Select select1 = new Select(selectAuthor);
		select1.selectByIndex(19);

		pause(browser, 30);

		WebElement selectDepartment = browser.findElement(By.id("inputDepartamentDestination"));
		Select select2 = new Select(selectDepartment);
		select2.selectByIndex(4);

		pause(browser, 40);

		WebElement buttonSave = browser.findElement(By.id("button_salvar"));
		buttonSave.click();

		pause(browser, 50);
	}

	// Título: 5 - 50 caracteres; campo obrigatório
	@Test
	void tryingToSaveCommentWithFourCharactersInTheTitleField() {

		// Campo Título com 4 caracteres

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver browser = new ChromeDriver();
		browser.navigate().to("http://localhost:3000/createComment");

		pause(browser, 30);

		WebElement inputTitle = browser.findElement(By.id("inputCommentTitle"));
		inputTitle.sendKeys("Olaa"); // 4 caracteres

		pause(browser, 30);

		WebElement message = browser.findElement(By.id("MessageTextarea"));
		message.sendKeys("Os computadores do Laboratório de ADS estão muito bons");

		pause(browser, 30);

		WebElement selectType = browser.findElement(By.id("selectCommentType"));
		Select select = new Select(selectType);
		select.selectByIndex(3);

		pause(browser, 30);

		WebElement selectAuthor = browser.findElement(By.id("inputUserAuthor"));
		Select select1 = new Select(selectAuthor);
		select1.selectByIndex(19);

		pause(browser, 30);

		WebElement selectDepartment = browser.findElement(By.id("inputDepartamentDestination"));
		Select select2 = new Select(selectDepartment);
		select2.selectByIndex(4);

		pause(browser, 40);

		WebElement buttonSave = browser.findElement(By.id("button_salvar"));
		buttonSave.click();

		pause(browser, 50);
	}

	// Título: 5 - 50 caracteres; campo obrigatório
	@Test
	void tryingToSaveCommentWithFiftyOneCharactersInTheTitleField() {

		// Campo Título com 51 caracteres

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver browser = new ChromeDriver();
		browser.navigate().to("http://localhost:3000/createComment");

		pause(browser, 30);

		WebElement inputTitle = browser.findElement(By.id("inputCommentTitle"));
		inputTitle.sendKeys("Sobre os computadores do laboratorio cinco de ADS!!"); // 51 caracteres

		pause(browser, 30);

		WebElement message = browser.findElement(By.id("MessageTextarea"));
		message.sendKeys("Os computadores do Laboratório de ADS estão muito bons");

		pause(browser, 30);

		WebElement selectType = browser.findElement(By.id("selectCommentType"));
		Select select = new Select(selectType);
		select.selectByIndex(3);

		pause(browser, 30);

		WebElement selectAuthor = browser.findElement(By.id("inputUserAuthor"));
		Select select1 = new Select(selectAuthor);
		select1.selectByIndex(19);

		pause(browser, 30);

		WebElement selectDepartment = browser.findElement(By.id("inputDepartamentDestination"));
		Select select2 = new Select(selectDepartment);
		select2.selectByIndex(4);

		pause(browser, 40);

		WebElement buttonSave = browser.findElement(By.id("button_salvar"));
		buttonSave.click();

		pause(browser, 50);
	}

	// Título: 5 - 50 caracteres; campo obrigatório
	@Test
	void tryingToSaveCommentWithFiveCharactersInTheTitleField() {

		// Campo Título com exatamente 5 caracteres

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver browser = new ChromeDriver();
		browser.navigate().to("http://localhost:3000/createComment");

		pause(browser, 30);

		WebElement inputTitle = browser.findElement(By.id("inputCommentTitle"));
		inputTitle.sendKeys("Dp TI"); // 5 caracteres

		pause(browser, 30);

		WebElement message = browser.findElement(By.id("MessageTextarea"));
		message.sendKeys("Os computadores do Laboratório de ADS estão muito bons");

		pause(browser, 30);

		WebElement selectType = browser.findElement(By.id("selectCommentType"));
		Select select = new Select(selectType);
		select.selectByIndex(3);

		pause(browser, 30);

		WebElement selectAuthor = browser.findElement(By.id("inputUserAuthor"));
		Select select1 = new Select(selectAuthor);
		select1.selectByIndex(19);

		pause(browser, 30);

		WebElement selectDepartment = browser.findElement(By.id("inputDepartamentDestination"));
		Select select2 = new Select(selectDepartment);
		select2.selectByIndex(4);

		pause(browser, 40);

		WebElement buttonSave = browser.findElement(By.id("button_salvar"));
		buttonSave.click();

		pause(browser, 50);
	}

	// Título: 5 - 50 caracteres; campo obrigatório
	@Test
	void tryingToSaveCommentWithFiftyCharactersInTheTitleField() {

		// Campo Título com 50 caracteres

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver browser = new ChromeDriver();
		browser.navigate().to("http://localhost:3000/createComment");

		pause(browser, 30);

		// 50 caracteres
		WebElement inputTitle = browser.findElement(By.id("inputCommentTitle"));
		inputTitle.sendKeys("Sobre os computadores do laboratorio quatro de ADS");

		pause(browser, 30);

		WebElement message = browser.findElement(By.id("MessageTextarea"));
		message.sendKeys("Os computadores do Laboratório de ADS estão muito bons");

		pause(browser, 30);

		WebElement selectType = browser.findElement(By.id("selectCommentType"));
		Select select = new Select(selectType);
		select.selectByIndex(3);

		pause(browser, 30);

		WebElement selectAuthor = browser.findElement(By.id("inputUserAuthor"));
		Select select1 = new Select(selectAuthor);
		select1.selectByIndex(19);

		pause(browser, 30);

		WebElement selectDepartment = browser.findElement(By.id("inputDepartamentDestination"));
		Select select2 = new Select(selectDepartment);
		select2.selectByIndex(4);

		pause(browser, 40);

		WebElement buttonSave = browser.findElement(By.id("button_salvar"));
		buttonSave.click();

		pause(browser, 50);
	}

	// Mensagem: 10 - 255 caracteres; campo obrigatório
	@Test
	void tryingToSaveCommentWithoutTheMessageField() {

		// Campo Mensagem Nulo/Vazio

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver browser = new ChromeDriver();
		browser.navigate().to("http://localhost:3000/createComment");

		pause(browser, 30);

		WebElement inputTitle = browser.findElement(By.id("inputCommentTitle"));
		inputTitle.sendKeys("Computadores");

		pause(browser, 30);

		WebElement message = browser.findElement(By.id("MessageTextarea"));
		message.sendKeys(""); // sem preencher

		pause(browser, 30);

		WebElement selectType = browser.findElement(By.id("selectCommentType"));
		Select select = new Select(selectType);
		select.selectByIndex(3);

		pause(browser, 30);

		WebElement selectAuthor = browser.findElement(By.id("inputUserAuthor"));
		Select select1 = new Select(selectAuthor);
		select1.selectByIndex(19);

		pause(browser, 30);

		WebElement selectDepartment = browser.findElement(By.id("inputDepartamentDestination"));
		Select select2 = new Select(selectDepartment);
		select2.selectByIndex(4);

		pause(browser, 40);

		WebElement buttonSave = browser.findElement(By.id("button_salvar"));
		buttonSave.click();

		pause(browser, 50);
	}

	// Mensagem: 10 - 255 caracteres; campo obrigatório
	@Test
	void tryingToSaveCommentWithNineCharactersInTheMessageField() {

		// Campo Mensagem com 9 caracteres

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver browser = new ChromeDriver();
		browser.navigate().to("http://localhost:3000/createComment");

		pause(browser, 30);

		WebElement inputTitle = browser.findElement(By.id("inputCommentTitle"));
		inputTitle.sendKeys("Computadores");

		pause(browser, 30);

		// 9 caracteres
		WebElement message = browser.findElement(By.id("MessageTextarea"));
		message.sendKeys("Lab Infor");

		pause(browser, 30);

		WebElement selectType = browser.findElement(By.id("selectCommentType"));
		Select select = new Select(selectType);
		select.selectByIndex(3);

		pause(browser, 30);

		WebElement selectAuthor = browser.findElement(By.id("inputUserAuthor"));
		Select select1 = new Select(selectAuthor);
		select1.selectByIndex(19);

		pause(browser, 30);

		WebElement selectDepartment = browser.findElement(By.id("inputDepartamentDestination"));
		Select select2 = new Select(selectDepartment);
		select2.selectByIndex(4);

		pause(browser, 40);

		WebElement buttonSave = browser.findElement(By.id("button_salvar"));
		buttonSave.click();

		pause(browser, 50);
	}

	// ***NÃO TÁ FUNCIONANDO - VER VALIDAÇÃO***
	// Mensagem: 10 - 255 caracteres; campo obrigatório
	@Test
	void tryingToSaveCommentWithTwoHundredAndFiftySixCharactersInTheMessageField() {

		// Campo Mensagem com 256 caracteres

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver browser = new ChromeDriver();
		browser.navigate().to("http://localhost:3000/createComment");

		pause(browser, 30);

		WebElement inputTitle = browser.findElement(By.id("inputCommentTitle"));
		inputTitle.sendKeys("Computadores");

		pause(browser, 30);

		// 256 caracteres
		WebElement message = browser.findElement(By.id("MessageTextarea"));
		message.sendKeys("Gostaria de parabenizar os envolvidos pela organizacao dos "
				+ "laboratórios de informática do curso de ADS. Os computadores estão "
				+ "com uma configuracao muito boa, isso é muito importante para o "
				+ "desenvolvimento dos projetos sugeridos para as disciplinas, legal!!");

		pause(browser, 30);

		WebElement selectType = browser.findElement(By.id("selectCommentType"));
		Select select = new Select(selectType);
		select.selectByIndex(3);

		pause(browser, 30);

		WebElement selectAuthor = browser.findElement(By.id("inputUserAuthor"));
		Select select1 = new Select(selectAuthor);
		select1.selectByIndex(19);

		pause(browser, 30);

		WebElement selectDepartment = browser.findElement(By.id("inputDepartamentDestination"));
		Select select2 = new Select(selectDepartment);
		select2.selectByIndex(4);

		pause(browser, 40);

		WebElement buttonSave = browser.findElement(By.id("button_salvar"));
		buttonSave.click();

		pause(browser, 50);
	}

	// Mensagem: 10 - 255 caracteres; campo obrigatório
	@Test
	void tryingToSaveCommentWithTenCharactersInTheMessageField() {

		// Campo Mensagem com 10 caracteres

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver browser = new ChromeDriver();
		browser.navigate().to("http://localhost:3000/createComment");

		pause(browser, 30);

		WebElement inputTitle = browser.findElement(By.id("inputCommentTitle"));
		inputTitle.sendKeys("Computadores");

		pause(browser, 30);

		// 10 caracteres
		WebElement message = browser.findElement(By.id("MessageTextarea"));
		message.sendKeys("Muito bons");

		pause(browser, 30);

		WebElement selectType = browser.findElement(By.id("selectCommentType"));
		Select select = new Select(selectType);
		select.selectByIndex(3);

		pause(browser, 30);

		WebElement selectAuthor = browser.findElement(By.id("inputUserAuthor"));
		Select select1 = new Select(selectAuthor);
		select1.selectByIndex(19);

		pause(browser, 30);

		WebElement selectDepartment = browser.findElement(By.id("inputDepartamentDestination"));
		Select select2 = new Select(selectDepartment);
		select2.selectByIndex(4);

		pause(browser, 40);

		WebElement buttonSave = browser.findElement(By.id("button_salvar"));
		buttonSave.click();

		pause(browser, 50);
	}

	// ***NÃO TÁ FUNCIONANDO - VER VALIDAÇÃO***
	// Mensagem: 10 - 255 caracteres; campo obrigatório
	@Test
	void tryingToSaveCommentWithTwoHundredAndFiftyFiveCharactersInTheMessageField() {

		// Campo Mensagem com 255 caracteres

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver browser = new ChromeDriver();
		browser.navigate().to("http://localhost:3000/createComment");

		pause(browser, 30);

		WebElement inputTitle = browser.findElement(By.id("inputCommentTitle"));
		inputTitle.sendKeys("Computadores");

		pause(browser, 30);

		// 255 caracteres
		WebElement message = browser.findElement(By.id("MessageTextarea"));
		message.sendKeys("Gostaria de parabenizar os envolvidos pela organizacao dos laboratorios "
				+ "de informatica do curso de ADS, os computadores estao com uma configuracao "
				+ "muito boa, isso e muito importante para o desenvolvimento dos projetos "
				+ "sugeridos para as disciplinas, legal!");

		pause(browser, 30);

		WebElement selectType = browser.findElement(By.id("selectCommentType"));
		Select select = new Select(selectType);
		select.selectByIndex(3);

		pause(browser, 30);

		WebElement selectAuthor = browser.findElement(By.id("inputUserAuthor"));
		Select select1 = new Select(selectAuthor);
		select1.selectByIndex(19);

		pause(browser, 30);

		WebElement selectDepartment = browser.findElement(By.id("inputDepartamentDestination"));
		Select select2 = new Select(selectDepartment);
		select2.selectByIndex(4);

		pause(browser, 40);

		WebElement buttonSave = browser.findElement(By.id("button_salvar"));
		buttonSave.click();

		pause(browser, 50);
	}

	// Sem selecionar tipo de comentário
	@Test
	void tryingToSaveCommentWithoutSelectingCommentType() {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver browser = new ChromeDriver();
		browser.navigate().to("http://localhost:3000/createComment");

		pause(browser, 30);

		WebElement inputTitle = browser.findElement(By.id("inputCommentTitle"));
		inputTitle.sendKeys("Computadores");

		pause(browser, 30);

		WebElement message = browser.findElement(By.id("MessageTextarea"));
		message.sendKeys("Os computadores do Laboratório de ADS estão muito bons");

		pause(browser, 30);

		WebElement selectAuthor = browser.findElement(By.id("inputUserAuthor"));
		Select select1 = new Select(selectAuthor);
		select1.selectByIndex(19);

		pause(browser, 30);

		WebElement selectDepartment = browser.findElement(By.id("inputDepartamentDestination"));
		Select select2 = new Select(selectDepartment);
		select2.selectByIndex(4);

		pause(browser, 40);

		WebElement buttonSave = browser.findElement(By.id("button_salvar"));
		buttonSave.click();

		pause(browser, 50);
	}

	// Sem selecionar autor do comentário
	@Test
	void tryingToSaveCommentWithoutSelectingCommentAuthor() {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver browser = new ChromeDriver();
		browser.navigate().to("http://localhost:3000/createComment");

		pause(browser, 30);

		WebElement inputTitle = browser.findElement(By.id("inputCommentTitle"));
		inputTitle.sendKeys("Computadores");

		pause(browser, 30);

		WebElement message = browser.findElement(By.id("MessageTextarea"));
		message.sendKeys("Os computadores do Laboratório de ADS estão muito bons");

		pause(browser, 30);

		WebElement selectType = browser.findElement(By.id("selectCommentType"));
		Select select = new Select(selectType);
		select.selectByIndex(3);

		pause(browser, 30);

		WebElement selectDepartment = browser.findElement(By.id("inputDepartamentDestination"));
		Select select2 = new Select(selectDepartment);
		select2.selectByIndex(4);

		pause(browser, 40);

		WebElement buttonSave = browser.findElement(By.id("button_salvar"));
		buttonSave.click();

		pause(browser, 50);
	}

	// Sem selecionar o Departamento para o qual será destinado o comentário

	@Test
	void tryingToSaveCommentWithoutSelectingDepartamentDestination() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver browser = new ChromeDriver();
		browser.navigate().to("http://localhost:3000/createComment");

		pause(browser, 30);

		WebElement inputTitle = browser.findElement(By.id("inputCommentTitle"));
		inputTitle.sendKeys("Computadores");

		pause(browser, 30);

		WebElement message = browser.findElement(By.id("MessageTextarea"));
		message.sendKeys("Os computadores do Laboratório de ADS estão muito bons");

		pause(browser, 30);

		WebElement selectType = browser.findElement(By.id("selectCommentType"));
		Select select = new Select(selectType);
		select.selectByIndex(3);

		pause(browser, 30);

		WebElement selectAuthor = browser.findElement(By.id("inputUserAuthor"));
		Select select1 = new Select(selectAuthor);
		select1.selectByIndex(19);

		pause(browser, 40);

		WebElement buttonSave = browser.findElement(By.id("button_salvar"));
		buttonSave.click();

		pause(browser, 50);
	}

	// Testando o botão Cancelar
	@Test
	void testingCancelButtonOnTheCreateCommentScreen() {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver browser = new ChromeDriver();
		browser.navigate().to("http://localhost:3000/createComment");

		pause(browser, 30);

		WebElement inputTitle = browser.findElement(By.id("inputCommentTitle"));
		inputTitle.sendKeys("Laboratório de Informática");

		pause(browser, 30);

		WebElement message = browser.findElement(By.id("MessageTextarea"));
		message.sendKeys("Mensagem cancelada");

		pause(browser, 30);

		WebElement selectType = browser.findElement(By.id("selectCommentType"));
		Select select = new Select(selectType);
		select.selectByIndex(2);

		pause(browser, 40);

		WebElement buttonCancel = browser.findElement(By.id("button_cancelar"));
		buttonCancel.click();
		browser.navigate().to("http://localhost:3000");

		pause(browser, 30);
	}

	//****Testes da Tela de Listar Comentários****
	
	@Test
	void createNewComment() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver browser = new ChromeDriver();
		browser.navigate().to("http://localhost:3000/viewComments");

		pause(browser, 40);

		WebElement buttonCreateNewComment = browser.findElement(By.id("cadastrar_comentario"));

		pause(browser, 30);

		buttonCreateNewComment.click();

		pause(browser, 30);
	}
	
	@Test
	void updateComment() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver browser = new ChromeDriver();
		browser.navigate().to("http://localhost:3000/viewComments");

		pause(browser, 30);

		// lista com todos os botoes editar
		List<WebElement> editar = browser.findElements(By.id("button_editar"));

		pause(browser, 40);

		// editar a primeira linha
		editar.get(0).click();

		pause(browser, 30);
	}
	
	@Test
	void deleteComment() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver browser = new ChromeDriver();
		browser.navigate().to("http://localhost:3000/viewComments");

		pause(browser, 30);

		// lista com todos os botoes excluir
		List<WebElement> excluir = browser.findElements(By.id("button_excluir"));

		pause(browser, 40);

		// Excluir a primeira linha
		excluir.get(0).click();

		pause(browser, 30);

		browser.navigate().to("http://localhost:3000/viewComments");
	}
	
	@Test
	void answerComment() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver browser = new ChromeDriver();
		browser.navigate().to("http://localhost:3000/viewComments");

		pause(browser, 30);

		// lista com todos os botoes responder
		List<WebElement> responder = browser.findElements(By.id("button_responder"));

		pause(browser, 40);

		// responder a primeira linha
		responder.get(0).click();

		pause(browser, 30);
	}

}
