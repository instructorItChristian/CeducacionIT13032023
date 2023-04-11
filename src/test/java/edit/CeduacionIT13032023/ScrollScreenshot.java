package edit.CeduacionIT13032023;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;

public class ScrollScreenshot {
	WebDriver driver;
	
	@Test
	public void scrollScreenshotTest() throws Exception {
		System.setProperty("webdriver.chrome.driver", "..\\CeducacionIT13032023\\Driver\\chromedriver111.0.5563.64.exe");
		
		ChromeOptions opciones = new ChromeOptions();
		
		opciones.addArguments("--remote-allow-origins=*");
	
		
	//2-abrir la pagina
		
		driver = new ChromeDriver(opciones);

				
		driver.get("http://www.bbc.com");       
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		
		Screenshot s=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        ImageIO.write(s.getImage(),"PNG",new File("..\\CeducacionIT13032023\\Evidencias\\fullPageScreenshot.png"));
		
		driver.close();
	}
	
}
