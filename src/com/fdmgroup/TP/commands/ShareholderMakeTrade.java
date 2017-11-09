package com.fdmgroup.TP.commands;

import java.util.HashMap;

import com.fdmgroup.TP.DTO.Broker;
import com.fdmgroup.TP.DTO.Shareholder;
import com.fdmgroup.TP.DTO.TradeOrder;


public class ShareholderMakeTrade<T> implements iCommand<T>{
	

	public void requestToBecomeClient(Shareholder shareholder, Broker broker){
		if(!broker.getRequestClientsList().containsValue(shareholder)){
			broker.getRequestClientsList().put(broker.getRequestClientsList().size()+1, shareholder);
		}
	}
	
	
	
	public HashMap<Integer, TradeOrder> viewAvailStockForSale(HashMap<Integer, TradeOrder> tradeList){
		HashMap<Integer, TradeOrder> activeTrade = new HashMap<Integer, TradeOrder>();
		for(Integer key : tradeList.keySet())
				if(tradeList.get(key).isActive())
					activeTrade.put(key, tradeList.get(key));
		
		
		return activeTrade;
	}
	
	
	public boolean requestBuyStock(TradeOrder tradeRequest, Broker broker, Shareholder shareholder){
		if(broker.getClients().containsKey(shareholder.getDtoID())){
		tradeRequest.setBuyerID(shareholder.getDtoID());
		tradeRequest.setBuyBrokerID(broker.getDtoID());
		tradeRequest.setActive(true);
		
		broker.getTradeRequestList().put(broker.getTradeRequestList().size()+1, tradeRequest);
		return true;
		}
		return false;
	}
	
	public boolean requestSellStock(TradeOrder tradeRequest, Broker broker, Shareholder shareholder){
		if(broker.getClients().containsKey(shareholder.getDtoID())){
			tradeRequest.setSellerID(shareholder.getDtoID());
			tradeRequest.setSellBrokerID(broker.getDtoID());
			tradeRequest.setActive(true);
			
			broker.getTradeRequestList().put(broker.getTradeRequestList().size()+1, tradeRequest);
			return true;
		}
		return false;
	}
	
	//For shareholder, they dont need to know which shareholder is selling the stock, but broker needs to know that
	public TradeOrder FilloutTradeOrderDetail(TradeOrder  request, int requestID, int stockID, int volume, double priceTotal, boolean buy){
		request.setDtoID(requestID);
		request.setStockID(stockID);
		request.setVolume(volume);
		request.setPriceTotal(priceTotal);
		return request;
	}
	
	public void requestTradeStock(Shareholder shareholder, Broker broker, TradeOrder tradeorder){
		if(broker.getClients().containsKey(shareholder) && tradeorder.isActive()){
			
			
		}else{
			System.out.println("Error: requestTradeOrder cant be completed, "+shareholder.getName()+"you are not the client of this broker "+broker.getName());
		}
	}



	public T execute() {
		
		return null;
	}



	public T requestBuy() {
		
		return null;
	}



	public T requestSell() {
		
		return null;
	}
}
