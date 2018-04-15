package test;

import java.util.regex.Pattern;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class testlogin {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  public Map<String,String> map=new HashMap();
  
  @SuppressWarnings("deprecation")
public void readfile() throws IOException{
	  FileInputStream excelFileInputStream = new FileInputStream("D:/input.xlsx");
	  XSSFWorkbook workbook = new XSSFWorkbook(excelFileInputStream);
	  excelFileInputStream.close();
	  
	  for(int sheet=0;sheet<workbook.getNumberOfSheets();sheet++){
		  XSSFSheet xssfsheet=workbook.getSheetAt(sheet);
		  if(xssfsheet!=null){
			  for(int row=1;row<=xssfsheet.getLastRowNum();row++){
				  XSSFRow xssfrow = xssfsheet.getRow(row);
				  if(xssfrow !=null){
					  XSSFCell xssfcell=xssfrow.getCell(0);
					  xssfcell.setCellType(Cell.CELL_TYPE_STRING);
			          String num=xssfcell.getStringCellValue();
					  XSSFCell xssfcell2=xssfrow.getCell(1);
					  String url=xssfcell2.toString().trim();
					  map.put(num, url);
				  }
			  }
		  }
	  }  
  }


  @Before
  public void setUp() throws Exception {
	System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
	driver = new ChromeDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testUntitledTestCase() throws Exception {
	  readfile();
		for(String key:map.keySet()){
			String user=key;
			String paw=user.substring(user.length()-6, user.length());
			String url=map.get(user);
			driver.get("https://psych.liebes.top/st");
    		driver.findElement(By.id("username")).click();
    		driver.findElement(By.id("username")).clear();
    		driver.findElement(By.id("username")).sendKeys(user);
    		driver.findElement(By.id("password")).clear();
    		driver.findElement(By.id("password")).sendKeys(paw);
    		driver.findElement(By.id("submitButton")).click();
    		String text=driver.findElement(By.xpath("//p")).getText();
    		assertTrue(testequals(url,text));
		}
  }
  public boolean testequals(String url,String text){
		  if(url.equals(text)||(url).equals(text+"/")||(url+"/").equals(text)){
			  return true;
		  }
	  return false;
  }


@After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
