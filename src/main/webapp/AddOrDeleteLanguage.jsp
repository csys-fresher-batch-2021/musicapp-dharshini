<%@ page import="org.owasp.encoder.Encode"%>

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

		<form>
			<div class="center">
				<h3>Add/Delete Language</h3>
				<label>Language To Be Updated</label> <input type="text"
					name="language" id="language" required autofocus /><br /> <br />
				<button class="btn btn-secondary" type="button"
					onclick="addLanguage()">Add</button>

				<button class="btn btn-danger" type="button"
					onclick="removeLanguage()">Remove</button>
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
		<script>
			function addLanguage() {
				let language = document.getElementById('language').value;
				document.location.href = "/app/AddLanguageServlet?language="
						+ language;
			}

			function removeLanguage() {
				let language = document.getElementById('language').value;
				document.location.href = "/app/RemoveLanguageServlet?language="
						+ language;
			}
		</script>
	</main>
</body>
</html>