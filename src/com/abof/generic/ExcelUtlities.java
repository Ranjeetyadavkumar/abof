package com.abof.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtlities {
	
	public static final String FILE_PATH="./testdata/testData.xlsx";
	
	public static String readData(String sheet, int rowNum, int cellNum){
		String data=null;
		try {
			Workbook wb = WorkbookFactory.create(new FileInputStream(new File(FILE_PATH)));
			data = wb.getSheet(sheet).getRow(rowNum).getCell(cellNum).getStringCellValue();
		} catch (EncryptedDocumentException | InvalidFormatException
				| IOException e) {
			e.printStackTrace();
		}
		
		return data;
	}

}
