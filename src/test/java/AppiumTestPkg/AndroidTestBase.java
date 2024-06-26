package AppiumTestPkg;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import AndroidPageFactory.FormPage;
import AppiumUtilityPkg.AndroidUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AndroidTestBase 
{

	public AndroidDriver driver;
	public AppiumDriverLocalService aservice;
	public String appiumServerPort  = "http://192.168.65.1:4723/";
    public FormPage fp;
	
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException, URISyntaxException
	{
		aservice = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\Dell\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("192.168.1.38").usingPort(4723).build();
		
	//	aservice.start();
		
		UiAutomator2Options optn = new UiAutomator2Options();
		
	//	optn.setDeviceName("Pixel 8 API 31"); // Emulator Device Name
	//	optn.setApp("F:\\SHIV NEWSCRIPTS\\AppiumBasicProject\\src\\main\\java\\ConfigPkg\\ApiDemos-debug.apk");
		
		optn.setDeviceName("Pixel 2 Orieo"); // Emulator Device Name
		optn.setApp("F:\\SHIV NEWSCRIPTS\\AppiumMavenProject\\src\\main\\java\\ConfigPkg\\General-Store.apk");
		optn.setAutomationName("UiAutomator2");
		optn.setPlatformName("ANDROID");
		
		
		driver = new AndroidDriver(new URI(appiumServerPort).toURL(),optn);
	
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
	    
	    fp = new FormPage(driver);
	}
	
	@BeforeMethod
	public void getBackToLoginPage()
	{
		AndroidUtils au = new AndroidUtils(driver);
		au.UserStartAppActivity("com.androidsample.generalstore/com.androidsample.generalstore.SplashActivity");
	}
	
	
	@AfterClass
	public void closeServerServices() 
	{
		driver.quit();
		
		aservice.stop();
	}
}