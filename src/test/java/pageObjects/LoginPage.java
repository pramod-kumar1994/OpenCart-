package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    // Constructor to initialize the WebDriver and PageFactory
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    @FindBy(xpath = "//input[@id='input-email']")
    WebElement email;

    @FindBy(xpath = "//input[@id='input-password']")
    WebElement password;

    @FindBy(xpath = "//input[@value='Login']")
    WebElement loginButton;

    // Actions
    public void setEmail(String userEmail) {
        // Clear any pre-filled value before entering
        email.sendKeys(userEmail); // Enter the provided email
    }

    public void setPassword(String userPassword) {
       // Clear any pre-filled value before entering
        password.sendKeys(userPassword); // Enter the provided password
    }

    public void clickLogin() {
        loginButton.click(); // Click the login button
    }
}
