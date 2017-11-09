package com.fdmgroup.testDB_DAO;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import java.util.Collection;
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

public class TestTradeOrderDB {

	private User mockUser1, mockUser2, mockUser3, mockUser4, mockUser5;
	private UserDB_DAO<User> userDB;
	private Collection<Permission> permissions1, permissions2, permissions3;
	private Permission permission;
	private TradeOrder mockTradeOrder1, mockTradeOrder2, mockTradeOrder3, mockTrade6;
	private TradeOrderDB_DAO<TradeOrder> tradeDB;
	private StockDB_DAO<Stock> stockDB;
	private Stock mockStock4;
	
	
	@Before
	public void setUp() throws Exception {
		userDB = new UserDB_DAO<User>();
		tradeDB = new TradeOrderDB_DAO<TradeOrder>();
		stockDB = new StockDB_DAO<Stock>();
		permissions1 = new HashSet<Permission>();
		permissions2 = new HashSet<Permission>();
		permissions3 = new HashSet<Permission>();
		
		permissions1.add(permission.ADMIN); permissions1.add(permission.BROKER);permissions1.add(permission.SHAREHOLDER);
		permissions2.add(permission.ADMIN); permissions2.add(permission.BROKER);
		permissions3.add(permission.SHAREHOLDER);
		
		mockUser4 = mock(User.class);
		mockUser4 = new User(4, "James4username", "li4password", permissions1, "Jame4", "li4", "11-AUG-80", "4 Grand St, New York", false);
		
		mockTrade6 = mock(TradeOrder.class);
		mockTrade6 = new TradeOrder(6,3, "7-Oct-2014",   84000,    2196768,      7,        3,            2,              1, true, 0.10); 
		
		mockTradeOrder1 = new TradeOrder(1, 1, 4000, 200300, 7, 0, 3, 0,  0.05, false, false, null);
		mockTradeOrder2 = new TradeOrder(2, 1, 4000, 400600, 7, 0, 3, 0,  0.05, true, true, null);
		mockTradeOrder3 = new TradeOrder(1, 1, 8000, 400600, 7, 0, 3, 0,  0.05, true, true, null);
		
		
		mockStock4 = new Stock(4, "QQ", "Tencent", 35, 1586414, 154666);
	}

	@Test
	public void testtradeOrderDB_DAOcreate() {
		assertTrue(tradeDB.create(mockTradeOrder2));
		tradeDB.delete(mockTrade6);
	}
	
	@Test
	public void testtradeOrderDB_DAOread() {
		assertTrue(tradeDB.read(1).getPriceTotal()==200300);
		assertTrue(!tradeDB.read(1).isBuy());
		assertTrue(tradeDB.read(1).isActive());
	}
	
	@Test
	public void testtradeOrderDB_DAOreadEntireDB() {
		assertTrue(tradeDB.readAll().get(1).getPriceTotal()==200300);
		
	}
	
	@Test
	public void testtradeOrderDB_DAOupdate() {
		assertTrue(tradeDB.update(mockTradeOrder3));
		assertTrue(tradeDB.read(1).getVolume()==8000);
		tradeDB.update(mockTradeOrder1);
	}
	
	@Test
	public void testtradeOrderDB_DAOupdate1() {
		
	
		assertTrue(tradeDB.update(mockTradeOrder1));
	
	
	}
	
	
	
	@Test
	public void testtradeOrderDB_DAOdelete() {
		assertTrue(tradeDB.delete(mockTradeOrder2));
		
	}
	

}
