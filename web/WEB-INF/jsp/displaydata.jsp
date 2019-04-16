<%-- 
    Document   : displaydata
    Created on : Apr 11, 2019, 7:41:07 PM
    Author     : parth
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Display</title>
    </head>
    <body>
       <%
        String b=request.getParameter("userSelection");
        out.println("<h1>");
        out.println("Data with "+b);
        out.println("</h1>");
        %>

        <table style="width:100%" border ="2" cellspacing="4" cellpadding="13" bgcolor="beige">
            <thead>
            
            <th><b>Id</b></th>
            <th><b>first_name</b></th>
            <th><b>last_name</b></th>
            <th><b>company</b></th>
            <th><b>email</b></th>
            <th><b>address1</b></th>
            <th><b>address2</b></th>
            <th><b>zip</b></th>
            <th><b>city</b></th>
            <th><b>state_long</b></th>
            <th><b>state</b></th>
            <th><b>phone</b></th>
        </thead>
        <tbody>

            <c:forEach var="a" items="${requestScope.a}">
                <tr>

                    <td><c:out value="${a.getId()}"/></td>
                    <td><c:out value="${a.getFirst_name()}"/></td>
                    <td><c:out value="${a.getLast_name()}"/></td>
                    <td><c:out value="${a.getCompany()}"/></td>
                    <td><c:out value="${a.getEmail()}"/></td>
                    <td><c:out value="${a.getAddress1()}"/></td>
                    <td><c:out value="${a.getAddress2()}"/></td>
                    <td><c:out value="${a.getZip()}"/></td>
                    <td><c:out value="${a.getCity()}"/></td>
                    <td><c:out value="${a.getState_long()}"/></td>
                    <td><c:out value="${a.getState()}"/></td>
                    <td><c:out value="${a.getPhone()}"/></td>
                    
                </tr>
            </c:forEach>
        </tbody>
    </table>
    </body>
</html>
