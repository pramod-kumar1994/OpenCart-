package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    // Constructor to initialize WebDriver and PageFactory
    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Locators
    @FindBy(xpath = "//body//nav//span[2]")
     WebElement linkMyAccount;

    @FindBy(xpath = "//a[normalize-space()='Login']")
     WebElement loginLink;

    // Actions
    public void clickMyAccount() {
    	    linkMyAccount.click();
    }

    public void clickLogin() {
        loginLink.click();
    }
}
