import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends _BasePage {

    public LoginPage(WebDriver driver, WebDriverWait driverWait){
        super(driver,driverWait);
    }

    private By customerButton = By.xpath("//*[contains(text(), 'Customer Login']");
    private By bankManagerButton = By.xpath("//*[contains(text(), 'Bank Manager Login')]");

    public void loginBankManager(){
        this.getDriver().findElement(this.bankManagerButton).click();
        //za svaku drugu stranicu kod radi. ali elementi nisu klikabilni. proveriti
    }

    public void loginCustomer(){
        this.getDriver().findElement(this.customerButton).click();
    }















}


