<%@ page import="org.owasp.encoder.Encode"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="in.dharshini.model.Song"%>
<%@page import="in.dharshini.service.SongService"%>

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
	font-size: 20px;
}

body {
	background-image: url("ImageUtilitiesServlet?imageName=Login-Image");
	background-repeat: no-repeat;
	background-size: 103% 300%;
}
</style>
</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<form action=SearchSongServlet>
			<div class="center">
				<h3 style="color: purple">Search Your Favourite Song</h3>
				<br /> <input type="text" name="song"
					placeholder="Type Song Name Correctly" autofocus /> <br /> <br />
				<button class="btn btn-secondary" type="submit">Search</button>
				<br /> <br /> <br /> <br />


				<%
				String errorMessage = request.getParameter("errorMessage");
				String songName = request.getParameter("songName");
				String encodedSongName = Encode.forHtml(songName);
				if (errorMessage != null) {
					String encodedErrorMessage = Encode.forHtml(errorMessage);
					out.println("<font color='red' size='5px'>" + encodedErrorMessage + "</font");
				} else if (songName != null) {
				%>
				<h3 style="color: darkturquoise">Result For The Search</h3>

				<div class="c">
					<label style="color: gold">Song : <%=encodedSongName%></label>
				</div>
				<br /> <a class="btn btn-primary"
					href="Download.jsp?songName=<%=encodedSongName%>" role="submit">Play</a>
				<br /> <br /> <a class="btn btn-primary"
					href="AddToPlaylist?song=<%=encodedSongName%>">Add To Playlist</a>
				<%
				}
				%>

			</div>
		</form>
	</main>
</body>
</html>