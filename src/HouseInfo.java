import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;

public class HouseInfo {
    Connection connection;
    String jdbcURL = "jdbc:postgresql://localhost:5432/CheepDelala";
    String username = "postgres";
    String password = "Basuismena#123";
    int id;
    BufferedImage bimage;
    boolean darkwhite;
    ImageIcon house;
    String name, regionValue, cityValue, streetValue, sizeValue, bedroomValue, priceValue;
    JFrame houseInfoFrame;

    public HouseInfo(int id, boolean darkwhite) {
        this.id = id;
        this.darkwhite = darkwhite;

        try {
            this.id = id;
            String sql = "SELECT * FROM uploadhouse WHERE id = ?";
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String fname = resultSet.getString("uploadfirstname");
                String mname = resultSet.getString("uploadmiddlename");
                String lname = resultSet.getString("uploadlastname");
                regionValue = resultSet.getString("uploadregion");
                cityValue = resultSet.getString("uploadcity");
                streetValue = resultSet.getString("uploadstreetaddress1");
                sizeValue = resultSet.getString("uploadhousesize");
                bedroomValue = resultSet.getString("nobedrooms");
                priceValue = resultSet.getString("uploadprice");
                name = fname + " " + mname + " " + lname;

                InputStream imageStream = resultSet.getBinaryStream("uploadimage");
                bimage = ImageIO.read(imageStream);
                house = ResizeImageProfile(bimage, 600, 300);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            go();

        }
    }

    public void go() {
        houseInfoFrame = new JFrame();
        houseInfoFrame.setSize(700, 800);
        houseInfoFrame.setLocationRelativeTo(null);
        houseInfoFrame.setLayout(new BorderLayout());
        houseInfoFrame.setResizable(false);
        houseInfoFrame.setUndecorated(true);
        houseInfoFrame.setShape(new RoundRectangle2D.Double(0, 0, 700, 800, 50, 50));

        JPanel houseInfo = new JPanel();
        houseInfo.setPreferredSize(new Dimension(300, 300));
        if (!darkwhite)
            houseInfo.setBackground(new Color(33, 32, 32));
        else
            houseInfo.setBackground(new Color(217, 205, 205));
        houseInfo.setLayout(null);

        JPanel p1 = new JPanel();
        p1.setBounds(40, 10, 600, 300);
        p1.setLayout(new BorderLayout());
        p1.setBackground(new Color(112, 110, 110));

        JLabel homeImages = new JLabel(house);
        homeImages.setForeground(Color.WHITE);
        homeImages.setPreferredSize(new Dimension(600, 300));


        p1.add(homeImages, BorderLayout.CENTER);


        JLabel ownerNameL = new JLabel("Owner Name: ");
        ownerNameL.setBounds(40, 350, 150, 40);
        ownerNameL.setFont(new Font("Sarif", Font.BOLD, 18));
        if (!darkwhite)
            ownerNameL.setForeground(Color.WHITE);
        else
            ownerNameL.setForeground(Color.BLACK);

        JLabel ownerName = new JLabel(name);
        ownerName.setBounds(180, 350, 250, 40);
        ownerName.setFont(new Font("Sarif", Font.BOLD, 18));
        if (!darkwhite)
            ownerName.setForeground(Color.WHITE);
        else
            ownerName.setForeground(Color.BLACK);

        JLabel Address = new JLabel("ADDRESS");
        Address.setBounds(40, 390, 200, 50);
        Address.setFont(new Font("Arial", Font.BOLD, 22));

        if (!darkwhite)
            Address.setForeground(Color.WHITE);
        else
            Address.setForeground(Color.BLACK);

        JLabel regionL = new JLabel("Region:");
        regionL.setBounds(40, 440, 100, 40);
        regionL.setFont(new Font("Sarif", Font.BOLD, 18));
        if (!darkwhite)
            regionL.setForeground(Color.WHITE);
        else
            regionL.setForeground(Color.black);

        JLabel region = new JLabel(regionValue);
        region.setBounds(140, 440, 150, 40);
        region.setFont(new Font("Sarif", Font.BOLD, 18));
        if (!darkwhite)
            region.setForeground(Color.WHITE);
        else
            region.setForeground(Color.BLACK);

        JLabel cityL = new JLabel("City:");
        cityL.setBounds(40, 480, 100, 40);
        cityL.setFont(new Font("Sarif", Font.BOLD, 18));
        if (!darkwhite)
            cityL.setForeground(Color.WHITE);
        else
            cityL.setForeground(Color.black);

        JLabel city = new JLabel(cityValue);
        city.setBounds(140, 480, 150, 40);
        city.setFont(new Font("Sarif", Font.BOLD, 18));
        if (!darkwhite)
            city.setForeground(Color.WHITE);
        else
            city.setForeground(Color.BLACK);

        JLabel street1L = new JLabel("Street:");
        street1L.setBounds(40, 520, 100, 40);
        street1L.setFont(new Font("Sarif", Font.BOLD, 18));
        if (!darkwhite)
            street1L.setForeground(Color.WHITE);
        else
            street1L.setForeground(Color.BLACK);

        JLabel street1 = new JLabel(streetValue);
        street1.setBounds(140, 520, 150, 40);
        street1.setFont(new Font("Sarif", Font.BOLD, 18));
        if (!darkwhite)
            street1.setForeground(Color.WHITE);
        else
            street1.setForeground(Color.BLACK);

        JLabel houseDetail = new JLabel("House Detail");
        houseDetail.setBounds(40, 560, 200, 40);
        houseDetail.setFont(new Font("Arial", Font.BOLD, 22));
        if (!darkwhite)
            houseDetail.setForeground(Color.WHITE);
        else
            houseDetail.setForeground(Color.BLACK);
        JLabel houseSizeL = new JLabel("House Size:");
        houseSizeL.setBounds(40, 600, 150, 40);
        houseSizeL.setFont(new Font("Sarif", Font.BOLD, 18));
        if (!darkwhite)
            houseSizeL.setForeground(Color.WHITE);
        else
            houseSizeL.setForeground(Color.BLACK);
        JLabel houseSize = new JLabel(sizeValue);
        houseSize.setBounds(180, 600, 150, 40);
        houseSize.setFont(new Font("Sarif", Font.BOLD, 18));
        if (!darkwhite)
            houseSize.setForeground(Color.WHITE);
        else
            houseSize.setForeground(Color.BLACK);

        JLabel bedroomL = new JLabel("Bedroom Size:");
        bedroomL.setBounds(40, 640, 150, 40);
        bedroomL.setFont(new Font("Sarif", Font.BOLD, 18));
        if (!darkwhite)
            bedroomL.setForeground(Color.WHITE);
        else
            bedroomL.setForeground(Color.BLACK);

        JLabel bedroom = new JLabel(bedroomValue);
        bedroom.setBounds(180, 640, 150, 40);
        bedroom.setFont(new Font("Sarif", Font.BOLD, 18));
        if (!darkwhite)
            bedroom.setForeground(Color.WHITE);
        else
            bedroom.setForeground(Color.BLACK);

        JLabel priceL = new JLabel("Rent Price:");
        priceL.setBounds(40, 680, 150, 40);
        priceL.setFont(new Font("Sarif", Font.BOLD, 18));
        if (!darkwhite)
            priceL.setForeground(Color.WHITE);
        else
            priceL.setForeground(Color.BLACK);

        JLabel price = new JLabel(priceValue);
        price.setBounds(180, 680, 150, 40);
        price.setFont(new Font("Sarif", Font.BOLD, 18));
        if (!darkwhite)
            price.setForeground(Color.WHITE);
        else
            price.setForeground(Color.BLACK);
        JLabel Globicon = new JLabel(new ImageIcon(this.getClass().getResource("add.png")));
        Globicon.setBounds(40, 730, 25, 25);

        JLabel website = new JLabel("Website");
        website.setBounds(70, 723, 200, 40);
        website.setFont(new Font("Sarif", Font.BOLD, 18));
        website.setForeground(new Color(30, 163, 211));


        JLabel ContactOwner = new JLabel("Do You Want To Contact the Owner?");
        ContactOwner.setBounds(360, 390, 300, 40);
        ContactOwner.setFont(new Font("Arial", Font.BOLD, 16));
        if (!darkwhite)
            ContactOwner.setForeground(Color.WHITE);
        else
            ContactOwner.setForeground(Color.BLACK);

        JTextArea messageArea = new JTextArea();
        messageArea.setBounds(360, 450, 300, 150);
        messageArea.setBackground(new Color(201, 200, 200));
        messageArea.setFont(new Font("sarif", Font.BOLD, 16));


        JButton sendMessage = new JButton("Send Message");
        sendMessage.setFont(new Font("sarif", Font.BOLD, 16));
        sendMessage.setBackground(new Color(0, 119, 56));
        sendMessage.setBounds(500, 610, 160, 40);
        sendMessage.setBorderPainted(false);
        sendMessage.setFocusPainted(false);
        sendMessage.setForeground(Color.WHITE);
        sendMessage.setFocusPainted(false);

        JLabel interested = new JLabel("Are you Interested?");
        interested.setBounds(360, 660, 200, 40);
        interested.setFont(new Font("Sarif", Font.BOLD, 16));
        interested.setForeground(new Color(241, 95, 95));

        JLabel watchicon = new JLabel(new ImageIcon(this.getClass().getResource("add.png")));
        watchicon.setBounds(360, 710, 25, 25);

        JLabel addtoWatchLater = new JLabel("Add to WatchLater");
        addtoWatchLater.setBounds(390, 700, 200, 40);
        addtoWatchLater.setFont(new Font("Sarif", Font.BOLD, 18));
        if (!darkwhite)
            addtoWatchLater.setForeground(Color.WHITE);
        else
            addtoWatchLater.setForeground(Color.BLACK);
        JLabel cancel = new JLabel("Cancel");
        cancel.setBounds(600, 720, 100, 30);
        cancel.setFont(new Font("Sarif", Font.BOLD, 18));
        cancel.setForeground(new Color(0, 89, 128));

        cancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                houseInfoFrame.dispose();
            }
        });

        JLabel separatorV = new JLabel();
        separatorV.setBounds(300, 390, 2, 350);
        ImageIcon sepV = new ImageIcon(this.getClass().getResource("separatorInfo.png"));
        separatorV.setIcon(sepV);

        JLabel separatorV1 = new JLabel();
        separatorV1.setBounds(30, 390, 2, 350);
        ImageIcon sepV1 = new ImageIcon(this.getClass().getResource("separatorInfo.png"));
        separatorV1.setIcon(sepV1);

        JLabel separatorH = new JLabel();
        separatorH.setBounds(30, 390, 270, 2);
        ImageIcon sepH = new ImageIcon(this.getClass().getResource("horizontalSeparator.png"));
        separatorH.setIcon(sepH);

        JLabel separatorH2 = new JLabel();
        separatorH2.setBounds(30, 430, 270, 2);
        ImageIcon sepH2 = new ImageIcon(this.getClass().getResource("horizontalSeparator.png"));
        separatorH2.setIcon(sepH2);

        JLabel separatorH3 = new JLabel();
        separatorH3.setBounds(30, 560, 270, 2);
        ImageIcon sepH3 = new ImageIcon(this.getClass().getResource("horizontalSeparator.png"));
        separatorH3.setIcon(sepH3);

        JLabel separatorH4 = new JLabel();
        separatorH4.setBounds(30, 590, 270, 2);
        ImageIcon sepH4 = new ImageIcon(this.getClass().getResource("horizontalSeparator.png"));
        separatorH4.setIcon(sepH4);

        JLabel separatorH5 = new JLabel();
        separatorH5.setBounds(30, 720, 270, 2);
        ImageIcon sepH5 = new ImageIcon(this.getClass().getResource("horizontalSeparator.png"));
        separatorH5.setIcon(sepH5);


        houseInfo.add(cancel);
        houseInfo.add(p1);
        houseInfo.add(ownerNameL);
        houseInfo.add(ownerName);
        houseInfo.add(Address);
        houseInfo.add(regionL);
        houseInfo.add(region);
        houseInfo.add(cityL);
        houseInfo.add(city);
        houseInfo.add(street1L);
        houseInfo.add(street1);
        houseInfo.add(houseDetail);
        houseInfo.add(houseSizeL);
        houseInfo.add(houseSize);
        houseInfo.add(bedroomL);
        houseInfo.add(bedroom);
        houseInfo.add(priceL);
        houseInfo.add(price);
        houseInfo.add(watchicon);
        houseInfo.add(addtoWatchLater);
        houseInfo.add(Globicon);
        houseInfo.add(website);

        houseInfo.add(separatorV);
        houseInfo.add(separatorV1);
        houseInfo.add(separatorH2);
        houseInfo.add(separatorH3);
        houseInfo.add(separatorH4);
        houseInfo.add(separatorH5);
        houseInfo.add(separatorH);

        houseInfo.add(interested);
        houseInfo.add(ContactOwner);
        houseInfo.add(messageArea);
        houseInfo.add(sendMessage);

        houseInfoFrame.add(houseInfo, BorderLayout.CENTER);
        houseInfoFrame.setVisible(true);


    }

    public ImageIcon ResizeImageProfile(BufferedImage image, int width, int height) {

        Image newImg = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon img = new ImageIcon(newImg);
        return img;
    }

}

