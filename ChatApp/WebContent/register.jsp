<html>
<head>
<title>Session Tracking</title>
</head>
<body>
<!-- 	<center> -->
		<h1>New Registration</h1>
<!-- 	</center> -->
	<form action="login" method="post">
		<table border="1" allign="right">
			<tr bgcolor="#949494">
				<td>User name</td>
				<td><textarea name="ID" rows="1" cols="20" required="required"></textarea></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><textarea name="Pwd" rows="1" cols="20" required="required"></textarea>
				</td>
			</tr>
			<tr>
				<td>Confirm Password</td>
				<td><textarea name="confPwd" rows="1" cols="20" required="required"></textarea>
				</td>
			</tr>
		</table>
		<br>
		<button type="submit">Login</button>
	</form>
	<input type="button" onclick="location.href='login.jsp';" value="Go Back" />
</body>
</html>