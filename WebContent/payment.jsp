<%@ page language="java" contentType="text/html; charset=windows-1251"
    pageEncoding="windows-1251"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>������ ������</title>
</head>
<body>
<jsp:useBean id="user" class="ru.shop.dto.User" scope="session">
		<jsp:setProperty property="name" name="user" value="�����"/>
</jsp:useBean>
<%if(user.getName().equals("�����")){%>
	<a href="index.jsp"><u><b>���������� ������� �� ������� ��������</b></u></a>
<% } else {%>
	���: 	<jsp:getProperty property="name" name="user"/><br>
	������: <jsp:getProperty property="cash" name="user"/><br>
	����� ������ <%=request.getParameter("totalCost") %>
	<form action="CashServlet" method="post">
		<input type="hidden" name="operation" value="remove" />
		<input type="hidden" name="income" value=<%=request.getParameter("totalCost") %> />
		<input type="submit" value="�������� �����"/>
	</form>
<%}%>
</body>
</html>