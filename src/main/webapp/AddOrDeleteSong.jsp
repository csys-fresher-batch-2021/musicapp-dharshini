<%@ page import="org.owasp.encoder.Encode"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>MusicApp</title>
<style>
.center {
	padding: 70px 0;
	vertical-align: middle;
	text-align: center;
}

.border1 {
	border: 10px solid gray;
	display: inline-block;
	height: 330px;
	border-width: 2px;
	padding: 20px;
	border-radius: 8px;
}

.border2 {
	border: 10px solid gray;
	display: inline-block;
	height: 180px;
	border-width: 2px;
	padding: 20px;
	border-radius: 8px;
}

p {
	color: red;
}

p1 {
	color: green;
}
</style>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">

		<form action="AddSongServlet">
			<div class="center">

				<h1>Add Song</h1>
				<div class="border1">
					<label>Language Id</label> <input type="text" name="languageId"
						id="languageId" required autofocus /> <br /> <br /> <label>Movie
						Id</label> <input type="text" name="movieId" id="movieId" required /> <br />
					<br /> <label>Song To Be Updated</label> <input type="text"
						name="song" id="song" required /><br /> <br /> <label>Song
						Link</label> <input type="text" name="songLink" id="songLink" required />
					<br /> <br />
					<button class="btn btn-secondary">Add</button>
					<br />
					<%
					String errorMessage = (String) request.getParameter("errorMessage");
					if (errorMessage != null) {
						String encodedString = Encode.forHtml(errorMessage);
						out.println("<p>" + encodedString + "</p>");
					} else {
						String message = (String) request.getParameter("message");
						if (message != null) {
							String encodedString = Encode.forHtml(message);
							out.println("<p1>" + encodedString + "</p1>");
						}
					}
					%>
				</div>
			</div>
		</form>
		<form action="RemoveSongServlet">
			<div class="center">
				<h3>Delete song</h3>
				<div class="border2">

					<label>Song To Be Deleted</label> <input type="text" name="song"
						id="song" required /><br /> <br />
					<button class="btn btn-danger">Remove</button>
					<br /> <br />
					<%
					String errorMessage1 = (String) request.getParameter("errorMessage");
					if (errorMessage1 != null) {
						String encodedString1 = Encode.forHtml(errorMessage1);
						out.println("<p>" + encodedString1 + "</p>");
					} else {
						String message1 = (String) request.getParameter("message");
						if (message1 != null) {
							String encodedString1 = Encode.forHtml(message1);
							out.println("<p1>" + encodedString1 + "</p1>");
						}
					}
					%>
				</div>
			</div>
		</form>

	</main>
</body>
</html>
