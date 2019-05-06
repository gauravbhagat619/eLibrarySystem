<%-- 
    Document   : addLibrarian
    Created on : Apr 23, 2019, 1:57:50 PM
    Author     : Focus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="frm3" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../jsp/common.jsp"%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Return Book</title>
    </head>
    <body>
        <%@include file="../jsp/navLibrarian.jsp"%>
        <h1 style="color:red;text-align:center">Return Book</h1>


        <div class="container">
            ${msg}
            <frm3:form action="returnBook.htm" commandName="returnbook" method="post" style="width:300px" id="frm4">

                <div class="form-group">
                    <label for="bookid2">Book Id</label>
                    <frm3:input type="text" class="form-control" path="book_id"  placeholder="Book Id"/>
                </div>

                <div class="form-group">
                    <label for="studentid2">Student Id</label>
                    <frm3:input type="text" class="form-control" path="student_id"  placeholder="Student Id"/>
                </div>

                <button type="submit" class="btn btn-primary">Return Book</button>
            </frm3:form>

            <script>

                $("#frm4").validate({
                    rules: {
                        book_id: {
                            required: true,
                        },
                        student_id: {
                            required: true,
                        },
                    },
                    messages: {
                        book_id: {required: "Please enter Book Id"
                        },
                        student_id: {required: "Please enter Student Id"
                        },
                    },
                });
            </script>
        </div>
    </body>
</html>
