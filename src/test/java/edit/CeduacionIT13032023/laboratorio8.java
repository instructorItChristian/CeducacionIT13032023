package edit.CeduacionIT13032023;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class laboratorio8 {
	
	//atributos
	
		String url ="http://automationpractice.pl/index.php";
		String chromedriver="..\\CeducacionIT13032023\\Driver\\chromedriver111.0.5563.64.exe";
		String firefoxdriver="..\\CeducacionIT13032023\\Driver\\geckodriver0.32.2.exe";
			WebDriver driver;	
			
			
			
	@Parameters("navegador")		
	@BeforeTest
	public void beforetest(String navegador) {
		
		
		if (navegador.equalsIgnoreCase("chrome")) {
		//1-indicar que driver voy a utilizar 
		System.setProperty("webdriver.chrome.driver", chromedriver);
		
		
		//1.5 - codigo para que funciones el navegador
		
		ChromeOptions opciones = new ChromeOptions();
		
		opciones.addArguments("--remote-allow-origins=*");
	
		
	//2-abrir la pagina
		
		driver = new ChromeDriver(opciones);
		
		
		}else if (navegador.equalsIgnoreCase("firefox")) {
		

		//1-indicar que driver voy a utilizar 
			System.setProperty("webdriver.firefox.driver", firefoxdriver);
			//System.setProperty("webdriver.firefox.bin","C:\\Program Files\\Mozilla Firefox\\firefox.exe");
							
		//2-abrir la pagina
			
			driver = new FirefoxDriver();
		
		}
		
		
		
			driver.manage().window().maximize();
			driver.get(url);
		
		
	}
				
			
			
		
			
		//metodos o acciones
		@Test
		public void buscarPalabra() {
		
			
			
		//3- escribir la palabra a buscar
			
			WebElement txtbuscador = driver.findElement(By.id("search_query_top"));
		
			
			txtbuscador.sendKeys("dress");
					
		//4-hacer un enter
		
		txtbuscador.sendKeys(Keys.ENTER);
		
	
		
		}
	
		
		
		
		
		
		
		
		
		
	
	
	
	
	
	
	
	
	
	

}
