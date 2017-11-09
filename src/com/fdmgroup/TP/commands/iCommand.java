package com.fdmgroup.TP.commands;

public interface iCommand<T> {
	
	public T execute();
	public T requestBuy();
	public T requestSell();
}
