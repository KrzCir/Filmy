package lab4;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import lab4.pages.*;
import lab4.models.RandomString;

import static org.junit.Assert.*;

public class TestSite {
	
	private static WebDriver driver;

    private HomePage homePage;
    private LoginPage loginPage;

    @BeforeClass
	public static void driverSetup() {

    	System.setProperty(
    		"webdriver.chrome.driver",
    		"src/test/java/resources/chromedriver.exe" 
    	);
    	
		driver = new ChromeDriver();
		driver.manage().timeouts()
                .implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().setSize(new Dimension(300,700));
	}

	@Before
    public void before() {
		homePage = new HomePage(driver);
		loginPage = new LoginPage(driver);
    }

	
	@Test
	public void hasLinkToShoppingCart(){
		homePage.open();
		assertNotNull(homePage.getShoppingCart());
	}
	
	@Test
	public void hasSlider(){
		homePage.open();
		assertNotNull(homePage.getSlider());
	}
	
	@Test
	public void hasLinkCallUs(){
		homePage.open();
		assertNotNull(homePage.getCallUs());
		homePage.clickCallUs();
		assertNotNull(homePage.getSubmitMessage());
	}

	@Test
	public void clickBestSeller()
	{
		homePage.open();
		assertNotNull(homePage.getBestSellers());
		homePage.clickBestSellers();
	    assertEquals(7, homePage.getProducts().size());
	}
	
	@Test
	public void clickBestSellerAndCheckProduct()
	{
		homePage.open();
		assertNotNull(homePage.getBestSellers());
		homePage.clickBestSellers();
		assertNotNull(homePage.getProductByXPath("//*[@id=\"blockbestsellers\"]/li[1]/div/div[2]/h5/a"));
	}
	
	@Test
	public void clickBestSellerAndCheckProductAndVisible()
	{
		homePage.open();
		assertNotNull(homePage.getBestSellers());
		homePage.clickBestSellers();
		
		WebElement p = homePage.getProductByXPath("//*[@id=\"blockbestsellers\"]/li[1]/div/div[2]/h5/a");
		assertNotNull(p);
		assertEquals(true, p.isDisplayed());
	}
	
	@Test
	public void moveToDressesMenu() throws IOException
	{
		homePage.open();
		assertNotNull(homePage.getDressesMenu());
		assertNotNull(homePage.getDressesSubMenu());
		
		homePage.moveToDressMenu();
		
		assertEquals(true, homePage.subMenuIsDisplayed());
		
		homePage.takeScreenshoot("moveToDressesMenu");
	}
	
	@Test
	public void clickLogin()
	{
		homePage.open();
		assertNotNull(homePage.getLoginLink());
		
		homePage.clickLoginLink();
		assertEquals(true, loginPage.isURLLoginPage() );
	}

	
	@Test
	public void failRegisterAccount()
	{
		loginPage.open();
		assertNotNull(loginPage.getEmailElement());
		assertNotNull(loginPage.getButtonCreateAccount());
		
		loginPage.setEmail(".");
		loginPage.createAccount();
		
		assertEquals(false, loginPage.sukcessCreateAccount());
	}
	
	@Test
	public void sukcessRegisterAccountAndLogout()
	{
		loginPage.open();
		assertNotNull(loginPage.getEmailElement());	
		assertNotNull(loginPage.getButtonCreateAccount());
		
		loginPage.setEmail( new RandomString().nextString()+"@test.pl" );
		
		loginPage.createAccount();
		
		assertNotNull(loginPage.getButtonSubmitAccount());
		
		assertNotNull(loginPage.getCustomerFirstNameElement());
		assertNotNull(loginPage.getCustomerLastNameElement());
		assertNotNull(loginPage.getPasswdElement());
		assertNotNull(loginPage.getFirstNameElement());
		assertNotNull(loginPage.getLastNameElement());
		assertNotNull(loginPage.getCompanyElement());
		assertNotNull(loginPage.getCityElement());
		assertNotNull(loginPage.getStateIdElement());
		assertNotNull(loginPage.getPostCodeElement());
		assertNotNull(loginPage.getCountryIdElement());
		assertNotNull(loginPage.getMobilePhoneElement());
		assertNotNull(loginPage.getAliasElement());
		assertNotNull(loginPage.getStreetElement());
					
		loginPage.setCustomerFirstName("Jan");
		loginPage.setCustomerLastName("Kowalski");
		loginPage.setPasswd("passwd");
		loginPage.setFirstName("Jan");
		loginPage.setLastName("Kowalski");
		loginPage.setCompany("Super x");
		loginPage.setStreet("some");
		loginPage.setCity("Bolszewo");
		loginPage.setStateId("Nevada");
		loginPage.setPostCode("84239");
		loginPage.setCountryId("48");
		loginPage.setMobilePhone("512106354");
		loginPage.setAlias("some alias");		
		
		loginPage.submitAccount();
		
		assertNotNull(homePage.getLogoutElement());
		
		homePage.clickLogoutLink();
	}
	
	@Test
	public void failLogin(){
		loginPage.open();
		assertNotNull(loginPage.getButtonSubmitLogin());	
		
		assertNotNull(loginPage.getEmailElement());
		assertNotNull(loginPage.getPasswdElement());
		assertNotNull(loginPage.getButtonSubmitLogin());
		
		loginPage.setEmail("");
		loginPage.setPasswd("");
		
		loginPage.submitLogin();	
		
		assertEquals( false, loginPage.sukcessLoginAccount());
	}
	
	@Test
	public void sukcessLoginAndLogout(){
		loginPage.open();
		assertNotNull(loginPage.getButtonSubmitLogin());	
		
		assertNotNull(loginPage.getLoginElement());
		assertNotNull(loginPage.getPasswdElement());
		assertNotNull(loginPage.getButtonSubmitLogin());
		
		loginPage.setLogin("newSuperTestAccount@gmail.com");
		loginPage.setPasswd("passwd");
		
		loginPage.submitLogin();
		
		assertNotNull(homePage.getLogoutElement());
		
		homePage.clickLogoutLink();
	}
	
	@AfterClass
	public static void cleanup() {
		driver.quit();
	}
}
