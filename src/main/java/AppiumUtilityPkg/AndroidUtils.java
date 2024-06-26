package AppiumUtilityPkg;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.remote.RemoteWebElement;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class AndroidUtils extends AppiumUtilPage
{

	public static AndroidDriver adriver;
	public AndroidUtils(AndroidDriver driver) {
		super(driver);
		adriver = driver;
		jsExec = ((JavascriptExecutor) adriver);
	}


	
	 /* In order to view mobile gesture Serach Mobile Gesture in appium Click on first git hub link  
	  * (Or)   Go to below Url
	    https://github.com/appium/appium-uiautomator2-driver/blob/master/docs/android-mobile-gestures.md
    */
	
	public void UseLongPressMobileGesture(WebElement elem, int timeduration)
	{		
		jsExec.executeScript("mobile: longClickGesture", 
		ImmutableMap.of("elementId",((RemoteWebElement)elem).getId()),"duration",timeduration);
		
	}
	
	public void UseScrollUptoDesiredTextByAndroidUIAutomatorGesture(String desiredtext)
	{
	 adriver.findElement(AppiumBy.androidUIAutomator
	 ("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+desiredtext+"\"));"));		
	}
	
	public void UseScrollToMobileGesture(int left,int top,int width,int height,String direction,double percent)
	{
		boolean canscrollmore;
		
		do
		{
		 canscrollmore = (Boolean)jsExec.executeScript("mobile: scrollGesture", 
		 ImmutableMap.of("left",left,"top",top,"width",width,"height",height,"direction",direction,"percent",percent));
		}
		while(canscrollmore); 
	}
	
	
	public void UseSwipeMobileGesture(WebElement elem, String direction,double percent)
	{
	  jsExec.executeScript("mobile: swipeGesture", 
	  ImmutableMap.of("elementId",((RemoteWebElement)elem).getId(),"direction",direction,"percent",percent));
		
	}	
	
	public void UseDragDropMobileGesture(WebElement elem,int xend,int yend)
	{
	 jsExec.executeScript("mobile: dragGesture", 
			 ImmutableMap.of("elementId", ((RemoteWebElement) elem).getId(),
		    "endX", xend,"endY", yend ));

	}
	
	public void UserStartAppActivity(String appActivity)
	{
	 jsExec.executeScript("mobile: startActivity",ImmutableMap.of("intent", appActivity));	
	}
	

}

