package com.fdmgroup.TP.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

import com.fdmgroup.TP.commands.Log;



public abstract class AbstractDBDAO implements IStorage{
	
	protected Log log = new Log();
	
	
	protected Connection createConnection(String url, String username,
			String password) throws SQLException {
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		Connection conn;
		return conn = DriverManager.getConnection(url, username, password);
	}

	protected void closeConnection(Connection conn) {
		if (conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
				log.logger("error", e.getMessage());
			}
	}
	
	protected int convertBooleanToNum(Boolean TF){
		if(TF)
			return 1;
		else
			return 0;
	}
	
	protected boolean convertNumToBoolean(Integer number){
		if(number==0)
			return false;
		else if(number == 1)
			return true;
		return false;
	}
	
	public boolean create(Object dto) {
		
		return false;
	}

	public Object read(int dtoID) {
		
		return null;
	}

	public boolean update(Object dto) {
		
		return false;
	}

	public boolean delete(Object dto) {
		
		return false;
	}

	public HashMap readAll() {
		
		return null;
	}

}
