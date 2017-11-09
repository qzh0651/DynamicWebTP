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

public class TestStockDB {

	private User mockUser1, mockUser2, mockUser3, mockUser4, mockUser5;
	private UserDB_DAO<User> userDB;
	private Collection<Permission> permissions1, permissions2, permissions3;
	private Permission permission;
	private TradeOrder mockTrade6, mockTradeOrder2, mockTradeOrder3;
	private TradeOrderDB_DAO<TradeOrder> tradeDB;
	private StockDB_DAO<Stock> stockDB;
	private Stock mockStock1, mockStock4;
	
	
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
			
		mockTradeOrder2 = new TradeOrder(2, 1, 4000, 400600, 7, 0, 3, 0,  0.05, true, true, null);
		mockTradeOrder3 = new TradeOrder(1, 1, 8000, 400600, 7, 0, 3, 0,  0.05, true, true, null);
		
		mockStock1 = new Stock(1, "APPL", "Apple", 100.15,	10000000,	1515614, true);
		mockStock4 = new Stock(4, "QQ", "Tencent", 35, 1586414, 154666, true);
	}

	@Test
	public void testStockDB_DAOcreate() {
		
		assertTrue(stockDB.create(mockStock4));
		assertTrue(stockDB.read(4).getSymbol().equals("QQ"));
		assertTrue(stockDB.read(4).getCompanyName().equals("Tencent"));
		assertTrue(stockDB.read(4).getUnitPrice()==35);
		assertTrue(stockDB.read(4).getVolume()==1586414);
		assertTrue(stockDB.read(4).getUnownedShares()==154666);
		
	}
	
	@Test
	public void testStockDB_DAOread() {
		assertTrue(stockDB.read(1).getSymbol().equalsIgnoreCase("APPL"));
	}
	
	@Test
	public void testStockDB_DAOupdate() {
		Stock updateStock = new Stock(1, "APPL", "Apple", 99, 1000000, 154666);
		assertTrue(stockDB.update(updateStock));
		stockDB.update(mockStock1);
	}
	
	@Test
	public void testStockDB_DAOreadAll() {
		assertTrue(stockDB.readAll().get(1).getCompanyName().equalsIgnoreCase("Apple"));
	}
	
	@Test
	public void testStockDB_DAOdelete() {
		
		assertTrue(stockDB.delete(mockStock1));
	}

}
