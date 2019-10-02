package pageObjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
 
public class HomePage
{
	WebDriver driver;

	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.ID, using = "txt_ttl_val") 
	public WebElement total_value;
	
	public List<WebElement> findByIdPrefix(String prefix)
	{
		return driver.findElements(By.xpath("//div[starts-with(@id,'"+prefix+"')]"));
	}
 
}