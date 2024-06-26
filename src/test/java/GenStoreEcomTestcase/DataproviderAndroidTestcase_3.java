package GenStoreEcomTestcase;

import org.testng.annotations.Test;

import AndroidPageFactory.CartPage;
import AndroidPageFactory.FormPage;
import AndroidPageFactory.ProductPage;
import AppiumTestPkg.AndroidTestBase;
import AppiumUtilityPkg.AndroidUtils;

import io.appium.java_client.android.AndroidDriver;

public class DataproviderAndroidTestcase_3 extends AndroidTestBase
{


	@Test
	public void purchaseproduct() throws InterruptedException
	{
	 FormPage fp = new FormPage(driver);
	 
	 fp.SetName("Abhishek Singh");
	 fp.SelectGender("Female");
	 fp.GetSelectCountry("Bhutan");
	 fp.ClickLetsShopButton();
     fp.NoErrorToastMessageDisplayed(0);
	 
		 
	}
	
	
	@Test
	public void GetnVerifyErrorToastMessage() throws InterruptedException
	{
	 FormPage fp = new FormPage(driver);
	 fp.SelectGender("Female");
	 fp.GetSelectCountry("Australia");
	 fp.ClickLetsShopButton();	
	 fp.GetnVerifyErrorMessage("Please enter your name");
	}
}
