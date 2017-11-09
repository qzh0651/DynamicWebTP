package com.fdmgroup.commands;



import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.TP.DAO.UserDB_DAO;
import com.fdmgroup.TP.DTO.User;
import com.fdmgroup.TP.commands.Authenticator;

public class TestAuthDB {

	private Authenticator auth;
	private UserDB_DAO<User> userDB;
	
	
	@Before
	public void setUp() throws Exception {
		auth = new Authenticator();
		userDB = new UserDB_DAO<User>();
		
	}

	@Test
	public void test1() {
		assertTrue(auth.login(userDB, "James1username", "li1password").getLastname().equals("li1"));
	}
	
	
	@SuppressWarnings("unchecked")
	@Test
	public void test2() {
		assertTrue(auth.login(userDB, "James1username", "sdfasd")==null);
	}
	
	@Test
	public void test3() {
		assertTrue(auth.login(userDB, "asdfaggr", "sdfasd")==null);
	}

}
