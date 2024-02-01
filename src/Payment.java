import javax.print.attribute.standard.MediaSize;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Payment {
    JPanel frame;
    JPanel payment;
    JLabel mastercard;
    JLabel CBE;
    JLabel teleBirr;
    JLabel clicked;
    JPanel top;
    JLabel selectMethod;
    JLabel paymentSummary;
    JLabel Deposit;
    JLabel line;
    JLabel CbeWallet;
    JLabel tele;
    JLabel other;
    JPanel center;
    JPanel summaryHolder;
    JLabel monthly;
    JLabel monthlyfee;
    JLabel type;
    JLabel typeL;
    JLabel discount;
    JLabel discountL;
    JLabel total;
    JLabel totalL;
    JLabel paymethodsL;
    JLabel assurance;
    JLabel cbe;
    JLabel telesmall;
    JLabel mastercardsmall;
    JLabel depo;
    JTextField depoInput;
    boolean payed = false;
    boolean yes = true;
    JLabel Name;
    JTextField nameInput;
    JLabel expiredate;
    JTextField expireInput;
    JLabel pin;
    JTextField pinInput;
    JButton paybtn;
    JCheckBox agreed;
    JLabel balance, sure, notsure;
    JPanel assu;
    static double number;
    static int i;
    int t = 50;
    static String s;

    Payment() {
        frame = new JPanel();
        frame.setLayout(new BorderLayout());

        number = 109700.0;
        i = 0;

        ImageIcon inputIcon = new ImageIcon(this.getClass().getResource("line.png"));
        ImageIcon mastercardIcon = new ImageIcon(this.getClass().getResource("Layer 5.png"));
        ImageIcon Teleicon = new ImageIcon(this.getClass().getResource("Layer 6.png"));
        ImageIcon CBEicon = new ImageIcon(this.getClass().getResource("Layer 3.png"));
        ImageIcon lineIcon = new ImageIcon(this.getClass().getResource("changeline.png"));
        ImageIcon clickedIcon = new ImageIcon(this.getClass().getResource("clicked.png"));
        payment = new JPanel();
        payment.setBackground(new Color(30, 31, 34));
        payment.setPreferredSize(new Dimension(350, 400));
        payment.setLayout(null);


        clicked = new JLabel();
        clicked.setIcon(clickedIcon);
        clicked.setBounds(30, 30, 45, 45);
        clicked.setVisible(false);


        s = String.valueOf(number);

        balance = new JLabel(s);

        balance.setFont(new Font("sarif", Font.BOLD, 22));
        balance.setBounds(50, 58, 100, 30);
        balance.setForeground(Color.WHITE);


        mastercard = new JLabel();
        mastercard.setIcon(mastercardIcon);
        mastercard.setBounds(20, 10, 280, 164);

        CBE = new JLabel();
        CBE.setIcon(CBEicon);
        CBE.setBounds(20, 194, 280, 164);

        teleBirr = new JLabel();
        teleBirr.setIcon(Teleicon);
        teleBirr.setBounds(20, 378, 280, 164);

        payment.add(balance);
        payment.add(clicked);
        payment.add(mastercard);
        payment.add(CBE);
        payment.add(teleBirr);


        mastercard.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                clicked.setVisible(true);
                clicked.setBounds(280, 0, 34, 34);
                paymethodsL.setText("Pay using Master Card");
                telesmall.setVisible(false);
                cbe.setVisible(false);
                mastercardsmall.setVisible(true);
                line.setBounds(50, 145, 100, 40);

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                mastercard.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
        });


        CBE.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                clicked.setVisible(true);
                clicked.setBounds(280, 184, 34, 34);
                paymethodsL.setText("Pay using CBE Wallet");
                telesmall.setVisible(false);
                cbe.setVisible(true);
                mastercardsmall.setVisible(false);
                line.setBounds(150, 145, 100, 40);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                CBE.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
        });

        teleBirr.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                clicked.setVisible(true);
                clicked.setBounds(280, 368, 34, 34);
                paymethodsL.setText("Pay using teleBirr");
                telesmall.setVisible(true);
                cbe.setVisible(false);
                mastercardsmall.setVisible(false);
                line.setBounds(250, 145, 100, 40);

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                teleBirr.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
        });
        //////////////////////////
        top = new JPanel();
        top.setBackground(new Color(24, 24, 28));
        top.setPreferredSize(new Dimension(400, 200));
        top.setLayout(null);

        selectMethod = new JLabel("Select Payment method");
        selectMethod.setBounds(50, 80, 250, 40);
        selectMethod.setFont(new Font("Sarif", Font.BOLD, 18));
        selectMethod.setForeground(Color.WHITE);

        paymentSummary = new JLabel("Payment Summary");
        paymentSummary.setBounds(800, 80, 250, 40);
        paymentSummary.setFont(new Font("Sarif", Font.BOLD, 18));
        paymentSummary.setForeground(Color.WHITE);

        Deposit = new JLabel("Deposit");
        Deposit.setBounds(50, 130, 100, 40);
        Deposit.setFont(new Font("Sarif", Font.BOLD, 14));
        Deposit.setForeground(Color.WHITE);

        line = new JLabel();
        line.setBounds(t, 145, 100, 40);
        line.setIcon(lineIcon);
        line.setForeground(Color.WHITE);

        CbeWallet = new JLabel("CBE Wallet");
        CbeWallet.setBounds(150, 130, 100, 40);
        CbeWallet.setFont(new Font("Sarif", Font.BOLD, 14));
        CbeWallet.setForeground(Color.WHITE);

        tele = new JLabel("Tele Birr");
        tele.setBounds(250, 130, 100, 40);
        tele.setFont(new Font("Sarif", Font.BOLD, 14));
        tele.setForeground(Color.WHITE);

        other = new JLabel("Other");
        other.setBounds(350, 130, 100, 40);
        other.setFont(new Font("Sarif", Font.BOLD, 14));
        other.setForeground(Color.WHITE);

        Deposit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                line.setBounds(t, 145, 100, 40);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Deposit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
        });

        CbeWallet.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                line.setBounds(t + 100, 145, 100, 40);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                CbeWallet.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
        });

        tele.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                line.setBounds(t + 200, 145, 100, 40);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                tele.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
        });

        other.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                line.setBounds(t + 300, 145, 100, 40);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                other.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
        });

        top.add(selectMethod);
        top.add(Deposit);
        top.add(line);
        top.add(CbeWallet);
        top.add(tele);
        top.add(other);

        top.add(paymentSummary);
        ///////////////////////////////////////////////////////
        center = new JPanel();
        center.setBackground(new Color(30, 31, 34));
        center.setLayout(null);

        summaryHolder = new JPanel();
        summaryHolder.setBounds(450, 10, 350, 500);
        summaryHolder.setBackground(new Color(55, 58, 61));
        summaryHolder.setLayout(null);

        ImageIcon logoIcon = new ImageIcon(this.getClass().getResource("logo.png"));
        JLabel logo = new JLabel();
        logo.setBounds(65, 100, 220, 50);
        logo.setIcon(logoIcon);

        monthly = new JLabel("Monthly Fee");
        monthly.setBounds(20, 220, 100, 50);
        monthly.setFont(new Font("Sarif", Font.BOLD, 16));
        monthly.setForeground(Color.WHITE);

        monthlyfee = new JLabel("100 Birr");
        monthlyfee.setBounds(240, 220, 100, 50);
        monthlyfee.setFont(new Font("Sarif", Font.BOLD, 16));
        monthlyfee.setForeground(Color.WHITE);

        typeL = new JLabel("Type");
        typeL.setBounds(20, 270, 100, 50);
        typeL.setFont(new Font("Sarif", Font.BOLD, 16));
        typeL.setForeground(Color.WHITE);

        type = new JLabel("Standard");
        type.setBounds(240, 270, 100, 50);
        type.setFont(new Font("Sarif", Font.BOLD, 16));
        type.setForeground(Color.WHITE);

        discount = new JLabel("Discount");
        discount.setBounds(20, 320, 100, 50);
        discount.setFont(new Font("Sarif", Font.BOLD, 16));
        discount.setForeground(Color.WHITE);

        discountL = new JLabel("10%");
        discountL.setBounds(240, 320, 100, 50);
        discountL.setFont(new Font("Sarif", Font.BOLD, 16));
        discountL.setForeground(Color.WHITE);

        JLabel sep = new JLabel();
        sep.setIcon(inputIcon);
        sep.setBounds(10, 370, 330, 5);

        totalL = new JLabel("Total");
        totalL.setBounds(20, 380, 100, 30);
        totalL.setFont(new Font("Sarif", Font.BOLD, 16));
        totalL.setForeground(Color.WHITE);

        total = new JLabel("90 Birr");
        total.setBounds(240, 380, 100, 30);
        total.setFont(new Font("Sarif", Font.BOLD, 16));
        total.setForeground(Color.WHITE);

        JLabel sep2 = new JLabel();
        sep2.setIcon(inputIcon);
        sep2.setBounds(10, 410, 330, 5);

        summaryHolder.add(sep2);
        summaryHolder.add(totalL);
        summaryHolder.add(total);
        summaryHolder.add(sep);
        summaryHolder.add(type);
        summaryHolder.add(typeL);
        summaryHolder.add(monthly);
        summaryHolder.add(monthlyfee);
        summaryHolder.add(discount);
        summaryHolder.add(discountL);
        summaryHolder.add(monthly);
        summaryHolder.add(logo);

        paymethodsL = new JLabel("Pay using Deposit");
        paymethodsL.setBounds(40, 40, 250, 30);
        paymethodsL.setFont(new Font("Sarif", Font.BOLD, 14));
        paymethodsL.setForeground(Color.WHITE);

        ImageIcon cbeIcon = new ImageIcon(this.getClass().getResource("cbe.png"));
        ImageIcon telesmallicon = new ImageIcon(this.getClass().getResource("tele.png"));
        ImageIcon mastercardsmallicon = new ImageIcon(this.getClass().getResource("mastercardsmall.png"));

        cbe = new JLabel();
        cbe.setIcon(cbeIcon);
        cbe.setBounds(40, 70, 45, 45);
        cbe.setVisible(false);

        telesmall = new JLabel();
        telesmall.setIcon(telesmallicon);
        telesmall.setBounds(30, 60, 116, 53);
        telesmall.setVisible(false);

        mastercardsmall = new JLabel();
        mastercardsmall.setIcon(mastercardsmallicon);
        mastercardsmall.setBounds(40, 80, 44, 26);
        mastercardsmall.setVisible(false);

        depo = new JLabel("Depo Number");
        depo.setFont(new Font("Sarif", Font.BOLD, 12));
        depo.setForeground(Color.WHITE);
        depo.setBounds(40, 145, 150, 30);

        depoInput = new JTextField();
        depoInput.setBackground(new Color(30, 31, 34));
        depoInput.setBounds(40, 170, 350, 30);
        depoInput.setOpaque(false);
        depoInput.setBorder(null);
        depoInput.setForeground(Color.WHITE);

        JLabel input = new JLabel();
        input.setIcon(inputIcon);
        input.setBounds(38, 190, 350, 30);

        Name = new JLabel("Name");
        Name.setFont(new Font("Sarif", Font.BOLD, 12));
        Name.setForeground(Color.WHITE);
        Name.setBounds(40, 220, 100, 30);

        nameInput = new JTextField();
        nameInput.setBackground(new Color(30, 31, 34));
        nameInput.setBounds(40, 245, 350, 30);
        nameInput.setOpaque(false);
        nameInput.setBorder(null);
        nameInput.setForeground(Color.WHITE);

        JLabel input2 = new JLabel();
        input2.setIcon(inputIcon);
        input2.setBounds(38, 265, 350, 30);

        expiredate = new JLabel("Expire date");
        expiredate.setFont(new Font("Sarif", Font.BOLD, 12));
        expiredate.setForeground(Color.WHITE);
        expiredate.setBounds(40, 295, 100, 30);

        expireInput = new JTextField();
        expireInput.setBackground(new Color(30, 31, 34));
        expireInput.setBounds(40, 320, 150, 30);
        expireInput.setOpaque(false);
        expireInput.setBorder(null);
        expiredate.setForeground(Color.WHITE);
        expireInput.setForeground(Color.WHITE);

        JLabel input3 = new JLabel();
        input3.setIcon(inputIcon);
        input3.setBounds(38, 340, 150, 30);

        assu = new JPanel();
        assu.setBounds(170, 300, 280, 100);
        assu.setBackground(new Color(34, 61, 61, 202));
        assu.setLayout(null);

        sure = new JLabel("Yes");
        sure.setFont(new Font("Sarif", Font.BOLD, 16));
        sure.setForeground(new Color(210, 222, 224));
        sure.setBounds(100, 40, 30, 30);

        notsure = new JLabel("No");
        notsure.setFont(new Font("Sarif", Font.BOLD, 16));
        notsure.setForeground(new Color(210, 222, 224));
        notsure.setBounds(150, 40, 30, 30);

        assurance = new JLabel("do you want to make a payment again?");
        assurance.setFont(new Font("Sarif", Font.BOLD, 13));
        assurance.setForeground(new Color(210, 222, 224));
        assurance.setBounds(10, 10, 280, 30);

        assu.add(sure);
        assu.add(notsure);
        assu.add(assurance);
        assu.setVisible(false);

        pin = new JLabel("Pin Code");
        pin.setFont(new Font("Sarif", Font.BOLD, 12));
        pin.setForeground(Color.WHITE);
        pin.setBounds(230, 295, 100, 30);

        pinInput = new JTextField();
        pinInput.setBackground(new Color(30, 31, 34));
        pinInput.setBounds(230, 320, 150, 30);
        pinInput.setOpaque(false);
        pinInput.setBorder(null);
        pinInput.setForeground(Color.WHITE);

        JLabel input4 = new JLabel();
        input4.setIcon(inputIcon);
        input4.setBounds(228, 340, 160, 30);

        paybtn = new JButton("pay");
        paybtn.setBounds(238, 400, 150, 40);
        paybtn.setFont(new Font("Sarif", Font.BOLD, 12));
        paybtn.setFocusPainted(false);
        paybtn.setBackground(new Color(166, 164, 164));
        paybtn.setBorderPainted(false);
        paybtn.setFocusPainted(false);
        paybtn.setForeground(Color.black);

        sure.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                assu.setVisible(false);
                number -= 90;
                s = String.valueOf(number);
                balance.setText(s);

            }

        });

        notsure.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                assu.setVisible(false);
                s = String.valueOf(number);
                balance.setText(s);

            }

        });


        paybtn.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {


                if (payed) {
                    assu.setVisible(true);
                }

                if (yes) {
                    number -= 90;
                    s = String.valueOf(number);
                    balance.setText(s);
                    payed = true;
                    yes = false;
                }

            }

            int x = 400;

            @Override
            public void mouseEntered(MouseEvent e) {
                String checker = nameInput.getText();
                String checker2 = depoInput.getText();
                String checker3 = pinInput.getText();
                String checker4 = expireInput.getText();

                if (checker.isEmpty() || checker2.isEmpty() || checker3.isEmpty() || checker4.isEmpty()) {
                    if (x == 400) {
                        paybtn.setBounds(238, x + 70, 150, 40);
                        x += 70;
                    } else {
                        paybtn.setBounds(238, 400, 150, 40);
                        x -= 70;
                    }
                } else {
                    paybtn.setBounds(238, 400, 150, 40);
                }

            }
        });

        agreed = new JCheckBox("Agreed to the terms");
        agreed.setForeground(Color.WHITE);
        agreed.setFont(new Font("Sarif", Font.BOLD, 12));
        agreed.setBounds(40, 410, 150, 30);
        agreed.setFocusPainted(false);
        agreed.setBorderPainted(false);

        center.add(assu);
        center.add(agreed);
        center.add(paybtn);
        center.add(depo);
        center.add(depoInput);
        center.add(input);
        center.add(Name);
        center.add(nameInput);
        center.add(input2);
        center.add(expiredate);
        center.add(expireInput);
        center.add(input3);
        center.add(pin);
        center.add(pinInput);
        center.add(input4);
        center.add(telesmall);
        center.add(cbe);
        center.add(mastercardsmall);
        center.add(summaryHolder);
        center.add(paymethodsL);

        frame.add(center, BorderLayout.CENTER);
        frame.add(top, BorderLayout.NORTH);
        frame.add(payment, BorderLayout.WEST);
    }

    public JPanel getPaymentPanel() {
        return frame;
    }

}

