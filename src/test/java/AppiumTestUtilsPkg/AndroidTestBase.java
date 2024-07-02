package AppiumTestUtilsPkg;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import AndroidPageFactory.FormPage;
import AppiumUtilityPkg.AndroidUtils;
import AppiumUtilityPkg.AppiumUtilPage;
import AppiumUtilityPkg.PropertiesLoader;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AndroidTestBase 
{

	public AndroidDriver driver;
	//public String appiumServerPort  = "http://192.168.65.1:4723/";
	public String appiumServerIp = "192.168.65.1";
	public int appiumport = 4723;
    public FormPage fp;
    AppiumUtilPage apumup = new AppiumUtilPage(driver);
    PropertiesLoader pl = new PropertiesLoader();
	
	@BeforeClass
	public void ConfigureAppium() throws URISyntaxException, IOException
	{     
     apumup.StartAppiumService(pl.getProperties("ServerIpAddress"), Integer.parseInt(pl.getProperties("ServerPortNo")));
		
	 UiAutomator2Options optn = new UiAutomator2Options();
		
	//	optn.setDeviceName("Pixel 8 API 31"); // Emulator Device Name
	//	optn.setApp("F:\\SHIV NEWSCRIPTS\\AppiumBasicProject\\src\\main\\java\\ConfigPkg\\ApiDemos-debug.apk");
		
		optn.setDeviceName(pl.getProperties("DeviceName")); // Emulator Device Name
		optn.setApp(pl.getProperties("ApplicationPath"));
		optn.setAutomationName("AutomationName");
		optn.setPlatformName("PlatformName");
		
		driver = new AndroidDriver(apumup.StartAppiumService(appiumServerIp, appiumport).getUrl(),optn);
	
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
	    
	    fp = new FormPage(driver);
	}
	
	@BeforeMethod
	public void getBackToLoginPage() throws InterruptedException
	{
     fp.PreScreenSetUp();
     
     Thread.sleep(3000);
	}
	


	
	@AfterClass
	public void closeServerServices() 
	{
		driver.quit();
		
		apumup.StopAppiumService(appiumServerIp, appiumport);
	}
}