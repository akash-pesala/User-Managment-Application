package com.java.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.java.user.connector.ConnectorFactory;
import com.java.user.model.User;

public class UserDaoImp implements UserDao
{

	Connection con = null;
	
	public List<User> selectAllUsers() {
		List<User> user = null;
		try {
			con = ConnectorFactory.requestConnector();
			String query = "select * from users_table";
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(query);
			user = new ArrayList<User>();
			while(res.next() == true)
			{
				int id = res.getInt(1);
				String name = res.getString(2);
				String email = res.getString(3);
				String country = res.getString(4);
				User us = new User(id,name,email,country);
				user.add(us);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}	
		
		return user;
	}

	

	public User selectUser(int id) {
		User user = null;
		try {
			con = ConnectorFactory.requestConnector();
			String query = "select * from users_table where id = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet res = pstmt.executeQuery();
			while(res.next() == true)
			{
				String name = res.getString(2);
				String email = res.getString(3);
				String country = res.getString(4);
				user = new User(id,name,email,country);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}	
		
		return user;
	}

	public void insertUser(User user) {
		try {
			con = ConnectorFactory.requestConnector();
			
			String query = "INSERT INTO users_table" + "  (name, email, country) VALUES " + " (?, ?, ?);";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getCountry());
			pstmt.executeUpdate();
		} 
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public boolean updateUser(User user) {
		boolean rowupdated = false;
		try {
			con = ConnectorFactory.requestConnector();
			String query = "update users_table set name = ?,email = ?,country = ? where id = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getCountry());
			pstmt.setInt(4, user.getId());
			rowupdated = pstmt.executeUpdate() > 0;
		}
		catch (Exception e) {
			e.printStackTrace();
		}	
		return rowupdated;
	}


	public boolean deleteUser(int id) {
		boolean rowupdated = false;
		try {
			con = ConnectorFactory.requestConnector();
			String query = "delete from users_table where id = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			rowupdated = pstmt.executeUpdate()>0;
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}	
		return rowupdated;
	}
	
}
