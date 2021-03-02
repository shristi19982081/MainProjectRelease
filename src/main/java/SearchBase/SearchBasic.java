package SearchBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Common.CaptureScreenshot;
import Common.KeywordDriven;
import Common.WriteToExcel;

public class SearchBasic {

	public static WebDriver driver;
	public static String getsidebar = KeywordDriven.getside();
	public static String dummyproj = KeywordDriven.getdummyproj();

	public static Properties prop() {
		File file = new File(System.getProperty("user.dir") + "/values.properties");

		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();

		// load properties file
		try {
			prop.load(fileInput);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return prop;

	}

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

	public static void testSearchBarEnabled(WebDriver driver) throws InterruptedException {
		boolean searchIconEnabled = driver.findElement(By.id("searchTextBox-inputEl")).isEnabled();
		System.out.println(searchIconEnabled);
		System.out.println("Search Bar is Enabled");
		Thread.sleep(3000);
	}

	public static void testSearchByID(WebDriver driver, Properties p) throws Exception {
		List<String> output = null;

		driver.findElement(By.xpath("//input[@id='searchTextBox-inputEl']")).sendKeys(p.getProperty("ID"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@id='searchButton-btnIconEl']")).click();
		Thread.sleep(2000);

		List<WebElement> searchresult = driver.findElements(By.className("x-grid-cell-inner"));
		System.out.println("Number of elements:" + searchresult.size());
		System.out.println("Search By Id test is passed and Search result is as follows:");
		output = new ArrayList<String>();
		for (int i = 0; i < searchresult.size(); i++) {

			System.out.print(searchresult.get(i).getText() + " ");
			String val = searchresult.get(i).getText();

			output.add(val);

		}

		String filePath = System.getProperty("user.dir") + "/Screenshots/SearchByID.png";
		CaptureScreenshot.captureTestScreenshot(driver, filePath);

		WriteToExcel.searchOutput("Sheet1", output, "output1");

	}

	public static void testSearchByName(WebDriver driver, Properties p) throws Exception {
		List<String> output1 = null;
		driver.findElement(By.xpath("//input[@id='searchTextBox-inputEl']")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@id='searchButton-btnIconEl']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@id='searchTextBox-inputEl']")).sendKeys(p.getProperty("Name"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@id='searchButton-btnIconEl']")).click();
		Thread.sleep(2000);

		List<WebElement> searchresult = driver.findElements(By.className("x-grid-cell-inner"));
		System.out.println("***********");
		System.out.println("Number of elements:" + searchresult.size());
		System.out.println("Search By name test is passed and Search result is as follows:");
		output1 = new ArrayList<String>();
		for (int i = 0; i < searchresult.size(); i++) {

			System.out.print(searchresult.get(i).getText() + " ");
			String val = searchresult.get(i).getText();
			output1.add(val);

		}

		String filePath = System.getProperty("user.dir") + "/Screenshots/SearchByName.png";
		CaptureScreenshot.captureTestScreenshot(driver, filePath);

		WriteToExcel.searchOutput("Sheet1", output1, "output2");

	}

	public static void testSearchByReleaseNumber(WebDriver driver, Properties p) throws Exception {
		List<String> output = null;
		driver.findElement(By.xpath("//input[@id='searchTextBox-inputEl']")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@id='searchButton-btnIconEl']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@id='searchTextBox-inputEl']")).sendKeys(p.getProperty("ReleaseNumber"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@id='searchButton-btnIconEl']")).click();
		Thread.sleep(2000);

		List<WebElement> searchresult = driver.findElements(By.className("x-grid-cell-inner"));
		System.out.println("***********");
		System.out.println("Number of elements:" + searchresult.size());
		System.out.println("Search By ReleaseNumber test is passed and Search result is as follows:");
		output = new ArrayList<String>();
		for (int i = 0; i < searchresult.size(); i++) {

			System.out.print(searchresult.get(i).getText() + " ");

			String val = searchresult.get(i).getText();
			output.add(val);

		}

		String filePath = System.getProperty("user.dir") + "/Screenshots/SearchByReleaseNumber.png";
		CaptureScreenshot.captureTestScreenshot(driver, filePath);

		WriteToExcel.searchOutput("Sheet3", output, "output3");

	}

}
