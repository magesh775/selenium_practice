package pojo.org;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;

	public static void launchBrowser() {
     WebDriverManager.chromedriver().setup();
     driver = new ChromeDriver();
	}
	public static void windowMax() {
		driver.manage().window().maximize();

	}

	public static void launchurl(String url) {
		driver.get(url);
	}

	public static void pageTitle() {
		String title = driver.getTitle();
		System.out.println(title);
	}

	public static void pageUrl() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
	}

	public static void sendText(WebElement we, String text) {
		we.sendKeys(text);
	}

	public static void closeEntireBrowser() {
		driver.quit();
	}

	public static void clickBtn(WebElement we) {
		we.click();
	}

	public static void closeWindow() {
		driver.close();
	}

	public static void navigateBack() {
		driver.navigate().back();
	}

	public static void navigateforward() {
		driver.navigate().forward();
	}

	public static void navigateTo(String url) {
		driver.navigate().to(url);
	}

	public static void navigateRefresh() {
		driver.navigate().refresh();
	}

	public static void alertAccept() {
		driver.switchTo().alert().accept();
	}

	public static void alertDismiss() {
		driver.switchTo().alert().dismiss();
	}

	public static void alertGetText() {
		String gettext = driver.switchTo().alert().getText();
		System.out.println(gettext);
	}

	public static void alertSentKeys(String values) {
		driver.switchTo().alert().sendKeys(values);
	}

	public static void isEnable(WebElement element) {
		if (element.isEnabled()) {
			System.out.println(element.isEnabled());
		} else {
			System.out.println("False");
		}
	}

	public static void isDisplayed(WebElement element) {
		if (element.isDisplayed()) {
			System.out.println(element.isDisplayed());
		} else {
			System.out.println("False");
		}
	}

	public static void isSelected(WebElement element) {
		if (element.isSelected()) {
			System.out.println(element.isSelected());
		} else {
			System.out.println("False");
		}
	}

	public static void screenShot(String imgName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des = new File("location+imgName.png");
		FileUtils.copyFile(src, des);
	}

	public static void dropDown(WebElement element, String type, String value) {
		Select s = new Select(element);
		if (type.equalsIgnoreCase("selectbyvalue")) {
			s.selectByValue(value);
		} else if (type.equalsIgnoreCase("selectbyindex")) {
			int data = Integer.parseInt(value);
			s.selectByIndex(data);
		} else if (type.equalsIgnoreCase("selectbyvisibletext")) {
			s.selectByVisibleText(value);
		}
	}

	public static Actions a;

	public static void moveTheCursor(WebElement ele) {
		a = new Actions(driver);
		a.moveToElement(ele).perform();
	}

	public static void dragDrop(WebElement drag, WebElement drop) {
		a = new Actions(driver);
		a.dragAndDrop(drag, drop).perform();
	}

	public static JavascriptExecutor js;

	public static void scrollThePage(WebElement we) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", we);
	}

	public static void scroll(WebElement we) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false)", we);
	}

	public static void excelRead(String sheetName, int rowNum, int cellNum) throws IOException {
        File f = new File("excellocation.xlsx");
        FileInputStream fis = new FileInputStream(f);
        Workbook wb = new XSSFWorkbook(fis);
        Sheet ms = wb.getSheet("Data");
        Row r = ms.getRow(rowNum);
        Cell c = r.getCell(cellNum);
        int cellType = c.getCellType();
        String value = " ";
        if (cellType==1) {
			String value2 = c.getStringCellValue();
		}
        else if (DateUtil.isCellDateFormatted(c)) {
			Date dateCellValue = c.getDateCellValue();	
			SimpleDateFormat sdf = new SimpleDateFormat(value);
			String format = sdf.format(dateCellValue);
			}
        else {
        	double d = c.getNumericCellValue();
			long l = (long)d;
		  String valueOf = String.valueOf(l);
		}
       }
	public static void createNewExcel(int rowNum, int CellNum, String newData) throws IOException {
        File f = new File("C:\\Users\\magesh\\eclipse-workspace\\allFile\\Excel\\newFile.xlsx");
        Workbook wb = new XSSFWorkbook();
        Sheet s = wb.createSheet("data");
        Row r = s.createRow(rowNum);
        Cell c = r.createCell(CellNum); 
        c.setCellValue(newData);
        FileOutputStream fos = new FileOutputStream(f);
        wb.write(fos);
        }
	public static void createCell(int rowNum, int CellNum, String newData) throws IOException {
        File f = new File("C:\\Users\\magesh\\eclipse-workspace\\allFile\\Excel\\newFile.xlsx");
        FileInputStream fis = new FileInputStream(f);
        Workbook wb = new XSSFWorkbook(fis);
        Sheet s = wb.getSheet("data");
        Row r = s.getRow(rowNum);
        Cell c = r.createCell(CellNum); 
        c.setCellValue(newData);
        FileOutputStream fos = new FileOutputStream(f);
        wb.write(fos);
        }
	public static void createRow(int rowNum, int CellNum, String newData) throws IOException {
        File f = new File("C:\\Users\\magesh\\eclipse-workspace\\allFile\\Excel\\newFile.xlsx");
        FileInputStream fis = new FileInputStream(f);
        Workbook wb = new XSSFWorkbook(fis);
        Sheet s = wb.getSheet("data");
        Row r = s.createRow(rowNum);
        Cell c = r.createCell(CellNum); 
        c.setCellValue(newData);
        FileOutputStream fos = new FileOutputStream(f);
        wb.write(fos);
        }
	
	
}
