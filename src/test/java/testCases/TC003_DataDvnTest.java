package testCases;

import java.util.NoSuchElementException;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccount;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_DataDvnTest extends BaseClass {

    @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups = "regression")
    public void verifyLoginDataDriven(String email, String pwd, String exp) {
        logger.info("Starting data-driven login test for email: ");

        try {
            // Navigate to the Login page
            HomePage hp = new HomePage(driver);
            logger.info("Clicking on My Account link");
            hp.clickMyAccount();
            logger.info("Clicking on Login link");
            hp.clickLogin();

            // Perform login
            LoginPage lp = new LoginPage(driver);
            logger.info("Entering email address: " + email);
            lp.setEmail(email);
            logger.info("Entering password");
            lp.setPassword(pwd);
            logger.info("Clicking on Login button");
            lp.clickLogin();

            // Validate login
            MyAccount ma = new MyAccount(driver);
            boolean isTargetPageDisplayed = ma.isMyAccountDisplay();

            if (exp.equalsIgnoreCase("valid")) {
                if (isTargetPageDisplayed) {
                    logger.info("Login successful for valid credentials");
                    Assert.assertTrue(true, "Login passed for valid credentials.");
                    ma.LogOut();
                } else {
                   logger.error("Login failed for valid credentials");
                    Assert.fail("Expected login success but failed.");
                }
            } else if (exp.equalsIgnoreCase("invalid")) {
                if (isTargetPageDisplayed) {
                    logger.error("Login successful for invalid credentials");
                    ma.LogOut();
                    Assert.fail("Expected login failure but succeeded.");
                } else {
                    logger.info("Login failed as expected for invalid credentials");
                    Assert.assertTrue(true, "Login failed as expected for invalid credentials.");
                }
            }
        } catch (NoSuchElementException e) {
            logger.error("Element not found: " + e.getMessage());
            Assert.fail("Test failed due to missing element.");
        } catch (Exception e) {
           logger.error("Unexpected error: " + e.getMessage());
            Assert.fail("Test failed due to an unexpected error.");
        }
    }
}
