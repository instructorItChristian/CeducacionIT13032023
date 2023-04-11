package edit.CeduacionIT13032023;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utilities.CapturaEvidencia;

public class laboratorio7 {
	
	//atributos
	
	String url ="http://automationpractice.pl/index.php";
	String chromedriver="..\\CeducacionIT13032023\\Driver\\chromedriver111.0.5563.64.exe";
	String datoABuscar="blouse";
	String imagePath="..\\CeducacionIT13032023\\Evidencias\\";
	String docPath="..\\CeducacionIT13032023\\Evidencias\\evidencias.docx";
	//21 57 29 03 2023 evidencias.docx  : / \
	WebDriver driver;
	File Screen;
	
	
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
	@Test (description ="cp001 - busqueda palabra en navegador", priority=10)
	public void buscarPalabraChrome() throws IOException {
		
		//captura evidencia
		
		Screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(Screen, new File (imagePath + "01_pantalla_inicial.jpg"));
		
			
	//3- escribir la palabra a buscar
		
		WebElement txtbuscador = driver.findElement(By.id("search_query_top"));
		txtbuscador.sendKeys(datoABuscar);
		
		//captura evidencia
		Screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(Screen, new File (imagePath + "02_pantalla_con_busqueda.jpg"));
		
				
	//4-hacer un enter
	
	txtbuscador.sendKeys(Keys.ENTER);
	
	
	Assert.assertEquals(driver.getCurrentUrl(), "http://automationpractice.pl/index.php?controller=search&orderby=position&orderway=desc&search_query="+datoABuscar+"&submit_search=");
	//captura evidencia
	
	Screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(Screen, new File (imagePath + "03_pantalla_resultado.jpg"));
	
	
	System.out.println("url: "+ driver.getCurrentUrl());
	System.out.println("titulo: "+ driver.getTitle());
	
	
	
	}

	
	
	@Test (description="cp002 - llenado formulario contact us", priority=20)
	public void irAcontactUs() throws InvalidFormatException, IOException, InterruptedException {
		
		//captura evidencias
		
		CapturaEvidencia.escribirTituloEnDocumento(docPath, "Documento de evidencia de formulario de contacto", 18);
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver, imagePath + "img.jpg", docPath, "pantalla Inicial");
		
		driver.findElement(By.linkText("Contact us")).click();
		
		//captura evidencias
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver, imagePath + "img.jpg", docPath, "formulario vacio");
		
		Select Subject = new Select(driver.findElement(By.id("id_contact")));
		Subject.selectByVisibleText("Customer service");
		
		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("miemail@test.com");
		
		driver.findElement(By.cssSelector("#id_order")).sendKeys("12345");
		
		driver.findElement(By.xpath("//input[@id='fileUpload']")).sendKeys("C:\\testenvio.txt");
		
		driver.findElement(By.cssSelector("#message")).sendKeys("msj de prueba");
		
		//captura evidencias
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver, imagePath + "img.jpg", docPath, "formulario lleno");
		
		driver.findElement(By.name("submitMessage")).click();
		
		//captura evidencias
		
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver, imagePath + "img.jpg", docPath, "resultado Carga Formulario");
		
		
		
		
		
		
		
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
