package com.qa.crm.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.sun.media.sound.InvalidFormatException;

public class TestUtilities extends TestBase {
	
	//switch to frame
	
	public static  Workbook book;
	public static Sheet sheet;
	
	public static String FILE_PATH="C:\\Java_Prep\\FreeCRMAutomation\\src\\main\\java\\testData\\Crm_testdata.xlsx";
	
	
	public TestUtilities() {
		super();
	}
	
	public void switchToFrame() {
		
		driver.switchTo().frame("mainpanel");
	}
	
	
	public static Object[][] getTestdata(String sheetname){
		
		 FileInputStream fp=null;
		
		try {
			fp=new FileInputStream(FILE_PATH);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			book=WorkbookFactory.create(fp);
		}
		
//		catch(InvalidFormatException e) {
//			e.printStackTrace();
//		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		sheet=book.getSheet(sheetname);
		
		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0;i<sheet.getLastRowNum();i++) {
			
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++) {
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
			}
		}
		
		return data;
	}
	
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
	
	


}
