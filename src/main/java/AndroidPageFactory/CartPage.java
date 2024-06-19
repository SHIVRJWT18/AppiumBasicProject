package AndroidPageFactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import AppiumUtilityPkg.AndroidUtils;
import AppiumUtilityPkg.BasePage;
import io.appium.java_client.android.AndroidDriver;

public class CartPage extends BasePage
{

	public WebElement elem;
	public List<WebElement> elements;
	
	AndroidUtils au = new AndroidUtils(adriver);
	
	public CartPage(AndroidDriver adriver) {
		super(adriver);
			
	}
		
	private By GetTitleElem = By.id("com.androidsample.generalstore:id/toolbar_title");
	
    public void GetnVerifyPageTitle(String exptitile)
    {
     elem = getWebElement(GetTitleElem);
     String acttile = elem.getText();
     System.out.println("ActualTitle: "+acttile);
     Assert.assertEquals(exptitile, acttile,"Page title should be matched");     
    }

}
