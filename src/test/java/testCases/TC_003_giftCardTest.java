package testCases;

import utilities.ExcelUtility;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.HomePage;
import pageObjects.GiftCard;
import testBase.BaseClass;
import utilities.dataProviders;

public class TC_003_giftCardTest extends BaseClass {
	HomePage hp;
	GiftCard gf;
	ExcelUtility excel;
	
	
	//NAVIGATING TO GIFTGARDS
    @Test(priority=6,groups={"sanity","regression","master"})
	public void click_on_gift_cards() throws Exception {
    	logger.info("***TC_003_giftCardTest has Started***");
    	hp = new HomePage(BaseClass.driver);
    	gf=new GiftCard(BaseClass.driver);
		//hp.navigatehome();
    	boolean ho=hp.navigatehome();
    	Assert.assertEquals(ho,true,"not in home page");
		//Thread.sleep(3000);
    	hp.clickOnGiftCard();
    	captureScreen1("giftcard");
    	logger.info("Gift Card page opened..");
		gf.clickOnBirthday();
		captureScreen1("birthday");
		logger.info("Clicked On birthday..");
	}
    
    //CUSTOMISING GIFT CARD
	@Test(priority=7,dataProvider="dp",dataProviderClass=dataProviders.class,groups={"regression","master"},dependsOnMethods= {"click_on_gift_cards"})
	public void  customise_your_gift_card(String getRecipientName,String getRecipientemail,String getRecipientnumber,String getYourName,String  getYouremail,String  getYourNumber,String  getYouraddress,String  getYourpin,String  getYourmessage,String getRecipientvalidemail,String getGiftCardAmount) throws InterruptedException, IOException {
		
		gf.amountSelectMonth(getGiftCardAmount);
		logger.info("Amount selected..");
		gf.nextButton();
		captureScreen1("yourgiftcard");
		logger.info("customising gift card completed..");
	}
	//TESTING WITH INVALID DETAILS
	@Test(priority=8,dataProvider="dp",dataProviderClass=dataProviders.class,groups={"regression","master"},dependsOnMethods= {"customise_your_gift_card"})
	public void invalidEmail(String getRecipientName,String getRecipientemail,String getRecipientnumber,String getYourName,String  getYouremail,String  getYourNumber,String  getYouraddress,String  getYourpin,String  getYourmessage,String getRecipientvalidemail,String getGiftCardAmount) throws InterruptedException, IOException {
		
		gf.recipientName.sendKeys(getRecipientName);
		gf.recipientEmail.sendKeys(getRecipientemail);
		gf.recipientNum.sendKeys(getRecipientnumber);
		gf.yourName.sendKeys(getYourName);
		gf.youremail.sendKeys(getYouremail);
		logger.info("Invalid email entered..");
		gf.yournumber.sendKeys(getYourNumber);
		gf.youraddress.sendKeys(getYouraddress);
		gf.yourpin.sendKeys(getYourpin);
		gf.text.sendKeys(getYourmessage);
		
		System.out.println(gf.errorMessage());
		captureScreen1("erroemessage");
		excel = new ExcelUtility(p.getProperty("path"));
		logger.info("Writing into excel started..");
		excel.setCellData("error_message", 2, 2, gf.errorMessage());
		logger.info("writing into excel completed..");
	}
	//TESTING WITH VALID DETAILS
	@Test(priority=9,dependsOnMethods= {"invalidEmail"},dataProvider="dp",dataProviderClass=dataProviders.class,groups={"regression","master"})
	public void validEmail(String getRecipientName,String getRecipientemail,String getRecipientnumber,String getYourName,String  getYouremail,String  getYourNumber,String  getYouraddress,String  getYourpin,String  getYourmessage,String getRecipientvalidemail,String getGiftCardAmount) throws InterruptedException, IOException{
		
		gf.validDetail(getRecipientvalidemail);
		captureScreen1("validmailentered");
		logger.info("Invalid email cleared and  valid email id is entered...");
		gf.clickOnConfirm();
	}
	
	//VALIDATING THE DETAILS	
	@Test(priority=10,dependsOnMethods= {"validEmail"},dataProvider="dp",dataProviderClass=dataProviders.class,groups={"regression","master"})
	public void validDetails(String getRecipientName,String getRecipientemail,String getRecipientnumber,String getYourName,String  getYouremail,String  getYourNumber,String  getYouraddress,String  getYourpin,String  getYourmessage,String getRecipientvalidemail,String getGiftCardAmount) throws IOException, InterruptedException {
		logger.info("validate all the given details in the Confirm Details section Started........");
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(getRecipientName,gf.confirmFromname.getText(),"Recipient's names are not equal");
		sa.assertEquals(getRecipientvalidemail,gf.confirmFromemail.getText(),"Recipient's emails are not equal");
		sa.assertEquals(getRecipientnumber,gf.confirmFromnum.getText(),"Recipient's phone numbers are not equal");
		sa.assertEquals(getYourName,gf.confirmToname.getText(),"Recipient's names are not equal");
		sa.assertEquals(getYouremail,gf.confirmToemail.getText(),"To mails are not equal");
		sa.assertEquals(getYourNumber,gf.confirmTonumber.getText(),"To number not equal");
		sa.assertEquals(getYourpin,gf.getConfimDetailsPin(),"To pin are not equal");
		sa.assertEquals(getGiftCardAmount,gf.getConfimDetailsAmount(),"In confirm details amount is not equal");
		sa.assertEquals(getYourmessage,gf.confirmmsg.getText(),"gif message is not equal");
		sa.assertAll();
		captureScreen1("confirmdetails");
		logger.info("validate all the given details in the Confirm Details section completed........");
		logger.info("***TC_003_giftCardTest has completed***");
	}
	
}
