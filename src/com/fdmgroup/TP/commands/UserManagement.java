package com.fdmgroup.TP.commands;

import java.util.HashSet;

import com.fdmgroup.TP.DAO.IStorage;
import com.fdmgroup.TP.DAO.UserDB_DAO;
import com.fdmgroup.TP.DTO.Admin;
import com.fdmgroup.TP.DTO.Broker;
import com.fdmgroup.TP.DTO.Permission;
import com.fdmgroup.TP.DTO.Shareholder;
import com.fdmgroup.TP.DTO.User;

public class UserManagement {
	private User userTemp = new User();
	private Log log;
	
	public boolean addUserToRAM(IStorage<User> userDAO, User user){
		userDAO.create(user);
		return true;
	}
	
	public boolean updateUserDetail(IStorage<User> userDAO, int userID, String field, String value){
		if(field.equalsIgnoreCase("firstname")){
			userTemp = userDAO.read(userID);
			userTemp.setFirstname(value);
			userDAO.update(userTemp);
			return true;
		}else if(field.equalsIgnoreCase("lastname")){
			userTemp = userDAO.read(userID);
			userTemp.setLastname(value);
			userDAO.update(userTemp);
			return true;
		}else if(field.equalsIgnoreCase("DOB")){
			userTemp = userDAO.read(userID);
			userTemp.setDOB(value);
			userDAO.update(userTemp);
			return true;
		}else{
		log.logger("Error", "you cant update, not such field");
		return false;
		}
	}
	
	public User createBlankUser(String userType){
		if(userType == null)
			return null;
		
		if(userType.equalsIgnoreCase("Admin")){
			User admin = new Admin();
			HashSet<Permission> permission = new HashSet<Permission>();
			permission.add(Permission.ADMIN);
			admin.setPermission(permission);
			return admin;
		} else if(userType.equalsIgnoreCase("shareholder")){
			User shareholder = new Shareholder();
			HashSet<Permission> permission = new HashSet<Permission>();
			permission.add(Permission.SHAREHOLDER);
			shareholder.setPermission(permission);
			return shareholder;
		} else if(userType.equalsIgnoreCase("Broker")){
			User broker = new Broker();
			HashSet<Permission> permission = new HashSet<Permission>();
			permission.add(Permission.BROKER);
			broker.setPermission(permission);
			return new Broker();
		}
		return null;
	}
	
	public void FillOutUserInfor(User user, String firstname, String lastname, String DOB, String address,
			 String username, String password){
		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setAddress(address);
		user.setDOB(DOB);
		user.setUsername(username);
		user.setPassword(password);
		
		UserDB_DAO<User> userDAO = new UserDB_DAO<User>();
		
		int userID = userDAO.readAll().size();
		user.setDtoID(userID);
		
	}
}
