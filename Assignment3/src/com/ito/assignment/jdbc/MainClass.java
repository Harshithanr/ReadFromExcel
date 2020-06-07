package com.ito.assignment.jdbc;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class MainClass {

	public static void main(String[] args) throws SQLException, InvalidFormatException, IOException {
		Jdbc jdbc = new Jdbc();
		Connection con =null;
		
		FileReader fileReader=null;
		
		fileReader=new FileReader("property.properties");
		Properties properties=new Properties();
		properties.load(fileReader);
		String dburl=properties.getProperty("dburl");
		String file = properties.getProperty("file");
		
		FileInputStream fileInputStream=new FileInputStream(file);
		System.out.println(dburl);
		
		
		con = DriverManager.getConnection(dburl, "root", "RanjithA@19");
		jdbc.executeJdbc(con,fileInputStream);
		
		
	}

}
