package lab5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends AccountPage{
			
    // ------------------------------------
    public RegisterPage(WebDriver driver) {
        super(driver);
    }
    
    
    // ------------------------------------        
    public void clickAccountRegister(){
    	this.getBtnAccountRegisterElement().click();
    }
    
    public void clickCreateAccount(){
    	this.getBtnCreateAccountElement().click();
    }
    
    public boolean correctAdresEmail(){
    	return (
    		this.driver.findElements(By.xpath("//*[contains(text(), 'Invalid email address')]")).size() == 0 &&
    		this.driver.findElements(By.xpath("//*[contains(text(), 'email address has already been registered')]")).size() == 0
    	);
    }
    
    // ------------------------------------
    public WebElement getBtnAccountRegisterElement(){
    	return this.driver.findElement(By.id("submitAccount"));
    }
    
    public WebElement getBtnCreateAccountElement(){
    	return this.driver.findElement(By.id("SubmitCreate"));
    }
    
    public WebElement getEmailElement(){
    	return this.driver.findElement(By.id("email_create"));
    }
    
    public String getEmail(){
    	return this.getEmailElement().getText();
    }
        
    public void setEmail(String arg){
    	this.getEmailElement().sendKeys(arg);
    }
    
    public WebElement getCustomerFirstNameElement(){
        return this.driver.findElement(By.id("customer_firstname"));
    }

    public String getCustomerFirstName(){
        return this.getCustomerFirstNameElement().getText();
    }
    
    public void setCustomerFirstName(String value){
        this.getCustomerFirstNameElement().sendKeys(value);
    }
    public WebElement getCustomerLastNameElement(){
        return this.driver.findElement(By.id("customer_lastname"));
    }

    
    public WebElement getStreetElement(){
    	return this.driver.findElement(By.id("address1"));
    }
    
    public String getCustomerLastName(){
        return getCustomerLastNameElement().getText();
    }
    
    public void setCustomerLastName(String value){
    	getCustomerLastNameElement().sendKeys(value);
    }

    public WebElement getFirstNameElement(){
        return this.driver.findElement(By.id("firstname"));
    }

    public String getFirstName(){
        return getFirstNameElement().getText();
    }
    
    public String getStreet(){
        return getStreetElement().getText();
    }
    
    public void setFirstName(String value){
    	getFirstNameElement().sendKeys(value);
    }
    public WebElement getLastNameElement(){
        return this.driver.findElement(By.id("lastname"));
    }

    public String getLastName(){
        return getLastNameElement().getText();
    }
    
    public void setLastName(String value){
    	getLastNameElement().sendKeys(value);
    }
    
    public WebElement getCompanyElement(){
        return this.driver.findElement(By.id("company"));
    }

    public String getCompany(){
        return getCompanyElement().getText();
    }
    
    public void setCompany(String value){
    	getCompanyElement().sendKeys(value);
    }
    public WebElement getCityElement(){
        return this.driver.findElement(By.id("city"));
    }

    public String getCity(){
        return getCityElement().getText();
    }
    
    public void setCity(String value){
    	getCityElement().sendKeys(value);
    }
    
    public void setStreet(String value){
    	getStreetElement().sendKeys(value);
    }
    
    public WebElement getStateIdElement(){
        return this.driver.findElement(By.id("id_state"));
    }

    public String getStateId(){
        return getStateIdElement().getText();
    }
    
    public void setStateId(String value){
    	Select select = new Select(getStateIdElement());
    	//select.deselectAll();
    	select.selectByVisibleText(value);
    }
    public WebElement getPostCodeElement(){
        return this.driver.findElement(By.id("postcode"));
    }

    public String getPostCode(){
        return getPostCodeElement().getText();
    }
    
    public void setPostCode(String value){
    	getPostCodeElement().sendKeys(value);
    }
    public WebElement getCountryIdElement(){
        return this.driver.findElement(By.id("id_country"));
    }

    public String getCountryId(){
        return getCountryIdElement().getText();
    }
    
    public void setCountryId(String value){
    	getCountryIdElement().sendKeys(value);
    }
    public WebElement getMobilePhoneElement(){
        return this.driver.findElement(By.id("phone_mobile"));
    }

    public String getMobilePhone(){
        return getMobilePhoneElement().getText();
    }
    
    public void setMobilePhone(String value){
    	getMobilePhoneElement().sendKeys(value);
    }
    public WebElement getAliasElement(){
        return this.driver.findElement(By.id("alias"));
    }

    public String getAlias(){
        return getAliasElement().getText();
    }
    
    public void setAlias(String value){
    	getAliasElement().sendKeys(value);
    }
}
