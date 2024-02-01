import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Base64;

public class Post extends JFrame {
    JPanel panel;
    JLabel moreLabel;
    JLabel nameLabel;
    JCheckBox watchLater;
    //    String profilePhoto;
    BufferedImage image = null;
    BufferedImage imagepp = null;
    String name = "Abdi Ahmed";
    String address = "Yeka Abado, Addis Ababa";
    String type = "Residential";
    ImageIcon house, profilePhoto;
    JPanel fpanel;
    JLabel rightFrame;
    JLabel leftFrame;
    JLabel frameLabel;
    JLabel fence;
    JLabel fence2;
    JLabel priceLabel;
    boolean visible;
    double size = 123.45;
    double price = 1234567.89;
    Connection1 conn;
    Colors usforwl;

    int id;

    public static void main(String[] args) {
        new Post().go();
    }

    public Post() {

    }

    public void idgeter(int id) {
        this.id = id;
    }

    BufferedImage prof;

    public Post(String name, ImageIcon house, BufferedImage profile) {
//        this.profilePhoto = profilePhoto;
        conn = new Connection1();
        prof = profile;
        profilePhoto = ResizeImageProfile(profile, 50, 50);

        this.name = name;
        this.house = house;
        go();
        Header.posts.add(panel);
    }

    public Post(String name, ImageIcon house, BufferedImage profile, int n) {

        conn = new Connection1();
        prof = profile;
        profilePhoto = ResizeImageProfile(profile, 50, 50);

        this.name = name;
        this.house = house;
        go();
        WatchLater.posts.add(panel);
    }

    public void go() {

        panel = new JPanel();
        panel.setBackground(new Color(66, 67, 70));
        SpringLayout sl = new SpringLayout();
        panel.setLayout(sl);
        panel.setPreferredSize(new Dimension(375, 265));
        panel.setMixingCutoutShape(new RoundRectangle2D.Double(0, 0, 375, 265, 50, 50));

        priceLabel = new JLabel("Price: ");
        priceLabel.setForeground(Color.BLACK);
        priceLabel.setFont(new Font("SERIF", Font.BOLD, 22));
        priceLabel.setPreferredSize(new Dimension(200, 25));
        panel.add(priceLabel);

        leftFrame = new JLabel();
        leftFrame.setPreferredSize(new Dimension(102, 210));
        panel.add(leftFrame);

        rightFrame = new JLabel();
        rightFrame.setPreferredSize(new Dimension(102, 210));
        panel.add(rightFrame);

        JLabel label = new JLabel(house);
        label.setPreferredSize(new Dimension(375, 210));
        label.setBackground(Color.cyan);
        panel.add(label);

        frameLabel = new JLabel();
        frameLabel.setPreferredSize(new Dimension(60, 60));
        panel.add(frameLabel);

        JLabel profileLabel = new JLabel(profilePhoto);
        profileLabel.setPreferredSize(new Dimension(60, 60));
//        profileLabel.setIcon(ResizeImage(profilePhoto, 30, 30));
        panel.add(profileLabel);

        nameLabel = new JLabel(name.toUpperCase());
        nameLabel.setForeground(Color.white);
        nameLabel.setFont(new Font("Sarif", Font.BOLD, 13));
        nameLabel.setPreferredSize(new Dimension(100, 25));
        panel.add(nameLabel);

        ImageIcon unchecked = new ImageIcon(this.getClass().getResource("watchLater_unchecked.png"));
        ImageIcon checked = new ImageIcon(this.getClass().getResource("watchLater_checked.png"));

        watchLater = new JCheckBox();
        watchLater.setFocusable(false);
        watchLater.setIcon(unchecked);
        watchLater.setSelectedIcon(checked);
        panel.add(watchLater);


        watchLater.addActionListener(e -> {
            usforwl = new Colors();
            if (watchLater.isSelected()) {
                try {
                    String watchlatertoDB = "INSERT INTO watchlater (username, houseid) VALUES (?,?)";

                    PreparedStatement stmt = conn.conn.prepareStatement(watchlatertoDB);

                    stmt.setString(1, usforwl.lastusername);
                    stmt.setInt(2, id);
                    stmt.executeUpdate();
                    System.out.println("inserted");

                } catch (Exception eee) {
                    eee.printStackTrace();
                    System.out.println("not inserted");
                }


            } else {
                try {
                    String DeletewatchlatertoDB = "DELETE FROM watchlater WHERE username=? AND houseid=?";
                     PreparedStatement stmt = conn.conn.prepareStatement(DeletewatchlatertoDB);
                    stmt.setString(1, usforwl.lastusername);
                    stmt.setInt(2, id);
                    stmt.executeUpdate();
                    System.out.println("Deleted");

                } catch (Exception eee) {
                    eee.printStackTrace();
                    System.out.println("not Deleted");
                }

            }

        });


        fence = new JLabel("|");
        fence.setForeground(Color.white);
        fence.setFont(new Font("Sarif", Font.BOLD, 20));
        fence.setPreferredSize(new Dimension(6, 30));
        panel.add(fence);


        moreLabel = new JLabel("More Info");
        moreLabel.setForeground(Color.white);
        moreLabel.setFont(new Font("Sarif", Font.BOLD, 16));
        moreLabel.setPreferredSize(new Dimension(90, 25));
        moreLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                HouseInfo houseInfo = new HouseInfo(id, Header.darkwhite);


            }
        });
        panel.add(moreLabel);

        fence2 = new JLabel("|");
        fence2.setForeground(Color.white);
        fence2.setFont(new Font("Sarif", Font.BOLD, 20));
        fence2.setPreferredSize(new Dimension(6, 30));
        panel.add(fence2);


        sl.putConstraint(SpringLayout.EAST, rightFrame, 440, SpringLayout.WEST, panel);
        sl.putConstraint(SpringLayout.NORTH, rightFrame, 0, SpringLayout.NORTH, panel);
        sl.putConstraint(SpringLayout.WEST, leftFrame, -65, SpringLayout.WEST, panel);
        sl.putConstraint(SpringLayout.NORTH, leftFrame, 0, SpringLayout.NORTH, panel);
        sl.putConstraint(SpringLayout.WEST, label, 0, SpringLayout.WEST, panel);
        sl.putConstraint(SpringLayout.NORTH, label, 0, SpringLayout.NORTH, panel);


        sl.putConstraint(SpringLayout.WEST, frameLabel, 5, SpringLayout.WEST, panel);
        sl.putConstraint(SpringLayout.SOUTH, frameLabel, 5, SpringLayout.SOUTH, panel);
        sl.putConstraint(SpringLayout.WEST, profileLabel, -10, SpringLayout.WEST, frameLabel);
        sl.putConstraint(SpringLayout.SOUTH, profileLabel, -2, SpringLayout.SOUTH, frameLabel);
        sl.putConstraint(SpringLayout.WEST, nameLabel, 7, SpringLayout.EAST, frameLabel);
        sl.putConstraint(SpringLayout.SOUTH, nameLabel, -10, SpringLayout.SOUTH, frameLabel);


        sl.putConstraint(SpringLayout.WEST, fence, 3, SpringLayout.EAST, nameLabel);
        sl.putConstraint(SpringLayout.VERTICAL_CENTER, fence, -3, SpringLayout.VERTICAL_CENTER, nameLabel);
        sl.putConstraint(SpringLayout.VERTICAL_CENTER, moreLabel, 0, SpringLayout.VERTICAL_CENTER, nameLabel);
        sl.putConstraint(SpringLayout.WEST, moreLabel, 25, SpringLayout.EAST, fence);

        sl.putConstraint(SpringLayout.VERTICAL_CENTER, priceLabel, -230, SpringLayout.VERTICAL_CENTER, nameLabel);
        sl.putConstraint(SpringLayout.WEST, priceLabel, -170, SpringLayout.EAST, fence);


        sl.putConstraint(SpringLayout.WEST, fence2, 3, SpringLayout.EAST, moreLabel);
        sl.putConstraint(SpringLayout.VERTICAL_CENTER, fence2, -3, SpringLayout.VERTICAL_CENTER, nameLabel);
        sl.putConstraint(SpringLayout.WEST, watchLater, 20, SpringLayout.EAST, fence2);
        sl.putConstraint(SpringLayout.SOUTH, watchLater, -5, SpringLayout.SOUTH, panel);


//        fpanel.add(panel);
//        fpanel.add(panel2);

//        setLayout(null);
//        add(panel);
//        setVisible(true);
//        setSize(1000, 800);
//        setDefaultCloseOperation(1);
//        setBackground(Color.blue);
//        setLocationRelativeTo(null);
    }

    public void go2() {

//        panel2.setVisible(false);
//        panel2.setBounds(0,260,800,290);
    }

    public ImageIcon ResizeImage(String ImagePath, int x, int y) {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(x, y, Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

    public ImageIcon ResizeImageProfile(BufferedImage image, int width, int height) {

        Image newImg = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon img = new ImageIcon(newImg);
        return img;
    }
}
