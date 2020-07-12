package crudtable.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.NumberFormat;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider
{
	static XSSFWorkbook wb;
	
	public ExcelDataProvider() 
	{
		File src=new File ("./TestData/Data.xlsx");
		
		try {
			FileInputStream fis=new FileInputStream(src);
			
			wb=new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println("Unable to read Excel File "+e.getMessage());
		}
	}
	
	public String getStringData(int sheeIndex, int row, int column)
	{
		return wb.getSheetAt(sheeIndex).getRow(row).getCell(column).getStringCellValue();
	}
	
	public static String getStringData(String sheetName, int row, int column)
	{
		return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
	}
	
	public String getNumericData(String sheetName, int row, int column)
	{
		double cell = wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
		
		NumberFormat fmt = NumberFormat.getInstance();
		fmt.setGroupingUsed(false);
		fmt.setMaximumIntegerDigits(999);
		fmt.setMaximumFractionDigits(999);
		
		String str = fmt.format(cell);

		return str;
	}
	
	public static int rowCounter(String sheetName) throws IOException// Counts the number of rows with data in the excel file
	{
		int value = wb.getSheet(sheetName).getLastRowNum()-wb.getSheet(sheetName).getFirstRowNum();
		return value;
	}

}