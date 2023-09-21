package loantester.com.Pages.Project;

import loantester.com.Pages.DashboardPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static loantester.com.keywords.WebUI.*;

public class ProjectPage {
    // các thuộc tinhs
    private String PROJETC_URL ="https://crm.anhtester.com/admin/projects";
    private String PROJETC_TEXT = "Projects Summary";

    // các đối tượng Object
    public By HeaderPageProject = By.xpath("//div[@class='panel-body']//h4[contains(.,'Projects Summary')]");
    public By buttonAddProjetc = By.xpath("//a[normalize-space()='New Project']");
    public By inputSearch = By.xpath("//input[@class='form-control input-sm']");
    public By tdProjectName = By.xpath("//tbody/tr[1]/td[2]");


    // Hàm xây dựng
    private WebDriver driver;
    public ProjectPage (WebDriver _driver){
        driver =_driver;
    }

    // Hàm xử lý chức năng thuộc Project
    public void verifyProjetcPage(){
        Assert.assertEquals(getCurrentUrl(),PROJETC_URL,"URL chưa đúng trang Projetc");
        Assert.assertTrue(checkElementExist(HeaderPageProject),"Header page Project not exit");
        Assert.assertEquals(getTextElement(HeaderPageProject),PROJETC_TEXT,"FAIL.Header Page of Customer not matching");

    }
    public AddProjectPage clickNewProjectButton(){
        waitForElementVisible(buttonAddProjetc,10);
        clickElement(buttonAddProjetc);
        return new AddProjectPage();
    }
    public void SearchProject(String Projectname){
        waitForPageLoaded();
        waitForElementVisible(inputSearch,10);
        setText(inputSearch,Projectname);
        sleep(2);
    }
    public void clickOnFirstRowProjectName(){
        waitForPageLoaded();
        clickElement(tdProjectName);
    }

}
