package com.fdmgroup.servletintro;

import java.io.IOException;
import java.util.HashSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdmgroup.TP.DAO.UserDB_DAO;
import com.fdmgroup.TP.DTO.Permission;
import com.fdmgroup.TP.DTO.User;
import com.fdmgroup.TP.commands.Log;
import com.fdmgroup.TP.commands.UserManagement;

/**
 * Servlet implementation class NewUser
 */
public class NewUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Log log=new Log();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewUser() {
        super();
        // TODO Auto-generated constructor stub
    }



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.logger("trace", "we are in NewUser Servlet");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String DOB = request.getParameter("DOB");
		String address = request.getParameter("address");
		String broker = request.getParameter("broker");
		String shareholder = request.getParameter("shareholder");
		
//		System.out.println("broker:"+broker+".");
//		System.out.println("shareholder:"+shareholder+".");
//		System.out.println("DOB:"+DOB);
		
		
		User userTemp = new User();
		UserManagement adminUM = new UserManagement();
		adminUM.FillOutUserInfor(userTemp, firstname, lastname, DOB, address, username, password);
		
		UserDB_DAO<User> userDB = new UserDB_DAO<User>();
		HashSet<Permission> permissions = new HashSet<Permission>();
		if(broker!=null)
			permissions.add(Permission.BROKER);
		if(shareholder!=null)
			permissions.add(Permission.SHAREHOLDER);
		
		userTemp.setPermission(permissions);
		userDB.create(userTemp);
		
		response.sendRedirect("welcome.html");
	}

}
