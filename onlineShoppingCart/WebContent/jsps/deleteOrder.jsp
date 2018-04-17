<%@page import="com.project.orderManagementJsp.DeleteOrder"%>
<html>
<head>
<title>Delete Order</title>
</head>
<body>

<%String deleteId = request.getParameter("dId"); 
DeleteOrder obj2 = new DeleteOrder();
obj2.deleteOrder(deleteId);
out.println("order deleted successfully");
%>




<form action="menu.jsp">

Main Page : <input type="submit" value="Goto">
</form>
</body>
</html>