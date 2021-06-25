<%@page import="in.dharshini.dto.SongDTO"%>
<%@ page import="org.owasp.encoder.Encode"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="in.dharshini.model.Song"%>
<%@page import="in.dharshini.service.SongService"%>

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

.c {
	font-size: 20px;
}

body {
	background-image: url("ImageUtilitiesServlet?imageName=PlayList-Image");
	background-repeat: no-repeat;
	background-size: 103% 200%;
}
</style>
</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<form action=SearchSongServlet>
			<div class="center">
				<h3 style="color: purple">Search Your Favourite Song</h3>
				<br /> <input type="text" name="song"
					placeholder="Type Song Name Correctly" autofocus /> <br /> <br />
				<button class="btn btn-secondary" type="submit">Search</button>
				<br /> <br /> <br /> <br />


				<%
				List<SongDTO> searchSongList = (List<SongDTO>) request.getAttribute("searchSongList");
				String errorMessage = request.getParameter("errorMessage");
				String noOfSearchResult = (String) request.getAttribute("noOfSearchResult");
				String encodedNoOfSearchResult = Encode.forHtml(noOfSearchResult);
				if (errorMessage != null) {
					String encodedErrorMessage = Encode.forHtml(errorMessage);
					out.println("<font color='red' size='5px'>" + encodedErrorMessage + "</font");
				} else if (searchSongList!=null) {
				%>
				<h3 style="color: deeppink">
					No Of Results For The Search:
					<%=encodedNoOfSearchResult%></h3>

				<div class="c">

					<table class="table table_bordered">
						<caption>searched song results</caption>
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
									href="Download.jsp?songName=<%=songdto.getSongName()%>">Play</a>
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

				</div>

				<%-- 
					<label style="color: gold">Song : <%=songName%></label>
				</div>
				<br /> <a class="btn btn-primary"
					href="Download.jsp?songName=<%=songName%>" role="submit">Play</a> <br />
				<br /> <a class="btn btn-primary"
					href="AddToPlaylist?song=<%=songName%>">Add To Playlist</a> --%>
				<%
				}
				%>

			</div>
		</form>
	</main>
</body>
</html>