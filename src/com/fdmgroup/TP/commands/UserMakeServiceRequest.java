package com.fdmgroup.TP.commands;

import com.fdmgroup.TP.DTO.Request;
import com.fdmgroup.TP.DTO.User;

public class UserMakeServiceRequest {

	private Request request;
	public boolean userRquestResetPassword(User user, User admin){
		
		request.setRequestID(admin.getRequests().size()+1);
		request.setRequestType("password reset");
		
		
		return false;
		
	}
}
