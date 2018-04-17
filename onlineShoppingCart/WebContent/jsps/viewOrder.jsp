<%@page import="java.util.List"%>
<%@page import="com.project.orderManagementJsp.modal.ViewOrderModel"%>
<%@page import="com.project.orderManagementJsp.ViewOrder"%>
<%@page import="com.project.orderManagementJsp.OrderPlace"%>
<html>
<head>
<title>ViewOrder</title>
</head>
<body>
	<form action="menu.jsp">
		<table border='1' cellpadding='3' cellspacing='0'>
			<tr>
				<td>customer id</td>
				<td>item id</td>
				<td>order id</td>
				<td>quantity id</td>
				<td>total price</td>
			</tr>
			<%
				String ordId = request.getParameter("orderId");
				ViewOrder view = new ViewOrder();
				List<ViewOrderModel> viewL = view.viewOrder(ordId);
				for (ViewOrderModel obj : viewL) {
			%>



			<tr>
				<td><%=obj.getCUST_ID()%></td>
				<td><%=obj.getITEM_ID()%></td>
				<td><%=obj.getORDER_ID()%></td>
				<td><%=obj.getQUANTITY()%></td>
				<td><%=obj.getTOTALPRICE()%></td>
			</tr>


			<%
				}
			%>
		</table>

		Main Page : <input type="submit" value="Goto">
	</form>
</body>
</html>