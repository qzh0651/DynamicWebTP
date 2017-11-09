package com.fdmgroup.TP.DTO;

public class TradeOrder implements DTO{
	private int tradeID;
	private int stockID;
	private int volume;
	private double priceTotal;
	private int buyerID;
	private int sellerID;
	private int buyBrokerID;
	private int sellBrokerID;
	private double commissionRate;
	private boolean buy;
	private boolean active;
	private String transaction_time;
	
	
	
	
	public TradeOrder(int tradeID, int stockID, int volume, double priceTotal,
			int buyerID, int sellerID, int buyBrokerID, int sellBrokerID,
			double commissionRate, boolean buy, boolean active,
			String transaction_time) {
		super();
		this.tradeID = tradeID;
		this.stockID = stockID;
		this.volume = volume;
		this.priceTotal = priceTotal;
		this.buyerID = buyerID;
		this.sellerID = sellerID;
		this.buyBrokerID = buyBrokerID;
		this.sellBrokerID = sellBrokerID;
		this.commissionRate = commissionRate;
		this.buy = buy;
		this.active = active;
		this.transaction_time = transaction_time;
	}

	private User buyer;
	private User seller;
	private String symbol;
	//trade request
	public TradeOrder(int tradeID, int stockID, String transaction_time,
			int volume, double priceTotal, int buyerID, int sellerID,
			int buyBrokerID, int sellBrokerID, boolean active,
			double commissionRate) {
		super();
		this.tradeID = tradeID;
		this.stockID = stockID;
		this.transaction_time = transaction_time;
		this.volume = volume;
		this.priceTotal = priceTotal;
		this.buyerID = buyerID;
		this.sellerID = sellerID;
		this.buyBrokerID = buyBrokerID;
		this.sellBrokerID = sellBrokerID;
		this.active = active;
		this.commissionRate = commissionRate;
	}

	//trade
	public TradeOrder(int tradeID, int stockID, int volume, double priceTotal,
			int buyerID, int sellerID, int buyBrokerID, int sellBrokerID,
			boolean active, double commissionRate) {
		super();
		this.tradeID = tradeID;
		this.stockID = stockID;
		this.volume = volume;
		this.priceTotal = priceTotal;
		this.buyerID = buyerID;
		this.sellerID = sellerID;
		this.buyBrokerID = buyBrokerID;
		this.sellBrokerID = sellBrokerID;
		this.active = active;
		this.commissionRate = commissionRate;
	}

	public String getTransaction_time() {
		return transaction_time;
	}

	public void setTransaction_time(String transaction_time) {
		this.transaction_time = transaction_time;
	}

	public int getBuyerID() {
		return buyerID;
	}

	public void setBuyerID(int buyerID) {
		this.buyerID = buyerID;
	}

	public int getSellerID() {
		return sellerID;
	}

	public void setSellerID(int sellerID) {
		this.sellerID = sellerID;
	}

	public int getBuyBrokerID() {
		return buyBrokerID;
	}

	public void setBuyBrokerID(int buyBrokerID) {
		this.buyBrokerID = buyBrokerID;
	}

	public int getSellBrokerID() {
		return sellBrokerID;
	}

	public void setSellBrokerID(int sellBrokerID) {
		this.sellBrokerID = sellBrokerID;
	}


	public TradeOrder(int tradeID, int stockID, String symbol,
			double priceTotal, int volume, boolean active,
			double commissionRate, boolean buy, User buyer, User seller) {
		super();
		this.tradeID = tradeID;
		this.stockID = stockID;
		this.symbol = symbol;
		this.priceTotal = priceTotal;
		this.volume = volume;
		this.active = active;
		this.commissionRate = commissionRate;
		this.buy = buy;
		this.buyer = buyer;
		this.seller = seller;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public User getBuyer() {
		return buyer;
	}

	public void setBuyer(User buyer) {
		this.buyer = buyer;
	}

	public User getSeller() {
		return seller;
	}

	public void setSeller(User seller) {
		this.seller = seller;
	}

	public boolean isBuy() {
		return buy;
	}

	public void setBuy(boolean buy) {
		this.buy = buy;
	}

	

	public double getCommissionRate() {
		return commissionRate;
	}

	public void setCommissionRate(double commissionRate) {
		this.commissionRate = commissionRate;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean status) {
		this.active = status;
	}

	public TradeOrder(){
		
	}
	
	public TradeOrder(int tradeID, int stockID, double priceTotal, int volume){
		this.tradeID = tradeID;
		this.stockID = stockID;
		this.priceTotal = priceTotal;
		this.volume = volume;
	}
	


	//	public int getTradeID() {
//		return tradeID;
//	}
//	public void setTradeID(int tradeID) {
//		this.tradeID = tradeID;
//	}
	public int getStockID() {
		return stockID;
	}
	public void setStockID(int stockID) {
		this.stockID = stockID;
	}
	public double getPriceTotal() {
		return priceTotal;
	}
	public void setPriceTotal(double priceTotal) {
		this.priceTotal = priceTotal;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}

	public int getDtoID() {
		
		return tradeID;
	}

	public void setDtoID(int dtoID) {
		
		this.tradeID = dtoID;
	}

	
	
}
