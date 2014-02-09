<%@ page language="java" contentType="text/html; charset=windows-1251"
    pageEncoding="windows-1251"%>
<%@ page import="java.util.*"
		 import="ru.shop.dto.Good" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mera internet shop</title>
</head>
<body>
<jsp:useBean id="user" class="ru.shop.dto.User" scope="session">
	<jsp:setProperty property="name" name="user" value="Ãîñòü"/>
</jsp:useBean>

<jsp:useBean id="cart" class="ru.shop.dto.ShoppingCart" scope="session"></jsp:useBean>

<jsp:include page="/GoodServlet" >
	<jsp:param value="select * from goods" name="sqlQuery"/>
</jsp:include>

Äîáðî ïîæàëîâàòü, <jsp:getProperty property="name" name="user"/>
<%if (user.getName().equals("Ãîñòü")){%>

<form action="login" method="post">
	<input type="text" name="reqName"/>
	<input type="password" name="reqPass"/>
	<input type="submit" value="Âõîä"/>
</form>
<%} else {%>
<br>Äåíüãè íà ñ÷åòó: <%=user.getCash() %> ðóá. <br>
<a href="logout"><u>Âûéòè</u></a> <br>
<%}%>
<a href="register.jsp"><u> Ðåãèñòðàöèÿ</u></a><br><br>
<a href="cart.jsp"><u>Â çàêàçå : <jsp:getProperty property="amount" name="cart"/> òîâàðà</u></a>


<%ArrayList<Good> goodsList = (ArrayList<Good>) session.getAttribute("goodsTable");%>
	<br><br>
	<table>
	<tr>
		<td colspan=2><b>Ñïèñîê òîâàðîâ</b></td>
	</tr>
	<%for(Good good : goodsList){%>
	<tr>
		<td align="left"><a href="description.jsp?goodId=<%=good.getId()%>&returnTo=index.jsp"><u><%=good.getName()%></u></a></td>
		<td align="right"><%=good.getPrice()%></td>
		<td align="center"><a href="CartServlet?operation=add&goodId=<%= good.getId()%>"><u>Äîáàâèòü â êîðçèíó</u></a></td> 
	</tr>
	<%}%>
	</table>
	
	
</body>
</html>