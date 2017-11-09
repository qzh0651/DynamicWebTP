<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Home</title>
<link rel="stylesheet" href="styles/application_noslide_styles.css"
	type="text/css" />
<!--[if lt IE 9]>
<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->

<script>
function getPriceTotal(){
	var x = document.getElementById("stockID").value;
	var y = document.getElementById("")
	
	if(x=1){
		return 
	}
}
</script>
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

						
							<li><a class="has_submenu" href="#">shareholder</a>
								<ul>
									<li><a href="#">View available shares for sale</a></li>
									<li><a href="#">Request to buy shares</a></li>
									<li><a href="#">Request to sell own shares</a></li>
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
					<h4>Available Stocks For Sale</h4>
						<table cellspacing="0">
		                <tr>
		                    <th>ID</th>
							<th>Symbol</th>
							<th>Company Name</th>
		                    <th>Unit Price</th>
							<th>Unowned Shares</th>	          
		                </tr>
		                
		                <c:forEach var="stock" items="${ sessionScope.stocks}">
		                <tr>
		                    <td>${ stock.value.dtoID }</td>
							<td>${ stock.value.symbol }</td>
		                    <td>${ stock.value.companyName }</td>
		                    <td>${ stock.value.unitPrice }</td>
							<td>${ stock.value.unownedShares }</td>					
		                </tr>
		                </c:forEach>
                

           			</table>

				</article>
				
				<article>
					<h4>Trading Area</h4>
					<fieldSet>
					<form name="shareholderBuyForm" action="shareholderBuyOrder" method="post">
					<table cellspacing="0">
					<tr>
						<th>Stock Symbol:</th> 
						<th>
							<select id="stockID" name="stockID">
							<c:forEach var="stock" items="${sessionScope.stocks }">
								<option value="${stock.value.dtoID}">      ${stock.value.symbol}   </option>
							</c:forEach>
							</select>
						</th>
					</tr>
					<tr>
						<th>Volume:</th> <th><input type="number" name="shares" required></th>
					</tr>
					<tr>
						<th>  </th> <th><input type="submit" name="buy" value="Buy" id="buy" ></th>
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
							
							
							<li><a href="login">Shareholder Trade Activity</a>
								<ul>
									<li><a href="page.html">View available shares for sale</a></li>
									<li><a href="noslides.html">Request to buy shares</a></li>
									<li><a href="noslides.html">Request to sell own shares</a></li>
									
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