<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/fontawesome.min.css">
<link rel="stylesheet" href="assets/css/style.css">

<%
String loggedInUsername = (String) session.getAttribute("LOGGED_IN_USER");
%>

<header>
	<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
		<a class="navbar-brand" href="#">MusicApp</a>
		<button class="navbar-toggler d-lg-none" type="button"
			data-toggle="collapse" data-target="#collapsibleNavId"
			aria-controls="collapsibleNavId" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavId">
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<li class="nav-item active"><a class="nav-link"
					href="index.jsp">Home <span class="sr-only">(current)</span></a></li>
			</ul>
			<ul class="navbar-nav ml-auto mt-2 mt-lg-0">
				<%
				if (loggedInUsername == null) {
				%>
				<li class="nav-item active"><a class="nav-link"
					href="Login.jsp">Login</a></li>
				<li class="nav-item"><a class="nav-link"
					href="Registration.jsp">Register</a>
				<li class="nav-item"><a class="nav-link" href="AdminLogin.jsp">Admin</a>
					<%
					} else {
					%>
				<li class="nav-item"><a class="nav-link" href="Language.jsp">Search
						Song By Language</a></li>
				<li class="nav-item"><a class="nav-link" href="SearchSong.jsp">Search
						Song/Create Playlist</a></li>
				<li class="nav-item"><a class="nav-link"
					href="/app/PlaylistServlet">My Playlist</a> <%
 }
 %> <%
 if (loggedInUsername != null) {
 %>
				<li class="nav-item active"><a class="nav-link">Welcome <%=loggedInUsername%></a></li>
				<li class="nav-item"><a class="nav-link" href="LogoutServlet">Logout</a></li>
				<%
				}
				%>
			</ul>

		</div>
	</nav>
</header>
