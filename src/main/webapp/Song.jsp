<%-- <%@page import="in.dharshini.dao.SongDAO"%>
<%@page import="java.util.List"%>
<%@page import="in.dharshini.service.SongService"%>
<%@page import="in.dharshini.model.Song"%>
<%@page import="in.dharshini.model.Movie"%>


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

	<div class="main center">
		<h1 style="color: deeppink">Enjoy Your Favourite Music</h1>
		<br />
		<h2 style="color: purple">List Of Available Songs</h2>
		<br/>
		<%
		String movieName = request.getParameter("movieName");
		SongService songService = new SongService();
		Movie movie = new Movie(movieName);
		List<Song> songList = songService.getSongsNames(movie);
		%>
		<form action="DownloadServlet">
			<select name="songName" required>
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
</body>
</html> --%>

String songName = request.getParameter("songName").toUpperCase();

		SongsDto songDetails = null;
		try {

			if (!SongServices.isSongSourceAvailable(songName)) {
				if (SongServices.isSongAvailableInSongsDatabase(songName)) {

					final Part songPart = request.getPart("songSource");
					final Part imagePart = request.getPart("imageSource");
					final String songFileName = getFileName(songPart);
					final String imageFileName = getFileName(imagePart);
					String fileLocation = getServletContext().getInitParameter("upload.location");
					if (fileLocation == null || "null".equals(fileLocation)) {
						fileLocation = "D:/uploads";
					}
					File songUploads = new File(fileLocation + File.separator + songFileName);
					File imageUploads = new File(fileLocation + File.separator + imageFileName);

					songDetails = copyFiles(response, songName, songDetails, songPart, imagePart, songUploads,
							imageUploads);

					if ((SongServices.addSongSource(songDetails))) {

						response.sendRedirect("adminWorks.jsp?info=" + "Succesfully added");
					} else {
						response.sendRedirect(JSP + "Cannot add Song");

					}
				} else {
					response.sendRedirect(JSP + "Song not available in songs database");

				}
			} else {
				response.sendRedirect(JSP + "Song source already exists");
			}

		} catch (ServicesException e) {
			String errorMessage = "unable to add Song";
			response.sendRedirect(JSP + errorMessage);
		}




































