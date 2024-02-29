package BOOKSHELVES;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class COLLECTIONS {
static WebDriver driver;
//driver.findElement(By.xpath(""));
	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub\
		driver=new ChromeDriver();
		driver.get("https://www.urbanladder.com/");
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    WebElement living=driver.findElement(By.xpath("//li[@class=\"topnav_item livingunit\"]//span"));
	   // Actions act=new Actions(driver);
	    //act.moveToElement(living);
	    living.click();
	    Thread.sleep(1000);
	    WebElement sch=driver.findElement(By.xpath("//li[@class='topnav_item livingunit']//div//div//a"));
	    System.out.println(sch.getText());
	    
	    List<WebElement> sc=driver.findElements(By.xpath("//li[@class='topnav_item livingunit']//li[1]//ul//li"));
	  //  utility.setCelldata(sc);
	    

	}

}
