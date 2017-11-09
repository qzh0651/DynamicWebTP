package com.fdmgroup.TP.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Properties;

import com.fdmgroup.TP.DTO.Stock;
import com.fdmgroup.TP.commands.Log;

public class StockDB_DAO<T extends Stock> extends AbstractDBDAO {

	private Properties properties;
	private String url, username, password;
	private Connection conn;
	private String stockDBCreateQuery1, stockDBCreateQuery2, stockDBReadQuery1,
			stockDBReadQuery2, stockDBUpdateQuery1, stockDBUpdateQuery2,
			stockDBDeleteQuery1, stockDBDeleteQuery2;
	private String stockDBReadAllQuery1, stockDBReadAllQuery2;
	

	public StockDB_DAO() {
		PropertiesLoader propertiesLoader = new PropertiesLoader();
		properties = propertiesLoader.getProperties("real.properties");

		if (properties != null) {
			url = properties.getProperty("url");
			username = properties.getProperty("username");
			password = properties.getProperty("password");
			stockDBCreateQuery1 = properties.getProperty("stockDBCreateQuery1");
			stockDBCreateQuery2 = properties.getProperty("stockDBCreateQuery2");
			stockDBReadQuery1 = properties.getProperty("stockDBReadQuery1");
			stockDBReadQuery2 = properties.getProperty("stockDBReadQuery2");
			stockDBUpdateQuery1 = properties.getProperty("stockDBUpdateQuery1");
			stockDBUpdateQuery2 = properties.getProperty("stockDBUpdateQuery2");
			stockDBDeleteQuery1 = properties.getProperty("stockDBDeleteQuery1");
			stockDBDeleteQuery2 = properties.getProperty("stockDBDeleteQuery2");
			stockDBReadAllQuery1 = properties
					.getProperty("stockDBReadAllQuery1");
			stockDBReadAllQuery2 = properties
					.getProperty("stockDBReadAllQuery2");
		}
	}

	public boolean create(Stock stock) {
		try {
			Connection conn = createConnection(url, username, password);

			PreparedStatement statement = conn
					.prepareStatement(stockDBCreateQuery1);
			
			statement.setInt(1, stock.getDtoID());
			statement.setString(2, stock.getSymbol());
			statement.setString(3, stock.getCompanyName());
			statement.setDouble(4, stock.getUnitPrice());
			statement.setInt(5, stock.getVolume());
			statement.setInt(6, stock.getUnownedShares());
			statement.setInt(7, convertBooleanToNum(stock.isActive()));

			statement.executeUpdate();
			return true;

		} catch (SQLException sqle) {
			 log.logger("error", sqle.getMessage());
		} finally {
			closeConnection(conn);
		}
		return false;
	}

	public Stock read(int dtoID) {
		try {
			Connection conn = createConnection(url, username, password);

			PreparedStatement statement = conn
					.prepareStatement(stockDBReadQuery1);
			statement.setInt(1, dtoID);

			ResultSet rs = statement.executeQuery();
			Stock stock = new Stock();
			while (rs.next()) {
				
				stock.setDtoID(rs.getInt("stock_id"));
				stock.setSymbol(rs.getString("symbol"));
				stock.setCompanyName(rs.getString("companyName"));
				stock.setUnitPrice(rs.getDouble("unitPrice"));
				stock.setVolume(rs.getInt("volume"));
				stock.setUnownedShares(rs.getInt("unownedshares"));
				stock.setActive(convertNumToBoolean(rs.getInt("active")));
			}
			return stock;
		} catch (SQLException sqle) {
			log.logger("error", sqle.getMessage());
		} finally {
			closeConnection(conn);
		}
		return null;
	}

	public boolean update(Stock stock) {
		try {
			Connection conn = createConnection(url, username, password);

			PreparedStatement statement = conn
					.prepareStatement(stockDBUpdateQuery1);
			statement.setInt(1, stock.getDtoID());
			statement.setString(2, stock.getSymbol());
			statement.setString(3, stock.getCompanyName());
			statement.setDouble(4, stock.getUnitPrice());
			statement.setInt(5, stock.getVolume());
			statement.setInt(6, stock.getUnownedShares());
			statement.setInt(7, convertBooleanToNum(stock.isActive()));
			statement.setInt(8, stock.getDtoID());

			statement.executeUpdate();
			return true;
		} catch (SQLException sqle) {
			log.logger("error", sqle.getMessage());
		} finally {
			closeConnection(conn);
		}
		return false;
	}

	public boolean delete(Stock stock) {
		try {
			Connection conn = createConnection(url, username, password);

			PreparedStatement statement = conn
					.prepareStatement(stockDBDeleteQuery1);
			statement.setInt(1, stock.getDtoID());

			statement.executeUpdate();
			return true;

		} catch (SQLException sqle) {
			log.logger("error", sqle.getMessage());
		} finally {
			closeConnection(conn);
		}
		return false;
	}

	public HashMap<Integer, Stock> readAll() {
		try {

			Connection conn = createConnection(url, username, password);

			PreparedStatement statement = conn
					.prepareStatement(stockDBReadAllQuery1);

			ResultSet rs = statement.executeQuery();

			HashMap<Integer, Stock> stocks = new HashMap<Integer, Stock>();
			while (rs.next()) {
				Stock stock = new Stock();
				stock.setDtoID(rs.getInt("stock_id"));
				stock.setSymbol(rs.getString("symbol"));
				stock.setCompanyName(rs.getString("companyName"));
				stock.setUnitPrice(rs.getDouble("unitPrice"));
				stock.setVolume(rs.getInt("volume"));
				stock.setUnownedShares(rs.getInt("unownedshares"));
				stock.setActive(convertNumToBoolean(rs.getInt("active")));
				
				stocks.put(stock.getDtoID(), stock);
			}

			return stocks;

		} catch (SQLException sqle) {
			log.logger("error", sqle.getMessage());
		} finally {
			closeConnection(conn);
		}
		return null;
	}

//	private Connection createConnection(String url, String username,
//			String password) throws SQLException {
//		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
//
//		return conn = DriverManager.getConnection(url, username, password);
//	}
//
//	private void closeConnection(Connection conn) {
//		if (conn != null)
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				log.logger("error", e.getMessage());
//			}
//	}

}
