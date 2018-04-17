<%@page import="com.project.orderManagementJsp.CustomerDao"%>
<%@page import="com.project.orderManagementJsp.CustomerDaoImpl"%>
<html>
<head>
<title>UserValidate and Place order</title>
</head>
<body>
	<%
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		CustomerDaoImpl customer = new CustomerDaoImpl();
		boolean isValidUser = customer.isUserValid(userName, password);
		if (isValidUser) {
			HttpSession customSession = request.getSession(true);
			customSession.setAttribute("userName", userName);
			response.sendRedirect("menu.jsp");
			
		} else {
	%>
	Invalid User
	<%
		response.sendRedirect("loginPage.html");
		}
	%>

</body>
</html>