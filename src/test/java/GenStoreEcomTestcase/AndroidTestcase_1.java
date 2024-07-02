package GenStoreEcomTestcase;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import AndroidPageFactory.FormPage;
import AppiumTestUtilsPkg.AndroidTestBase;


public class AndroidTestcase_1 extends AndroidTestBase
{



	@Test(priority=1)
	public void purchaseproduct() throws InterruptedException
	{
	 FormPage fp = new FormPage(driver);
	 
	 fp.SetName("Abhishek Singh");
	 fp.SelectGender("Female");
	 fp.GetSelectCountry("Bhutan");
	 fp.ClickLetsShopButton();
     fp.NoErrorToastMessageDisplayed(0);
	 
		 
	}
	
	
	@Test(priority=2)
	public void GetnVerifyErrorToastMessage() throws InterruptedException
	{
	 FormPage fp = new FormPage(driver);
	 fp.SetName("");
	 fp.SelectGender("Female");
	 fp.GetSelectCountry("Australia");
	 fp.ClickLetsShopButton();	
	 fp.GetnVerifyErrorMessage("Please enter your name");
	}
}
