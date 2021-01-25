package baseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	
	public static String excelData(int rowNo, int cellNo) throws IOException {
		
	File loc=new File("C:\\Users\\ELCOT\\eclipse-workspace\\MavenNew\\src\\test\\resources\\Excel\\Datas.xlsx");
	
	FileInputStream is=new FileInputStream(loc);
	
	Workbook w=new XSSFWorkbook(is);
	
	Sheet sheet = w.getSheet("Sheet1");
	
	Row row = sheet.getRow(rowNo);
	
	Cell cell = row.getCell(cellNo);
	
	int type = cell.getCellType();
			
			String value=null;
			
			if (type==1) {
				 value = cell.getStringCellValue();
				//System.out.println(value);
			} else {
				if (DateUtil.isCellDateFormatted(cell)) {
					Date date = cell.getDateCellValue();
					SimpleDateFormat sf=new SimpleDateFormat("dd-MMM-yyy");
					 value = sf.format(date);
				//	System.out.println(value);
				} else {
					double doubleNum = cell.getNumericCellValue();
					long ln=(long)doubleNum;
					 value = String.valueOf(ln);
				//	System.out.println(value);
				}
			}	
	return value;
	}
}


