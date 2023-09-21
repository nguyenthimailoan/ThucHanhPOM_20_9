package loantester.com.Pages.Customers;

import org.openqa.selenium.*;

import static loantester.com.keywords.WebUI.clickElement;
import static loantester.com.keywords.WebUI.waitForPageLoaded;

import org.openqa.selenium.Alert;
import org.openqa.selenium.interactions.Actions;
public class DeleteCustomerPage extends CustomersPage{

    private String PAGE_URL = "https://crm.anhtester.com/admin/clients";

    By deletepage = By.xpath("//tbody/tr[1]/td[3]/div[1][1]/a[3]");


    private WebDriver driver;
    public DeleteCustomerPage (WebDriver _driver){
        super(_driver);
        driver = _driver;
    }


    public CustomersPage DeletePage(){
        waitForPageLoaded();
        clickElement(deletepage);
        waitForPageLoaded();
        return new CustomersPage(driver);
    }



}
