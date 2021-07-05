<%@page import="in.dharshini.dao.SongDAO"%>
<%@page import="java.util.List"%>
<%@page import="in.dharshini.service.SongService"%>
<%@page import="in.dharshini.dto.SongDTO"%>

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
	background-color: #1affa3;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<form>
		<div class="main center">
			<h3 style="color: darkslateblue">Enjoy Your Favourite Song
				Online</h3>
			<br />
			<%
			SongDTO SongDetailsList = (SongDTO) request.getAttribute("songDetails");
			%>
			<audio controls autoplay>
				<source src="SongUtilitiesServlet?songName=<%=SongDetailsList.getSongName()%>"
					type="audio/ogg">
				<source src="SongUtilitiesServlet?songName=<%=SongDetailsList.getSongName()%>"
					type="audio/mpeg">
			</audio>
			<br /> <br />
			<div class="c">
				<img
					src="SongImageUtilitiesServlet?imageName=<%=SongDetailsList.getMovieName()%>"
					alt="<%=SongDetailsList.getMovieName()%>" width="300" height="200"><br />
				Movie Name:
				<%=SongDetailsList.getMovieName()%>
				<br /> Song Name:
				<%=SongDetailsList.getSongName()%><br/>
				Music Director: <%=SongDetailsList.getMusicDirector()%><br/>
				Playback Singers: <%=SongDetailsList.getSingers()%><br/>
				Movie Releaes Date: <%=SongDetailsList.getMovieReleasedDate() %>
			</div>
			<br />
		</div>
	</form>
</body>
</html>