<%@ page language="java" contentType="text/html; charset=windows-1251"
    pageEncoding="windows-1251"%>
<%@ page import="ru.shop.dto.Good"
		 import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart</title>
</head>
<body>
	<jsp:useBean id="user" class="ru.shop.dto.User" scope="session">
		<jsp:setProperty property="name" name="user" value="Guest"/>
	</jsp:useBean>
	
	<jsp:useBean id="cart" class="ru.shop.dto.ShoppingCart" scope="session"></jsp:useBean>
	<%ArrayList<Good> goodsList = (ArrayList<Good>) session.getAttribute("goodsTable");%>
	<%ArrayList<Long> cartList = cart.getGoodsIdCart();%>
	<table>
	<tr>
		<td colspan=2><b>Ñïèñîê òîâàðîâ â êîðçèíå</b></td>
	</tr>
	<%for(Long index : cartList){%>
		
		<%for(Good good : goodsList){%>
		<%if(index == null) System.out.println("NULL"); %>
		<%if(good.getId() == index) {%>
				
				<tr>
					<td align="left"><a href=""><u><%=good.getName()%></u></a></td>
					<td align="right"><%=good.getPrice()%></td>		 
				</tr>
				
			<%}%>		
		<%}%>
		 
	<%}%> 
	</table>
	
</body>
</html>