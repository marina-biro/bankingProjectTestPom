import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends _BasePage {


    private By customerButton = By.xpath("/html/body/div/div/div[2]/div/div[1]/div[1]/button");
    private By bankManagerButton = By.xpath("//*[contains(text(), 'Bank Manager Login')]");

    public LoginPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }
    public void loginBankManager() {
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(bankManagerButton)).click();
    }

    public void loginCustomer() {
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(customerButton)).click();
       // this.getDriver().findElement(this.customerButton).click();

    }

}





















