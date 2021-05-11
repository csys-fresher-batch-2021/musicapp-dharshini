<%@page import="java.util.List"%>
<%@page import="in.dharshini.service.LanguageList"%>
<html>
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
		<form>
			<div class="center">
				<h3>
					<font style="color: blue">List Of Available Languages</font>
				</h3>
				<br />
				<%
				List<String> languageName = LanguageList.displayAvailableLanguages();
				%>
				<select name="languages">
					<option disabled selected>--Select language--</option>
					<%
					for (String language : languageName) {
					%>
					<option value="<%=language%>"><%=language%></option>
					<%
					}
					%>
				</select>

			</div>
		</form>
	</main>
</body>
</html>


