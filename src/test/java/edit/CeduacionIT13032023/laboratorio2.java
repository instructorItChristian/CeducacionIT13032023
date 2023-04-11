package edit.CeduacionIT13032023;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class laboratorio2 {
	
	//atributos
	
	String url ="http://automationpractice.pl/index.php";
	String chromedriver="..\\CeducacionIT13032023\\Driver\\chromedriver111.0.5563.64.exe";
	String firefoxdriver="..\\CeducacionIT13032023\\Driver\\geckodriver0.32.2.exe";
		WebDriver driver;	
	
		
	//metodos o acciones
	@Test
	public void buscarPalabraChrome() {
	
	//1-indicar que driver voy a utilizar 
		System.setProperty("webdriver.chrome.driver", chromedriver);
		
		
		//1.5 - codigo para que funciones el navegador
		
		ChromeOptions opciones = new ChromeOptions();
		
		opciones.addArguments("--remote-allow-origins=*");
		
		//opciones.addArguments("maximize");
		
		//opciones.addArguments("deleteallcookies");
		
				
	//2-abrir la pagina
		
		driver = new ChromeDriver(opciones);
		driver.manage().window().maximize();
		driver.get(url);
				//driver.navigate().to(url); linea similar a la 45
		 // maximame la pantalla
		
		
		
		
	//3- escribir la palabra a buscar
		
		WebElement txtbuscador = driver.findElement(By.id("search_query_top"));
	
		
		txtbuscador.sendKeys("dress");
				
	//4-hacer un enter
	
	txtbuscador.sendKeys(Keys.ENTER);
	
	
	System.out.println("url: "+ driver.getCurrentUrl());
	System.out.println("titulo: "+ driver.getTitle());
	
	
	
	}
	
	
	@Test
	public void buscarPalabrafirefox() {
	
	//1-indicar que driver voy a utilizar 
		System.setProperty("webdriver.firefox.driver", firefoxdriver);
		//System.setProperty("webdriver.firefox.bin","C:\\Program Files\\Mozilla Firefox\\firefox.exe");
						
	//2-abrir la pagina
		
		driver = new FirefoxDriver();
		driver.get(url);
		
		
	//3- escribir la palabra a buscar
		
		WebElement txtbuscador = driver.findElement(By.id("search_query_top"));
		txtbuscador.sendKeys("dress");
		
		
		
	//4-hacer un enter
	
	txtbuscador.sendKeys(Keys.ENTER);
	}
	
	
	
	
	
	
	
	
	
	

}
