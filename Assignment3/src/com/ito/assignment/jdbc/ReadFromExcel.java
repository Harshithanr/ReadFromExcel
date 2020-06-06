package com.ito.assignment.jdbc;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFromExcel{
	

	@SuppressWarnings("deprecation")
	public void read(Connection con,String query2) throws InvalidFormatException, IOException, SQLException{
		File file = new File("C:\\Users\\Harshitha Ramashetty\\Documents\\DevOps\\bp_data.xlsx");
		
		@SuppressWarnings("resource")
		XSSFWorkbook wb = new XSSFWorkbook(file);
		
		XSSFSheet sheet = wb.getSheetAt(0);
		PreparedStatement stmt = con.prepareStatement(query2);
		Iterator<Row> rowIterator = sheet.iterator();
		rowIterator.next();
		
		FormulaEvaluator eval = wb.getCreationHelper().createFormulaEvaluator();
		while(rowIterator.hasNext()) {
			Row nextRow = rowIterator.next();
			Iterator<Cell> cellIterator = nextRow.cellIterator();
			
			while(cellIterator.hasNext()) {
				Cell nextCell = cellIterator.next();
				int coulmnIndex = nextCell.getColumnIndex();
				switch(eval.evaluateInCell(nextCell).getCellType()) {
				case Cell.CELL_TYPE_NUMERIC: 
					stmt.setInt(coulmnIndex + 1,(int) nextCell.getNumericCellValue() );
					break;
					
				case Cell.CELL_TYPE_STRING:
					stmt.setString(coulmnIndex + 1, nextCell.getStringCellValue());
					break;
				case Cell.CELL_TYPE_BLANK:
					stmt.setNull(coulmnIndex + 1, 0);
					System.out.println();
					break;
				}
			}
		
			
			stmt.addBatch();
			stmt.executeBatch();
		}	
	}
}
