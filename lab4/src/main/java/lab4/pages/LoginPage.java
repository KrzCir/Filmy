package lab4.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	private final WebDriver driver;
	
	@FindBy( id = "email_create")
	private WebElement email;
	
	@FindBy(id = "SubmitCreate")
	private WebElement buttonCreateAccount;
	
	@FindBy(id = "submitAccount")
	private WebElement buttonSubmitAccount;
	
	@FindBy(id = "SubmitLogin")
	private WebElement buttonSubmitLogin;
	
	@FindBy(id = "customer_firstname")
	private WebElement customerFirstName;
	
	@FindBy(id = "customer_lastname")
	private WebElement customerLastName;
	
	@FindBy(id = "passwd")
	private WebElement passwd;
	
	@FindBy(id = "firstname")
	private WebElement firstName;
	
	@FindBy(id = "lastname")
	private WebElement lastName;
	
	@FindBy(id = "company")
	private WebElement company;
	
	@FindBy(id = "city")
	private WebElement city;
	
	@FindBy(id = "id_state")
	private WebElement stateId;
	
	@FindBy(id = "postcode")
	private WebElement postCode;
	
	@FindBy(id = "id_country")
	private WebElement countryId;
	
	@FindBy(id = "phone_mobile")
	private WebElement mobilePhone;
	
	@FindBy(id = "alias")
	private WebElement alias;
	
    // ------------------------------------
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    
    // ------------------------------------
    public WebElement getButtonCreateAccount(){
    	return this.buttonCreateAccount;
    }
    
    public WebElement getButtonSubmitAccount(){
    	return this.buttonSubmitAccount;
    }
    
    public WebElement getButtonSubmitLogin(){
    	return this.buttonSubmitLogin;
    }
    
    public WebElement getEmailElement(){
    	return this.email;
    }

    public String getEmail(){
    	return email.getText();
    }
    
    public void setEmail(String value){
    	email.sendKeys(value);
    }
    
    public WebElement getCustomerFirstNameElement(){
        return this.customerFirstName;
    }

    public String getCustomerFirstName(){
        return customerFirstName.getText();
    }
    
    public void setCustomerFirstName(String value){
        customerFirstName.sendKeys(value);
    }
    public WebElement getCustomerLastNameElement(){
        return this.customerLastName;
    }

    public String getCustomerLastName(){
        return customerLastName.getText();
    }
    
    public void setCustomerLastName(String value){
        customerLastName.sendKeys(value);
    }
    public WebElement getPasswdElement(){
        return this.passwd;
    }

    public String getPasswd(){
        return passwd.getText();
    }
    
    public void setPasswd(String value){
        passwd.sendKeys(value);
    }
    public WebElement getFirstNameElement(){
        return this.firstName;
    }

    public String getFirstName(){
        return firstName.getText();
    }
    
    public void setFirstName(String value){
        firstName.sendKeys(value);
    }
    public WebElement getLastNameElement(){
        return this.lastName;
    }

    public String getLastName(){
        return lastName.getText();
    }
    
    public void setLastName(String value){
        lastName.sendKeys(value);
    }
    public WebElement getCompanyElement(){
        return this.company;
    }

    public String getCompany(){
        return company.getText();
    }
    
    public void setCompany(String value){
        company.sendKeys(value);
    }
    public WebElement getCityElement(){
        return this.city;
    }

    public String getCity(){
        return city.getText();
    }
    
    public void setCity(String value){
        city.sendKeys(value);
    }
    public WebElement getStateIdElement(){
        return this.stateId;
    }

    public String getStateId(){
        return stateId.getText();
    }
    
    public void setStateId(String value){
        stateId.sendKeys(value);
    }
    public WebElement getPostCodeElement(){
        return this.postCode;
    }

    public String getPostCode(){
        return postCode.getText();
    }
    
    public void setPostCode(String value){
        postCode.sendKeys(value);
    }
    public WebElement getCountryIdElement(){
        return this.countryId;
    }

    public String getCountryId(){
        return countryId.getText();
    }
    
    public void setCountryId(String value){
        countryId.sendKeys(value);
    }
    public WebElement getMobilePhoneElement(){
        return this.mobilePhone;
    }

    public String getMobilePhone(){
        return mobilePhone.getText();
    }
    
    public void setMobilePhone(String value){
        mobilePhone.sendKeys(value);
    }
    public WebElement getAliasElement(){
        return this.alias;
    }

    public String getAlias(){
        return alias.getText();
    }
    
    public void setAlias(String value){
        alias.sendKeys(value);
    }
        
    
    // ------------------------------------
    public boolean isURLLoginPage()
    {
    	return this.driver.getCurrentUrl()
    		.contains("automationpractice.com/index.php?controller=authentication&back=my-account");
    }
    
    public boolean sukcessCreateAccount(){
    	return driver.findElement(By.id("create_account_error")) == null;
    }
    
    public boolean sukcessLoginAccount(){
    	return driver.findElement(By.className("alert alert-danger")) == null;
    }
    
    public void createAccount(){
    	this.getButtonCreateAccount().click();
    }
    
    public void submitAccount(){
    	this.getButtonSubmitAccount().click();
    }
    
    public void submitLogin(){
    	this.getButtonSubmitLogin().click();
    }
    
    public LoginPage open()
    {
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        PageFactory.initElements(driver, this);
        
        return this;    	
    }
}
