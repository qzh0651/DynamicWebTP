package com.fdmgroup.servletintro;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fdmgroup.TP.DAO.StockDB_DAO;
import com.fdmgroup.TP.DAO.TradeOrderDB_DAO;
import com.fdmgroup.TP.DAO.UserDB_DAO;
import com.fdmgroup.TP.DTO.Request;
import com.fdmgroup.TP.DTO.Stock;
import com.fdmgroup.TP.DTO.TradeOrder;
import com.fdmgroup.TP.DTO.User;

/**
 * Servlet implementation class ShareholderBuyOrder
 */
public class ShareholderBuyOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDB_DAO<User> userDB;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShareholderBuyOrder() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int stockID = Integer.parseInt(request.getParameter("stockID"));
		int shares = Integer.parseInt(request.getParameter("shares"));
		
		HttpSession session = request.getSession();
		
		User user = (User) session.getAttribute("user");
		
		TradeOrder tradeOrder = new TradeOrder();
		TradeOrderDB_DAO<TradeOrder> tradeOrderDB = new TradeOrderDB_DAO<TradeOrder>();
		StockDB_DAO<Stock> stockDB = new StockDB_DAO<Stock>();
		tradeOrder.setDtoID(tradeOrderDB.readAll().size()+1);
		tradeOrder.setStockID(stockID);
		tradeOrder.setVolume(shares);
		tradeOrder.setPriceTotal(stockDB.read(stockID).getUnitPrice()*shares);
		tradeOrder.setActive(true);
		
		tradeOrderDB.create(tradeOrder);
		
		session.setAttribute("tradeOrders", tradeOrderDB.readAll());
		
		PrintWriter out = response.getWriter();  
		response.setContentType("text/html");  
		out.println("<script type=\"text/javascript\">");  
		out.println("alert('Trade Order Made Successfully!');");  
		out.println("</script>");
		
		RequestDispatcher reqDispatcher = request.getRequestDispatcher("shareholderTrade.jsp");
		reqDispatcher.include(request, response);
	}

}
