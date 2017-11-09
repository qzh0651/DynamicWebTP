package com.fdmgroup.TP.DAO;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.fdmgroup.TP.DTO.DTO;


public class RAM_DAO<T extends DTO> implements IStorage<T>{
	static Logger log = 
			Logger.getLogger(RAM_DAO.class);	
	private HashMap<Integer, T> dtos = new HashMap<Integer, T>();

	public boolean create(T dto) {
		dtos.put(dto.getDtoID(), dto);
		return false;
	}

	public T read(int dtoID) {
		
		return dtos.get(dtoID);
	}

	public boolean update(T dtoNew) {
		if(dtos.get(dtoNew.getDtoID())!=null){
			dtos.remove(dtoNew.getDtoID());
			dtos.put(dtoNew.getDtoID(), dtoNew);
			return true;
		}
		return false;
	}

	public boolean delete(T dto) {
		if(dtos.get(dto.getDtoID())!=null){
			dtos.remove(dto.getDtoID());
		}
		return false;
	}
	
	public HashMap<Integer, T> readAll(){
		return dtos;
	}

	

	



}
