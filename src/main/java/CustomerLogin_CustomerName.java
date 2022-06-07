import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomerLogin_CustomerName extends _BasePage{

    private By customerNameLabel = By.xpath("/html/body/div/div/div[2]/div/form/div/label");
    private By nameSelector = By.id("userSelect");
    private By loginButton = By.xpath("/html/body/div/div/div[2]/div/form/button");

    public CustomerLogin_CustomerName(WebDriver driver, WebDriverWait driverWait){
        super(driver,driverWait);
    }



    public void indentifyDropdown(){
        new WebDriverWait(getDriver(),  Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(nameSelector));
        WebElement chooseName = getDriver().findElement(nameSelector);
        Select sl= new Select(chooseName);
        sl.selectByVisibleText("Harry Potter");
    }

    public void clickLogin(){
        new WebDriverWait(getDriver(),  Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(loginButton)).click();
    }

    public boolean isCustomerLoggedOut(){
        return this.getDriver().findElement(this.customerNameLabel).isDisplayed();
    }

}
