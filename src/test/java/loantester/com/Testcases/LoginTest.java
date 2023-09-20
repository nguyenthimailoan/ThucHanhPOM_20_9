package loantester.com.Testcases;

import loantester.com.Common.BaseTest;
import loantester.com.Pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    LoginPage loginpage;

    @Test
    public void loginTestSuccess() {
        // khởi tạo đối tượng trang loginpage
        // truyền driver từ BaseTest
        loginpage = new LoginPage(driver);

        // gọi hàm "login" từ LoginPage để dùng
        loginpage.login("admin@example.com", "123456");

    }

    @Test
    public void loginTestInvalidEmail() {
        // khởi tạo đối tượng trang loginpage
        // truyền driver từ BaseTest
        loginpage = new LoginPage(driver);

        // gọi hàm "login" từ LoginPage để dùng
        loginpage.loginInvalidEmail("admin@example.com123", "123456");

    }

    @Test
    public void LoginTestInvalidEmptyEmail() {
        loginpage = new LoginPage(driver);
        loginpage.loginEmpty("", "");
    }

    @Test
    public void loginTestSuccessCheckboxRemember() {
        // khởi tạo đối tượng trang loginpage
        // truyền driver từ BaseTest
        loginpage = new LoginPage(driver);

        // gọi hàm "login" từ LoginPage để dùng
        loginpage.loginCheckboxRemember("admin@example.com", "123456");


    }
}