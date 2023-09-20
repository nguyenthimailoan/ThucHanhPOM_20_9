package loantester.com.Pages;
import loantester.com.keywords.WebUI;
import static loantester.com.keywords.WebUI.*;
import static loantester.com.keywords.WebUI.getTextElement;
//import static loantester.com.keywords.WebUI.getTextElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {
//    private String URL = "https://crm.anhtester.com/admin/authentication";
//    private String PAGETEXT = "Login";
//
//    //Lưu Object của trang Login
//    //Dùng đối tượng By trong Selenium để khai báo tên Object cùng giá trị Locator tương ứng
//    By headerPage = By.xpath("//h1");
//    By inputEmail = By.xpath("//input[@id='email']");
//    By inputPassword = By.xpath("//input[@id='password']");
//    By buttonLogin = By.xpath("//button[normalize-space()='Login']");
//    By messageErrorEmail = By.xpath("//div[@class='text-center alert alert-danger']");
//
//    //Hàm xây dựng để truyền vào driver
//    private WebDriver driver;
//
//    public LoginPage(WebDriver _driver){
//        driver = _driver;
//        new WebUI(driver);
//    }
//
//    //Viết các hàm xử lý cho trang Login
//    public void verifyHeaderPage(){
//        Assert.assertEquals(getTextElement(headerPage), "Login", "FAIL. Header not match.");
//    }
//
//    public void verifyErrorMessageDisplay(){
//        Assert.assertTrue(getWebElement(messageErrorEmail).isDisplayed(), "FAIL. Error message no displays.");
//        Assert.assertEquals(getTextElement(messageErrorEmail), "Invalid email or password", "FAIL. Content of the Error message not match.");
//
//    }
//
//    public void enterEmail(String email){
//        setText(inputEmail, email);
//    }
//
//    public void enterPassword(String password){
//        setText(inputPassword, password);
//    }
//
//    public void clickOnLoginButton(){
//        clickElement(buttonLogin);
//    }
//
//    public DashboardPage login(String email, String password){
//        openURL(URL);
//        verifyHeaderPage();
//        enterEmail(email);
//        enterPassword(password);
//        clickOnLoginButton();
//        return new DashboardPage(driver);
//    }
//
//    public void loginInvalidEmail(String email, String password){
//        openURL(URL);
//        verifyHeaderPage();
//        enterEmail(email);
//        enterPassword(password);
//        clickOnLoginButton();
//        //Kểm tra message thông báo lỗi khi sai email
//        verifyErrorMessageDisplay();
//    }

    private String URL = "https://crm.anhtester.com/admin/authentication";
    private String PAGE_TEXT ="Login";

    // các Object
    By headerPage = By.xpath("//h1");
    By inputEmail = By.xpath("//input[@id='email']");
    By inputPassword = By.xpath("//input[@id='password']");
    By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    By messageErrorEmail = By.xpath("//div[@class='text-center alert alert-danger']");
    By messageErrorEmptyPassword = By.xpath("//div[normalize-space()='The Password field is required.']");
    By messageErrorEmptyEmail = By.xpath("//div[normalize-space()='The Email Address field is required.']");
    By checkboxRemember = By.xpath("//label[normalize-space()='Remember me']");


    // hàm xay dựng
    private WebDriver driver;
    public LoginPage (WebDriver _driver){
        driver = _driver;
        new WebUI(driver);
    }
    // Viết các hàm xử lý
    public void verifyHeaderPage(){
        Assert.assertEquals(getTextElement(headerPage),"Login","FAIL.Header not matching");
    }
    public void verifyErrorMessageDisplay(){
       Assert.assertTrue(getWebElement(messageErrorEmail).isDisplayed(),"fail. Error message no Displays.");
       Assert.assertEquals(getTextElement(messageErrorEmail),"Invalid email or password","Fail. connent not matching.");
    }
    public void verifyEmptyEmailAndPass(){
        Assert.assertTrue(getWebElement(messageErrorEmptyPassword).isDisplayed(),"fail.error message Password no Displays.");
        Assert.assertTrue(getWebElement(messageErrorEmptyEmail).isDisplayed(),"fail.error message Email no Displays.");
        Assert.assertEquals(getTextElement(messageErrorEmptyPassword),"The Password field is required.","Fail.content password not matching.");
        Assert.assertEquals(getTextElement(messageErrorEmptyEmail),"The Email Address field is required.","Fail.content Email not matching");
    }

    public void enterEmail(String email){
        setText(inputEmail,email);
    }
    public void enterPassword(String password){
        setText(inputPassword,password);
    }
    // check click remember
    public void clickCheckboxRemember(){
        clickElement(checkboxRemember);
    }
    public void clickOnLoginbutton(){
        clickElement(buttonLogin);
    }
    public void GetcssvalueLogin(){
       getCssValue(buttonLogin,"background-color");
    }
    public DashboardPage login(String email,String password){
        openURL(URL);
        verifyHeaderPage();
        enterEmail(email);
        enterPassword(password);
        clickOnLoginbutton();
     //   verifyErrorMessageDisplay();
        return new DashboardPage(driver);
    }
    public void loginInvalidEmail(String email,String password){
        openURL(URL);
        verifyHeaderPage();
        enterEmail(email);
        enterPassword(password);
        clickOnLoginbutton();
        verifyErrorMessageDisplay();

    }
    public void loginEmpty(String email, String password){
        openURL(URL);
        verifyHeaderPage();
        enterEmail(email);
        enterPassword(password);
        clickOnLoginbutton();
        verifyEmptyEmailAndPass();
    }
    public void loginCheckboxRemember(String email, String password){
        openURL(URL);
        verifyHeaderPage();
        enterEmail(email);
        enterPassword(password);
        clickCheckboxRemember();
        GetcssvalueLogin();
        clickOnLoginbutton();

    }


}
