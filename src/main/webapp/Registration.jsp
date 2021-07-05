<%@ page import="org.owasp.encoder.Encode"%>
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
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<div class="main center">
		<%
		String errorMessage = request.getParameter("errormessage");
		if (errorMessage != null) {
			String encodedString = Encode.forHtml(errorMessage);
			out.println("<font color='red'>" + encodedString + "</font>");
		}
		%>
		<form method="POST" action="RegistrationServlet">
			<h1>Registration</h1>
			<br /> <label>First Name</label> <input type="text" name="fName"
				id="fName" placeholder="Enter Your First Name" required autofocus /><br>
			<br> <label>Email Id</label> <input type="email" name="email"
				id="email" placeholder="Enter Your Email Id" required /><br> <br>
			<label>Confirm Your Email Id</label> <input type="email"
				name="checkEmail" id="checkEmail"
				placeholder="Re-Enter Your Email Id" required /><br> <br>
			<label>Password</label> <input type="password" name="password"
				id="password" placeholder="Enter Your Password" required /><br>
			<p style="font-size: 15px">
				(Password length Should be between 8 to 20 characters)<br />(Password
				should contain atleast - 1 digit, 1 smallLetter,1 CapitalLetter, 1
				specialCharacter)
			</p>
			<br> <label>Age:</label> <input type="number" name="age"
				id="age" placeholder="Enter Your Age" required> <br>
			<p style="font-size: 15px">(Enter Correct Age For Better song
				Recommendation)</p>
			<br />
			<button class="btn btn-secondary" type="submit">Submit</button>
			<br /> <br /> <br> <br> Already Signed Up? <a
				href="Login.jsp">Login</a>

		</form>
	</div>
</body>

</html>