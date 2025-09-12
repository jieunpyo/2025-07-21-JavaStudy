package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DAOdefault {
	private final static String URL="jdbc:oracle:thin:@211.238.142.22:1521:XE";
	public DAOdefault() {
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception ex) {}
	}
	public Connection getConnection(Connection conn)
	{
		try
		{
			conn=DriverManager.getConnection(URL,"hr_2","happy");
		}catch(Exception ex) {}
		
		return conn;
	}
	public void disConnection(Connection conn, PreparedStatement ps)
	{
		try
		{
			 if(ps!=null) ps.close(); if(conn!=null) conn.close();
		}catch(Exception ex) {}
	}
}
