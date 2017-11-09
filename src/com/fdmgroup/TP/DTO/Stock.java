package com.fdmgroup.TP.DTO;

public class Stock implements DTO{

	private int stockID;
	private String symbol;
	private String companyName;
	private double unitPrice;
	private int volume;
	private int unownedShares;
	private boolean active;

	
	
	
	public Stock(int stockID, String symbol, String companyName,
			double unitPrice, int volume, int unownedShares, boolean active
			) {
		super();
		this.stockID = stockID;
		this.symbol = symbol;
		this.companyName = companyName;
		this.unitPrice = unitPrice;
		this.volume = volume;
		this.unownedShares = unownedShares;
		this.active = active;
		
	}

	public Stock(int stockID, String symbol, String companyName,
			double unitPrice, int volume, int unownedShares) {
		super();
		this.stockID = stockID;
		this.symbol = symbol;
		this.companyName = companyName;
		this.unitPrice = unitPrice;
		this.volume = volume;
		this.unownedShares = unownedShares;
	}

	public Stock(int stockID, String symbol, String companyName,
			double unitPrice) {
		super();
		this.stockID = stockID;
		this.symbol = symbol;
		this.companyName = companyName;
		this.unitPrice = unitPrice;
	}
	
public Stock() {
		
	}
	
	private double priceTotal;
	
	
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getUnownedShares() {
	return unownedShares;
	}

	public void setUnownedShares(int unownedShares) {
	this.unownedShares = unownedShares;
	}

	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public double getPriceTotal() {
		return unitPrice * volume;
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
	
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public int getDtoID() {
		
		return stockID;
	}
	public void setDtoID(int dtoID) {
		
		this.stockID = dtoID;
	}
}
