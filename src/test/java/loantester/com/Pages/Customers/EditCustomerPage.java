package loantester.com.Pages.Customers;

import loantester.com.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static loantester.com.keywords.WebUI.getAttributeElement;
import static loantester.com.keywords.WebUI.waitForPageLoaded;

public class EditCustomerPage extends CustomerDetailPage{

    private String PAGE_URL = "https://crm.anhtester.com/admin/clients/client/288";
    private String PAGE_TEXT = "Profile";

    public By CustomerEdit = By.xpath("//input[@id='company']");
    public By VatEdit = By.xpath("//input[@id='vat']");
    private WebDriver driver;
    public EditCustomerPage(WebDriver _driver){
        super(_driver);
        driver =_driver;
        new WebUI(driver);
    }

    public void EditCustomer(){
        waitForPageLoaded();
        getAttributeElement(CustomerEdit,"Holiday06");

    }

}
