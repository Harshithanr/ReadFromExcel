package com.ito.assignment.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFromExcel{
	
	public void read(Connection con,String query2,FileInputStream file) throws IOException, SQLException, InvalidFormatException{
		XSSFWorkbook wb = new XSSFWorkbook(file);
		
		XSSFSheet sheet = wb.getSheetAt(0);
		PreparedStatement stmt = con.prepareStatement(query2);
		Iterator<Row> rowIterator = sheet.iterator();
		rowIterator.next();
		
		try
		{
			for (int row = 1; row <= sheet.getLastRowNum(); row++)
			{
				Row nextRow = sheet.getRow(row);

				for (int col = 0; col < nextRow.getLastCellNum(); col++)
				{

					Cell cell = nextRow.getCell(col);//return the cell at specified index

					if (cell == null)
					{
						cell = nextRow.getCell(col, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
					}
					int columnIndexinsheet = cell.getColumnIndex();//index of the cell
					
					switch (columnIndexinsheet)
					{
					case 0:
						int business_partner_id = (int) cell.getNumericCellValue();//the value of the cell as a number
						stmt.setInt(1, business_partner_id);
						break;
					case 1:
						String business_partner_name = cell.getStringCellValue();
						stmt.setString(2, business_partner_name);
						break;
					case 2:
						String business_partner_code = cell.getStringCellValue();
						stmt.setString(3, business_partner_code);
						break;
					case 3:
						String contact_name = cell.getStringCellValue();
						stmt.setString(4, contact_name);
						
						break;
					case 4:
						String address1 = cell.getStringCellValue();
						stmt.setString(5, address1);
						
						break;
					case 5:
						String address2 = cell.getStringCellValue();
						stmt.setString(6, address2);
						break;
					case 6:
						String city = cell.getStringCellValue();
						stmt.setString(7, city);
						break;
					case 7:
						String province = cell.getStringCellValue();
						stmt.setString(8, province);
						break;
					case 8:
						String country = cell.getStringCellValue();
						stmt.setString(9, country);
						break;
					case 9:
						String postal_code = cell.getStringCellValue();
						stmt.setString(10, postal_code);
						break;
					case 10:
						String parent_company = cell.getStringCellValue();
						stmt.setString(11, parent_company);
						break;
					case 11:
						String toll_free_number = cell.getStringCellValue();
						stmt.setString(12, toll_free_number);
						break;
					case 12:
						cell.setCellType(cell.CELL_TYPE_STRING);//converting into string type
						String phone = cell.getStringCellValue();
						stmt.setString(13, phone);
						break;
					case 13:
						cell.setCellType(cell.CELL_TYPE_STRING);
						String phone_extension = cell.getStringCellValue();
						stmt.setString(14, phone_extension);
						break;
					case 14:
						String fax = cell.getStringCellValue();
						stmt.setString(15, fax);
						break;
					case 15:
						String website_url = cell.getStringCellValue();
						stmt.setString(16, website_url);
						break;
					case 16:
						int payment_condition = (int) cell.getNumericCellValue();
						stmt.setInt(17, payment_condition);
						break;
					case 17:
						String gl_number = cell.getStringCellValue();
						stmt.setString(18, gl_number);
						break;
					case 18:
						int driver_min_age = (int) cell.getNumericCellValue();
						stmt.setInt(19, driver_min_age);
						break;
					case 19:
						int api_enabled = (int) cell.getNumericCellValue();
						stmt.setInt(20, api_enabled);
						break;
					case 20:
						int status = (int) cell.getNumericCellValue();
						stmt.setInt(21, status);
						break;
					case 21:
						String one_way_fee_paid_by = cell.getStringCellValue();
						stmt.setString(22, one_way_fee_paid_by);
						break;
					case 22:
						String country_code = cell.getStringCellValue();
						stmt.setString(23, country_code);
						break;
					}
				}
				stmt.addBatch();
				
				stmt.executeBatch();
				System.out.println("row "+ row +  " is inserted");
			}
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (con != null) {
					con.close();
				}
				if (stmt != null) {
					stmt.close();
				}
							
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
