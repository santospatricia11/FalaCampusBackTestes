package br.edu.ifpb.dac.falacampus.testeselenium;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

class OpenSystemWeb {
	

	private static WebDriver browser;
	
	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		browser = new ChromeDriver();
	}

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	
	@AfterAll
	static void tearDown() {
		
		browser.quit();
	}

	@Test
	@DisplayName("Open screen Home")
	void comentario() throws InterruptedException {
		
	}
	
	
	
	




}
