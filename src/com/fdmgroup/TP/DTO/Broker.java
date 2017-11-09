package com.fdmgroup.TP.DTO;

import java.util.Collection;
import java.util.HashMap;

public class Broker extends User{
	private HashMap<Integer, Shareholder> clients;
	private HashMap<Integer, Shareholder> requestClientsList;
	private HashMap<Integer, TradeOrder> tradeRequestList;

	public Broker(int i) {
		
		this.userID = i;
	}

	public Broker() {
		
	}

	public HashMap<Integer, Shareholder> getClients() {
		return clients;
	}

	public void setClients(HashMap<Integer, Shareholder> clients) {
		this.clients = clients;
	}

	public HashMap<Integer, Shareholder> getRequestClientsList() {
		return requestClientsList;
	}

	public void setRequestClientsList(
			HashMap<Integer, Shareholder> requestClientsList) {
		this.requestClientsList = requestClientsList;
	}

	public HashMap<Integer, TradeOrder> getTradeRequestList() {
		return tradeRequestList;
	}

	public void setTradeRequestList(HashMap<Integer, TradeOrder> tradeRequestList) {
		this.tradeRequestList = tradeRequestList;
	}

	
	
	

}
