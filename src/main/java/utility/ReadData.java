package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import base.TestBase;

public class ReadData 
{
	public static String readPropertyFile(String value) throws IOException 
	{
		Properties prop= new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\Siddhant\\OneDrive\\Attachments\\JAVA\\eclipse\\OctoberBatch25\\src\\main\\java\\config\\config.properties");
	    prop.load(file);
	    return prop.getProperty(value);
	}
	
	public static String readExcel(int roNum, int colNum ) throws EncryptedDocumentException, IOException 
	{
		FileInputStream file = new FileInputStream("C:\\Users\\Siddhant\\Downloads\\Parameterization_Siddh.xlsx");
		Sheet excel = WorkbookFactory.create(file).getSheet("Sheet1");
		String value = excel.getRow(roNum).getCell(colNum).getStringCellValue();
		return value;
	}

}
