package pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{
	

	public HomePage(WebDriver driver) {
		
		super(driver);
	}
	
	//ELEMENTS	
	@FindBy(xpath="//input[@id='search']") 
	WebElement search;
	
	@FindBy(xpath="//span[@class=\"search-icon icofont-search\"]") 
	WebElement searchIcon;

	@FindBy(xpath="//a[@class='featuredLinksBar__link'][normalize-space()='Gift Cards']")
	public
	WebElement giftCards;
	
	@FindBy(xpath="//section[@class='header__topBar_sectionLeft']")
	WebElement logIn;
	
	@FindBy(xpath="//span[normalize-space()='Living']") 
	WebElement living;
	
	@FindBy(xpath="//li[@class='topnav_item livingunit']//div//div//a[1]") 
	WebElement submenu_head;
	
	@FindBy(xpath="//li[@class='topnav_item livingunit']//li[1]//ul//li") 
	List<WebElement> living_subMenu;
	@FindBy(xpath="//figure[@class=\"header__topBar_logo\"]") 
	WebElement urban;
	@FindBy(xpath="//ul[@data-class=\"slider-track     \"]") 
	WebElement wrapper;
	
	
	//ACTION METHODS
	public void search_for_Book_Shelves(String b){
		//System.out.println(b);
		search.sendKeys(b);
		searchIcon.click();
	}
	

	public void go_to_Living_collections(){
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].scrollIntoView();", living);	
		living.click();
	}
	public  String get_subMenu_Header(){
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
		wait.until(ExpectedConditions.visibilityOfAllElements(submenu_head));
		return submenu_head.getText();
	}
	
	public  List<String> subMenus_of_Living_collections()
	{
	    List<String> seatingAndChairs =new ArrayList<String>();
		for(WebElement SAC : living_subMenu)
		{
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
			wait.until(ExpectedConditions.visibilityOfAllElements(SAC));
			seatingAndChairs.add(SAC.getText());
			
		}
		return seatingAndChairs;
	}
	public Boolean navigatehome() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
		wait.until(ExpectedConditions.visibilityOfAllElements(urban));
     	JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("arguments[0].scrollIntoView();", logoIcon);
		js.executeScript("window.scroll(0, -document.body.scrollHeight)");	
		urban.click();
	//	urban.click();
		return(wrapper.isDisplayed());
		
	}
	
	public void clickOnGiftCard() throws InterruptedException {		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
//		wait.until(ExpectedConditions.visibilityOfAllElements(giftCards));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",giftCards);

		//giftCards.click();
	}
}
