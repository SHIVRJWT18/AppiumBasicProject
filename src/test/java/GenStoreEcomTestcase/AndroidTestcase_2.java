package GenStoreEcomTestcase;

import org.testng.annotations.Test;

import AndroidPageFactory.CartPage;
import AndroidPageFactory.FormPage;
import AndroidPageFactory.ProductPage;
import AppiumTestPkg.AndroidTestBase;
import AppiumUtilityPkg.AndroidUtils;

import io.appium.java_client.android.AndroidDriver;

public class AndroidTestcase_2 extends AndroidTestBase
{


	@Test
	public void purchaseproduct() throws InterruptedException
	{
	 FormPage fp = new FormPage(driver);
	 
	 fp.SetName("Abhishek Singh");
	 fp.SelectGender("Female");
	 fp.GetSelectCountry("Bhutan");
	 ProductPage Pp = fp.ClickLetsShopButton();
	 
	 Pp.GetnVerifyPageTitle("Products");
	 Pp.AddProductToCart("Air Jordan 9 Retro");
	 Pp.AddProductToCart("Nike SFB Jungle");
	 CartPage Cp = Pp.ClickCartButton();
	 
	 Cp.GetnVerifyPageTitle("Cart");
	 Cp.GetnVerifyPayablePrice();
	 Cp.ClickTermsAndCondition();
	 Cp.ClickVisitToWebsiteToCompletePurchaseElem();
	 
		 
	}
	

}
