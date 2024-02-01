import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;

public class loginSignup extends JFrame {
    Connection1 connection;
    JLabel messageLabel;
    File img;
    loginSignup(){

        connection = new Connection1();
        loginPage();
    }

    JFrame frame;
    JFrame frame2;
    String Dfname, Dlname, Dpassword, Dusername , DConfirm, Dmname, Demail;
    void loginPage(){
        frame = new JFrame();
        frame.setSize(750,450);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);


        JPanel fpanel = new JPanel();
        fpanel.setBounds(0,0,300,450);
        fpanel.setBackground(Color.darkGray);
        fpanel.setLayout(null);


        JPanel imageslider = new JPanel();
        imageslider.setBounds(0,0,300,200);
        imageslider.setLayout(null);
        imageslider.setBackground(Color.black);

        JLabel slideIcL = new JLabel();
        slideIcL.setBounds(0,0,300,200);
        slideIcL.setIcon(new ImageIcon(this.getClass().getResource("house.gif")));

        JPanel underImage = new JPanel();
        underImage.setBounds(0,200,300,225);
        underImage.setBackground(Color.white);
        underImage.setLayout(null);

        JLabel slideIcL2 = new JLabel("ከድርጅታችን ሚያገኟቸው ጥቅሞች");
        slideIcL2.setFont(new Font("Abyssinica SIL",Font.BOLD,22));
        slideIcL2.setForeground(new Color(49, 48, 48));
        slideIcL2.setBounds(0,0,310,30);
        slideIcL2.setBorder(BorderFactory.createLineBorder(Color.black));

        JLabel slideIcL3 = new JLabel("+ ሁሉም አይነት ቤቶች ");
        slideIcL3.setFont(new Font("Abyssinica SIL",Font.PLAIN,18));
        slideIcL3.setForeground(new Color(49, 48, 48));
        slideIcL3.setBounds(10,40,170,20);
        slideIcL3.setBorder(BorderFactory.createLineBorder(Color.black));

        JLabel slideIcL4 = new JLabel("+ ከገብያ በረከሰ ዋጋ ");
        slideIcL4.setFont(new Font("Abyssinica SIL",Font.PLAIN,18));
        slideIcL4.setForeground(new Color(49, 48, 48));
        slideIcL4.setBounds(10,70,160,20);
        slideIcL4.setBorder(BorderFactory.createLineBorder(Color.black));

        JLabel slideIcL5 = new JLabel("+ ያለ እንግልት");
        slideIcL5.setFont(new Font("Abyssinica SIL",Font.PLAIN,18));
        slideIcL5.setForeground(new Color(49, 48, 48));
        slideIcL5.setBounds(10,100,120,20);
        slideIcL5.setBorder(BorderFactory.createLineBorder(Color.black));

        JLabel slideIcL6 = new JLabel("+ ለመጀምሪያ ጊዜ");
        slideIcL6.setFont(new Font("Abyssinica SIL",Font.PLAIN,18));
        slideIcL6.setForeground(new Color(49, 48, 48));
        slideIcL6.setBounds(10,130,150,20);
        slideIcL6.setBorder(BorderFactory.createLineBorder(Color.black));

        JLabel slideIcL7 = new JLabel();
        slideIcL7.setForeground(new Color(49, 48, 48));
        slideIcL7.setBounds(200,100,100,100);
        slideIcL7.setIcon(ResizeImage("C:\\Users\\hp\\Desktop\\theProject\\src\\off.jpg",slideIcL7));

        underImage.add(slideIcL2);
        underImage.add(slideIcL3);
        underImage.add(slideIcL4);
        underImage.add(slideIcL5);
        underImage.add(slideIcL6);
        underImage.add(slideIcL7);
        imageslider.add(slideIcL);
        fpanel.add(imageslider);
        fpanel.add(underImage);








        JPanel illusion = new JPanel();
        illusion.setBounds(300,0,50,450);
        illusion.setBackground(new Color(241, 241, 241));
        frame.add(illusion);


        JPanel spanel = new JPanel();
        spanel.setBounds(350,00,400,450);
        spanel.setBackground(new Color(241, 241, 241));
        spanel.setLayout(new GridLayout(9,2,50,20));

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        topPanel.setBackground(new Color(241, 241, 241));

        JLabel loginLabel = new JLabel("Login Form");
        loginLabel.setForeground(new Color(37, 37, 37));
        loginLabel.setFont(new Font("sarif", Font.BOLD,22));
        loginLabel.setHorizontalAlignment(JLabel.CENTER);
        topPanel.add(loginLabel);

        JLabel username = new JLabel("Username");
        username.setForeground(new Color(37, 37, 37));
        username.setFont(new Font("sarif", Font.PLAIN,22));


        JPanel userInPanel = new JPanel();
        userInPanel.setLayout(null);
        userInPanel.setBackground(new Color(241, 241, 241));

        ImageIcon lineicon = new ImageIcon(this.getClass().getResource("line.png"));
        JLabel line1 = new JLabel(lineicon);
        line1.setBounds(0,30,340,2);
        userInPanel.add(line1);

        JTextField userIn = new JTextField();
        userIn.setForeground(new Color(37, 37, 37));
        userIn.setFont(new Font("sarif", Font.PLAIN,22));
        userIn.setOpaque(false);
        userIn.setBorder(null);
        userIn.setBounds(0,0, 340,30);
        userIn.setBackground(new Color(241, 241, 241));

        JLabel userIconLabel = new JLabel(new ImageIcon(this.getClass().getResource("username.png")));
        userIconLabel.setBounds(340,0, 30,30);
        userInPanel.add(userIn);
        userInPanel.add(userIconLabel);

        JLabel password = new JLabel("Password");
        password.setForeground(new Color(37, 37, 37));
        password.setFont(new Font("sarif", Font.PLAIN,22));


        JPanel passInPanel = new JPanel();
        passInPanel.setLayout(null);
        passInPanel.setBackground(new Color(241, 241, 241));

        JPasswordField passIn = new JPasswordField();
        passIn.setForeground(new Color(37, 37, 37));
        passIn.setFont(new Font("sarif", Font.PLAIN,22));
        passIn.setOpaque(false);
        passIn.setBorder(null);
        passIn.setBounds(0,0, 340,30);
        passIn.setBackground(new Color(241, 241, 241));

        ImageIcon lineicon2 = new ImageIcon(this.getClass().getResource("line.png"));
        JLabel line2 = new JLabel(lineicon2);
        line2.setBounds(0,30,340,2);
        passInPanel.add(line2);

        JLabel logshow = new JLabel(new ImageIcon(this.getClass().getResource("eye.png")));
        logshow.setBounds(350,0, 30,30);

        JLabel logdonshow = new JLabel(new ImageIcon(this.getClass().getResource("lock.png")));
        logdonshow.setBounds(350,0, 30,30);


        CardLayout lay1 = new CardLayout();

        JPanel  log1 = new JPanel();
        log1.setBounds(350,0, 30,30);
        log1.setBackground(new Color(241, 241, 241));
        log1.add(logdonshow);

        JPanel log2 = new JPanel();
        log2.setBackground(new Color(241, 241, 241));
        log2.setBounds(350,0, 30,30);
        log2.add(logshow);

        JPanel passTwo1 = new JPanel();
        passTwo1.setLayout(lay1);
        passTwo1.setBounds(350,-5, 30,40);
        passTwo1.setBackground(new Color(241, 241, 241));

        passTwo1.add(log1, "first");
        passTwo1.add(log2, "second");

        passInPanel.add(passIn);
        passInPanel.add(passTwo1);


        logdonshow.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                lay1.next(passTwo1);
                passIn.setEchoChar((char)0);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

        });
        logshow.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                lay1.next(passTwo1);
                passIn.setEchoChar('*');
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

        });


        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(null);
        loginPanel.setBackground(new Color(241, 241, 241));

        JButton loginSubmit = new JButton("LOGIN");
        loginSubmit.setFocusPainted(false);
        loginSubmit.setBounds(140,0,100,30);
        loginSubmit.setBackground(new Color(22, 28, 42));
        loginPanel.add(loginSubmit);
        loginSubmit.setBorderPainted(false);
        loginSubmit.setFocusPainted(false);
        loginSubmit.setForeground(Color.white);

        loginSubmit.addActionListener(e -> {
            String U = userIn.getText();
            String P = String.valueOf(passIn.getPassword());
            System.out.println(U);
            validateUser(U,P);
        });

        JPanel noAccountPanel = new JPanel();
        noAccountPanel.setLayout(null);
        noAccountPanel.setBackground(new Color(241, 241, 241));

        JLabel noAccount = new JLabel("Do You Have an Acount?");
        noAccount.setForeground(Color.BLACK);
        noAccount.setFont(new Font("sarif", Font.PLAIN,12));
        noAccount.setBounds(100,0,150,30);

        JButton registerSwitch = new JButton("Register");
        registerSwitch.setFocusPainted(false);
        registerSwitch.setForeground(new Color(214, 40, 40));
        registerSwitch.setFont(new Font("sarif",Font.PLAIN,15));
        registerSwitch.setBounds(230,0,100,30);
        registerSwitch.setBorderPainted(false);
        registerSwitch.setContentAreaFilled(false);
        registerSwitch.setFocusPainted(false);

        registerSwitch.addActionListener(e -> {
            frame.dispose();
            registerPage();
        });


        noAccountPanel.add(noAccount);
        noAccountPanel.add(registerSwitch);

        spanel.add(topPanel);
        spanel.add(username);
        spanel.add(userInPanel);
        spanel.add(password);
        spanel.add(passInPanel);
        spanel.add(loginPanel);
        spanel.add(noAccountPanel);

        frame.add(fpanel);
        frame.add(spanel);

        frame.setVisible(true);
    }
    int v = 0;
    void registerPage(){
        frame2 = new JFrame();
        frame2.setSize(750,850);
        frame2.setDefaultCloseOperation(frame2.EXIT_ON_CLOSE);
        frame2.setResizable(false);
        frame2.setLocationRelativeTo(null);
        frame2.setLayout(null);

        JPanel fpanel = new JPanel();
        fpanel.setBounds(0,0,750,850);
        fpanel.setBackground(new Color(241, 241, 241));
        fpanel.setLayout(null);

        JLabel loginformLabel = new JLabel();
        loginformLabel.setBounds(200,500,750,300);
        ImageIcon loginform = new ImageIcon(this.getClass().getResource("signup.png"));
        loginformLabel.setIcon(ResizeImage(loginform,350,200));
        fpanel.add(loginformLabel);

        JLabel loginLabel = new JLabel("Registeration Form");
        loginLabel.setForeground(Color.BLACK);
        loginLabel.setFont(new Font("sarif", Font.BOLD,22));
        loginLabel.setBounds(300,0,200,30);
        fpanel.add(loginLabel);

        ImageIcon iconholder = new ImageIcon(this.getClass().getResource("holder.gif"));
        JLabel imageChooser = new JLabel(iconholder);
        imageChooser.setBounds(300,50, 120,120);
        imageChooser.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        JLabel pprof = new JLabel("    Profile Image");
        pprof.setBounds(310,60, 100,100);

        imageChooser.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFileChooser file = new JFileChooser();
                file.setCurrentDirectory(new File(System.getProperty("user.home")));
                //filter the files
                FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg","gif","png");
                file.addChoosableFileFilter(filter);
                int result = file.showSaveDialog(null);
                //if the user click on save in Jfilechooser
                if(result == JFileChooser.APPROVE_OPTION){

                    File selectedFile = file.getSelectedFile();
                    String path = selectedFile.getAbsolutePath();

                    pprof.setIcon(ResizeImage(path,pprof));
                    pprof.setText("");


                }

            }
        });



        JLabel firstnameLabel = new JLabel("First-Name");
        firstnameLabel.setForeground(Color.BLACK);
        firstnameLabel.setFont(new Font("sarif", Font.PLAIN,16));
        firstnameLabel.setBounds(40,50+120,100,30);

        JTextField firstIn = new JTextField();
        firstIn.setForeground(Color.black);
        firstIn.setFont(new Font("sarif", Font.PLAIN,22));
        firstIn.setOpaque(false);
        firstIn.setBorder(null);
        firstIn.setBackground(new Color(241, 241, 241));
        firstIn.setBounds(40,80+120, 250,30);


        ImageIcon lineicon = new ImageIcon(this.getClass().getResource("line.png"));
        JLabel line = new JLabel(lineicon);
        line.setBounds(40,110+120,250,2);
        fpanel.add(line);

        JLabel userIconLabel = new JLabel(new ImageIcon(this.getClass().getResource("name.png")));
        userIconLabel.setBounds(290,80+120, 30,30);

////////////////////////////////////////////////


        JLabel middlenameLabel = new JLabel("Middle-Name");
        middlenameLabel.setForeground(Color.BLACK);
        middlenameLabel.setFont(new Font("sarif", Font.PLAIN,16));
        middlenameLabel.setBounds(40,140+120,100,30);

        JTextField middlenameIn = new JTextField();
        middlenameIn.setForeground(Color.black);
        middlenameIn.setFont(new Font("sarif", Font.PLAIN,22));
        middlenameIn.setOpaque(false);
        middlenameIn.setBorder(null);
        middlenameIn.setBackground(new Color(241, 241, 241));
        middlenameIn.setBounds(40,170+120, 250,30);

        JLabel line2 = new JLabel(lineicon);
        line2.setBounds(40,200+120,250,2);
        fpanel.add(line2);

        JLabel userIconLabel2 = new JLabel(new ImageIcon(this.getClass().getResource("mname.gif")));
        userIconLabel2.setBounds(290,170+120, 30,30);


        //////////////////////////////////////////////////////
        JLabel lastnameLabel = new JLabel("Last-Name");
        lastnameLabel.setForeground(Color.BLACK);
        lastnameLabel.setFont(new Font("sarif", Font.PLAIN,16));
        lastnameLabel.setBounds(40,230+120,100,30);

        JTextField lastnameIn = new JTextField();
        lastnameIn.setForeground(Color.black);
        lastnameIn.setFont(new Font("sarif", Font.PLAIN,22));
        lastnameIn.setOpaque(false);
        lastnameIn.setBorder(null);
        lastnameIn.setBackground(new Color(241, 241, 241));
        lastnameIn.setBounds(40,260+120, 250,30);

        JLabel line3 = new JLabel(lineicon);
        line3.setBounds(40,290+120,250,2);
        fpanel.add(line3);

        JLabel userIconLabel3 = new JLabel(new ImageIcon(this.getClass().getResource("mname.gif")));
        userIconLabel3.setBounds(290,260+120, 30,30);

        /////////////////////////////////////////////////////////////////////////////
        JLabel email = new JLabel("Email");
        email.setForeground(Color.BLACK);
        email.setFont(new Font("sarif", Font.PLAIN,16));
        email.setBounds(400,50+120,100,30);

        JTextField emaillabel = new JTextField();
        emaillabel.setForeground(Color.black);
        emaillabel.setFont(new Font("sarif", Font.PLAIN,22));
        emaillabel.setOpaque(false);
        emaillabel.setBorder(null);
        emaillabel.setBackground(new Color(241, 241, 241));
        emaillabel.setBounds(400,80+120, 250,30);

        JLabel line4 = new JLabel(lineicon);
        line4.setBounds(400,110+120,250,2);
        fpanel.add(line4);

        JLabel userIconLabel4 = new JLabel(new ImageIcon(this.getClass().getResource("email.png")));
        userIconLabel4.setBounds(650,80+120, 30,30);

/////////////////////////////
        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setForeground(Color.BLACK);
        usernameLabel.setFont(new Font("sarif", Font.PLAIN,16));
        usernameLabel.setBounds(400,140+120,100,30);

        JTextField usernameIn = new JTextField();
        usernameIn.setForeground(Color.black);
        usernameIn.setFont(new Font("sarif", Font.PLAIN,22));
        usernameIn.setOpaque(false);
        usernameIn.setBorder(null);
        usernameIn.setBackground(new Color(241, 241, 241));
        usernameIn.setBounds(400,170+120, 250,30);

        JLabel line5 = new JLabel(lineicon);
        line5.setBounds(400,200+120,250,2);
        fpanel.add(line5);

        JLabel userIconLabel5 = new JLabel(new ImageIcon(this.getClass().getResource("username.png")));
        userIconLabel5.setBounds(650,170+120, 30,30);

////////////////////////////////////////////////////////
        JLabel password = new JLabel("Password");
        password.setForeground(Color.BLACK);
        password.setFont(new Font("sarif", Font.PLAIN,16));
        password.setBounds(400,230+120,100,30);

        JPasswordField passwordIn = new JPasswordField();
        passwordIn.setForeground(Color.black);
        passwordIn.setFont(new Font("sarif", Font.PLAIN,22));
        passwordIn.setOpaque(false);
        passwordIn.setBorder(null);
        passwordIn.setBackground(new Color(241, 241, 241));
        passwordIn.setBounds(400,260+120, 250,30);

        JLabel line6 = new JLabel(lineicon);
        line6.setBounds(400,290+120,250,2);
        fpanel.add(line6);

        fpanel.add(lastnameLabel);
        fpanel.add(lastnameIn);
        fpanel.add(userIconLabel3);
        fpanel.add(loginLabel);
        fpanel.add(firstnameLabel);
        fpanel.add(firstIn);
        fpanel.add(userIconLabel);
        fpanel.add(middlenameLabel);
        fpanel.add(middlenameIn);
        fpanel.add(userIconLabel2);
        fpanel.add(email);
        fpanel.add(emaillabel);
        fpanel.add(userIconLabel4);
        fpanel.add(userIconLabel5);
        fpanel.add(usernameLabel);
        fpanel.add(usernameIn);
        fpanel.add(password);
        fpanel.add(passwordIn);
/////////////////////////////


        JLabel passwordIcon = new JLabel(new ImageIcon(this.getClass().getResource("lock.png")));
        passwordIcon.setBounds(650,260+120, 30,30);

        JLabel passwordIc = new JLabel(new ImageIcon(this.getClass().getResource("eye.png")));
        passwordIc.setBounds(650,260+120, 30,30);

        CardLayout lay = new CardLayout();

        JPanel  show = new JPanel();
        show.setBounds(650,260+120, 30,30);
        show.setBackground(new Color(241, 241, 241));
        show.add(passwordIc);
        JPanel donshow = new JPanel();
        donshow.setBounds(650,260+120, 30,30);
        donshow.add(passwordIcon);
        donshow.setBackground(new Color(241, 241, 241));

        JPanel passTwo = new JPanel();
        passTwo.setLayout(lay);
        passTwo.setBounds(650,260+120, 30,30);
        passTwo.setBackground(new Color(43 ,  45, 66));

        passTwo.add(donshow, "first");
        passTwo.add(show, "second");

        fpanel.add(passTwo);


        passwordIcon.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                lay.next(passTwo);
                passwordIn.setEchoChar((char)0);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

        });


        passwordIc.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                lay.next(passTwo);
                passwordIn.setEchoChar('*');
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

        });


////////////////////////////



        fpanel.add(imageChooser);
        fpanel.add(pprof);
////////////////////////////


        JButton loginSubmit = new JButton("Register");
        loginSubmit.setFocusPainted(false);
        loginSubmit.setFont(new Font("Serif",Font.BOLD,22));
        loginSubmit.setBounds(220,340+120, 300,50);
        loginSubmit.setBackground(new Color(22, 28, 42));
        loginSubmit.setBorderPainted(false);
        loginSubmit.setFocusPainted(false);
        loginSubmit.setForeground(Color.white);

        loginSubmit.addActionListener(e -> {
            Image image = pprof.createImage(100,100);
            BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB);
            Graphics2D g2 = bufferedImage.createGraphics();
            g2.drawImage(image, 0, 0, null);
            g2.dispose();

            img = new File("image.png");
            try {
                ImageIO.write(bufferedImage, "png", img);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            Dfname = firstIn.getText().toString();
            Dmname = middlenameIn.getText().toString();
            Dlname = lastnameIn.getText().toString();
            Dpassword = String.valueOf(passwordIn.getPassword());
            Dusername = usernameIn.getText().toString();
            Demail = emaillabel.getText().toString();
            addUserToDatabase();
        });

        fpanel.add(loginSubmit);

        JLabel noAccount = new JLabel("Already Have an Account?");
        noAccount.setForeground(Color.BLACK);
        noAccount.setFont(new Font("sarif", Font.PLAIN,18));
        noAccount.setBounds(230,400+120, 250,30);

        JButton registerSwitch = new JButton("Login");
        registerSwitch.setFocusPainted(false);
        registerSwitch.setForeground(new Color(214, 40, 40));
        registerSwitch.setFont(new Font("sarif",Font.PLAIN,22));
        registerSwitch.setBounds(440,400+120, 100,30);
        registerSwitch.setBorderPainted(false);
        registerSwitch.setContentAreaFilled(false);
        registerSwitch.setFocusPainted(false);

        registerSwitch.addActionListener(e -> {
            frame2.dispose();
            loginPage();
        });

        fpanel.add(noAccount);
        fpanel.add(registerSwitch);



        frame2.add(fpanel);
        frame2.setVisible(true);
    }

    SideBar sideBar;
    void validateUser(String username, String password){


        String checker = "SELECT * FROM users WHERE username=? AND password=?";
        String lastStatus = "INSERT INTO loginchecker (username, laststatus) VALUES (?,'Logged in')";

        try{
            Statement statement = connection.conn.createStatement();

            System.out.println(checker);
            PreparedStatement preparedStatement = connection.conn.prepareStatement(checker);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet results = preparedStatement.executeQuery();



            PreparedStatement stmt = connection.conn.prepareStatement(lastStatus);
            stmt.setString(1, username);
            stmt.executeUpdate();

            if(results.next()){


                frame.dispose();
                sideBar = new SideBar(username);
                SuccessDisplay("Logged in Successfully!");

            }

            else {

                ErrorDisplay("Login Failed");

            }

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Errortrtrtrtrrrtrtrtrr logging in");

        }
    }


    void addUserToDatabase(){
        if(Dfname.isEmpty() || Dlname.isEmpty() || Dpassword.isEmpty() || Dusername.isEmpty()){
            System.out.println("Fill All Fields");
            ErrorDisplay("Fill All Fields");
            return;
        }
        if(String.valueOf(Dpassword).length() <= 8){
            System.out.println("Week Password");
            ErrorDisplay("Week Password");
            return;
        }

        try(FileInputStream fin = new FileInputStream(img)) {
            Statement stmt = connection.conn.createStatement();

            String sql = "INSERT INTO users (fname, mname, lname, email, username, password, image)" + "VALUES (?,?,?,?,?,?,?)";

            PreparedStatement preparedStatement = connection.conn.prepareStatement(sql);
            preparedStatement.setString(1, Dfname);
            preparedStatement.setString(2, Dmname);
            preparedStatement.setString(3, Dlname);
            preparedStatement.setString(4, Demail);
            preparedStatement.setString(5, Dusername);
            preparedStatement.setString(6, Dpassword);
            preparedStatement.setBinaryStream(7, fin, (int) img.length());
            preparedStatement.executeUpdate();
            SuccessDisplay("Registered Successfully!");
            System.out.println("registered");
//            stmt.close();
//            connection.close();
        }catch(Exception e){
            ErrorDisplay("Database Error!");
            System.out.println("not added to sql!");
            e.printStackTrace();
        }

    }


    public ImageIcon ResizeImage(String ImagePath, JLabel label)
    {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

    public ImageIcon ResizeImage(ImageIcon ImagePath, int width, int height)
    {
        ImageIcon MyImage = ImagePath;
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

    private void SuccessDisplay(String text) {
        JFrame errorFrame = new JFrame();
        errorFrame.setUndecorated(true);
        errorFrame.setSize(255,300);
        errorFrame.setLayout(null);
        errorFrame.setShape(new RoundRectangle2D.Double(0, 0, 255, 300, 50, 50));


        JPanel message = new JPanel();
        message.setBounds(0,0,255,50);
        message.setBackground(new Color(242, 242, 242));

        JLabel messagelabel = new JLabel(text);
        messagelabel.setForeground(new Color(37, 36, 36));
        messagelabel.setFont(new Font("serif", Font.BOLD, 22));
        message.add(messagelabel);
        messagelabel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));

        JPanel panel = new JPanel();
        panel.setBounds(0,50,255,250);
        panel.setBackground(new Color(242, 242, 242));

        ImageIcon image = new ImageIcon(this.getClass().getResource("successfull.gif"));
        JLabel label = new JLabel();
        label.setIcon(image);

        panel.add(label);
        errorFrame.add(message);
        errorFrame.add(panel);

        errorFrame.setLocationRelativeTo(null);
        errorFrame.setVisible(true);

        new Timer(4000, (e) -> { errorFrame.setVisible(false); errorFrame.dispose(); }).start();


    }

    private void ErrorDisplay(String text) {
        JFrame errorFrame = new JFrame();
        errorFrame.setUndecorated(true);
        errorFrame.setSize(255,300);
        errorFrame.setLayout(null);
        errorFrame.setShape(new RoundRectangle2D.Double(0, 0, 255, 300, 50, 50));


        JPanel message = new JPanel();
        message.setBounds(0,0,255,50);
        message.setBackground(new Color(255, 149, 149));

        JLabel messagelabel = new JLabel(text);
        messagelabel.setForeground(Color.WHITE);
        messagelabel.setFont(new Font("serif", Font.BOLD, 22));
        message.add(messagelabel);
        messagelabel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));

        JPanel panel = new JPanel();
        panel.setBounds(0,50,255,250);
        panel.setBackground(new Color(255, 149, 149));

        ImageIcon image = new ImageIcon(this.getClass().getResource("error.gif"));
        JLabel label = new JLabel();
        label.setIcon(image);

        panel.add(label);
        errorFrame.add(panel);
        errorFrame.add(message);


        errorFrame.setLocationRelativeTo(null);
        errorFrame.setVisible(true);

        new Timer(2400, (e) -> { errorFrame.setVisible(false); errorFrame.dispose(); }).start();


    }
}
