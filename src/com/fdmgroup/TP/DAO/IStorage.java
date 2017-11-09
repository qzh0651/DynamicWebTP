package com.fdmgroup.TP.DAO;

import java.util.HashMap;

public interface IStorage<T>{
	
	public boolean create(T dto);
	
	public T read(int dtoID);

	public boolean update(T dto);

	public boolean delete(T dto);
	
	public HashMap<Integer, T> readAll();

	
}
