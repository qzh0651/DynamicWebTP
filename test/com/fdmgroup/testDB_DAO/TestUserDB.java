package com.fdmgroup.testDB_DAO;

import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.TP.DAO.StockDB_DAO;
import com.fdmgroup.TP.DAO.TradeOrderDB_DAO;
import com.fdmgroup.TP.DAO.UserDB_DAO;
import com.fdmgroup.TP.DTO.Permission;
import com.fdmgroup.TP.DTO.Stock;
import com.fdmgroup.TP.DTO.TradeOrder;
import com.fdmgroup.TP.DTO.User;

public class TestUserDB {
	private User mockUser1, mockUser2, mockUser3, mockUser4, mockUser5;
	private UserDB_DAO<User> userDB;
	private Collection<Permission> permissions1, permissions2, permissions3;
	private Permission permission;
	private TradeOrder mockTrade6, mockTradeOrder2, mockTradeOrder3;
	private TradeOrderDB_DAO<TradeOrder> tradeDB;
	private StockDB_DAO<Stock> stockDB;
	private Stock mockStock4;
	
	
	@Before
	public void setUp() throws Exception {
		userDB = new UserDB_DAO<User>();
		
		permissions1 = new HashSet<Permission>();
		permissions2 = new HashSet<Permission>();
		permissions3 = new HashSet<Permission>();
		
		permissions1.add(permission.ADMIN); permissions1.add(permission.BROKER);permissions1.add(permission.SHAREHOLDER);
		permissions2.add(permission.ADMIN); permissions2.add(permission.BROKER);
		permissions3.add(permission.SHAREHOLDER);
		
		
		mockUser4 = new User(4, "James4username", "li4password", permissions1, "James4", "li4", "11-AUG-1980", "4 Grand St, New York", false);
		
	}

	@Test
	public void testUserDB_DAOCreate() {
		userDB.delete(mockUser4);
		assertTrue(userDB.create(mockUser4));
		assertTrue(userDB.read(4).getUsername().equals("James4username"));
		assertTrue(userDB.read(4).getPassword().equals("li4password"));
		assertTrue(userDB.read(4).getFirstname().equals("James4"));
		assertTrue(userDB.read(4).getLastname().equals("li4"));
		assertTrue(userDB.read(4).getDOB().equals("1980-08-11"));
		assertTrue(userDB.read(4).getAddress().equals("4 Grand St, New York"));
		assertTrue(!userDB.read(4).isBan());
		

	}
	
	@Test
	public void testUserDB_DAORead(){
		assertTrue(userDB.read(1).getPermission().equals(permissions1));
		
	}
	
	@Test
	public void testUserDB_DAOReadDOBLength(){
		assertTrue(userDB.read(1).getDOB().length()==10);
	}
	
	@Test
	public void testUserDB_DAOReadDOBDetail(){
		assertTrue(userDB.read(1).getDOB().equals("1961-01-11"));
	}
	
	@Test
	public void testUserDB_DAOReadMockUserFourDOBDetail(){
		userDB.create(mockUser4);
		assertTrue(userDB.read(4).getDOB().equals("1980-08-11"));
	}
	
	@Test
	public void testUserDB_DAOupdate(){
		mockUser5 = new User(3, "James5s username", "li5s password", permissions2, "Jame4", "li4", "25-Feb-1980", "4 Grand St, New York", true);
		assertTrue(userDB.update(mockUser5));
		assertTrue(userDB.read(3).getUsername().equals("James5s username"));
		assertTrue(userDB.read(3).getDOB().equals("1980-02-25"));
		assertTrue(userDB.read(3).isBan()==true);
	}

	@Test
	public void testUserDB_DAOdelete() {
		assertTrue(userDB.delete(mockUser4));
	}
	

	
	@Test
	public void testuserDB_DAOreadEntireDB() {
		assertTrue(userDB.readAll() instanceof HashMap);
	}
	
//	@Test
//	public void testuserDB_DAOreadEntireDBPassintoRAM() {
//		HashMap<Integer, User> usersDB= userDB.readAll() ;
//		UserRAM_DAO<User> usersRAM = new UserRAM_DAO<User>();
//		 
//		userDB.writeUserDetail(usersDB);
//	      
//	}
//	
//	public void writeUserDetail(Collection<User> users){
//		for(User auser : users)
//			auser.writeUserDetail();
//	}
}
