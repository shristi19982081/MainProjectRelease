package ExportReleases;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Common.CaptureScreenshot;

public class Export {

	WebDriver driver = null;
	public static String parent = null;
	public static String child = null;

	public Export(WebDriver driver) {
		this.driver = driver;
	}

	public void clickExportButton() {
		WebElement exportButton = driver.findElement(By.xpath("//span[@id='KEY_TOOLTIP_Export-btnIconEl']"));
		exportButton.click();

		new WebDriverWait(driver, 30).until(ExpectedConditions.numberOfWindowsToBe(2));

		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iterator = windows.iterator();
		parent = iterator.next();
		child = iterator.next();

		driver.switchTo().window(child);
	}

	public void exportXLS() {

		driver.findElement(By.xpath("//input[@id='QTP_KEY_BUTTON_Ok']")).click();

		driver.findElement(By.xpath("//input[@id='QTP_KEY_BUTTON_Close']")).click();

		driver.switchTo().window(parent);
	}

	public void exportXLSM() {

		driver.findElement(By.xpath("//body/form[1]/div[2]/div[1]/div[1]/div[1]/div[2]/input[1]")).click();

		driver.findElement(By.xpath("//input[@id='QTP_KEY_BUTTON_Ok']")).click();

		driver.findElement(By.xpath("//input[@id='QTP_KEY_BUTTON_Close']")).click();

		driver.switchTo().window(parent);
	}

	public void exportCSV() {

		driver.findElement(By.xpath("//body/form[1]/div[2]/div[1]/div[1]/div[2]/input[1]")).click();

		driver.findElement(By.xpath("//input[@id='QTP_KEY_BUTTON_Ok']")).click();

		driver.findElement(By.xpath("//input[@id='QTP_KEY_BUTTON_Close']")).click();

		driver.switchTo().window(parent);

	}

	public void exportZipXLS() {

		driver.findElement(By.xpath("//input[@id='ZipOutput']")).click();

		WebElement attachments = driver.findElement(By.xpath("//input[@id='ExportAttachment']"));

		WebDriverWait wait = new WebDriverWait(driver, 30);

		wait.until(ExpectedConditions.visibilityOf(attachments));

		attachments.click();

		driver.findElement(By.xpath("//input[@id='QTP_KEY_BUTTON_Ok']")).click();

		driver.findElement(By.xpath("//input[@id='QTP_KEY_BUTTON_Close']")).click();

		driver.switchTo().window(parent);
	}

	public void exportZipXLSM() {

		driver.findElement(By.xpath("//body/form[1]/div[2]/div[1]/div[1]/div[1]/div[2]/input[1]")).click();

		exportZipXLS();
	}

	public void exportZipCSV() {

		driver.findElement(By.xpath("//body/form[1]/div[2]/div[1]/div[1]/div[2]/input[1]")).click();

		exportZipXLS();
	}

	public void exportListXLS() {

		driver.findElement(By.xpath("//input[@id='ListView']")).click();

		driver.findElement(By.xpath("//input[@id='QTP_KEY_BUTTON_Ok']")).click();

		driver.findElement(By.xpath("//input[@id='QTP_KEY_BUTTON_Close']")).click();

		driver.switchTo().window(parent);
	}

	public void exportListCSV() {

		driver.findElement(By.xpath("//body/form[1]/div[2]/div[1]/div[1]/div[2]/input[1]")).click();

		exportListXLS();
	}

	public void exportSkeletalXLS() {

		driver.findElement(By.xpath("//input[@id='Skeletal']")).click();

		driver.findElement(By.xpath("//input[@id='QTP_KEY_BUTTON_Ok']")).click();

		driver.findElement(By.xpath("//input[@id='QTP_KEY_BUTTON_Close']")).click();

		driver.switchTo().window(parent);
	}

	public void exportSkeletalCSV() {

		driver.findElement(By.xpath("//body/form[1]/div[2]/div[1]/div[1]/div[2]/input[1]")).click();

		exportSkeletalXLS();
	}

	public void reset() {

		driver.findElement(By.xpath("//input[@id='ZipOutput']")).click();

		WebElement attachments = driver.findElement(By.xpath("//input[@id='ExportAttachment']"));

		WebDriverWait wait = new WebDriverWait(driver, 30);

		wait.until(ExpectedConditions.visibilityOf(attachments));

		attachments.click();

		driver.findElement(By.xpath("//input[@id='Skeletal']")).click();

		String filePath = System.getProperty("user.dir") + "/Screenshots/ExportRelease.png";
		CaptureScreenshot.captureTestScreenshot(driver, filePath);

		driver.findElement(By.xpath("//input[@id='QTP_KEY_BUTTON_Reset']")).click();

		driver.findElement(By.xpath("//input[@id='QTP_KEY_BUTTON_Close']")).click();

		driver.switchTo().window(parent);
	}

}
