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
import lab5.pages.HomePage;
import lab5.pages.LoginPage;
import lab5.pages.RegisterPage;
import lab5.services.DbConector;
import lab5.services.FilmService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class LoginSteps {
	
	// pages
	private HomePage homePage;
	private LoginPage loginPage;
    
	// -------------------------------	
    @Before
    public void setUp() {
    	
    	homePage = new HomePage(RunTest.driver);
    }

    // -------------------------------	
    @Given("^there is a login page object$")
    public void there_is_a_login_page_object() throws Throwable {
    	assertNotNull(RunTest.driver);
    	assertNotNull(homePage);
    	
    	homePage.open();
    	homePage.clickLoginLink();
    	
    	loginPage = new LoginPage(RunTest.driver);
    	assertNotNull(loginPage);
    	
    	assertEquals(true, loginPage.isURLAccountPage());
    }

    // -------------------------------	
    @When("^login (.*?) and password (.*?) are filled$")
    public void login_and_passowrd_are_filled(String email, String passwd){
    	
    	// sprawdza czy kompoenty istenija
    	assertNotNull(loginPage.getEmailElement());
    	assertNotNull(loginPage.getPasswdElement());
    	assertNotNull(loginPage.getBtnLoginAccount());
    	
    	// uzupelnia dane
    	loginPage.setEmail(email);
    	loginPage.setPasswd(passwd);
    }

    // -------------------------------	
    @Then("^form will be posting and account should be loged (.*?)$")
    public void the_account_should_be(String sukcess) throws Throwable {
    	
    	loginPage.clickLoginAccount();
    	
    	// konto zostalo zalogowane
    	if (sukcess.toUpperCase().contains("TRUE"))
    	{
    		assertNotNull(homePage.getLogoutElement());
    		homePage.clickLogoutLink();
    	}
    	
    	// wskazane zostaly nie prawidlowe dnae, 
    	// lub nie istenijace
    	else
    	{
    		assertEquals(true, loginPage.hasUncorrectData() );
    	}
    }

}
