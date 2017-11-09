package com.fdmgroup.TP.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import com.fdmgroup.TP.DTO.Permission;
import com.fdmgroup.TP.DTO.User;

public class UserDB_DAO<T extends User> extends AbstractDBDAO {

	private Properties properties;
	private String url, username, password;
	private Connection conn;
	private String userDBCreateQuery1, userDBCreateQuery2, userDBReadQuery1,
			userDBReadQuery2, userDBReadAllQuery1, userDBReadAllQuery2;
	private String userDBUpdateQuery1, userDBUpdateQuery2, userDBDeleteQuery1,
			userDBDeleteQuery2;


	public UserDB_DAO() {
		PropertiesLoader propertiesLoader = new PropertiesLoader();
		properties = propertiesLoader.getProperties("real.properties");

		if (properties != null) {
			url = properties.getProperty("url");
			username = properties.getProperty("username");
			password = properties.getProperty("password");

			userDBCreateQuery1 = properties.getProperty("userDBCreateQuery1");
			userDBCreateQuery2 = properties.getProperty("userDBCreateQuery2");
			userDBReadQuery1 = properties.getProperty("userDBReadQuery1");
			userDBReadQuery2 = properties.getProperty("userDBReadQuery2");
			userDBUpdateQuery1 = properties.getProperty("userDBUpdateQuery1");
			userDBUpdateQuery2 = properties.getProperty("userDBUpdateQuery2");
			userDBDeleteQuery1 = properties.getProperty("userDBDeleteQuery1");
			userDBDeleteQuery2 = properties.getProperty("userDBDeleteQuery2");
			userDBReadAllQuery1 = properties.getProperty("userDBReadAllQuery1");
			userDBReadAllQuery2 = properties.getProperty("userDBReadAllQuery2");
		}
	}

	public boolean create(User user) {
		try {
			Connection conn = createConnection(url, username, password);

			int ban;
			if (!user.isBan())
				ban = 0;
			else
				ban = 1;

			PreparedStatement statement = conn
					.prepareStatement(userDBCreateQuery1);
			statement.setInt(1, user.getDtoID());
			statement.setString(2, user.getUsername());
			statement.setString(3, user.getPassword());
			statement.setString(4, user.getFirstname());
			statement.setString(5, user.getLastname());
			statement.setString(6, user.getDOB());
			statement.setString(7, user.getAddress());
			statement.setInt(8, ban);
			statement.executeUpdate();

			PreparedStatement statement2 = conn
					.prepareStatement(userDBCreateQuery2);
			for (Permission value : user.getPermission()) {
				if (value.equals(Permission.ADMIN)) {
					statement2.setInt(1, user.getDtoID());
					statement2.setInt(2, 1);
					statement2.addBatch();
				}
				if (value.equals(Permission.BROKER)) {
					statement2.setInt(1, user.getDtoID());
					statement2.setInt(2, 2);
					statement2.addBatch();
				}
				if (value.equals(Permission.SHAREHOLDER)) {
					statement2.setInt(1, user.getDtoID());
					statement2.setInt(2, 3);
					statement2.addBatch();
				}
				
			}
			
			statement2.executeBatch();
			return true;

		} catch (SQLException sqle) {
			log.logger("error", sqle.getMessage());
		} finally {
			closeConnection(conn);
		}
		return false;
	}

	public User read(int dtoID) {
		try {
			Connection conn = createConnection(url, username, password);

			PreparedStatement statement = conn
					.prepareStatement(userDBReadQuery1);
			PreparedStatement statement2 = conn
					.prepareStatement(userDBReadQuery2);
			statement.setInt(1, dtoID);
			statement2.setInt(1, dtoID);

			ResultSet rs = statement.executeQuery();
			User userTemp = populateUserInfo(rs);

			ResultSet rs2 = statement2.executeQuery();
			HashSet<Permission> permissions = new HashSet<Permission>();
			while (rs2.next()) {
				if (rs2.getInt("permission_id") == 1)
					permissions.add(Permission.ADMIN);
				if (rs2.getInt("permission_id") == 2)
					permissions.add(Permission.BROKER);
				if (rs2.getInt("permission_id") == 3)
					permissions.add(Permission.SHAREHOLDER);
			}
			userTemp.setPermission(permissions);
			return userTemp;

		} catch (SQLException sqle) {
			log.logger("error", sqle.getMessage());
		} finally {
			closeConnection(conn);
		}
		return null;
	}

	public boolean update(User user) {
		if (delete(user) && create(user))
			return true;
		return false;

	}

	public boolean delete(User user) {
		try {
			Connection conn = createConnection(url, username, password);

			int userID = user.getDtoID();
			PreparedStatement statement = conn
					.prepareStatement(userDBDeleteQuery1);
			PreparedStatement statement2 = conn
					.prepareStatement(userDBDeleteQuery2);
			statement.setInt(1, userID);
			statement2.setInt(1, userID);

			statement2.executeUpdate();
			statement.executeUpdate();
			return true;

		} catch (SQLException sqle) {
			log.logger("error", sqle.getMessage());
		} finally {
			closeConnection(conn);
		}
		return false;

	}

	public HashMap<Integer, User> readAll() {
		HashMap<Integer, User> users = new HashMap<Integer, User>();
		try {
			Connection conn = createConnection(url, username, password);

			PreparedStatement statement = conn
					.prepareStatement(userDBReadAllQuery1);
			PreparedStatement statement2 = conn
					.prepareStatement(userDBReadAllQuery2);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				User userTemp = new User();
				userTemp.setDtoID(rs.getInt("user_id"));
				userTemp.setUsername(rs.getString("username"));
				userTemp.setPassword(rs.getString("password_db"));
				userTemp.setFirstname(rs.getString("first_name"));
				userTemp.setLastname(rs.getString("last_name"));
				userTemp.setDOB(rs.getString("DOB").substring(0, 10));
				userTemp.setAddress(rs.getString("address"));
				setBan(userTemp, rs.getInt("ban"));

				statement2.setInt(1, userTemp.getDtoID());
				ResultSet rs2 = statement2.executeQuery();

				HashSet<Permission> permissions = new HashSet<Permission>();
				while (rs2.next()) {
					if (rs2.getInt("permission_id") == 1)
						permissions.add(Permission.ADMIN);
					if (rs2.getInt("permission_id") == 2)
						permissions.add(Permission.BROKER);
					if (rs2.getInt("permission_id") == 3)
						permissions.add(Permission.SHAREHOLDER);
				}
				userTemp.setPermission(permissions);
				users.put(userTemp.getDtoID(), userTemp);
			}

			return users;

		} catch (SQLException sqle) {
			log.logger("error", sqle.getMessage());
		} finally {
			closeConnection(conn);
		}
		return null;

	}

	private User populateUserInfo(ResultSet rs) throws SQLException {
		User userTemp = new User();
		if (rs != null)
			while (rs.next()) {
				userTemp.setDtoID(rs.getInt("user_id"));
				userTemp.setUsername(rs.getString("username"));
				userTemp.setPassword(rs.getString("password_db"));
				userTemp.setFirstname(rs.getString("first_name"));
				userTemp.setLastname(rs.getString("last_name"));
				userTemp.setDOB(rs.getString("DOB").substring(0, 10));
				//System.out.println(rs.getString("DOB").substring(0, 10));
				userTemp.setAddress(rs.getString("address"));
				setBan(userTemp, rs.getInt("ban"));
			}
		return userTemp;
	}

	public Collection<Permission> returnPermissionSet(String permission) {
		HashSet<Permission> permissions = new HashSet<Permission>();
		String[] parts = permission.trim().split(",");
		for (int i = 0; i < parts.length; i++) {
			if (parts[i].equalsIgnoreCase("Admin"))
				permissions.add(Permission.ADMIN);
			if (parts[i].equalsIgnoreCase("Broker"))
				permissions.add(Permission.BROKER);
			if (parts[i].equalsIgnoreCase("Shareholder"))
				permissions.add(Permission.SHAREHOLDER);
		}
		return permissions;
	}

	private boolean setBan(User user, int ban) {
		if (ban == 0)
			user.setBan(false);
		else if (ban == 1)
			user.setBan(true);
		return false;

	}

	private void writeUserDetail(HashMap<Integer, User> users) {

		Iterator i = users.entrySet().iterator();
		while (i.hasNext()) {
			Map.Entry me = (Map.Entry) i.next();
			User user = (User) me.getValue();
			log.logger(
					"trace",
					"\n" + user.getDtoID() + " " + user.getUsername() + " "
							+ user.getPassword() + " " + user.getFirstname()
							+ " " + user.getLastname() + " "
							+ user.getAddress() + " " + user.getDOB());
			for (Permission value : user.getPermission())
				log.logger("trace", value.toString() + " ");
		}
	}

}
