package com.fdmgroup.commands;

import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.TP.DAO.UserFactory;
import com.fdmgroup.TP.DAO.UserRAM_DAO;
import com.fdmgroup.TP.DTO.Broker;
import com.fdmgroup.TP.DTO.Permission;
import com.fdmgroup.TP.DTO.Stock;
import com.fdmgroup.TP.DTO.TradeOrder;
import com.fdmgroup.TP.DTO.User;
import com.fdmgroup.TP.commands.SwitchRole;

public class TestSwithRole {
	private User mockUser1, mockUser2, mockUser3, mockUser4;
	private HashMap<Integer, User> users;
	private HashMap<Integer, TradeOrder> tradeOrders;
	private HashMap<Integer, Stock> stocks;
	private Collection<Permission> permissions1, permissions2, permissions3;
	private Permission permission;
	private TradeOrder mockTradeOrder1;
	private UserFactory userFactory;
	private Stock mockStock1;
	private SwitchRole<Broker> sRole;
	private UserRAM_DAO<User> daoUser;


	
	@Before
	public void setUp() throws Exception {
		permissions1 = new HashSet<Permission>();
		permissions2 = new HashSet<Permission>();
		permissions3 = new HashSet<Permission>();
		sRole = new SwitchRole<Broker>();
		daoUser = new UserRAM_DAO<User>();
		
		permissions1.add(permission.ADMIN); permissions1.add(permission.BROKER);permissions1.add(permission.SHAREHOLDER);
		permissions2.add(permission.ADMIN); permissions2.add(permission.BROKER);
		permissions3.add(permission.SHAREHOLDER);

		mockUser1 = new User(1, "James1", "li1's password", permissions1, false);
		mockUser2 = new User(2, "James2", "li2's password", permissions2, false);
		mockUser3 = new User(3, "James3", "li3's password", permissions3, false);
		
		daoUser.create(mockUser1);
		daoUser.create(mockUser2);
		daoUser.create(mockUser3);
		
	}
	@Test
	public void testSwitchRole() {
		assertTrue(sRole.switchRole(mockUser1, Permission.BROKER) instanceof Broker);
		
	}

}
