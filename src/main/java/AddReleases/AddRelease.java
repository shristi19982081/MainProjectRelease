package AddReleases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.Select;

import Common.CaptureScreenshot;
import Common.KeywordDriven;

public class AddRelease {

	// Getting the data from the KeywordDriven class

	public static String getsidebar = KeywordDriven.getside();
	public static String dummyproj = KeywordDriven.getdummyproj();
	public static String getplan = KeywordDriven.getplan();
	public static String getrelease = KeywordDriven.getrelease();
	public static String getadd = KeywordDriven.getADD();
	public static String addname = KeywordDriven.addname();
	public static String adddescription = KeywordDriven.adddescription();
	public static String adddate = KeywordDriven.adddate();
	public static String addpriority = KeywordDriven.addpriority();
	public static String addreleasetype = KeywordDriven.addreleasetype();
	public static String addsize = KeywordDriven.addsize();
	public static String addtechnology = KeywordDriven.addtechnology();
	public static String addbutton = KeywordDriven.addbutton();
	public static String returnbutton = KeywordDriven.returnbutton1();

	public static void getadd(WebDriver driver) throws InterruptedException {
		String url = "https://pratesting.cognizant.com";
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.get(url);
		driver.findElement(By.xpath(getsidebar)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(dummyproj)).click();
		Thread.sleep(1000);

		Actions action = new Actions(driver);
		WebElement plan = driver.findElement(By.xpath("//a[@id='LOCK_Plan']"));
		action.moveToElement(plan).perform();
		Thread.sleep(1000);
		WebElement releases = driver.findElement(By.xpath("//a[@id='LOCK_Releases']"));
		action.moveToElement(releases).click().perform();

		Thread.sleep(1000);
		driver.findElement(By.xpath(getadd)).click();
	}

	public static void fillForm(String name, String description, String releasetype, String date, String priority,
			String technology, WebDriver driver) throws InterruptedException {

		driver.switchTo().frame("contentframe");
		WebElement nam = driver.findElement(By.xpath(addname));
		Thread.sleep(1000);
		nam.sendKeys(name);
		Thread.sleep(1000);
		WebElement des = driver.findElement(By.xpath(adddescription));
		des.sendKeys(description);
		WebElement End = driver.findElement(By.xpath(adddate));
		End.sendKeys(date);

		WebElement reltype = driver.findElement(By.xpath(addreleasetype));
		Select rel = new Select(reltype);
		rel.selectByVisibleText(releasetype);

		WebElement prior = driver.findElement(By.xpath(addpriority));
		Select priorit = new Select(prior);
		priorit.selectByVisibleText(priority);

		WebElement techno = driver.findElement(By.xpath(addtechnology));
		Select tech = new Select(techno);
		tech.selectByVisibleText(technology);

		String filePath = System.getProperty("user.dir") + "/Screenshots/AddRelease.png";
		CaptureScreenshot.captureTestScreenshot(driver, filePath);

		WebElement submit = driver.findElement(By.xpath(addbutton));
		submit.click();
		WebElement return1 = driver.findElement(By.xpath(returnbutton));
		return1.click();

	}

}
