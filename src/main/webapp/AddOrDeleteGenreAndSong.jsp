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
	height: 400px;
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
	<jsp:include page="AdminHeader.jsp"></jsp:include>
	<main class="container-fluid">
		<form  method="POST">
			<div class="center">
				<h3>Add/Delete Genre</h3>
				<label>Genre To Be Updated</label> <input type="text" name="genre"
					id="genre" required  /><br /> <br />
				<button class="btn btn-secondary"type="button" onclick = "addGenre()">Add</button>
				<button class="btn btn-danger" type="button" onclick = "removeGenre()" >Remove</button>
				<br /> <br />
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
		</form>
		<form action="AddGenreSongServlet" enctype="multipart/form-data" method="POST">
			<div class="center">
				<h2>Add Genre Song</h2>
				<div class="border1">
					<label>Song Name</label> <input type="text" name="songName"
						id="songName" required /><br /> <br /> <label>Music
						Director</label> <input type="text" name="musicDirector"
						id="musicDirector" required /> <br /> <br /> <label>Genre
						Id</label> <input type="number" name="genreId" id="genreId" required /> <br />
					<br /> <label>Singers</label> <input type="text" name="singers"
						id="singers" required /><br /> <br /> <label>Song File</label>
					<input type="file" name="songFile" id="songFile" accept=".mp3"
						required /> <br /> <br />
					<button class="btn btn-secondary">Add</button>
					<button class="btn btn-danger">Reset</button>
					<br />
					<%
					String errorMessage2 = (String) request.getParameter("errorMessage");
					if (errorMessage2 != null) {
						String encodedString = Encode.forHtml(errorMessage2);
						out.println("<p>" + encodedString + "</p>");
					} else {
						String message2 = (String) request.getParameter("message");
						if (message2 != null) {
							String encodedString = Encode.forHtml(message2);
							out.println("<p1>" + encodedString + "</p1>");
						}
					}
					%>
				</div>
			</div>
		</form>
		<form action="RemoveGenreSongServlet">
			<div class="center">
				<h3>Delete Genre song</h3>
				<div class="border2">
					<label>Song To Be Deleted</label> <input type="text" name="song"
						id="song" required /><br /> <br />
					<button class="btn btn-danger">Remove</button>
					<br /> <br />
					<%
					String errorMessage3 = (String) request.getParameter("errorMessage");
					if (errorMessage3 != null) {
						String encodedString1 = Encode.forHtml(errorMessage3);
						out.println("<p>" + encodedString1 + "</p>");
					} else {
						String message3 = (String) request.getParameter("message");
						if (message3 != null) {
							String encodedString1 = Encode.forHtml(message3);
							out.println("<p1>" + encodedString1 + "</p1>");
						}
					}
					%>
				</div>
			</div>
		</form>

		 <script>
			function addGenre() {
				let genre = document.getElementById('genre').value;
				document.location.href = "AddGenreSongServlet?genre=" + genre;
			}
			function removeGenre() {
				let genre = document.getElementById('genre').value;
				document.location.href = "RemoveGenreSongServlet?genre="+ genre;
			}
		</script>
	</main>
</body>
</html>