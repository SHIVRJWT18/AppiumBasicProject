package AndroidPageFactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import AppiumUtilityPkg.AndroidUtils;
import io.appium.java_client.android.AndroidDriver;

public class ProductPage extends AndroidUtils
{

	public WebElement elem;
	public List<WebElement> elements;
	
	AndroidUtils au = new AndroidUtils(adriver);
	
	public ProductPage(AndroidDriver adriver) {
		super(adriver);
			
	}
		
	private By GetTitleElem = By.id("com.androidsample.generalstore:id/toolbar_title");
	
	private By AddProductToCart = By.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productAddCart']");
	
	private By ClickCartIconElem = By.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/counterText']");
	
    public void GetnVerifyPageTitle(String exptitile)
    {
     elem = getWebElement(GetTitleElem);
     String acttile = elem.getText();
     System.out.println("ActualTitle: "+acttile);
     Assert.assertEquals(exptitile, acttile,"Page title should be matched");     
    }
    
    public void AddProductToCart(String prodname) throws InterruptedException
    {
     elements = getWebElements(AddProductToCart);	
     int size = elements.size();
     System.out.println("Product Found: "+size);
     au.UseScrollUptoDesiredTextByAndroidUIAutomatorGesture(prodname);
     PauseDriver(5000);
     elem = getWebElement(By.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productName' and @text='"+prodname+"']/..//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productAddCart']"));
     elem.click();
     System.out.println("Added Product in Cart : "+prodname);
    }
    
    public CartPage ClickCartButton() throws InterruptedException
    {
     elem = getWebElement(ClickCartIconElem);
     elem.click();
     PauseDriver(2000);
     System.out.println("Cart Button is clicked");
     
     return new CartPage(adriver);
    	
    }
    
}
