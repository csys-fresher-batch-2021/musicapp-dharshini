<%@page import="java.util.List"%>
<%@page import="in.dharshini.model.Movie"%>
<%@page import="in.dharshini.model.Song"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>MusicApp</title>
<style>
body {
	background-color: #1affa3;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="main center">
		<%
		Movie movieDetails = (Movie) request.getAttribute("movieDetails");
		List<Song> movieSongList = (List<Song>) request.getAttribute("movieSongList");
		%>
		<%
		if (movieDetails != null) {
		%>
		<h2><%=movieDetails.getMovieName()%></h2>
		<br /> <img src="SongImageUtilitiesServlet?imageName=<%=movieDetails.getMovieName()%>"
			alt="<%=movieDetails.getMovieName()%>" width="300" height="200">
		<audio controls autoplay>
			<%
			String songName = (String) session.getAttribute("songName");
			if (songName != null) {
			%>
			<source src="SongUtilitiesServlet?songName=<%=songName%>"
				type="audio/ogg">
			<source src="SongUtilitiesServlet?songName=<%=songName%>"
				type="audio/mpeg">
			<%
			session.removeAttribute("songName");
			}
			%>
		</audio>
		<br /> Movie Name:
		<%=movieDetails.getMovieName()%>
		<br /> Music Director:
		<%=movieDetails.getMusicDirector()%>
		<br />Movie Release Date:
		<%=movieDetails.getMovieReleaseDate()%>
		<br /> <br />
		<h2>Songs</h2>
		<br />
		<table class="table table_bordered">
			<caption>List Of songs in Album</caption>
			<thead>
				<tr>
					<th scope="col">S.No.</th>
					<th scope="col">Song Name</th>
					<th scope="col">Play</th>
					<th scope="col">Playlist</th>
				</tr>
			</thead>
			<tbody>
				<%
				int i = 0;
				for (Song songList : movieSongList) {
					i++;
				%>
				<tr>
					<td><%=i%>.</td>
					<td><%=songList.getSongName()%></td>
					<td><a class="btn btn-primary"
						href="PlayServlet?songName=<%=songList.getSongName()%>&movieName=<%=movieDetails.getMovieName()%>">Play</a>
						<br /></td>
					<td><a class="btn btn-primary"
						href="AddToPlaylist?song=<%=songList.getSongName()%>">Add To
							Playlist</a>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
		<%
		}
		%>
		<br />

	</div>
</body>
</html>