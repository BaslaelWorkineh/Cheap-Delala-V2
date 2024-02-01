import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class WatchLater {
    static ArrayList<JPanel> watchLater = new ArrayList<JPanel>();
    JPanel panel;
    Connection1 connection;
    Colors usforwl;
    static ArrayList<JPanel> posts = new ArrayList<JPanel>();
    BufferedImage bimage;
    BufferedImage bimage2;
    String first_name;
    Post p;
    JPanel main;
    JLabel Label;
    JLabel Label2;

    JPanel panel1;
    JScrollPane scroller;

    public WatchLater() {

        connection = new Connection1();
        usforwl = new Colors();
        go();
    }

    public void go() {

        main = new JPanel();
        main.setLayout(new BorderLayout());
        main.setBackground(new Color(14, 14, 16));

        panel = new JPanel();
        panel.setBackground(new Color(30, 31, 34));
        panel.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 30));
        panel.setPreferredSize(new Dimension(300, 1500));

        scroller = new JScrollPane(panel);
        scroller.setPreferredSize(new Dimension(0, 0));
        scroller.getVerticalScrollBar().setPreferredSize(new Dimension(5, 0));
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroller.getVerticalScrollBar().setUnitIncrement(16);
        scroller.setBackground(new Color(14, 14, 16));

        panel1 = new JPanel();
        panel1.setBackground(new Color(14, 14, 16));
        panel1.setPreferredSize(new Dimension(1300, 200));
        panel1.setLayout(new GridLayout(2, 1, 10, 10));


        JPanel pane = new JPanel();
        pane.setPreferredSize(new Dimension(375, 265));
        pane.setBackground(Color.red);

        try {
            String sql2 = "SELECT u.id, u.uploadurl, u.uploademail, u.uploadphoneno, u.uploadfirstname, u.uploadmiddlename, u.uploadlastname, u.uploadimage, u.uploadprice\n" +
                    "FROM uploadhouse u\n" +
                    "JOIN watchlater w ON u.id = w.houseid WHERE w.username = ?";

            String imsql = "SELECT image From users WHERE username=?";

            PreparedStatement statement = connection.conn.prepareStatement(sql2);

            statement.setString(1, usforwl.lastusername);
            ResultSet resultSet = statement.executeQuery();


            while (resultSet.next()) {
                first_name = resultSet.getString("uploadfirstname");
                String middle_name = resultSet.getString("uploadmiddlename");
                String last_name = resultSet.getString("uploadlastname");
                String full_name = first_name + " " + middle_name + " " + last_name;
                InputStream path = resultSet.getBinaryStream("uploadimage");
                String user_name = resultSet.getString("uploadurl");
                String email = resultSet.getString("uploademail");
                String phono = resultSet.getString("uploadphoneno");
                String price = resultSet.getString("uploadprice");
                int id = resultSet.getInt("id");


                bimage = ImageIO.read(path);
                ImageIcon iIcon = ResizeImageProfile(bimage, 375, 210);


                PreparedStatement statement2 = connection.conn.prepareStatement(imsql);
                statement2.setString(1, user_name);
                ResultSet resultSet2 = statement2.executeQuery();
                InputStream pppath = null;
                if (resultSet2.next()) {
                    pppath = resultSet2.getBinaryStream("image");
                }

                bimage2 = ImageIO.read(pppath);

                p = new Post(full_name, iIcon, bimage2, 1);

                p.priceLabel.setText("Price: " + price + "$");
                p.moreLabel.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        new HouseInfo(id, true);
                    }
                });

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Label = new JLabel("Hello Customer");
        Label.setFont(new Font("Abyssinica SIL", Font.BOLD, 36));
        Label.setForeground(Color.WHITE);
        Label.setHorizontalAlignment(JLabel.CENTER);

        Label2 = new JLabel("This is your list of houses that you were interested to watch");
        Label2.setFont(new Font("Abyssinica SIL", Font.BOLD, 22));
        Label2.setForeground(Color.WHITE);
        Label2.setHorizontalAlignment(JLabel.CENTER);

        panel1.add(Label);
        panel1.add(Label2);

        main.add(panel1, BorderLayout.NORTH);
        main.add(scroller, BorderLayout.CENTER);
        for (JPanel p : posts) {
            panel.add(p);
        }


    }

    public ImageIcon ResizeImageProfile(BufferedImage image, int width, int height) {

        Image newImg = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon img = new ImageIcon(newImg);
        return img;
    }

    public JPanel getWatchLaterPanel() {
        return main;
    }

}
