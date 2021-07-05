
<!DOCTYPE html>
<html lang="en">

<%
String loggedInUsername = (String) session.getAttribute("LOGGED_IN_USER");
%>
<header>
	<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
		<a class="navbar-brand" href="#">DJMusicz</a>
		<button class="navbar-toggler d-lg-none" type="button"
			data-toggle="collapse" data-target="#collapsibleNavId"
			aria-controls="collapsibleNavId" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<%
		if (loggedInUsername == null) {
		%>
		<ul class="navbar-nav ml-auto mt-2 mt-lg-0">
			<li class="nav-item active"><a class="nav-link" href="Login.jsp">Login</a></li>
			<li class="nav-item"><a class="nav-link" href="Registration.jsp">Register</a>
			<li class="nav-item"><a class="nav-link" href="AdminLogin.jsp">Admin</a>
			</li>
		</ul>
		<%
		} else {
		%>
		<ul class="navbar-nav ml-auto mt-2 mt-lg-0">
			<li class="nav-item active"><a class="nav-link">Welcome <em style="color:#1affa3"><%=loggedInUsername%></em></a></li>
			<li class="nav-item"><a class="nav-link" href="LogoutServlet">Logout</a>
			</li>
		</ul>
		<%
		}
		%>
	</nav>
</header>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>MusicApp</title>
<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/fontawesome.min.css">
<link rel="stylesheet" href="assets/css/style.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<style>
/* 
body {
	font-family: "Lato", sans-serif;
} */
header {
	margin-left: 160px;
}
/* sidebar css */
.sidebar {
	height: 100%;
	width: 160px;
	position: fixed;
	z-index: 1;
	top: 0;
	left: 0;
	background-color: black;
	overflow-x: hidden;
	padding-top: 16px;
}

.sidebar a {
	padding: 6px 8px 6px 16px;
	text-decoration: none;
	font-size: 20px;
	color: white;
	display: block;
}

.sidebar a:hover {
	color: #1affa3;
}

.main {
	background-color: #1affa3;
	margin-left: 160px;
	padding: 0px 10px;
	font-size: 20px;
	padding: 70px 0;
}

@media screen and (max-height: 450px) {
	.sidebar {
		padding-top: 15px;
	}
	.sidebar a {
		font-size: 18px;
	}
}

.center {
	text-align: center;
	padding: 70px 0;
}
/* Grid css*/
.grid-container {
	display: grid;
	height: 300px;
	grid-template-columns: 200px 200px 200px 200px;
	grid-template-rows: 250px 250px 250px 250px;
	gap: 20px 50px;
}

.grid-container  div {
	border: 1px solid black;
	background-color: black;
	display: inline block;
}

.heading-font-size {
	font-size: 40px;
	font-weight: bold;
}

/*user name*/
.user {
	float: right;
	margin: 7px;
}
</style>
<body>
	<div class="sidebar">
		<a href="HomeServlet"><em class="fa fa-fw fa-home"></em> Home</a> <br />
		<a href="SearchSong.jsp"><em class="fa fa-fw fa-search"></em>
			Search</a><br /> <a href="PlaylistServlet"><em
			class="fa fa-fw fa-headphones"></em> Playlist</a><br /> <a
			href="Language.jsp"><em class="fa fa-fw fa-language"></em>
			Language</a><br /> <a href="AllMoviesList.jsp"><em
			class="fa fa-fw fa-film"></em> Movies</a><br /> <a
			href="MusicGenreServlet?genreId=4"><em class="fa fa-fw fa-child"></em>
			Kids</a><br />

	</div>


</body>

</head>
</html>

