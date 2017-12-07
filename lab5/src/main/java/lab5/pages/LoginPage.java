package lab5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AccountPage {
	
	@FindBy( id = "email")
	private WebElement email;
		
	// --- buttons ---
	@FindBy(id = "SubmitLogin")
	private WebElement btnLoginAccount;
	
	// --------------------------------
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	// --------------------------------
    public void clickLoginAccount(){
    	this.getBtnLoginAccount().click();
    }
	
	// --------------------------------
    public WebElement getBtnLoginAccount(){
    	//return this.btnLoginAccount;
    	return driver.findElement(By.id("SubmitLogin"));
    }
    
    public WebElement getEmailElement(){
    	//return this.email;
    	return driver.findElement(By.id("email"));
    }

    public String getEmail(){
    	return this.getEmailElement().getText();
    }
    
    public void setEmail(String value){
    	this.getEmailElement().sendKeys(value);
    }        
}
