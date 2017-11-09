package com.fdmgroup.TP.DAO;

import java.util.HashMap;

import com.fdmgroup.TP.DTO.DTO;
import com.fdmgroup.TP.commands.Log;

public class UserRAM_DAO<User extends DTO> implements IStorage<User> {
	
	private HashMap<Integer, User> dtos = new HashMap<Integer, User>();
	Log log = new Log();
	
	
	public boolean create(User dto) {
		if(!dtos.containsKey(dto.getDtoID())){
			dtos.put(dto.getDtoID(), dto);
			return true;
		}else{
		log.logger("error","Dto in RAM already have this dtoID");
		return false;}
	}

	
	public User read(int dtoID) {
		if(dtos.get(dtoID)!= null)
			return dtos.get(dtoID);
		else{
			log.logger("error", "Not such user in the database in RAM, with dtoID: "+dtoID);
			return null;
		}
		
	}
	
	public HashMap<Integer, User> readAll(){
		return dtos;
		
	}

	
	public boolean update(User dtoNew) {
		if(dtos.get(dtoNew.getDtoID())!=null){
			dtos.remove(dtoNew.getDtoID());
			dtos.put(dtoNew.getDtoID(), dtoNew);
			return true;
		}else{
			log.logger("error", "Database in RAM doesnt contain this user");
		return false;
		}
	}

	
	public boolean delete(User dto) {
		if(dtos.get(dto.getDtoID())!=null){
			dtos.remove(dto.getDtoID());
			return true;
		}
		log.logger("error", "Database in RAM doesnt contain this user");
		return false;
	}



}
