package lab5.pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class HomePage {
	
    private final WebDriver driver;

    @FindBy(id = "contact-link")
    WebElement callUs;
    
    @FindBy(xpath = "//*[@id=\"homepage-slider\"]/div/div[2]/div/a[2]")
    WebElement slider;
    
    @FindBy(className = "shopping_cart")
    WebElement shoppingCart;
    
    @FindBy(className = "blockbestsellers")
    WebElement bestSellers;
    
    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]/a" )
    WebElement dressesMenu;
        
    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]/ul")
    WebElement dressesSubMenu;
    
    @FindBy(className = "login")
    WebElement loginLink;
    
    
    // ------------------------------------
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
   
    // ------------------------------------
    public void clickBestSellers() {
        getBestSellers().click();
    }

    public void clickShoppingCart()
    {
    	getShoppingCart().click();
    }
    
    public void clickSlider(){
    	getSlider().click();
    }
    
    public void clickCallUs(){
    	getCallUs().click();
    }
    
    public void clickLoginLink(){
    	this.getLoginLink().click();
    }
    
    public void clickLogoutLink(){
    	this.getLogoutElement().click();
    }
    
    // ------------------------------------
    public void moveToDressMenu()
    {
    	Actions a = new Actions(driver);
    	a.moveToElement(this.getDressesMenu());
    } 
    
    // ------------------------------------
    public List<WebElement> getProducts() {
        return driver.findElement(By.cssSelector("#blockbestsellers")).findElements(By.tagName("li"));
    }

    public void takeScreenshoot(String name) throws IOException 
    {
		if (driver instanceof TakesScreenshot) {
			File f = ((TakesScreenshot) driver).
					getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(f,new File("build/"+name+".png"));
		}
    }
    
    public HomePage open() {
        driver.get("http://automationpractice.com");
        PageFactory.initElements(driver, this);
        
        return this;
    }
    
    public boolean subMenuIsDisplayed(){
    	return this.getDressesSubMenu().getCssValue("display") != "none";
    }
    
    
    // ------------------------------------
    public WebElement getBestSellers() {
       return bestSellers;
    }
    
    public WebElement getShoppingCart(){
    	return this.shoppingCart;
    }
    
    public WebElement getCallUs(){
    	return this.callUs;
    }
    
    public WebElement getSlider(){
    	return this.slider;
    }
    
    public WebElement getSubmitMessage(){
    	return this.driver.findElement(By.id("submitMessage"));
    }
    
    public WebElement getProductByXPath(String path)
    {
    	return driver.findElement(By.xpath(path));
    }
    
    public WebElement getDressesMenu(){
    	return this.dressesMenu;
    }
    
    public WebElement getLogoutElement(){
    	return driver.findElement(By.className("logout"));
    }
    
    public WebElement getDressesSubMenu(){
    	return this.dressesSubMenu;
    }
    
    public WebElement getLoginLink(){
    	return this.loginLink;
    }
}
