<%-- 
    Document   : schedule
    Created on : 16 Jun 2026, 2:42:50 PM
    Author     : MP2-4
--%>
<%@ page import="java.util.List" %>
<%@ page import="bean.SessionBean" %>

<html>
<head>
    <title>Training Schedule</title>
</head>
<body>
    <h2>Training Schedule</h2>

    <table border="1" cellpadding="8" cellspacing="0">
        <tr>
            <th>Session ID</th>
            <th>Student Name</th>
            <th>Branch Location</th>
            <th>Lesson Type</th>
            <th>Status</th>
        </tr>

        <%
            List<SessionBean> sessionList = (List<SessionBean>) request.getAttribute("sessionList");
            if (sessionList != null) {
                for (SessionBean s : sessionList) {
        %>
        <tr>
            <td><%= s.getSession_id() %></td>
            <td><%= s.getStudent_name() %></td>
            <td><%= s.getBranch_location() %></td>
            <td><%= s.getLesson_type() %></td>
            <td><%= s.getStatus() %></td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="5">No sessions found.</td>
        </tr>
        <%
            }
        %>

    </table>
</body>
</html>
