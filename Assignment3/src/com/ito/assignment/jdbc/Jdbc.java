package com.ito.assignment.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;



public class Jdbc {

	public void executeJdbc(Connection con,FileInputStream file) throws SQLException, InvalidFormatException, IOException {
		String query1 = "select * from business_partner";
		String query2 = "insert into business_partner(business_partner_id,business_partner_name,"
						+ "business_partner_code,contact_name,address1,address2,city,province,country,"
						+ "postal_code,parent_company,toll_free_number,phone,phone_extension,fax,website_url,"
						+ "payment_condition,gl_number,driver_min_age,api_enabled,status,one_way_fee_paid_by,"
						+ "country_code) "
						+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		ReadFromExcel rfe = new ReadFromExcel();
		rfe.read(con,query2, file);
		display(con, query1);	
	}
	
	public void display(Connection con,String query1) throws SQLException {
		Statement st = null;
		st = con.createStatement();
		ResultSet rs = st.executeQuery(query1);
		st = con.createStatement();
		while(rs.next())
		{
			
			System.out.print(rs.getInt("business_partner_id") + "\t");
			System.out.print(rs.getString("business_partner_name")+ "\t");
			System.out.print(rs.getString("business_partner_code") + "\t");
			System.out.print(rs.getString("contact_name") + "\t");
			System.out.print(rs.getString("address1") + "\t");
			System.out.print(rs.getString("address2") + "\t");
			System.out.print(rs.getString("city") + "\t");
			System.out.print(rs.getString("province") + "\t");
			System.out.print(rs.getString("country") + "\t");
			System.out.print(rs.getString("postal_code") + "\t");
			System.out.print(rs.getString("parent_company") + "\t");
			System.out.print(rs.getString("toll_free_number") + "\t");
			System.out.print(rs.getString("phone") + "\t");
			System.out.print(rs.getString("phone_extension") + "\t");
			System.out.print(rs.getString("fax") +"\t");
			System.out.print(rs.getString("website_url") + "\t");
			System.out.print(rs.getInt("payment_condition") + "\t");
			System.out.print(rs.getString("gl_number") + "\t");
			System.out.print(rs.getInt("driver_min_age") + "\t");
			System.out.print(rs.getInt("api_enabled") + "\t");
			System.out.print(rs.getInt("status") + "\t");
			System.out.print(rs.getString("one_way_fee_paid_by") + "\t");
			System.out.print(rs.getString("country_code") + "\t");
			System.out.println();
			
		}
		rs.close();
		st.close();
		con.close();
	}

	
}
	
