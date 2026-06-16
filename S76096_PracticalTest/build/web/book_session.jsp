<%-- 
    Document   : book_session
    Created on : 16 Jun 2026, 2:42:19 PM
    Author     : MP2-4
--%>

<%@ page contentType="text/html; charset=UTF-8" %>

<html>
<head>
    <title>Book Session</title>
</head>
<body>
    <h2>Book a Training Session</h2>

    <form method="POST" action="bookSession">
        Student Name: <input type="text" name="student_name" required /><br/><br/>
        Branch Location: <input type="text" name="branch_location" required /><br/><br/>
        Lesson Type: <input type="text" name="lesson_type" required /><br/><br/>
        <button type="submit">Book</button>
    </form>
</body>
</html>
