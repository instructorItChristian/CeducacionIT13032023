package edit.CeduacionIT13032023;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class laboratorio4 {
	
		//atributos
	
		String url ="http://automationpractice.pl/index.php";
		String chromedriver="..\\CeducacionIT13032023\\Driver\\chromedriver111.0.5563.64.exe";
		String datoABuscar="blouse";
		WebDriver driver;	
		
		
		@BeforeSuite
		
		public void beforesuite() {
			System.out.println("beforeSuite - Inicio de la suite de pruebas");
					
		}
		
		@BeforeClass
		public void beforeclass() {
			System.out.println("beforeclass - Inicio de la clase de java");
			
			//1-indicar que driver voy a utilizar 
			System.setProperty("webdriver.chrome.driver", chromedriver);
			
			
			//1.5 - codigo para que funciones el navegador
			
			ChromeOptions opciones = new ChromeOptions();
			
			opciones.addArguments("--remote-allow-origins=*");
								
		//2-abrir la pagina
			
			driver = new ChromeDriver(opciones);
			driver.manage().window().maximize();
			driver.get(url);
			
			
		}
		
		@BeforeTest
		public void beforetest() {
			System.out.println("beforetest - acciones que se van a ejecutar antes del @Test");
			
		}
		
		
		
		
			
		//metodos o acciones
		@Test
		public void buscarPalabraChrome() {
				
		//3- escribir la palabra a buscar
			
			WebElement txtbuscador = driver.findElement(By.id("search_query_top"));
			txtbuscador.sendKeys(datoABuscar);
					
		//4-hacer un enter
		
		txtbuscador.sendKeys(Keys.ENTER);
		
		Assert.assertEquals(driver.getCurrentUrl(), "http://automationpractice.pl/index.php?controller=search&orderby=position&orderway=desc&search_query="+datoABuscar+"&submit_search=");
		
		
		System.out.println("url: "+ driver.getCurrentUrl());
		System.out.println("titulo: "+ driver.getTitle());
		
		
		
		
		
		}
	
		
		@AfterTest
		
		public void AfterTest() {
			System.out.println("Aftertest - acciones que se van a ejecutar una vez concluido el @Test");
			
		}
		
		
		
		@AfterClass
		
		public void AfterClass() {
			System.out.println("afterclass - acciones que se van a ejecutar cuando se termina la clase");
			
		}
		
	
	

}
