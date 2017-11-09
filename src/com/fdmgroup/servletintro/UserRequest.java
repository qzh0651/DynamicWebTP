package com.fdmgroup.servletintro;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fdmgroup.TP.DAO.StockDB_DAO;
import com.fdmgroup.TP.DAO.TradeOrderDB_DAO;
import com.fdmgroup.TP.DAO.UserDB_DAO;
import com.fdmgroup.TP.DTO.Permission;
import com.fdmgroup.TP.DTO.Stock;
import com.fdmgroup.TP.DTO.TradeOrder;
import com.fdmgroup.TP.DTO.User;
import com.fdmgroup.TP.commands.Authenticator;

/**
 * Servlet implementation class UserRequest
 */
public class UserRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRequest() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String address = request.getParameter("address");
		
		Authenticator login = new Authenticator();
		UserDB_DAO<User> userDB = new UserDB_DAO<User>();
		
		if(login.reset(userDB, username, address)!=null){
			System.out.println("user is returned");
			
			User user = login.reset(userDB, username, address);
			user.setPassword(user.getLastname());
			userDB.update(user);
			
			PrintWriter out = response.getWriter();  
			response.setContentType("text/html");  
			out.println("<script type=\"text/javascript\">");  
			out.println("alert('Password reset successfully!');");  
			out.println("</script>");
			
			response.sendRedirect("");
		}
		else{
			PrintWriter out = response.getWriter();  
			response.setContentType("text/html");  
			out.println("<script type=\"text/javascript\">");  
			out.println("alert('username or address incorrect! Go back to retry.');");  
			out.println("</script>");
			
		}
		
		
	}

}
