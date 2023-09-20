package loantester.com.Testcases;

import loantester.com.Common.BaseTest;
import loantester.com.Pages.Customers.AddCustomerPage;
import loantester.com.Pages.Customers.CustomerDetailPage;
import loantester.com.Pages.Customers.CustomersPage;
import loantester.com.Pages.DashboardPage;
import loantester.com.Pages.LoginPage;
import org.testng.annotations.Test;

public class CustomersTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomersPage customersPage;
    AddCustomerPage addCustomerPage;
    CustomerDetailPage customerDetailPage;

    @Test
    public void testAddNewCustomer(){
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.login("admin@example.com","123456");
     // customersPage = new CustomersPage(driver);
        dashboardPage.verifyDashboardPage();
        dashboardPage.verifyTextDashboard();

        customersPage = dashboardPage.openCustomerPage();

        //Kiểm tra trang Customer Page load được hay chưa và đúng hay chưa
        customersPage.verifyCustomerPage();
        //click vào nút New Customer
        addCustomerPage=customersPage.clickNewCustomerButton();

        String CUSTOMER_NAME = "Holiday06";
        addCustomerPage.AddDataNewCustomer(CUSTOMER_NAME);

        //Mở lại trang Customer
        dashboardPage.openCustomerPage();

        //Search giá trị customer vừa Add
       customersPage.searchCustomer(CUSTOMER_NAME);

       //Click vào giá trị Cusstomer Name dòng đầu tiên
        customerDetailPage = customersPage.clickOnFirstRowCustomerName();
        //check customer detail
        customerDetailPage.checkCustomerDetail("Holiday06");


    }

}
