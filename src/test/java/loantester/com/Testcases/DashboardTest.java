package loantester.com.Testcases;

import loantester.com.Common.BaseTest;
import loantester.com.Pages.Customers.CustomersPage;
import loantester.com.Pages.DashboardPage;
import loantester.com.Pages.LoginPage;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

      LoginPage loginpage;
      DashboardPage dashboardPage;
      CustomersPage customersPage;


      @Test
    public void testOpenMenuOnDashboard(){
          loginpage = new LoginPage(driver);

          //Liên kết trang được xảy ra nhờ hàm login trả về là sự khởi tạo của trang Dashboard
          dashboardPage = loginpage.login("admin@example.com","123456");

          // Kiểm tra trang Dashboard là đúng
          dashboardPage.verifyDashboardPage();
          dashboardPage.verifyTextDashboard();

          // kiểm tra menu Customers click vào mở được trang
          customersPage =dashboardPage.openCustomerPage();
          customersPage.verifyCustomerPage();

      }

      @Test
      public void testAddCustomer(){
          //Login > open Customer Page > Add Customer
          loginpage = new LoginPage(driver);
          loginpage.login("admin@example","123456");
      //    dashboardPage = new DashboardPage(driver);
          dashboardPage.verifyDashboardPage();




      }

      @Test
      public void testFilterWidgeOnDashboard(){
            loginpage = new LoginPage(driver);
            loginpage.login("admin@example","123456");
            dashboardPage = new DashboardPage(driver);
            dashboardPage.verifyDashboardPage();

            //check filter widgets on Dashboard
           dashboardPage.ClickcheckboxQuickStatistics();
           dashboardPage.verifyWidgetStatistics();
      }
}
