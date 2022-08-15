package br.edu.ifpb.dac.falacampus.presentation.control;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

class CommentControllerSystemTest {
	
	private WebDriver browser;

    @BeforeEach
    public void beforeEach() {
    	System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        this.browser = new ChromeDriver();
    }
	
	//Método para pausar algumas partes do testes
	private void pause(WebDriver browser, int time) {
		browser.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	//****TESTES DA TELA DE CADASTRAR COMENTÁRIO****
	
	@Test
	void savingCommentWithValidFields() {

		//Comentário com todos os campos válidos
		
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
		select1.selectByIndex(6);

		pause(browser, 30);

		WebElement selectDepartment = browser.findElement(By.id("inputDepartamentDestination"));
		Select select2 = new Select(selectDepartment);
		select2.selectByIndex(3);

		pause(browser, 40);

		WebElement buttonSave = browser.findElement(By.id("button_salvar"));
		buttonSave.click();

		pause(browser, 30);
		
		//browser.quit(); //para fechar o navegador no final do teste
	}

	// Comentário com todos os campos inválidos
	@Test
	void tryingToSaveCommentWithInvalidFields() {

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
		select1.selectByIndex(6);

		pause(browser, 30);

		WebElement selectDepartment = browser.findElement(By.id("inputDepartamentDestination"));
		Select select2 = new Select(selectDepartment);
		select2.selectByIndex(3);

		pause(browser, 40);

		WebElement buttonSave = browser.findElement(By.id("button_salvar"));
		buttonSave.click();

		pause(browser, 50);
		
		//verifica se a mensagem de erro é exibida na página
		//recupera elementos em uma página e verifica se a mensagem está presente na página
		assertTrue(browser.getPageSource().contains("Campo Título é obrigatório!"));
	}

	// Título: 5 - 50 caracteres; campo obrigatório
	@Test
	void tryingToSaveCommentWithFourCharactersInTheTitleField() {

		// Campo Título com 4 caracteres

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
		select1.selectByIndex(6);

		pause(browser, 30);

		WebElement selectDepartment = browser.findElement(By.id("inputDepartamentDestination"));
		Select select2 = new Select(selectDepartment);
		select2.selectByIndex(3);

		pause(browser, 40);

		WebElement buttonSave = browser.findElement(By.id("button_salvar"));
		buttonSave.click();

		pause(browser, 50);
		
		assertTrue(browser.getPageSource().contains("O Título do Comentário deve ter no "
				+ "mínimo 5 e no máximo 50 caracteres!"));
	}

	// Título: 5 - 50 caracteres; campo obrigatório
	@Test
	void tryingToSaveCommentWithFiftyOneCharactersInTheTitleField() {

		// Campo Título com 51 caracteres

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
		select1.selectByIndex(6);

		pause(browser, 30);

		WebElement selectDepartment = browser.findElement(By.id("inputDepartamentDestination"));
		Select select2 = new Select(selectDepartment);
		select2.selectByIndex(3);

		pause(browser, 40);

		WebElement buttonSave = browser.findElement(By.id("button_salvar"));
		buttonSave.click();

		pause(browser, 50);
		
		assertTrue(browser.getPageSource().contains("O Título do Comentário deve ter no mínimo 5 e no máximo 50 caracteres!"));
	}

	// Título: 5 - 50 caracteres; campo obrigatório
	@Test
	void tryingToSaveCommentWithFiveCharactersInTheTitleField() {

		// Campo Título com exatamente 5 caracteres

		browser.navigate().to("http://localhost:3000/createComment");

		pause(browser, 30);

		WebElement inputTitle = browser.findElement(By.id("inputCommentTitle"));
		inputTitle.sendKeys("Coordenação de TI"); // 5 caracteres

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
		select1.selectByIndex(6);

		pause(browser, 30);

		WebElement selectDepartment = browser.findElement(By.id("inputDepartamentDestination"));
		Select select2 = new Select(selectDepartment);
		select2.selectByIndex(3);

		pause(browser, 40);

		WebElement buttonSave = browser.findElement(By.id("button_salvar"));
		buttonSave.click();

		pause(browser, 50);
		
		//assertTrue(browser.getPageSource().contains("Comentário criado com sucesso!"));
	}

	// Título: 5 - 50 caracteres; campo obrigatório
	@Test
	void tryingToSaveCommentWithFiftyCharactersInTheTitleField() {

		// Campo Título com 50 caracteres

		browser.navigate().to("http://localhost:3000/createComment");

		pause(browser, 30);

		// 50 caracteres
		WebElement inputTitle = browser.findElement(By.id("inputCommentTitle"));
		inputTitle.sendKeys("Sobre os computadores do laboratorio quatro de ADS");

		pause(browser, 30);

		WebElement message = browser.findElement(By.id("MessageTextarea"));
		message.sendKeys("Os computadores do Laboratorio de ADS estao muito bons");

		pause(browser, 30);

		WebElement selectType = browser.findElement(By.id("selectCommentType"));
		Select select = new Select(selectType);
		select.selectByIndex(3);

		pause(browser, 30);

		WebElement selectAuthor = browser.findElement(By.id("inputUserAuthor"));
		Select select1 = new Select(selectAuthor);
		select1.selectByIndex(6);

		pause(browser, 30);

		WebElement selectDepartment = browser.findElement(By.id("inputDepartamentDestination"));
		Select select2 = new Select(selectDepartment);
		select2.selectByIndex(3);

		pause(browser, 40);

		WebElement buttonSave = browser.findElement(By.id("button_salvar"));
		buttonSave.click();

		pause(browser, 50);
		
		//assertTrue(browser.getPageSource().contains("Comentário criado com sucesso!"));
	}

	// Mensagem: 10 - 255 caracteres; campo obrigatório
	@Test
	void tryingToSaveCommentWithoutTheMessageField() {

		// Campo Mensagem Nulo/Vazio

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
		select1.selectByIndex(6);

		pause(browser, 30);

		WebElement selectDepartment = browser.findElement(By.id("inputDepartamentDestination"));
		Select select2 = new Select(selectDepartment);
		select2.selectByIndex(3);

		pause(browser, 40);

		WebElement buttonSave = browser.findElement(By.id("button_salvar"));
		buttonSave.click();

		pause(browser, 50);
		
		assertTrue(browser.getPageSource().contains("Campo Mensagem é obrigatório!"));
	}

	// Mensagem: 10 - 255 caracteres; campo obrigatório
	@Test
	void tryingToSaveCommentWithNineCharactersInTheMessageField() {

		// Campo Mensagem com 9 caracteres

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
		select1.selectByIndex(6);

		pause(browser, 30);

		WebElement selectDepartment = browser.findElement(By.id("inputDepartamentDestination"));
		Select select2 = new Select(selectDepartment);
		select2.selectByIndex(3);

		pause(browser, 40);

		WebElement buttonSave = browser.findElement(By.id("button_salvar"));
		buttonSave.click();

		pause(browser, 50);
		
		assertTrue(browser.getPageSource().contains("A mensagem do Comentário deve ter "
				+ "no mínimo 10 e no máximo 255 caracteres!"));
	}

	// Mensagem: 10 - 255 caracteres; campo obrigatório
	@Test
	void tryingToSaveCommentWithTwoHundredAndFiftySixCharactersInTheMessageField() {

		// Campo Mensagem com 256 caracteres

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
		select1.selectByIndex(6);

		pause(browser, 30);

		WebElement selectDepartment = browser.findElement(By.id("inputDepartamentDestination"));
		Select select2 = new Select(selectDepartment);
		select2.selectByIndex(3);

		pause(browser, 40);

		WebElement buttonSave = browser.findElement(By.id("button_salvar"));
		buttonSave.click();

		pause(browser, 50);
		
		assertTrue(browser.getPageSource().contains("A mensagem do Comentário deve ter "
				+ "no mínimo 10 e no máximo 255 caracteres!"));
	}

	// Mensagem: 10 - 255 caracteres; campo obrigatório
	@Test
	void tryingToSaveCommentWithTenCharactersInTheMessageField() {

		// Campo Mensagem com 10 caracteres

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
		select1.selectByIndex(6);

		pause(browser, 30);

		WebElement selectDepartment = browser.findElement(By.id("inputDepartamentDestination"));
		Select select2 = new Select(selectDepartment);
		select2.selectByIndex(3);

		pause(browser, 40);

		WebElement buttonSave = browser.findElement(By.id("button_salvar"));
		buttonSave.click();

		pause(browser, 50);
		
		//assertTrue(browser.getPageSource().contains("Comentário criado com sucesso!"));
	}

	// Mensagem: 10 - 255 caracteres; campo obrigatório
	@Test
	void tryingToSaveCommentWithTwoHundredAndFiftyFiveCharactersInTheMessageField() {

		// Campo Mensagem com 255 caracteres

		browser.navigate().to("http://localhost:3000/createComment");

		pause(browser, 30);

		WebElement inputTitle = browser.findElement(By.id("inputCommentTitle"));
		inputTitle.sendKeys("Computadores");

		pause(browser, 30);

		// 255 caracteres
		WebElement message = browser.findElement(By.id("MessageTextarea"));
		message.sendKeys("Gostaria de parabenizar os envolvidos pela organizacao "
				+ "dos laboratorios de informatica do curso de ADS pois os "
				+ "computadores estao com uma configuracao muito boa isso é muito "
				+ "importante para o desenvolvimento dos projetos sugeridos "
				+ "nas disciplinas do curso");

		pause(browser, 30);

		WebElement selectType = browser.findElement(By.id("selectCommentType"));
		Select select = new Select(selectType);
		select.selectByIndex(3);

		pause(browser, 30);

		WebElement selectAuthor = browser.findElement(By.id("inputUserAuthor"));
		Select select1 = new Select(selectAuthor);
		select1.selectByIndex(6);

		pause(browser, 30);

		WebElement selectDepartment = browser.findElement(By.id("inputDepartamentDestination"));
		Select select2 = new Select(selectDepartment);
		select2.selectByIndex(3);

		pause(browser, 40);

		WebElement buttonSave = browser.findElement(By.id("button_salvar"));
		buttonSave.click();

		pause(browser, 50);
		
		//assertTrue(browser.getPageSource().contains("Comentário criado com sucesso!"));
	}

	// Sem selecionar tipo de comentário
	@Test
	void tryingToSaveCommentWithoutSelectingCommentType() {

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
		select1.selectByIndex(6);

		pause(browser, 30);

		WebElement selectDepartment = browser.findElement(By.id("inputDepartamentDestination"));
		Select select2 = new Select(selectDepartment);
		select2.selectByIndex(3);

		pause(browser, 40);

		WebElement buttonSave = browser.findElement(By.id("button_salvar"));
		buttonSave.click();

		pause(browser, 50);
		
		assertTrue(browser.getPageSource().contains("É obrigatório informar o "
				+ "Tipo de Comentário!"));
	}

	// Sem selecionar autor do comentário
	@Test
	void tryingToSaveCommentWithoutSelectingCommentAuthor() {

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
		select2.selectByIndex(3);

		pause(browser, 40);

		WebElement buttonSave = browser.findElement(By.id("button_salvar"));
		buttonSave.click();

		pause(browser, 50);
		
		assertTrue(browser.getPageSource().contains("É obrigatório informar o "
				+ "Autor do Comentário!"));
	}

	// Sem selecionar o Departamento para o qual será destinado o comentário
	@Test
	void tryingToSaveCommentWithoutSelectingDepartamentDestination() {
		
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
		select1.selectByIndex(6);

		pause(browser, 40);

		WebElement buttonSave = browser.findElement(By.id("button_salvar"));
		buttonSave.click();

		pause(browser, 50);
		
		assertTrue(browser.getPageSource().contains("É obrigatório informar o Departamento "
				+ "para o qual será direcionada a crítica, sugestão ou elogio!"));
	}

	// Testando o botão Cancelar - Tela Cadastrar Comentário
	@Test
	void testingCancelButtonOnTheCreateCommentScreen() {

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

	//****TESTES DA TELA DE LISTAR COMENTÁRIOS****
	
	//Botão Pesquisar
	@Test
	void testingSearchButton() {

		browser.navigate().to("http://localhost:3000/viewComments");

		pause(browser, 30);

		WebElement inputTitle = browser.findElement(By.id("inputTitle"));
		inputTitle.sendKeys("Coordenação de TI");

		pause(browser, 50);

		WebElement buttonSearch = browser.findElement(By.id("btn-search"));
		buttonSearch.click();

		pause(browser, 50);
	}
	
	//Botão Pesquisar colocando 2 caracteres no campo Título
		@Test
		void testingSearchButtonWithTwoCharactersInTitleField() {

			browser.navigate().to("http://localhost:3000/viewComments");

			pause(browser, 30);

			WebElement inputTitle = browser.findElement(By.id("inputTitle"));
			inputTitle.sendKeys("Bi");

			pause(browser, 50);

			WebElement buttonSearch = browser.findElement(By.id("btn-search"));
			buttonSearch.click();

			pause(browser, 50);
		}
	
	@Test
	void createNewComment() {
		
		browser.navigate().to("http://localhost:3000/viewComments");

		pause(browser, 40);

		WebElement buttonCreateNewComment = browser.findElement(By.id("cadastrar_comentario"));

		pause(browser, 30);

		buttonCreateNewComment.click();

		pause(browser, 30);
		
		//compara se a página que estamos no momento não é mais a página da viewComments 
		//(redirecionamento para a tela de cadastro de comentário)
		assertFalse(browser.getCurrentUrl().equals("http://localhost:3000/viewComments"));
	}
	
	@Test
	void updateComment() {

		browser.navigate().to("http://localhost:3000/viewComments");

		pause(browser, 30);

		// lista com todos os botoes editar
		List<WebElement> editar = browser.findElements(By.id("button_editar"));

		pause(browser, 40);

		// editar a primeira linha
		editar.get(0).click();

		pause(browser, 30);
		
		assertFalse(browser.getCurrentUrl().equals("http://localhost:3000/viewComments"));
	}
	
	@Test
	void deleteComment() {

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

		browser.navigate().to("http://localhost:3000/viewComments");

		pause(browser, 30);

		// lista com todos os botoes responder
		List<WebElement> responder = browser.findElements(By.id("button_responder"));

		pause(browser, 40);

		// responder a primeira linha
		responder.get(0).click();

		pause(browser, 30);
		
		assertFalse(browser.getCurrentUrl().equals("http://localhost:3000/viewComments"));
	}
	
	// Testando o botão Cancelar - Tela Atualizar Comentário
		@Test
		void testingCancelButtonOnTheUpdateCommentScreen() {

			browser.navigate().to("http://localhost:3000/viewComments");

			pause(browser, 50);
			pause(browser, 50);
			pause(browser, 50);

			// lista com todos os botoes editar
			List<WebElement> editar = browser.findElements(By.id("button_editar"));

			pause(browser, 50);
			pause(browser, 50);
			pause(browser, 50);
			pause(browser, 50);
			pause(browser, 50);

			// editar a primeira linha
			editar.get(0).click();

			pause(browser, 50);
			pause(browser, 50);
			pause(browser, 50);
			pause(browser, 50);
			pause(browser, 50);

			WebElement buttonCancel = browser.findElement(By.id("button-cancel"));
			buttonCancel.click();

			pause(browser, 50);
			pause(browser, 50);
			pause(browser, 50);
			pause(browser, 50);
			pause(browser, 50);
			
			assertFalse(browser.getCurrentUrl().equals("http://localhost:3000/viewComments"));
		}

}
