<%@ page import="java.util.List" %>
<%@ page import="entity.Feedback" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 4/16/2019
  Time: 6:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Feedback> feedbacks =(List<Feedback>) request.getAttribute("ListFeedback");
    if (feedbacks == null){
        feedbacks = new ArrayList<>();
    }
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    for (Feedback fe:feedbacks
         ) {%>
      <span>
          <%=
          fe.getAccountfeeadback().getAccountid()
          %>
          <%=
          fe.getFeedbackid()
          %>
      </span>
    <%}
%>
</body>
</html>
