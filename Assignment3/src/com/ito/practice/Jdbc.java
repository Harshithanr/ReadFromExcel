package com.ito.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc {
	public static void main(String args[]) {
		Connection con = null;
		try {
			String url = "jdbc:mysql://localhost:3306/student_database";
			con = DriverManager.getConnection(url,"root", "RanjithA@19");
			
			Statement st = null;
			String query1 = "insert into student_details(student_id, student_name) values('10','Virat')";
			String query2 = "select * from student_details";
			
				st = con.createStatement();
				if(st.executeUpdate(query1)!= 0)
				{
					System.out.println("The given value is inserted");
				}
				ResultSet rs = st.executeQuery(query2);
				while(rs.next())
				{
					int id = rs.getInt("Student_id");
					String name = rs.getString("student_name");
					System.out.print(id + "\t");
					System.out.println(name);
				}	
					
		          
		      

		    } catch (SQLException e) {
		        throw new Error("Problem", e);
		    } finally {
		      try {
		        if (con != null) {
		            con.close();
		        }
		      } catch (SQLException ex) {
		          System.out.println(ex.getMessage());
		      }
		    
		  
		
		}
	}
}


