package com.fdmgroup.TP.DAO;

import java.util.HashMap;

import com.fdmgroup.TP.DTO.DTO;

public class TradeOrderRAM_DAO<TradeOrder extends DTO> implements IStorage<TradeOrder>  {
private HashMap<Integer, TradeOrder> dtos = new HashMap<Integer, TradeOrder>();
	
	public boolean create(TradeOrder dto) {
		dtos.put(dto.getDtoID(), dto);
		return false;
	}

	public TradeOrder read(int dtoID) {
		return dtos.get(dtoID);
	}

	public boolean update(TradeOrder dtoNew) {
		if(dtos.get(dtoNew.getDtoID())!=null){
			dtos.remove(dtoNew.getDtoID());
			dtos.put(dtoNew.getDtoID(), dtoNew);
			return true;
		}
		return false;
	}

	public boolean delete(TradeOrder dto) {
		if(dtos.get(dto.getDtoID())!=null){
			dtos.remove(dto.getDtoID());
		}
		return false;
	}

	public HashMap<Integer, TradeOrder> readAll() {
		
		return dtos;
	}


}
