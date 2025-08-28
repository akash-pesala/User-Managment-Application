package com.java.user.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectorFactory {

	static Connection con = null;
	static String url = "jdbc:mysql://localhost:3306/users";
	static String un = "root";
	static String pwd = "root";
	public static Connection requestConnector() throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url,un,pwd);
		return con;
	}
}
