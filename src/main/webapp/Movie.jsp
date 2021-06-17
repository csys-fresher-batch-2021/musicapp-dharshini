<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="in.dharshini.service.MovieService"%>
<%@page import="in.dharshini.model.Movie"%>
<%@page import="in.dharshini.dao.MovieDAO"%>

<!DOCTYPE html>
<%@page import="in.dharshini.model.User"%>
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

		<form action="MovieServlet">
			<div class="center">
				<h1>List Of Available Movies</h1>
				<br />
				<%
				Integer languageId = Integer.parseInt(request.getParameter("languageId"));
				MovieService movieService = new MovieService();
				List<Movie> movieList = movieService.getMovies(languageId);
				%>
				<select name="movies" required>
					<option disabled selected>--Select movie--</option>
					<%
					for (Movie movie : movieList) {
					%>
					<option value="<%=movie.getMovieId()%>"><%=movie.getMovieName()%></option>
					<%
					}
					%>
				</select> <br />
				<br />
				<button class="btn btn-secondary" type="submit">OK</button>

			</div>
		</form>
	</main>
</body>
</html>
