package AndroidPageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import AppiumUtilityPkg.AndroidUtils;
import AppiumUtilityPkg.BasePage;
import io.appium.java_client.android.AndroidDriver;

public class FormPage extends BasePage
{

	public WebElement elem;
	AndroidUtils au = new AndroidUtils(adriver);
	
	public FormPage(AndroidDriver adriver) {
		super(adriver);
		
	//	PageFactory.initElements(new AppiumFieldDecorator(adriver), this);
		
	}
	
	private By SelectCountryElem = By.xpath("//android.widget.TextView[@resource-id='android:id/text1']");
		
	private By EnterYourNameElem = By.id("com.androidsample.generalstore:id/nameField");
	
	private By ClickLetsShopElem = By.id("com.androidsample.generalstore:id/btnLetsShop");
	
	public void SetName(String name)
	{
	 elem = getWebElement(EnterYourNameElem);
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
	   adriver.wait(2000);
	   
	   elem = getWebElement(By.xpath("//android.widget.TextView[@resource-id='android:id/text1' and @text='"+country+"']"));
	   elem.click();
	   System.out.println("Selected Country: "+country);
	   Reporter.log("GetSelectCountry: "+country);

	 }
	 
	 public ProductPage ClickLetsShopButton() throws InterruptedException
	 {
	  elem = getWebElement(ClickLetsShopElem); 
	  elem.click();
	  System.out.println("Lets shop button is clicked");
	  adriver.wait(2000);
	  Reporter.log("ClickLetsShopButton");
	  
	  return new ProductPage(adriver);
	  
	  
	 }
      	 
	

}
