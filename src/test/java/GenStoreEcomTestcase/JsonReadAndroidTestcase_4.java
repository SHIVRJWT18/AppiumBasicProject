package GenStoreEcomTestcase;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import AndroidPageFactory.CartPage;
import AndroidPageFactory.FormPage;
import AndroidPageFactory.ProductPage;
import AppiumTestUtilsPkg.AndroidTestBase;
import AppiumUtilityPkg.AppiumUtilPage;


public class JsonReadAndroidTestcase_4 extends AndroidTestBase
{



	@Test(dataProvider = "FillData")
	public void purchaseproduct(HashMap<String,String> hashinput) throws InterruptedException
	{
	 FormPage fp = new FormPage(driver);
	 
	 fp.SetName(hashinput.get("name"));
	 fp.SelectGender(hashinput.get("gender"));
	 fp.GetSelectCountry(hashinput.get("country"));
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
    public Object[][] FillData() throws IOException
    {
     String Filepath = "F:\\SHIV NEWSCRIPTS\\AppiumMavenProject\\src\\main\\java\\ConfigPkg\\JsonTestdata.json";
     AppiumUtilPage Apumutil = new 	AppiumUtilPage(driver);
     List<HashMap<String, String>> jsondata = Apumutil.GetJsonData(Filepath);
     return new Object[][] {{jsondata.get(0)},{jsondata.get(1)}};	
    }

}
