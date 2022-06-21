package utilities;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ReadExcel {
	
	public HSSFWorkbook work_book1;
	public HSSFSheet sheet1;
	public HSSFCell Cell1;
	
	public ReadExcel(String path) {
		File file=new File(path);
		try {
			FileInputStream stream=new FileInputStream(file);
			
			try {
				//work_book=new XSSFWorkbook(stream);
				work_book1=new HSSFWorkbook(stream);
			} catch (IOException e) {
				System.out.println("Work_book is not identified");
				e.printStackTrace();
			}			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			System.out.println("Test Data file streaming fails");
		}
	}

	public String getData(String SheetName,int row,int col)
	{
		sheet1=work_book1.getSheet(SheetName);
		Cell1=sheet1.getRow(row).getCell(col);
		String Data=Cell1.getStringCellValue();
		return Data;
		
	}
	
	public int getRowCount(String SheetName) {
		sheet1=work_book1.getSheet(SheetName);
		int row=sheet1.getLastRowNum();
		row=row+1;
		return row;	
	}
	

}
