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
	background-color: #1affa3;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>


		<div class=" main center">
			<h1 style="color: deeppink">Enjoy Your Favourite Music</h1>
			<br />
			<h2 style="color: purple">List Of Available Languages</h2>
			<br />
			<%
			LanguageDAO languageDao = new LanguageDAO();
			List<Language> languageList = languageDao.getAllLanguages();
			%>

			<form action="LanguageServlet">
				<select name="languages" id="languages" required>
					<option disabled selected value="">--Select language--</option>
					<%
					for (Language language : languageList) {
					%>
					<option value="<%=language.getLanguageId()%>"><%=language.getLanguageName()%></option>
					<%
					}
					%>
				</select> <br /> <br />
				<button class="btn btn-secondary" type="submit">OK</button>
			</form>
		</div>


</body>
</html>


