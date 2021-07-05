<%@page import="in.dharshini.dto.SongDTO"%>
<%@ page import="org.owasp.encoder.Encode"%>
<%@page import="java.util.List"%>
<%@page import="in.dharshini.model.Song"%>
<%@page import="in.dharshini.model.Movie"%>
<%@page import="in.dharshini.service.SongService"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>MusicApp</title>

<style>
/*search Bar css*/
.search input[type=text] {
	margin-left: 160px;
	width: 300px;
	height: 35px;
	border-radius: 25px;
	border: none;
}

.search {
	float: left;
	margin: 7px;
}

.search button {
	background-color: black;
	color: #1affa3;
	float: right;
	padding: 7px 10px;
	margin-right: 16px;
	font-size: 12px;
	border: none;
	cursor: pointer;
}

body {
	background-color: #1affa3;
}
</style>

<jsp:include page="header.jsp"></jsp:include>
</head>
<body>
	<div class="search">
		<form action="SearchSongServlet">
			<input type="text" placeholder="Songs, Movies" name="search"
				autofocus required>
			<button>
				<em class="fa fa-search" style="font-size: 18px;"> </em>
			</button>
		</form>
	</div>

	<div class="main center">
		<%
		List<SongDTO> searchSongList = (List<SongDTO>) request.getAttribute("searchSongList");
		List<Movie> searchMovieList = (List<Movie>) request.getAttribute("searchMovieList");
		String errorMessage = (String) request.getAttribute("errorMessage");
		String songName = (String) request.getAttribute("songName");
		String movieName = (String) request.getAttribute("movieName");
		if (movieName == null && errorMessage != null) {
			String encodedErrorMessage = Encode.forHtml(errorMessage);
			out.println(encodedErrorMessage);
		} else if (searchSongList != null) {
		%>
		<%
		if (movieName != null) {
		%>
		<h3 style="color: deeppink">Top Results For The Search</h3>
		<img src="SongImageUtilitiesServlet?imageName=<%=movieName%>"
			alt="<%=movieName%>" width="300" height="200"> <br /> Movie
		Name:
		<%=movieName%>
		<br /> Song Name:
		<%=songName%>
		<br /> <a class="btn btn-primary"
			href="DownloadServlet?songName=<%=songName%>&movieName=<%=movieName%>">Play</a>

		<h3 style="color: deeppink">Other Related Results</h3>
		<table class="table table_bordered">
			<caption>searched song/movie results</caption>
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
				for (SongDTO songdto : searchSongList) {
					i++;
				%>
				<tr>
					<td><%=i%>.</td>
					<td><%=songdto.getSongName()%></td>
					<td><a class="btn btn-primary"
						href="DownloadServlet?songName=<%=songdto.getSongName()%>">Play</a>
						<br /></td>
					<td><a class="btn btn-primary"
						href="AddToPlaylist?song=<%=songdto.getSongName()%>">Add To
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
		<%
		}
		if (searchMovieList != null) {
		%>
		<div class="heading-font-size" style="color: deeppink">Related
			Albums</div>
		<div class="grid-container center">
			<%
			for (Movie movie : searchMovieList) {
			%>
			<div>
				<a href="AlbumServlet?movieName=<%=movie.getMovieName()%>"><img
					src="SongImageUtilitiesServlet?imageName=<%=movie.getMovieName()%>"
					alt="<%=movie.getMovieName()%>" style="height: 50%"
					style="width: 60%"><br /> <strong style="color: #1affa3"><%=movie.getMovieName()%></strong><br/>
					<em style="color: #1affa3"><%=movie.getMusicDirector()%></em></a>
			</div>
			<%
			}
			%>
		</div>
		<%
		}
		%>
	</div>
</body>
</html>