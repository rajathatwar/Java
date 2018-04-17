<%@page import="com.project.orderManagementJsp.ItemDao"%>
<%@page import="com.project.orderManagementJsp.modal.Item"%>
<%@page import="java.util.List"%>
<%@page import="com.project.orderManagementJsp.ItemDaoImpl"%>
<html>
<head>

<title>Insert title here</title>
</head>
<body>
<%
String key=request.getParameter("search");

ItemDaoImpl itemListObj = new ItemDaoImpl();
List<Item> itemList =itemListObj.searchItems(key);

session.setAttribute("itemList", itemList);

%>
<jsp:forward page="productListAndSearch.jsp">
<jsp:param value='<%=key %>' name="search"/>
</jsp:forward>
</body>
</html>