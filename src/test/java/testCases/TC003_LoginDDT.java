package testCases;

import org.apache.commons.collections4.functors.TruePredicate;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountpage;
import testBase.BaseClass;
import utilities.DataProviders;


public class TC003_LoginDDT extends BaseClass {

        @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class,groups = "Datadriven")
        public void verify_loginDDT(String email, String pwd, String exp) {
            logger.info("**** Starting TC003_LoginDDT ***");
            try {
                {
                    //HomePage
                    HomePage hp = new HomePage(driver);
                    hp.clickMyAccount();
                    hp.clickLogin();

                    //Login
                    LoginPage lp = new LoginPage(driver);
                    lp.setEmail(email);
                    lp.setPassword(pwd);
                    lp.clickLogin();

                    //MyAccount
                    MyAccountpage macc = new MyAccountpage(driver);
                    boolean targetPage = macc.isMyAccountPageExists();

                    if (exp.equalsIgnoreCase("Valid")) {
                        if (targetPage == true) {
                            macc.clickLogout();
                            Assert.assertTrue(true);
                        } else {
                            Assert.assertTrue(false);
                        }
                    }
                    if (exp.equalsIgnoreCase("invalid")) {
                        if (targetPage == true) {
                            macc.clickLogout();
                            Assert.assertTrue(false);
                        } else {
                            Assert.assertTrue(true);
                        }
                    }

                }
            } catch (Exception e) {
                Assert.fail();
            }
            logger.info("**** Finished TC003_LoginDDT ***");
        }
    }
