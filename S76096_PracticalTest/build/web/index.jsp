<%-- 
    Document   : index
    Created on : 16 Jun 2026, 3:36:31 PM
    Author     : MP2-4
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="header.html" %>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>DriveSmart Academy</title>
    </head>
    <body>
<h2>Welcome to DriveSmart Academy</h2>
<p>Select a module:</p>

<div style="margin-top:15px;">
    <a href="book_session.jsp" style="display:inline-block;margin-right:15px;padding:10px 18px;background:#198754;color:white;text-decoration:none;">
        Booking Form
    </a>

    <a href="schedule.jsp" style="display:inline-block;padding:10px 18px;background:#dc3545;color:white;text-decoration:none;">
        Schedule Dashboard
    </a>
</div>

<%@ include file="footer.jsp" %>
    </body>
</html>
