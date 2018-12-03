package com.jpmc.dao.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jpmc.bean.User;
import com.jpmc.dao.interfaces.LoginDaoI;

public class LoginDao implements LoginDaoI {
private Connection connection;
	public LoginDao()
	{
		connection=DbConnection.getConnection();
		
	}
	
	@Override
	public User validateUser(User user) {
		//db statements
		String template =  "select * from user where phoneNo=? and password=?";
		try{
			PreparedStatement pstmt=connection.prepareStatement(template);
			pstmt.setString(1, user.getPhoneNo());
			pstmt.setString(2, user.getPassword());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())//if records are present
			{
				user.setRole(rs.getString(3));return user;
			}
			return null;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return null;
	}

	public static void main(String[] args) {
		
		LoginDao dao = new LoginDao();
		System.out.println(dao.validateUser(new User("2222222222", "sam","")));
	}
}
