package testCases;

import utilities.ExcelUtility;
import testBase.BaseClass;
import pageObjects.HomePage;
import pageObjects.BookShelves;
import java.io.IOException;
import java.util.Map;

import org.testng.annotations.Test;

public class TC_001_productsSearch extends BaseClass
{
	BaseClass bc ;
	HomePage hp;
	BookShelves bs;
	ExcelUtility excel;
	@Test(priority=1,groups={"sanity","regression","master"})
	public void search_bookshelves() throws IOException
	{
		  logger.info("***TC_001_productsSearch has Started***");
			//SEACH FOR BOOKSHELVES
			hp = new HomePage(BaseClass.driver);
			hp.search_for_Book_Shelves(p.getProperty("search"));
			captureScreen1("search Book Shelves");
			logger.info("searched for Book Shelves..");
	}
	@Test(priority=2,dependsOnMethods= {"search_bookshelves"},groups={"sanity","regression","master"})
	public void get_KidsBookShelves() throws InterruptedException, IOException {
			//SELECT FILTERS
			bs = new BookShelves(BaseClass.driver);
			bs.closePopup();
			captureScreen1("popup");
			logger.info("Popup Closed..");
			bs.select_category(p.getProperty("book"));
			logger.info("Selected Category as Kids Book Shelves..");
			bs.select_price_range();
			logger.info("Selected Price Range..");
			bs.select_sortby_as_high_to_low();
			logger.info("Selected Sort By..");
			bs.select_exclude_outofstock();
			logger.info("selected Exclude Out of Stock..");
			captureScreen1("after filters");
	}	
	@Test(priority=3,dependsOnMethods= {"get_KidsBookShelves"},groups={"regression","master"})
	public void first_ThreeBookShelves() throws InterruptedException, IOException 
	{
			//PRINT FIRST 3 PRODUCTS
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
