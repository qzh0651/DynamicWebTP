package com.fdmgroup.TP.commands;

import java.util.HashMap;

import com.fdmgroup.TP.DAO.IStorage;
import com.fdmgroup.TP.DTO.Broker;
import com.fdmgroup.TP.DTO.TradeOrder;
import com.fdmgroup.TP.DTO.User;

//invoker
public class BrokerManageTrade{
	
	public HashMap<Integer, TradeOrder> viewAvailTradeRequest(Broker broker){
		return broker.getTradeRequestList();
	}
	
	public boolean sentOutTradeRequestToOtherBroker(IStorage<User> dao, Broker broker){
		HashMap<Integer, TradeOrder> requests = broker.getTradeRequestList();
		for(Integer key : requests.keySet()){
			
		}
		
		return false;
		
	}
	
	
	
	//take order
	
	//place order
	public boolean matchAndCompleteTrade(TradeOrder request){
		return false;
		
	}
	

	
}
