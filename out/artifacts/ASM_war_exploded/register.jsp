<%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 4/15/2019
  Time: 1:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <form action="userinformation" method="post">
        <fieldset>
            <legend>Account</legend>
            Email: <input type="email" name="email">
            Password : <input type="text" name="password">
        </fieldset>

        <fieldset>
            <legend>UserInformation</legend>
            UserName <input type="text" name="username">
            FullName <input type="text" name="fullname">
            Address <input type="text" name="address">
            DOB <input type="date" name="dob">
            Phone <input type="text" name="phone">
        </fieldset>
        <input type="submit" value="Register">
    </form>
</div>

</body>
</html>
