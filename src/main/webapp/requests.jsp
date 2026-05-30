<%@ page import="java.util.*" %>
<%@ page import="com.contactus.model.ContactRequest" %>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
	<title>Requests</title>

	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/request.css">

</head>

<body>

	<div class="container">
		<div style="text-align:right; margin-bottom:20px;">
		    <a href="${pageContext.request.contextPath}/admin/logout" class="logout-btn">Logout</a>
		</div>
			
		<h1>Active Requests</h1>

		<table class="request-table">
		    <thead>
		        <tr>
		            <th>ID</th>
		            <th>Full Name</th>
		            <th>Email</th>
		            <th>Message</th>
		            <th>Action</th>
		        </tr>
		    </thead>
		    <tbody>
		        <%
		            List<ContactRequest> activeRequests = (List<ContactRequest>) request.getAttribute("activeRequests");
		
		            for(ContactRequest r : activeRequests) {
		        %>
		        <tr>
		            <td><%= r.getId() %></td>
		            <td><%= r.getFullName() %></td>
		            <td><%= r.getEmail() %></td>
		            <td><%= r.getMessage() %></td>
		            <td>
		                <form action="<%=request.getContextPath()%>/archive" method="post">
		                    <input type="hidden" name="id" value="<%=r.getId()%>">
		                    <button type="submit" class="archive-btn">
		                        Archive
		                    </button>
		                </form>
		            </td>
		        </tr>
		        <%
		            }
		        %>
		    </tbody>
		</table>
		
		<hr>
		
		<h1>Archived Requests</h1>
		
		<table class="request-table">
		    <thead>
		        <tr>
		            <th>ID</th>
		            <th>Full Name</th>
		            <th>Email</th>
		            <th>Message</th>
		        </tr>
		    </thead>
		    <tbody>
		        <%
		            List<ContactRequest> archivedRequests = (List<ContactRequest>) request.getAttribute("archivedRequests");
		
		            for(ContactRequest r : archivedRequests) {
		        %>
		        <tr>
		            <td><%= r.getId() %></td>
		            <td><%= r.getFullName() %></td>
		            <td><%= r.getEmail() %></td>
		            <td><%= r.getMessage() %></td>
		        </tr>
		        <%
		            }
		        %>
		    </tbody>
		</table>
	</div>

</body>
</html>