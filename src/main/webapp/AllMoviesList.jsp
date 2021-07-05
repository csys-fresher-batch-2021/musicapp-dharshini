<%@page import="java.util.List"%>
<%@page import="in.dharshini.model.Movie"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>MusicApp</title>
<style>
</style>
<link rel="stylesheet"
	href="//cdn.datatables.net/1.10.25/css/jquery.dataTables.min.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script src="https://cdn.datatables.net/1.10.25/js/jquery.dataTables.min.js" integrity="sha256-Vs1Pr+/TIqzfEEfhNiD7E1hrhxPKLaVcSnBV4G+1S0E=" crossorigin="anonymous"></script>
</head>
<body>
	<div class="center">
		<h3>All Movies List( Year Wise)</h3>
		<table border="1" id="moviesTable">
			<caption>List Of All Movies</caption>
			<thead>
				<tr>
					<th scope="col">S.No.</th>
					<th scope="col">Movie Name</th>
					<th scope="col">Music Director</th>
					<th scope="col">Released Year</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
		<script>
	let url = "AllMoviesServlet";
	
	fetch(url).then(res=> res.json()).then(res=>{
		let movies = res;
		
		let content = "";
		let index = 0;
		for(let movie of movies){
			content+= "<tr ><td>" + ++index + "</td><td>" + movie.movieName +"</td><td>" + movie.musicDirector + "</td><td>"+movie.movieReleaseDate+"</td></tr>";
		}
		$(document).ready(function() {
			$("#moviesTable tbody").append(content);
			$('#moviesTable').DataTable();
		});
	})
		 </script>
	</div>

</body>
</html>