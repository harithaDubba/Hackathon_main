package StepDefinitions;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.Logger;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import testBase.BaseClass;
import utilities.ExcelUtility;

public class Living {
	HomePage hp ;
	ExcelUtility excel ;
	Logger logger;
	@Given("user should be on home page")
	public void user_should_be_on_home_page() {
		logger=BaseClass.getLogger();
		hp = new HomePage(BaseClass.driver);
		hp.navigatehome();
		
	}

	@When("user click on living")
	public void user_click_on_living() throws IOException {
		//hp = new HomePage(BaseClass.driver);
	    hp.go_to_Living_collections();
	    BaseClass.captureScreen1("livig submenu");
	    logger.info("Navivating to living Collections..");
	}

	@Then("get all the submenu of seating and chair")
	public void get_all_the_submenu_of_seating_and_chair() throws IOException {
		 excel = new ExcelUtility(".\\TestData\\ExcelData.xlsx");
		    String heading = hp.get_subMenu_Header();
		    System.out.println(heading);
		    excel.setCellData("Living_subMenu", 1, 1, heading);
		    
		    //PRINTING ALL SUBMENUS
		    List<String> seatingAndChairs = hp.subMenus_of_Living_collections();
		    int j=3;
		    logger.info("Adding SubMenu List to Excel Started..");
		    for(String s : seatingAndChairs	) {
		    	System.out.println(s);
		    	excel.setCellData("Living_subMenu", j, 1, s);
		    	j=j+1;
		    }
		    logger.info("Adding SubMenu to Excel Completed..");

		}
	}
