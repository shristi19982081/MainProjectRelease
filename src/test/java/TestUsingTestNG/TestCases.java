package TestUsingTestNG;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import AddReleases.AddRelease;
import Common.DriverSetup;
import Common.KeywordDriven;
import ExportReleases.Export;
import Filters.AddFilters;
import NavigatePages.PageNavigations;
import SearchBase.SearchBasic;

public class TestCases {

	public static WebDriver driver = null;
	public static String filePath = null;

	String extentReportFile = System.getProperty("user.dir") + "/ExtentReport/extentReportFile.html";

	// Create object of extent report and specify the report file path.
	ExtentReports extent = new ExtentReports(extentReportFile, false);

	// Start the test using the ExtentTest class object.
	ExtentTest extentTest = extent.startTest("Main Project", "Module - Releases");

	@BeforeClass
	public void getDriver() {
		driver = DriverSetup.driverInstantiate();
		extentTest.log(LogStatus.INFO, "Browser launched and mainspring Releases is opened");
		filePath = System.getProperty("user.dir") + "/Screenshots/ReleasesHome.png";
		extentTest.log(LogStatus.INFO, "Releases Snapshot : " + extentTest.addScreenCapture(filePath));
	}

	@Test(priority = 1)
	public void exportButtonTests() {

		Export export = new Export(driver);

		export.clickExportButton();
		export.exportXLS();
		extentTest.log(LogStatus.INFO, "Releases are exported in XLS format");

		export.clickExportButton();
		export.exportXLSM();
		extentTest.log(LogStatus.INFO, "Releases are exported in XLSM format");

		export.clickExportButton();
		export.exportCSV();
		extentTest.log(LogStatus.INFO, "Releases are exported in CSV format");

		export.clickExportButton();
		export.exportZipXLS();
		extentTest.log(LogStatus.INFO, "Releases are exported in XLS Zip attachment");

		export.clickExportButton();
		export.exportZipXLSM();
		extentTest.log(LogStatus.INFO, "Releases are exported in XLSM Zip attachment");

		export.clickExportButton();
		export.exportZipCSV();
		extentTest.log(LogStatus.INFO, "Releases are exported in CSV Zip attachment");

		export.clickExportButton();
		export.exportListXLS();
		extentTest.log(LogStatus.INFO, "Releases are exported in XLS List format");

		export.clickExportButton();
		export.exportListCSV();
		extentTest.log(LogStatus.INFO, "Releases are exported in CSV List format");

		export.clickExportButton();
		export.exportSkeletalXLS();
		extentTest.log(LogStatus.INFO, "Releases are exported in XLS Skeletal format");

		export.clickExportButton();
		export.exportSkeletalCSV();
		extentTest.log(LogStatus.INFO, "Releases are exported in CSV Skeletal format");

		export.clickExportButton();
		export.reset();
		extentTest.log(LogStatus.INFO, "Reset button in Export window is working properly");

		filePath = System.getProperty("user.dir") + "/Screenshots/ExportRelease.png";
		extentTest.log(LogStatus.INFO, "Export Window Snapshot : " + extentTest.addScreenCapture(filePath));
		extentTest.log(LogStatus.PASS, "Export Releases test case is passed");
	}

	@Test(priority = 2)
	public void addRelease() throws Exception {

		AddRelease.getadd(driver);
		extentTest.log(LogStatus.INFO, "Navigate to the Release page again");
		extentTest.log(LogStatus.INFO, "Add Release button is clicked");

		String name = KeywordDriven.getname();
		extentTest.log(LogStatus.INFO, "Name input is collected from the database");
		String description = KeywordDriven.getdescription();
		extentTest.log(LogStatus.INFO, "Description input is collected from the database");
		String releasetype = KeywordDriven.getreleasetype();
		extentTest.log(LogStatus.INFO, "Release input is collected from the database");
		String date = KeywordDriven.getenddate();
		extentTest.log(LogStatus.INFO, "End Date input is collected from the database");
		String priority = KeywordDriven.getpriority();
		extentTest.log(LogStatus.INFO, "Priority input is collected from the database");
		String technology = KeywordDriven.gettechnology();
		extentTest.log(LogStatus.INFO, "Technolgy input is collected from the database");
		AddRelease.fillForm(name, description, releasetype, date, priority, technology, driver);
		extentTest.log(LogStatus.INFO,
				"Collected inputs are written to the Add Release form and the Release is submitted successfully");

		filePath = System.getProperty("user.dir") + "/Screenshots/AddRelease.png";
		extentTest.log(LogStatus.INFO, "Add Release Snapshot : " + extentTest.addScreenCapture(filePath));
		extentTest.log(LogStatus.PASS, "Add Release Test Case is passed");

	}

	@Test(priority = 3)
	public void pageNavigator() throws Exception {

		PageNavigations.getadd(driver);
		extentTest.log(LogStatus.INFO, "Navigate to the Release page again");

		PageNavigations.displayPages(driver);
		extentTest.log(LogStatus.INFO, "Number of data that will be visible is selected");
		filePath = System.getProperty("user.dir") + "/Screenshots/NumberOfRelease.png";
		extentTest.log(LogStatus.INFO, "Number Of Releases Snapshot : " + extentTest.addScreenCapture(filePath));

		extentTest.log(LogStatus.INFO, "Navigate to the Next page of Releases");
		filePath = System.getProperty("user.dir") + "/Screenshots/NextPage.png";
		extentTest.log(LogStatus.INFO, "Next Page Snapshot : " + extentTest.addScreenCapture(filePath));

		extentTest.log(LogStatus.INFO, "Navigate to the Last page of Releases");
		filePath = System.getProperty("user.dir") + "/Screenshots/LastPage.png";
		extentTest.log(LogStatus.INFO, "Last Page Snapshot : " + extentTest.addScreenCapture(filePath));

		extentTest.log(LogStatus.INFO, "Navigate to the Previous page of Releases");
		filePath = System.getProperty("user.dir") + "/Screenshots/PreviousPage.png";
		extentTest.log(LogStatus.INFO, "Previous Page Snapshot : " + extentTest.addScreenCapture(filePath));

		extentTest.log(LogStatus.INFO, "Navigate to the First page of Releases");
		filePath = System.getProperty("user.dir") + "/Screenshots/FirstPage.png";
		extentTest.log(LogStatus.INFO, "First Page Snapshot : " + extentTest.addScreenCapture(filePath));

		extentTest.log(LogStatus.PASS, "Page navigation test case is passed");
	}

	@Test(priority = 4)
	public void search() throws Exception {

		Properties p = SearchBasic.prop();

		SearchBasic.getadd(driver);
		extentTest.log(LogStatus.INFO, "Navigate to the Release page again");

		SearchBasic.testSearchBarEnabled(driver);
		extentTest.log(LogStatus.PASS, "Search Bar is enabled");

		SearchBasic.testSearchByID(driver, p);
		extentTest.log(LogStatus.INFO, "Search Releases using ID and store the results in Excel file Output1");
		filePath = System.getProperty("user.dir") + "/Screenshots/SearchByID.png";
		extentTest.log(LogStatus.INFO, "Search By ID Snapshot : " + extentTest.addScreenCapture(filePath));

		SearchBasic.testSearchByName(driver, p);
		extentTest.log(LogStatus.INFO, "Search Releases using Name and store the results in Excel file Output2");
		filePath = System.getProperty("user.dir") + "/Screenshots/SearchByName.png";
		extentTest.log(LogStatus.INFO, "Search By Name Snapshot : " + extentTest.addScreenCapture(filePath));

		SearchBasic.testSearchByReleaseNumber(driver, p);
		extentTest.log(LogStatus.INFO,
				"Search Releases using Release Number and store the results in Excel file Output3");
		filePath = System.getProperty("user.dir") + "/Screenshots/SearchByReleaseNumber.png";
		extentTest.log(LogStatus.INFO, "Search By Release Number Snapshot : " + extentTest.addScreenCapture(filePath));

		extentTest.log(LogStatus.PASS, "Search Releases Test Case is passed");
	}

	@Test(priority = 5)
	public void filters() throws Exception {

		AddFilters.getadd(driver);
		extentTest.log(LogStatus.INFO, "Navigate to the Release page again");

		AddFilters.advanceFilter(driver);
		extentTest.log(LogStatus.INFO, "Clicked on Advance Filter option");
		extentTest.log(LogStatus.INFO, "Clicked on Create");
		extentTest.log(LogStatus.INFO,
				"All the details is written in Create Filter window and clicked on Save & Apply button");
		filePath = System.getProperty("user.dir") + "/Screenshots/CreateAdvanceFilter.png";
		extentTest.log(LogStatus.INFO, "Advance Filter Snapshot : " + extentTest.addScreenCapture(filePath));
		extentTest.log(LogStatus.INFO, "Created filter is applied successfully");

		AddFilters.tableView(driver);
		extentTest.log(LogStatus.INFO, "Clicked on Table View option");
		extentTest.log(LogStatus.INFO, "Clicked on Create");
		extentTest.log(LogStatus.INFO,
				"All the options for Table View is written in Table View window and clicked on Save button");
		filePath = System.getProperty("user.dir") + "/Screenshots/CreateTableView.png";
		extentTest.log(LogStatus.INFO, "Table View Snapshot : " + extentTest.addScreenCapture(filePath));
		extentTest.log(LogStatus.INFO, "Created Table View is applied");

		extentTest.log(LogStatus.PASS, "Add Filters Test Case is passed");
	}

	@AfterClass
	public void closeDriver() {

		driver.quit();

		extentTest.log(LogStatus.PASS, "All Test Cases are passed and browser is closed successfully");

		// close report.
		extent.endTest(extentTest);

		// writing everything to document.
		extent.flush();
	}
}
