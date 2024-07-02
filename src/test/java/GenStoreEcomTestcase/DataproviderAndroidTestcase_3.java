package GenStoreEcomTestcase;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import AndroidPageFactory.CartPage;
import AndroidPageFactory.FormPage;
import AndroidPageFactory.ProductPage;
import AppiumTestUtilsPkg.AndroidTestBase;


public class DataproviderAndroidTestcase_3 extends AndroidTestBase
{



	@Test(dataProvider = "FillData")
	public void purchaseproduct(String custname,String custgen,String custcountry) throws InterruptedException
	{
	 FormPage fp = new FormPage(driver);
	 
	 fp.SetName(custname);
	 fp.SelectGender(custgen);
	 fp.GetSelectCountry(custcountry);
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
	
    @DataProvider
    public Object[][] FillData()
    {
     return new Object[][] {{"Kirti Kumari","Female","Australia"},{"Kapil Kumar","Male","Bangladesh"}};	
    }
	

}
