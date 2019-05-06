<%-- 
    Document   : addLibrarian
    Created on : Apr 23, 2019, 1:57:50 PM
    Author     : Focus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c1" %>
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
        <th>Book Id</th><th>Name</th><th>Author</th><th>Publisher No</th><th>Quantity</th><th>Issued</th><th>Delete</th>
    </tr>
    <c1:forEach var="book" items="${listBook}">
    <tr>
        
        <td><c1:out value="${book.book_id}"/></td>
        <td><c1:out value="${book.name}"/></td>
        <td><c1:out value="${book.author}"/></td>
        <td><c1:out value="${book.publisher}"/></td>
        <td><c1:out value="${book.quantity}"/></td>
        <td><c1:out value="${book.issued}"/></td>
        <td><a href="deleteBook.htm?book_id=${book.book_id}">Delete</a></td>
    </tr>
    </c1:forEach>
</table>
</div>
</body>