package hello_java;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.format.CellFormatType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONException;
import org.json.JSONObject;
//import org.junit.Test; 
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;



public class excel {
	@Test
	public void test1() throws EncryptedDocumentException, IOException, InvalidFormatException, JSONException {
		
		ClassLoader classLoader = this.getClass().getClassLoader();
		FileInputStream file = new FileInputStream(classLoader.getResource("jyosanasaini.xlsx").getFile());
		
		XSSFWorkbook wb = new XSSFWorkbook(file);
		   XSSFSheet sheet = wb.getSheetAt(0);
		   int rowstart = sheet.getFirstRowNum();
		   int rowend = sheet.getLastRowNum();
		   rowend++;
		   for(int i=rowstart+1;i<rowend;i++)
		   {
			   Row row=sheet.getRow(i);
			   String request = row.getCell(0).getStringCellValue();
			   String url=row.getCell(1).getStringCellValue();
			   int statusCode=(int) row.getCell(2).getNumericCellValue();
			   int status = helper.help(request,url);
			   Assert.assertEquals(statusCode, status);  
			}
		}
		
	}
	


