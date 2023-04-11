package edit.CeduacionIT13032023;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class laboratorio15 {
	
	String url="https://bonigarcia.dev/webdrivermanager/";

	WebDriver driver;
	
	
	@BeforeTest
	public void beforetest() {
			
		//1-indicar que 
		
		WebDriverManager.chromedriver().setup();;
		
		
		//1.5 - codigo para que funciones el navegador
		
		ChromeOptions opciones = new ChromeOptions();
		
		opciones.addArguments("--remote-allow-origins=*");
	
		
	//2-abrir la pagina
		
		driver = new ChromeDriver(opciones);

		driver.manage().window().maximize();
		driver.get(url);
		
		}
	
	
	@Test
	public void imprimirValoresTabla() {
		
	System.out.println("mi clase de boni garcia sin chrome driver"); 
		
	}
	
	
	
	

}
