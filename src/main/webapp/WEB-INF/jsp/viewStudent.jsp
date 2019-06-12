<%-- 
    Document   : viewStudent
    Created on : Jun 11, 2019, 3:54:33 PM
    Author     : Gaurav 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c3" %>
<head>
    <title>Issued Book List</title>
    <%@include file="../jsp/common.jsp"%>
</head>
<body>
    <%@include file="../jsp/navLibrarian.jsp"%>

    <div class="container">
        ${msg}
        <table class='table table-bordered table-striped'>
            <tr>
                <th>Sr.No</th><th>Student Name</th><th>Contact</th><th>State</th><th>District</th><th>Village</th>
            </tr>
            <c3:set var="num" value="0"/>
            <c3:forEach var="listStudent" items="${listStudent}">
                <tr>
                <c3:set var="num" value="${num+1}"/>
                <td>${num}</td>
                <td><c3:out value="${listStudent.name}"/></td>
                <td><c3:out value="${listStudent.contactno}"/></td>
                <td><c3:out value="${listStudent.state.state_desc}"/></td>
                <td><c3:out value="${listStudent.district.districtDesc}"/></td>
                <td><c3:out value="${listStudent.village.villageDesc}"/></td>
                </tr>
            </c3:forEach>
        </table>
    </div>
</body>
