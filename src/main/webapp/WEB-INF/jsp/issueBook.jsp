<%-- 
    Document   : addLibrarian
    Created on : Apr 23, 2019, 1:57:50 PM
    Author     : Focus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="frm2" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../jsp/common.jsp"%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Book Form</title>
    </head>
    <body>
        <%@include file="../jsp/navLibrarian.jsp"%>
        <h1 style="color:red;text-align:center">Issue Book</h1>


        <div class="container">
            ${msg}
            <frm2:form action="issueBook.htm" commandName="issuebook" method="post" style="width:300px" id="frm2">

                <div class="form-group">
                    <label for="bookid1">Book Id</label>
                    <frm2:input type="text" class="form-control" path="book_id"  placeholder="Book Id"/>
                </div>

                <div class="form-group">
                    <label for="author1">Student Id</label>
                    <frm2:input type="text" class="form-control" path="student_id"  placeholder="Student Id"/>
                </div>

                <div class="form-group">
                    <label for="publisher1">Student Name</label>
                    <frm2:input type="text" class="form-control" path="student_name"  placeholder="Student Name"/>
                </div>  

                <div class="form-group">
                    <label for="quantity1">Contact</label>
                    <frm2:input type="text" class="form-control" path="contact"  placeholder="Contact"/>
                </div>

                <button type="submit" class="btn btn-primary">Issue Book</button>
            </frm2:form>

            <script>

                $("#frm2").validate({
                    rules: {
                        book_id: {
                            required: true,
                        },
                        student_id: {
                            required: true,
                        },

                        student_name: {
                            required: true,
                        },
                        contact:{
                            required: true,
                            number: true,
                            maxlength: 10,
                        },
                    },
                     messages: { 
                         book_id: { required: "Please enter Book Id"
                     },
                     student_id: { required: "Please enter Student Id"
                     },
                     student_name: { required: "Please enter Student Name"
                     },
                     contact: { required: "Please enter Contact No."
                     },
                 },
                });
            </script>
        </div>
    </body>
</html>
