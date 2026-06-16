/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

/**
 *
 * @author MP2-4
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SessionDAO {

    // CHANGE these to match your phpMyAdmin/MySQL settings
    private static final String DB_URL =
            "jdbc:mysql://localhost:8080/drivesmart_db?useSSL=false&serverTimezone=UTC";
    private static final String DB_USER = "admin";
    private static final String DB_PASSWORD = "admin";

    // 5 Marks: Connection Method
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    // 5 Marks: Insert Method
    public boolean bookSession(SessionBean session) {
        String sql = "INSERT INTO Training_Sessions (student_name, branch_location, lesson_type, status) "
                   + "VALUES (?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, session.getStudent_name());
            ps.setString(2, session.getBranch_location());
            ps.setString(3, session.getLesson_type());
            ps.setString(4, session.getStatus());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // 5 Marks: Retrieve Method
    public List<SessionBean> getAllSessions() {
        List<SessionBean> list = new ArrayList<>();

        String sql = "SELECT * FROM Training_Sessions ORDER BY branch_location ASC";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                SessionBean s = new SessionBean();
                s.setSession_id(rs.getInt("session_id"));
                s.setStudent_name(rs.getString("student_name"));
                s.setBranch_location(rs.getString("branch_location"));
                s.setLesson_type(rs.getString("lesson_type"));
                s.setStatus(rs.getString("status"));
                list.add(s);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
