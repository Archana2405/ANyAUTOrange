package ReadExcelData;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	XSSFWorkbook wb;
	XSSFSheet sheet1;
	
	public ReadExcel(String excelPath)
	{
		try {
			File src=new File(excelPath);
			
			FileInputStream fis=new FileInputStream(src);
			
			 wb=new XSSFWorkbook(fis);
			
			 sheet1=wb.getSheetAt(0);
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}

	public String getData(String sheetNumber, int row, int column)
	{
		
		String data=sheet1.getRow(row).getCell(column).getStringCellValue();
		return data;
	}
}
