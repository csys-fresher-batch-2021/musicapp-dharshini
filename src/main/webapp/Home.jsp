<%@page import="java.util.List"%>
<%@page import="in.dharshini.model.Movie"%>
<%@page import="in.dharshini.model.MusicGenre"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>MusicApp</title>

<style>
body {
	background-color: #1affa3;
}

.bg {
	background-color: #1affa3;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<div class="main">

		<%
		List<Movie> recentlyReleasedMovie = (List<Movie>) request.getAttribute("recentlyReleasedMovie");
		List<MusicGenre> allMusicGenre = (List<MusicGenre>) request.getAttribute("allMusicGenre");
		List<MusicGenre> recommendedGenre = (List<MusicGenre>) request.getAttribute("recommendedGenre");
		%>
		<%
		if (allMusicGenre != null) {
		%>
		<div class="heading-font-size">Recommended For You</div>
		<div class="grid-container center">
			<%
			for (MusicGenre musicGenre : recommendedGenre) {
			%>
			<div>
				<a href="MusicGenreServlet?genreId=<%=musicGenre.getGenreId()%>">
					<img
					src="ImageUtilitiesServlet?imageName=<%=musicGenre.getGenre()%>"
					alt="<%=musicGenre.getGenre()%>" style="height: 50%"
					style="width: 60%"><br /> <strong style="color: #1affa3"><%=musicGenre.getGenre()%></strong><br />
					<em style="color: #1affa3">Top <%=musicGenre.getGenre()%>
						Picks
				</em>
				</a>
			</div>
			<%
			}
			%>
		</div>
		<%
		}
		%>
		<br /> <br /> <br /> <br />

		<%
		if (recentlyReleasedMovie != null) {
		%>
		<div class="heading-font-size">Popular New Kollywood Releases</div>
		<div class="grid-container center">
			<%
			for (Movie movie : recentlyReleasedMovie) {
			%>
			<div>
				<a href="AlbumServlet?movieName=<%=movie.getMovieName()%>"> <img
					src="SongImageUtilitiesServlet?imageName=<%=movie.getMovieName()%>"
					alt="<%=movie.getMovieName()%>" style="height: 50%"
					style="width: 60%"><br /> <strong style="color: #1affa3"><%=movie.getMovieName()%></strong><br />
					<em style="color: #1affa3"><%=movie.getMusicDirector()%></em></a>
			</div>
			<%
			}
			%>
		</div>
		<%
		}
		%>
		<br /> <br /> <br /> <br />
		<%
		if (allMusicGenre != null) {
		%>
		<div class="heading-font-size">Music Genres</div>
		<div class="grid-container center">
			<%
			for (MusicGenre musicGenre : allMusicGenre) {
			%>
			<div>
				<a href="MusicGenreServlet?genreId=<%=musicGenre.getGenreId()%>">
					<img
					src="ImageUtilitiesServlet?imageName=<%=musicGenre.getGenre()%>"
					alt="<%=musicGenre.getGenre()%>" style="height: 50%"
					style="width: 60%"><br /> <strong style="color: #1affa3"><%=musicGenre.getGenre()%></strong><br />
					<em style="color: #1affa3">Top <%=musicGenre.getGenre()%>
						Picks
				</em>
				</a>
			</div>
			<%
			}
			%>
		</div>
		<%
		}
		%><br /> <br /> <br /> <br /><br /> <br /> <br /> <br />
	</div>
</body>
</html>
