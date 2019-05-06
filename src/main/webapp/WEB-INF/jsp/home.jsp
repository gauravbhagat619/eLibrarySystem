<%-- 
    Document   : home
    Created on : Apr 21, 2019, 7:51:42 PM
    Author     : Focus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
  <title>Login Page</title>
  <%@include file="../jsp/common.jsp"%>
  <script>
        var jvalidate = $("#form1").validate({
                ignore: [],
                rules: {
                    email1: {
                        required: true
                    },
                    password1 : {
                        required: true
                    },
                }
            });
  </script>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="home.htm">eLibrary</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">

       </ul>

    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

<div class="container-fluid">
<h1>eLibrary</h1>

<div class="row">
  <div class="col-md-6">
  <h3>Admin Login</h3>
  ${msg}
  <form action="adminLogin.htm" method="post" style="width:300px" id="form1">
  <div class="form-group">
    <label for="email1">Email address</label>
    <input type="email" class="form-control" name="email" id="email1" placeholder="Email"/>
  </div>
  <div class="form-group">
    <label for="password1">Password</label>
    <input type="password" class="form-control" name="password" id="password1" placeholder="Password"/>
  </div>  
  <button type="submit" class="btn btn-primary" name="admin">Login</button>
</form>
  
  </div>
  <div class="col-md-6">
  <h3>Librarian Login</h3>
  <form action="librarianLogin.htm" method="post" style="width:300px">
  <div class="form-group">
    <label for="email1">Email address</label>
    <input type="email" class="form-control" id="email1" name="email" placeholder="Email"/>
  </div>
  <div class="form-group">
    <label for="password1">Password</label>
    <input type="password" class="form-control" id="password1" name="password" placeholder="Password"/>
  </div>  
  <button type="submit" class="btn btn-primary" name="libr">Login</button>
</form>
</div>
  </div>
</div>




 
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
</body>
</html>
