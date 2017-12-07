package bdd;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lab5.enums.Genres;
import lab5.interfaces.IDbConector;
import lab5.interfaces.IFilmService;
import lab5.models.Film;
import lab5.models.RandomString;
import lab5.pages.HomePage;
import lab5.pages.LoginPage;
import lab5.pages.RegisterPage;
import lab5.services.DbConector;
import lab5.services.FilmService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RegisterSteps {
	
	// pages
	private HomePage homePage;
	private RegisterPage registerPage;
	private boolean freeEmail;
    
	// -------------------------------	
    @Before
    public void setUp() {
    	homePage = new HomePage(RunTest.driver);
    }

    // -------------------------------	
    @Given("^there is a register page object$")
    public void there_is_a_register_page_object() throws Throwable {
    	
    	assertNotNull(RunTest.driver);
    	assertNotNull(homePage);
    	
    	homePage.open();
    	homePage.clickLoginLink();
    	
    	registerPage = new RegisterPage(RunTest.driver);
    	assertNotNull(registerPage);
    	
    	assertEquals(true, registerPage.isURLAccountPage());
    }

    // -------------------------------	
    @When("^fields are filled (.*?), (.*?), (.*?), (.*?), (.*?), (.*?), (.*?), (.*?), (.*?), (.*?), (.*?), (.*?) and form has posted$")
    public void fields_are_filled(
    		String email,		String passwd, 	String firstName, 
    		String lastName, 	String company,	String city, 		
    		String street, 		String state, 	String postalCode, 
    		String country, 	String phone, 	String alias) {
    	
    	// sprawdzanie czy pola istnieja
    	assertNotNull(registerPage.getEmailElement());
    	assertNotNull(registerPage.getBtnCreateAccountElement());
    	
    	registerPage.setEmail( (email.toLowerCase().contains("rand")) ? new RandomString().nextString()+"@test.te" : email);
    	
    	registerPage.clickCreateAccount();
    	
    	freeEmail = registerPage.correctAdresEmail();
    	
    	if (freeEmail == true)
    	{
	    	// sprawdzanie czy pola istnieja
			assertNotNull(registerPage.getCustomerFirstNameElement());
			assertNotNull(registerPage.getCustomerLastNameElement());
			assertNotNull(registerPage.getPasswdElement());
			assertNotNull(registerPage.getFirstNameElement());
			assertNotNull(registerPage.getLastNameElement());
			assertNotNull(registerPage.getCompanyElement());
			assertNotNull(registerPage.getCityElement());
			assertNotNull(registerPage.getStateIdElement());
			assertNotNull(registerPage.getPostCodeElement());
			assertNotNull(registerPage.getCountryIdElement());
			assertNotNull(registerPage.getMobilePhoneElement());
			assertNotNull(registerPage.getAliasElement());
			assertNotNull(registerPage.getStreetElement());
	    	
			// uzupe³nienie danych
			registerPage.setCustomerFirstName(firstName);
			registerPage.setCustomerLastName(lastName);
			registerPage.setPasswd(passwd);
			registerPage.setFirstName(firstName);
			registerPage.setLastName(lastName);
			registerPage.setCompany(company);
			registerPage.setStreet(street);
			registerPage.setCity(city);
			registerPage.setStateId(state);
			registerPage.setPostCode(postalCode);
			registerPage.setCountryId(country);
			registerPage.setMobilePhone(phone);
			registerPage.setAlias(alias);  
			
			// sprawdzanie czy istnieje przycisk
			assertNotNull(registerPage.getBtnAccountRegisterElement());
			
			registerPage.clickAccountRegister();
    	}
    }

    // -------------------------------	
    @Then("^form will be posting and account should be registered (.*?)$")
    public void the_account_should_be(String sukcess) throws Throwable {
    	
    	if (freeEmail)
    	{
    		assertNotNull(homePage.getLogoutElement());
    		homePage.clickLogoutLink();
    	}
    	else
    	{
    		assertEquals(freeEmail,sukcess.toUpperCase().contains("TRUE"));
    	}
    }

}
