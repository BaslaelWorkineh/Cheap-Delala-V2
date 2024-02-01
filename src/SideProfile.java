import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class SideProfile {
    JPanel userInfo;
    ImageIcon profileImage;
    Connection1 connection;
    JLabel fullname;
    JLabel username;
    JLabel email;
    JLabel phone;
    JLabel profile;
    JLabel fullnameL;
    JLabel usernameL;
    JLabel phoneL;
    JLabel emailL;
    JTextArea chat;
    JButton sentChat;
    JLabel profileHolder;
    String u;

    public SideProfile() {
        go();
    }

    public void go() {
        connection = new Connection1();

        userInfo = new JPanel();
        userInfo.setPreferredSize(new Dimension(300, 300));
        userInfo.setBackground(new Color(30, 31, 34));
        userInfo.setVisible(true);
        userInfo.setLayout(null);

        //not finished get owners image from the database
        JLabel pp = new JLabel();
        pp.setBounds(10, 10, 118, 118);

        ImageIcon close = new ImageIcon(this.getClass().getResource("close.png"));
        JButton closeUserInfo = new JButton();
        closeUserInfo.setIcon(close);
        closeUserInfo.setBounds(250, 10, 30, 30);
        closeUserInfo.setBorderPainted(false);
        closeUserInfo.setFocusPainted(false);
        closeUserInfo.setOpaque(false);
        closeUserInfo.setBackground(new Color(255, 31, 31));
        closeUserInfo.addActionListener(e -> {
            userInfo.setVisible(false);
        });

        ImageIcon profileh = new ImageIcon(this.getClass().getResource("frame120.png"));
        profileHolder = new JLabel(profileh);
        profileHolder.setBounds(90, 40, 120, 120);

        profile = new JLabel();
        profile.setBounds(90, 40, 120, 120);

        fullnameL = new JLabel("Owner's Name: ");
        fullnameL.setBounds(10, 180, 150, 40);
        fullnameL.setFont(new Font("Sarif", Font.BOLD, 18));
        fullnameL.setForeground(Color.WHITE);

        fullname = new JLabel("(-) Baslael Workineh Ayele");
        fullname.setBounds(20, 200, 200, 40);
        fullname.setFont(new Font("sarif", Font.BOLD, 16));
        fullname.setForeground(Color.WHITE);

        usernameL = new JLabel("Username: ");
        usernameL.setBounds(10, 250, 150, 40);
        usernameL.setFont(new Font("Sarif", Font.BOLD, 18));
        usernameL.setForeground(Color.WHITE);

        username = new JLabel("(-) @" + "Beka123");
        username.setBounds(20, 270, 200, 40);
        username.setFont(new Font("sarif", Font.BOLD, 16));
        username.setForeground(Color.WHITE);

        phoneL = new JLabel("PhoneNo: ");
        phoneL.setBounds(10, 320, 100, 40);
        phoneL.setFont(new Font("Sarif", Font.BOLD, 18));
        phoneL.setForeground(Color.WHITE);

        phone = new JLabel("(-) +251985316396");
        phone.setBounds(20, 340, 200, 40);
        phone.setFont(new Font("sarif", Font.BOLD, 16));
        phone.setForeground(Color.WHITE);

        emailL = new JLabel("Email: ");
        emailL.setBounds(10, 390, 60, 40);
        emailL.setFont(new Font("Sarif", Font.BOLD, 18));
        emailL.setForeground(Color.WHITE);

        email = new JLabel("(-) Baslaworku@gmail.com");
        email.setBounds(20, 410, 250, 40);
        email.setFont(new Font("sarif", Font.BOLD, 16));
        email.setForeground(Color.WHITE);

        JLabel status = new JLabel();
        status.setBounds(230, 420, 100, 30);
        status.setForeground(new Color(19, 171, 0));
        status.setFont(new Font("sarif", Font.PLAIN, 22));

        chat = new JTextArea();
        chat.setBounds(10, 450, 280, 200);
        chat.setBackground(new Color(201, 200, 200));
        chat.setFont(new Font("sarif", Font.BOLD, 16));

        sentChat = new JButton("Send Message");
        sentChat.setFont(new Font("sarif", Font.BOLD, 16));
        sentChat.setBounds(130, 660, 160, 40);
        sentChat.setBackground(new Color(0, 119, 56));
        sentChat.setBorderPainted(false);
        sentChat.setFocusPainted(false);
        sentChat.setForeground(Color.WHITE);
        sentChat.setFocusPainted(false);
        Profile p = new Profile();

        ////////////////////////////////////This has worked donot dare touch it :( ////////////////////////////////////////////////////

        sentChat.addActionListener(e -> {


            String query = "SELECT * FROM loginchecker";
            String usernametobeupdated = "";
            try {
                PreparedStatement statement = connection.conn.prepareStatement(query);

                ResultSet results = statement.executeQuery();

                while (results.next()) {
                    usernametobeupdated = results.getString("username");
                }
                status.setText("sent!");
                new Timer(3000, e1 -> {
                    status.setVisible(false);
                }).start();

            } catch (Exception a) {
                System.out.println("error");
            }
            u = usernametobeupdated;
            String sql2 = "SELECT * FROM users WHERE username=?";
            String fullnames = "";
            String fdname = "";
            String mdname = "";
            String ldname = "";

            try {
                PreparedStatement statement = connection.conn.prepareStatement(sql2);
                statement.setString(1, u);
                ResultSet results = statement.executeQuery();

                if (results.next()) {
                    fdname = results.getString("fname");
                    mdname = results.getString("mname");
                    ldname = results.getString("lname");
                }
                fullnames = fdname + " " + mdname + " " + ldname + " ";

            } catch (Exception a) {
                System.out.println("error");
            }

            String sql = "INSERT INTO messages(fromusername,fullname,themessage,tousername) values (?,?,?,?)";

            try {
                PreparedStatement stmt = connection.conn.prepareStatement(sql);

                stmt.setString(1, u);
                stmt.setString(2, fullnames);
                stmt.setString(3, chat.getText());
                stmt.setString(4, username.getText());

                stmt.executeUpdate();
            } catch (Exception a) {
                a.printStackTrace();
            }
        });


        ////////////////////////////////////This has worked donot dare touch it :( ////////////////////////////////////////////////////


        userInfo.add(fullnameL);
        userInfo.add(fullname);
        userInfo.add(usernameL);
        userInfo.add(username);
        userInfo.add(phoneL);
        userInfo.add(phone);
        userInfo.add(emailL);
        userInfo.add(email);
        userInfo.add(profileHolder);
        userInfo.add(profile);
        userInfo.add(closeUserInfo);
        userInfo.add(chat);
        userInfo.add(sentChat);
        userInfo.add(status);
    }

    public JPanel getSideProfile() {
        return userInfo;
    }

}
