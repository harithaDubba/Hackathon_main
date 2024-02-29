package BOOKSHELVES;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;

public class utility {

	@SuppressWarnings("resource")
	public static String getCelldata(String sheetname,int rownum,int cellnum) throws IOException {
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"//testdata//fromTodetails.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet(sheetname);
		XSSFRow row1=sheet.getRow(rownum);
		XSSFCell cell=row1.getCell(cellnum);
		String data;
		try 
		{
			//data=cell.toString();
			
			DataFormatter formatter = new DataFormatter();
            data = formatter.formatCellValue(cell);
            return data;
		}
		catch (Exception e) 
		{
			data="";
		}
		
		workbook.close();
		file.close();
		return data;
		
		
	}
//	public static void setCelldata(int um,List<WebElement> data) throws IOException {
//		FileOutputStream file = null;
//		 try {
//			file=new FileOutputStream(System.getProperty("user.dir")+".\\testdata\\userdetails.xlsx");
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//			XSSFWorkbook workbook1=new XSSFWorkbook();
//			XSSFSheet sheet1 = workbook1.createSheet("username");
//			XSSFRow row=sheet1.createRow(0);
//			int row1=1;
//			for(WebElement entry:data) { 
//		         XSSFRow row11=sheet1.createRow(row11++); 
//		         row11.createCell(0).setCellValue((data.get(row11)); 
//		         			
//			try {
//				workbook1.write(file);
//				workbook1.close();
//				file.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		
//	}

}
