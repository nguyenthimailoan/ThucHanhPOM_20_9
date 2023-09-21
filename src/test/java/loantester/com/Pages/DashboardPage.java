package loantester.com.Pages;

import loantester.com.Pages.Customers.CustomersPage;
import loantester.com.Pages.Project.ProjectPage;
import loantester.com.keywords.WebUI;
import static loantester.com.keywords.WebUI.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DashboardPage {

    //Data trong nội bộ trang Dashboard
    private String PAGE_URL = "https://crm.anhtester.com/admin/";
    private String PAGE_TEXT = "Dashboard Options";

    // Các Object
    By menuCustomer = By.xpath("//span[normalize-space()='Customers']");
    By menuProjects = By.xpath("//span[normalize-space()='Projects']");
    By buttonOptionDashboard = By.xpath("//div[@class='screen-options-btn']");

    By checkboxQuickStatistics = By.xpath("//label[normalize-space()='Quick Statistics']");
    By widgetStatistics = By.xpath("//div[@id='widget-top_stats']");


    //Hàm xây dựng
    private WebDriver driver;
    public DashboardPage(WebDriver _driver){
       driver = _driver;
    }
    public void verifyDashboardPage(){
        //Kiểm tra URL chứa phần thuộc trang DB
        //Kiểm tra Text hoặc Object chỉ có trang DB có
    // CÁCH 1:    Assert.assertEquals(driver.getCurrentUrl(),PAGE_URL,"URL chưa đúng trang Dashboard");
    // CÁCH 2:
          Assert.assertEquals(getCurrentUrl(),PAGE_URL,"URL chưa đúng trang Dashboard");
          Assert.assertTrue(checkElementExist(buttonOptionDashboard),"Dashboard Option not existing");
    }
    // Kiểm tra text Dashboard có đúng không
    public void verifyTextDashboard (){
        Assert.assertEquals(PAGE_TEXT ,"Dashboard Options","FAIL. Text not matching");
    }

    // Hàm xử lý
    public CustomersPage openCustomerPage(){
         waitForPageLoaded();
    //   driver.findElement(menuCustomer).click();
        clickElement(menuCustomer);
       return new CustomersPage(driver);
    }
    public ProjectPage openProject(){
        waitForPageLoaded();
        clickElement(menuProjects);
        return new ProjectPage(driver);
    }

    public void ClickcheckboxQuickStatistics(){
    // driver.findElement(buttonOptionDashboard).click();
        clickElement(buttonOptionDashboard);
     waitForElementVisible(checkboxQuickStatistics,5);
     // driver.findElement(checkboxQuickStatistics).click();
        clickElement(checkboxQuickStatistics);
    }
    public void verifyWidgetStatistics(){
        //kiểm tra widget này đang hiển thị (visible)
        Assert.assertTrue(WebUI.checkElementExist(widgetStatistics),"WidgetStatistics not existing");

        //Nhấn uncheck this widget
        ClickcheckboxQuickStatistics();

        //Kiểm tra widget đã bị ẩn (not visible)

         Assert.assertTrue(WebUI.verifyElementNotVisible(widgetStatistics,5),"The Widget Statistics not existing");

    }
}
