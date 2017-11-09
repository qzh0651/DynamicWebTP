package com.fdmgroup.TP.DTO;

public class Request {
	public enum Status{
		OUTSTANDING, INPROGRESS, COMPLETED,
	}
	private int requestID;
	private	String requestType;
	private User handler;
	private String info;
	private Status status;
	
	
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public int getRequestID() {
		return requestID;
	}
	public void setRequestID(int requestID) {
		this.requestID = requestID;
	}
	public String getRequestType() {
		return requestType;
	}
	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public User getHandler() {
		return handler;
	}
	public void setHandler(User handler) {
		this.handler = handler;
	}
}
