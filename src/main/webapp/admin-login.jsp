<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Admin Login</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">

</head>

<body>

	<div class="container">
	
		<h1>Admin Login</h1>
		
		<form action="login" method="post">
		
			<label>Username</label>
			
			<input type="text" name="username">
			
			<label>Password</label>
			
			<input type="password" name="password">
			
			<button type="submit">Login</button>
			
		</form>
		
	</div>

</body>
</html>