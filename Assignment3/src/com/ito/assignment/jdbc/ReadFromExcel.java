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
			for (int i = 1; i <= sheet.getLastRowNum(); i++)//getLastRowNum() will give you the total number of rows in a sheet
			{
				Row nextRow = sheet.getRow(i);//getRow(i) will give you the row at specified index

				for (int j = 0; j < nextRow.getLastCellNum(); j++)//returns total how many cells are there in specified row or index of last cell
				{

					Cell nextCellinsheet = nextRow.getCell(j);//return the cell at specified index

					if (nextCellinsheet == null)
					{
						nextCellinsheet = nextRow.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
					}
					int columnIndexinsheet = nextCellinsheet.getColumnIndex();//index of the cell
					
					switch (columnIndexinsheet)
					{
					case 0:
						int business_partner_id = (int) nextCellinsheet.getNumericCellValue();//the value of the cell as a number
						stmt.setInt(1, business_partner_id);
						break;
					case 1:
						String business_partner_name = nextCellinsheet.getStringCellValue();
						stmt.setString(2, business_partner_name);
						break;
					case 2:
						String business_partner_code = nextCellinsheet.getStringCellValue();
						stmt.setString(3, business_partner_code);
						break;
					case 3:
						String contact_name = nextCellinsheet.getStringCellValue();
						stmt.setString(4, contact_name);
						
						break;
					case 4:
						String address1 = nextCellinsheet.getStringCellValue();
						stmt.setString(5, address1);
						
						break;
					case 5:
						String address2 = nextCellinsheet.getStringCellValue();
						stmt.setString(6, address2);
						break;
					case 6:
						String city = nextCellinsheet.getStringCellValue();
						stmt.setString(7, city);
						break;
					case 7:
						String province = nextCellinsheet.getStringCellValue();
						stmt.setString(8, province);
						break;
					case 8:
						String country = nextCellinsheet.getStringCellValue();
						stmt.setString(9, country);
						break;
					case 9:
						String postal_code = nextCellinsheet.getStringCellValue();
						stmt.setString(10, postal_code);
						break;
					case 10:
						String parent_company = nextCellinsheet.getStringCellValue();
						stmt.setString(11, parent_company);
						break;
					case 11:
						String toll_free_number = nextCellinsheet.getStringCellValue();
						stmt.setString(12, toll_free_number);
						break;
					case 12:
						nextCellinsheet.setCellType(nextCellinsheet.CELL_TYPE_STRING);//converting into string type
						String phone = nextCellinsheet.getStringCellValue();
						stmt.setString(13, phone);
						break;
					case 13:
						nextCellinsheet.setCellType(nextCellinsheet.CELL_TYPE_STRING);
						String phone_extension = nextCellinsheet.getStringCellValue();
						stmt.setString(14, phone_extension);
						break;
					case 14:
						String fax = nextCellinsheet.getStringCellValue();
						stmt.setString(15, fax);
						break;
					case 15:
						String website_url = nextCellinsheet.getStringCellValue();
						stmt.setString(16, website_url);
						break;
					case 16:
						int payment_condition = (int) nextCellinsheet.getNumericCellValue();
						stmt.setInt(17, payment_condition);
						break;
					case 17:
						String gl_number = nextCellinsheet.getStringCellValue();
						stmt.setString(18, gl_number);
						break;
					case 18:
						int driver_min_age = (int) nextCellinsheet.getNumericCellValue();
						stmt.setInt(19, driver_min_age);
						break;
					case 19:
						int api_enabled = (int) nextCellinsheet.getNumericCellValue();
						stmt.setInt(20, api_enabled);
						break;
					case 20:
						int status = (int) nextCellinsheet.getNumericCellValue();
						stmt.setInt(21, status);
						break;
					case 21:
						String one_way_fee_paid_by = nextCellinsheet.getStringCellValue();
						stmt.setString(22, one_way_fee_paid_by);
						break;
					case 22:
						String country_code = nextCellinsheet.getStringCellValue();
						stmt.setString(23, country_code);
						break;
					}
				}
				stmt.addBatch();
				
				stmt.executeBatch();
				System.out.println("row "+ i +  " is inserted");
			}
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		

	}
}
