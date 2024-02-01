//import javaswingdev.drawer.Drawer;
//import javaswingdev.drawer.DrawerController;
//import javaswingdev.drawer.DrawerItem;

import org.w3c.dom.css.Rect;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SideBar {

    //    private DrawerController drawer;
    Connection1 connection;
    JToggleButton themeBtn;
    JLabel statusLabel;
    Loading LoadingObj;
    WatchLater watchLaterObj;
    JPanel profile;
    JPanel home;
    JPanel Upload;
    JLabel profileimagelabel;
    JPanel message;
    JPanel watchlater;
    JPanel payment;
    JLabel upImages;
    JPanel uploadFrame;
    CardLayout card2;
    JPanel cardPane2;
    JPanel logout;
    JLabel pbtn;
    JLabel hbtn;
    JLabel ubtn;
    JLabel fbtn;
    JLabel Nicon;
    JLabel watchbtn;
    JLabel paybtn;
    JLabel logoutBtn;
    JLabel picon;
    JLabel hicon;
    JLabel uicon;
    JLabel ficon;
    JLabel watchicon;
    JLabel payicon;
    JLabel logouticon;
    boolean togglebttnClicked = false;
    boolean languagebtnClicked = false;
    Upload uploadObj;
    Payment paymentObj;
    Message messageObj;
    Header headerObj;
    Profile ProfileObj;
    JFrame frame;

    SideBar() {

    }

    SideBar(String getUsername) {

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500, 800);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
        frame.setVisible(false);

        connection = new Connection1();


        getmainFrame();

        JPanel sideIcons = new JPanel();
        sideIcons.setPreferredSize(new Dimension(260, 300));
        sideIcons.setLayout(new BorderLayout());
        sideIcons.setBackground(new Color(16, 17, 20));

        JPanel upperSideIc = new JPanel();
        upperSideIc.setPreferredSize(new Dimension(265, 350));
        upperSideIc.setLayout(new GridLayout(6, 1, 0, 0));

        ///////////////////////////////////component panels///////////////////////////////////////

        /////////////////////////UPLOAD/////////////////////////////////


////////////////////////////////////////////////////////////////////

        //to the upper side

        profile = new JPanel();
        profile.setLayout(null);
        profile.setBackground(new Color(16, 17, 20));
        profile.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        pbtn = new JLabel("Profile");
        pbtn.setForeground(Color.WHITE);
        pbtn.setFont(new Font("sanserif", Font.BOLD, 16));
        pbtn.setBounds(45, 0, 100, 50);


        picon = new JLabel();
        picon.setBounds(10, 10, 30, 30);
        profile.addMouseListener(new ProfileListener());

/////////////////////////////////////////////
        home = new JPanel();
        home.setLayout(null);
        home.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        home.setBackground(new Color(88, 89, 91));

        hbtn = new JLabel("Home");
        hbtn.setHorizontalAlignment(JLabel.LEFT);
        hbtn.setForeground(Color.WHITE);
        hbtn.setFont(new Font("sanserif", Font.BOLD, 16));
        hbtn.setBounds(60, 0, 100, 50);

        hicon = new JLabel(new ImageIcon(this.getClass().getResource("home.png")));
        hicon.setBounds(15, 10, 30, 30);

        home.add(hbtn);
        home.add(hicon);
        home.addMouseListener(new HomeListener());
        //////////////////////////////////////////

        Upload = new JPanel();
        Upload.setLayout(null);
        Upload.setBackground(new Color(16, 17, 20));
        Upload.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        ubtn = new JLabel("Upload");
        ubtn.setHorizontalAlignment(JLabel.LEFT);
        ubtn.setForeground(Color.WHITE);
        ubtn.setFont(new Font("sanserif", Font.BOLD, 16));
        ubtn.setBounds(60, 0, 100, 50);


        uicon = new JLabel(new ImageIcon(this.getClass().getResource("upload (2).png")));
        uicon.setBounds(15, 10, 30, 30);

        Upload.add(ubtn);
        Upload.add(uicon);
        Upload.addMouseListener(new UploadListener());
////////////////////////////////////////////////
        message = new JPanel();
        message.setLayout(null);
        message.setBackground(new Color(16, 17, 20));
        message.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        fbtn = new JLabel("Notifications");
        fbtn.setHorizontalAlignment(JLabel.LEFT);
        fbtn.setForeground(Color.WHITE);
        fbtn.setFont(new Font("sanserif", Font.BOLD, 16));
        fbtn.setBounds(60, 0, 150, 50);

        ficon = new JLabel(new ImageIcon(this.getClass().getResource("notification.png")));
        ficon.setBounds(15, 10, 30, 30);

        Nicon = new JLabel(new ImageIcon(this.getClass().getResource("notificationNo.png")));
        Nicon.setBounds(220, 10, 30, 30);

        JLabel numb = new JLabel("9+");
        numb.setForeground(Color.WHITE);
        numb.setFont(new Font("Abyssinica SIL", Font.BOLD, 16));
        numb.setBounds(226, 10, 30, 30);

        message.add(numb);
        message.add(Nicon);
        message.add(fbtn);
        message.add(ficon);
        message.addMouseListener(new messageListener());
//////////////////////////////////////////////////////
        watchlater = new JPanel();
        watchlater.setLayout(null);
        watchlater.setBackground(new Color(16, 17, 20));
        watchlater.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        watchbtn = new JLabel("Watch later");
        watchbtn.setHorizontalAlignment(JLabel.LEFT);
        watchbtn.setForeground(Color.WHITE);
        watchbtn.setFont(new Font("sanserif", Font.BOLD, 16));
        watchbtn.setBounds(60, 0, 100, 50);

        watchicon = new JLabel(new ImageIcon(this.getClass().getResource("add.png")));
        watchicon.setBounds(15, 10, 30, 30);

        watchlater.add(watchbtn);
        watchlater.add(watchicon);
        watchlater.addMouseListener(new WatchlaterListner());
/////////////////////////////////////////////////////////
        payment = new JPanel();
        payment.setLayout(null);
        payment.setBackground(new Color(16, 17, 20));
        payment.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        paybtn = new JLabel("Payment");
        paybtn.setHorizontalAlignment(JLabel.LEFT);
        paybtn.setForeground(Color.WHITE);
        paybtn.setFont(new Font("sanserif", Font.BOLD, 16));
        paybtn.setBounds(60, 0, 100, 50);


        payicon = new JLabel(new ImageIcon(this.getClass().getResource("payment.png")));
        payicon.setBounds(15, 10, 30, 30);

        payment.add(paybtn);
        payment.add(payicon);
        payment.addMouseListener(new PaymentListener());
/////////////////////////////////////////////////////////

        upperSideIc.add(profile);
        upperSideIc.add(home);
        upperSideIc.add(Upload);
        upperSideIc.add(message);
        upperSideIc.add(watchlater);
        upperSideIc.add(payment);

        JPanel lowerSideIc = new JPanel();
        lowerSideIc.setBackground(Color.red);
        lowerSideIc.setPreferredSize(new Dimension(400, 100));
        lowerSideIc.setLayout(new GridLayout(2, 1));


        JPanel theme = new JPanel();
        theme.setBackground(new Color(16, 17, 20));
        theme.setLayout(null);
        theme.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        themeBtn = new JToggleButton("");
        themeBtn.setBounds(20, 10, 50, 30);
        themeBtn.setText("");
        ImageIcon moon = new ImageIcon(this.getClass().getResource("moon.png"));
        themeBtn.setBounds(20, 10, 50, 30);
        themeBtn.setIcon(moon);
        themeBtn.setBorderPainted(false);
        themeBtn.setContentAreaFilled(false);
        themeBtn.setFocusPainted(false);

        // Create the status label
        statusLabel = new JLabel("");
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        statusLabel.setText("Dark");
        statusLabel.setForeground(Color.WHITE);
        statusLabel.setBounds(80, 10, 100, 30);


        // Add an action listener to toggle the button state and update the label
        themeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!themeBtn.isSelected()) {
                    togglebttnClicked = false;
                    headerObj.darkwhite = false;

                    themeBtn.setText("");
                    ImageIcon moon = new ImageIcon(this.getClass().getResource("moon.png"));
                    themeBtn.setBounds(20, 10, 50, 30);
                    themeBtn.setIcon(moon);
                    statusLabel.setText("Dark");
                    statusLabel.setForeground(Color.WHITE);
                    statusLabel.setBounds(80, 10, 100, 30);

                    themeBtn.setBorderPainted(false);
                    themeBtn.setContentAreaFilled(false);
                    themeBtn.setFocusPainted(false);

                    sideIcons.setBackground(new Color(16, 17, 20));
                    profile.setBackground(new Color(16, 17, 20));
                    home.setBackground(new Color(105, 106, 108));
                    Upload.setBackground(new Color(16, 17, 20));
                    message.setBackground(new Color(16, 17, 20));
                    watchlater.setBackground(new Color(16, 17, 20));
                    payment.setBackground(new Color(16, 17, 20));
                    theme.setBackground(new Color(16, 17, 20));
                    logout.setBackground(new Color(16, 17, 20));

                    pbtn.setForeground(Color.WHITE);
                    hbtn.setForeground(Color.WHITE);
                    ubtn.setForeground(Color.WHITE);
                    fbtn.setForeground(Color.WHITE);
                    watchbtn.setForeground(Color.WHITE);
                    paybtn.setForeground(Color.WHITE);
                    logoutBtn.setForeground(Color.WHITE);

                    ImageIcon up = new ImageIcon(this.getClass().getResource("upload (2).png"));
                    uicon.setIcon(up);
                    ImageIcon hom = new ImageIcon(this.getClass().getResource("home.png"));
                    hicon.setIcon(hom);
                    ImageIcon fil = new ImageIcon(this.getClass().getResource("notification.png"));
                    ficon.setIcon(fil);
                    ImageIcon watch = new ImageIcon(this.getClass().getResource("add.png"));
                    watchicon.setIcon(watch);
                    ImageIcon pay = new ImageIcon(this.getClass().getResource("payment.png"));
                    payicon.setIcon(pay);
                    ImageIcon logicon = new ImageIcon(this.getClass().getResource("logout.png"));
                    logouticon.setIcon(logicon);
                    ImageIcon bcicon = new ImageIcon(this.getClass().getResource("circlelanb.png"));
                    headerObj.backBtn.setIcon(bcicon);

                    ImageIcon backicon = new ImageIcon(this.getClass().getResource("back.png"));
                    headerObj.scrollerTopleft.setIcon(backicon);
                    ImageIcon nexticon = new ImageIcon(this.getClass().getResource("next.png"));
                    headerObj.scrollerTop.setIcon(nexticon);
                    ImageIcon profileimageiconb = new ImageIcon(this.getClass().getResource("forprofile.png"));
                    profileimagelabel.setIcon(profileimageiconb);

//                    ImageIcon rightframe = new ImageIcon(this.getClass().getResource("RightFrame.png"));
//                    headerObj.p.rightFrame.setIcon(rightframe);
//                    ImageIcon leftframe = new ImageIcon(this.getClass().getResource("LeftFrame.png"));
//                    headerObj.p.leftFrame.setIcon(leftframe);
//                    ImageIcon framepp = new ImageIcon(this.getClass().getResource("FrameBlack50x50.png"));
//                    headerObj.p.frameLabel.setIcon(framepp);


                    uploadObj.uploadFrame.setBackground(new Color(30, 31, 34));
                    uploadObj.price.setBackground(new Color(255, 255, 255));

                    Color w = new Color(255, 255, 255);
                    Color x = new Color(30, 31, 34);
                    Color b = new Color(218, 216, 216);
                    Color ex = new Color(91, 91, 91);

                    uploadObj.uploadFrame.setBackground(x);
                    uploadObj.price.setForeground(w);
                    uploadObj.basicInfo.setForeground(w);
                    uploadObj.firstName.setForeground(w);
                    uploadObj.firstNameInput.setBackground(b);
                    uploadObj.firstNameInput.setForeground(w);
                    uploadObj.middleName.setForeground(w);
                    uploadObj.middleNameInput.setBackground(b);
                    uploadObj.middleNameInput.setForeground(w);
                    uploadObj.lastName.setForeground(w);
                    uploadObj.lastNameInput.setBackground(b);
                    uploadObj.lastNameInput.setForeground(w);
                    uploadObj.genderL.setForeground(w);
                    uploadObj.gender.setBackground(ex);
                    uploadObj.gender.setForeground(w);
                    uploadObj.contactInfo.setForeground(w);
                    uploadObj.Email.setForeground(w);
                    uploadObj.EmailInput.setBackground(b);
                    uploadObj.EmailInput.setForeground(w);
                    uploadObj.confirmEmail.setForeground(w);
                    uploadObj.confirmEmailInput.setBackground(b);
                    uploadObj.confirmEmailInput.setForeground(w);
                    uploadObj.phoneNo.setForeground(w);
                    uploadObj.phoneNoInput.setBackground(ex);
                    uploadObj.phoneNoInput.setForeground(w);
                    uploadObj.countryCode.setBackground(ex);
                    uploadObj.countryCode.setForeground(w);
                    uploadObj.houseInfo.setForeground(w);
                    uploadObj.Region.setForeground(w);
                    uploadObj.regionSelector.setBackground(ex);
                    uploadObj.regionSelector.setForeground(w);
                    uploadObj.City.setForeground(w);
                    uploadObj.cityInput.setBackground(b);
                    uploadObj.cityInput.setForeground(w);
                    uploadObj.StreetAddress1.setForeground(w);
                    uploadObj.streetAddress1Input.setBackground(b);
                    uploadObj.streetAddress1Input.setForeground(w);
                    uploadObj.StreetAddress2.setForeground(w);
                    uploadObj.streetAddress2Input.setBackground(b);
                    uploadObj.streetAddress2Input.setForeground(w);
                    uploadObj.houseSize.setForeground(w);
                    uploadObj.houseSizeInput.setBackground(b);
                    uploadObj.houseSizeInput.setForeground(w);
                    uploadObj.bedroom.setForeground(w);
                    uploadObj.bedroomSize.setBackground(ex);
                    uploadObj.bedroomSize.setForeground(w);
                    uploadObj.priceInput.setBackground(b);
                    uploadObj.priceInput.setForeground(w);
                    uploadObj.opinionL.setForeground(w);
                    uploadObj.opinion.setBackground(new Color(80, 79, 79));
                    uploadObj.opinion.setForeground(b);
                    uploadObj.op.setBackground(w);
                    uploadObj.holderTemp.setBackground(new Color(80, 79, 79));
                    uploadObj.imageChooser.setBackground(new Color(94, 92, 92));
                    uploadObj.uploadSubmit.setBackground(new Color(0, 119, 56));
                    uploadObj.water.setBackground(b);
                    uploadObj.electricity.setBackground(b);
                    uploadObj.water.setForeground(w);
                    uploadObj.electricity.setForeground(w);
                    uploadObj.upLabel.setForeground(w);


                    paymentObj.payment.setBackground(x);
                    paymentObj.center.setBackground(x);
                    paymentObj.top.setBackground(new Color(24, 24, 28));
                    paymentObj.selectMethod.setForeground(w);
                    paymentObj.summaryHolder.setBackground(new Color(55, 58, 61));
                    paymentObj.paymentSummary.setForeground(w);
                    paymentObj.Deposit.setForeground(w);
                    paymentObj.CbeWallet.setForeground(w);
                    paymentObj.tele.setForeground(w);
                    paymentObj.other.setForeground(w);
                    paymentObj.monthly.setForeground(w);
                    paymentObj.monthlyfee.setForeground(w);
                    paymentObj.type.setForeground(w);
                    paymentObj.typeL.setForeground(w);
                    paymentObj.discount.setForeground(w);
                    paymentObj.discountL.setForeground(w);
                    paymentObj.total.setForeground(w);
                    paymentObj.totalL.setForeground(w);
                    paymentObj.paymethodsL.setForeground(w);
                    paymentObj.depo.setForeground(w);
                    paymentObj.depoInput.setBackground(x);
                    paymentObj.depoInput.setForeground(w);
                    paymentObj.Name.setForeground(w);
                    paymentObj.nameInput.setBackground(x);
                    paymentObj.nameInput.setForeground(w);
                    paymentObj.expiredate.setForeground(w);
                    paymentObj.expireInput.setBackground(x);
                    paymentObj.expireInput.setForeground(w);
                    paymentObj.pin.setForeground(w);
                    paymentObj.pinInput.setBackground(x);
                    paymentObj.pinInput.setForeground(w);
                    paymentObj.agreed.setForeground(w);
                    paymentObj.paybtn.setBackground(new Color(166, 164, 164));
                    paymentObj.paybtn.setForeground(x);

                    headerObj.backBtn.setForeground(x);
                    headerObj.body.setBackground(x);
                    headerObj.header.setBackground(x);
                    headerObj.fullBody.setBackground(x);
                    headerObj.lowerBody.setBackground(x);
                    headerObj.eastTop.setBackground(x);
                    headerObj.topLowerBody.setBackground(x);
                    headerObj.topLabel.setForeground(w);
                    headerObj.topsmall.setForeground(w);
                    headerObj.lowerTop.setBackground(x);
                    headerObj.btns[0].setBackground(x);
                    headerObj.btns[0].setBorder(BorderFactory.createLineBorder(Color.white));
                    headerObj.btns[0].setForeground(w);
                    headerObj.btns[1].setBackground(x);
                    headerObj.btns[1].setBorder(BorderFactory.createLineBorder(Color.white));
                    headerObj.btns[1].setForeground(w);
                    headerObj.btns[2].setBackground(x);
                    headerObj.btns[2].setBorder(BorderFactory.createLineBorder(Color.white));
                    headerObj.btns[2].setForeground(w);
                    headerObj.mainPanel.setBackground(x);
                    headerObj.homeStartpanel.setBackground(x);
                    headerObj.homeStartLabel.setForeground(w);
                    headerObj.homeStartLabelsmall.setForeground(w);
                    headerObj.topLabel.setForeground(w);
                    headerObj.topsmall.setForeground(w);
                    headerObj.label.setForeground(w);
                    headerObj.sp.userInfo.setBackground(x);
                    headerObj.sp.fullname.setForeground(w);
                    headerObj.sp.username.setForeground(w);
                    headerObj.sp.email.setForeground(w);
                    headerObj.sp.phone.setForeground(w);
                    headerObj.sp.fullnameL.setForeground(w);
                    headerObj.sp.usernameL.setForeground(w);
                    headerObj.sp.phoneL.setForeground(w);
                    headerObj.sp.emailL.setForeground(w);
                    headerObj.sp.chat.setForeground(x);
                    headerObj.sp.chat.setBackground(w);

                    ImageIcon filtericon = new ImageIcon(this.getClass().getResource("filterw.png"));
                    headerObj.searchicon.setForeground(w);
                    headerObj.searchicon.setBorder(BorderFactory.createLineBorder(Color.WHITE));
                    headerObj.searchicon.setIcon(filtericon);
                    headerObj.filterpanel.setBackground(new Color(49, 50, 58));
                    headerObj.comboHRegion.setBackground(new Color(49, 50, 58));
                    headerObj.comboHRegion.setForeground(new Color(245, 245, 245));
                    headerObj.combominPrice.setBackground(new Color(49, 50, 58));
                    headerObj.combominPrice.setForeground(new Color(245, 245, 245));
                    headerObj.combomaxPrice.setBackground(new Color(49, 50, 58));
                    headerObj.combomaxPrice.setForeground(new Color(245, 245, 245));
                    headerObj.combobedrooms.setBackground(new Color(49, 50, 58));
                    headerObj.combobedrooms.setForeground(new Color(245, 245, 245));
                    headerObj.combominArea.setBackground(new Color(49, 50, 58));
                    headerObj.combominArea.setForeground(new Color(245, 245, 245));
                    headerObj.combomaxArea.setBackground(new Color(49, 50, 58));
                    headerObj.combomaxArea.setForeground(new Color(245, 245, 245));
                    headerObj.apply.setForeground(Color.WHITE);
                    headerObj.apply.setBorder(BorderFactory.createLineBorder(Color.WHITE));
                    headerObj.clear.setForeground(Color.WHITE);
                    headerObj.clear.setBorder(BorderFactory.createLineBorder(Color.WHITE));

                    messageObj.frame.setBackground(new Color(28, 29, 33));
                    messageObj.scroller2.setBackground(new Color(28, 29, 33));
                    messageObj.scroller.setBackground(new Color(28, 29, 33));
                    messageObj.messages.setBackground(new Color(28, 29, 33));
                    messageObj.theimage.setBackground(new Color(66, 66, 66));
                    messageObj.theimage1.setBackground(new Color(66, 66, 66));
                    messageObj.theimage2.setBackground(new Color(66, 66, 66));

                    messageObj.messageArea.setBackground(new Color(66, 66, 66));
                    messageObj.emoji.setBackground(new Color(66, 66, 66));

                    messageObj.fmessage.setBackground(new Color(66, 66, 66));
                    messageObj.firstLabel.setForeground(w);
                    messageObj.secondLabel.setForeground(w);
                    messageObj.centerHolder.setBackground(new Color(28, 29, 33));
                    messageObj.fmessage.setBackground(new Color(28, 29, 33));

                    messageObj.topHolder.setBackground(new Color(28, 29, 33));
                    messageObj.lowHolder.setBackground(new Color(28, 29, 33));
                    messageObj.search.setBackground(new Color(103, 98, 98));
                    messageObj.search.setForeground(new Color(241, 241, 241));
                    ImageIcon ppsp = new ImageIcon(this.getClass().getResource("frame120.png"));
                    headerObj.sp.profileHolder.setIcon(ppsp);

                    watchLaterObj.panel.setBackground(new Color(30, 31, 34));
                    watchLaterObj.panel1.setBackground(new Color(14, 14, 16));
                    watchLaterObj.main.setBackground(new Color(14, 14, 16));
                    watchLaterObj.scroller.setBackground(new Color(14, 14, 16));
                    watchLaterObj.Label.setForeground(w);
                    watchLaterObj.Label2.setForeground(w);

                    for (int i = 0; i < 100; i++) {
                        try {
                            if (!messageObj.mesSenter[i].equals(null)) {
                                messageObj.mesSenter[i].setBackground(new Color(66, 66, 66));
                                messageObj.date[i].setForeground(new Color(241, 241, 241));
                                messageObj.topHolderPP[i].setForeground(new Color(241, 241, 241));
                                messageObj.fromName[i].setForeground(new Color(241, 241, 241));
                                messageObj.prof[i].setIcon(new ImageIcon(this.getClass().getResource("profile.png")));
                                messageObj.messpart[i].setBackground(new Color(61, 61, 61));
                            }
                        } catch (Exception eaa) {
                            break;
                        }
                    }
                    messageObj.centerHolder.setBackground(new Color(28, 29, 33));
                    //messageObj.scroller2.setBackground(new Color(28, 29, 33));
                    for (int i = 0; i < 100; i++) {
                        try {
                            if (!messageObj.message[i].equals(null)) {
                                messageObj.themess[i].setForeground(new Color(241, 241, 241));
                                messageObj.message[i].setForeground(new Color(241, 241, 241));
                            }
                        } catch (Exception eea) {
                            break;
                        }
                    }

                } else {
                    togglebttnClicked = true;
                    headerObj.darkwhite = true;
                    themeBtn.setText("");
                    ImageIcon sun = new ImageIcon(this.getClass().getResource("sun.png"));
                    themeBtn.setBounds(80, 10, 50, 30);
                    statusLabel.setText("Light");
                    themeBtn.setIcon(sun);
                    statusLabel.setForeground(Color.BLACK);
                    statusLabel.setBounds(30, 10, 70, 30);

                    themeBtn.setBorderPainted(false);
                    themeBtn.setContentAreaFilled(false);
                    themeBtn.setFocusPainted(false);

                    sideIcons.setBackground(Color.WHITE);
                    profile.setBackground(Color.WHITE);
                    home.setBackground(new Color(72, 71, 71));
                    Upload.setBackground(Color.WHITE);
                    message.setBackground(Color.WHITE);
                    watchlater.setBackground(Color.WHITE);
                    payment.setBackground(Color.WHITE);
                    theme.setBackground(Color.WHITE);
                    logout.setBackground(Color.WHITE);

                    pbtn.setForeground(Color.BLACK);
                    hbtn.setForeground(Color.WHITE);
                    ubtn.setForeground(Color.BLACK);
                    fbtn.setForeground(Color.BLACK);
                    watchbtn.setForeground(Color.BLACK);
                    paybtn.setForeground(Color.BLACK);
                    logoutBtn.setForeground(Color.BLACK);
                    ImageIcon up = new ImageIcon(this.getClass().getResource("uploadb.png"));
                    uicon.setIcon(up);
                    ImageIcon hom = new ImageIcon(this.getClass().getResource("home.png"));
                    hicon.setIcon(hom);
                    ImageIcon fil = new ImageIcon(this.getClass().getResource("notificationb.png"));
                    ficon.setIcon(fil);
                    ImageIcon watch = new ImageIcon(this.getClass().getResource("addb.png"));
                    watchicon.setIcon(watch);
                    ImageIcon pay = new ImageIcon(this.getClass().getResource("paymentb.png"));
                    payicon.setIcon(pay);
                    ImageIcon logicon = new ImageIcon(this.getClass().getResource("logoutb.png"));
                    logouticon.setIcon(logicon);
                    ImageIcon bcicon = new ImageIcon(this.getClass().getResource("circlelan.png"));
                    headerObj.backBtn.setIcon(bcicon);
                    ImageIcon backicon = new ImageIcon(this.getClass().getResource("forwb.png"));
                    headerObj.scrollerTopleft.setIcon(backicon);
                    ImageIcon nexticon = new ImageIcon(this.getClass().getResource("nextb.png"));
                    headerObj.scrollerTop.setIcon(nexticon);
                    ImageIcon profileimageiconb = new ImageIcon(this.getClass().getResource("forprofilew.png"));
                    profileimagelabel.setIcon(profileimageiconb);

//                    ImageIcon rightframe = new ImageIcon(this.getClass().getResource("RightFramew.png"));
//                    headerObj.p.rightFrame.setIcon(rightframe);
//                    ImageIcon leftframe = new ImageIcon(this.getClass().getResource("LeftFramew.png"));
//                    headerObj.p.leftFrame.setIcon(leftframe);
//                    ImageIcon framepp = new ImageIcon(this.getClass().getResource("FrameWhite50x50.png"));
//                    headerObj.p.frameLabel.setIcon(framepp);

                    Color w = new Color(197, 194, 194);
                    Color x = new Color(222, 216, 216);
                    Color b = new Color(0, 0, 0);

                    uploadObj.uploadFrame.setBackground(x);
                    uploadObj.price.setForeground(b);
                    uploadObj.basicInfo.setForeground(b);
                    uploadObj.firstName.setForeground(b);
                    uploadObj.firstNameInput.setBackground(new Color(197, 194, 194));
                    uploadObj.firstNameInput.setForeground(b);
                    uploadObj.middleName.setForeground(b);
                    uploadObj.middleNameInput.setBackground(w);
                    uploadObj.middleNameInput.setForeground(b);
                    uploadObj.lastName.setForeground(b);
                    uploadObj.lastNameInput.setBackground(w);
                    uploadObj.lastNameInput.setForeground(b);
                    uploadObj.genderL.setForeground(b);
                    uploadObj.gender.setBackground(w);
                    uploadObj.gender.setForeground(b);
                    uploadObj.contactInfo.setForeground(b);
                    uploadObj.Email.setForeground(b);
                    uploadObj.EmailInput.setBackground(w);
                    uploadObj.EmailInput.setForeground(b);
                    uploadObj.confirmEmail.setForeground(b);
                    uploadObj.confirmEmailInput.setBackground(w);
                    uploadObj.confirmEmailInput.setForeground(b);
                    uploadObj.phoneNo.setForeground(b);
                    uploadObj.phoneNoInput.setBackground(w);
                    uploadObj.phoneNoInput.setForeground(b);
                    uploadObj.countryCode.setBackground(w);
                    uploadObj.countryCode.setForeground(b);
                    uploadObj.houseInfo.setForeground(b);
                    uploadObj.Region.setForeground(b);
                    uploadObj.regionSelector.setBackground(w);
                    uploadObj.regionSelector.setForeground(b);
                    uploadObj.City.setForeground(b);
                    uploadObj.cityInput.setBackground(w);
                    uploadObj.cityInput.setForeground(b);
                    uploadObj.StreetAddress1.setForeground(b);
                    uploadObj.streetAddress1Input.setBackground(w);
                    uploadObj.streetAddress1Input.setForeground(b);
                    uploadObj.StreetAddress2.setForeground(b);
                    uploadObj.streetAddress2Input.setBackground(w);
                    uploadObj.streetAddress2Input.setForeground(b);
                    uploadObj.houseSize.setForeground(b);
                    uploadObj.houseSizeInput.setBackground(w);
                    uploadObj.houseSizeInput.setForeground(b);
                    uploadObj.bedroom.setForeground(b);
                    uploadObj.bedroomSize.setBackground(w);
                    uploadObj.bedroomSize.setForeground(b);
                    uploadObj.priceInput.setBackground(w);
                    uploadObj.priceInput.setForeground(b);
                    uploadObj.opinionL.setForeground(b);
                    uploadObj.opinion.setBackground(new Color(80, 79, 79));
                    uploadObj.opinion.setForeground(w);
                    uploadObj.op.setBackground(b);
                    uploadObj.holderTemp.setBackground(new Color(80, 79, 79));
                    uploadObj.imageChooser.setBackground(new Color(94, 92, 92));
                    uploadObj.uploadSubmit.setBackground(new Color(0, 119, 56));
                    uploadObj.water.setBackground(w);
                    uploadObj.electricity.setBackground(w);
                    uploadObj.water.setForeground(b);
                    uploadObj.electricity.setForeground(b);
                    uploadObj.upLabel.setForeground(b);


                    Color a = new Color(52, 51, 51);
                    Color cen = new Color(241, 241, 241);
                    paymentObj.payment.setBackground(cen);
                    paymentObj.center.setBackground(cen);
                    paymentObj.top.setBackground(new Color(217, 216, 216));
                    paymentObj.selectMethod.setForeground(a);
                    paymentObj.summaryHolder.setBackground(new Color(217, 216, 216));
                    paymentObj.paymentSummary.setForeground(a);
                    paymentObj.Deposit.setForeground(a);
                    paymentObj.CbeWallet.setForeground(a);
                    paymentObj.tele.setForeground(a);
                    paymentObj.other.setForeground(a);
                    paymentObj.monthly.setForeground(a);
                    paymentObj.monthlyfee.setForeground(a);
                    paymentObj.type.setForeground(a);
                    paymentObj.typeL.setForeground(a);
                    paymentObj.discount.setForeground(a);
                    paymentObj.discountL.setForeground(a);
                    paymentObj.total.setForeground(a);
                    paymentObj.totalL.setForeground(a);
                    paymentObj.paymethodsL.setForeground(a);
                    paymentObj.depo.setForeground(a);
                    paymentObj.depoInput.setBackground(cen);
                    paymentObj.depoInput.setForeground(b);
                    paymentObj.Name.setForeground(a);
                    paymentObj.nameInput.setBackground(cen);
                    paymentObj.nameInput.setForeground(b);
                    paymentObj.expiredate.setForeground(a);
                    paymentObj.expireInput.setBackground(cen);
                    paymentObj.expireInput.setForeground(b);
                    paymentObj.pin.setForeground(a);
                    paymentObj.pinInput.setBackground(cen);
                    paymentObj.pinInput.setForeground(b);
                    paymentObj.agreed.setForeground(a);
                    paymentObj.paybtn.setBackground(new Color(0, 0, 0));
                    paymentObj.paybtn.setForeground(cen);
                    headerObj.label.setForeground(a);

                    headerObj.backBtn.setForeground(cen);
                    headerObj.body.setBackground(cen);
                    headerObj.header.setBackground(cen);
                    headerObj.fullBody.setBackground(cen);
                    headerObj.lowerBody.setBackground(cen);
                    headerObj.eastTop.setBackground(cen);
                    headerObj.topLowerBody.setBackground(cen);
                    headerObj.topLabel.setForeground(cen);
                    headerObj.topsmall.setForeground(cen);
                    headerObj.lowerTop.setBackground(cen);
                    headerObj.btns[0].setBackground(cen);
                    headerObj.btns[0].setForeground(a);
                    headerObj.btns[0].setBorder(BorderFactory.createLineBorder(Color.black));
                    headerObj.btns[1].setBackground(cen);
                    headerObj.btns[1].setBorder(BorderFactory.createLineBorder(Color.black));
                    headerObj.btns[1].setForeground(a);
                    headerObj.btns[2].setBackground(cen);
                    headerObj.btns[2].setBorder(BorderFactory.createLineBorder(Color.black));
                    headerObj.btns[2].setForeground(a);
                    headerObj.mainPanel.setBackground(cen);
                    headerObj.homeStartpanel.setBackground(cen);
                    headerObj.homeStartLabel.setForeground(a);
                    headerObj.homeStartLabelsmall.setForeground(a);
                    headerObj.btns[2].setBackground(cen);
                    headerObj.btns[2].setBackground(cen);
                    headerObj.topLabel.setForeground(a);
                    headerObj.topsmall.setForeground(a);
                    headerObj.label.setForeground(a);
                    headerObj.sp.userInfo.setBackground(cen);
                    headerObj.sp.userInfo.setBackground(cen);
                    headerObj.sp.fullname.setForeground(a);
                    headerObj.sp.username.setForeground(a);
                    headerObj.sp.email.setForeground(a);
                    headerObj.sp.phone.setForeground(a);
                    headerObj.sp.fullnameL.setForeground(a);
                    headerObj.sp.usernameL.setForeground(a);
                    headerObj.sp.phoneL.setForeground(a);
                    headerObj.sp.emailL.setForeground(a);
                    headerObj.sp.chat.setForeground(cen);
                    headerObj.sp.chat.setBackground(a);
                    headerObj.sp.chat.setBackground(new Color(68, 65, 65));
                    ImageIcon ppsp = new ImageIcon(this.getClass().getResource("frame120w.png"));
                    headerObj.sp.profileHolder.setIcon(ppsp);

                    ImageIcon filtericon = new ImageIcon(this.getClass().getResource("filter.png"));
                    headerObj.searchicon.setForeground(a);
                    headerObj.searchicon.setIcon(filtericon);
                    headerObj.searchicon.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    headerObj.filterpanel.setBackground(new Color(105, 108, 124));
                    headerObj.comboHRegion.setBackground(new Color(105, 108, 124));
                    headerObj.comboHRegion.setForeground(a);
                    headerObj.combominPrice.setBackground(new Color(105, 108, 124));
                    headerObj.combominPrice.setForeground(a);
                    headerObj.combomaxPrice.setBackground(new Color(105, 108, 124));
                    headerObj.combomaxPrice.setForeground(a);
                    headerObj.combobedrooms.setBackground(new Color(105, 108, 124));
                    headerObj.combobedrooms.setForeground(a);
                    headerObj.combominArea.setBackground(new Color(105, 108, 124));
                    headerObj.combominArea.setForeground(a);
                    headerObj.combomaxArea.setBackground(new Color(105, 108, 124));
                    headerObj.combomaxArea.setForeground(a);
                    headerObj.apply.setForeground(Color.WHITE);
                    headerObj.apply.setBorder(BorderFactory.createLineBorder(Color.white));
                    headerObj.clear.setForeground(Color.WHITE);
                    headerObj.clear.setBorder(BorderFactory.createLineBorder(Color.white));

                    messageObj.frame.setBackground(new Color(211, 209, 209));
                    messageObj.scroller2.setBackground(new Color(211, 209, 209));
                    messageObj.scroller.setBackground(new Color(211, 209, 209));
                    messageObj.messages.setBackground(new Color(211, 209, 209));
                    messageObj.theimage.setBackground(new Color(174, 174, 175));
                    messageObj.theimage1.setBackground(new Color(174, 174, 175));
                    messageObj.theimage2.setBackground(new Color(174, 174, 175));

                    messageObj.messageArea.setBackground(new Color(174, 174, 175));
                    messageObj.emoji.setBackground(new Color(174, 174, 175));

                    messageObj.fmessage.setBackground(new Color(174, 174, 175));
                    messageObj.firstLabel.setForeground(b);
                    messageObj.secondLabel.setForeground(b);

                    messageObj.topHolder.setBackground(new Color(211, 209, 209));
                    messageObj.lowHolder.setBackground(new Color(211, 209, 209));
                    messageObj.search.setBackground(new Color(229, 219, 219));
                    messageObj.search.setForeground(b);

                    watchLaterObj.panel.setBackground(w);
                    watchLaterObj.panel1.setBackground(x);
                    watchLaterObj.main.setBackground(x);
                    watchLaterObj.scroller.setBackground(x);
                    watchLaterObj.Label.setForeground(b);
                    watchLaterObj.Label2.setForeground(b);

                    for (int i = 0; i < 100; i++) {
                        try {
                            if (!messageObj.mesSenter[i].equals(null)) {
                                messageObj.mesSenter[i].setBackground(new Color(190, 190, 190));
                                messageObj.date[i].setForeground(b);
                                messageObj.topHolderPP[i].setForeground(b);
                                messageObj.fromName[i].setForeground(b);
                                messageObj.prof[i].setIcon(new ImageIcon(this.getClass().getResource("profileb.png")));
                                messageObj.messpart[i].setBackground(new Color(166, 165, 165));
                            }
                        } catch (Exception eee) {
                            System.out.println("out of bound");
                            break;
                        }
                    }
                    messageObj.centerHolder.setBackground(new Color(178, 171, 171));
                    //messageObj.scroller2.setBackground(new Color(28, 29, 33));
                    for (int i = 0; i < 100; i++) {
                        try {
                            if (!messageObj.message[i].equals(null)) {
                                messageObj.themess[i].setForeground(new Color(241, 241, 241));
                                messageObj.message[i].setForeground(b);

                            }
                        } catch (Exception ae) {
                            System.out.println("out of bound2");
                            break;
                        }
                    }
                }
            }
        });


        theme.add(themeBtn);
        theme.add(statusLabel);
        lowerSideIc.add(theme);


        logout = new JPanel();
        logout.setBackground(new Color(16, 17, 20));
        logout.setLayout(null);
        logout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        logoutBtn = new JLabel("Logout");
        logoutBtn.setBounds(50, 10, 100, 30);
        logoutBtn.setHorizontalAlignment(JLabel.LEFT);
        logoutBtn.setForeground(Color.WHITE);
        logoutBtn.setFont(new Font("sanserif", Font.BOLD, 16));

        logouticon = new JLabel(new ImageIcon(this.getClass().getResource("logout.png")));
        logouticon.setBounds(15, 10, 30, 30);


        logout.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                logoutPage();
            }

            @Override
            public void mouseEntered(MouseEvent e) {

                logout.setBackground(new Color(240, 33, 7));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (togglebttnClicked) {
                    logout.setBackground(new Color(255, 255, 255));
                } else {
                    logout.setBackground(new Color(16, 17, 20));
                }
            }
        });

        logout.add(logoutBtn);
        logout.add(logouticon);
        lowerSideIc.add(logout);


        sideIcons.add(upperSideIc, BorderLayout.NORTH);
        sideIcons.add(lowerSideIc, BorderLayout.SOUTH);

        card2 = new CardLayout();
        cardPane2 = new JPanel();


        try {
            uploadObj = new Upload();
            messageObj = new Message();
            paymentObj = new Payment();
            headerObj = new Header();
            ProfileObj = new Profile(getUsername);
            LoadingObj = new Loading();
            watchLaterObj = new WatchLater();

            cardPane2.setLayout(card2);
            cardPane2.add(headerObj.getHeaderPanel(), "Header");

            cardPane2.add(ProfileObj.getProfilePanel(), "Profile");
            cardPane2.add(uploadObj.getUploadPane(), "Upload");
            cardPane2.add(messageObj.getMessagePanel(), "Notifications");
            cardPane2.add(paymentObj.getPaymentPanel(), "Payment");
            cardPane2.add(watchLaterObj.getWatchLaterPanel(), "WatchLater");

        } catch (NullPointerException e) {
            e.printStackTrace();
        }


        ////////////////////////////////to not couse null pointer exception///////////////////////////////////////
        ImageIcon profileimage = ResizeImage(ProfileObj.profileImage, 30, 30);
        picon.setIcon(profileimage);

        ImageIcon profileimageiconb = new ImageIcon(this.getClass().getResource("forprofile.png"));
        profileimagelabel = new JLabel(profileimageiconb);
        profileimagelabel.setBounds(10, 10, 30, 30);

        profile.add(profileimagelabel);
        profile.add(pbtn);
        profile.add(picon);
        /////////////////////////////////////////////////////////////////////////////////////////////////////////


        headerObj.backBtn.addActionListener(e -> {

            if (!languagebtnClicked) {
                headerObj.label.setText("En");
                headerObj.label.setFont(new Font("Abyssinica SIL", Font.BOLD, 16));
                headerObj.label.setBounds(30, 10, 30, 30);


                uploadObj.price.setText("ዋጋ");
                uploadObj.price.setFont(new Font("Abyssinica SIL", Font.PLAIN, 18));

                uploadObj.basicInfo.setText("መሰረታዊ መረጃ");
                uploadObj.basicInfo.setFont(new Font("Abyssinica SIL", Font.PLAIN, 22));

                uploadObj.firstName.setText("የራስ ስም");
                uploadObj.firstName.setFont(new Font("Abyssinica SIL", Font.PLAIN, 18));

                uploadObj.middleName.setText("የአባት ስም");
                uploadObj.middleName.setFont(new Font("Abyssinica SIL", Font.PLAIN, 18));

                uploadObj.lastName.setText("የአያት ስም");
                uploadObj.lastName.setFont(new Font("Abyssinica SIL", Font.PLAIN, 18));

                uploadObj.genderL.setText("ጾታ");
                uploadObj.genderL.setFont(new Font("Abyssinica SIL", Font.PLAIN, 18));

                uploadObj.contactInfo.setText("መገኛ መርጃ");
                uploadObj.contactInfo.setFont(new Font("Abyssinica SIL", Font.PLAIN, 22));

                uploadObj.Email.setText("ኢሜይል");
                uploadObj.Email.setFont(new Font("Abyssinica SIL", Font.PLAIN, 18));

                uploadObj.confirmEmail.setText("ኢሜይል አረጋግጥ");
                uploadObj.confirmEmail.setFont(new Font("Abyssinica SIL", Font.PLAIN, 18));

                uploadObj.houseInfo.setText("ስለ ቤት መረጃ");
                uploadObj.houseInfo.setFont(new Font("Abyssinica SIL", Font.PLAIN, 18));

                uploadObj.Region.setText("ከልል");
                uploadObj.Region.setFont(new Font("Abyssinica SIL", Font.PLAIN, 18));

                uploadObj.City.setText("ክተማ");
                uploadObj.City.setFont(new Font("Abyssinica SIL", Font.PLAIN, 18));

                uploadObj.StreetAddress1.setText("የሰፈር ስም");
                uploadObj.StreetAddress1.setFont(new Font("Abyssinica SIL", Font.PLAIN, 18));

                uploadObj.StreetAddress2.setText("የሰፈር ስም(በምርጫ)");
                uploadObj.StreetAddress2.setFont(new Font("Abyssinica SIL", Font.PLAIN, 18));

                uploadObj.houseSize.setText("የቤት ስፋት");
                uploadObj.houseSize.setFont(new Font("Abyssinica SIL", Font.PLAIN, 18));

                uploadObj.bedroom.setText("መኝታ ቤት ብዛት");
                uploadObj.bedroom.setFont(new Font("Abyssinica SIL", Font.PLAIN, 18));

                uploadObj.opinionL.setText("ተጨማሪ ሃሳብ");
                uploadObj.opinionL.setFont(new Font("Abyssinica SIL", Font.PLAIN, 18));

                uploadObj.upLabel.setText("የባለቤቶች ፎርም");
                uploadObj.upLabel.setFont(new Font("Abyssinica SIL", Font.PLAIN, 26));

                uploadObj.water.setText("የውሃ አገልግሎት የትሟላ");
                uploadObj.water.setFont(new Font("Abyssinica SIL", Font.PLAIN, 16));

                uploadObj.electricity.setText("የኤሌክትሪክ አገልግሎት የተሟላ");
                uploadObj.electricity.setFont(new Font("Abyssinica SIL", Font.PLAIN, 16));

                uploadObj.imageChooser.setText("ፎቶ አስገባ");
                uploadObj.imageChooser.setFont(new Font("Abyssinica SIL", Font.PLAIN, 18));

                uploadObj.uploadSubmit.setText("ጫን");
                uploadObj.uploadSubmit.setFont(new Font("Abyssinica SIL", Font.PLAIN, 18));

                pbtn.setText("ፕሮፋይል");
                pbtn.setFont(new Font("Abyssinica SIL", Font.PLAIN, 18));

                hbtn.setText("መግቢያ");
                hbtn.setFont(new Font("Abyssinica SIL", Font.PLAIN, 18));

                ubtn.setText("ጫን");
                ubtn.setFont(new Font("Abyssinica SIL", Font.PLAIN, 18));

                fbtn.setText("መልእክቶች");
                fbtn.setFont(new Font("Abyssinica SIL", Font.PLAIN, 18));

                watchbtn.setText("የተመረጡ");
                watchbtn.setFont(new Font("Abyssinica SIL", Font.PLAIN, 18));

                paybtn.setText("ክፍያ");
                paybtn.setFont(new Font("Abyssinica SIL", Font.PLAIN, 18));

                headerObj.topLabel.setFont(new Font("Abyssinica SIL", Font.PLAIN, 32));
                headerObj.topLabel.setText("Cheapደላላ");

                headerObj.topsmall.setText("ምን ተፈጠረ");
                headerObj.topsmall.setFont(new Font("Abyssinica SIL", Font.PLAIN, 22));

                headerObj.btns[0].setText("በገብያ ላይ ያሉ ቤቶች");
                headerObj.btns[0].setFont(new Font("Abyssinica SIL", Font.PLAIN, 18));
                headerObj.btns[1].setText("በረከሰ ዋጋ");
                headerObj.btns[1].setFont(new Font("Abyssinica SIL", Font.PLAIN, 18));
                headerObj.btns[2].setText("ስለ እኛ");
                headerObj.btns[2].setFont(new Font("Abyssinica SIL", Font.PLAIN, 18));
                headerObj.homeStartLabel.setText("በቅርብ የተጨመሩ ቤቶች");
                headerObj.homeStartLabel.setFont(new Font("Abyssinica SIL", Font.PLAIN, 22));

                headerObj.homeStartLabelsmall.setText("በምርጫዎ ቤቶችን ይፈጉ (ቶሎ ለማግኘት ፊልተር መጠቀም ይችላሉ)");
                headerObj.homeStartLabelsmall.setFont(new Font("Abyssinica SIL", Font.PLAIN, 16));

                paymentObj.selectMethod.setText("የክፍያ መንገድ ይምረጡ");
                paymentObj.selectMethod.setFont(new Font("Abyssinica SIL", Font.BOLD, 22));

                paymentObj.paymentSummary.setText("አጠቃላይ ክፍያ መጠን");
                paymentObj.paymentSummary.setFont(new Font("Abyssinica SIL", Font.BOLD, 22));

                paymentObj.Deposit.setText("ተቀማጭ");
                paymentObj.Deposit.setFont(new Font("Abyssinica SIL", Font.BOLD, 16));

                paymentObj.CbeWallet.setText("ሲቢኢ ዋሌት");
                paymentObj.CbeWallet.setFont(new Font("Abyssinica SIL", Font.BOLD, 16));

                paymentObj.tele.setText("ቴሌ ብር");
                paymentObj.tele.setFont(new Font("Abyssinica SIL", Font.BOLD, 16));

                paymentObj.other.setText("ሌላ");
                paymentObj.other.setFont(new Font("Abyssinica SIL", Font.BOLD, 16));

                paymentObj.monthly.setText("ወርሃዊ ክፍያ");
                paymentObj.monthly.setFont(new Font("Abyssinica SIL", Font.BOLD, 16));

                paymentObj.monthlyfee.setText("100 ብር");
                paymentObj.monthlyfee.setFont(new Font("Abyssinica SIL", Font.BOLD, 16));

                paymentObj.typeL.setText("አይነት");
                paymentObj.typeL.setFont(new Font("Abyssinica SIL", Font.BOLD, 16));

                paymentObj.type.setText("መደበኛ");
                paymentObj.type.setFont(new Font("Abyssinica SIL", Font.BOLD, 16));

                paymentObj.discount.setText("10%");
                paymentObj.discount.setFont(new Font("Abyssinica SIL", Font.BOLD, 16));

                paymentObj.discountL.setText("ተቀናሽ");
                paymentObj.discountL.setFont(new Font("Abyssinica SIL", Font.BOLD, 16));

                paymentObj.total.setText("90 ብር");
                paymentObj.total.setFont(new Font("Abyssinica SIL", Font.BOLD, 16));

                paymentObj.totalL.setText("አጠቃላይ");
                paymentObj.totalL.setFont(new Font("Abyssinica SIL", Font.BOLD, 16));

                paymentObj.depo.setText("ተቀማጭ ሂሳብ ቁጥር");
                paymentObj.depo.setFont(new Font("Abyssinica SIL", Font.BOLD, 16));

                paymentObj.Name.setText("ስም");
                paymentObj.Name.setFont(new Font("Abyssinica SIL", Font.BOLD, 16));

                paymentObj.expiredate.setText("ማብቂያ ቀን");
                paymentObj.expiredate.setFont(new Font("Abyssinica SIL", Font.BOLD, 16));

                paymentObj.pin.setText("ሚስጥር ቁጥር");
                paymentObj.pin.setFont(new Font("Abyssinica SIL", Font.BOLD, 16));

                paymentObj.sure.setText("አዎ");
                paymentObj.sure.setFont(new Font("Abyssinica SIL", Font.BOLD, 16));

                paymentObj.notsure.setText("አልፈልግም");
                paymentObj.notsure.setFont(new Font("Abyssinica SIL", Font.BOLD, 16));

                paymentObj.assurance.setText("በድጋሜ መክፈል ይፈልጋሉ");
                paymentObj.assurance.setFont(new Font("Abyssinica SIL", Font.BOLD, 16));

                watchLaterObj.Label.setText("ሰላም ደምበኛችን");
                watchLaterObj.Label.setFont(new Font("Abyssinica SIL", Font.BOLD, 36));

                watchLaterObj.Label2.setText("ከታች የተዘረዘሩት ከዚህ በፊት ለማየት የመረጡዋቸው ቤቶች ናቸው");
                watchLaterObj.Label2.setFont(new Font("Abyssinica SIL", Font.BOLD, 22));


                logoutBtn.setText("ውጣ");
                logoutBtn.setFont(new Font("Abyssinica SIL", Font.PLAIN, 20));

                languagebtnClicked = true;
            } else {
                headerObj.label.setText("አ");
                headerObj.label.setFont(new Font("Abyssinica SIL", Font.BOLD, 16));
                headerObj.label.setBounds(35, 10, 30, 30);


                languagebtnClicked = false;
                uploadObj.price.setText("Price");
                uploadObj.price.setFont(new Font("Abyssinica SIL", Font.PLAIN, 18));

                uploadObj.basicInfo.setText("Basic Info");
                uploadObj.basicInfo.setFont(new Font("Abyssinica SIL", Font.PLAIN, 22));

                uploadObj.firstName.setText("First Name");
                uploadObj.firstName.setFont(new Font("Abyssinica SIL", Font.PLAIN, 18));

                uploadObj.middleName.setText("Middle Name");
                uploadObj.middleName.setFont(new Font("Abyssinica SIL", Font.PLAIN, 18));

                uploadObj.lastName.setText("Last Name");
                uploadObj.lastName.setFont(new Font("Abyssinica SIL", Font.PLAIN, 18));

                uploadObj.genderL.setText("Gender");
                uploadObj.genderL.setFont(new Font("Abyssinica SIL", Font.PLAIN, 18));

                uploadObj.contactInfo.setText("Contact Info");
                uploadObj.contactInfo.setFont(new Font("Abyssinica SIL", Font.PLAIN, 22));

                uploadObj.Email.setText("Email");
                uploadObj.Email.setFont(new Font("Abyssinica SIL", Font.PLAIN, 18));

                uploadObj.confirmEmail.setText("Confirm Email");
                uploadObj.confirmEmail.setFont(new Font("Abyssinica SIL", Font.PLAIN, 18));

                uploadObj.houseInfo.setText("House Info");
                uploadObj.houseInfo.setFont(new Font("Abyssinica SIL", Font.PLAIN, 18));

                uploadObj.Region.setText("Region");
                uploadObj.Region.setFont(new Font("Abyssinica SIL", Font.PLAIN, 18));

                uploadObj.City.setText("City");
                uploadObj.City.setFont(new Font("Abyssinica SIL", Font.PLAIN, 18));

                uploadObj.StreetAddress1.setText("Street Address");
                uploadObj.StreetAddress1.setFont(new Font("Abyssinica SIL", Font.PLAIN, 18));

                uploadObj.StreetAddress2.setText("Street Address2(Optional)");
                uploadObj.StreetAddress2.setFont(new Font("Abyssinica SIL", Font.PLAIN, 18));

                uploadObj.houseSize.setText("House Size(sqCare)");
                uploadObj.houseSize.setFont(new Font("Abyssinica SIL", Font.PLAIN, 18));

                uploadObj.bedroom.setText("Bedroom Size");
                uploadObj.bedroom.setFont(new Font("Abyssinica SIL", Font.PLAIN, 18));

                uploadObj.opinionL.setText("Additional Info");
                uploadObj.opinionL.setFont(new Font("Abyssinica SIL", Font.PLAIN, 18));

                uploadObj.upLabel.setText("Owners Form");
                uploadObj.upLabel.setFont(new Font("Abyssinica SIL", Font.PLAIN, 26));

                uploadObj.water.setText("Water is Available");
                uploadObj.water.setFont(new Font("Abyssinica SIL", Font.PLAIN, 16));

                uploadObj.electricity.setText("Electricity is Available");
                uploadObj.electricity.setFont(new Font("Abyssinica SIL", Font.PLAIN, 16));

                uploadObj.imageChooser.setText("Select Image");
                uploadObj.imageChooser.setFont(new Font("Abyssinica SIL", Font.PLAIN, 18));

                uploadObj.uploadSubmit.setText("Upload");
                uploadObj.uploadSubmit.setFont(new Font("Abyssinica SIL", Font.PLAIN, 18));

                pbtn.setText("Profile");
                pbtn.setFont(new Font("Abyssinica SIL", Font.PLAIN, 18));

                hbtn.setText("Home");
                hbtn.setFont(new Font("Abyssinica SIL", Font.PLAIN, 18));

                ubtn.setText("Upload");
                ubtn.setFont(new Font("Abyssinica SIL", Font.PLAIN, 18));

                fbtn.setText("Notifications");
                fbtn.setFont(new Font("Abyssinica SIL", Font.PLAIN, 18));

                watchbtn.setText("Watch Later");
                watchbtn.setFont(new Font("Abyssinica SIL", Font.PLAIN, 18));

                paybtn.setText("Payment");
                paybtn.setFont(new Font("Abyssinica SIL", Font.PLAIN, 18));

                headerObj.topLabel.setFont(new Font("Abyssinica SIL", Font.PLAIN, 32));
                headerObj.topLabel.setText("Cheap Delala");

                headerObj.topsmall.setText("What's happening");
                headerObj.topsmall.setFont(new Font("Abyssinica SIL", Font.PLAIN, 22));

                headerObj.btns[0].setText("AVAILABLE HOUSES");
                headerObj.btns[0].setFont(new Font("Abyssinica SIL", Font.PLAIN, 18));
                headerObj.btns[1].setText("GET IT CHEAP");
                headerObj.btns[1].setFont(new Font("Abyssinica SIL", Font.PLAIN, 18));
                headerObj.btns[2].setText("ABOUT US");
                headerObj.btns[2].setFont(new Font("Abyssinica SIL", Font.PLAIN, 18));
                headerObj.homeStartLabel.setText("Reaceantly added");
                headerObj.homeStartLabel.setFont(new Font("Abyssinica SIL", Font.PLAIN, 22));

                headerObj.homeStartLabelsmall.setText("Explore houses with you specifications! (you can use filter)");
                headerObj.homeStartLabelsmall.setFont(new Font("Abyssinica SIL", Font.PLAIN, 16));

                paymentObj.selectMethod.setText("Select Payment method");
                paymentObj.selectMethod.setFont(new Font("Abyssinica SIL", Font.BOLD, 18));

                paymentObj.paymentSummary.setText("Payment Summary");
                paymentObj.paymentSummary.setFont(new Font("Abyssinica SIL", Font.BOLD, 18));

                paymentObj.Deposit.setText("Deposit");
                paymentObj.Deposit.setFont(new Font("Abyssinica SIL", Font.PLAIN, 14));

                paymentObj.CbeWallet.setText("CBE Wallet");
                paymentObj.CbeWallet.setFont(new Font("Abyssinica SIL", Font.PLAIN, 14));

                paymentObj.tele.setText("Tele Birr");
                paymentObj.tele.setFont(new Font("Abyssinica SIL", Font.PLAIN, 14));

                paymentObj.other.setText("Other");
                paymentObj.other.setFont(new Font("Abyssinica SIL", Font.PLAIN, 14));

                paymentObj.monthly.setText("Monthly Fee");
                paymentObj.monthly.setFont(new Font("Abyssinica SIL", Font.PLAIN, 14));

                paymentObj.monthlyfee.setText("100 Birr");
                paymentObj.monthlyfee.setFont(new Font("Abyssinica SIL", Font.PLAIN, 14));

                paymentObj.typeL.setText("Type");
                paymentObj.typeL.setFont(new Font("Abyssinica SIL", Font.PLAIN, 14));

                paymentObj.type.setText("Standard");
                paymentObj.type.setFont(new Font("Abyssinica SIL", Font.PLAIN, 14));

                paymentObj.discount.setText("10%");
                paymentObj.discount.setFont(new Font("Abyssinica SIL", Font.PLAIN, 14));

                paymentObj.discountL.setText("Discount");
                paymentObj.discountL.setFont(new Font("Abyssinica SIL", Font.PLAIN, 14));

                paymentObj.total.setText("90 Birr");
                paymentObj.total.setFont(new Font("Abyssinica SIL", Font.PLAIN, 14));

                paymentObj.totalL.setText("Total");
                paymentObj.totalL.setFont(new Font("Abyssinica SIL", Font.PLAIN, 14));

                paymentObj.depo.setText("Depo Number");
                paymentObj.depo.setFont(new Font("Abyssinica SIL", Font.PLAIN, 14));

                paymentObj.Name.setText("Name");
                paymentObj.Name.setFont(new Font("Abyssinica SIL", Font.PLAIN, 14));

                paymentObj.expiredate.setText("Expire date");
                paymentObj.expiredate.setFont(new Font("Abyssinica SIL", Font.PLAIN, 14));

                paymentObj.pin.setText("Pin Code");
                paymentObj.pin.setFont(new Font("Abyssinica SIL", Font.PLAIN, 14));

                paymentObj.sure.setText("Yes");
                paymentObj.sure.setFont(new Font("Abyssinica SIL", Font.PLAIN, 14));

                paymentObj.notsure.setText("No");
                paymentObj.notsure.setFont(new Font("Abyssinica SIL", Font.PLAIN, 14));

                paymentObj.assurance.setText("do you want to make a payment again?");
                paymentObj.assurance.setFont(new Font("Abyssinica SIL", Font.PLAIN, 14));

                watchLaterObj.Label.setText("Hello Customer");
                watchLaterObj.Label.setFont(new Font("Abyssinica SIL", Font.BOLD, 36));

                watchLaterObj.Label2.setText("This is your list of houses that you were interested to watch");
                watchLaterObj.Label2.setFont(new Font("Abyssinica SIL", Font.BOLD, 22));

                logoutBtn.setText("Log Out");
                logoutBtn.setFont(new Font("Abyssinica SIL", Font.PLAIN, 20));
            }
        });


        frame.add(BorderLayout.CENTER, cardPane2);
        frame.add(sideIcons, BorderLayout.WEST);
        // new Colors(sideIcons,profile,home,Upload,message,watchlater,payment,theme,logout);
        frame.setVisible(true);

    }

    public ImageIcon ResizeImage(String ImagePath) {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(upImages.getWidth(), upImages.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

    public ImageIcon ResizeImage(ImageIcon ImagePath, int width, int height) {
        ImageIcon MyImage = ImagePath;
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

    class ProfileListener implements MouseListener {

        @Override
        public void mousePressed(MouseEvent e) {
            if (togglebttnClicked) {
                profile.setBackground(new Color(130, 130, 130));
                home.setBackground(new Color(70, 89, 91));
                Upload.setBackground(new Color(255, 255, 255));
                message.setBackground(new Color(255, 255, 255));
                payment.setBackground(new Color(255, 255, 255));
                watchlater.setBackground(new Color(255, 255, 255));
            } else {
                profile.setBackground(new Color(130, 130, 130));
                home.setBackground(new Color(70, 89, 91));
                Upload.setBackground(new Color(16, 17, 20));
                message.setBackground(new Color(16, 17, 20));
                payment.setBackground(new Color(16, 17, 20));
                watchlater.setBackground(new Color(16, 17, 20));
            }
//            card.show(cardPane, "Profile");
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if (togglebttnClicked) {
                profile.setBackground(new Color(255, 255, 255));
                home.setBackground(new Color(70, 89, 91));
                Upload.setBackground(new Color(255, 255, 255));
                message.setBackground(new Color(255, 255, 255));
                payment.setBackground(new Color(255, 255, 255));
                watchlater.setBackground(new Color(255, 255, 255));
            } else {
                profile.setBackground(new Color(16, 17, 20));
                home.setBackground(new Color(70, 89, 91));
                Upload.setBackground(new Color(16, 17, 20));
                message.setBackground(new Color(16, 17, 20));
                payment.setBackground(new Color(16, 17, 20));
                watchlater.setBackground(new Color(16, 17, 20));
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            profile.setBackground(new Color(107, 106, 106));
            home.setBackground(new Color(70, 89, 91));
        }

        @Override
        public void mouseExited(MouseEvent e) {

            if (togglebttnClicked)
                profile.setBackground(new Color(255, 255, 255));
            if (!togglebttnClicked) {
                profile.setBackground(new Color(16, 17, 20));
            }
            home.setBackground(new Color(70, 89, 91));
        }

        @Override
        public void mouseClicked(MouseEvent e) {

            if (togglebttnClicked) {
                profile.setBackground(new Color(88, 89, 91));
                home.setBackground(new Color(70, 89, 91));
                Upload.setBackground(new Color(255, 255, 255));
                message.setBackground(new Color(255, 255, 255));
                payment.setBackground(new Color(255, 255, 255));
                watchlater.setBackground(new Color(255, 255, 255));
                card2.show(cardPane2, "Profile");
            } else {
                profile.setBackground(new Color(88, 89, 91));
                home.setBackground(new Color(70, 89, 91));
                Upload.setBackground(new Color(16, 17, 20));
                message.setBackground(new Color(16, 17, 20));
                payment.setBackground(new Color(16, 17, 20));
                watchlater.setBackground(new Color(16, 17, 20));
                card2.show(cardPane2, "Profile");

            }
        }
    }

    class HomeListener implements MouseListener {

        @Override
        public void mousePressed(MouseEvent e) {
            if (togglebttnClicked) {
                profile.setBackground(new Color(255, 255, 255));
                home.setBackground(new Color(130, 130, 130));
                Upload.setBackground(new Color(255, 255, 255));
                message.setBackground(new Color(255, 255, 255));
                payment.setBackground(new Color(255, 255, 255));
                watchlater.setBackground(new Color(255, 255, 255));
            } else {
                profile.setBackground(new Color(16, 17, 20));
                home.setBackground(new Color(130, 130, 130));
                Upload.setBackground(new Color(16, 17, 20));
                message.setBackground(new Color(16, 17, 20));
                payment.setBackground(new Color(16, 17, 20));
                watchlater.setBackground(new Color(16, 17, 20));
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if (togglebttnClicked) {
                profile.setBackground(new Color(255, 255, 255));
                home.setBackground(new Color(70, 89, 91));
                Upload.setBackground(new Color(255, 255, 255));
                message.setBackground(new Color(255, 255, 255));
                payment.setBackground(new Color(255, 255, 255));
                watchlater.setBackground(new Color(255, 255, 255));
            } else {
                profile.setBackground(new Color(16, 17, 20));
                home.setBackground(new Color(70, 89, 91));
                Upload.setBackground(new Color(16, 17, 20));
                message.setBackground(new Color(16, 17, 20));
                payment.setBackground(new Color(16, 17, 20));
                watchlater.setBackground(new Color(16, 17, 20));
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            home.setBackground(new Color(171, 169, 169));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            home.setBackground(new Color(255, 255, 255));
            if (!togglebttnClicked) {
                home.setBackground(new Color(16, 17, 20));
            }

        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if (togglebttnClicked) {
                profile.setBackground(new Color(255, 255, 255));
                home.setBackground(new Color(88, 89, 91));
                Upload.setBackground(new Color(255, 255, 255));
                message.setBackground(new Color(255, 255, 255));
                payment.setBackground(new Color(255, 255, 255));
                watchlater.setBackground(new Color(255, 255, 255));
                card2.show(cardPane2, "Header");
            } else {
                profile.setBackground(new Color(16, 17, 20));
                home.setBackground(new Color(88, 89, 91));
                Upload.setBackground(new Color(16, 17, 20));
                message.setBackground(new Color(16, 17, 20));
                payment.setBackground(new Color(16, 17, 20));
                watchlater.setBackground(new Color(16, 17, 20));
                card2.show(cardPane2, "Header");
            }
        }
    }

    class UploadListener implements MouseListener {

        @Override
        public void mousePressed(MouseEvent e) {
            if (togglebttnClicked) {
                profile.setBackground(new Color(255, 255, 255));
                home.setBackground(new Color(70, 89, 91));
                Upload.setBackground(new Color(130, 130, 130));
                message.setBackground(new Color(255, 255, 255));
                payment.setBackground(new Color(255, 255, 255));
                watchlater.setBackground(new Color(255, 255, 255));
            } else {
                profile.setBackground(new Color(16, 17, 20));
                home.setBackground(new Color(70, 89, 91));
                Upload.setBackground(new Color(130, 130, 130));
                message.setBackground(new Color(16, 17, 20));
                payment.setBackground(new Color(16, 17, 20));
                watchlater.setBackground(new Color(16, 17, 20));
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if (togglebttnClicked) {
                profile.setBackground(new Color(255, 255, 255));
                home.setBackground(new Color(70, 89, 91));
                Upload.setBackground(new Color(255, 255, 255));
                message.setBackground(new Color(255, 255, 255));
                payment.setBackground(new Color(255, 255, 255));
                watchlater.setBackground(new Color(255, 255, 255));
            } else {
                profile.setBackground(new Color(16, 17, 20));
                home.setBackground(new Color(70, 89, 91));
                Upload.setBackground(new Color(16, 17, 20));
                message.setBackground(new Color(16, 17, 20));
                payment.setBackground(new Color(16, 17, 20));
                watchlater.setBackground(new Color(16, 17, 20));
            }

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            home.setBackground(new Color(70, 89, 91));
            Upload.setBackground(new Color(171, 169, 169));

        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (togglebttnClicked)
                Upload.setBackground(new Color(96, 95, 95));
            if (togglebttnClicked)
                Upload.setBackground(new Color(255, 255, 255));
            if (!togglebttnClicked) {
                Upload.setBackground(new Color(16, 17, 20));
            }
            home.setBackground(new Color(70, 89, 91));
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if (togglebttnClicked) {
                profile.setBackground(new Color(255, 255, 255));
                home.setBackground(new Color(70, 89, 91));
                Upload.setBackground(new Color(88, 89, 91));
                message.setBackground(new Color(255, 255, 255));
                payment.setBackground(new Color(255, 255, 255));
                watchlater.setBackground(new Color(255, 255, 255));
                card2.show(cardPane2, "Upload");
            } else {
                profile.setBackground(new Color(16, 17, 20));
                home.setBackground(new Color(70, 89, 91));
                Upload.setBackground(new Color(88, 89, 91));
                message.setBackground(new Color(16, 17, 20));
                payment.setBackground(new Color(16, 17, 20));
                watchlater.setBackground(new Color(16, 17, 20));
                card2.show(cardPane2, "Upload");
            }

        }
    }

    class messageListener implements MouseListener {

        @Override
        public void mousePressed(MouseEvent e) {
            if (togglebttnClicked) {
                profile.setBackground(new Color(255, 255, 255));
                home.setBackground(new Color(70, 89, 91));
                Upload.setBackground(new Color(255, 255, 255));
                message.setBackground(new Color(130, 130, 130));
                payment.setBackground(new Color(255, 255, 255));
                watchlater.setBackground(new Color(255, 255, 255));
            } else {
                profile.setBackground(new Color(16, 17, 20));
                home.setBackground(new Color(70, 89, 91));
                Upload.setBackground(new Color(16, 17, 20));
                message.setBackground(new Color(130, 130, 130));
                payment.setBackground(new Color(16, 17, 20));
                watchlater.setBackground(new Color(16, 17, 20));
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if (togglebttnClicked) {
                profile.setBackground(new Color(255, 255, 255));
                home.setBackground(new Color(70, 89, 91));
                Upload.setBackground(new Color(255, 255, 255));
                message.setBackground(new Color(255, 255, 255));
                payment.setBackground(new Color(255, 255, 255));
                watchlater.setBackground(new Color(255, 255, 255));
            } else {
                profile.setBackground(new Color(16, 17, 20));
                home.setBackground(new Color(70, 89, 91));
                Upload.setBackground(new Color(16, 17, 20));
                message.setBackground(new Color(16, 17, 20));
                payment.setBackground(new Color(16, 17, 20));
                watchlater.setBackground(new Color(16, 17, 20));
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {

            home.setBackground(new Color(70, 89, 91));
            message.setBackground(new Color(171, 169, 169));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (togglebttnClicked)
                message.setBackground(new Color(96, 95, 95));
            if (togglebttnClicked)
                message.setBackground(new Color(255, 255, 255));
            if (!togglebttnClicked) {
                message.setBackground(new Color(16, 17, 20));
            }
            home.setBackground(new Color(70, 89, 91));
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if (togglebttnClicked) {
                profile.setBackground(new Color(255, 255, 255));
                home.setBackground(new Color(70, 89, 91));
                Upload.setBackground(new Color(255, 255, 255));
                message.setBackground(new Color(88, 89, 91));
                payment.setBackground(new Color(255, 255, 255));
                watchlater.setBackground(new Color(255, 255, 255));
                card2.show(cardPane2, "Notifications");
            } else {
                profile.setBackground(new Color(16, 17, 20));
                home.setBackground(new Color(70, 89, 91));
                Upload.setBackground(new Color(16, 17, 20));
                message.setBackground(new Color(88, 89, 91));
                payment.setBackground(new Color(16, 17, 20));
                watchlater.setBackground(new Color(16, 17, 20));
                card2.show(cardPane2, "Notifications");
            }
        }
    }

    class WatchlaterListner implements MouseListener {

        @Override
        public void mousePressed(MouseEvent e) {
            if (togglebttnClicked) {
                profile.setBackground(new Color(255, 255, 255));
                home.setBackground(new Color(70, 89, 91));
                Upload.setBackground(new Color(255, 255, 255));
                message.setBackground(new Color(255, 255, 255));
                payment.setBackground(new Color(255, 255, 255));
                watchlater.setBackground(new Color(130, 130, 130));
            } else {
                profile.setBackground(new Color(16, 17, 20));
                home.setBackground(new Color(70, 89, 91));
                Upload.setBackground(new Color(16, 17, 20));
                message.setBackground(new Color(16, 17, 20));
                payment.setBackground(new Color(16, 17, 20));
                watchlater.setBackground(new Color(130, 130, 130));
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if (togglebttnClicked) {
                profile.setBackground(new Color(255, 255, 255));
                home.setBackground(new Color(70, 89, 91));
                Upload.setBackground(new Color(255, 255, 255));
                message.setBackground(new Color(255, 255, 255));
                payment.setBackground(new Color(255, 255, 255));
                watchlater.setBackground(new Color(255, 255, 255));
            } else {
                profile.setBackground(new Color(16, 17, 20));
                home.setBackground(new Color(70, 89, 91));
                Upload.setBackground(new Color(16, 17, 20));
                message.setBackground(new Color(16, 17, 20));
                payment.setBackground(new Color(16, 17, 20));
                watchlater.setBackground(new Color(16, 17, 20));
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {

            home.setBackground(new Color(70, 89, 91));
            watchlater.setBackground(new Color(171, 169, 169));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (togglebttnClicked)
                watchlater.setBackground(new Color(96, 95, 95));
            if (togglebttnClicked)
                watchlater.setBackground(new Color(255, 255, 255));
            if (!togglebttnClicked) {
                watchlater.setBackground(new Color(16, 17, 20));
            }
            home.setBackground(new Color(70, 89, 91));
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if (togglebttnClicked) {
                profile.setBackground(new Color(255, 255, 255));
                home.setBackground(new Color(70, 89, 91));
                Upload.setBackground(new Color(255, 255, 255));
                message.setBackground(new Color(255, 255, 255));
                payment.setBackground(new Color(255, 255, 255));
                watchlater.setBackground(new Color(88, 89, 91));
            } else {
                profile.setBackground(new Color(16, 17, 20));
                home.setBackground(new Color(70, 89, 91));
                Upload.setBackground(new Color(16, 17, 20));
                message.setBackground(new Color(16, 17, 20));
                payment.setBackground(new Color(16, 17, 20));
                watchlater.setBackground(new Color(88, 89, 91));
            }
            card2.show(cardPane2, "WatchLater");
        }
    }

    class PaymentListener implements MouseListener {

        @Override
        public void mousePressed(MouseEvent e) {
            if (togglebttnClicked) {
                profile.setBackground(new Color(255, 255, 255));
                home.setBackground(new Color(70, 89, 91));
                Upload.setBackground(new Color(255, 255, 255));
                message.setBackground(new Color(255, 255, 255));
                payment.setBackground(new Color(130, 130, 130));
                watchlater.setBackground(new Color(255, 255, 255));
            } else {
                profile.setBackground(new Color(16, 17, 20));
                home.setBackground(new Color(70, 89, 91));
                Upload.setBackground(new Color(16, 17, 20));
                message.setBackground(new Color(16, 17, 20));
                payment.setBackground(new Color(130, 130, 130));
                watchlater.setBackground(new Color(16, 17, 20));
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if (togglebttnClicked) {
                profile.setBackground(new Color(255, 255, 255));
                home.setBackground(new Color(70, 89, 91));
                Upload.setBackground(new Color(255, 255, 255));
                message.setBackground(new Color(255, 255, 255));
                payment.setBackground(new Color(255, 255, 255));
                watchlater.setBackground(new Color(255, 255, 255));
            } else {
                profile.setBackground(new Color(16, 17, 20));
                home.setBackground(new Color(70, 89, 91));
                Upload.setBackground(new Color(16, 17, 20));
                message.setBackground(new Color(16, 17, 20));
                payment.setBackground(new Color(16, 17, 20));
                watchlater.setBackground(new Color(16, 17, 20));
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {

            home.setBackground(new Color(70, 89, 91));
            payment.setBackground(new Color(171, 169, 169));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (togglebttnClicked)
                payment.setBackground(new Color(96, 95, 95));
            if (togglebttnClicked)
                payment.setBackground(new Color(255, 255, 255));
            if (!togglebttnClicked) {
                payment.setBackground(new Color(16, 17, 20));
            }
            home.setBackground(new Color(70, 89, 91));
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if (togglebttnClicked) {
                profile.setBackground(new Color(255, 255, 255));
                home.setBackground(new Color(70, 89, 91));
                Upload.setBackground(new Color(255, 255, 255));
                message.setBackground(new Color(255, 255, 255));
                payment.setBackground(new Color(88, 89, 91));
                watchlater.setBackground(new Color(255, 255, 255));

                card2.show(cardPane2, "Payment");
            } else {
                profile.setBackground(new Color(16, 17, 20));
                home.setBackground(new Color(70, 89, 91));
                Upload.setBackground(new Color(16, 17, 20));
                message.setBackground(new Color(16, 17, 20));
                payment.setBackground(new Color(88, 89, 91));
                watchlater.setBackground(new Color(16, 17, 20));

                card2.show(cardPane2, "Payment");
            }
        }
    }

    public JFrame getmainFrame() {
        return frame;
    }


/////////////////////////////////////UPLOAD//////////////////////////////////


    public void logoutPage() {
        JFrame framel = new JFrame();
        framel.setSize(400, 240);
        framel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framel.setResizable(false);
        framel.setLocationRelativeTo(null);
        framel.setLayout(null);
        framel.setUndecorated(true);

        JPanel topPanel = new JPanel();
        topPanel.setBounds(0, 0, 400, 30);
        topPanel.setBackground(new Color(33, 45, 59));

        JPanel panel = new JPanel();
        panel.setBounds(0, 20, 400, 220);
        panel.setBackground(new Color(33, 45, 59));
        panel.setLayout(null);


        JLabel logoutText = new JLabel("Log Out");
        logoutText.setLayout(null);
        logoutText.setFont(new Font("Abyssinica SIL", Font.BOLD, 20));
        logoutText.setBounds(20, 15, 100, 40);
        logoutText.setForeground(new Color(247, 246, 244));

        JLabel logoutWarning = new JLabel("Are you sure you want to log out?");
        logoutWarning.setFont(new Font("Abyssinica SIL", Font.BOLD, 15));
        logoutWarning.setBounds(25, 55, 400, 30);
        logoutWarning.setForeground(new Color(247, 246, 244));
        logoutWarning.setLayout(null);

        JLabel logoutMsg = new JLabel("This will remove all your current information.");
        logoutMsg.setFont(new Font("Abyssinica SIL", Font.BOLD, 15));
        logoutMsg.setBounds(25, 85, 400, 30);
        logoutMsg.setForeground(new Color(247, 246, 244));
        logoutMsg.setLayout(null);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBounds(0, 160, 400, 60);
        bottomPanel.setBackground(new Color(33, 45, 59));
        bottomPanel.setLayout(null);

        JLabel cancelLabel = new JLabel("CANCEL");
        cancelLabel.setFont(new Font("Abyssinica SIL", Font.BOLD, 15));
        cancelLabel.setBounds(180, 0, 65, 30);
        cancelLabel.setForeground(new Color(115, 181, 255));
        cancelLabel.setLayout(null);

        cancelLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                framel.dispose();

            }
        });


        JLabel logoutLabel = new JLabel("LOG OUT");
        logoutLabel.setFont(new Font("Abyssinica SIL", Font.BOLD, 15));
        logoutLabel.setBounds(280, 0, 70, 30);
        logoutLabel.setForeground(new Color(115, 181, 255));

        logoutLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new loginSignup();

                frame.dispose();
                framel.dispose();

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

        framel.add(topPanel);
        framel.add(panel);
        framel.setVisible(true);
    }

}