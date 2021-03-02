package Common;

public class KeywordDriven {

	// Reading the Excel Data from the InputDetails.xlsx file
	public static String getname() throws Exception {

		String[] data = ExcelUtils.readExcelData("Sheet1");
		String name = data[0];
		return name;
	}

	public static String getdescription() throws Exception {
		String[] data = ExcelUtils.readExcelData("Sheet1");
		String description = data[1];
		return description;
	}

	public static String getreleasetype() throws Exception {
		String[] data = ExcelUtils.readExcelData("Sheet1");
		String ReleaseType = data[2];
		return ReleaseType;
	}

	public static String getenddate() throws Exception {
		String[] data = ExcelUtils.readExcelData("Sheet1");
		String EndDate = data[3];
		return EndDate;
	}

	public static String getpriority() throws Exception {
		String[] data = ExcelUtils.readExcelData("Sheet1");
		String priority = data[4];
		return priority;
	}

	public static String gettechnology() throws Exception {
		String[] data = ExcelUtils.readExcelData("Sheet1");
		String technology = data[5];
		return technology;
	}

	public static String getChrome() throws Exception {
		String[] data = ExcelUtils.readExcelData("Sheet1");
		String chrome = data[7];
		return chrome;
	}

	public static String getside() {
		String sidebar = "//*[@id=\"navbar\"]/div[3]/div[1]";
		return sidebar;
	}

	public static String getdummyproj() {
		String dummyproj = "//*[@id=\"projectIcon\"]/ul/li[1]/a";
		return dummyproj;
	}

	public static String getplan() {
		String plan = "//*[@id=\"LOCK_Plan\"]";
		return plan;
	}

	public static String getrelease() {
		String release = "LOCK_Releases";
		return release;
	}

	public static String getADD() {
		String add = "//*[@id=\"KEY_BUTTON_Add-btnWrap\"]";
		return add;
	}

	public static String addname() {
		String add = "//*[@id=\'_Text_Check_CM_Name\']";
		return add;
	}

	public static String adddescription() {
		String add = "//*[@id=\"DN_Description\"]";
		return add;
	}

	public static String addsize() {
		String add = "//*[@id=\"DN_Size\"]";
		return add;
	}

	public static String addreleasetype() {
		String add = "//*[@id=\"releasetype\"]";
		return add;
	}

	public static String adddate() {
		String add = "//*[@id=\"releasedate\"]";
		return add;
	}

	public static String addpriority() {
		String add = "//*[@id=\"CM_Priority\"]";
		return add;
	}

	public static String addtechnology() {
		String add = "//*[@id=\"DN_Technology\"]";
		return add;
	}

	public static String addbutton() {
		String add = "//*[@id=\'SaveBtn\']";
		return add;
	}

	public static String returnbutton1() {
		String add = "//*[@id='CancelBtn']";
		return add;
	}
}
