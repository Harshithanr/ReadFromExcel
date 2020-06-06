package com.ito.practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFromExcel 
{  
	public static void main(String args[]) throws IOException
	{
		File file = new File("C:\\Users\\Harshitha Ramashetty\\Documents\\DevOps\\bp_data.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		FormulaEvaluator eval = wb.getCreationHelper().createFormulaEvaluator();
		for(Row row: sheet)
		{
			for(Cell cell: row)
			{
				switch(eval.evaluateInCell(cell).getCellType()) {
				case Cell.CELL_TYPE_NUMERIC:
					System.out.print(cell.getNumericCellValue()+ "\t");
					break;
				case Cell.CELL_TYPE_STRING:
					System.out.print(cell.getStringCellValue()+ "\t");
					
					break;
				}
				
			}
			System.out.println();
		}
	}
	
	
}  

