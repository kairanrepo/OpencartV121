package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountpage extends BasePage{
    public MyAccountpage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[text()='My Account']") // MyAccount Page heading
    WebElement msgHeading;

    @FindBy (xpath = "//div[@class='list-group']//a[text()='Logout']")
    WebElement lnkLogout;

    public Boolean isMyAccountPageExists(){
        try {
            return (msgHeading.isDisplayed());
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public void clickLogout() {
        lnkLogout.click();
    }
}
