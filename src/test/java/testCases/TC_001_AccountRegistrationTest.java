package testCases;

import org.testng.Assert;

import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass
{
   
	@Test(groups= {"Regression","Master"})
	public void test_account_Registration() throws InterruptedException
	{
		logger.info("***  Starting TC_001_AccountRegistrationTest ***");
		
		try
		{
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on My account link");
		hp.clickRegister();
		logger.info("Clicked on register link");
	
		AccountRegistrationPage regpage= new AccountRegistrationPage(driver);
		
		logger.info("Providing customer data");
		
		regpage.setFirstName(randomString().toUpperCase());
		logger.info("Updated First Name");
		
		regpage.setLastName(randomString().toUpperCase());
		logger.info("Updated Last Name");
		
		regpage.setEmail(randomString()+"@gmail.com");// randomly generated the email
		logger.info("Updated Email");
		
		String password=randomAlphaNumeric();
		regpage.setPassword(password);
		logger.info("Updated Password");
		//if confirm password is present
		//regpage.setConfirmPassword(password);
		
		regpage.setSubscribeNewsletter();
		logger.info("Updated subscribe news letter");
		
		regpage.setPrivacyPolicy();
		logger.info("Updated privacy policy");
		
		regpage.clickContinue();
		logger.info("Clicked on continue");
		
		Thread.sleep(10000);
		String confmsg=regpage.getConfirmationMsg();
		System.out.println("\n\nmsg -"+confmsg+"\n\n");
		logger.info("Validating expected message");
		Thread.sleep(5000);
		Assert.assertEquals(confmsg,"Your Account Has Been Created!","Not getting expected message");
		}
		catch(Exception e) 
		{
			logger.error("Test failed");
			Assert.fail();
			System.out.println("\n"+e.getMessage()+"\n\n");
		}
		logger.info("***  Finished TC_001_AccountRegistrationTest ***");
	}
	
}
