package com.fdmgroup.TP.commands;

import com.fdmgroup.TP.DAO.IStorage;
import com.fdmgroup.TP.DTO.User;

public class Authenticator {
	private Log log= new Log();
	
	public User login(IStorage<User> userDB, String username, String password) throws NullPointerException{
		if(userDB.readAll()==null){
			log.logger("error","In database. userDB is empty.");
			return null;
		}else{
			int RAMNumUser = userDB.readAll().size();
			for(int i=1; i<RAMNumUser; i++){
				if(userDB.read(i)!=null){
					if(userDB.read(i).getUsername().equals(username)){
						if(userDB.read(i).getPassword().equals(password)){
							return userDB.read(i);
						}else{
							log.logger("error", "password incorrect");
							return null;
						}
					}
				}
			}
			log.logger("error", "username not exist.");
			return null;
		}
		
	}
	
	public User reset(IStorage<User> userDB, String username, String address) throws NullPointerException{
		if(userDB.readAll()==null){
			log.logger("error","In database. userDB is empty.");
			return null;
		}else{
			int RAMNumUser = userDB.readAll().size();
			for(int i=1; i<RAMNumUser; i++){
				if(userDB.read(i)!=null){
					if(userDB.read(i).getUsername().equals(username)){
						if(userDB.read(i).getAddress().equals(address)){
							return userDB.read(i);
						}else{
							log.logger("error", "address incorrect");
							return null;
						}
					}
				}
			}
			log.logger("error", "username not exist.");
			return null;
		}
		
	}
	
	


}
