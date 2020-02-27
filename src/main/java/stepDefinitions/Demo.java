package stepDefinitions;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Demo {

	
	static String filepath="C:\\Demo.xlsx";
	static String filepath1="D:\\DataExtractor\\Demo1.xlsx";
	
	public static String ReadData(String Sheetname,int rowcount,int columncount) throws Throwable
	{
	
	        FileInputStream input=new FileInputStream(filepath);
	        XSSFWorkbook wb=new XSSFWorkbook(input);
	        XSSFSheet sheet=wb.getSheet(Sheetname);
	        XSSFRow row=sheet.getRow(rowcount);
	        String cell=(row.getCell(columncount)).toString();
	        
	        
		return cell;
	}
	
	
	public static String write(String Sheetname,int rowcount,int columncount,String value) throws Throwable
	{ 
		FileInputStream inp= new FileInputStream(filepath1); 
	    XSSFWorkbook wb = new XSSFWorkbook(inp); 
	    XSSFSheet sheet = wb.getSheetAt(0); 
	   // System.out.println(sheet);
	    XSSFRow row1 = sheet.createRow(0);
		XSSFCell r1c1 = row1.createCell(0);
		r1c1.setCellValue("Emd Id");
	   // XSSFRow row=sheet.getRow(rowcount);
	    //XSSFCell cell=row.getCell(columncount);
	   // cell.setCellValue(value);
	    System.out.println("sheet name is"+ sheet);
	    
	
	   
	        // Now this Write the output to a file 
	        FileOutputStream fileOut = new FileOutputStream(filepath1); 
	    wb.write(fileOut); 
	    fileOut.close();
		return value; 
	} 
	
	
	public static void main(String[] args) throws Throwable {
		
		
		
		 String cellvalue=ReadData("Sheet1",0,0);
		 System.out.println(cellvalue);
		 String value2 = write("Sheet1",0,1,"ok");
		 System.out.println(value2);
		

	}


	

}
