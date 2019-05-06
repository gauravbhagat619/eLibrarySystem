<%-- 
    Document   : addLibrarian
    Created on : Apr 23, 2019, 1:57:50 PM
    Author     : Focus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="frm" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../jsp/common.jsp"%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Book Form</title>
    </head>
    <body>
        <%@include file="../jsp/navLibrarian.jsp"%>
        <h1 style="color:red;text-align:center">Add Book Form</h1>


        <div class="container">
            ${msg}
            <frm:form commandName="book" method="post" style="width:300px" id="frm1">


                <div class="form-group">
                    <label for="bookname1">Name</label>
                    <frm:input type="text" class="form-control" path="name" placeholder="Book Name"/>
                </div>
                <div class="form-group">
                    <label for="author1">Author</label>
                    <frm:input type="text" class="form-control" path="author" placeholder="Author"/>
                </div>
                <div class="form-group">
                    <label for="publisher1">Publisher</label>
                    <frm:input type="text" class="form-control" path="publisher"  placeholder="Publisher"/>
                </div>  
                <div class="form-group">
                    <label for="quantity1">Quantity</label>
                    <frm:input type="text" class="form-control" path="quantity"  placeholder="Quantity"/>
                </div>
                <button type="submit" class="btn btn-primary">Save Book</button>


            </frm:form>
            
            <script>
                // just for the demos, avoids form submit
                jQuery.validator.setDefaults({
                    debug: true,
                    success: "valid"
                });
                $("#frm1").validate({
                    rules: {
                        name: {
                            required: true,
                        },
                        author : {
                            required: true,
                        },
                        publisher:  {
                            required: true,
                        },
                        quantity :{
                            required: true,
                            number: true,
                            minlength:1,
                            maxlength:3,
                        },
                    },
                    messages: { 
                        name:{ 
                            required: "Please enter Name"
                    },
                },
                });
            </script>
        </div>
    </body>

</html>
