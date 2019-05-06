<%-- 
    Document   : addLibrarian
    Created on : Apr 23, 2019, 1:57:50 PM
    Author     : Focus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- This taglib is used to use Spring Form-->
<%@taglib prefix="form2" uri="http://www.springframework.org/tags/form" %>

<!-- This taglib is used to use Spring Labels-->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../jsp/common.jsp"%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Librarian</title>
    </head>
    <body>
        <%@include file="../jsp/navAdmin.jsp"%>
        <h1 style="color:red;text-align:center">Add Librarian</h1>
        ${msg}<br><br>
        <div class="container">
            <form2:form commandName="librarian" method="post" style="width:300px" id="frm2">


                <div class="form-group">
                    <label for="name1"><spring:message code="name"/></label>
                    <form2:input type="text" class="form-control" path="name" placeholder="Name"/>
                </div>
                <div class="form-group">
                    <label for="email1">Email address</label>
                    <form2:input type="email" class="form-control" path="email" placeholder="Email"/>
                </div>
                <div class="form-group">
                    <label for="password1">Password</label>
                    <form2:input type="password" class="form-control" path="password" placeholder="Password"/>
                </div>  
                <div class="form-group">
                    <label for="mobile1">Mobile Number</label>
                    <form2:input type="text" class="form-control" path="mobno" placeholder="Mobile"/>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>


            </form2:form>

            <script>
                
                $("#frm2").validate({
                    rules: {
                        name: {
                            required: true,
                        },
                        email: {
                            required: true,
                            email: true,
                        },
                        password: {
                            required: true,
                        },
                        mobno: {
                            required: true,
                            number: true,
                            maxlength: 10,
                        },
                    },
                });
            </script>
        </div>
    </body>
</html>
