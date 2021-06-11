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

		<form>
			<div class="center">
				<h3>Download Your Favourite Song</h3>
				<br />
				<%
				Integer songId = Integer.parseInt(request.getParameter("songId"));
				SongService songService = new SongService();
				Song song = songService.getSongLink(songId);
				%>
				<a href="<%=song.getSongLink()%>">Click here to download</a>
			</div>
		</form>
	</main>
</body>
</html>