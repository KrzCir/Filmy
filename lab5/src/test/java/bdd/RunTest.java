package bdd;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.BeforeClass;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = { "pretty", "html:target/cucumber" },
        features = "src/test/java/resources/lab5.feature"
)

public class RunTest {
	
	public static WebDriver driver;
	
    @BeforeClass
	public static void driverSetup() {

    	System.setProperty(
    		"webdriver.chrome.driver",
    		"C:\\chromedriver_win32\\chromedriver.exe"
    		//"C:\\pathto\\my\\chromedriver.exe"
    		//"src/test/java/resources/chromedriver.exe" 
    	);
    	
		driver = new ChromeDriver();
		driver.manage().timeouts()
                .implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().setSize(new Dimension(300,700));
	}
    
	@AfterClass
	public static void cleanup() {
		driver.quit();
	}
}