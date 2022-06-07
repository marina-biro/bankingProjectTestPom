import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BankManager_OpenAccount extends _BasePage{

    private By customerField = By.id("userSelect");
    private By currencyField = By.id("currency");
    private By processButton = By.xpath("//*[contains(text(), 'Process')]");


    public BankManager_OpenAccount(WebDriver driver, WebDriverWait driverWait){
        super(driver,driverWait);
    }


    public void selectCustomer(){
        new WebDriverWait(getDriver(),  Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(currencyField));
        WebElement customer = getDriver().findElement(customerField);
        Select sl= new Select(customer);
        sl.selectByVisibleText("Harry Potter");

    }

    public void selectCurrency(){
        new WebDriverWait(getDriver(),  Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(currencyField));
        WebElement currency = getDriver().findElement(currencyField);
        Select sl= new Select(currency);
        sl.selectByVisibleText("Dollar");

    }

    public void clickProcess(){
        new WebDriverWait(getDriver(),  Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(processButton));
        WebElement processBtn = getDriver().findElement(processButton);
        processBtn.click();
    }





}



