import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Colors {
    Connection1 connection;
    String lastusername;

    Colors() {
        String laststatus = "SELECT * FROM loginchecker";
        connection = new Connection1();
        try {
            PreparedStatement stmt = connection.conn.prepareStatement(laststatus);
            ResultSet results = stmt.executeQuery();
            while (results.next()) {
                lastusername = results.getString("username");
            }
        } catch (Exception ee) {
            ee.printStackTrace();
            System.out.println("not done in colors");
        }

    }

}