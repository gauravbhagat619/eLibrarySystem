<%-- 
    Document   : addLibrarian
    Created on : Apr 23, 2019, 1:57:50 PM
    Author     : Focus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c2" %>
<head>
    <title>Book List</title>
    <%@include file="../jsp/common.jsp"%>
</head>
<body>
    <%@include file="../jsp/navLibrarian.jsp"%>

<div class="container">
    ${msg}
<table class='table table-bordered table-striped'>
    <tr>
        <th>Book Id</th><th>Student Id</th><th>Student Name</th><th>Contact</th>
    </tr>
    <c2:forEach var="listissuedbook" items="${listIssuedBook}">
    <tr>
        
        <td><c2:out value="${listissuedbook.book_id}"/></td>
        <td><c2:out value="${listissuedbook.student_id}"/></td>
        <td><c2:out value="${listissuedbook.student_name}"/></td>
        <td><c2:out value="${listissuedbook.contact}"/></td>
    </tr>
    </c2:forEach>
</table>
</div>
</body>