package loantester.com.Pages.Customers;

import loantester.com.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static loantester.com.keywords.WebUI.*;

public class EditCustomerPage extends CustomerDetailPage{

    private String PAGE_URL = "https://crm.anhtester.com/admin/clients/client/288";
    private String PAGE_TEXT = "Profile";
    public By HeaderPage = By.xpath("//h4[normalize-space()='Profile']");

    public By CustomerEdit = By.xpath("//input[@id='company']");
    public By VatEdit = By.xpath("//input[@id='vat']");
    public By PhonenumberEdit = By.xpath("//input[@id='phonenumber']");
    public By WebsiteEdit = By.xpath("//input[@id='website']");
    public By AddressEdit = By.xpath("//textarea[@id='address']");
    public By CityEdit = By.xpath("//input[@id='city']");
    public By StateEdit = By.xpath("//input[@id='state']");
    public By ZipEdit = By.xpath("//input[@id='zip']");
    public By buttonSave = By.xpath("//div[@id='profile-save-section']//button[normalize-space()='Save']");

   public By menuCustomer = By.xpath("//span[normalize-space()='Customers']");
    private WebDriver driver;
    public EditCustomerPage(WebDriver _driver){
        super(_driver);
        driver =_driver;
        new WebUI(driver);
    }
    public void verifyheader(){
        Assert.assertEquals(getTextElement(HeaderPage),PAGE_TEXT,"Fail. header not matching");

    }


    public CustomerDetailPage EditCustomer(){
        waitForPageLoaded();
        driver.findElement(CustomerEdit).clear();
        driver.findElement(VatEdit).clear();
        driver.findElement(PhonenumberEdit).clear();
        driver.findElement(WebsiteEdit).clear();
        driver.findElement(AddressEdit).clear();
        driver.findElement(CityEdit).clear();
        driver.findElement(StateEdit).clear();
        driver.findElement(ZipEdit).clear();
        return new CustomerDetailPage(driver);
    }
    public CustomerDetailPage InputCustomer(){
        setText(CustomerEdit,"Holiday07");
        setText(VatEdit,"11");
        setText(PhonenumberEdit,"1111111111");
        setText(WebsiteEdit,"https://www.arcgis.com/apps/mapviewer/index.html?layers=58ca82eb9e1948a49e812fe90454e73e");
        setText(AddressEdit,"NGUYEN TRAI");
        setText(CityEdit,"HO CHI MINH");
        setText(StateEdit,"4444");
        setText(ZipEdit,"09999");
        clickElement(buttonSave);
        return new CustomerDetailPage(driver);
    }
    public CustomerDetailPage OpenmennuCustomer(){
        waitForPageLoaded();
        clickElement(menuCustomer);
        return new CustomerDetailPage(driver);
    }

}
