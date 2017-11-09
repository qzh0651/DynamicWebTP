<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Home</title>
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


						<li><a class="has_submenu" href="adminHome">Administer</a>
							<ul>
								<li><a
									href="#">User
										Managemenet</a></li>
								<li><a href="#">User Issue Tracking</a></li>
								<li><a href="#">Logging</a></li>
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
					<h4>View All Users</h4>
						<table cellspacing="0">
		                <tr>
		                    <th>ID</th>
							<th>Username</th>
							<th>Password</th>
		                    <th>Name</th>
							<th>DOB</th>	
							<th>Address</th>
							<th>Ban</th>          
		                </tr>
		                
		                <c:forEach var="user" items="${ sessionScope.users}">
		                <tr>
		                    <td>${ user.value.dtoID }</td>
							<td>${ user.value.username }</td>
		                    <td>${ user.value.password }</td>
		                    <td>${ user.value.name }</td>
							<td>${ user.value.DOB }</td>		
							<td>${ user.value.address }</td>
							<td>${ user.value.ban }</td>			
		                </tr>
		                </c:forEach>
                

           			</table>


				</article>
				
				<article>
					<h4>Ban User</h4>
					<fieldSet>
					<form name="adminBanForm" action="BanUser" method="post">
					<table cellspacing="0">
					<tr>
						<th>Username:</th> 
						<th>
							<select id="userID" name="userID">
							<c:forEach var="user" items="${sessionScope.users }">
								<option value="${user.value.dtoID}">      ${user.value.name}   </option>
							</c:forEach>
							</select>
						</th>
					</tr>
					<tr>
						<th>Ban:</th> <th><input type="checkbox" name="ban" value="ban"></th>
					</tr>
					<tr>
						<th>unBan:</th> <th><input type="checkbox" name="unban" value="unban"></th>
					</tr>
					<tr>
						<th>  </th> <th><input type="submit" name="buy" value="Submit" id="buy" ></th>
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
							<li><a class="selected" href="userHome">Home Page</a></li>
							<li><a href="login">Authentication</a>
								<ul>

									<li><a href="welcome.html">Log
											Off</a></li>
								</ul></li>
							<li><a href="three-column.html">Search Trades</a></li>
							<li><a href="#">Search Stocks</a></li>
							<li><a href="#">Search User</a></li>
						</ul>
					</li>

				</ul>

			</aside>

		</div>
		<footer> </footer>
	</div>
</body>
</html>