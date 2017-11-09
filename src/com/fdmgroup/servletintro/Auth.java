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
import com.fdmgroup.TP.commands.Log;

/**
 * Servlet implementation class Auth
 */
public class Auth extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Authenticator login;
	private UserDB_DAO<User> userDB;
	private Log log = new Log();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Auth() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.logger("trace", "We are in authenticator servlet");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		username="James1username";
		password="li1password";
		
		login = new Authenticator();
		userDB = new UserDB_DAO<User>();
		
		if(login.login(userDB, username, password)!=null){
			log.logger("trace", "user is returned");
			
			HttpSession session = request.getSession();
			
			User user = login.login(userDB, username, password);
			session.setAttribute("user", user);
			session.setAttribute("admin", user.getPermission().contains(Permission.ADMIN));
			session.setAttribute("broker", user.getPermission().contains(Permission.BROKER));
			session.setAttribute("shareholder", user.getPermission().contains(Permission.SHAREHOLDER));
			String name = user.getName();
			session.setAttribute("name", name);
			
			UserDB_DAO<User> userDB = new UserDB_DAO<User>();
			HashMap<Integer, User> users = new HashMap<Integer, User>();
			users = userDB.readAll();
			session.setAttribute("users", users);
			
			StockDB_DAO<Stock> stockDB = new StockDB_DAO<Stock>();
			HashMap<Integer, Stock> stocks = new HashMap<Integer, Stock>();
			stocks = stockDB.readAll();
			session.setAttribute("stocks", stocks);
			
			TradeOrderDB_DAO<TradeOrder> tradeDB = new TradeOrderDB_DAO<TradeOrder>();
			HashMap<Integer, TradeOrder> tradeOrders = new HashMap<Integer, TradeOrder>();
			tradeOrders = tradeDB.readAll();
			session.setAttribute("tradeOrders", tradeOrders);
			
			RequestDispatcher reqDispatcher = request.getRequestDispatcher("userHome.jsp");
			reqDispatcher.forward(request, response);
		}
		else{
			PrintWriter out = response.getWriter();  
			response.setContentType("text/html");  
			out.println("<script type=\"text/javascript\">");  
			out.println("alert('username or password incorrect! Go back to retry.');");  
			out.println("</script>");
			
		}
		
	}

}
