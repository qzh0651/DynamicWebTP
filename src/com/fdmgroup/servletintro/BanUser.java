package com.fdmgroup.servletintro;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fdmgroup.TP.DAO.TradeOrderDB_DAO;
import com.fdmgroup.TP.DAO.UserDB_DAO;
import com.fdmgroup.TP.DTO.TradeOrder;
import com.fdmgroup.TP.DTO.User;

/**
 * Servlet implementation class BanUser
 */
public class BanUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BanUser() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userID = Integer.parseInt(request.getParameter("userID"));
		String ban = request.getParameter("ban");
		String unban = request.getParameter("unban");
		
		HttpSession session = request.getSession();
		
		UserDB_DAO<User> userDB = new UserDB_DAO<User>();
		
		User user = new User();
		user = userDB.read(userID);
		if(ban!=null && ban.equals("ban"))
			user.setBan(true);
		else if(unban!=null && unban.equals("unban"))
			user.setBan(false);
		
		userDB.update(user);
		
		session.setAttribute("users", userDB.readAll());
	
		PrintWriter out = response.getWriter();  
		response.setContentType("text/html");  
		out.println("<script type=\"text/javascript\">");
		if(ban!=null && ban.equals("ban"))
			out.println("alert('Ban user successfully');"); 
		else if(unban!=null && unban.equals("unban"))
			out.println("alert('Unban user successfully');"); 
		out.println("</script>");
		
		RequestDispatcher reqDispatcher = request.getRequestDispatcher("adminHome.jsp");
		reqDispatcher.include(request, response);
	}

}
