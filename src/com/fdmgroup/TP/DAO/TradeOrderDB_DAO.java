package com.fdmgroup.TP.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Properties;

import com.fdmgroup.TP.DTO.TradeOrder;

public class TradeOrderDB_DAO<T extends TradeOrder> extends AbstractDBDAO{

	private Properties properties;
	private String url, username, password;
	private Connection conn;
	private String tradeOrderDBCreateQuery1, tradeOrderDBCreateQuery2, tradeOrderDBReadQuery1, tradeOrderDBReadQuery2, tradeOrderDBUpdateQuery1, tradeOrderDBUpdateQuery2, tradeOrderDBDeleteQuery1, tradeOrderDBDeleteQuery2;
	private String tradeOrderDBReadAllQuery1, tradeOrderDBReadAllQuery2;
	
	public TradeOrderDB_DAO(){
		PropertiesLoader propertiesLoader = new PropertiesLoader();
		properties = propertiesLoader.getProperties("real.properties");
		
		if(properties != null){
			url = properties.getProperty("url");
			username = properties.getProperty("username");
			password = properties.getProperty("password");
			tradeOrderDBCreateQuery1 = properties.getProperty("tradeOrderDBCreateQuery1");
			tradeOrderDBCreateQuery2 = properties.getProperty("tradeOrderDBCreateQuery2");
			tradeOrderDBReadQuery1 = properties.getProperty("tradeOrderDBReadQuery1");
			tradeOrderDBReadQuery2 = properties.getProperty("tradeOrderDBReadQuery2");
			tradeOrderDBUpdateQuery1 = properties.getProperty("tradeOrderDBUpdateQuery1");
			tradeOrderDBUpdateQuery2 = properties.getProperty("tradeOrderDBUpdateQuery2");
			tradeOrderDBDeleteQuery1 = properties.getProperty("tradeOrderDBDeleteQuery1");
			tradeOrderDBDeleteQuery2 = properties.getProperty("tradeOrderDBDeleteQuery2");
			tradeOrderDBReadAllQuery1 = properties.getProperty("tradeOrderDBReadAllQuery1");
			tradeOrderDBReadAllQuery2 = properties.getProperty("tradeOrderDBReadAllQuery2");
		}
	}

	public boolean create(TradeOrder tradeOrder) {
		try {
			Connection conn = createConnection(url, username, password);
	
			PreparedStatement statement = conn
					.prepareStatement(tradeOrderDBCreateQuery1);
			statement.setInt(1, tradeOrder.getDtoID());
			statement.setInt(2, tradeOrder.getStockID());
			statement.setInt(3, tradeOrder.getVolume());
			statement.setDouble(4, tradeOrder.getPriceTotal());
			statement.setInt(5, tradeOrder.getBuyerID());
			statement.setInt(6, tradeOrder.getSellerID());
			statement.setInt(7, tradeOrder.getBuyBrokerID());
			statement.setInt(8, tradeOrder.getSellBrokerID());
			statement.setDouble(9, tradeOrder.getCommissionRate());
			statement.setInt(10, convertBooleanToNum(tradeOrder.isBuy()));
			statement.setInt(11, convertBooleanToNum(tradeOrder.isActive()));
			statement.setString(12, tradeOrder.getTransaction_time());

			statement.executeUpdate();
			return true;

		} catch (SQLException sqle) {
			log.logger("error", sqle.getMessage());
		} finally {
			closeConnection(conn);
		}
		return false;
	}

	public TradeOrder read(int dtoID) {
		try {
			Connection conn = createConnection(url, username, password);

			PreparedStatement statement = conn
					.prepareStatement(tradeOrderDBReadQuery1);
			statement.setInt(1, dtoID);

			ResultSet rs = statement.executeQuery();
			TradeOrder trade = new TradeOrder();
			while (rs.next()) {
				boolean buy = false, active = false;
				buy=convertNumToBoolean(rs.getInt("buy"));
				active=convertNumToBoolean(rs.getInt("active"));

				trade.setDtoID(rs.getInt("order_id"));
				trade.setStockID(rs.getInt("stock_id"));
				trade.setVolume(rs.getInt("volume"));
				trade.setPriceTotal(rs.getDouble("price_total"));
				trade.setBuyerID(rs.getInt("buyer_id"));
				trade.setSellerID(rs.getInt("seller_id"));
				trade.setBuyBrokerID(rs.getInt("buy_broker_id"));
				trade.setSellBrokerID(rs.getInt("sell_broker_id"));
				trade.setCommissionRate(rs.getDouble("commission_rate"));
				trade.setBuy(buy);
				trade.setActive(active);
				trade.setTransaction_time(rs.getString("order_time"));
			}

			return trade;

		} catch (SQLException sqle) {
			log.logger("error", sqle.getMessage());
		} finally {
			closeConnection(conn);
		}
		return null;
	}

	public boolean update(TradeOrder tradeOrder) {
		try {
			Connection conn = createConnection(url, username, password);

			PreparedStatement statement = conn
					.prepareStatement(tradeOrderDBUpdateQuery1);
			statement.setInt(1, tradeOrder.getDtoID());
			statement.setInt(2, tradeOrder.getStockID());
			statement.setInt(3, tradeOrder.getVolume());
			statement.setDouble(4, tradeOrder.getPriceTotal());
			statement.setInt(5, tradeOrder.getBuyerID());
			statement.setInt(6, tradeOrder.getSellerID());
			statement.setInt(7, tradeOrder.getBuyBrokerID());
			statement.setInt(8, tradeOrder.getSellBrokerID());
			statement.setDouble(9, tradeOrder.getCommissionRate());
			statement.setInt(10, convertBooleanToNum(tradeOrder.isBuy()));
			statement.setInt(11, convertBooleanToNum(tradeOrder.isActive()));
			statement.setString(12, tradeOrder.getTransaction_time());
			statement.setInt(13, tradeOrder.getDtoID());

			statement.executeUpdate();
			return true;

		} catch (SQLException sqle) {
			log.logger("error", sqle.getMessage());
		} finally {
			closeConnection(conn);
		}
		return false;
	}

	public boolean delete(TradeOrder dto) {
		try {
			Connection conn = createConnection(url, username, password);

			PreparedStatement statement = conn
					.prepareStatement(tradeOrderDBDeleteQuery1);
			statement.setInt(1, dto.getDtoID());

			statement.executeUpdate();
			return true;

		} catch (SQLException sqle) {
			log.logger("error", sqle.getMessage());
		} finally {
			closeConnection(conn);
		}
		return false;
	}

	public HashMap<Integer, TradeOrder> readAll() {
		try {

			Connection conn = createConnection(url, username, password);

			PreparedStatement statement = conn
					.prepareStatement(tradeOrderDBReadAllQuery1);

			ResultSet rs = statement.executeQuery();
			HashMap<Integer, TradeOrder> tradeOrders = new HashMap<Integer, TradeOrder>();
			while (rs.next()) {
				TradeOrder trade = new TradeOrder();

				trade.setDtoID(rs.getInt("order_id"));
				trade.setStockID(rs.getInt("stock_id"));
				trade.setVolume(rs.getInt("volume"));
				trade.setPriceTotal(rs.getDouble("price_total"));
				trade.setBuyerID(rs.getInt("buyer_id"));
				trade.setSellerID(rs.getInt("seller_id"));
				trade.setBuyBrokerID(rs.getInt("buy_broker_id"));
				trade.setSellBrokerID(rs.getInt("sell_broker_id"));
				trade.setCommissionRate(rs.getDouble("commission_rate"));
				trade.setBuy(convertNumToBoolean(rs.getInt("buy")));
				trade.setActive(convertNumToBoolean(rs.getInt("active")));
				trade.setTransaction_time(rs.getString("order_time"));

				tradeOrders.put(trade.getDtoID(), trade);
			}

			return tradeOrders;

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
//				Log.logger("trace", e.getMessage());
//			}
//	}




	


}