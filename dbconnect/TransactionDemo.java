package dbconnect;

import java.sql.*;

public class TransactionDemo {
    private final String url = "jdbc:mysql://localhost:3306/answers";
    private final String user = "root";
    private final String password = "";

    public void transfer(int fromId, int toId, double amount) {
        String debitSql = "UPDATE accounts SET balance = balance - ? WHERE id = ?";
        String creditSql = "UPDATE accounts SET balance = balance + ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            conn.setAutoCommit(false);
            try (PreparedStatement debitStmt = conn.prepareStatement(debitSql);
                 PreparedStatement creditStmt = conn.prepareStatement(creditSql)) {
                debitStmt.setDouble(1, amount);
                debitStmt.setInt(2, fromId);
                creditStmt.setDouble(1, amount);
                creditStmt.setInt(2, toId);
                int debitRows = debitStmt.executeUpdate();
                int creditRows = creditStmt.executeUpdate();
                if (debitRows == 1 && creditRows == 1) {
                    conn.commit();
                    System.out.println("Transfer successful. Transaction committed.");
                } else {
                    conn.rollback();
                    System.out.println("Transfer failed. Transaction rolled back.");
                }
            } catch (SQLException e) {
                conn.rollback();
                System.err.println("Error during transfer: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.err.println("Connection error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        TransactionDemo demo = new TransactionDemo();
        demo.transfer(1, 2, 100.0); // Example: transfer 100 from account 1 to 2
    }
}
