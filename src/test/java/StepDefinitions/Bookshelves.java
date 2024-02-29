package StepDefinitions;

import java.io.IOException;
import java.util.Map;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

//import factory.BaseClassc;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BookShelves;
//import pageObjects.BookShelves;
import pageObjects.HomePage;
import testBase.BaseClass;
import utilities.ExcelUtility;



public class Bookshelves extends BaseClass{
	public static WebDriver driver;
	public HomePage hp;
	public BookShelves bs;
	ExcelUtility excel;
	//p=BaseClass.getProperties();
	Logger logger;
	@Given("the user navigate to the urban ladder page and search as {string}")
	public void the_user_navigate_to_the_urban_ladder_page_and_search_as(String search) throws IOException {
		logger=BaseClass.getLogger();
		logger.info("Bookshelves step Definition started...............");
		//Hooks hk = new Hooks();
		///hk.setup();
		hp = new HomePage(BaseClass.driver);
		//System.out.println(search);
		hp.search_for_Book_Shelves(search);
		
	}
	@When("the user should be redirected to the Bookshelves page close the popup")
	public void the_user_should_be_redirected_to_the_bookshelves_page_close_the_popup() throws IOException {
		bs = new BookShelves(BaseClass.driver);
		bs.closePopup();
		captureScreen1("popup");
		logger.info("Popup Closed..");
	}

	@When("select category as {string} select price as below fifteen thousand exclude out of stock  sort By  hight to low")
	public void select_category_as_select_price_as_below_fifteen_thousand_exclude_out_of_stock_sort_by_hight_to_low(String cat) throws InterruptedException {
		bs = new BookShelves(BaseClass.driver);
		bs.select_category(cat);
		logger.info("Selected Category as Kids Book Shelves..");
		bs.select_price_range();
		logger.info("Selected Price Range..");
		bs.select_sortby_as_high_to_low();
		logger.info("Selected Sort By..");
		bs.select_exclude_outofstock();
		logger.info("selected Exclude Out of Stock..");
	}
	@Then("the user should get the first three bookshelves name and price")
	public void the_user_should_get_the_first_three_bookshelves_name_and_price() throws InterruptedException, IOException {
		excel = new ExcelUtility(".\\TestData\\ExcelData.xlsx");
		int j=1;
		Map<String, Integer> map =bs.get_first_three_products();
		captureScreen1("three books");
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
		      System.out.println(entry.getKey() + "----" + entry.getValue());
		      excel.setCellData("BookShelves", j, 3, entry.getKey());
		      excel.setCellData("BookShelves", j, 4, entry.getValue());
		      logger.info("Adding products to Excel Sheet..");
		      j = j+1;
		      
		    }
		logger.info("Adding products to Excel Sheet completed..");
	}
	

}
