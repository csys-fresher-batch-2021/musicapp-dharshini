<%@page import="java.util.List"%>
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
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>


	<%
	List<MusicGenre> genreSongList = (List<MusicGenre>) request.getAttribute("list");
	String genreName = (String) request.getAttribute("genre");
	Integer genreId = (Integer) request.getAttribute("genreId");
	%>
	<div class="main center">
		<h1 style="color: deeppink">
			Popular
			<%=genreName%>
			Songs
		</h1>
		<img src="ImageUtilitiesServlet?imageName=<%=genreName%>"
			alt="<%=genreName%>" width="300" height="300"><br /><br/>
		<audio controls autoplay>
			<%
			String genreSongName = (String) session.getAttribute("genreSongName");
			if (genreSongName != null) {
			%>
			<source
				src="MusicGenreSongUtilityServlet?songName=<%=genreSongName%>"
				type="audio/ogg">
			<source
				src="MusicGenreSongUtilityServlet?songName=<%=genreSongName%>"
				type="audio/mpeg">
			<%
			session.removeAttribute("genreSongName");
			}
			%>
		</audio>
		<br /> <br />
		<%
		if (genreSongList != null) {
		%>
		<table class="table table_bordered">
			<caption>songs</caption>
			<thead>
				<tr>
					<th scope="col">S.No.</th>
					<th scope="col">Song Name</th>
					<th scope="col">Music director</th>
					<th scope="col">Singers</th>
					<th scope="col">Play</th>
				</tr>
			</thead>
			<tbody>
				<%
				int i = 0;
				for (MusicGenre genre : genreSongList) {
					i++;
				%>
				<tr>
					<td><%=i%>.</td>
					<td><%=genre.getSongName()%></td>
					<td><%=genre.getMusicDirector()%></td>
					<td><%=genre.getSingers()%></td>
					<td><a class="btn btn-primary"
						href="PlayServlet?genreSongName=<%=genre.getSongName()%>&genreId=<%=genreId%>">Play</a>
						<br /></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
		<%
		}
		%>
	</div>
</body>
</html>