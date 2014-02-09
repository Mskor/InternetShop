<%@ page language="java" contentType="text/html; charset=windows-1251"
    pageEncoding="windows-1251"%>
<%@ page import="java.util.*"
		 import="ru.shop.dto.Good" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Îïèñàíèå òîâàðà</title>
</head>
<body>
<div align="center">
	<%ArrayList<Good> goodsList = (ArrayList<Good>) session.getAttribute("goodsTable");%>
	<%
		Long goodId = Long.valueOf(request.getParameter("goodId"));
		
		for(Good good : goodsList){
			if(good.getId() == goodId){%>
				<table>
				<tr>
					<td align="left"><b><%=good.getName() %></b></td>
				</tr>
				<tr>
					<td align="left">Öåíà: <%=good.getPrice()%> ðóá.</td>
				</tr>
				<tr colspan=2>
					<td>Îïèñàíèå:</td>
				</tr>
				<tr colspan=2> 
					<td align="justify"><%=good.getDescription()%></td>
				</tr>
				</table>
				 
			<%}
		}		
	%>
	
	<br><u><a href="index.jsp">Íà ãëàâíóþ</a></u>
</div>
</body>
</html>