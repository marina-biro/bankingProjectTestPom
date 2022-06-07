import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomerLogin_DepositPage extends _BasePage{

    private By wellcomeMessage = By.xpath("//*[contains(text(), 'Welcome')]");

    private By amoutToDeposit = By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input");
    private By depositBtn = By.xpath("//*[contains(text(), 'Deposit')]");
    private By confirmDeposit = By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/button");

    private By accountState = By.xpath("/html/body/div/div/div[2]/div/div[2]/strong[2]");

    public CustomerLogin_DepositPage(WebDriver driver, WebDriverWait driverWait){
        super(driver,driverWait);
    }


    public boolean welcome(){
        new WebDriverWait(getDriver(),  Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(wellcomeMessage));
        return this.getDriver().findElement(this.wellcomeMessage).isDisplayed();
    }

    public void depositMoney(){
        new WebDriverWait(getDriver(),  Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(depositBtn));
        WebElement depositButton = getDriver().findElement(depositBtn);
        depositButton.click();

        new WebDriverWait(getDriver(),  Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(amoutToDeposit));
        WebElement depositAmount = getDriver().findElement(amoutToDeposit);
        depositAmount.sendKeys("100");

        new WebDriverWait(getDriver(),  Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(confirmDeposit));
        WebElement confirmDepo = getDriver().findElement(confirmDeposit);
        confirmDepo.click();
        confirmDepo.click();
    }


    public String getBalansState(){
        new WebDriverWait(getDriver(),  Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(accountState));
        return this.getDriver().findElement(accountState).getText();
    }


}
