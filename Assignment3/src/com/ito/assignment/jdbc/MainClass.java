package com.ito.assignment.jdbc;
import java.sql.SQLException;

public class MainClass {

	public static void main(String[] args) {
		Jdbc jdbc = new Jdbc();
			
		try {
			jdbc.executeJdbc();
		} catch ( SQLException e) {
			e.printStackTrace();
		}
	}

}
