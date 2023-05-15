package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountRegistrationPage extends BasePage
{
	//Constructor
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	//Elements
	@FindBy(name="firstname") 
	WebElement txtUsername;
	
	@FindBy(id="input-lastname") 
	WebElement txtLastname;
	
	@FindBy(xpath="//input[@id='input-email']") 
	WebElement txtEmail;
	
	@FindBy(css="#input-password") 
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@id='input-newsletter-no']")
	WebElement chkdSubscribe;
	
	@FindBy(name="agree")
	WebElement chkdPolicy;
	
	@FindBy(xpath="//button[normalize-space()='Continue']")
	WebElement btnContinue;
	//h1[normalize-space()='Your Account Has Been Created!']
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	//Action Methods
	public void setFirstName(String fname)
	{
		txtUsername.sendKeys(fname);
	}
	
	public void setLastName(String lname) 
	{
		txtLastname.sendKeys(lname);
	}
	
	public void setEmail(String email) 
	{
		txtEmail.sendKeys(email);
	}
	
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void setSubscribeNewsletter()
	{
		chkdSubscribe.click();
	}
	
	public void setPrivacyPolicy() 
	{
		chkdPolicy.click();
	}
	
	public void clickContinue()
	{
		//sol1 
		btnContinue.click();
		
		//sol2 
		//btnContinue.submit();
		
		//sol3
		//Actions act=new Actions(driver);
		//act.moveToElement(btnContinue).click().perform();
					
		//sol4
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click();", btnContinue);
		
		//Sol 5
		//btnContinue.sendKeys(Keys.RETURN);
		
		//Sol6  
		//WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
	}
	
	public String getConfirmationMsg()
	{
		try
		{
			return (msgConfirmation.getText());
		}
		catch(Exception e)
		{
			return (e.getMessage());
		}
	}
}
