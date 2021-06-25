<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="in.dharshini.service.MovieService"%>
<%@page import="in.dharshini.model.Movie"%>
<%@page import="in.dharshini.dao.MovieDAO"%>
<%@page import="in.dharshini.model.User"%>

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
	background-size: 103% 200%;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">

		<div class="center">
			<h2 style="color: purple">List Of Available Movies</h2>
			<br />
			<%
			Integer languageId = Integer.parseInt(request.getParameter("languageId"));
			MovieService movieService = new MovieService();
			List<Movie> movieList = movieService.getMovies(languageId);
			%>

			<form action="MovieServlet">
				<select required name="movies" id="movies">
					<option disabled selected value="">--Select movie--</option>
					<%
					for (Movie movie : movieList) {
					%>
					<option value="<%=movie.getMovieId()%>"><%=movie.getMovieName()%></option>
					<%
					}
					%>
				</select> <br /> <br />
				<button class="btn btn-secondary" type="submit">OK</button>
			</form>
		</div>
	</main>
</body>
</html>
