import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BankManagerMenu extends _BasePage {



    private By addCustomer = By.xpath("/html/body/div/div/div[2]/div/div[1]/button[1]");
    private By openAccount = By.xpath("/html/body/div/div/div[2]/div/div[1]/button[2]");
    private By listOfCustomers = By.xpath("/html/body/div/div/div[2]/div/div[1]/button[3]");
    private By logOutManager = By.xpath("/html/body/div/div/div[1]/button[1]");
    private By customerNameLabel = By.xpath("/html/body/div/div/div[2]/div/form/div/label");

    public BankManagerMenu(WebDriver driver, WebDriverWait driverWait){
        super(driver,driverWait);
    }

    public boolean addCustomerBtnDisplayed(){
       new WebDriverWait(getDriver(),  Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(addCustomer));
       return this.getDriver().findElement(this.addCustomer).isDisplayed();

    }

    public void addCustomerBtnClick(){
        new WebDriverWait(getDriver(),  Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(addCustomer));
        WebElement button = getDriver().findElement(addCustomer);
        button.click();

    }

    public void openAccountBtnClick(){
        new WebDriverWait(getDriver(),  Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(openAccount));
        WebElement button = getDriver().findElement(openAccount);
        button.click();

    }

    public void bankManagerLogOut(){
        new WebDriverWait(getDriver(),  Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(logOutManager));
        WebElement button = getDriver().findElement(logOutManager);
        button.click();
    }



}
