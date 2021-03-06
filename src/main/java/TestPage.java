import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestPage {
    private WebDriver driver;
    private WebDriverWait driverWait;
    private LoginPage loginPage;
    private BankManagerMenu bankManagerMenu;
    private AddCustomerForm addCustomerForm;
    private CustomerLogin_CustomerName customerLogin_customerName;
    private CustomerLogin_DepositPage customerLogin_depositPage;
    private BankManager_OpenAccount bankManager_openAccount;

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
        this.customerLogin_customerName = new CustomerLogin_CustomerName(this.driver, this.driverWait);
        this.customerLogin_depositPage = new CustomerLogin_DepositPage(this.driver, this.driverWait);
        this.bankManager_openAccount = new BankManager_OpenAccount(this.driver, this.driverWait);

        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
    }

    @Test (priority = 1)
    public void loginAsBankManager(){
        this.loginPage.loginBankManager();
        Assert.assertTrue(this.bankManagerMenu.addCustomerBtnDisplayed());
    }

    @Test (priority = 2)
    public void createCustomerAccount(){
        this.bankManagerMenu.addCustomerBtnClick();
        this.addCustomerForm.populateForm("M", "B", "24000");
        this.addCustomerForm.clickCreate();
        Assert.assertEquals(driver.switchTo().alert().getText().substring(0, 27), "Customer added successfully");
        driver.switchTo().alert().accept();
    }

    @Test (priority = 3)
    public void bankManager_openCustomerAccount(){
        this.bankManagerMenu.openAccountBtnClick();
        this.bankManager_openAccount.selectCustomer();
        this.bankManager_openAccount.selectCurrency();
        this.bankManager_openAccount.clickProcess();
        Assert.assertEquals(driver.switchTo().alert().getText().substring(0, 28), "Account created successfully");
        driver.switchTo().alert().accept();
    }

    @Test (priority = 5)
    public void loginAsCustomer(){
        this.loginPage.loginCustomer();
        this.customerLogin_customerName.indentifyDropdown();
        this.customerLogin_customerName.clickLogin();
        Assert.assertTrue(this.customerLogin_depositPage.welcome());
    }

    @Test (priority = 6)
    public void testDepositMoney(){
        this.customerLogin_depositPage.depositMoney();
        Assert.assertEquals(customerLogin_depositPage.getBalansState(),"100");

    }

    @Test (priority = 7)
    public void testWithdrawMoney(){
        this.customerLogin_depositPage.withdrawlBtnClick();
        this.customerLogin_depositPage.enterWithrawalAmount();
        this.customerLogin_depositPage.confirmWithrawalAmount();
        Assert.assertEquals(customerLogin_depositPage.getBalansState(),"50");
    }


    @Test (priority = 4)
    public void logoutBankManager(){
        this.bankManagerMenu.bankManagerLogOut();
        Assert.assertTrue(loginPage.isLoginBankManagerVisible());

    }

    @Test (priority = 8)
    public void logOutCustomer(){
        this.customerLogin_depositPage.clickLogOut();
        Assert.assertTrue(customerLogin_customerName.isCustomerLoggedOut());
    }

    @AfterClass
    public void afterClass(){
        driver.close();
    }

}
