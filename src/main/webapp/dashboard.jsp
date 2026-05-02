<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
</head>
<body>


 <% response.setHeader("Cache-control","no-cache,no-store,must-revalidate");
        if(session.getAttribute("a")==null)
    {
    response.sendRedirect("index.html");
    }
    %>


<%
String username=(String) session.getAttribute("a");

%>



<h1>Welcome,  <%=username%>  </h1>

<form action="LogoutServlet">

<input type="submit" value="Logout">
</form>


</body>
</html>