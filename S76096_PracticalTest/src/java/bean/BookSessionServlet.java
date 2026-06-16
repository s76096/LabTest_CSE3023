/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package bean;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bookSession")
public class BookSessionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String studentName = request.getParameter("student_name");
        String branchLocation = request.getParameter("branch_location");
        String lessonType = request.getParameter("lesson_type");

        SessionBean session = new SessionBean();
        session.setStudent_name(studentName);
        session.setBranch_location(branchLocation);
        session.setLesson_type(lessonType);
        session.setStatus("Booked");

        SessionDAO dao = new SessionDAO();
        boolean ok = dao.bookSession(session);

        // Update dashboard by going to ScheduleServlet (which re-queries DB)
        if (ok) {
            response.sendRedirect(request.getContextPath() + "/schedule");
        } else {
            // still redirect; you can change to an error page if needed
            response.sendRedirect(request.getContextPath() + "/schedule");
        }
    }
}
