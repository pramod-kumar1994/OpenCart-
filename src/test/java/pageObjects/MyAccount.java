package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccount extends BasePage {

	public MyAccount(WebDriver driver) {
		super(driver);
	
	}
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement msgHeading;
	@FindBy(xpath="(//a[normalize-space()='Logout'])[2]")
	WebElement Click_Logout;
	
	public boolean isMyAccountDisplay()
	
	{try {
		return(msgHeading.isDisplayed());
	}catch(Exception e)
	{
		return false;
	}
		
	}
	public void LogOut()
	{
		Click_Logout.click();
	}

}
