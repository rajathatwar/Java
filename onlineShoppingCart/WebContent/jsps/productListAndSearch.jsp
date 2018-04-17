<%@page import="java.util.ArrayList"%>
<%@page import="com.project.orderManagementJsp.modal.Item"%>
<%@page import="java.util.List"%>
<%@page import="com.project.orderManagementJsp.ItemDaoImpl"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="searchItem.jsp">

		Enter item name to search <input type="text" name="search" /> <input
			type="submit" value="Submit"> <br>

		<%
			ItemDaoImpl itemsList = new ItemDaoImpl();
			List<Item> items = itemsList.viewAllItems();
			for (Item item : items) {
				out.println("Item Id is " + item.getItemId());
				out.println("<br>");
				out.println("Item Name is " + item.getItemName());
				out.println("<br>");
				out.println("Item Price is " + item.getPrice());
				out.println("<br>");
				out.println("Discount on Name is " + item.getDiscount());
				out.println("<br>");
			}
			out.println("<br>");
			out.println("<br>");
		%>
	</form>
	<br>
	<form action="placedOrder.jsp">
		<table border='1' cellpadding='3' cellspacing='0'>
			<tr>
				<td></td>
				<td><b>ItemName</b></td>
				<td><b>Price</b></td>
				<td><b>Discount</b></td>
				<td><b>Quantity</b></td>
			</tr>

			<%
				List<Item> noItem = (ArrayList<Item>) session.getAttribute("itemList");
				if (noItem != null && noItem.size() > 0) {
					for (Item item : noItem) {
			%>

			<tr>

				<td align='right'><input type="checkbox" name="itemId"
					value="<%=item.getItemId()%>" /></td>
				<td align='right'><input value="<%=item.getItemName()%>" /></td>
				<td align='right'><input value="<%=item.getPrice()%>" /></td>
				<td align='right'><input value="<%=item.getDiscount()%>" /></td>
				<td align='right'><input type="text" name="quantity" /></td>

			</tr>

			<%
				}
			%>
		</table>
		<%
			} else {
				out.println("No item found");
				
			}
		%>

		<input type="submit" value="Submit" />


	</form>


</body>
</html>