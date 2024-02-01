import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection1 {
    Connection conn;

    Connection1() {
        String jdbcURL = "jdbc:postgresql://localhost:5432/CheepDelala";
        String username = "postgres";
        String password = "Basuismena#123";

        try {
            conn = DriverManager.getConnection(jdbcURL, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}