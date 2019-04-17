<%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 4/15/2019
  Time: 8:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Title</title>
</head>
<jsp:include page="link.jsp"></jsp:include>
<%
    String error = (String) request.getAttribute("errorLogin");
%>
<body>
<%
    if (error !=null){
        %>
    <span class="error">
        <%= error %>
    </span>
<%
    }
%>
<div>
    <form action="login" method="post">
        Email: <input type="email" name="email">
        Password: <input type="text" name="password">
        <input type="submit" value="login">
    </form>
</div>

</body>
</html>
