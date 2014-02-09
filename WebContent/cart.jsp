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
		<jsp:setProperty property="name" name="user" value="Ãîñòü"/>
	</jsp:useBean>
	
	<jsp:useBean id="cart" class="ru.shop.dto.ShoppingCart" scope="session"></jsp:useBean>
	<%ArrayList<Good> goodsList = (ArrayList<Good>) session.getAttribute("goodsTable");%>
	<%ArrayList<Long> cartList = cart.getGoodsIdCart();%>
	<%long totalCost = 0; %>
	<table>
	<tr>
		<td colspan=2><b>Ñïèñîê òîâàðîâ â êîðçèíå</b></td>
	</tr>
	<%for(Long index : cartList){%>
		
		<%for(Good good : goodsList){%>
		<%if(index == null) System.out.println("NULL"); %>
		<%if(good.getId() == index) {%>
				
				<tr>
					<td align="left"><a href="description.jsp?goodId=<%=good.getId()%>&returnTo=cart.jsp"><u><%=good.getName()%></u></a></td>
					<td align="right"><%="  "%><%=good.getPrice()%> ðóá. <%="   "%> </td>	
					<td align="center"><a href="CartServlet?operation=remove&goodId=<%= good.getId()%>"><u>Óáðàòü èç êîðçèíû</u></a></td>	 
					<%totalCost+=good.getPrice(); %>
				</tr>
				
			<%}%>		
		<%}%>
		 
	<%}%> 
	</table>
	<br>Òîâàðà íà ñóììó: <%=totalCost %> ðóá.
	<br><a href="payment.jsp?totalCost=<%= totalCost %>"><u><b>Îïëàòèòü çàêàç</b></u></a>
	
</body>
</html>