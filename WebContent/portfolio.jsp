<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>User Portfolio Page</title>
<link rel="stylesheet" href="styles/application_noslide_styles.css"
	type="text/css" />
<!--[if lt IE 9]>
<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->
<!--
acceler, a free CSS web template by ZyPOP (zypopwebtemplates.com/)

Download: http://zypopwebtemplates.com/

License: Creative Commons Attribution
//-->


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

						<li><a href="portfolio">Portfolio</a></li>
					</ul>

				</nav>
			</div>

			<div class="clear"></div>


		</header>
		<div id="body" class="width">



			<section id="content" class="two-column with-right-sidebar">

				<article>

					<fieldset>
						<form name="userapplication" method="post">

							<h4>User Information:</h4>
							<br>

							<table cellspacing="0">
								<tr>
									<th>Username:</th>
									<th>${sessionScope.user.username }</th>
								</tr>
								<tr>
									<th>Password:</th>
									<th>${sessionScope.user.password }</th>
								</tr>
								<tr>
									<th>First name:</th>
									<th>${sessionScope.user.firstname }</th>
								</tr>
								<tr>
									<th>Last name:</th>
									<th>${sessionScope.user.lastname }</th>
								</tr>
								<tr>
									<th>DOB (Eg:2014-10-01):</th>
									<th>${sessionScope.user.firstname }</th>
								</tr>
								<tr>
									<th>Address:</th>
									<th>${sessionScope.user.address }</th>
								</tr>

							</table>
						</form>
					</fieldset>
				</article>

				<article class="expanded">
			</section>

			<aside class="sidebar big-sidebar right-sidebar">


				<ul>
					<li>
						<h4>QuickLinks</h4>
						<ul class="blocklist">
							<li><a class="selected" href="userHome">Home Page</a></li>
							<li><a href="login">Authentication</a>
								<ul>
									<li><a href="welcome.html">Log In</a></li>
									<li><a href="noslides.html">Log Off</a></li>
								</ul></li>
							<li><a href="#">Search Trades</a></li>
							<li><a href="#">Search Stocks</a></li>
							<li><a href="#">Search User</a></li>
						</ul>
					</li>




				</ul>

			</aside>

		</div>

	</div>
</body>
</html>