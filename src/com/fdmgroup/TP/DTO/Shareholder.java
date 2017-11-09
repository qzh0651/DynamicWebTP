package com.fdmgroup.TP.DTO;

import java.util.Collection;
import java.util.HashMap;

public class Shareholder extends User{

	private HashMap<Integer, Stock> stockOwned;
	private Broker brokerRepresented;

	public Shareholder(int userID) {
		
		this.userID = userID;
	}

	public Shareholder() {
		
	}

	public Broker getBrokerRepresented() {
		return brokerRepresented;
	}

	public void setBrokerRepresented(Broker brokerRepresented) {
		this.brokerRepresented = brokerRepresented;
	}

	public HashMap<Integer, Stock> getStockOwned() {
		return stockOwned;
	}

	public void setStockOwned(HashMap<Integer, Stock> stockOwned) {
		this.stockOwned = stockOwned;
	}

	
}
