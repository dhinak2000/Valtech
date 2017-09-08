package webdriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Valtech {

	public WebDriver driver;
	
	
	@BeforeMethod
	public void init() {
		
		//Assumption: chromedriver present under C:\\SeleniumDrivers\\
		
		System.setProperty("webdriver.chrome.driver","C:\\SeleniumDrivers\\chromedriver.exe");	
		driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	@AfterMethod
	public void destroy() {
		driver.close();
		driver.quit();
	}
	
	
@Test
public void news_Section_Test() {
	
	// Question 1
	
	driver.get("https://www.valtech.com");
	WebElement newsSection = driver.findElement(By.xpath("//*[@id=\"container\"]/div[2]/div[3]/div[1]/header/h2"));
	Assert.assertEquals("LATEST NEWS", newsSection.getText());
	
}

@Test
public void about_Page_Test() {
	
	// Question 2
	
	driver.get("https://www.valtech.com");
	WebElement aboutPage =  driver.findElement(By.xpath("//*[@id=\"navigationMenuWrapper\"]/div/ul/li[1]/a/span"));
	aboutPage.click();
	WebElement title  = driver.findElement(By.tagName("h1"));
	Assert.assertEquals("About", title.getText());
	
	
}

@Test

public void services_Page_Test() {

	driver.get("https://www.valtech.com");
	WebElement servicesPage =  driver.findElement(By.xpath("//*[@id=\"navigationMenuWrapper\"]/div/ul/li[3]/a/span"));
	servicesPage.click();
	WebElement title  = driver.findElement(By.tagName("h1"));
	Assert.assertEquals("Services", title.getText());

}


@Test
public void work_Page_Test() {

	driver.get("https://www.valtech.com");
	WebElement workPage =  driver.findElement(By.xpath("//*[@id=\"navigationMenuWrapper\"]/div/ul/li[2]/a/span"));
	workPage.click();
	WebElement title  = driver.findElement(By.tagName("h1"));
	Assert.assertEquals("Work", title.getText());

}

 
//Question 3

@Test

public void valtech_offices_Test() throws InterruptedException {

	driver.get("https://www.valtech.com");
	WebElement contactUsArea = driver.findElement(By.xpath("//*[@id=\"CTA-form-trigger\"]/div/div/span"));
	contactUsArea.click();
	Thread.sleep(2000);

	
	Select se = new Select(driver.findElement(By.name("Country")));
	
	// Assumption 1: Drop down value "Where are you" is  hard-coded and always present
	// Assumption 2: Drop down value "other" is hard-coded and always present	

	List<WebElement> numberOfOfficesList = se.getOptions();
	int number_of_offices = numberOfOfficesList.size();
	if(number_of_offices > 2) {
		number_of_offices = number_of_offices -2;
	}
	else {
		number_of_offices = 0;
	}
	
	Assert.assertEquals(28, number_of_offices);
	System.out.println("[Number of Valtech offices:" + number_of_offices + "]");
	
	
	
	
}

}