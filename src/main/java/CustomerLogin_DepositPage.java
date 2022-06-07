import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomerLogin_DepositPage extends _BasePage{

    private By welcomeMessage = By.xpath("//*[contains(text(), 'Welcome')]");

    private By amoutToDeposit = By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input");
    private By depositBtn = By.xpath("//*[contains(text(), 'Deposit')]");
    private By confirmDeposit = By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/button");
    private By withdrawalBtn =  By.xpath("//*[contains(text(), 'Withdrawl')]");
    private By withdrawalAmountField = By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input");
    private By withdrawalConfirmBtn = By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/button");
    private By homeButton = By.xpath("/html/body/div/div/div[1]/button[1]");
    private By accountState = By.xpath("/html/body/div/div/div[2]/div/div[2]/strong[2]");
    private By logOutButton = By.xpath("/html/body/div/div/div[1]/button[2]");

    public CustomerLogin_DepositPage(WebDriver driver, WebDriverWait driverWait){
        super(driver,driverWait);
    }


    public boolean welcome(){
        new WebDriverWait(getDriver(),  Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(welcomeMessage));
        return this.getDriver().findElement(this.welcomeMessage).isDisplayed();
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

    }


    public String getBalansState(){
        new WebDriverWait(getDriver(),  Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(accountState));
        return this.getDriver().findElement(accountState).getText();
    }

    public void withdrawlBtnClick(){
        new WebDriverWait(getDriver(),  Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(withdrawalBtn));
        WebElement takeOutMoney = getDriver().findElement(withdrawalBtn);
        takeOutMoney.click();

    }

    public void enterWithrawalAmount(){
        new WebDriverWait(getDriver(),  Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(withdrawalAmountField));
        WebElement howMuchMoney = getDriver().findElement(withdrawalAmountField);
        howMuchMoney.sendKeys("50");

    }

    public void confirmWithrawalAmount(){
        new WebDriverWait(getDriver(),  Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(withdrawalConfirmBtn));
        WebElement confirm = getDriver().findElement(withdrawalConfirmBtn);
        confirm.click();
    }

    public void clickHomeButton(){
        new WebDriverWait(getDriver(),  Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(homeButton));
        WebElement home = getDriver().findElement(homeButton);
        home.click();
    }

    public void clickLogOut(){
        new WebDriverWait(getDriver(),  Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(logOutButton));
        WebElement logOut = getDriver().findElement(logOutButton);
        logOut.click();
    }

}
