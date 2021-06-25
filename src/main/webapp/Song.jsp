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

body {
	background-image: url("ImageUtilitiesServlet?imageName=Login-Image");
	background-repeat: no-repeat;
	background-size: 103% 200%;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">

		<div class="center">
			<h2 style="color: purple">List Of Available Songs</h2>
			<br />
			<%
			Integer movieId = Integer.parseInt(request.getParameter("movieId"));
			SongService songService = new SongService();
			List<Song> songList = songService.getSongsNames(movieId);
			%>
			<form action="SongServlet">
				<select name="song" required>
					<option disabled selected value="">--Select song--</option>
					<%
					for (Song song : songList) {
					%>
					<option value="<%=song.getSongName()%>"><%=song.getSongName()%></option>
					<%
					}
					%>
				</select> <br /> <br />
				<button class="btn btn-secondary" type="submit">OK</button>
			</form>
		</div>
	</main>
</body>
</html>