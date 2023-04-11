package edit.CeduacionIT13032023;

import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class laboratorio3 {
	
	//variables
	String url="http://automationpractice.pl/index.php?controller=authentication&back=my-account";
	String chromepath="..\\CeducacionIT13032023\\Driver\\chromedriver111.0.5563.64.exe";
	WebDriver driver;
	
	
	//metodos
	@Test
	public void registrarUsuario() {
		
	//instaciar el driver y cargar el sitio
		System.setProperty("webdriver.chrome.driver", chromepath);
		
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("incognito");
		
		
		/**
		 * incognito
		 * start-maximizied
		 * disable-extensions
		 * disable-popup-blocking
		 *  
		 * 
		 * 
		 */
		
		
		driver = new ChromeDriver(options);
		
		driver.navigate().to(url);
		
				
	//cargar el formulario primera parte
		
		//escribir el correo
		
		WebElement txtEmail = driver.findElement(By.xpath("//input[@id='email_create']"));
		
		//txtEmail.sendKeys("micorreo2049_22032023@test.com");
		
		txtEmail.sendKeys("micorreo"+Math.random()+"@test.com" );
		
		//click boton create account
		
		driver.findElement(By.cssSelector("#SubmitCreate")).click();
		
		
		///espera para la carga del sitio
		WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(20));
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("id_gender2")));
		
	
		//cargar el formulario segunda parte
		
		//radio botton
		
		driver.findElement(By.id("id_gender2")).click();
		
		//nombre
		
		driver.findElement(By.name("customer_firstname")).sendKeys("christian");
		//apellido
		
		driver.findElement(By.xpath("//input[@id='customer_lastname']")).sendKeys("perez");	
		
		//pass
		
		driver.findElement(By.name("passwd")).sendKeys("12345");
		
		//fecha de nacimiento
		
		//dia
		
		Select day = new Select(driver.findElement(By.cssSelector("#days")));
		day.selectByVisibleText("3  ");
		
		//mes
		
		Select mes = new Select(driver.findElement(By.id("months")));
		mes.selectByIndex(7);
		
		//año
		
		Select year = new Select (driver.findElement(By.xpath("//select[@id='years']")));
		year.selectByValue("2010");
		
		//novedades
		
		driver.findElement(By.cssSelector("#newsletter")).click();
		
		
		//novedades2
		
		driver.findElement(By.id("optin")).click();
		
		
		//boton registro
		
		driver.findElement(By.id("submitAccount")).click();
		
				
	
	}
		

}
