<%@page import="in.dharshini.dao.SongDAO"%>
<%@page import="java.util.List"%>
<%@page import="in.dharshini.service.SongService"%>
<%@page import="in.dharshini.model.Song"%>

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
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">

		<form action="SongServlet">
			<div class="center">
				<h3>List Of Available Songs</h3>
				<br />
				<%
				Integer movieId = Integer.parseInt(request.getParameter("movieId"));
				SongService songService = new SongService();
				List<Song> songList = songService.getSongs(movieId);
				%>
				<select name="songs" required>

					<option disabled selected>--Select language--</option>
					<%
					for (Song song : songList) {
					%>
					<option value="<%=song.getSongId()%>"><%=song.getSongName()%></option>
					<%
					}
					%>
				</select> <br /> <br />
				<button class="btn btn-secondary" type="submit">OK</button>

			</div>
		</form>
	</main>
</body>
</html>