package loantester.com.Pages.Project;

import org.openqa.selenium.By;
import loantester.com.keywords.WebUI;

import static loantester.com.keywords.WebUI.*;
import org.openqa.selenium.WebDriver;

public class AddProjectPage extends ProjectPage{
   private String PROJECT_URL="https://crm.anhtester.com/admin/projects";
   private String PROJECT_TEXT="Add new project";

   // Các Object thuộc Project
   By projectname = By.xpath("//input[@id='name']");
   By customer = By.xpath("//div[@class='dropdown bootstrap-select ajax-search bs3']");
   By inputcustomer = By.xpath("//input[@placeholder='Type to search...'])[1]");
   By selectcustomer = By.xpath("//div[@class='dropdown-menu open']/div[@class='inner open']/ul/li[1]");
   By checkboxCaculate = By.xpath("(//label[normalize-space()='Calculate progress through tasks'])[1]");
   By dropbillingtype = By.xpath("//label[@for='billing_type']/following-sibling::div[@class='dropdown bootstrap-select bs3']");
   By clickbillingtype = By.xpath("//div[@class='inner open']//ul//li[2]");
   By dropStatus= By.xpath("//button[@title='In Progress']");
   By clickStatus = By.xpath("(//span[normalize-space()='On Hold'])[1]");
   By Totalrate = By.xpath("//input[@id='project_cost']");
   By estimated = By.xpath("//input[@id='estimated_hours']");
   By member = By.xpath("//label[normalize-space()='Members']/following-sibling::div");
   By inputmember = By.xpath("//label[normalize-space()='Members']/following-sibling::div//input");
   By startdate = By.xpath("//label[@for='start_date']/following-sibling::div");
   By inputstartdate = By.xpath("//div[normalize-space()='22']");
 //   By deadline = By.xpath("//label[normalize-space()='Deadline']/following-sibling::div");
 //  By inputdeadline = By.xpath("");
   By tags = By.xpath("//input[@placeholder='Tag']");
   By savebutton = By.xpath("//button[normalize-space()='Save']");


   public void Customer(String CUSTOMER_NAME){
       clickElement(customer);
       setText(inputcustomer,CUSTOMER_NAME);
       clickElement(selectcustomer);

   }


   // Các hàm xây dựng
    private WebDriver driver;
    public AddProjectPage (WebDriver _driver){
        super (_driver);
        driver = _driver;
        new WebUI(driver);
    }

    // Hàm xử lý
    public void AddProject(String PROJECT_NAME){
        waitForPageLoaded();
       setText(projectname,PROJECT_NAME);
       Customer("Minh");
       clickElement(checkboxCaculate);
       clickElement(dropbillingtype);
       clickElement(clickbillingtype);
       clickElement(dropStatus);
       clickElement(clickStatus);



    }

}
