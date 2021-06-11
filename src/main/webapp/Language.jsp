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
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">

		<form action="LanguageServlet">
			<div class="center">
				<h3>List Of Available Languages</h3>
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
			<a href="AddLanguage.jsp">Add New Languages</a>
		</form>
	</main>
</body>
</html>


