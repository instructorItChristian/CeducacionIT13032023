package edit.CeduacionIT13032023;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import paginas.PaginaInicio;
import paginas.paginaLogIn;

public class laboratorio12 {
	
	String url="http://automationpractice.pl/index.php";
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
	
	
	
	@Test(dataProvider="Datos Login")
	public void logIn(String email, String pass) {
	
		//hacer click en sign in
		
		PaginaInicio inicio = new PaginaInicio(driver);
		
		inicio.hacerClickSignIn();
		
			
		//completar correo y pass
		
	paginaLogIn login = new paginaLogIn(driver);
	
	
login.escribirEmail(email);
	
	login.escribirPass(pass);
		
	
	//login.escribirEmail("micorreo0.31585222836873084@test.com");
	
	//login.escribirPass("12345");
		
		
		//click boton ingreso
		
	login.ClickBtn();
	
	
	Assert.assertEquals("http://automationpractice.pl/index.php?controller=my-account", driver.getCurrentUrl());	
		
	login.hacerClickBTNsignOut();
	
}
	
	
	
	@DataProvider(name="Datos Login")
	public Object[][] obtenerDatos() {
	
		Object[][] datos = new Object[4][2];
		
	datos [0][0] = "micorreo0.31585222836873084@test.com";	
	datos [0][1] = "12345";		
		
	datos [1][0] = "maria";	
	datos [1][1] = "test1234";	
		
	datos [2][0] = "juan";
	datos [2][1] = "test55";	
		
	datos [3][0] = "pedro";	
	datos [3][1] = "test99";	
		
	return datos;
	
	
	}

}
