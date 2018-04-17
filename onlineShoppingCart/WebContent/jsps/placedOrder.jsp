<%@page import="com.project.orderManagementJsp.OrderPlace"%>
<html>
<head>

<title>Place Order</title>
</head>
<body>

	<%
		String[] itemId = request.getParameterValues("itemId");
		String[] quant = request.getParameterValues("quantity");

		OrderPlace order = new OrderPlace();
		for(int i=0;i<itemId.length;i++){
		//order.orderPlace(itemId, quant);
		out.println("Order Placed");
		}
	%>
	<form action="menu.jsp">
	
	
	<input type="submit" value="GotoMainPage">
	</form>
</body>
</html>