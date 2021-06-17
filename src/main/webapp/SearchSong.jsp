<%@ page import="org.owasp.encoder.Encode"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="in.dharshini.model.Song"%>
<%@page import="in.dharshini.service.SongService"%>
<%@page import="in.dharshini.dao.SearchSongDAO"%>


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
</style>
</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">

		<form action=SearchSongServlet>
			<div class="center">
				<h3>Search Your Favourite Song</h3>
				<br /> <input type="text" name="song"
					placeholder="Type Song Name Correctly" autofocus /> <br /> <br />
				<button class="btn btn-secondary" type="submit">Search</button>
				<br /> <br /> <br /> <br />

				<%
				String errorMessage = request.getParameter("errorMessage");
				if (errorMessage != null) {
					String encodedErrorMessage = Encode.forHtml(errorMessage);
					out.println(encodedErrorMessage);
				} else {
					String searchedSong = (String) request.getAttribute("searchedSong");
					String encodedString = Encode.forHtml(searchedSong);
					Song songLink = (Song) request.getAttribute("songLink");
					session.setAttribute("song",searchedSong);
					session.setAttribute("songLink",songLink);

					if (searchedSong != null) {
				%>
				<h3>Result For The Search</h3>

				<div class="c">
					Song :
					<%=encodedString%>
				</div>
				<br /> <a class="btn btn-primary"
					href=" <%=songLink.getSongLink()%>" role="button">Play</a> <br />
				<br />

				<%
				}
				%>
				<%
				}
				%>
			</div>
		</form>
	</main>
</body>
</html>