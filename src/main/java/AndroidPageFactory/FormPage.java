package AndroidPageFactory;

import java.util.List;
import java.util.ListIterator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import AppiumUtilityPkg.AndroidUtils;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class FormPage extends AndroidUtils
{
  
	public FormPage(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public WebElement elem;
	public List<WebElement> elements;
		
    AndroidUtils au = new AndroidUtils(adriver);
	
	private By SelectCountryElem = By.xpath("//android.widget.TextView[@resource-id='android:id/text1']");
		
	private By EnterYourNameElem = By.id("com.androidsample.generalstore:id/nameField");
	
	private By ClickLetsShopElem = By.id("com.androidsample.generalstore:id/btnLetsShop");
	
	private By GetErrorMessageElem = By.xpath("(//android.widget.Toast)[1]");
	
	public void SetName(String name) throws InterruptedException
	{
	 elem = getWebElement(EnterYourNameElem);
	 elem.sendKeys(Keys.CONTROL + "a",Keys.DELETE);
	 elem.sendKeys(name);
	 adriver.hideKeyboard();
	 System.out.println("Entered Name: "+name);
	 
	 Reporter.log("SetName: "+name);
	}
	
	public void SelectGender(String gender)
	{
	 if(!gender.equalsIgnoreCase("Male") && !gender.equalsIgnoreCase("Female"))
	 {
	  System.out.println("Not a valid value! Please enter Male or Female");
	 }
	 else
	 {	 
	  elem = getWebElement(By.id("com.androidsample.generalstore:id/radio"+gender+""));
	  elem.click();
	 }	 
	   System.out.println("Selected Gender: "+gender);
	   Reporter.log("SelectGender: "+gender);
	}
	
	 public void GetSelectCountry(String country) throws InterruptedException
	 {
	   elem = getWebElement(SelectCountryElem);
	   elem.click(); 
	   
	   au.UseScrollUptoDesiredTextByAndroidUIAutomatorGesture(country);
	   PauseDriver(8000);
	   
	   elem = getWebElement(By.xpath("//android.widget.TextView[@resource-id='android:id/text1' and @text='"+country+"']"));
	   elem.click();
	   PauseDriver(4000);
	   System.out.println("Selected Country: "+country);
	   Reporter.log("GetSelectCountry: "+country);

	 }
	 
	 public void GetnVerifyErrorMessage(String expmsg)
	 {
	  elem = getWebElement(GetErrorMessageElem);
	  String actmsg = elem.getAttribute("name");
	  System.out.println("Actual Error Message: "+actmsg);
	  Assert.assertEquals(expmsg, actmsg,"Error toast message is not matched");
	 }
	 
	 public ProductPage ClickLetsShopButton() throws InterruptedException
	 {
	  elem = getWebElement(ClickLetsShopElem); 
	  elem.click();
	  System.out.println("Lets shop button is clicked");	  
	  Reporter.log("ClickLetsShopButton");
	  PauseDriver(3000);
	  return new ProductPage(adriver);
	  	  
	 }
	 
	 public void NoErrorToastMessageDisplayed(int esize)
	 {
	  elements = getWebElements(GetErrorMessageElem); 
	  int size = elements.size();
	  System.out.println("ElementSize: "+size);	 
	  Assert.assertEquals(size, esize,"Element size is not matched");	 
	 }
	 
	 public void PreScreenSetUp() throws InterruptedException
	 {
	  adriver.pressKey(new KeyEvent(AndroidKey.BACK));
			
	  Thread.sleep(2500);
	  
	  System.out.println("Start activity started");	
	 }

}
