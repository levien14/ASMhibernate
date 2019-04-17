<%@ page import="entity.Account" %><%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 4/15/2019
  Time: 12:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  HttpSession session1 = request.getSession();

  Account account = (Account) session1.getAttribute("Loggedin");
  if (account == null){
    account = new Account();
  }
%>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  $END$
  <%= account.getEmail() + account.getPassword()%>
  <div>
    <form action="feedback" method="post">
      <input type="hidden" value="<%=account.getAccountid()%>" name="accountid">
      Feedback: <textarea name="content"></textarea>
      <input type="submit" value="sub">
    </form>
  </div>
  </body>
</html>
