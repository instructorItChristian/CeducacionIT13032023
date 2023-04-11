package edit.CeduacionIT13032023;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class laboratorio10 {
	
	String url="https://demoqa.com/alerts";
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
	public void alert1() {
		
		driver.findElement(By.id("alertButton")).click();
		Alert alerta = driver.switchTo().alert();
		alerta.accept();
			
		}
		
	@Test
	public void alert2() {
	driver.findElement(By.xpath("//button[@id='timerAlertButton']")).click();
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	wait.until(ExpectedConditions.alertIsPresent());
	
	Alert alerta = driver.switchTo().alert();
	alerta.accept();
	
	
	}
	
	
	@Test
	public void alert3() {
		
		driver.findElement(By.id("confirmButton")).click();
		
		Alert alerta = driver.switchTo().alert();
		alerta.dismiss();
		
		}
	
	
	@Test
	public void alert4() {
		driver.findElement(By.xpath("//button[@id='promtButton']")).click();
		Alert alerta = driver.switchTo().alert();
		alerta.sendKeys("Clase de automatizacion");
		alerta.accept();
		}
	
	

}