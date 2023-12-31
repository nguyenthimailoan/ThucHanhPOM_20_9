package loantester.com.Pages.Customers;

import loantester.com.keywords.WebUI;

import static loantester.com.keywords.WebUI.*;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CustomerDetailPage extends AddCustomerPage {

    private WebDriver driver;

    public CustomerDetailPage(WebDriver _driver) {
        super(_driver);
        driver = _driver;
        new WebUI(driver); //khởi tạo anonimous

    }

    public void checkCustomerDetail(String customerName) {
        WebUI.waitForPageLoaded();
//        System.out.println(driver.findElement(company).getAttribute("value"));
//        System.out.println(driver.findElement(vat).getAttribute("value"));
        //       System.out.println(getAttributeElement(phonenumber,"value"));
//        System.out.println(driver.findElement(phonenumber).getAttribute("value"));
//        System.out.println(driver.findElement(company).getAttribute("company"));
//        System.out.println(driver.findElement(company).getAttribute("company"));
        System.out.println(getAttributeElement(company, "value"));
        System.out.println(getAttributeElement(vat, "value"));
        System.out.println(getAttributeElement(phonenumber, "value"));
        System.out.println(getAttributeElement(website, "value"));
        System.out.println(getAttributeElement(address, "value"));
        System.out.println(getAttributeElement(city, "value"));
        System.out.println(getAttributeElement(state, "value"));
        System.out.println(getAttributeElement(zipcode, "value"));


        // kiểm tra thì phải dùng Assert
        // Phải dùng Equals chứ không nên dùng Contains
//        Assert.assertEquals(driver.findElement(company).getAttribute("value"),customerName);
        Assert.assertEquals(getAttributeElement(company, "value"), customerName);
//        Assert.assertEquals(driver.findElement(vat).getAttribute("value"),"10");
        Assert.assertEquals(getAttributeElement(vat, "value"), "10");
        Assert.assertEquals(getAttributeElement(phonenumber, "value"), "0123456789");
        Assert.assertEquals(getAttributeElement(website, "value"), "https://anhtester.com");
        Assert.assertEquals(getAttributeElement(address, "value"), "Viet Nam");
        Assert.assertEquals(getAttributeElement(city, "value"), "Can Tho");
        Assert.assertEquals(getAttributeElement(state, "value"), "Can Tho");
        Assert.assertEquals(getAttributeElement(zipcode, "value"), "92000");

    }


}
