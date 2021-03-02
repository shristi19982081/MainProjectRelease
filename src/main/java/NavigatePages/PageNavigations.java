package NavigatePages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Common.CaptureScreenshot;
import Common.KeywordDriven;

public class PageNavigations {

	public static String getsidebar = KeywordDriven.getside();
	public static String dummyproj = KeywordDriven.getdummyproj();

	public static void getadd(WebDriver driver) throws InterruptedException {
		String url = "https://pratesting.cognizant.com";
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.get(url);
		driver.findElement(By.xpath(getsidebar)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(dummyproj)).click();
		Thread.sleep(1000);

		Thread.sleep(1000);

		Actions action = new Actions(driver);
		WebElement plan = driver.findElement(By.xpath("//a[@id='LOCK_Plan']"));
		action.moveToElement(plan).perform();
		Thread.sleep(1000);
		WebElement releases = driver.findElement(By.xpath("//a[@id='LOCK_Releases']"));
		action.moveToElement(releases).click().perform();

	}

	public static void displayPages(WebDriver driver) throws InterruptedException {

		Actions action = new Actions(driver);
		WebElement pagenum = driver.findElement(By.id("combobox-1044-trigger-picker"));
		action.moveToElement(pagenum).click(pagenum).perform();
		action.sendKeys(Keys.DOWN).build().perform();// press down arrow key
		action.sendKeys(Keys.ENTER).build().perform();
		String filePath = System.getProperty("user.dir") + "/Screenshots/NumberOfRelease.png";
		CaptureScreenshot.captureTestScreenshot(driver, filePath);

		Thread.sleep(2000);
		WebElement next = driver.findElement(By.xpath("//*[@id=\'button-1036-btnIconEl\']"));
		action.moveToElement(next).click(next).perform();
		String filePath1 = System.getProperty("user.dir") + "/Screenshots/NextPage.png";
		CaptureScreenshot.captureTestScreenshot(driver, filePath1);

		Thread.sleep(2000);
		WebElement last = driver.findElement(By.xpath("//*[@id=\'button-1037-btnIconEl\']"));
		action.moveToElement(last).click(last).perform();
		String filePath2 = System.getProperty("user.dir") + "/Screenshots/LastPage.png";
		CaptureScreenshot.captureTestScreenshot(driver, filePath2);

		Thread.sleep(2000);
		WebElement prev = driver.findElement(By.xpath("//*[@id=\'button-1030-btnIconEl\']"));
		action.moveToElement(prev).click(prev).perform();
		String filePath3 = System.getProperty("user.dir") + "/Screenshots/PreviousPage.png";
		CaptureScreenshot.captureTestScreenshot(driver, filePath3);

		Thread.sleep(2000);

		WebElement first = driver.findElement(By.xpath("//*[@id=\'button-1029-btnIconEl\']"));
		action.moveToElement(first).click(first).perform();
		String filePath4 = System.getProperty("user.dir") + "/Screenshots/FirstPage.png";
		CaptureScreenshot.captureTestScreenshot(driver, filePath4);
	}
}
