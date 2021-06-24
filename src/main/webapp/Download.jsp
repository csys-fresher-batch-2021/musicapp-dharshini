<%@page import="in.dharshini.dao.SongDAO"%>
<%@page import="java.util.List"%>
<%@page import="in.dharshini.service.SongService"%>
<%@page import="in.dharshini.dto.SongDTO"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>MusicApp</title>
<style>
.center {
	text-align: center;
	padding: 70px 0;
}

.c {
	font-size: 150%;
}

body {
	background-image: url("ImageUtilitiesServlet?imageName=Play-Image");
	background-repeat: no-repeat;
	background-size: 103% 200%;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">

		<form>
			<div class="center">
				<h3 style="color: darkslateblue">Enjoy Your Favourite Song
					Online</h3>
				<br />
				<%
				String songName = request.getParameter("songName");
				%>
				<audio controls autoplay>
					<source
						src="SongUtilitiesServlet?songName=<%=songName.toLowerCase()%>"
						type="audio/ogg">
					<source
						src="SongUtilitiesServlet?songName=<%=songName.toLowerCase()%>"
						type="audio/mpeg">
				</audio>
				<br />
				<br />
				<div class="c">
					<img
						src="SongImageUtilitiesServlet?imageName=<%=songName.toLowerCase()%>"
						alt="<%=songName%>" width="400" height="333"><br /> Song
					Name:
					<%=songName%>
				</div>
				<br />
			</div>
		</form>
	</main>
</body>
</html>