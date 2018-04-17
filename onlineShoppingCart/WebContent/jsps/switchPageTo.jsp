<html>
<head>

<title>Insert title here</title>
</head>
<body>
<%
String value =request.getParameter("selectMenu");
if(value.equals("placeOrder"))
{
	response.sendRedirect("productListAndSearch.jsp");
}
if(value.equals("deleteOrder"))
{
	response.sendRedirect("Delete.jsp");
}
if(value.equals("viewOrder"))
{
	response.sendRedirect("View.jsp");
}
if(value.equals("exit"))
{
	response.sendRedirect("exit.jsp");
}
%>
</body>
</html>