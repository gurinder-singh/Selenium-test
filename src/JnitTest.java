import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JnitTest {

WebDriver driver = new ChromeDriver();
	
	@Before
	public void openbrowser() {
		String exePath = "C:\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 }
	
	
	
	
	@Test
	public void clickmobilemenu(){
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[@title='Electronics']"))).click().build().perform();
		//Clicking on the mobile tab
		driver.findElement(By.xpath("//a[@title='Mobiles']")).click();
		
	}
	
	@Test 
	public void select4gbram(){
		           //to Select the "RAM" text
				driver.findElement(By.xpath(".//*[@id='container']/div/div[1]/div/div[2]/div/div/div[4]/section/div/div")).click();
				driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
				
				//Clicking on 4GB RAM
				driver.findElement(By.xpath(".//*[@id='container']/div/div[1]/div/div[2]/div/div/div[4]/section/div[2]/div/div[6]/div/div/label/div[2]")).click();
				
				System.out.println(" phones with 4Gb ram are displayed" );
	}
	@Test
	public void selectMotorolaphone(){
		//To Enter Moto in the edit text Filter		
				driver.findElement(By.className("_1wT-Zr")).sendKeys("Moto");
				
				WebDriverWait wait = new WebDriverWait(driver, 40);
				WebElement element = wait.until(
				        ExpectedConditions.visibilityOfElementLocated
				        (By.xpath(".//*[@id='container']/div/div[1]/div/div[2]/div/div/div[5]/section/div[2]/div[1]/div[2]/div/div/label/div[2]")));
				//This is to assert Whether  text Motorola is presnt or not
				Assert.assertEquals(element.getText(),"Motorola");
				element.click();
				
				
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	
	
	
	@After
	public void Closebrowser(){
		driver.quit();
	}
}
