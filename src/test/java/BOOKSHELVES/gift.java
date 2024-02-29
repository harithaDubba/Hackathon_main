
package BOOKSHELVES;
 
import java.io.IOException;

import java.time.Duration;
 
import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
 
public class gift {

	static WebDriver driver;
 
	public static void main(String[] args) throws InterruptedException, IOException {

		// TODO Auto-generated method stub

		driver=new ChromeDriver();

		driver.get("https://www.urbanladder.com/");

		driver.manage().window().maximize();

	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.findElement(By.xpath("//ul[@class='featuredLinksBar__linkContainer']//li[3]/a")).click();

	  WebElement move=driver.findElement(By.xpath("//h2[@class='_FCNL']"));

	  JavascriptExecutor js = (JavascriptExecutor) driver;

	js.executeScript("arguments[0].scrollIntoView();",move );

	driver.findElement(By.xpath("//ul[@class=\"_2sedU\"]//li[3]")).click();

	String cost=utility.getCelldata("sheet1",0,0);

	driver.findElement(By.id("ip_2251506436")).sendKeys(cost);

	Thread.sleep(1000);

	driver.findElement(By.xpath("//button[@class='_1IFIb _1fVSi action-button _1gIUf _1XfDi']")).click();

	Thread.sleep(1000);

	String rName=utility.getCelldata("sheet1",1,0);

	driver.findElement(By.xpath("//input[@id='ip_4036288348']")).sendKeys(rName);

	Thread.sleep(1000);

	String rEmail=utility.getCelldata("sheet1",2,0);

	driver.findElement(By.xpath("//input[@id='ip_137656023']")).sendKeys(rEmail);

	Thread.sleep(1000);

	String rnum=utility.getCelldata("sheet1",3,0);

	driver.findElement(By.xpath("//input[@id='ip_3177473671']")).sendKeys(rnum);

	Thread.sleep(1000);

	String Name=utility.getCelldata("sheet1",4,0);

	driver.findElement(By.xpath("//input[@id='ip_1082986083']")).sendKeys(Name);

	Thread.sleep(1000);

	String Email=utility.getCelldata("sheet1",5,0);

	driver.findElement(By.xpath("//input[@id='ip_4081352456']")).sendKeys(Email);

	Thread.sleep(1000);

	String num=utility.getCelldata("sheet1",6,0);

	driver.findElement(By.xpath("//input[@id='ip_2121573464']")).sendKeys(num);

	Thread.sleep(1000);

	String adr=utility.getCelldata("sheet1",7,0);

	driver.findElement(By.xpath("//input[@id='ip_2194351474']")).sendKeys(adr);

	Thread.sleep(1000);

	String pin=utility.getCelldata("sheet1",8,0);

	driver.findElement(By.xpath("//input[@id='ip_567727260']")).sendKeys(pin);

	Thread.sleep(1000);

    driver.findElement(By.xpath("//button[@class='_3Hxyv _1fVSi action-button _1gIUf _1XfDi']")).click();

    String s=driver.findElement(By.xpath("//input[@id='ip_137656023']")).getAttribute("validationMessage");

    System.out.println(s);
  
    driver.findElement(By.xpath("//div[@class='_2wEGI']//section[3]//div[2]//div[2]/div[1]")).getText();
}

}

