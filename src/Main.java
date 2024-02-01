import javax.swing.*;
import java.sql.*;

public class Main {

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception ignored) {
        }

        Connection1 connection;
        String lastStatus = "";

        connection = new Connection1();

        String query = "SELECT * FROM loginchecker";
        try {
            PreparedStatement stmt = connection.conn.prepareStatement(query);

            ResultSet results = stmt.executeQuery();

            while (results.next()) {
                lastStatus = results.getString("laststatus");
            }

            if (lastStatus.equals("not logged in"))
                new loginSignup();
            else if (lastStatus.equals("Logged in")) {
                new SideBar(lastStatus);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


