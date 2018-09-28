<%-- 
    Document   : rsvp
    Created on : Sep 27, 2018, 1:57:35 PM
    Author     : timpinkerton
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>RSVP to the BEST PARTY EVER!</title>
    </head>
    <body>
        <h1>You Ready?!</h1>

        <h3>Tell me who/what is coming!</h3>

        <hr>

        <p>
            <c:if test="${boolKiddie}">
                Welcome back Buster!
            </c:if>
        </p>

        <form method="POST" action="${pageContext.request.contextPath}/rsvp">
            <label for="name">Yer Name: </label>
            <input type="text" name="name" id="name"/> <br>

            <label for="numOfLlamas">Number of Llamas you're bringing</label>
            <input type="number" name="numOfLlamas" id="numOfLlamas"/> <br>

            <label for="coming">Yer coming right? </label>
            <input type="radio" name="coming" value="yes">Yes</input> 
            <input type="radio" name="coming" value="no">No</input>
            <br><br>
            <input type="submit" value="rsvp"/>

        </form>
    </body>
</html>
