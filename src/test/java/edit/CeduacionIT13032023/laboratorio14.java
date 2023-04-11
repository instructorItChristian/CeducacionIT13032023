package edit.CeduacionIT13032023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class laboratorio14 {
	
	String url="https://demo.guru99.com/test/table.html";
	String driverPath="..\\CeducacionIT13032023\\Driver\\chromedriver111.0.5563.64.exe";
	WebDriver driver;
	
	
	@BeforeTest
	public void beforetest() {
			
		//1-indicar que driver voy a utilizar 
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		
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
		
		String valor1 = driver.findElement(By.xpath("/html[1]/body[1]/table[1]/tbody[1]/tr[1]/td[2]")).getText();
		
		System.out.println("primera fila, segunda columna: "+ valor1);
		
		
	String valor2 = driver.findElement(By.xpath("//tbody/tr[2]/td[2]")).getText();
		
		System.out.println("segunda fila, segunda columna: "+ valor2);
		
		
		//con el css no podemos buscar los datos de una tabla
	//String valor3 = driver.findElement(By.cssSelector("body:nth-child(2) table:nth-child(14) tbody:nth-child(2) tr:nth-child(3) > td:nth-child(1)")).getText();
		
	//	System.out.println("tercera fila, primera columna: "+ valor3);
		
		
	}
	
	
	
	

}
