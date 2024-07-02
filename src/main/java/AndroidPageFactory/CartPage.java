package AndroidPageFactory;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import AppiumUtilityPkg.AndroidUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class CartPage extends AndroidUtils
{

	public WebElement elem;
	public List<WebElement> elements;
	
	AndroidUtils au = new AndroidUtils(adriver);
	
	public CartPage(AndroidDriver adriver) {
		super(adriver);
			
	}
		
	private By GetTitleElem = By.id("com.androidsample.generalstore:id/toolbar_title");
	
	private By GetPriceElem = By.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productPrice']");
	
	private By PayablepriceElem = By.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/totalAmountLbl']");
	
	private By SendEmailCheckboxElem = By.xpath("//android.widget.CheckBox[@text='Send me e-mails on discounts related to selected products in future']");
	
	private By VisitToWebsiteToCompletePurchaseElem = By.id("com.androidsample.generalstore:id/btnProceed");
	
	private By TermsConditionElem = By.id("com.androidsample.generalstore:id/termsButton");
	
	private By TermsConditionMessageElem = By.id("android:id/message");
	
	private By AcceptTermsConditionElem = By.id("android:id/button1");		
	
    public void GetnVerifyPageTitle(String exptitile)
    {
     elem = getWebElement(GetTitleElem);
     String acttile = elem.getText();
     System.out.println("ActualTitle: "+acttile);
     Assert.assertEquals(exptitile, acttile,"Page title should be matched");     
    }
    
    public List<WebElement> GetProductPrices()
    {
     elements = getWebElements(GetPriceElem);
     
     return elements;
    }
    
    public void GetnVerifyPayablePrice()
    {
     elements = getWebElements(GetPriceElem);
     double sum =0;
     int psize = elements.size();
     System.out.println("Product in Cart: "+psize);
     for(int i=0;i<psize;i++)
     {
      String d = elements.get(i).getText();	 
      d = d.substring(1);
      double p1 = Double.parseDouble(d);
      sum = sum+p1;     
      PauseDriver(1500);
     }	
     String actprice = String.format( "%.2f", sum);
     System.out.println("ActualSum: "+actprice);
     
     String expprice = getWebElement(PayablepriceElem).getText();
     expprice = expprice.substring(1);
     
     Assert.assertEquals(actprice.trim(), expprice.trim(),"Total price is not matched with Payable price");
     
    }
    
    public void ClickTermsAndCondition()
    {
     elem = getWebElement(TermsConditionElem);	
     au.UseLongPressMobileGesture(elem, 2000);
     
     if(getWebElement(TermsConditionMessageElem).isDisplayed())
     {
      System.out.println("Terms and Condition Pop up is displayed");
     }
     else
     {
      Assert.fail("Terms and Condition Pop up is not displayed");	 
     }	 
 
     elem = getWebElement(AcceptTermsConditionElem);
     elem.click();
     System.out.println("Terms and conditions are accepted");
    }

    public void ClickVisitToWebsiteToCompletePurchaseElem() throws InterruptedException
    {
     elem = getWebElement(SendEmailCheckboxElem);	
     elem.click();
     elem = getWebElement(VisitToWebsiteToCompletePurchaseElem);
     elem.click();
     System.out.println("Purchase link is click successfully!");
     Thread.sleep(4000);
    }
}
