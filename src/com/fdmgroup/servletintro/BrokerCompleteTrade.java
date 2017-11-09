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
import com.fdmgroup.TP.DTO.TradeOrder;

/**
 * Servlet implementation class BrokerCompleteTrade
 */
public class BrokerCompleteTrade extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BrokerCompleteTrade() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int tradeOrderID = Integer.parseInt(request.getParameter("tradeOrderID"));
		
		System.out.println(tradeOrderID);
		HttpSession session = request.getSession();
		
		TradeOrderDB_DAO<TradeOrder> tradeOrderDB = new TradeOrderDB_DAO<TradeOrder>();
		
		TradeOrder tradeOrder = new TradeOrder();
		tradeOrder = tradeOrderDB.read(tradeOrderID);
		tradeOrder.setActive(false);
		
		tradeOrderDB.update(tradeOrder);
		
		session.setAttribute("tradeOrders", tradeOrderDB.readAll());
		
		PrintWriter out = response.getWriter();  
		response.setContentType("text/html");  
		out.println("<script type=\"text/javascript\">");  
		out.println("alert('Trade Order Completed successfully.');");  
		out.println("</script>");
		
		RequestDispatcher reqDispatcher = request.getRequestDispatcher("brokerTrade.jsp");
		reqDispatcher.include(request, response);
		
		
		
		
	}

}
