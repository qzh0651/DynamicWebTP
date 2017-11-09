<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Broker Trade</title>
<link rel="stylesheet" href="styles/application_noslide_styles.css"
	type="text/css" />
<!--[if lt IE 9]>
<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->

<meta name="viewport"
	content="width=device-width, minimum-scale=1.0, maximum-scale=1.0" />
</head>
<body>
	<div id="container">

		<header>
			<div class="width">
				<h1>
					<a href="/">Trading Platform</a>
				</h1>
				<br> <br> <br> <br> <br>

				<nav>
					<ul class="sf-menu dropdown">
						<li class="selected"><a href="userHome">Home</a></li>

						<li><a href="#">Broker</a>
							<ul>
								<li><a href="#">View available trade order</a></li>
								<li><a href="#">Match and complete trade order</a></li>
								<li><a href="#">View past trades</a></li>
								<li><a href="#">Define custom commission level</a></li>
							</ul></li>

						<li><a href="portfolio">Portfolio</a></li>
					</ul>

				</nav>
			</div>
		</header>

		<div id="body" class="width">
			<section id="content" class="two-column with-right-sidebar">

				<article>

					<h3>Welcome: ${ sessionScope.name }</h3>
					<h4>Available Trade Order</h4>
						<table cellspacing="0">
		                <tr>
		                    <th>TradeOrderID</th>
							<th>Stock Symbol</th>
							<th>Volume</th>
		                    <th>PriceTotal</th>
							<th>Active</th>	          
		                </tr>
		                
		                <c:forEach var="tradeOrder" items="${ sessionScope.tradeOrders}">
		                <tr>
		                    <td>${ tradeOrder.value.dtoID }</td>
							<td><c:forEach var="stock" items="${ sessionScope.stocks }">
									<c:if test="${ stock.value.dtoID == tradeOrder.value.stockID}" >
										${ stock.value.symbol }
									</c:if>
								</c:forEach>
								</td>
		                    <td>${ tradeOrder.value.volume }</td>
		                    <td>${ tradeOrder.value.priceTotal }</td>
							<td>${ tradeOrder.value.active }</td>					
		                </tr>
		                </c:forEach>

				</article>
				
				<article>
					<h4>Match and Complete Trade Order</h4>
					<fieldSet>
					<form name="brokerTradeForm" action="brokerCompleteTrade" method="post">
					<table cellspacing="0">
					<tr>
						<th>TradeOrder ID:</th> 
						<th>
							<select id="tradeOrderID" name="tradeOrderID">
							<c:forEach var="tradeOrder" items="${sessionScope.tradeOrders }">
								<option value="${tradeOrder.value.dtoID}">      ${tradeOrder.value.dtoID}   </option>
							</c:forEach>
							</select>
						</th>
					</tr>
					
					<tr>
						<th>  </th> <th><input type="submit" name="Complete Trade" value="Submit" id="completeTrade" ></th>
					</tr>
					</table>
					</form>
					</fieldSet>			
					
				</article>

			</section>

			<aside class="sidebar big-sidebar right-sidebar">
				<ul>
					<li>
						<h4>QuickLinks</h4>
						<ul class="blocklist">
							<li><a class="selected" href="#">Home Page</a></li>
							<li><a href="">Log Off</a>
							<li><a href="three-column.html">Search Trades</a></li>
							<li><a href="#">Search Stocks</a></li>

							<li><a href="login">Broker Trade Activity</a>
								<ul>
									<li><a href="page.html">View available trade order</a></li>
									<li><a href="noslides.html">Match and complete order
											request</a></li>
									<li><a href="noslides.html">View past trades</a></li>
									<li><a href="noslides.html">Define custom commission
											level</a></li>
								</ul></li>

						</ul>
					</li>

				</ul>

			</aside>

		</div>
		<footer> </footer>
	</div>
</body>
</html>