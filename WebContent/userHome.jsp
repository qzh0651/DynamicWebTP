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

						<c:if test="${sessionScope.admin}">
							<li><a class="has_submenu" href="adminHome">Administer</a>
								<ul>
									<li><a href="#">User Managemenet</a></li>
									<li><a href="#">User Issue Tracking</a></li>
									<li><a href="#">Logging</a></li>
								</ul></li>
						</c:if>
						<c:if test="${sessionScope.broker}">
							<li><a href="brokerTrade">Broker</a>
								<ul>
									<li><a href="#">View available trade order</a></li>
									<li><a href="#">Match and complete trade order</a></li>
									<li><a href="#">View past trades</a></li>
									<li><a href="#">Define custom commission level</a></li>
								</ul></li>
						</c:if>
						<c:if test="${sessionScope.shareholder}">
							<li><a class="has_submenu" href="shareholderTrade">shareholder</a>
								<ul>
									<li><a href="#">View available shares for sale</a></li>
									<li><a href="#">Request to buy shares</a></li>
									<li><a href="#">Request to sell own shares</a></li>
								</ul></li>
						</c:if>
						<li><a href="portfolio">Portfolio</a></li>
					</ul>

				</nav>
			</div>
		</header>

		<div id="body" class="width">
			<section id="content" class="two-column with-right-sidebar">

				<article>

					<h3>Welcome: ${ sessionScope.name }</h3>



				</article>

			</section>

			<aside class="sidebar big-sidebar right-sidebar">
				<ul>
					<li>
						<h4>QuickLinks</h4>
						<ul class="blocklist">
							<li><a class="selected" href="userHome">Home Page</a></li>
							<li><a href="">Log Off</a>
							<li><a href="three-column.html">Search Trades</a></li>
							<li><a href="#">Search Stocks</a></li>
							
							<c:if test="${sessionScope.admin}">
							<li><a href="login">User Management</a>
								<ul>
									<li><a href="page.html">Add User</a></li>
									<li><a href="noslides.html">Delete User</a></li>
									<li><a href="noslides.html">Update User Detail</a></li>
									<li><a href="noslides.html">Ban User Temporarily</a></li>
								</ul></li>
							<li><a href="#">Search User</a></li>
							</c:if>
							
							<c:if test="${sessionScope.broker}">	
							<li><a href="login">Broker Trade Activity</a>
								<ul>
									<li><a href="page.html">View available trade order</a></li>
									<li><a href="noslides.html">Match and complete order request</a></li>
									<li><a href="noslides.html">View past trades</a></li>
									<li><a href="noslides.html">Define custom commission level</a></li>
								</ul></li>
							</c:if>
							
							<c:if test="${sessionScope.shareholder}">
							<li><a href="login">Shareholder Trade Activity</a>
								<ul>
									<li><a href="page.html">View available shares for sale</a></li>
									<li><a href="noslides.html">Request to buy shares</a></li>
									<li><a href="noslides.html">Request to sell own shares</a></li>
									
								</ul></li>
							</c:if>
			
						</ul>
					</li>

				</ul>

			</aside>

		</div>
		<footer> </footer>
	</div>
</body>
</html>