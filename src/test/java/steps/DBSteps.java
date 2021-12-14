package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utils.DBUtils;
import utils.GlobalVariables;

import java.util.Map;

public class DBSteps {
	
	@Then("query HRMS database")
	public void query_database_and_get_data() {
	   
	GlobalVariables.mapDataFromDb=DBUtils.mapFromDb("SELECT emp_firstname, emp_middle_name, emp_lastname "
							   + "FROM hs_hr_employees "
				               + "WHERE employee_id="+GlobalVariables.empId);
	}

    @And("verify data is coming from proper table")
    public void verifyDataIsComingFromProperTable() {
		GlobalVariables.mapDataFromDb=DBUtils.mapFromDb("SELECT emp_firstname, emp_middle_name, emp_lastname "
				+ "FROM hs_hr_employees "
				+ "WHERE employee_id="+GlobalVariables.empId);
    }

	@Then("verify from db")
	public void verifyFromDb() {
		String query="select * from ohrm_user where user_name='"+GlobalVariables.userName+"'";
		System.out.println(query);
		GlobalVariables.mapDataFromDb = DBUtils.mapFromDb(query);
		Assert.assertEquals(GlobalVariables.mapDataFromDb.get("user_name") , GlobalVariables.userName);

	}
}
