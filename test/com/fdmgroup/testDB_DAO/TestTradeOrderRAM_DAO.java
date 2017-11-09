package com.fdmgroup.testDB_DAO;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.TP.DAO.TradeOrderRAM_DAO;
import com.fdmgroup.TP.DAO.UserFactory;
import com.fdmgroup.TP.DAO.UserRAM_DAO;
import com.fdmgroup.TP.DTO.Permission;
import com.fdmgroup.TP.DTO.Stock;
import com.fdmgroup.TP.DTO.TradeOrder;
import com.fdmgroup.TP.DTO.User;

public class TestTradeOrderRAM_DAO {

	private User mockUser1, mockUser2, mockUser3, mockUser4;
	private HashMap<Integer, User> users;
	private HashMap<Integer, TradeOrder> tradeOrders;
	private HashMap<Integer, Stock> stocks;
	private Collection<Permission> permissions1, permissions2, permissions3;
	private Permission permission;
	private TradeOrder mockTradeOrder1;
	private UserFactory userFactory;
	private Stock mockStock1;


	
	@Before
	public void setUp() throws Exception {
		permissions1 = new HashSet<Permission>();
		permissions2 = new HashSet<Permission>();
		permissions3 = new HashSet<Permission>();
		
		permissions1.add(permission.ADMIN); permissions1.add(permission.BROKER);permissions1.add(permission.SHAREHOLDER);
		permissions2.add(permission.ADMIN); permissions2.add(permission.BROKER);
		permissions3.add(permission.SHAREHOLDER);

		mockUser1 = mock(User.class);
		when(mockUser1.getDtoID()).thenReturn(1);
		when(mockUser1.getUsername()).thenReturn("James1's username");
		when(mockUser1.getPassword()).thenReturn("li1's password");
		when(mockUser1.getPermission()).thenReturn(permissions1);
		
		mockUser2 = mock(User.class);
		when(mockUser2.getDtoID()).thenReturn(2);
		when(mockUser2.getUsername()).thenReturn("James2's username");
		when(mockUser2.getPassword()).thenReturn("li2's password");
		when(mockUser2.getPermission()).thenReturn(permissions2);
		
		mockUser3 = mock(User.class);
		when(mockUser3.getDtoID()).thenReturn(3);
		when(mockUser3.getUsername()).thenReturn("James3's username");
		when(mockUser3.getPassword()).thenReturn("li3's password");
		when(mockUser3.getPermission()).thenReturn(permissions3);
		
		mockTradeOrder1 = mock(TradeOrder.class);
		when(mockTradeOrder1.getDtoID()).thenReturn(1);
		when(mockTradeOrder1.getStockID()).thenReturn(1);
		when(mockTradeOrder1.getSymbol()).thenReturn("Apple");
		when(mockTradeOrder1.getPriceTotal()).thenReturn(10015.00);
		when(mockTradeOrder1.getVolume()).thenReturn(100);
		when(mockTradeOrder1.isActive()).thenReturn(true);
		when(mockTradeOrder1.isBuy()).thenReturn(true);
		when(mockTradeOrder1.getBuyer()).thenReturn(mockUser3);
		when(mockTradeOrder1.getSeller()).thenReturn(mockUser1);
		
		mockStock1 = mock(Stock.class);
		
	}
	

	@Test
	public void testCreateDTO_TradeOrder(){
		TradeOrderRAM_DAO<TradeOrder> crud = new TradeOrderRAM_DAO<TradeOrder>();
		crud.create(mockTradeOrder1);
		assertTrue(crud.read(1).equals(mockTradeOrder1));
	}
	
//	@Test
//	public void testCreateDTO_Stock(){
//		CRUD<Stock> crud1 = new CRUD<Stock>();
//		Stock baba = new Stock();
//		crud1.create(stockDatabase, baba);
//		assertTrue(stockDatabase.contains(baba));
//	}	

//	
//	@Test 
//	public void testReadDTO_Stock(){
//		CRUD<Stock> crud1 = new CRUD<Stock>();
//		Stock readStock = crud1.read(stockDatabase, 1);
//		assertTrue(readStock.getCompanyName().equals("Apple"));
//	}
//	
	@Test 
	public void testReadDTO_TradeOrder(){
		TradeOrderRAM_DAO<TradeOrder> crud = new TradeOrderRAM_DAO<TradeOrder>();
		crud.create(mockTradeOrder1);
		TradeOrder readTradeOrder = crud.read(1);
		assertTrue(readTradeOrder.getPriceTotal()==10015);
	}
	
	@Test
	public void testUpdateDTO_TradeOrder(){
		TradeOrder updatedOrder = new TradeOrder(1, 1, "APPL", 1001.5, 10, true, 0.05, true, mockUser3, mockUser1);
		TradeOrderRAM_DAO<TradeOrder> crud = new TradeOrderRAM_DAO<TradeOrder>();
		crud.create(mockTradeOrder1);
		crud.update(updatedOrder);
		assertTrue(crud.read(1).getPriceTotal()==1001.5);
	
	}
	
	@Test 
	public void testDeleteDTO_User(){
		UserRAM_DAO<User> crud = new UserRAM_DAO<User>();
		crud.create(mockUser3);
		crud.delete(mockUser3);
		assertTrue(crud.read(3)==null);
	}
		
}
