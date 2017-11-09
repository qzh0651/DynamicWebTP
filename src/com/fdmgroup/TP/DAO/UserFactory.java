package com.fdmgroup.TP.DAO;

import java.util.HashSet;

import com.fdmgroup.TP.DTO.Admin;
import com.fdmgroup.TP.DTO.Broker;
import com.fdmgroup.TP.DTO.Permission;
import com.fdmgroup.TP.DTO.Shareholder;
import com.fdmgroup.TP.DTO.User;


public class UserFactory {

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
			int userID, String username, String password){
		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setAddress(address);
		user.setDOB(DOB);
		user.setUsername(username);
		user.setPassword(password);
		user.setDtoID(userID);
		
//		HashSet<Permission> permissionlocal = new HashSet<Permission>();
//		permissionlocal.add(permission);
//		user.setPermission(permissionlocal);
		
	}
}
