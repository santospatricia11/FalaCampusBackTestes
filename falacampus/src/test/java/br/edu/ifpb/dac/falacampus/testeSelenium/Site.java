package br.edu.ifpb.dac.falacampus.testeSelenium;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class Site {
	

	private static WebDriver driver;
	
	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@AfterAll
	static void tearDown() {
		//driver.close();
		driver.quit();
	}

//	@Test
//	@DisplayName("axcess to homepage")
//	void home() throws InterruptedException {
//		driver.get("http://localhost:8080");
//		Thread.sleep(2000);
//	}
//	
	@Test
	@DisplayName("verify title of tab")
	void title() {
		assertTrue(driver.getTitle().contentEquals("falacampus"));
	}


}
