package StepDefinitions;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.GiftCard;
import pageObjects.HomePage;
import testBase.BaseClass;
import utilities.ExcelUtility;

public class giftcard {
	WebDriver driver;
	HomePage hp;
	GiftCard gf;
	ExcelUtility excel;
	Logger logger;
	Properties p;
	@Given("user on homePage and  user click o gift card")
	public void user_on_home_page_and_user_click_o_gift_card() throws InterruptedException, IOException {
		hp=new HomePage(BaseClass.driver);
		hp.clickOnGiftCard();
		BaseClass.captureScreen1("giftcard");
		logger=BaseClass.getLogger();
	    logger.info("Gift Card page opened..");
	}

	 @When("scroll down to the birthday\\/anniversary click on that")
	 public void scroll_down_to_the_birthday_anniversary_click_on_that() throws InterruptedException, IOException {
		gf=new GiftCard(BaseClass.driver);
		 gf.clickOnBirthday();
		 BaseClass.captureScreen1("birthday");
		logger.info("Clicked On birthday..");
	 }

	 @When("fill customize your gift card amount as {string} and select month and date click on next")
	 public void fill_customize_your_gift_card_amount_as_and_select_month_and_date_click_on_next(String amount) throws InterruptedException, IOException {
		gf.amountSelectMonth(amount);
		logger.info("Amount selected..");
		gf.nextButton();
		BaseClass.captureScreen1("yourgiftcard");
		logger.info("customising gift card completed..");
	 }

	 @When("fill the all recipient details and to deatils with wrong email id click on confirm capture the error messsage")
	 public void fill_the_all_recipient_details_and_to_deatils_with_wrong_email_id_click_on_confirm_capture_the_error_messsage(DataTable dataTable) throws InterruptedException, IOException {
	     Map<String,String> dataMap=dataTable.asMap(String.class,String.class);
	     gf=new GiftCard(BaseClass.driver);
	     p=BaseClass.getProperties();
	     gf.recipientName.sendKeys(dataMap.get("Recipientname"));
			gf.recipientEmail.sendKeys(dataMap.get("Recipientemail"));
			gf.recipientNum.sendKeys(dataMap.get("Recipientnumber"));
			gf.yourName.sendKeys(dataMap.get("YourName"));
			gf.youremail.sendKeys(dataMap.get("YourEmail"));
			logger.info("Invalid email entered..");
			gf.yournumber.sendKeys(dataMap.get("YourNumber"));
			gf.youraddress.sendKeys(dataMap.get("YourAddress"));
			gf.yourpin.sendKeys(dataMap.get("YourPin"));
			gf.text.sendKeys(dataMap.get("YourMessage"));
			gf.clickOnConfirm();
			System.out.println(gf.errorMessage());
			BaseClass.captureScreen1("errormessage");
			excel = new ExcelUtility(p.getProperty("path"));
			logger.info("Writing into excel started..");
			excel.setCellData("error_message", 2, 2, gf.errorMessage());
			logger.info("writing into excel completed..");
	 }

	 @When("enter valid email id and clickON confirm")
	 public void enter_valid_email_id_and_click_on_confirm(DataTable dataTable) throws InterruptedException, IOException {
		 Map<String,String> dataMap=dataTable.asMap(String.class,String.class);
		 gf.validDetail(dataMap.get("ValidREmail"));
		 BaseClass.captureScreen1("validmailentered");
			logger.info("Invalid email cleared and  valid email id is entered...");
			gf.clickOnConfirm();
	 }

	 @Then("validate the all the from and to details")
	 public void validate_the_all_the_from_and_to_details(DataTable dataTable) {
		 Map<String,String> dataMap=dataTable.asMap(String.class,String.class);
			Assert.assertEquals(dataMap.get("Recipientname"),gf.confirmFromname.getText());
			Assert.assertEquals(dataMap.get("Recipientemail"),gf.confirmFromemail.getText());
			Assert.assertEquals(dataMap.get("Recipientnumber"),gf.confirmFromnum.getText());
			Assert.assertEquals(dataMap.get("YourName"),gf.confirmToname.getText());
			Assert.assertEquals(dataMap.get("YourEmail"),gf.confirmToemail.getText());
			Assert.assertEquals(dataMap.get("YourNumber"),gf.confirmTonumber.getText());
			Assert.assertEquals(dataMap.get("YourPin"),gf.getConfimDetailsPin());
			Assert.assertEquals(dataMap.get("YourMessage"),gf.confirmmsg.getText());
			Assert.assertEquals(dataMap.get("YourAddress"),gf.confirmToadr.getText());
	 }

}
