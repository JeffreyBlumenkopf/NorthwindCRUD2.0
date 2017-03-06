<%--
  Created by IntelliJ IDEA.
  User: Owner
  Date: 3/1/2017
  Time: 10:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %> <%-- "<%@" means import --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table border="1">
    <td>


    <th>customer id</th>
    <th>company name</th>
    <th>city</th>
    <th>country</th>
    <th> delete</th>


    </td>
    <c:forEach var="customer" items="${cList}">
        <tr>
            <td>${customer.customerId} </td>
            <td>${customer.companyName} </td>
            <td>${customer.city}</td>
            <td>${customer.country}</td>
            <td><a href="delCust?id=${customer.customerId}">Delete${customer.customerId}</a></td
            <%--<a href="2.html" onclick=""topics.html?getId=${customer.customerId} "">Open</a>--%>
        </tr>


    </c:forEach>
</table>
</body>
</html>
