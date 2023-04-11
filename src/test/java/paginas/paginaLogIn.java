package paginas;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class paginaLogIn {
	
	//elementos
	
	@FindBy(css="#email")
	WebElement txtmail;
	
	
	@FindBy(name="passwd")
	WebElement txtpass;
	
	@FindBy(id="SubmitLogin")
	WebElement btnSignIn;
	
	@FindBy(linkText="Sign out")
	WebElement btnSignOut;
	
	//constructor

	public paginaLogIn(WebDriver driver) {
		PageFactory.initElements(driver, this);
				
	}
			
	//acciones
	
	public void escribirEmail(String email) {
		
		txtmail.sendKeys(email);
		
	}
	
	
	public void escribirPass(String pass) {
		txtpass.sendKeys(pass);
		
	}
	
	
	public void ClickBtn() {
		
		btnSignIn.click();
		
	}
	
	
	
	//es necesario para que se ejecute el testing completo
	
	public void hacerClickBTNsignOut() {
		
		
		btnSignOut.click();
		
	}
	
	
	

}
