package com.fdmgroup.TP.commands;

import java.util.HashMap;

import com.fdmgroup.TP.DTO.Shareholder;
import com.fdmgroup.TP.DTO.Stock;

public class ShareholderViewPortfolio {
	
	//view portfolio will list all the stocks that shareholder owned
	//another information like monitor brokers performance and commission rates are also anticipated
	public HashMap<Integer, Stock> viewPortfolio(Shareholder shareholder){
		return shareholder.getStockOwned();
		
		
	
	}
}
