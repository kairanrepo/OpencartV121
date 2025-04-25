package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

import java.time.Duration;

public class TC001_AccountRegistrationTest extends BaseClass {



    @Test (groups = {"Regression","Master"})
    public void verify_account_registration() throws InterruptedException {

        logger.info("***** Starting TC001_AccountRegistrationTest  ****");

        try {
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            hp.clickRegister();

            AccountRegistrationPage regpage = new AccountRegistrationPage(driver);

            logger.info("Providing customer details...");
            regpage.setFirstName(randomString());
            regpage.setLastName(randomString());
            regpage.setEmail(randomString() + "@gmail.com");
            regpage.setPassword(randomAlphaNumeric());

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            Thread.sleep(5000);
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("window.scrollBy(0,1000)");
            Thread.sleep(5000);

            jse.executeScript("window.scrollBy(0,2000)");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            regpage.setPrivacyPolicy();
            regpage.clickContinue();

            logger.info("validating expected message...");
            String confmsg = regpage.getConfirmationMsg();
            Assert.assertEquals(confmsg, "Your Account Has Been Created!");
        }
        catch (Exception e)
        {
            logger.error("Test Failed..");
            logger.debug("Debug logs..");
            Assert.fail();
        }
        finally
        {
            logger.info("***** Finished TC001_AccountRegistrationTest *****");
        }

    }

}
