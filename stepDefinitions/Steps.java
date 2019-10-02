package stepDefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import static org.junit.Assert.*;
import pageObjects.HomePage;
import util.qaUtils;


public class Steps
{
	WebDriver driver;
	HomePage home;
	List<WebElement> values;
	
	@Given("^user is on Home Page$")
	public void user_is_on_Home_Page()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.exercise1.com/values");
	}

	@Then("^verify the value count is (\\d+)$")
	public void verify_the_value_count_is(String arg1)
	{
		int expectedCount = Integer.parseInt(arg1);
		home = new HomePage(driver);
		values = home.findByIdPrefix("txt_val");
		if(values.size() != expectedCount)
			fail("Values count is wrong! Expected "+expectedCount+" Found "+values.size());
		List<WebElement> values_lbl = home.findByIdPrefix("lbl_val");
		if(values_lbl.size() != expectedCount)
			fail("Values label count is wrong! Expected "+expectedCount+" Found "+values_lbl.size());
	}
	
	@And("^values are greater than zero$")
	public void values_are_greater_than_zero()
	{
		 for(WebElement value : values)
			if(qaUtils.currencyToDecimal(value.getText()) <= 0.0)
				fail("Invalid value: "+value.getText());
				
	}
	
	@And("^values are in currency format$")
	public void values_are_in_currency_format()
	{
		for(WebElement value : values)
			if( !value.getText().equals(qaUtils.decimalToCurrency(qaUtils.currencyToDecimal(value.getText()))) )
				fail("Value Not in currency format: "+value.getText());
	}
	
	@And("^total balance is correct$")
	public void total_balance_is_correct()
	{
		double total = 0.0;
		
		for(WebElement value : values)
			total += qaUtils.currencyToDecimal(value.getText());
		
		if( qaUtils.currencyToDecimal(home.total_value.getText()) != total)
			fail("Total should have been "+qaUtils.decimalToCurrency(total));
	}
}