package loantester.com.Testcases;

import loantester.com.Common.BaseTest;
import loantester.com.Pages.DashboardPage;
import loantester.com.Pages.LoginPage;
import loantester.com.Pages.Project.AddProjectPage;
import loantester.com.Pages.Project.ProjectPage;
import org.testng.annotations.Test;

public class ProjectTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    ProjectPage projectPage;
    AddProjectPage addProjectPage;

    @Test
    public void TestAddNewProject(){
       loginPage = new LoginPage( driver);
       dashboardPage = loginPage.login("admin@example.com","123456");
       projectPage = dashboardPage.openProject();
       // Kiểm tra trang Project load đúng hay chưa
       projectPage.verifyProjetcPage();
       addProjectPage = projectPage.clickNewProjectButton();

    }


}
