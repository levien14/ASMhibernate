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
<div class="container">
    <div class="row">
        <div class="col-md-5 mx-auto">
            <div id="first">
                <div class="myform form ">
                    <div class="logo mb-3">
                        <div class="col-md-12 text-center">
                            <h1>Login</h1>
                        </div>
                    </div>
                    <form action="login" method="post" name="login">
                        <div class="form-group">
                            <%--@declare id="exampleinputemail1"--%><label for="exampleInputEmail1">Email address</label>
                            <input type="email" name="email"  class="form-control" id="email" aria-describedby="emailHelp" placeholder="Enter email">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputEmail1">Password</label>
                            <input type="password" name="password" id="password"  class="form-control" aria-describedby="emailHelp" placeholder="Enter Password">
                        </div>
                        <div class="form-group">
                            <p class="text-center">By signing up you accept our <a href="#">Terms Of Use</a></p>
                        </div>
                        <div class="col-md-12 text-center ">
                            <button type="submit" class=" btn btn-block mybtn btn-primary tx-tfm">Login</button>
                        </div>
                        <div class="col-md-12 ">
                            <div class="login-or">
                                <hr class="hr-or">
                                <span class="span-or">or</span>
                            </div>
                        </div>
                        <div class="form-group">
                            <p class="text-center">Don't have account? <a href="#" id="signup">Sign up here</a></p>
                        </div>
                    </form>

                </div>
            </div>
        </div>
    </div>
</div>
<div>
    <form action="login" method="post">
        Email: <input type="email" name="email">
        Password: <input type="text" name="password">
        <input type="submit" value="login">
    </form>
</div>

</body>
</html>
