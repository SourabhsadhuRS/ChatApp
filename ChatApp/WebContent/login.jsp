<html>
<head>
<title>Session Tracking</title>
</head>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
function getISO8583() {
	var ISO8583="Check";
	xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			document.getElementById("alrt").innerHTML = xhttp.responseText;
		} else {
			document.getElementById("alrt").innerHTML = "Validating User";
		}
	}
	xhttp.open("POST", "login?q=" + ISO8583, true);
	xhttp.send();
}
</script>
<body>
<!-- 	<center> -->
		<h1>Login</h1>
<!-- 	</center> -->
	<div id="alrt"></div>
	<form action="login" method="post">
		<table border="1" allign="right">
			<tr>
				<td>User name</td>
				<td><textarea name="ID" rows="1" cols="20" required="required"></textarea></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><textarea name="Pwd" rows="1" cols="20" required="required"></textarea>
				</td>
			</tr>
		</table>
		<br>
		<button type="submit" onclick="getISO8583()">Login</button>
	</form>
	<input type="button" onclick="location.href='register.jsp';" value="Sign Up" />
</body>
</html>