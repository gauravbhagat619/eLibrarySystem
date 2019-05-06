<%-- 
    Document   : listLibrarian
    Created on : Apr 23, 2019, 4:33:54 PM
    Author     : Focus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <title>Librarian List</title>
    <%@include file="../jsp/common.jsp"%>
</head>
<body>
    <%@include file="../jsp/navAdmin.jsp"%>

<div class="container">
    ${msg}
<table class='table table-bordered table-striped'>
    <tr>
        <th>Sr.No</th><th>Name</th><th>Email</th><th>Mobile No</th><th>Edit</th><th>Delete</th>
    </tr>
    <c:set var="num" value="0"/>
    <c:forEach var="librarian" items="${libList}">
    <tr>
        <c:set var="num" value="${num+1}"/>
        <td>${num}</td>
        <td><c:out value="${librarian.name}"/></td>
        <td><c:out value="${librarian.email}"/></td>
        <td><c:out value="${librarian.mobno}"/></td>
        <td><a href="editLibrarian.htm?user_id=${librarian.user_id}">Edit</a></td>
        <td><a href="deleteLibrarian.htm?user_id=${librarian.user_id}">Delete</a></td>
    </tr>
    </c:forEach>
</table>
</div>
</body>
    
