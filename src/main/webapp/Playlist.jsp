<%@ page import="org.owasp.encoder.Encode"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="in.dharshini.model.Playlist"%>
<%@page import="in.dharshini.service.SongService"%>
<%@page import="in.dharshini.dao.PlaylistDAO"%>

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

p {
	color: green;
}

f {
	color: red;
}

.c {
	font-size: 20px;
}

.right {
	position: absolute;
	right: 0px;
	width: 200px;
}


body {
	background-image: url("ImageUtilitiesServlet?imageName=PlayList-Image");
	 background-repeat: no-repeat;
	background-size: 103% 100%;
}
</style>
</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<form action=SearchSongServlet>
			<div class="center">
				<%
				String play = null;
				List<Playlist> playlistDetailsList = (List<Playlist>) request.getAttribute("list");
				String errorMessage = request.getParameter("errorMessage");
				String infoMessage = request.getParameter("infoMessage");
				String infoMessage2 = request.getParameter("infoMessage2");

				String songName = (String) session.getAttribute("songName");
				if (errorMessage != null) {
					String encodedErrorMessage = Encode.forHtml(errorMessage);
					out.println("<f>" + encodedErrorMessage + "</f>");
				} else if (infoMessage != null) {
					String encodedInfoMessage = Encode.forHtml(infoMessage);
					out.println("<p>" + encodedInfoMessage + "</p>");
				}
				%>
				<h3 style="color: purple">Your Playlist</h3>
				<audio controls autoplay>
					<%
					if (songName != null) {
					%>
					<source src="SongUtilitiesServlet?songName=<%=songName%>"
						type="audio/ogg">
					<source src="SongUtilitiesServlet?songName=<%=songName%>"
						type="audio/mpeg">
					<%
					}
					%>
				</audio>

				<div class="right">
					<a class="btn btn-danger" href="ClearPlaylistServlet">Clear
						Playlist</a>
				</div>
				<br /> <br /><br/>
				<table class="table table_bordered">
					<caption>List Of songs in Playlist</caption>
					<thead>
						<tr>
							<th scope="col">S.No.</th>
							<th scope="col">Song Name</th>
							<th scope="col">Play/Download</th>
							<th scope="col">Remove</th>
						</tr>
					</thead>
					<tbody>
						<%
						int i = 0;
						for (Playlist playlist : playlistDetailsList) {
							play = playlist.getPlaylistSongName();
							i++;
						%>
						<tr>
							<td><%=i%>.</td>
							<td><%=playlist.getPlaylistSongName()%></td>
							<td><a class="btn btn-primary"
								href="PlaylistServlet?songName=<%=playlist.getPlaylistSongName()%>">Play</a>
								<br /></td>
							<td><a class="btn btn-danger"
								href="RemovePlaylistServlet?song=<%=playlist.getPlaylistSongName()%>">Remove</a>
						</tr>
						<%
						}
						%>
					</tbody>
				</table>
				<a href="SearchSong.jsp">Add More Songs To Your Playlist</a>
			</div>
		</form>
		<script>
			function play() {
				let play = "Yenga Annan";
			}
		</script>

	</main>
</body>
</html>
