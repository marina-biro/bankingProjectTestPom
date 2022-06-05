import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BankManagerMenu extends _BasePage {

    public BankManagerMenu(WebDriver driver, WebDriverWait driverWait){
        super(driver,driverWait);
    }

    private By addCustomer = By.xpath("/html/body/div/div/div[2]/div/div[1]/button[1]");
    private By openAccount = By.xpath("/html/body/div/div/div[2]/div/div[1]/button[2]");
    private By listOfCustomers = By.xpath("/html/body/div/div/div[2]/div/div[1]/button[3]");



    public boolean addCustomerBtnIsVisible(){
        return this.getDriver().findElement(addCustomer).isDisplayed();
    }








}
