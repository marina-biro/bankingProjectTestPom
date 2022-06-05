import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestPage {
    private WebDriver driver;
    private WebDriverWait driverWait;
    private LoginPage loginPage;
    private BankManagerMenu bankManagerMenu;


    public TestPage(){}

    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Raven\\Desktop\\QA\\chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.driverWait = new WebDriverWait(this.driver, Duration.ofSeconds(15));
        this.driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
    }

    @Test
    public void loginAsBankManager(){
        this.loginPage.loginBankManager();
        Assert.assertTrue(this.bankManagerMenu.addCustomerBtnIsVisible());
    }
}
