package testCases;
import java.util.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccount;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
    @Test()
    public void verifyLogin() {
        logger.info("Starting test: verifyLogin");

        try {
        	
            // Navigate to the Login page
            HomePage hp = new HomePage(driver);
            logger.info("Clicking on 'My Account' link");
            hp.clickMyAccount();
            logger.info("Clicking on 'Login' link");
            hp.clickLogin();

            // Perform login
            LoginPage lp = new LoginPage(driver);
            logger.info("Entering email address");
            lp.setEmail(p.getProperty("email"));
            logger.info("Entering password");
            lp.setPassword(p.getProperty("password"));
            logger.info("Clicking on 'Login' button");
            lp.clickLogin();
            // Verify login
            MyAccount ma = new MyAccount(driver);
            boolean isMyAccountDisplayed = ma.isMyAccountDisplay();
            Assert.assertTrue(isMyAccountDisplayed, "Login failed: 'My Account' page is not displayed.");

            logger.info("Login test passed");
        } catch (NoSuchElementException e) {
            logger.error("Element not found: " + e.getMessage());
            Assert.fail("Test failed due to missing element.");
        } catch (Exception e) {
            logger.error("Unexpected error: " + e.getMessage());
            Assert.fail("Test failed due to an unexpected error.");
        }
    }
}
