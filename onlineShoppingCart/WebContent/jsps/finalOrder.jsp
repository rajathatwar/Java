<%@page import="com.project.orderManagementJsp.OrderPlace"%>
<html>
<head>
<title>FinalOrder</title>
</head>
<body>
<form action="menu.jsp">



	<%
		String[] itemId = request.getParameterValues("itemId");
		String[] quant = request.getParameterValues("quantity");
		
		OrderPlace order= new OrderPlace();
		order.orderPlace(itemId, quant);
		out.println("Order Placed");
		
		/* int noOfItems = itemId.length;
		if (itemId != null && quant != null) {
			for (int i = 0; i < noOfItems; i++) {
				out.println("<li> item Id is " + itemId[i] + "</li>");
				out.println("<li>" + quant[i] + "</li>");
			}
		} */
		
	%>
	
	<br>
	GoTo Main Page: <input type="submit" value="Submit">
	
	</form>
</body>
</html>