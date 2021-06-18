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
	font color: red;
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
				<h3>Your Playlist</h3>
			</div>
			<br /> <br />

			<%
			List<Playlist> playlistDetailsList = (List<Playlist>) request.getAttribute("list");
			String errorMessage = request.getParameter("errorMessage");
			if (errorMessage != null) {
				String encodedErrorMessage = Encode.forHtml(errorMessage);
				out.println("<p>" + encodedErrorMessage + "</p>");
			}
			%>
			<table class="table table_bordered">
				<thead>
					<tr>
						<th>S.No.</th>
						<th>Song Name</th>
						<th>Play/Download</th>
					</tr>
				</thead>
				<tbody>
					<%
					int i = 0;
					for (Playlist playlist : playlistDetailsList) {
						i++;
					%>
					<tr>
						<td>i</td>
						<td><%=playlist.getPlaylistSongName()%></td>
						<td><a class="btn btn-primary"
							href=" <%=playlist.getPlaylistSongLink()%>" role="submit">Play</a>
							<br /></td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
		</form>
	</main>
</body>
</html>
