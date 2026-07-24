package utilities;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.FileHandler;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;

public class WebdriverUtility {
	public void waitForPageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
	public void waitForElementPresent(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
			
		
	}
	public void waitForElementInvisibility(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.invisibilityOf(element));
			
		
	}
	public void waitForElementToBeClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	public void waitForElementToBeSelected(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeSelected(element));
		
	}
	
	public void switchToTabOnURl(WebDriver driver,String partialURL)
	
	{
		Set<String> set=driver.getWindowHandles();
		Iterator<String>it=set.iterator();
	    {
	    	while(it.hasNext())
	    	{
	    		String windowId=it.next();
	    		driver.switchTo().window(windowId);
	    		String actUrl=driver.getCurrentUrl();
	    		if(actUrl.contains(partialURL)) {
	    			break;
	    		}
			
	    	}
	}
	}
	 public void switchToTabOnTitle(WebDriver driver,String partialTitle)	  	{
	    		Set<String> set=driver.getWindowHandles();
	    		Iterator<String>it=set.iterator();
	    	    {
	    	    	while(it.hasNext())
	    	    	{
	    	    		String windowID=it.next();
	    	    		driver.switchTo().window(windowID);
	    	    		String actUrl=driver.getTitle();
	    	    		if(actUrl.contains(partialTitle)) {
	    	    			break;
	    	    		}
	    			
}
}
	 }
	
	  public void switchToFrame(WebDriver driver,int index) {
		  driver.switchTo().frame(index);
	  }
	  public void switchToFrame(WebDriver driver,String nameID) {
		  driver.switchTo().frame(nameID);
	  }  
	  
	  public void switchToFrame(WebDriver driver,WebElement element) {
		  driver.switchTo().frame(element);
	  }  
	  
	  public void switchtoAlertAndAccept(WebDriver driver)
	  {
		  driver.switchTo().alert().accept();
	  }
	  public void switchtoAlertAndCancel(WebDriver driver)
	  {
		  driver.switchTo().alert().dismiss();
	  }
	  public Select dropdown(WebElement element)
	  {
		  Select sel=new Select(element);
		return sel;
	  }
	  public void selectByVisibleText(WebElement element,String text)
	  {
		 dropdown(element).selectByVisibleText(text);
	  }
	  public void select(WebElement element,int index)
	  {
		  dropdown(element).selectByIndex(index);
	  }
	  public void select(WebElement element,String value)
	  {
		  dropdown(element).selectByValue(value);
		  }
	  
	  public Actions actionscls(WebDriver driver)
	  {
		  Actions act=new Actions(driver);
		return act; 
	  }
	  public void mousemoveOnElement(WebDriver driver,WebElement element) {
		  actionscls(driver).moveToElement(element).perform();
	  }
	  public void doubleClick(WebDriver driver,WebElement element) {
		  actionscls(driver).doubleClick(element).perform();
	  }
	  public void dragAndDrop(WebDriver driver,WebElement src,WebElement des) {
		  actionscls(driver).dragAndDrop(src,des).perform();
	  }
	  
	  public void contextClick(WebDriver driver,WebElement element) {
		  actionscls(driver).contextClick(element).perform();
	  } 
	  
	  public void takescreenshot(WebDriver driver) throws IOException
	  {   
		    TakesScreenshot ts = (TakesScreenshot) driver;
	        File source = ts.getScreenshotAs(OutputType.FILE);
	        File destination = new File("./Screenshots/1.png");
	        FileUtils.copyFile(source, destination);
      } 
	  
	  public void scrollUntilElementToBeVisible(WebDriver driver,WebElement element)
	  {
		  JavascriptExecutor js=(JavascriptExecutor)driver;
			int y=element.getLocation().getY();
			js.executeScript("window.scrollBy(0,'+y+')");
	  }

}
