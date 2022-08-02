package br.edu.ifpb.dac.falacampus.testeselenium;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class OpenSystemWeb {
	

	private static WebDriver driver;
	
	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	
	@AfterAll
	static void tearDown() {
		
		driver.quit();
	}

	@Test
	@DisplayName("Open screen Home")
	void home() throws InterruptedException {
		driver.get("http://localhost:3000");
		assertTrue("Título difere do esperado", driver.getTitle().contentEquals("Fala Campus"));
			
		Thread.sleep(3000);
	}


}
