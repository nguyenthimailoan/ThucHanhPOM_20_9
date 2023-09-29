package loantester.com.Pages.Customers;

import loantester.com.Pages.Customers.AddCustomerPage;
import loantester.com.keywords.WebUI;
import static loantester.com.keywords.WebUI.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class CustomersPage {
    // Các thuộc tính xác thực Customer Page
    private String PAGE_URL = "https://crm.anhtester.com/admin/clients";

    private String PAGE_TEXT = "Customers Summary";


    // Các Object thuộc Customer

    private By HeaderPageCustomers = By.xpath("//div[@class='panel-body']//h4[contains(.,'Customers Summary')]");
    private By buttonAddCustomer = By.xpath("//a[normalize-space()='New Customer']");
    private By buttonImportCustomer = By.xpath("//a[normalize-space()='Import Customers']");
    private By buttonContacts = By.xpath("//div[@class='_buttons']//a[normalize-space()='Contacts']");
    private By inputSearch = By.xpath("//div[@id='DataTables_Table_0_filter']//input");
    private By tdCustomerName = By.xpath("//tbody/tr[1]/td[3]/a");
    private By deletepage = By.xpath("//tbody/tr[1]/td[3]/div[1][1]/a[3]");

    // Hàm xây dựng
    private WebDriver driver;
    public CustomersPage(WebDriver _driver){
        driver =_driver;
    }

    // hàm xử lý cho chức năng thuộc Customers Page
    public void verifyCustomerPage(){
    // cách 1:    Assert.assertEquals(driver.getCurrentUrl(),PAGE_URL,"URL chưa đúng trang Customers.");
        Assert.assertEquals(getCurrentUrl(),PAGE_URL,"URL chưa đúng trang Customers.");
        Assert.assertTrue(checkElementExist(HeaderPageCustomers),"Header Page Customers not exits");
    // cách 1:    Assert.assertEquals(driver.findElement(HeaderPageCustomers).getText(),PAGE_TEXT,"FAI.Header Page of Customer not matching");
        Assert.assertEquals(getTextElement(HeaderPageCustomers),PAGE_TEXT,"FAIL.Header Page of Customer not matching.");
    }

    public AddCustomerPage clickNewCustomerButton (){
        waitForElementVisible(buttonAddCustomer,10);
   //     driver.findElement(buttonAddCustomer).click();
        clickElement(buttonAddCustomer);
        return new AddCustomerPage(driver);

    }
    public void searchCustomer(String CompanyName){
       waitForPageLoaded();
       waitForElementVisible(inputSearch,10);// chờ đợi input hiển thị rồi search
    //    driver.findElement(inputSearch).sendKeys(CompanyName);
        setText(inputSearch,CompanyName);
        sleep(2);

    }
    public CustomerDetailPage clickOnFirstRowCustomerName(){
       waitForPageLoaded();
    //    driver.findElement(tdCustomerName).click();
        clickElement(tdCustomerName);
        return new CustomerDetailPage (driver);
    }
    public CustomerDetailPage hoverOnFirstRowCustomerName(){
        waitForPageLoaded();
        //    driver.findElement(tdCustomerName).click();
       hoverOnElement(tdCustomerName);
       //clickElement(deletepage);
        return new CustomerDetailPage (driver);
    }

}
