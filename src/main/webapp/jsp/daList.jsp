<%-- 
    Document   : daList
    Created on : Sep 27, 2018, 2:31:57 PM
    Author     : timpinkerton
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>The Cool Kids!</title>
    </head>
    <body>
        <p>There are ${numOfPeople} people coming w/ ${totalLlamas} Llamas in total.</p>
        
        <hr>
        
        <a href="rsvp"> >> RSVP Someone Else << </a>
        
        <hr>
        
        <p>The people coming...</p>
        
        <!--The list of people--> 
        <c:forEach var="person" items="${daList}">
            <c:out value="${person}"/><br>
        </c:forEach>
        
    </body>
</html>
