import javax.imageio.ImageIO;
import javax.swing.*;
import javax.xml.xpath.XPath;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;

public class Header {
    JButton backBtn;
    HouseInfo houseInfo;
    static boolean darkwhite;
    Post p;
    JLabel scrollerTop;
    JLabel scrollerTopleft;
    JPanel header;
    JPanel fullBody;
    JPanel lowerBody;
    JPanel eastTop;
    JPanel topLowerBody;
    JLabel topsmall;
    SideProfile sp;
    JLabel topLabel;
    JPanel lowerTop;
    JButton[] btns;
    JPanel homeStartpanel;
    JLabel homeStartLabel;
    JPanel mainPanel;
    JLabel homeStartLabelsmall;
    int a = -525;
    int b = 50;
    int c = 625;
    int d = 1200;
    int f = 1775;
    int v = 50;
    int w = 625;
    int x = 1200;
    int y = 1775;
    int z = 2350;
    int counter;
    JPanel filterBtn;
    ArrayList<JPanel> pa = new ArrayList<JPanel>(1);
    Uploadhouse up = new Uploadhouse();
    Uploadhouse uploadhouse[] = new Uploadhouse[5];
    JLabel label;
    JPanel body;
    JPanel Slide[] = new JPanel[5];
    JLabel quality;
    JPanel sideProfile;
    String jdbcURL = "jdbc:postgresql://localhost:5432/CheepDelala";
    String usernamedb = "postgres";
    String password = "Basuismena#123";
    Connection1 connection;
    BufferedImage bimage;
    JButton searchicon;
    JPanel filterpanel;
    JComboBox comboHRegion;
    JComboBox combominPrice;
    JComboBox combomaxPrice;
    JComboBox combobedrooms;
    JComboBox combominArea;
    JComboBox combomaxArea;
    JButton apply;
    JButton closefilter;
    JButton clear;

    static ArrayList<JPanel> posts = new ArrayList<JPanel>();

    Header() {


        connection = new Connection1();

        String checker = "SELECT * FROM uploadhouse ";
        fetchdata(checker);
        try {
            Statement statement = connection.conn.createStatement();

            PreparedStatement preparedStatement = connection.conn.prepareStatement(checker);

            ResultSet results = preparedStatement.executeQuery();
            int i = 0;
            while (results.next()) {
                uploadhouse[i] = new Uploadhouse();
                uploadhouse[i].id = results.getInt("id");
                uploadhouse[i].uploadhousesize = results.getString("uploadhousesize");
                uploadhouse[i].uploadregion = results.getString("uploadregion");
                uploadhouse[i].nobedrooms = results.getString("nobedrooms");
                uploadhouse[i].uploadcity = results.getString("uploadcity");
                uploadhouse[i].uploadprice = results.getString("uploadprice");
                uploadhouse[i].path = results.getBinaryStream("uploadimage");
                uploadhouse[i].bufferedImage = ImageIO.read(uploadhouse[i].path);
                uploadhouse[i].uploadimage = ResizeImageProfile(uploadhouse[i].bufferedImage, 550, 450);
                i += 1;
                if (i == 5) {
                    break;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error to fetch the data");
            throw new RuntimeException(e);
        } catch (IOException e) {

            throw new RuntimeException(e);
        }

        body = new JPanel();
        body.setPreferredSize(new Dimension(400, 300));
        body.setLayout(new BorderLayout());
        body.setBackground(new Color(30, 31, 34));

        Loading m = new Loading();


        body.add(m.getLoadingpanel(), BorderLayout.CENTER);
        // header.setBackground(new Color(30, 31, 34));
        header = new JPanel();
        header.setBackground(new Color(30, 31, 34));
        header.setPreferredSize(new Dimension(400, 50));
        header.setLayout(null);

        Icon iconb = new ImageIcon(this.getClass().getResource("circlelanb.png"));

        backBtn = new JButton();

        backBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        backBtn.setBounds(25, 10, 30, 30);
        backBtn.setBorderPainted(false);
        backBtn.setContentAreaFilled(false);
        backBtn.setFocusPainted(false);
        backBtn.setIcon(iconb);
        backBtn.setForeground(Color.white);
        backBtn.setFont(new Font("Sarif", Font.BOLD, 16));


        label = new JLabel("አ");
        label.setBounds(35, 10, 30, 30);
        label.setFont(new Font("Abyssinica SIL", Font.BOLD, 16));
        label.setForeground(Color.white);


        Icon icon = new ImageIcon(this.getClass().getResource("filterw.png"));
        searchicon = new JButton(icon);
        searchicon.setText("Filter");
        searchicon.setForeground(Color.WHITE);
        searchicon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        searchicon.setBounds(200, 5, 150, 40);
        searchicon.setContentAreaFilled(false);
        searchicon.setFocusPainted(false);
        searchicon.setBorder(BorderFactory.createLineBorder(Color.WHITE));

        filterpanel = new JPanel();
        filterpanel.setBounds(200, 50, 850, 240);
        filterpanel.setBackground(new Color(49, 50, 58));
        filterpanel.setLayout(null);
        filterpanel.setVisible(false);

        String regions[] = {"Region", "Addis Ababa", "Tigray", "Afar", "Amhara", "Oromia", "Somali", "Benishagul-Gumuz", "SNNPR", "Gambella", "Harari"};
        String minPrices[] = {"Min Price", "10000", "20000", "30000", "50000", "100000", "200000", "300000", "500000", "1000000"};
        String maxPrices[] = {"Max price", "10000", "20000", "30000", "50000", "100000", "200000", "300000", "500000", "1000000"};
        String bedrooms[] = {"Bed room", "0", "1", "2", "3", "4", "5"};
        String minArea[] = {"Min Area", "100", "200", "300", "400", "500", "1000"};
        String maxArea[] = {"Max Area", "100", "200", "300", "400", "500", "1000"};

        Color fontColor = new Color(245, 245, 245);


        comboHRegion = new JComboBox(regions);
        comboHRegion.setFont(new Font("Abyssinica SIL", Font.PLAIN, 14));
        comboHRegion.setBounds(10, 52, 200, 40);
        comboHRegion.setBackground(new Color(49, 50, 58));
        comboHRegion.setForeground(fontColor);
        comboHRegion.setOpaque(false);
        combominPrice = new JComboBox(minPrices);
        combominPrice.setBounds(220, 52, 200, 40);
        combominPrice.setFont(new Font("Abyssinica SIL", Font.PLAIN, 14));
        combominPrice.setBackground(new Color(49, 50, 58));
        combominPrice.setOpaque(false);
        combominPrice.setForeground(fontColor);
        combomaxPrice = new JComboBox(maxPrices);
        combomaxPrice.setBounds(430, 52, 200, 40);
        combomaxPrice.setFont(new Font("Abyssinica SIL", Font.PLAIN, 14));
        combomaxPrice.setBackground(new Color(49, 50, 58));
        combomaxPrice.setOpaque(false);
        combomaxPrice.setForeground(fontColor);
        combobedrooms = new JComboBox(bedrooms);
        combobedrooms.setBounds(640, 52, 200, 40);
        combobedrooms.setFont(new Font("Abyssinica SIL", Font.PLAIN, 14));
        combobedrooms.setBackground(new Color(49, 50, 58));
        combobedrooms.setOpaque(false);
        combobedrooms.setForeground(fontColor);
        combominArea = new JComboBox(minArea);
        combominArea.setBounds(10, 92, 200, 40);
        combominArea.setFont(new Font("Abyssinica SIL", Font.PLAIN, 14));
        combominArea.setBackground(new Color(49, 50, 58));
        combominArea.setOpaque(false);
        combominArea.setForeground(fontColor);
        combomaxArea = new JComboBox(maxArea);
        combomaxArea.setBounds(220, 92, 200, 40);
        combomaxArea.setFont(new Font("Abyssinica SIL", Font.PLAIN, 14));
        combomaxArea.setBackground(new Color(49, 50, 58));
        combomaxArea.setOpaque(false);
        combomaxArea.setForeground(fontColor);

        apply = new JButton();
        apply.setText("Apply");
        apply.setForeground(Color.WHITE);
        apply.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        apply.setBounds(630, 140, 100, 40);
        apply.setContentAreaFilled(false);
        apply.setFocusPainted(false);
        apply.setBorder(BorderFactory.createLineBorder(Color.WHITE));

        clear = new JButton();
        clear.setText("Clear");
        clear.setForeground(Color.WHITE);
        clear.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        clear.setBounds(740, 140, 100, 40);
        clear.setContentAreaFilled(false);
        clear.setFocusPainted(false);
        clear.setBorder(BorderFactory.createLineBorder(Color.WHITE));

        Icon closefilterIcon = new ImageIcon(this.getClass().getResource("close.png"));
        closefilter = new JButton(closefilterIcon);
        closefilter.setForeground(Color.WHITE);
        closefilter.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        closefilter.setBounds(810, 10, 35, 30);
        closefilter.setContentAreaFilled(false);
        closefilter.setFocusPainted(false);

        filterpanel.add(apply);
        filterpanel.add(clear);
        filterpanel.add(closefilter);
        filterpanel.add(comboHRegion);
        filterpanel.add(combominPrice);
        filterpanel.add(combomaxPrice);
        filterpanel.add(combobedrooms);
        filterpanel.add(combominArea);
        filterpanel.add(combomaxArea);

        header.add(filterpanel);

        searchicon.addActionListener(e -> {
            header.setPreferredSize(new Dimension(400, 250));
            filterpanel.setVisible(true);
        });
        closefilter.addActionListener(e -> {
            header.setPreferredSize(new Dimension(400, 50));
            filterpanel.setVisible(false);
        });

        ImageIcon logo = new ImageIcon(this.getClass().getResource("logo.png"));
        JLabel logol = new JLabel();
        logol.setBounds(900, 0, 210, 50);
        logol.setIcon(logo);

        header.add(logol);
        header.add(searchicon);
        header.add(label);
        header.add(backBtn);

        fullBody = new JPanel();
        fullBody.setBackground(new Color(30, 31, 34));
        fullBody.setPreferredSize(new Dimension(400, 1500));
        fullBody.setLayout(new BorderLayout());

        lowerBody = new JPanel();
        lowerBody.setBackground(new Color(30, 31, 34));
        lowerBody.setPreferredSize(new Dimension(800, 550));
        lowerBody.setLayout(new BorderLayout());

        eastTop = new JPanel();
        eastTop.setBackground(new Color(30, 31, 34));
        eastTop.setPreferredSize(new Dimension(50, 100));
        eastTop.setLayout(null);

        ImageIcon eastIcon = new ImageIcon(this.getClass().getResource("next.png"));
        scrollerTop = new JLabel(eastIcon);
        scrollerTop.setBounds(0, 240, 50, 50);


        eastTop.add(scrollerTop);


        topLowerBody = new JPanel();
        topLowerBody.setBackground(new Color(30, 31, 34));
        topLowerBody.setLayout(null);

        ImageIcon westIcon = new ImageIcon(this.getClass().getResource("back.png"));
        scrollerTopleft = new JLabel(westIcon);
        scrollerTopleft.setBounds(0, 250, 30, 30);


        topLowerBody.add(scrollerTopleft);

        topLabel = new JLabel("Cheap Delala");
        topLabel.setForeground(Color.white);
        topLabel.setFont(new Font("Abyssinica SIL", Font.PLAIN, 32));
        topLabel.setBounds(100, 30, 200, 30);

        ImageIcon toplabelI = new ImageIcon(this.getClass().getResource("winking.png"));
        JLabel topLabelIcon = new JLabel();
        topLabelIcon.setIcon(toplabelI);
        topLabelIcon.setBounds(50, 30, 30, 30);

        topsmall = new JLabel("What's happening");
        topsmall.setForeground(Color.white);
        topsmall.setFont(new Font("Abyssinica SIL", Font.PLAIN, 22));
        topsmall.setBounds(50, 70, 200, 30);

        lowerTop = new JPanel();
        lowerTop.setPreferredSize(new Dimension(300, 100));
        lowerTop.setBackground(new Color(30, 31, 34));

        btns = new JButton[3];
        for (int i = 0; i < 3; i++) {
            btns[i] = new JButton();
            btns[i].setPreferredSize(new Dimension(250, 50));
            btns[i].setFont(new Font("Abyssinica SIL", Font.PLAIN, 18));
            btns[i].setContentAreaFilled(false);
            btns[i].setFocusPainted(false);
            btns[i].setForeground(Color.WHITE);
            btns[i].setBorder(BorderFactory.createLineBorder(Color.white));
            btns[i].setBackground(new Color(75, 73, 73, 100));

            lowerTop.add(btns[i]);
        }
        btns[0].setText("AVAILABLE HOUSES");
        btns[1].setText("GET IT CHEAP");
        btns[2].setText("ABOUT US");

        btns[0].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btns[0].setContentAreaFilled(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btns[0].setContentAreaFilled(false);
            }
        });
        btns[1].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btns[1].setContentAreaFilled(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btns[1].setContentAreaFilled(false);
            }
        });
        btns[2].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btns[2].setContentAreaFilled(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btns[2].setContentAreaFilled(false);
            }
        });

        lowerBody.add(lowerTop, BorderLayout.SOUTH);
        lowerBody.add(eastTop, BorderLayout.EAST);

        topLowerBody.add(topsmall);
        topLowerBody.add(topLabel);
        topLowerBody.add(topLabelIcon);


        JPanel recentPreview = new JPanel();
        recentPreview.setBackground(new Color(223, 232, 255));
        recentPreview.setBounds(50, 130, 550, 300);
        recentPreview.setLayout(null);

        JLabel price1 = new JLabel();
        price1.setForeground(Color.BLACK);
        price1.setFont(new Font("SERIF", Font.BOLD, 32));
        price1.setBounds(10, 10, 200, 30);
        if (!uploadhouse[0].uploadprice.equals(null))
            price1.setText("Price: " + uploadhouse[0].uploadprice + "$");
        recentPreview.add(price1);

        JLabel rp1 = new JLabel();
        rp1.setBounds(0, 0, 600, 300);
        rp1.setIcon((ResizeImageProfile(uploadhouse[0].uploadimage, 600, 300)));
        recentPreview.add(rp1);

        JPanel recentPreview2 = new JPanel();
        recentPreview2.setBackground(new Color(223, 232, 255));
        recentPreview2.setBounds(625, 130, 550, 300);
        recentPreview2.setLayout(null);

        JLabel price2 = new JLabel();
        price2.setForeground(Color.BLACK);
        price2.setFont(new Font("SERIF", Font.BOLD, 32));
        price2.setBounds(10, 10, 200, 30);
        price2.setText("Price: " + uploadhouse[1].uploadprice + "$");
        recentPreview2.add(price2);

        JLabel rp2 = new JLabel();
        rp2.setBounds(0, 0, 600, 300);
        rp2.setIcon((ResizeImageProfile(uploadhouse[1].uploadimage, 600, 300)));
        recentPreview2.add(rp2);

        JPanel recentPreview3 = new JPanel();
        recentPreview3.setBackground(new Color(223, 232, 255));
        recentPreview3.setBounds(1200, 130, 550, 300);
        recentPreview3.setLayout(null);

        JLabel price3 = new JLabel();
        price3.setForeground(Color.BLACK);
        price3.setFont(new Font("SERIF", Font.BOLD, 32));
        price3.setBounds(10, 10, 200, 30);
        price3.setText("Price: " + uploadhouse[2].uploadprice + "$");
        recentPreview3.add(price3);

        JLabel rp3 = new JLabel();
        rp3.setBounds(0, 0, 600, 300);
        rp3.setIcon((ResizeImageProfile(uploadhouse[2].uploadimage, 600, 300)));
        recentPreview3.add(rp3);

        JPanel recentPreview4 = new JPanel();
        recentPreview4.setBackground(new Color(223, 232, 255));
        recentPreview4.setBounds(1775, 130, 550, 300);
        recentPreview4.setLayout(null);

        JLabel price4 = new JLabel();
        price4.setForeground(Color.BLACK);
        price4.setFont(new Font("SERIF", Font.BOLD, 32));
        price4.setBounds(10, 10, 200, 30);
        price4.setText("Price: " + uploadhouse[3].uploadprice + "$");
        recentPreview4.add(price4);

        JLabel rp4 = new JLabel();
        rp4.setBounds(0, 0, 600, 300);
        rp4.setIcon((ResizeImageProfile(uploadhouse[3].uploadimage, 600, 300)));
        recentPreview4.add(rp4);

        JPanel recentPreview5 = new JPanel();
        recentPreview5.setBackground(new Color(223, 232, 255));
        recentPreview5.setBounds(2350, 130, 550, 300);
        recentPreview5.setLayout(null);

        JLabel price5 = new JLabel();
        price5.setForeground(Color.BLACK);
        price5.setFont(new Font("SERIF", Font.BOLD, 32));
        price5.setBounds(10, 10, 200, 30);
        price5.setText("Price: " + uploadhouse[4].uploadprice + "$");
        recentPreview5.add(price5);

        JLabel rp5 = new JLabel();
        rp5.setBounds(0, 0, 600, 300);
        rp5.setIcon((ResizeImageProfile(uploadhouse[4].uploadimage, 600, 300)));
        recentPreview5.add(rp5);

        scrollerTop.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {


                new Timer(1, e1 -> {
                    if (z == 625) {
                        scrollerTop.setEnabled(false);
                        scrollerTopleft.setEnabled(true);
                        ((Timer) e1.getSource()).stop();
                    }
                    if (scrollerTop.isEnabled()) {
                        if (v != a)
                            v -= 25;
                        if (w != b)
                            w -= 25;
                        if (x != c)
                            x -= 25;
                        if (y != d)
                            y -= 25;
                        if (z != f)
                            z -= 25;
                        else {
                            a -= 575;
                            b -= 575;
                            c -= 575;
                            d -= 575;
                            f -= 575;
                            ((Timer) e1.getSource()).stop();
                        }

                        recentPreview.setLocation(v, 130);
                        recentPreview2.setLocation(w, 130);
                        recentPreview3.setLocation(x, 130);
                        recentPreview4.setLocation(y, 130);
                        recentPreview5.setLocation(z, 130);
                    }
                }).start();
            }
        });


        scrollerTopleft.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                new Timer(1, e12 -> {
                    if (v == 50) {
                        scrollerTopleft.setEnabled(false);
                        scrollerTop.setEnabled(true);
                        ((Timer) e12.getSource()).stop();
                    }
                    if (scrollerTopleft.isEnabled()) {
                        if (v != a + 575)
                            v += 25;
                        if (w != b + 575)
                            w += 25;
                        if (x != c + 575)
                            x += 25;
                        if (y != d + 575)
                            y += 25;
                        if (z != f + 575)
                            z += 25;
                        else {
                            a += 575;
                            b += 575;
                            c += 575;
                            d += 575;
                            f += 575;
                            ((Timer) e12.getSource()).stop();
                        }

                        recentPreview.setLocation(v, 130);
                        recentPreview2.setLocation(w, 130);
                        recentPreview3.setLocation(x, 130);
                        recentPreview4.setLocation(y, 130);
                        recentPreview5.setLocation(z, 130);
                    }
                }).start();

            }
        });
//        JPanel filter = new JPanel();
//        filter.setBounds(850,130,300, 300);
//        filter.setBackground(new Color(255, 0, 0));
//        filter.setLayout(null);
//
//        JPanel filter1 = new JPanel();
//        filter1.setBounds(0,0, 300, 55);
//        filter1.setBackground(new Color(63, 63, 63));
//        filter1.setLayout(new FlowLayout());
//
//        JPanel filter2 = new JPanel();
//        filter2.setBounds(0,55,300,345);
//        filter2.setBackground(new Color(63, 63, 63));
//        filter2.setLayout(new FlowLayout());


//        JLabel filterl = new JLabel("Filter");
//        filterl.setForeground(fontColor);
//        filterl.setPreferredSize(new Dimension(150, 55));
//        filterl.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
//
//        String regions[] = {"Region","Addis Ababa", "Tigray", "Afar", "Amhara", "Oromia", "Somali", "Benishagul-Gumuz", "SNNPR", "Gambella", "Harari"};
//        String minPrices[] = {"Min Price", "10000", "20000", "30000", "50000", "100000", "200000", "300000", "500000", "1000000"};
//        String maxPrices[] = {"Max price","10000", "20000", "30000", "50000", "100000", "200000", "300000", "500000", "1000000"};
//        String bedrooms[] = {"Bed room","0", "1", "2", "3", "4", "5"};
//        String minArea[] = {"Min Area","100", "200", "300", "400", "500", "1000"};
//        String maxArea[] = {"Max Area","100", "200", "300", "400", "500", "1000"};
//
//        JComboBox comboHRegion = new JComboBox(regions);
//        comboHRegion.setFont(new Font("sarif", Font.BOLD,14));
//        comboHRegion.setPreferredSize(new Dimension(120, 50));
//        comboHRegion.setBackground(new Color(0,0,0));
//        comboHRegion.setForeground(fontColor);
//        comboHRegion.setOpaque(false);
//        JComboBox combominPrice = new JComboBox(minPrices);
//        combominPrice.setPreferredSize(new Dimension(120, 50));
//        combominPrice.setFont(new Font("sarif", Font.BOLD,14));
//        combominPrice.setBackground(new Color(0,0,0));
//        combominPrice.setOpaque(false);
//        combominPrice.setForeground(fontColor);
//        JComboBox combomaxPrice = new JComboBox(maxPrices);
//        combomaxPrice.setPreferredSize(new Dimension(120, 50));
//        combomaxPrice.setFont(new Font("sarif", Font.BOLD,14));
//        combomaxPrice.setBackground(new Color(0,0,0));
//        combomaxPrice.setOpaque(false);
//        combomaxPrice.setForeground(fontColor);
//        JComboBox combobedrooms = new JComboBox(bedrooms);
//        combobedrooms.setPreferredSize(new Dimension(120, 50));
//        combobedrooms.setFont(new Font("sarif", Font.BOLD,14));
//        combobedrooms.setBackground(new Color(0,0,0));
//        combobedrooms.setOpaque(false);
//        combobedrooms.setForeground(fontColor);
//        JComboBox combominArea = new JComboBox(minArea);
//        combominArea.setPreferredSize(new Dimension(120, 50));
//        combominArea.setFont(new Font("sarif", Font.BOLD,14));
//        combominArea.setBackground(new Color(0,0,0));
//        combominArea.setOpaque(false);
//        combominArea.setForeground(fontColor);
//        JComboBox combomaxArea = new JComboBox(maxArea);
//        combomaxArea.setPreferredSize(new Dimension(120, 50));
//        combomaxArea.setFont(new Font("sarif", Font.BOLD,14));
//        combomaxArea.setBackground(new Color(0,0,0));
//        combomaxArea.setOpaque(false);
//        combomaxArea.setForeground(fontColor);
//
//        filter2.add(comboHRegion); filter2.add(combobedrooms);
//        filter2.add(combominPrice); filter2.add(combomaxPrice);
//        filter2.add(combominArea); filter2.add(combomaxArea);
//
//
//        filterBtn = new JPanel();
//        filterBtn.setPreferredSize(new Dimension(230, 45));
//        filterBtn.setBackground(new Color(116, 117, 116));
//        filterBtn.setLayout(new FlowLayout());
//        JLabel filtericon = new JLabel(new ImageIcon(getClass().getResource("filter.png")));
//        filterBtn.add(filtericon);
//        filterBtn.addMouseListener(new MouseListener() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                String fregion;
//                if ((String)comboHRegion.getSelectedItem() == regions[0]){
//                    fregion = "";
//                }
//                else fregion = " and uploadregion  = '"+(String)comboHRegion.getSelectedItem()+"'";
//                String fminPrice;
//                if ((String)combominPrice.getSelectedItem() == minPrices[0]){
//                    fminPrice = "";
//                }
//                else fminPrice = " and uploadprice >= " + (String)combominPrice.getSelectedItem();
//                String fmaxPrice;
//                if ((String)combomaxPrice.getSelectedItem() == maxPrices[0]){
//                    fmaxPrice = "";
//                }
//                else fmaxPrice = " and uploadprice <= " + (String)combomaxPrice.getSelectedItem();
//                String fbedrooms;
//                if ((String)combobedrooms.getSelectedItem() == bedrooms[0]){
//                    fbedrooms = "";
//                }
//                else fbedrooms = " and nobedrooms  = " +(String)combobedrooms.getSelectedItem();
//                String fminArea;
//                if ((String)combominArea.getSelectedItem() == minArea[0]){
//                    fminArea = "";
//                }
//                else fminArea = " and uploadhousesize >= " + (String)combominArea.getSelectedItem();
//                String fmaxArea;
//                if ((String)combomaxArea.getSelectedItem() == maxArea[0]){
//                    fmaxArea = "";
//                }
//                else fmaxArea = " and uploadhousesize <= " + (String)combomaxArea.getSelectedItem();
//
//                String query = "SELECT * FROM uploadhouse WHERE id >= 0"+fregion+""+fminPrice+""+fmaxPrice+""+fmaxArea+""+fbedrooms+""+fminArea+ ""+fmaxArea;
//
//
//                fetchdata(query);
//                System.out.println(query);
//            }
//
//            @Override
//            public void mousePressed(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseReleased(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                filterBtn.setBackground(new Color(126, 128, 126, 82));
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//                filterBtn.setBackground(new Color(116, 117, 116, 82));
//            }
//        });
//
//        filter1.add(filterl);
//        filter.add(filter1);
//        filter.add(filter2);
//        filter2.add(filterBtn);

        mainPanel = new JPanel();
        mainPanel.setBackground(new Color(30, 31, 34));
        mainPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));

        homeStartpanel = new JPanel();
        homeStartpanel.setPreferredSize(new Dimension(1600, 70));
        homeStartpanel.setLayout(null);
        homeStartpanel.setBackground(new Color(30, 31, 34));

        homeStartLabel = new JLabel("Receantly added");
        homeStartLabel.setForeground(Color.WHITE);
        homeStartLabel.setBounds(20, 0, 250, 50);
        homeStartLabel.setFont(new Font("Abyssinica SIL", Font.PLAIN, 22));

        homeStartLabelsmall = new JLabel("Explore houses with you specifications! (you can use filter)");
        homeStartLabelsmall.setForeground(Color.WHITE);
        homeStartLabelsmall.setBounds(20, 40, 500, 20);
        homeStartLabelsmall.setFont(new Font("Abyssinica SIL", Font.PLAIN, 16));

        homeStartpanel.add(homeStartLabel);
        homeStartpanel.add(homeStartLabelsmall);

        mainPanel.add(homeStartpanel);

        ImageIcon i1;
        counter = 0;
        JLabel l1;
        l1 = new JLabel(ResizeImageProfile(uploadhouse[counter].uploadimage, 600, 300));
        l1.setBounds(0, 0, 600, 300);


        //   topLowerBody.add(filter);
        topLowerBody.add(recentPreview);
        topLowerBody.add(recentPreview2);
        topLowerBody.add(recentPreview3);
        topLowerBody.add(recentPreview4);
        topLowerBody.add(recentPreview5);


        lowerBody.add(topLowerBody, BorderLayout.CENTER);
        JScrollPane scroller = new JScrollPane(fullBody);
        scroller.setPreferredSize(new Dimension(0, 0));
        scroller.getVerticalScrollBar().setPreferredSize(new Dimension(5, 0));
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroller.getVerticalScrollBar().setUnitIncrement(16);

//////////////////////////////////////////detail about owner//////////////////////////////////////
        sp = new SideProfile();
        sideProfile = sp.getSideProfile();
        sideProfile.setVisible(false);
        body.add(BorderLayout.EAST, sideProfile);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////


        try {
            String sql2 = "SELECT id,uploadurl,uploademail,uploadphoneno, uploadfirstname, uploadmiddlename, uploadlastname, uploadimage, uploadprice FROM uploadhouse";
            String imsql = "SELECT image From users WHERE username=?";

            PreparedStatement statement = connection.conn.prepareStatement(sql2);

            ResultSet resultSet = statement.executeQuery();


            while (resultSet.next()) {
                String first_name = resultSet.getString("uploadfirstname");
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

                BufferedImage bimage2 = ImageIO.read(pppath);

                p = new Post(full_name, iIcon, bimage2);
                p.idgeter(id);
                p.priceLabel.setText("Price: " + price + "$");


                Colors usforwl = new Colors();


                p.nameLabel.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {

                        ImageIcon iIcon2 = ResizeImageProfile(bimage2, 120, 120);
                        sp.fullname.setText(full_name);
                        sp.username.setText(user_name);
                        sp.email.setText(email);
                        sp.phone.setText(phono);
                        sp.profile.setIcon(iIcon2);
//                        sp.username.setText();

                        sideProfile.setVisible(true);
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        p.nameLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    }

                });

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        for (JPanel p : posts) {
            mainPanel.add(p);
        }


        fullBody.add(mainPanel, BorderLayout.CENTER);
        fullBody.add(lowerBody, BorderLayout.NORTH);

        body.add(scroller, BorderLayout.CENTER);
        body.add(header, BorderLayout.NORTH);

    }

    public JPanel getHeaderPanel() {
        return body;
    }

    public ImageIcon ResizeImageProfile(Image image, int width, int height) {

        Image newImg = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon img = new ImageIcon(newImg);
        return img;
    }

    public ImageIcon ResizeImageProfile(ImageIcon image, int width, int height) {

        Image newImg = image.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon img = new ImageIcon(newImg);
        return img;
    }

    public ImageIcon ResizeImageProfile(BufferedImage image, int width, int height) {

        Image newImg = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon img = new ImageIcon(newImg);
        return img;
    }

    public void fetchdata(String query) {
        JLabel l2 = new JLabel();
        pa.clear();
        try {
            Statement statement = connection.conn.createStatement();

            PreparedStatement preparedStatement = connection.conn.prepareStatement(query);

            ResultSet results = preparedStatement.executeQuery();
            while (results.next()) {
                up.id = results.getInt("id");
                up.uploadhousesize = results.getString("uploadhousesize");
                up.uploadregion = results.getString("uploadregion");
                up.nobedrooms = results.getString("nobedrooms");
                up.uploadcity = results.getString("uploadcity");
                up.uploadprice = results.getString("uploadprice");
                up.path = results.getBinaryStream("uploadimage");
                up.bufferedImage = ImageIO.read(up.path);
                Image img = up.bufferedImage.getScaledInstance(600, 500, Image.SCALE_SMOOTH);
                up.uploadimage = new ImageIcon(img);
                l2.setIcon(up.uploadimage);
                l2.setBounds(0, 0, 600, 500);
                JPanel p1 = new JPanel();
                p1.setPreferredSize(new Dimension(600, 500));
                p1.setLayout(null);
                p1.add(l2);
            }
        } catch (SQLException e) {
            System.out.println("Error to fetch the data");
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
