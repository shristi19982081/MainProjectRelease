package Filters;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import Common.CaptureScreenshot;
import Common.KeywordDriven;

public class AddFilters {

	public static String getsidebar = KeywordDriven.getside();
	public static String dummyproj = KeywordDriven.getdummyproj();
	public static String getadd = KeywordDriven.getADD();

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

	public static void advanceFilter(WebDriver driver) {

		// To click on Advanced filter button
		driver.findElement(By.xpath("//*[@id=\"KEY_LABEL_Advanced_Filter-btnIconEl\"]")).click();
		// To click on Create button inside advanced filter
		driver.findElement(By.xpath("//*[@id=\"advanceFilterCreateButton-KEY_LABEL_Advanced_Filter-btnInnerEl\"]"))
				.click();
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iterator = windows.iterator();
		String parent = iterator.next();
		String child = iterator.next();

		driver.switchTo().window(child);
		// To enter data in Advanced filter form
		String filterName = " " + new Random().nextInt(1000);
		driver.findElement(By.name("filtername")).sendKeys(filterName);
		// driver.findElement(By.name("Description")).sendKeys("About Filter1");
		driver.findElement(By.xpath("//tbody/tr[2]/td[2]/textarea[1]")).sendKeys("About Filter1");
		// To select the check box GlobalFilter
		driver.findElement(By.name("isGlobalFilter")).click();
		// To select values from drop down button
		Select dropdown = new Select(driver.findElement(By.name("LeftBrace1")));
		dropdown.selectByValue("1");

		Select dropdown1 = new Select(driver.findElement(By.name("FieldName1")));
		dropdown1.selectByVisibleText("ID");

		Select dropdown2 = new Select(driver.findElement(By.name("Operator1")));
		dropdown2.selectByValue("Like");

		driver.findElement(By.xpath("//input[@id='Control_1_4']")).sendKeys("REL");

		Select dropdown6 = new Select(driver.findElement(By.name("RightBrace1")));
		dropdown6.selectByValue("1");

		String filePath = System.getProperty("user.dir") + "/Screenshots/CreateAdvanceFilter.png";
		CaptureScreenshot.captureTestScreenshot(driver, filePath);

		// To save and apply the inputed data
		driver.findElement(By.xpath("//*[@id=\"QTP_KEY_LABEL_Save_&_Apply\"]")).click();

		driver.switchTo().window(parent);
	}

	public static void tableView(WebDriver driver) {

		// To click on Table:View button
		driver.findElement(By.xpath("//*[@id=\"KEY_LABEL_Display_Table_View-btnIconEl\"]")).click();
		// To click on Create button inside Table:View
		driver.findElement(By.xpath("//*[@id=\"tableViewCreateButton-KEY_LABEL_Display_Table_View-btnInnerEl\"]"))
				.click();
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iterator = windows.iterator();
		String parent = iterator.next();
		String child = iterator.next();

		driver.switchTo().window(child);
		// To enter data in Table:View form
		String view = " " + new Random().nextInt(1000);
		driver.findElement(By.id("ViewName")).sendKeys("Table1" + view);
		// driver.findElement(By.name("Description")).sendKeys("About Filter1");
		driver.findElement(By.xpath("//*[@id=\"CommonDiv\"]/table/tbody/tr[3]/td[2]/textarea"))
				.sendKeys("About Table1");
		// To select the check box Make View Available To All Team Members
		driver.findElement(By.name("ProjectLevel")).click();
		// To select values from the list box
		Select listbox = new Select(driver.findElement(By.name("AllFieldList")));
		listbox.selectByVisibleText("Capacity");
		// To click on add button in List box
		driver.findElement(By.xpath("//input[@id='QTP_Add_With_Arrow']")).click();

		String filePath = System.getProperty("user.dir") + "/Screenshots/CreateTableView.png";
		CaptureScreenshot.captureTestScreenshot(driver, filePath);
		// To save the data
		driver.findElement(By.xpath("//input[@id='SaveB']")).click();

		driver.switchTo().window(parent);
	}

}
