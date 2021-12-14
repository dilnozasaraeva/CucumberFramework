package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.DashBoardPage;
import pages.EmployeeListPage;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;
import utils.GlobalVariables;

public class EmployeeSearchSteps extends CommonMethods {

    @Given("user is logged in with valid admin credentials")
    public void user_is_logged_in_with_valid_admin_credentials() {
        LoginPage login = new LoginPage();
        sendText(login.usernameBox, ConfigReader.getPropertyValue("username"));
        sendText(login.passwordBox, ConfigReader.getPropertyValue("password"));
        click(login.loginBtn);
    }

    @Given("user navigates to employee list page")
    public void user_navigates_to_employee_list_page() {
        DashBoardPage dash = new DashBoardPage();
        click(dash.pimOption);
        click(dash.employeeListOption);
    }

    @When("user enters valid employee id")
    public void user_enters_valid_employee_id() {
        EmployeeListPage emp = new EmployeeListPage();
        GlobalVariables.empId="20119000";
        sendText(emp.idEmployee, GlobalVariables.empId);
    }

    @When("click on search button")
    public void click_on_search_button() {
        EmployeeListPage emp = new EmployeeListPage();
        jsClick(emp.searchButton);
    }

    @Then("user see employee information is displayed")
    public void user_see_employee_information_is_displayed() {
        Assert.assertEquals(GlobalVariables.mapDataFromDb.get("emp_firstname") , GlobalVariables.firstName);
        Assert.assertEquals(GlobalVariables.mapDataFromDb.get("emp_middle_name") , GlobalVariables.middleName);
        Assert.assertEquals(GlobalVariables.mapDataFromDb.get("emp_lastname") , GlobalVariables.lastName);
    }

    @When("user enters valid employee name")
    public void user_enters_valid_employee_name() {
        EmployeeListPage emp = new EmployeeListPage();
        sendText(emp.employeeNameField, "sohail");
    }

    @Given("user is navigated to HRMS")
    public void user_is_navigated_to_hrms() {
        openBrowser();
    }



}

//https://github.com/SyntaxTechnologies/CucumberFrameworkBatch10