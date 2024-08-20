package com.qsp.genericutility;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtility {
	
	public Actions act;
	public JavaUtility SystemTime;
	
	

	public WebDriverUtility(WebDriver driver) {
		act = new Actions(driver);
		SystemTime = new JavaUtility();
	}

	public void doubleClick(WebElement element)
	{
		act.doubleClick(element).perform();
	}

	public void clickAndHold(WebElement element) {
		act.clickAndHold(element).perform();
	}

	public void dragAndDrop(WebElement source, WebElement target)
	{
		act.dragAndDrop(source, target).perform();

	}
	public void mouseHover(WebElement element)
	{
		act.moveToElement(element).perform();
	}

	public void scrollToElement(WebElement element)
	{
		act.scrollToElement(element).perform();
	}

	public static void switchToWindow(WebDriver driver, String expetedUrl)
	{
		Set<String> AllWindowsIds = driver.getWindowHandles();
		for (String id:AllWindowsIds)
		{
			String actUrl = driver.switchTo().window(id).getCurrentUrl();
			if(actUrl.contains(expetedUrl)) {
				break;
			}
		}
	}
	public void switchToFrame(WebDriver driver , int index)
	{
		driver.switchTo().frame(index);

	}

	public void switchToFrameString(WebDriver driver, String nameOrId )
	{
		driver.switchTo().frame(nameOrId);
	}

	public void switchToFrame(WebDriver driver, WebElement frameElement) 
	{
		driver.switchTo().frame(frameElement);
	}

	public Alert switchToAlert(WebDriver driver)
	{
		return driver.switchTo().alert();
	}
	
	public void selectByIndex(WebElement dropdownElement,int index) {
		Select dropdownSelect= new Select(dropdownElement);
		dropdownSelect.selectByIndex(index);
	}
	
	public List<WebElement> getAllOptions(WebElement dropdownElement){
		Select dropdownSelect = new Select(dropdownElement);
		return dropdownSelect.getOptions();
		
	}
	
	public void jsScroll(WebDriver driver, int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+x+","+y+")");
	}
	
	
	 public String takeScreenshot(WebDriver driver, String fileName) throws IOException {
	        String timestamp = SystemTime.getSystemTime();
	        File temp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        String filePath = "./ScreenShots/" + fileName + "_" + timestamp + ".png";
	        File dest = new File(filePath);
	        FileHandler.copy(temp, dest);
	        return dest.getAbsolutePath();  // Return the absolute path of the screenshot file
	    }

}
