package com.fdmgroup.TP.DTO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;


public class User implements DTO {
//	public enum Permission {
//		SHAREHOLDER, BROKER, ADMIN, GUEST;
//	}
	
	int userID;
	String username;
	String password;
	Collection<Permission> permissions;
	String firstname;
	String lastname;
	String DOB;
	String address;
	boolean ban;
	HashMap<Integer,Request> requests;
	HashMap<Integer, Stock> stockOwned;
	

	
	
	public void writeUserDetail(){
		System.out.println(""+userID+" "+username+" "+password+" "+firstname+" "+lastname);
	}
	

	public User(int userID, String username, String password,
			Collection<Permission> permissions, boolean ban) {
		super();
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.permissions = permissions;
		this.ban = ban;
	}

	public User(int userID, String username, String password,
			Collection<Permission> permissions, String firstname,
			String lastname, String dOB, String address, boolean ban) {
		super();
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.permissions = permissions;
		this.firstname = firstname;
		this.lastname = lastname;
		this.DOB = dOB;
		this.address = address;
		this.ban = ban;
	}

	public User(int userID, String username, String password, Collection<Permission> permissions){
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.permissions = permissions;		
	}

	public User(String username, String password, Collection<Permission> permissions){
		this.username = username;
		this.password = password;
		this.permissions = permissions;		
	}
	
	
	public HashMap<Integer, Stock> getStockOwned() {
		return stockOwned;
	}


	public void setStockOwned(HashMap<Integer, Stock> stockOwned) {
		this.stockOwned = stockOwned;
	}


	public HashMap<Integer, Request> getRequests() {
		return requests;
	}


	public void setRequests(HashMap<Integer, Request> requests) {
		this.requests = requests;
	}


	public boolean isBan() {
		return ban;
	}

	public void setBan(boolean ban) {
		this.ban = ban;
	}
	

	public User() {
		
	}
	
	
	



	public User(int userID, String username, String password, String firstname,
			String lastname, String dOB, String address, boolean ban) {
		super();
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		DOB = dOB;
		this.address = address;
		this.ban = ban;
	}


	public Collection<Permission> getPermission() {
		return permissions;
	}
	public void setPermission(Collection<Permission> permissions) {
		this.permissions = permissions;
	}


	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName(){
		return firstname+" "+lastname;
	}

	public int getDtoID() {
		
		return userID;
	}

	public void setDtoID(int dtoID) {
		
		this.userID = dtoID;
	}

}