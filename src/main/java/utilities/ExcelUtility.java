package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
public class ExcelUtility {

	public String getDataFromExcel(String sheetName,int rowNum,int celNum) throws EncryptedDocumentException, IOException {
		FileInputStream fis1 = new FileInputStream("./testdata/nykaaTestscriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		String data  = wb.getSheet(sheetName).getRow(rowNum).getCell(celNum).getStringCellValue();
		wb.close();
		return data;
		
		}
		
	public int getRowcount(String sheetName) throws EncryptedDocumentException, IOException	{
		FileInputStream fis1 = new FileInputStream("./testdata/nykaaTestscriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		int rowcount=wb.getSheet(sheetName).getLastRowNum();
		wb.close();
		return rowcount;
	}
		
	public void setDataIntoExcel(String sheetName,int rowNum,int celNum,String data) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis1 = new FileInputStream("./testdata/nykaaTestscriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		wb.getSheet(sheetName).getRow(rowNum).createCell(celNum).setCellValue(data);
		
		FileOutputStream fos=new FileOutputStream("./testdata/nykaaTestscriptData.xlsx");
		wb.write(fos);
		wb.close();
	}


	
}
