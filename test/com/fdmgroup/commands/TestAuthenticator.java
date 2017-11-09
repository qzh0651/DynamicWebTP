package com.fdmgroup.commands;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.TP.DAO.UserDB_DAO;
import com.fdmgroup.TP.DAO.UserFactory;
import com.fdmgroup.TP.DAO.UserRAM_DAO;
import com.fdmgroup.TP.DTO.Permission;
import com.fdmgroup.TP.DTO.Stock;
import com.fdmgroup.TP.DTO.TradeOrder;
import com.fdmgroup.TP.DTO.User;
import com.fdmgroup.TP.commands.Authenticator;
import com.fdmgroup.TP.commands.BanUserCommand;

public class TestAuthenticator {
	private Authenticator auth;
	private User mockUser1, mockUser2, mockUser3, mockUser4;
	private HashMap<Integer, User> users;
	private HashMap<Integer, TradeOrder> tradeOrders;
	private HashMap<Integer, Stock> stocks;
	private Collection<Permission> permissions1, permissions2, permissions3;
	private Permission permission;
	private TradeOrder mockTradeOrder1;
	private UserFactory userFactory;
	private Stock mockStock1;
	private BanUserCommand ban;
	private UserDB_DAO<User> daoUser;
	
	@Before
	public void setUp() throws Exception {
		permissions1 = new HashSet<Permission>();
		permissions2 = new HashSet<Permission>();
		permissions3 = new HashSet<Permission>();
		daoUser = new UserDB_DAO<User>();
		ban = new BanUserCommand(daoUser, 0);
		auth = new Authenticator();
		
		permissions1.add(permission.ADMIN); permissions1.add(permission.BROKER);permissions1.add(permission.SHAREHOLDER);
		permissions2.add(permission.ADMIN); permissions2.add(permission.BROKER);
		permissions3.add(permission.SHAREHOLDER);


	
	}


	
	@Test
	public void testLogin(){
		assertTrue(auth.login(daoUser, "James1username", "li1password").getFirstname().equals("James1"));
	}

	@Test
	public void testLoginUsernameIncorrect(){
		assertTrue(auth.login(daoUser, "sdfsfa", "li1password")==null);
	}
	
	
}
