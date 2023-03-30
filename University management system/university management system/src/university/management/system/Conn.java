package university.management.system;

import java.sql.*;

public class Conn {
	private Connection con;
	public Statement stmt;
	Conn(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitymanagementsystem","root","root");
			stmt = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
