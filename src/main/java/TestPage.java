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
    private AddCustomerForm addCustomerForm;


    public TestPage(){

    }

    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Raven\\Desktop\\QA\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
      // this.driverWait = new WebDriverWait(this.driver, Duration.ofSeconds(15));
       this.addCustomerForm = new AddCustomerForm(this.driver, this.driverWait);
        this.loginPage = new LoginPage(this.driver, this.driverWait);
        this.bankManagerMenu = new BankManagerMenu(this.driver, this.driverWait);

        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
    }

    @Test
    public void loginAsBankManager(){
        this.loginPage.loginBankManager();
        Assert.assertTrue(this.bankManagerMenu.addCustomerBtnDisplayed());
    }

    @Test
    public void createCustomerAccount(){
        this.loginPage.loginBankManager();
        this.bankManagerMenu.addCustomerBtnClick();
        this.addCustomerForm.populateForm("M", "B", "24000");
        this.addCustomerForm.clickCreate();
        Assert.assertEquals(driver.switchTo().alert().getText().substring(0, 27), "Customer added successfully");
        driver.switchTo().alert().accept();

    }

    @Test
    public void loginAsCustomer(){
        this.loginPage.loginCustomer();
        Assert.assertTrue(this.bankManagerMenu.yourNameLabel());
    }

    @Test










}
