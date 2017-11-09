package com.fdmgroup.TP.commands;

import java.util.HashSet;
import java.util.Iterator;

import com.fdmgroup.TP.DTO.Permission;
import com.fdmgroup.TP.DTO.User;

public class SwitchRole <T extends User> {

	private User userTemp;

	
	public T switchRole(User user, Permission role){
		HashSet<Permission> permissions = (HashSet<Permission>) user.getPermission();
		userTemp = user;
		switch(role){
		case ADMIN: 
				Iterator<Permission> itr1 = permissions.iterator();
				while(itr1.hasNext()){
					if(itr1.next().equals(Permission.ADMIN))
						return (T) userTemp;
				}
				break;		
		case BROKER:
			Iterator<Permission> itr2 = permissions.iterator();
			while(itr2.hasNext()){
				if(itr2.next().equals(Permission.BROKER))
					return (T) userTemp;
			}
			break;
		case SHAREHOLDER:
			Iterator<Permission> itr3 = permissions.iterator();
			while(itr3.hasNext()){
				if(itr3.next().equals(Permission.SHAREHOLDER))
					return (T) userTemp;
			}
			break;
		default:
			return null;
		
		}
		return null;
		
	}

}
