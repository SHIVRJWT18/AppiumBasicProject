package AppiumUtilityPkg;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.AppiumDriver;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class AppiumUtilPage {
    
	public AppiumDriver appiumdriver;
    public WebDriverWait jsWait;
    public WebElement elem;
    public Alert alt;
    public Actions act;
    public Select sel;
	@SuppressWarnings("rawtypes")
	public ArrayList Aryl;
	public String Filepath = "C:\\Users\\Administrator\\Downloads";
	
    public static JavascriptExecutor jsExec;

	public AppiumUtilPage(AppiumDriver driver)
	{
		appiumdriver=driver;
		jsExec = ((JavascriptExecutor) appiumdriver);
	}

    protected WebElement getWebElement(WebElement elem, final By by)
    {
     waitForLoaded(elem, by, 5);
     
     waitForVisible(elem, by, 5);
        
     return elem.findElement(by);
    }

    protected List<WebElement> getWebElements(final By by)
    {
     waitForLoaded(by, 2);
     
     waitForVisible(by, 2);

     try 
     {
      return appiumdriver.findElements(by);
     } 
     catch (Exception e) 
     {
            return null;
     }
    }

    @SuppressWarnings("deprecation")
	protected void waitForLoaded(WebElement elem, final By by, int waitTime) 
    {
     for (int attempt = 0; attempt < waitTime; attempt++) 
     {
      try 
      {
       elem.findElement(by);
       break;
      } 
      catch (Exception e) 
      {
                appiumdriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
      }
     }
    }

    protected void waitForVisible(WebElement selem, final By by, int waitTime)
    {
     try 
     {
      elem = selem.findElement(by);
     } 
     catch (Exception e) 
     {

     }
     try 
     {
      elem = selem.findElement(by);
     } 
     catch (Exception e) 
     {

     }
    }

    protected WebElement getWebElement(final By by)
    {
     waitForLoaded(by, 5);
        
     waitForVisible(by, 5);

     try 
     {
      return appiumdriver.findElement(by);        
     } 
     catch (Exception e) 
     {
      return null;
     }
    }

    @SuppressWarnings("deprecation")
	protected void waitForLoaded(final By by, int waitTime) 
    {
     for (int attempt = 0; attempt < waitTime; attempt++) 
     {
      try 
      {
       appiumdriver.findElement(by);                
       break;                   
      } 
      catch (Exception e) 
      {
       appiumdriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
      }
     }  
    }

    protected void waitForVisible(final By by, int waitTime)
    {
     try 
     {
      elem = appiumdriver.findElement(by);
     } 
     catch (Exception e) 
     {

     }
    }
    
    public void PauseDriver(int waitTime) 
    {
     try 
     {
	  Thread.sleep(waitTime);
	 } 
     catch (InterruptedException e) 
     {
		e.printStackTrace();
	 }	
    }
    
    public void SwitchToNewFrame(WebElement elem)
    {
	 appiumdriver.switchTo().frame(elem);
	}

    public void SwitchDefaultContent() 
    {
	 appiumdriver.switchTo().defaultContent();
	}

    public void SwitchToParentFrame() 
    {
	 appiumdriver.switchTo().parentFrame();
	}
    
    public void MouseHover(WebElement elem) 
    {
  	  act = new Actions(appiumdriver);
  	  
  	  act.moveToElement(elem).perform();		
	 }

    public void MouseClick(WebElement elem) 
    {
  	  act = new Actions(appiumdriver);
  	  
  	  act.moveToElement(elem).perform();
  	  
  	  act.click(elem).perform();
	 }
    
    public void SelectByIndex(int index) 
    {
	 sel = new Select(elem);
	 
	 sel.selectByIndex(index);
	}
    
    public void SelectByVisibleText(String text) 
    {
	 sel = new Select(elem);
	 
	 sel.selectByVisibleText(text);
	}

    public Boolean isFileDownloadedinDir() throws InterruptedException
    {
  	 Thread.sleep(2000);
  	 
  	 Boolean flag=false;
	    
  	 File dir = new File(Filepath);
	    
  	 File[] files = dir.listFiles();
	    
  	 if (files == null || files.length == 0) 
  	 {
	   return null;
	 }
  	 
	 File lastModifiedFile = files[0];
	    
	 for (int i = 1; i < files.length; i++) 
	 {
	  if (lastModifiedFile.lastModified() < files[i].lastModified()) 
	  {
	           lastModifiedFile = files[i];
	  }
	 }
	  
     System.out.println(lastModifiedFile.getName());
     
     if(lastModifiedFile!=null) 
     {
		flag=true;
     }
     return flag;
	}
    
	public boolean IsFileDownloadedContains_Ext(String ext) throws InterruptedException
	{
	 Thread.sleep(2000);
		
	 boolean flag=false;
	    
	 File dir = new File(Filepath);
	    
	 File[] files = dir.listFiles();
	    
	 if (files == null || files.length == 0) 
	 {
	  flag = false;
	 }
	    
	 for (int i = 1; i < files.length; i++) 
	 {
	  if(files[i].getName().contains(ext)) 
	  {
	   flag=true;
	  }
	 }
	  return flag;
	}      
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public void SwitchWindowToForward()  
    {
	 Aryl = new ArrayList (appiumdriver.getWindowHandles());
		
	 System.out.println(Aryl.size());
		
	 appiumdriver.switchTo().window((String) Aryl.get(Aryl.size()-1));
		
	}
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public void SwitchWindowToBackward() throws InterruptedException 
	{
   	 Aryl = new ArrayList (appiumdriver.getWindowHandles());
		
   	 System.out.println(Aryl.size());
   		
   	 appiumdriver.switchTo().window((String) Aryl.get(Aryl.size()-2));
	}

	public String RandomString(String str)  
	{
	 Random rd= new Random();
		
	 int in = rd.nextInt(1000);
		
	 return (str+in);
	}

	public Date addDays(Date d, int days)
    {
	 d.setTime(d.getTime() + days * 1000 * 60 * 60 * 24);
      
	 return d;       
    }

	public void ClickAcceptIconAgainstPopup() 
	{
     alt = appiumdriver.switchTo().alert();
		
     alt.accept();
	}
	
	public void ClickCloseIconAgainstPopup() 
	{
	 alt = appiumdriver.switchTo().alert();
	 
	 alt.dismiss();
	}

    public void ScrollToDocumentHeight(int pixel) throws InterruptedException 
    {
	 jsExec.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
	 Thread.sleep(pixel);
	}

    public void ScrollHeightPixel(String pixel) 
    {	 
	 jsExec.executeScript("window.scrollBy(pixel,pixel)");
	}

    public void ScrollToElement(int pixel) throws InterruptedException 
    {
     jsExec.executeScript("arguments[0].scrollIntoView(true);", elem);
	   
     Thread.sleep(pixel);
	} 	
		
	public void PressArrowDownKey() 
	{
     Actions act = new Actions(appiumdriver);
	  	
     act.sendKeys(Keys.ARROW_DOWN).perform();
	  	
	 act.sendKeys(Keys.ENTER).perform();	
	}
	
	public void PressArrowLeftKey() 
	{
     Actions act = new Actions(appiumdriver);
	  	
     act.sendKeys(Keys.ARROW_LEFT).perform();
	  	
	 act.sendKeys(Keys.ENTER).perform();	
	}
	
	public void PressArrowRightKey() 
	{
     Actions act = new Actions(appiumdriver);
	  	
     act.sendKeys(Keys.ARROW_RIGHT).perform();
	  	
	 act.sendKeys(Keys.ENTER).perform();	
	}
	
	public void PressArrowUpKey() 
	{
     Actions act = new Actions(appiumdriver);
	  	
     act.sendKeys(Keys.ARROW_UP).perform();
	  	
	 act.sendKeys(Keys.ENTER).perform();	
	}
			
	public void explicitWait_visibilityOfElementLocated(By locator)
	{
	 jsWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
		
	public void explicitWait_visibilityOf(WebElement locator)
	{
	 jsWait.until(ExpectedConditions.visibilityOf(locator));
	}
		
	public void explicitiWait_presenceOfElementLocated(By locator)
	{
     jsWait.until(ExpectedConditions.presenceOfElementLocated(locator));					
	}
		
	public void fluentWait(WebDriver driver, int totalTime,int pollingTime, WebElement element)
	{
	 FluentWait<WebDriver> fw = new FluentWait<WebDriver>(driver);

	 fw.until(ExpectedConditions.visibilityOf(element));
	}
		
	public void explicitWait_elementToBeClickable(WebElement element)
	{
     jsWait.until(ExpectedConditions.elementToBeClickable(element));	
	}
		
	public void explicitWait_attributeToBeNotEmpty(WebElement element, String attribute)
	{
     jsWait.until(ExpectedConditions.attributeToBeNotEmpty(element,attribute));
    }
		
	public void explicitWait_textToBePresentInElementValue(WebElement element, String value)
	{
	 jsWait.until(ExpectedConditions.textToBePresentInElementValue(element, value));
	}

	public String lastmonthdatefromtoday()
	{
	 SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		 
	 Calendar c = Calendar.getInstance();

	 c.add(Calendar.MONTH, -1);
		 
	 String lstdt = dateFormat.format(c.getTime());

	 return lstdt;
	}
	
	public String todaydate()
	{
	 Date date =new Date();
		
	 SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
	    
	 String td = sdf.format(date);
		
	 return td;
	}	

    public void sleep (Integer milliSeconds) 
    {
     long secondsLong = (long) milliSeconds;
        
     try 
     {
      Thread.sleep(secondsLong);
     } 
     catch (InterruptedException e) 
     {
            e.printStackTrace();
     }
    }
    
    
    
    }
