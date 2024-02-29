package testCases;

import testBase.BaseClass;
import utilities.ExcelUtility;
import pageObjects.HomePage;
import java.io.IOException;
import java.util.List;
import org.testng.annotations.Test;


public class TC_002_Collections extends BaseClass{
        HomePage hp ;
		ExcelUtility excel ;
@Test(priority=4,groups={"sanity","regression","master"})
public void home_Living() throws InterruptedException, IOException {
		logger.info("***TC_002_Collections has Started***");	
		//NAVIGATING TO LIVING COLLECTIONS
		//driver.navigate().back();
		captureScreen1("homePage");
		hp = new HomePage(BaseClass.driver);
	    hp.go_to_Living_collections();
	    captureScreen1("livig submenu");
	    logger.info("Navivating to living Collections..");
}
@Test(priority=5,dependsOnMethods= {"home_Living"},groups={"regression","master"})
public void submenu_living() throws IOException {
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
