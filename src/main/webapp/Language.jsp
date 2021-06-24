<%@page import="in.dharshini.dao.LanguageDAO"%>
<%@page import="java.util.List"%>
<%@page import="in.dharshini.service.LanguageService"%>
<%@page import="in.dharshini.model.Language"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>MusicApp</title>
<style>
.center {
	text-align: center;
	padding: 70px 0;
}

body {
	background-image: url("ImageUtilitiesServlet?imageName=Login-Image");
	background-repeat: no-repeat;
	background-size: 103% 150%;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">

		<form action="LanguageServlet">
			<div class="center">
				<h1 style="color: darkturquoise">Enjoy Your Favourite Music</h1>
				<br />
				<h2 style="color: purple">List Of Available Languages</h2>
				<br />
				<%
				List<Language> languageList = LanguageDAO.getAllLanguages();
				%>

				<select name="languages" required>
					<option disabled selected>--Select language--</option>
					<%
					for (Language language : languageList) {
					%>
					<option value="<%=language.getLanguageId()%>"><%=language.getLanguageName()%></option>
					<%
					}
					%>
				</select> <br /> <br />
				<button class="btn btn-secondary" type="submit">OK</button>

			</div>
		</form>
	</main>
</body>
</html>


