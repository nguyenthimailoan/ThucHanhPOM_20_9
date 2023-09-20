package loantester.com.Pages.Customers;

import loantester.com.keywords.WebUI;
import static loantester.com.keywords.WebUI.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class AddCustomerPage extends CustomersPage {

    // Các thuộc tính
    private String PAGE_URL = "https://crm.anhtester.com/admin/clients/client";
    private String PAGE_TEXT ="Customer Details";

    By tabCustomerDetail = By.xpath("//a[@aria-controls='contact_info']");
    public By company = By.xpath("//input[@id='company']");
    public By vat = By.xpath("//input[@id='vat']");
    public By phonenumber = By.xpath("//input[@id='phonenumber']");
    public By website = By.xpath("//input[@id='website']");

    public By dropdownGroups = By.xpath("//label[@for='groups_in[]']/following-sibling::div");
    public By inputGroups = By.xpath("//div[@app-field-wrapper='groups_in[]']//input");

    public By currency = By.xpath("//button[@data-id='default_currency']");
    public By language = By.xpath("//button[@data-id='default_language']");
    public By address = By.xpath("//textarea[@id='address']");
    public By city = By.xpath("//input[@id='city']");
    public By state = By.xpath("//input[@id='state']");
    public By zipcode = By.xpath("//input[@id='zip']");
    public By dropdowncountry = By.xpath("//label[@for='country']/following-sibling::div");
    public By inputcountry = By.xpath("//label[@for='country']/following-sibling::div//input[@type='search']");
    public By buttonSave = By.xpath("//div[@id='profile-save-section']//button[normalize-space()='Save']");



    private WebDriver driver;
    public AddCustomerPage(WebDriver _driver){
        super(_driver);  // tuân theo cấu trúc hàm xây dựng của thằng cha (CustomersPage)
        driver =_driver;  // Khởi tạo driver của thằng con (AddCustomerPage)
        new WebUI(driver);
    }

    public void selectGroups(String groupName){
        clickElement(dropdownGroups);
        setText(inputGroups,groupName);
        clickElement(dropdownGroups);

    }
    public void selectCountry(String countryName){
        clickElement(dropdowncountry);
        setText(inputcountry,countryName);
        clickElement(dropdowncountry);
    }
    public void AddDataNewCustomer(String CUSTOMER_NAME){

          waitForPageLoaded();
//        driver.findElement(By.xpath("//input[@id='company']")).sendKeys(CUSTOMER_NAME);
//        driver.findElement(vat).sendKeys("10");
//        driver.findElement(phonenumber).sendKeys("0123456789");
//        driver.findElement(website).sendKeys("https://anhtester.com");
//        driver.findElement(dropdownGroups).click();
//        driver.findElement(inputGroups).sendKeys("Gold", Keys.ENTER);
//        driver.findElement(address).sendKeys("Viet Nam");
//        driver.findElement(city).sendKeys("Can Tho");
//        driver.findElement(state).sendKeys("Can Tho");
//        driver.findElement(zipcode).sendKeys("92000");
//        driver.findElement(dropdowncountry).click();
//        driver.findElement(inputcountry).sendKeys("Vietnam", Keys.ENTER);
//        driver.findElement(buttonSave).click();




        setText(company,CUSTOMER_NAME);
        setText(vat,"10");
        setText(phonenumber,"0123456789");
        setText(website,"https://anhtester.com");
        selectGroups("Gold");
        setText(address,"Viet Nam");
        setText(city,"Can Tho");
        setText(state,"Can Tho");
        setText(zipcode,"92000");
        selectCountry("Viet Nam");
        clickElement(buttonSave);
        waitForPageLoaded();

        //click back về Customers List


    }
}