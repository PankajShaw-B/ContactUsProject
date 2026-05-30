<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Contact Us</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">

</head>

<body>

	<div class="container">
	
	    <h1>Contact Us</h1>
	
	    <form action="contactus" method="post">
	
	        <label>Full Name</label>
	
	        <input type="text" name="fullName" required>
	
	        <label>Email</label>
	
	        <input type="email" name="email" required>
	
	        <label>Message</label>
	
	        <textarea name="message" required></textarea>
	
	        <button type="submit">Submit</button>
	
	    </form>
	
	</div>

</body>
</html>