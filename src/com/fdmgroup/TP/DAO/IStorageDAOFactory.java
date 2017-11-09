package com.fdmgroup.TP.DAO;

import com.fdmgroup.TP.DTO.Stock;
import com.fdmgroup.TP.DTO.TradeOrder;
import com.fdmgroup.TP.DTO.User;

public class IStorageDAOFactory {

	public IStorage<User> getUserRAM_DAO(){
		return new UserRAM_DAO<User>();
	}
	
	public IStorage<Stock> getStockRAM_DAO(){
		return new UserRAM_DAO<Stock>();
	}
	
	public IStorage<TradeOrder> getTradeOrderRAM_DAO(){
		return new UserRAM_DAO<TradeOrder>();
	}
	
	
}
