<%-- 
    Document   : editLibrarian
    Created on : Apr 23, 2019, 4:07:19 PM
    Author     : Focus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form3" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../jsp/common.jsp"%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Librarian</title>
    </head>
    <body>
        <%@include file="../jsp/navAdmin.jsp"%>
        <h1 style="color:red;text-align:center">Edit Librarian</h1>
        <div class="container">
            <form3:form commandName="libr" method="post" style="width:300px" id="frm3">
                <div class="form-group">
                    <label for="name1">Name</label>
                    <form3:input type="text" class="form-control" path="name"  placeholder="Name"/>
                </div>

                <div class="form-group">
                    <label for="email1">Email address</label>
                    <form3:input type="email" class="form-control" path="email"  placeholder="Email"/>
                </div>

                <div class="form-group">
                    <label for="password1">Password</label>
                    <form3:input type="password" class="form-control" path="password"  placeholder="Password"/>
                </div>

                <div class="form-group">
                    <label for="mobile1">Mobile Number</label>
                    <form3:input type="text" class="form-control" path="mobno"  placeholder="Mobile"/>
                </div>

                <button type="submit" class="btn btn-primary">Update</button>
            </form3:form>
                
            <script>
               
                $("#frm3").validate({
                    rules: {
                        name: {
                            required: true,
                        },
                        email: {
                            required: true,
                            email: true,
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
