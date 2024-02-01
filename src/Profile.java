import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.Buffer;
import java.sql.*;

public class Profile {
    JLabel upImages[] = new JLabel[12];
    String path2;
    String fullname;
    BufferedImage pImage;
    JPanel mainPanel, editPanel, cardPane, pPanel;
    CardLayout card;
    JLabel changeProfile, eprofile; // to be deleted
    String fname, mname, lname, uname, password, email, phoneNumber = "+251929248080";
    InputStream path; //to be deleted
    ImageIcon profileImage;
    Connection1 connection;
    JPanel p[] = new JPanel[12];
    JTextField usernameText;
    int i;
    int j = 0;
    String Gusername;

    Profile() {
    }

    public String name() {
        return Gusername;
    }


    Profile(String Gusername) {

        connection = new Connection1();

        String un = "SELECT * FROM loginchecker";
        String last = "";
        try {
            PreparedStatement stmt = connection.conn.prepareStatement(un);
            ResultSet results = stmt.executeQuery();

            while (results.next()) {
                last = results.getString("username");
                System.out.println(last);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        this.Gusername = last;
        System.out.println(last);
        getUserData();
        goo();
//        setPath(path2);
    }

    public void goo() {
        pPanel = new JPanel();
        pPanel.setLayout(new BorderLayout());
        pPanel.setBackground(Color.WHITE);
        pPanel.setBounds(0, 0, 333, 333);
        ;

////////////////////////////////////////////////
        ////      main panel      /////
////////////////////////////////////////////////


        mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(1200, 800));
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);

        SpringLayout topLayout = new SpringLayout();
        JPanel topPanel = new JPanel();
        topPanel.setLayout(topLayout);
        topPanel.setBackground(new Color(248, 248, 248));
        topPanel.setPreferredSize(new Dimension(1300, 153));

        JPanel menuPlusBorder = new JPanel();
        menuPlusBorder.setLayout(new BorderLayout());
        menuPlusBorder.setBackground(new Color(255, 255, 255));
        menuPlusBorder.setPreferredSize(new Dimension(600, 32));

        JPanel upperMenuBorder = new JPanel();
        upperMenuBorder.setBackground(Color.black);
        upperMenuBorder.setPreferredSize(new Dimension(600, 1));

        JPanel lowerMenuBorder = new JPanel();
        lowerMenuBorder.setBackground(Color.black);
        lowerMenuBorder.setPreferredSize(new Dimension(600, 1));

        JPanel menu = new JPanel();
        SpringLayout layout = new SpringLayout();
        menu.setLayout(layout);
        menu.setBackground(new Color(248, 248, 248));
        menu.setPreferredSize(new Dimension(1300, 30));

        menuPlusBorder.add(BorderLayout.NORTH, upperMenuBorder);
        menuPlusBorder.add(BorderLayout.CENTER, menu);
        menuPlusBorder.add(BorderLayout.SOUTH, lowerMenuBorder);

        JLabel pp = new JLabel();
        pp.setIcon(profileImage);
        pp.setBounds(10, 10, 118, 118);

        JLabel ppFrame = new JLabel(new ImageIcon(this.getClass().getResource("frame120w.png")));
        ppFrame.setBounds(10, 10, 120, 120);

        JPanel ppAndFrame = new JPanel();
        ppAndFrame.setLayout(null);
        ppAndFrame.setPreferredSize(new Dimension(150, 150));
        ppAndFrame.setBackground(new Color(248, 248, 248));

        ppAndFrame.add(ppFrame);
        ppAndFrame.add(pp);
        topPanel.add(ppAndFrame);

        JPanel profileInfo = new JPanel();
        profileInfo.setLayout(null);
        profileInfo.setPreferredSize(new Dimension(300, 153));
        profileInfo.setBackground(new Color(247, 248, 246));

        Font f = new Font("Sarif", Font.BOLD, 15);

        JLabel username = new JLabel("@" + uname);
        username.setFont(new Font("Sarif", Font.BOLD, 14));
        username.setBounds(40, 75, 100, 25);
        username.setForeground(new Color(28, 36, 47));
        profileInfo.add(username);

//        profileInfo.add(editIcon);

        int rentNumber = 3;
        JLabel Rent = new JLabel(rentNumber + " Registration");
        Rent.setForeground(new Color(28, 36, 47));
        Rent.setFont(new Font("Sarif", Font.PLAIN, 12));
        Rent.setBounds(40, 75, 100, 20);
//        profileInfo.add(Rent);

        int ownNum = 0;
        JLabel Own = new JLabel(ownNum + " Registration");
        Own.setForeground(new Color(28, 36, 47));
        Own.setFont(new Font("Sarif", Font.PLAIN, 12));
        Own.setBounds(40, 160, 100, 20);
//        profileInfo.add(Own);

        fullname = fname.toUpperCase() + " " + mname.toUpperCase() + " " + lname.toUpperCase();
        JLabel name = new JLabel(fullname);
        name.setForeground(new Color(28, 36, 47));
        name.setFont(new Font("SansSerif", Font.BOLD, 18));
        name.setBounds(40, 120, 300, 20);
        profileInfo.add(name);

        JLabel editIcon = new JLabel(new ImageIcon(super.getClass().getResource("ChangeProfile50.png")));
//        editIcon.setPreferredSize(new Dimension(50,52));
        editIcon.setBounds(75, 0, 50, 52);

        JLabel pnumber = new JLabel("PHONE NO: " + phoneNumber);
        pnumber.setForeground(new Color(28, 36, 47));
        pnumber.setFont(new Font("Sarif", Font.BOLD, 12));
//        pnumber.setPreferredSize(new Dimension(180, 20));
        pnumber.setBounds(10, 80, 180, 20);
//        profileInfo.add(pnumber);

        JPanel topEastBar = new JPanel();
        topEastBar.setLayout(null);
        topEastBar.setPreferredSize(new Dimension(200, 100));
        topEastBar.setBackground(new Color(255, 255, 255));
        topEastBar.add(pnumber);
        topEastBar.add(editIcon);


        topPanel.add(profileInfo);
        topPanel.add(topEastBar);
//        topPanel.add(pnumber);
//        topPanel.add(editIcon);

//        topPanel.add(BorderLayout.CENTER, profileInfo);
//
        topLayout.putConstraint(SpringLayout.EAST, topEastBar, -50, SpringLayout.EAST, topPanel);
        topLayout.putConstraint(SpringLayout.NORTH, topEastBar, 20, SpringLayout.NORTH, topPanel);

        topLayout.putConstraint(SpringLayout.WEST, ppAndFrame, 15, SpringLayout.WEST, topPanel);
        topLayout.putConstraint(SpringLayout.NORTH, ppAndFrame, 10, SpringLayout.NORTH, topPanel);
        topLayout.putConstraint(SpringLayout.WEST, profileInfo, 20, SpringLayout.EAST, ppAndFrame);
        topLayout.putConstraint(SpringLayout.NORTH, profileInfo, -10, SpringLayout.NORTH, topPanel);
//        topLayout.putConstraint(SpringLayout.EAST, editIcon, 90, SpringLayout.EAST, topPanel);
//        topLayout.putConstraint(SpringLayout.NORTH, editIcon, 20, SpringLayout.NORTH, topPanel);
//        topLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, pnumber, 20, SpringLayout.HORIZONTAL_CENTER, editIcon);
//        topLayout.putConstraint(SpringLayout.NORTH, pnumber, 30, SpringLayout.SOUTH, topPanel);


        JPanel page = new JPanel();
        page.setLayout(new BorderLayout());
        page.setBackground(Color.red);

//        CardLayout preCard = new CardLayout();
//        JPanel prePage = new JPanel();
//        prePage.setLayout(preCard);
//        prePage.setBackground(Color.WHITE);

        JPanel post = new JPanel();
        SpringLayout postLayout = new SpringLayout();
        post.setLayout(postLayout);
        post.setBackground(new Color(28, 36, 47));
        post.setPreferredSize(new Dimension(1400, 700));

        ///////////////////////
        //  POST   //
        ///////////////////////

//        for (i = 0; i < 12; i++) {
//            p[i] = new JPanel();
//            p[i].setPreferredSize(new Dimension(160, 160));
//            p[i].setLayout(null);
//            p[i].setBackground(new Color(30, 31, 34));
//
//            upImages[i] = new JLabel(new ImageIcon(this.getClass().getResource("Cross.png")));
//            upImages[i].setForeground(Color.WHITE);
//            upImages[i].setBounds(0, 0,170,170);
//
//            p[i].add(upImages[i]);
//            post.add(p[i]);
//        }
//
//        JButton addImgBtn = new JButton("ADD IMAGE");
//        addImgBtn.setFont(new Font("Sarif",Font.BOLD,16));
//        addImgBtn.setBackground(new Color(0, 150,50));
//        addImgBtn.setBorderPainted(false);
//        addImgBtn.setFocusPainted(false);
//        addImgBtn.setForeground(new Color(248,248,248));
//        addImgBtn.setFocusPainted(false);
//        addImgBtn.addActionListener(e -> {
//            JFileChooser file = new JFileChooser();
//            file.setCurrentDirectory(new File(System.getProperty("user.home")));
//            FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg","gif","png");
//            file.addChoosableFileFilter(filter);
//            int result = file.showSaveDialog(null);
//            if(result == JFileChooser.APPROVE_OPTION){
//                File selectedFile = file.getSelectedFile();
//
//                String path = selectedFile.getAbsolutePath();
//                upImages[j].setIcon(ResizeImage(path, upImages[j]));
//                j++;
//            }
//        });
//
//        JButton dltImgBtn = new JButton("DELETE IMAGE");
//        dltImgBtn.setFont(new Font("Sarif",Font.BOLD,16));
//        dltImgBtn.setBackground(new Color(200,0,10));
//        dltImgBtn.setBorderPainted(false);
//        dltImgBtn.setFocusPainted(false);
//        dltImgBtn.setForeground(new Color(248,248,248));
//        addImgBtn.setFocusPainted(false);
//        dltImgBtn.addActionListener(e -> {
//            upImages[--j].setIcon((new ImageIcon(this.getClass().getResource("Cross.png"))));
//        });
//
//        post.add(addImgBtn);
//        post.add(dltImgBtn);
//
//        postLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, p[0], -248, SpringLayout.HORIZONTAL_CENTER, post);
//        postLayout.putConstraint(SpringLayout.NORTH, p[0], 5, SpringLayout.NORTH, post);
//        postLayout.putConstraint(SpringLayout.WEST, p[4], 0, SpringLayout.WEST, p[0]);
//        postLayout.putConstraint(SpringLayout.NORTH, p[4], 5, SpringLayout.SOUTH, p[0]);
//        postLayout.putConstraint(SpringLayout.WEST, p[8], 0, SpringLayout.WEST, p[0]);
//        postLayout.putConstraint(SpringLayout.NORTH, p[8], 5, SpringLayout.SOUTH, p[4]);
//        postLayout.putConstraint(SpringLayout.WEST, p[1], 5, SpringLayout.EAST, p[0]);
//        postLayout.putConstraint(SpringLayout.NORTH, p[1], 0, SpringLayout.NORTH, p[0]);
//        postLayout.putConstraint(SpringLayout.WEST, p[5], 0, SpringLayout.WEST, p[1]);
//        postLayout.putConstraint(SpringLayout.NORTH, p[5], 5, SpringLayout.SOUTH, p[1]);
//        postLayout.putConstraint(SpringLayout.WEST, p[9], 0, SpringLayout.WEST, p[1]);
//        postLayout.putConstraint(SpringLayout.NORTH, p[9], 5, SpringLayout.SOUTH, p[5]);
//        postLayout.putConstraint(SpringLayout.WEST, p[2], 5, SpringLayout.EAST, p[1]);
//        postLayout.putConstraint(SpringLayout.NORTH, p[2], 0, SpringLayout.NORTH, p[0]);
//        postLayout.putConstraint(SpringLayout.EAST, p[6], 0, SpringLayout.EAST, p[2]);
//        postLayout.putConstraint(SpringLayout.NORTH, p[6], 5, SpringLayout.SOUTH, p[2]);
//        postLayout.putConstraint(SpringLayout.EAST, p[10], 0, SpringLayout.EAST, p[2]);
//        postLayout.putConstraint(SpringLayout.NORTH, p[10], 5, SpringLayout.SOUTH, p[6]);
//        postLayout.putConstraint(SpringLayout.WEST, p[3], 5, SpringLayout.EAST, p[2]);
//        postLayout.putConstraint(SpringLayout.NORTH, p[3], 0, SpringLayout.NORTH, p[0]);
//        postLayout.putConstraint(SpringLayout.EAST, p[7], 0, SpringLayout.EAST, p[3]);
//        postLayout.putConstraint(SpringLayout.NORTH, p[7], 5, SpringLayout.SOUTH, p[3]);
//        postLayout.putConstraint(SpringLayout.EAST, p[11], 0, SpringLayout.EAST, p[3]);
//        postLayout.putConstraint(SpringLayout.NORTH, p[11], 5, SpringLayout.SOUTH, p[7]);
//        postLayout.putConstraint(SpringLayout.EAST, dltImgBtn, -30, SpringLayout.EAST, p[11]);
//        postLayout.putConstraint(SpringLayout.NORTH, dltImgBtn, 15, SpringLayout.SOUTH, p[11]);
//        postLayout.putConstraint(SpringLayout.EAST, addImgBtn, -12, SpringLayout.WEST, dltImgBtn);
//        postLayout.putConstraint(SpringLayout.NORTH, addImgBtn, 0, SpringLayout.NORTH, dltImgBtn);
//
//        JPanel rent = new JPanel();
//        rent.setLayout(new GridLayout());
//        rent.setBackground(Color.white);
//        rent.setPreferredSize(new Dimension(1300, 800));
//        rent.setVisible(false);
//
//        JPanel own = new JPanel();
//        own.setLayout(new GridLayout());
//        own.setBackground(Color.black);
//        own.setPreferredSize(new Dimension(1300, 800));
//        own.setVisible(false);

        JButton postBtn = new JButton("POSTS");
        postBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        postBtn.setSize(80, 30);
        postBtn.setBorderPainted(false);
        postBtn.setContentAreaFilled(false);
        postBtn.setFocusPainted(false);
        postBtn.setForeground(new Color(28, 36, 47));
        postBtn.setFont(new Font("sarif", Font.BOLD, 16));
//
//        postBtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                prePage.setBackground(Color.WHITE);
//                preCard.show(prePage, "Post");
//            }
//        });
//
//        JButton rentBtn = new JButton("RENT");
//        rentBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//        rentBtn.setSize(80, 30);
//        rentBtn.setBorderPainted(false);
//        rentBtn.setContentAreaFilled(false);
//        rentBtn.setFocusPainted(false);
//        rentBtn.setForeground(Color.black);
//        rentBtn.setFont(new Font("sanserif", Font.BOLD, 16));
//        rentBtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                prePage.setBackground(Color.white);
//                preCard.show(prePage, "Rent");
//            }
//        });
//
//        JButton ownButton = new JButton("OWN");
//        ownButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//        ownButton.setSize(80, 30);
//        ownButton.setBorderPainted(false);
//        ownButton.setContentAreaFilled(false);
//        ownButton.setFocusPainted(false);
//        ownButton.setForeground(Color.black);
//        ownButton.setFont(new Font("sarif", Font.BOLD, 16));
//        ownButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                prePage.setBackground(Color.black);
//                preCard.show(prePage, "Own");
//
//            }
//        });

        menu.add(postBtn);
//        menu.add(rentBtn);
//        menu.add(ownButton);

//        prePage.add(post, "Post");
//        prePage.add(rent, "Rent");
//        prePage.add(own, "Own");

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, postBtn, 0, SpringLayout.HORIZONTAL_CENTER, menu);

        page.add(BorderLayout.NORTH, menuPlusBorder);
        page.add(BorderLayout.CENTER, post);

        mainPanel.add(BorderLayout.NORTH, topPanel);
        mainPanel.add(BorderLayout.CENTER, page);


/////////////////////////////////////////////
        //   edit page   //
/////////////////////////////////////////////


        editPanel = new JPanel();
        editPanel.setPreferredSize(new Dimension(1200, 800));
        editPanel.setLayout(new BorderLayout());
        editPanel.setBackground(Color.WHITE);

        JPanel editTop = new JPanel();
        SpringLayout teLayout = new SpringLayout();
        editTop.setPreferredSize(new Dimension(1300, 180));
        editTop.setLayout(teLayout);
        editTop.setBackground(new Color(248, 248, 248));

        JPanel editProfilePanel = new JPanel();
        editProfilePanel.setPreferredSize(new Dimension(1300, 160));
        editProfilePanel.setLayout(new BorderLayout());
        editProfilePanel.setBackground((Color.magenta));

        JLabel wave = new JLabel(new ImageIcon(super.getClass().getResource("W1500.jpg")));
        wave.setBounds(0, 80, 800, 100);

        eprofile = new JLabel();
        eprofile.setIcon(profileImage);
        eprofile.setPreferredSize(new Dimension(118, 118));

        JLabel eprofileFrame = new JLabel(new ImageIcon(super.getClass().getResource("frame120w.png")));
        eprofileFrame.setPreferredSize(new Dimension(120, 120));

        changeProfile = new JLabel("CHANGE PROFILE PICTIURE");
        changeProfile.setFont(new Font("Sarif", Font.BOLD, 13));
        changeProfile.setFont(new Font("Sarif", Font.BOLD, 13));
        changeProfile.setForeground(new Color(28, 36, 47));
        changeProfile.setBackground(Color.WHITE);
        changeProfile.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                changeProfile.setBackground(new Color(148, 156, 167));
            }

            public void mouseExited(MouseEvent e) {
                changeProfile.setBackground(Color.WHITE);
            }

            public void mouseClicked(MouseEvent e) {
                JFileChooser file = new JFileChooser();
                file.setCurrentDirectory(new File(System.getProperty("user.home")));

                FileNameExtensionFilter filter = new FileNameExtensionFilter("*.images", "jpg", "gif", "png");
                file.addChoosableFileFilter(filter);
                int result = file.showOpenDialog(null);

                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = file.getSelectedFile();
                    path2 = selectedFile.getAbsolutePath();
//                    setPath(path2);
                    eprofile.setIcon(ResizeImage(path2, eprofile));
                }
            }
        });

        teLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, eprofile, 0, SpringLayout.HORIZONTAL_CENTER, editTop);
        teLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, eprofileFrame, 0, SpringLayout.HORIZONTAL_CENTER, editTop);
        teLayout.putConstraint(SpringLayout.NORTH, eprofile, 10, SpringLayout.NORTH, editTop);
        teLayout.putConstraint(SpringLayout.NORTH, eprofileFrame, 10, SpringLayout.NORTH, editTop);
        teLayout.putConstraint(SpringLayout.NORTH, wave, 115, SpringLayout.NORTH, editTop);
        teLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, wave, 0, SpringLayout.HORIZONTAL_CENTER, editTop);
        teLayout.putConstraint(SpringLayout.WEST, changeProfile, 20, SpringLayout.EAST, eprofileFrame);
        teLayout.putConstraint(SpringLayout.NORTH, changeProfile, 100, SpringLayout.NORTH, editTop);

        editTop.add(changeProfile);
        editTop.add(eprofileFrame);
        editTop.add(eprofile);
        editTop.add(wave);

        JPanel editForm = new JPanel();
        SpringLayout eformLayout = new SpringLayout();
        editForm.setLayout(eformLayout);
        editForm.setBackground(new Color(28, 36, 47));

        JLabel yourProfile = new JLabel("Your Profile");
        yourProfile.setLayout(null);
        yourProfile.setFont(new Font("sarif", Font.BOLD, 26));
        yourProfile.setPreferredSize(new Dimension(150, 30));
        yourProfile.setForeground(new Color(247, 246, 244));
        editForm.add(yourProfile);

        JLabel firstName = new JLabel("First name");
        firstName.setLayout(null);
        firstName.setFont(new Font("sarif", Font.BOLD, 18));
        firstName.setPreferredSize(new Dimension(150, 20));
        firstName.setForeground(new Color(247, 246, 244));
        editForm.add(firstName);

        JTextField firstNameText = new JTextField(fname);
        firstNameText.setFont(new Font("sarif", Font.BOLD, 16));
        firstNameText.setForeground(new Color(247, 246, 244));
        firstNameText.setPreferredSize(new Dimension(200, 24));
        firstNameText.setBackground(null);
        editForm.add(firstNameText);


        JLabel middleName = new JLabel("Middle name");
        middleName.setLayout(null);
        middleName.setFont(new Font("sarif", Font.BOLD, 18));
        middleName.setPreferredSize(new Dimension(150, 20));
        middleName.setForeground(new Color(247, 246, 244));
        editForm.add(middleName);

        JTextField middleNameText = new JTextField(mname);
        middleNameText.setFont(new Font("sarif", Font.BOLD, 16));
        middleNameText.setForeground(new Color(247, 246, 244));
        middleNameText.setPreferredSize(new Dimension(150, 24));
        middleNameText.setBackground(null);
        editForm.add(middleNameText);

        JLabel lastName = new JLabel("Last Name");
        lastName.setLayout(null);
        lastName.setFont(new Font("sarif", Font.BOLD, 18));
        lastName.setPreferredSize(new Dimension(150, 20));
        lastName.setForeground(new Color(247, 246, 244));
        editForm.add(lastName);

        JTextField lastNameText = new JTextField(lname);
        lastNameText.setFont(new Font("sarif", Font.BOLD, 16));
        lastNameText.setForeground(new Color(247, 246, 244));
        lastNameText.setPreferredSize(new Dimension(200, 24));
        lastNameText.setBackground(null);
        editForm.add(lastNameText);

        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setLayout(null);
        usernameLabel.setFont(new Font("sarif", Font.BOLD, 18));
        usernameLabel.setPreferredSize(new Dimension(150, 20));
        usernameLabel.setForeground(new Color(247, 246, 244));
        editForm.add(usernameLabel);

        usernameText = new JTextField(uname);
        usernameText.setFont(new Font("sarif", Font.BOLD, 16));
        usernameText.setForeground(new Color(247, 246, 244));
        usernameText.setPreferredSize(new Dimension(200, 24));
        usernameText.setBackground(null);
        editForm.add(usernameText);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setLayout(null);
        passwordLabel.setFont(new Font("sarif", Font.BOLD, 18));
        passwordLabel.setPreferredSize(new Dimension(150, 20));
        passwordLabel.setForeground(new Color(247, 246, 244));
        editForm.add(passwordLabel);

        JTextField passwordText = new JTextField(password);
        passwordText.setFont(new Font("sarif", Font.BOLD, 16));
        passwordText.setForeground(new Color(247, 246, 244));
        passwordText.setPreferredSize(new Dimension(200, 24));
        passwordText.setBackground(null);
        editForm.add(passwordText);

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setLayout(null);
        emailLabel.setFont(new Font("sarif", Font.BOLD, 18));
        emailLabel.setPreferredSize(new Dimension(150, 20));
        emailLabel.setForeground(new Color(247, 246, 244));
        editForm.add(emailLabel);

        JTextField emailText = new JTextField(email);
        emailText.setFont(new Font("sarif", Font.BOLD, 16));
        emailText.setForeground(new Color(247, 246, 244));
        emailText.setPreferredSize(new Dimension(200, 24));
        emailText.setBackground(null);
        editForm.add(emailText);

        JLabel phoneLabel = new JLabel("Phone Number");
        phoneLabel.setLayout(null);
        phoneLabel.setFont(new Font("sarif", Font.BOLD, 18));
        phoneLabel.setPreferredSize(new Dimension(150, 20));
        phoneLabel.setForeground(new Color(247, 246, 244));
        editForm.add(phoneLabel);

        JTextField phoneText = new JTextField(phoneNumber);
        phoneText.setFont(new Font("sarif", Font.BOLD, 16));
        phoneText.setForeground(new Color(247, 246, 244));
        phoneText.setPreferredSize(new Dimension(200, 24));
        phoneText.setBackground(null);
        editForm.add(phoneText);

        JLabel genderL = new JLabel("Gender");
        genderL.setFont(new Font("sarif", Font.BOLD, 18));
        genderL.setForeground(new Color(247, 246, 244));
        genderL.setPreferredSize(new Dimension(100, 20));
        editForm.add(genderL);

        JComboBox gender = new JComboBox();
        gender.setFont(new Font("sarif", Font.BOLD, 16));
        gender.setForeground(Color.WHITE);
        gender.setPreferredSize(new Dimension(100, 23));
        gender.setOpaque(false);
        gender.addItem("");
        gender.addItem("Male");
        gender.addItem("Female");
        gender.setOpaque(false);
        gender.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        editForm.add(gender);

        JLabel cancelChange = new JLabel("CANCEL");
        cancelChange.setFont(new Font("SansSerif", Font.BOLD, 14));
        cancelChange.setPreferredSize(new Dimension(150, 20));
        cancelChange.setForeground(new Color(115, 181, 255));

        cancelChange.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                card.next(cardPane);
            }
        });
        editForm.add(cancelChange);

        JLabel saveChange = new JLabel("SAVE CHANGE");
        saveChange.setFont(new Font("SansSerif", Font.BOLD, 14));
        saveChange.setPreferredSize(new Dimension(150, 20));
        saveChange.setForeground(new Color(115, 181, 255));

        editForm.add(saveChange);

        eformLayout.putConstraint(SpringLayout.WEST, yourProfile, 20, SpringLayout.WEST, editForm);
        eformLayout.putConstraint(SpringLayout.NORTH, yourProfile, 20, SpringLayout.NORTH, editForm);
        eformLayout.putConstraint(SpringLayout.WEST, firstName, 50, SpringLayout.WEST, editForm);
        eformLayout.putConstraint(SpringLayout.NORTH, firstName, 20, SpringLayout.SOUTH, yourProfile);
        eformLayout.putConstraint(SpringLayout.WEST, firstNameText, 0, SpringLayout.WEST, firstName);
        eformLayout.putConstraint(SpringLayout.NORTH, firstNameText, 7, SpringLayout.SOUTH, firstName);
        eformLayout.putConstraint(SpringLayout.WEST, middleName, 50, SpringLayout.EAST, firstNameText);
        eformLayout.putConstraint(SpringLayout.NORTH, middleName, 0, SpringLayout.NORTH, firstName);
        eformLayout.putConstraint(SpringLayout.WEST, middleNameText, 0, SpringLayout.WEST, middleName);
        eformLayout.putConstraint(SpringLayout.NORTH, middleNameText, 0, SpringLayout.NORTH, firstNameText);
        eformLayout.putConstraint(SpringLayout.WEST, lastName, 50, SpringLayout.EAST, middleNameText);
        eformLayout.putConstraint(SpringLayout.NORTH, lastName, 0, SpringLayout.NORTH, firstName);
        eformLayout.putConstraint(SpringLayout.WEST, lastNameText, 0, SpringLayout.WEST, lastName);
        eformLayout.putConstraint(SpringLayout.NORTH, lastNameText, 0, SpringLayout.NORTH, firstNameText);
        eformLayout.putConstraint(SpringLayout.WEST, usernameLabel, 0, SpringLayout.WEST, firstName);
        eformLayout.putConstraint(SpringLayout.NORTH, usernameLabel, 15, SpringLayout.SOUTH, lastNameText);
        eformLayout.putConstraint(SpringLayout.WEST, usernameText, 0, SpringLayout.WEST, firstName);
        eformLayout.putConstraint(SpringLayout.NORTH, usernameText, 7, SpringLayout.SOUTH, usernameLabel);
        eformLayout.putConstraint(SpringLayout.WEST, passwordLabel, 0, SpringLayout.WEST, firstName);
        eformLayout.putConstraint(SpringLayout.NORTH, passwordLabel, 15, SpringLayout.SOUTH, usernameText);
        eformLayout.putConstraint(SpringLayout.WEST, passwordText, 0, SpringLayout.WEST, firstName);
        eformLayout.putConstraint(SpringLayout.NORTH, passwordText, 7, SpringLayout.SOUTH, passwordLabel);
        eformLayout.putConstraint(SpringLayout.WEST, emailLabel, 0, SpringLayout.WEST, firstName);
        eformLayout.putConstraint(SpringLayout.NORTH, emailLabel, 15, SpringLayout.SOUTH, passwordText);
        eformLayout.putConstraint(SpringLayout.WEST, emailText, 0, SpringLayout.WEST, firstName);
        eformLayout.putConstraint(SpringLayout.NORTH, emailText, 7, SpringLayout.SOUTH, emailLabel);
        eformLayout.putConstraint(SpringLayout.WEST, phoneLabel, 0, SpringLayout.WEST, firstName);
        eformLayout.putConstraint(SpringLayout.NORTH, phoneLabel, 15, SpringLayout.SOUTH, emailText);
        eformLayout.putConstraint(SpringLayout.WEST, phoneText, 0, SpringLayout.WEST, firstName);
        eformLayout.putConstraint(SpringLayout.NORTH, phoneText, 7, SpringLayout.SOUTH, phoneLabel);
        eformLayout.putConstraint(SpringLayout.WEST, genderL, 0, SpringLayout.WEST, firstName);
        eformLayout.putConstraint(SpringLayout.NORTH, genderL, 15, SpringLayout.SOUTH, phoneText);
        eformLayout.putConstraint(SpringLayout.WEST, gender, 0, SpringLayout.WEST, firstName);
        eformLayout.putConstraint(SpringLayout.NORTH, gender, 7, SpringLayout.SOUTH, genderL);
        eformLayout.putConstraint(SpringLayout.EAST, saveChange, -30, SpringLayout.EAST, editForm);
        eformLayout.putConstraint(SpringLayout.SOUTH, saveChange, -40, SpringLayout.SOUTH, editForm);
        eformLayout.putConstraint(SpringLayout.EAST, cancelChange, 25, SpringLayout.WEST, saveChange);
        eformLayout.putConstraint(SpringLayout.SOUTH, cancelChange, 0, SpringLayout.SOUTH, saveChange);

        editPanel.add(BorderLayout.NORTH, editTop);
        editPanel.add(BorderLayout.CENTER, editForm);

        cardPane = new JPanel();
        card = new CardLayout();

        cardPane.setLayout(card);
        cardPane.add(mainPanel, "Main Pane");
        cardPane.add(editPanel, "Edit Pane");

        pPanel.add(BorderLayout.CENTER, cardPane);

        editIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                card.next(cardPane);
            }
        });

        saveChange.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                card.next(cardPane);

                try {
                    File file = new File(path2);
                    FileInputStream fis = new FileInputStream(file);
                    BufferedInputStream bis = new BufferedInputStream(fis);
                    byte[] imagesBytes = new byte[(int) file.length()];
                    bis.read(imagesBytes, 0, imagesBytes.length);

                    String sql = "update users set mname = ? , lname = ?, email = ?, username = ?, password = ? , image = ? where fname = ?";
                    PreparedStatement s = connection.conn.prepareStatement(sql);
                    s.setString(1, middleNameText.getText());
                    s.setString(2, lastNameText.getText());
                    s.setString(3, emailText.getText());
                    s.setString(4, usernameText.getText());
                    s.setString(5, passwordText.getText());
                    s.setBytes(6, imagesBytes);
                    s.setString(7, firstNameText.getText());
                    s.executeUpdate();

                    sql = "update loginchecker set username = ? where laststatus = 'Logged in'";
                    PreparedStatement s2 = connection.conn.prepareStatement(sql);
                    s2.setString(1, usernameText.getText());
                    s2.executeUpdate();

                    getUserData();
                    profileInfo.repaint();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (Exception efg) {
                    efg.printStackTrace();
                } finally {
                    card.next(cardPane);
                }


            }
        });


    }

    //    public void setPath(String path) {
//        this.path = path;
//    }
    public ImageIcon ResizeImage(String ImagePath, JLabel label) {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

    public ImageIcon ResizeImageProfile(BufferedImage image) {

        Image newImg = image.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        ImageIcon img = new ImageIcon(newImg);
        return img;
    }

    public JPanel getProfilePanel() {
        return pPanel;
    }

    ///get all the data from the database here

    void getUserData() {

        String checker = "SELECT * FROM users WHERE username=?";
        System.out.println(Gusername);
        try {
            Statement statement = connection.conn.createStatement();

            PreparedStatement preparedStatement = connection.conn.prepareStatement(checker);
            preparedStatement.setString(1, Gusername);

            ResultSet results = preparedStatement.executeQuery();

            if (results.next()) {
                fname = results.getString("fname");
                mname = results.getString("mname");
                lname = results.getString("lname");
                email = results.getString("email");
                password = results.getString("password");
                uname = results.getString("username");
                path = results.getBinaryStream(7);

                pImage = ImageIO.read(path);
                profileImage = ResizeImageProfile(pImage);

            } else {
                System.out.println("Login Failed");
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Errorrrrrrrrrrrrrrrrrr logging in");

        }
    }


}
