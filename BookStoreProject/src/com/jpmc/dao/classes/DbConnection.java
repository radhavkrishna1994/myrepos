package com.jpmc.dao.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	private static Connection connection;
	public static Connection getConnection() {
		return connection;
	}

	/*private static String driverClass="com.mysql.jdbc.Driver";//"oracle.jdbc.driver.OracleDriver"
	private static String dbUrl="jdbc:mysql://localhost/jpmc";
	//String dbUrl="jdbc:oracle:thin@localhost:1521:orcl";
	private static String user="root";
	private static String password="root";
	*/
	private DbConnection(){ }
	
	public static void setConnection(String driverClass,String dbUrl,String username,String password)
	{
		try{
			Class.forName(driverClass);
			connection =  DriverManager.getConnection(dbUrl,username,password);
			if(connection!=null)
				System.out.println("Connection Done ..");
			//return connection;
		}
		catch(ClassNotFoundException | SQLException e)
		{
			System.out.println(e);
			//return null;
		}
	}
	
	/*public static void main(String[] args) {
		setConnection();
	}*/
	

}
