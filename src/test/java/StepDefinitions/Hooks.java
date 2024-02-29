package StepDefinitions;

import java.io.IOException;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import testBase.BaseClass;

public class Hooks {

	 static WebDriver driver;
	 Properties p;
     @Before
    public void setups() throws IOException
    {
    	 p=BaseClass.getProperties();
    	driver=BaseClass.setup(p.getProperty("os"),p.getProperty("browser"));
        System.out.println(p.getProperty("os")+p.getProperty("browser"));
    	driver.get(p.getProperty("appURL"));
    	// System.out.println("url opened"); 
    	driver.manage().window().maximize();
    
    			
    }
	@After
	public static void teardown() {
		driver.quit();
}
}