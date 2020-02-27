package ReusabilityMethods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig {
	
	static XSSFWorkbook wb;
	static XSSFSheet sheet; 
	
	static String filepath1="D:\\DataExtractor\\Demo1.xlsx";
      public ExcelDataConfig(String excelPath)
      {
    	  try {
    		  
			File src=new File(excelPath); //Define path
			FileInputStream Fis=new FileInputStream(src);//Class which will accept this file source_Load it in form of bites
			wb=new XSSFWorkbook(Fis);//Load full Excel(WB)
    		  
    	  }
    		  catch (Exception e) 
        	  {
    		 
    			System.out.println(e.getMessage());
    		  }
        	  
          }
	
      public String getData(String sheetname,int row, int column)
      {
      	sheet=wb.getSheet(sheetname);
      	String data=sheet.getRow(row).getCell(column).getStringCellValue();
      	return data;
      
      }
	
	
      
	public String write(String Sheetname,int rowcount,int columncount,String value) throws Throwable
	{ 
		FileInputStream inp= new FileInputStream(filepath1); 
	    XSSFWorkbook wb = new XSSFWorkbook(inp); 
	    XSSFSheet sheet = wb.getSheet(Sheetname); 
	   // System.out.println(sheet);
	    XSSFRow row1 = sheet.createRow(rowcount);
		XSSFCell r1c1 = row1.createCell(columncount);
		r1c1.setCellValue(value);
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

}
	
	