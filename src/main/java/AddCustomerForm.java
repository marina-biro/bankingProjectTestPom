import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddCustomerForm extends _BasePage {
    private By firstName = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[1]/input");
    private By lastName = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[2]/input");
    private By postCode = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[3]/input");

    private By createButton = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/button");

    public AddCustomerForm(WebDriver driver, WebDriverWait driverWait){
        super(driver,driverWait);
    }

    public void enterFirstName(String firstName){
        new WebDriverWait(getDriver(),  Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(this.firstName));
        this.getDriver().findElement(this.firstName).sendKeys(new CharSequence[]{firstName});
    }

    public void enterLastName(String lastName){
        new WebDriverWait(getDriver(),  Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(this.lastName));
        this.getDriver().findElement(this.lastName).sendKeys(new CharSequence[]{lastName});
    }

    public void enterPostCode(String postCode){
        new WebDriverWait(getDriver(),  Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(this.postCode));
        this.getDriver().findElement(this.postCode).sendKeys(new CharSequence[]{postCode});
    }

    public void populateForm(String firstName, String lastName, String postCode){
        this.enterFirstName(firstName);
        this.enterLastName(lastName);
        this.enterPostCode(postCode);
    }

    public void clickCreate(){
        new WebDriverWait(getDriver(),  Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(createButton));
        this.getDriver().findElement(this.createButton).click();
    }


}
