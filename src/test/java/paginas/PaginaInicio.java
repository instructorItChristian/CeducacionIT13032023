package paginas;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaInicio {
	
	//elementos
	
	@FindBy(xpath="//a[contains(text(),'Sign in')]")
	WebElement lnkSignIn;
	
	@FindBy(name="search_query")
	WebElement txtBuscador;
	
	
	//constructor
	
	public PaginaInicio(WebDriver driver) {
		
		PageFactory.initElements(driver, this);	
		
	}
	
	
	//acciones
	
	public void hacerClickSignIn() {
		
		lnkSignIn.click();
		
		
	}
	
	
	public void escribirPalabraABuscar(String palabra) {
		
		txtBuscador.sendKeys(palabra);
		
	}
	
	public void hacerEnterEnBusquedaPalabra() {
		
		txtBuscador.sendKeys(Keys.ENTER);
	}
	
	
	
	

}
