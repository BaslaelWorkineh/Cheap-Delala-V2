import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LogOut {
    Connection1 connection;
    JFrame frame;

    public LogOut() {
        connection = new Connection1();

        logoutPage();
    }

    public void logoutPage() {
        frame = new JFrame();
        frame.setSize(400, 240);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setUndecorated(true);

        JPanel topPanel = new JPanel();
        topPanel.setBounds(0, 0, 400, 30);
        topPanel.setBackground(new Color(33, 45, 59));

        JPanel panel = new JPanel();
        panel.setBounds(0, 20, 400, 220);
        panel.setBackground(new Color(33, 45, 59));
        panel.setLayout(null);


        JLabel logoutText = new JLabel("Log Out");
        logoutText.setLayout(null);
        logoutText.setFont(new Font("sarif", Font.BOLD, 20));
        logoutText.setBounds(20, 15, 100, 40);
        logoutText.setForeground(new Color(247, 246, 244));

        JLabel logoutWarning = new JLabel("Are you sure you want to log out?");
        logoutWarning.setFont(new Font("sarif", Font.BOLD, 15));
        logoutWarning.setBounds(25, 55, 400, 30);
        logoutWarning.setForeground(new Color(247, 246, 244));
        logoutWarning.setLayout(null);

        JLabel logoutMsg = new JLabel("This will remove all your current information.");
        logoutMsg.setFont(new Font("sarif", Font.BOLD, 15));
        logoutMsg.setBounds(25, 85, 400, 30);
        logoutMsg.setForeground(new Color(247, 246, 244));
        logoutMsg.setLayout(null);


        JPanel bottomPanel = new JPanel();
        bottomPanel.setBounds(0, 160, 400, 60);
        bottomPanel.setBackground(new Color(33, 45, 59));
        bottomPanel.setLayout(null);

        JLabel cancelLabel = new JLabel("CANCEL");
        cancelLabel.setFont(new Font("Sarif", Font.BOLD, 15));
        cancelLabel.setBounds(180, 0, 65, 30);
        cancelLabel.setForeground(new Color(115, 181, 255));
        cancelLabel.setLayout(null);

        cancelLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();

            }
        });


        JLabel logoutLabel = new JLabel("LOG OUT");
        logoutLabel.setFont(new Font("Sarif", Font.BOLD, 15));
        logoutLabel.setBounds(280, 0, 70, 30);
        logoutLabel.setForeground(new Color(115, 181, 255));

        logoutLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                new loginSignup();
                String lastStatus = "INSERT INTO loginchecker (username, laststatus) VALUES ('unknown','not logged in')";

                try {
                    PreparedStatement stmt = connection.conn.prepareStatement(lastStatus);
                    stmt.executeUpdate();
                } catch (Exception de) {
                    de.printStackTrace();
                }
                //there should be something to point to the database that the user in logged in or not
            }
        });

        bottomPanel.add(cancelLabel);
        bottomPanel.add(logoutLabel);

        panel.add(bottomPanel);
        panel.add(logoutMsg);
        panel.add(logoutWarning);
        panel.add(logoutText);

        frame.add(topPanel);
        frame.add(panel);
        frame.setVisible(true);
    }
}
