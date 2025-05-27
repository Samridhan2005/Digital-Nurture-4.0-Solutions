package dbconnect;

import java.sql.*;

public class StudentDAO {
    private final String url = "jdbc:mysql://localhost:3306/answers";
    private final String user = "root";
    private final String password = "";

    public void insertStudent(int id, String name, String grade) {
        String sql = "INSERT INTO student (id, name, grade) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, grade);
            int rows = pstmt.executeUpdate();
            System.out.println(rows + " student(s) inserted.");
        } catch (SQLException e) {
            System.err.println("Insert error: " + e.getMessage());
        }
    }

    public void updateStudent(int id, String newName, String newGrade) {
        String sql = "UPDATE student SET name = ?, grade = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newName);
            pstmt.setString(2, newGrade);
            pstmt.setInt(3, id);
            int rows = pstmt.executeUpdate();
            System.out.println(rows + " student(s) updated.");
        } catch (SQLException e) {
            System.err.println("Update error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        dao.insertStudent(101, "Alice", "A");
        dao.updateStudent(101, "Alice Smith", "A+");
    }
}
