package com.ito.assignment.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;



public class Jdbc {

	public void executeJdbc(Connection con) throws SQLException, InvalidFormatException, IOException {
		String query1 = "select * from student_details";
		String query2 = "insert into business_partner(business_partner_id,business_partner_name,"
						+ "business_partner_code,contact_name,address1,address2,city,province,country,"
						+ "postal_code,parent_company,toll_free_number,phone,phone_extension,fax,website_url,"
						+ "payment_condition,gl_number,driver_min_age,api_enabled,status,one_way_fee_paid_by,"
						+ "country_code) "
						+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		ReadFromExcel rfe = new ReadFromExcel();
		rfe.read(con,query2);
		//display(con, query1);	
	}
	
	public void display(Connection con,String query1) throws SQLException {
		Statement st = null;
		st = con.createStatement();
		ResultSet rs = st.executeQuery(query1);
		st = con.createStatement();
		while(rs.next())
		{
			int id = rs.getInt("Student_id");
			String name = rs.getString("student_name");
			System.out.print(id + "\t");
			System.out.println(name);
		}	
	}
}
	
