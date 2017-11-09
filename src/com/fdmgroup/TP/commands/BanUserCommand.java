package com.fdmgroup.TP.commands;

import com.fdmgroup.TP.DAO.IStorage;
import com.fdmgroup.TP.DTO.User;

public class BanUserCommand implements iCommand<Boolean>{
	private User userTemp;
	private IStorage<User> daoUser;
	private int userID;
	private Log log;
	
	public BanUserCommand(IStorage<User> daoUser, int userID){
		this.daoUser = daoUser;
		this.userID = userID;
	}
	
	public boolean banUserTemp() {
		
		userTemp = daoUser.read(userID);
		if(!userTemp.isBan()){			
			userTemp.setBan(true);
			daoUser.update(userTemp);
			return true;
		}else if(userTemp.isBan()){
			
			log.logger("Error", "the user is already banned.");
			return false;
		}else{
			System.out.println("undefined.");
			return false;
		}
		
	}

	public Boolean execute() {		
		return false;
	}

	public Boolean requestBuy() {
		
		return null;
	}

	public Boolean requestSell() {
		
		return null;
	}
	
}
