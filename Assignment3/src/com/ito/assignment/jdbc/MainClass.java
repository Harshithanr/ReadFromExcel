package com.ito.assignment.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class MainClass {

	public static void main(String[] args) throws SQLException, InvalidFormatException, IOException {
		Jdbc jdbc = new Jdbc();
		Connection con =null;
		String uri = "jdbc:mysql://localhost:3306/busisess";
		con = DriverManager.getConnection(uri, "root", "RanjithA@19");
		
		jdbc.executeJdbc(con);
		
	}

}
