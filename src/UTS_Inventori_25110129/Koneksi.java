package UTS_Inventori_25110129;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Koneksi {
    public static Connection getConnection() {
        Connection conn = null;
        try {
            String url = "jdbc:mysql://localhost:3306/db_inventori";
            String user = "root";
            String password = ""; // Kosongkan jika XAMPP default tidak pakai password

            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            // Jika koneksi gagal, pesan ini akan muncul (Tugas 2)
            JOptionPane.showMessageDialog(null, "Koneksi Gagal ke Database: " + e.getMessage());
        }
        return conn;
    }
}