package com.ito.assignment.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class Jdbc {

	public void executeJdbc() throws SQLException {
		
		
		try {
			//Reading properties file
			FileReader fileReader=null;
			fileReader=new FileReader("property.properties");
			Properties properties=new Properties();
			properties.load(fileReader);
			String url=properties.getProperty("dburl");
			String file = properties.getProperty("file");
			
			//bp_data
			FileInputStream fileInputStream=new FileInputStream(file);
			
			//connection
			Connection con =null;
			con = DriverManager.getConnection(url, "root", "RanjithA@19");
			
			ReadFromExcel rfe = new ReadFromExcel();
			String query2 ="insert into business_partner(business_partner_id,business_partner_name,business_partner_code,contact_name,address1,address2,city,province,country,postal_code,parent_company,toll_free_number,phone,phone_extension,fax,website_url,payment_condition,gl_number,driver_min_age,api_enabled,status,one_way_fee_paid_by,country_code) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			rfe.read(con,query2, fileInputStream);
			
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
}
	
