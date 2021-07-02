<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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

	<jsp:include page="AdminHeader.jsp"></jsp:include>
	<main class="container-fluid">
		<div class="center">
			1.To Add/Delete Languages <br /> <a href="AddOrDeleteLanguage.jsp">Click
				here</a> <br> <br> 2.To Add/Delete Movies <br /> <a
				href="AddOrDeleteMovie.jsp">Click here</a> <br> <br> 3.To
			Add/Delete Songs <br /> <a href="AddOrDeleteSong.jsp">Click here</a>
			<br> <br> 4.To Add/Delete Genre And Genre Songs <br /> <a
				href="AddOrDeleteGenreAndSong.jsp">Click here</a> <br> <br>
		</div>
	</main>
</body>
</html>