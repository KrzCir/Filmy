package lab5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class AccountPage {

	protected final WebDriver driver;
	
	@FindBy(id = "passwd")
	private WebElement passwd;
	
	// --------------------------------
	public AccountPage(WebDriver driver)
	{
		this.driver = driver;
	}

    public AccountPage open()
    {
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        PageFactory.initElements(driver, this);
        
        return this;    	
    }	
	
    // --------------------------------
    public boolean isURLAccountPage()
    {
    	return this.driver.getCurrentUrl()
    		.contains("automationpractice.com/index.php?controller=authentication&back=my-account");
    }
    
    public boolean hasUncorrectData(){
    	return this.driver.findElement(By.xpath("//*[contains(text(), 'error')]")) != null;
    }
    
    // --------------------------------
    public WebElement getPasswdElement(){
        //return this.passwd;
    	return driver.findElement(By.id("passwd"));
    }

    public String getPasswd(){
        return this.getPasswdElement().getText();
    }
    
    public void setPasswd(String value){
    	this.getPasswdElement().sendKeys(value);
    }
}
