package Common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverSetup {

	public static WebDriver driver;
	public static String url = " https://pratesting.cognizant.com";
	public static String browsertype;

	// Instantiation of chrome and mozilla firefox browser
	public static WebDriver driverInstantiate() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		// To maximize the window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// To go to the webpage
		driver.get(url);
		WebDriverWait wait = new WebDriverWait(driver, 180);
		wait.until(ExpectedConditions.titleContains("mainspring"));

		Actions action = new Actions(driver);
		WebElement menu = driver.findElement(By.xpath("//header/nav[1]/div[1]/div[1]/div[3]/div[1]"));
		action.moveToElement(menu).perform();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		driver.findElement(By.linkText("Aug8th Release_Dummy Proj 1")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement plan = driver.findElement(By.xpath("//a[@id='LOCK_Plan']"));
		action.moveToElement(plan).perform();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement releases = driver.findElement(By.xpath("//a[@id='LOCK_Releases']"));
		action.moveToElement(releases).click().perform();

		String filePath = System.getProperty("user.dir") + "/Screenshots/ReleasesHome.png";
		CaptureScreenshot.captureTestScreenshot(driver, filePath);

		return driver;

	}

}
