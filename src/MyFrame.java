import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.sql.*;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyFrame extends JFrame{


    String jdbcURL = "jdbc:postgresql://localhost:5432/CheepDelala";
    String username = "postgres";
    String password = "trident";
    JButton registerSubmit;
    String Dfname;
    String Dlname;
    String Dusername;
    String Dpassword;
    Connection connection;
    JFrame loginFrame;
    JFrame registerFrame;
    JTextField firstNameField;
    JTextField lastNameField;
    JPasswordField passField;
    JTextField userField;
    MyFrame(){

        try {
            connection = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Connected to server");
        }catch(
                SQLException e){
            System.out.println("Error in Connecting to Server");
            e.printStackTrace();
        }
    }
boolean windowActive = false;
    void loginWindow(){
       windowActive= true;
        loginFrame = new JFrame();

        if(registerFrame != null)
            registerFrame.dispose();

        loginFrame.setVisible(true);
        loginFrame.setSize(400,400);
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setLayout(null);
        loginFrame.setResizable(false);

        JPanel loginPanel = new JPanel();
        JPanel userPanel = new JPanel();
        JPanel userInPanel = new JPanel();

        loginPanel.setBounds(0,0,400,50);
        userPanel.setBounds(10,50,400,50);
        userInPanel.setBounds(0,100,400,50);

        //userPanel.setBackground(Color.RED);
        //loginPanel.setBackground(Color.GRAY);
        //userInPanel.setBackground(Color.green);

        loginFrame.add(userPanel);
        loginFrame.add(loginPanel);
        loginFrame.add(userInPanel);

        JLabel loginLabel = new JLabel();
        loginLabel.setText("LOGIN");
        loginLabel.setFont(new Font("Serif", Font.BOLD, 22));
        loginLabel.setBounds(190,25,50,50);
        loginPanel.add(loginLabel);

        JLabel username = new JLabel();
        username.setText("Username");
        username.setFont(new Font("Serif", Font.BOLD, 18));
        userPanel.setLayout(new BorderLayout());

        userPanel.add(username);
        username.setHorizontalAlignment(JLabel.LEFT);

        JTextField userLField = new JTextField();
        userLField.setFont(new Font("Serif", Font.BOLD, 18));
        userInPanel.setLayout(null);
        userLField.setBounds(10,0,300,50);
        userInPanel.add(userLField);

        JPanel passPanel = new JPanel();
        JPanel passInPanel = new JPanel();

        passPanel.setBounds(10,150,400,50);
        passInPanel.setBounds(0,200,400,50);

        //passPanel.setBackground(Color.RED);
        //passInPanel.setBackground(Color.green);

        loginFrame.add(passPanel);
        loginFrame.add(passInPanel);

        JLabel password = new JLabel();
        password.setText("Password");
        password.setFont(new Font("Serif", Font.BOLD, 18));
        passPanel.setLayout(new BorderLayout());

        passPanel.add(password);
        password.setHorizontalAlignment(JLabel.LEFT);

        JPasswordField passLField = new JPasswordField();
        passLField.setFont(new Font("Serif", Font.BOLD, 18));
        passInPanel.setLayout(null);
        passLField.setBounds(10,0,300,50);
        passInPanel.add(passLField);

        JPanel logBtnLabel = new JPanel();
        logBtnLabel.setBounds(0,250,400,50);

        JButton loginSubmit = new JButton();
        loginSubmit.setText("Login");
        loginSubmit.setBackground(new Color(128,128,128));
        loginSubmit.setFont(new Font("Serif", Font.BOLD, 18));
        logBtnLabel.add(loginSubmit);
        JPanel noAccount = new JPanel();
        noAccount.setBounds(0,300,400,50);

        JButton registerBtn = new JButton();
        registerBtn.setText("Register");
        registerBtn.setForeground(Color.red);
        //this is to make the button transparent i have no idea about the code :)
        registerBtn.setBorderPainted(false);
        registerBtn.setContentAreaFilled(false);
        registerBtn.setFocusPainted(false);
        registerBtn.setOpaque(false);

        registerBtn.setFont(new Font("Serif", Font.BOLD, 18));

        JLabel registerLabel = new JLabel("Don't have an Account? ");
        registerLabel.setFont(new Font("Serif", Font.BOLD, 18));

        registerBtn.addActionListener(e -> {
            registerWindow();
        });

        noAccount.add(registerLabel);
        noAccount.add(registerBtn);
        loginFrame.add(noAccount);
        loginFrame.add(logBtnLabel);

        loginSubmit.addActionListener(e -> {
            String U = userLField.getText();
            String P = String.valueOf(passLField.getPassword());
            System.out.println(U);
            validateUser(U,P);
        });

    }

    void registerWindow(){
        registerFrame = new JFrame();

        if(loginFrame != null)
             loginFrame.dispose();

        registerFrame.setVisible(true);
        registerFrame.setSize(400,600);
        registerFrame.setLocationRelativeTo(null);
        registerFrame.setLayout(null);
        registerFrame.setResizable(false);

        JPanel registerPanel = new JPanel();
        JPanel userPanel = new JPanel();
        JPanel userInPanel = new JPanel();
        JPanel confirmPanel = new JPanel();
        JPanel confirmInPanel = new JPanel();
        JPanel firstNamePanel = new JPanel();
        JPanel firstNameInPanel = new JPanel();
        JPanel lastNamePanel = new JPanel();
        JPanel lastNameInPanel = new JPanel();
        JPanel imageInsertPanel = new JPanel();
        JPanel owner_renteePanel = new JPanel();


        registerPanel.setBounds(0,0,400,35);
        firstNamePanel.setBounds(10,35,400,35);
        firstNameInPanel.setBounds(0,70,400,35);
        lastNamePanel.setBounds(10,105,400,35);
        lastNameInPanel.setBounds(0,145,400,35);
        userPanel.setBounds(10,180,400,35);
        userInPanel.setBounds(0,215,400,35);
        confirmPanel.setBounds(10,320,400,35);
        confirmInPanel.setBounds(0,355,400,35);
        owner_renteePanel.setBounds(0,390,400,35);
        imageInsertPanel.setBounds(0,425,400,35);

        //firstNamePanel.setBackground(Color.RED);
        //firstNameInPanel.setBackground(Color.GRAY);
        //lastNamePanel.setBackground(Color.green);
        //lastNameInPanel.setBackground(Color.GRAY);
        //userPanel.setBackground(Color.RED);
        //registerPanel.setBackground(Color.GRAY);
        //userInPanel.setBackground(Color.green);

        registerFrame.add(registerPanel);
        registerFrame.add(confirmPanel);
        registerFrame.add(confirmInPanel);
        registerFrame.add(firstNamePanel);
        registerFrame.add(firstNameInPanel);
        registerFrame.add(lastNamePanel);
        registerFrame.add(lastNameInPanel);
        registerFrame.add(imageInsertPanel);
        registerFrame.add(owner_renteePanel);
        registerFrame.add(userPanel);
        registerFrame.add(userInPanel);

        JLabel registerLabel = new JLabel();
        registerLabel.setText("REGISTERATION");
        registerLabel.setFont(new Font("Serif", Font.BOLD, 22));
        registerLabel.setBounds(190,25,50,35);
        registerPanel.add(registerLabel);


        JLabel fname = new JLabel();
        fname.setText("First Name");
        fname.setFont(new Font("Serif", Font.BOLD, 18));
        firstNamePanel.setLayout(new BorderLayout());
        firstNamePanel.add(fname);
        fname.setHorizontalAlignment(JLabel.LEFT);


        firstNameField = new JTextField();
        firstNameField.setFont(new Font("Serif", Font.BOLD, 18));
        firstNameInPanel.setLayout(null);
        firstNameField.setBounds(10,0,300,35);
        firstNameInPanel.add(firstNameField);

        JLabel lname = new JLabel();
        lname.setText("Last Name");
        lname.setFont(new Font("Serif", Font.BOLD, 18));
        lastNamePanel.setLayout(new BorderLayout());
        lastNamePanel.add(lname);
        lname.setHorizontalAlignment(JLabel.LEFT);

        lastNameField = new JTextField();
        lastNameField.setFont(new Font("Serif", Font.BOLD, 18));
        lastNameInPanel.setLayout(null);
        lastNameField.setBounds(10,0,300,35);
        lastNameInPanel.add(lastNameField);


        JPanel passPanel = new JPanel();
        JPanel passInPanel = new JPanel();


        passPanel.setBounds(10,250,400,35);
        passInPanel.setBounds(0,285,400,35);

       // passPanel.setBackground(Color.RED);
        //passInPanel.setBackground(Color.green);

        registerFrame.add(passPanel);
        registerFrame.add(passInPanel);

        JLabel password = new JLabel();
        password.setText("Password");
        password.setFont(new Font("Serif", Font.BOLD, 18));
        passPanel.setLayout(new BorderLayout());

        passPanel.add(password);
        password.setHorizontalAlignment(JLabel.LEFT);

        passField = new JPasswordField();
        passField.setFont(new Font("Serif", Font.BOLD, 18));
        passInPanel.setLayout(null);
        passField.setBounds(10,0,300,35);
        passInPanel.add(passField);

        JLabel ConfText = new JLabel();
        ConfText.setText("Confirm Password");
        ConfText.setFont(new Font("Serif", Font.BOLD, 18));
        confirmPanel.setLayout(new BorderLayout());
        confirmPanel.add(ConfText);
        ConfText.setHorizontalAlignment(JLabel.LEFT);

        JPasswordField confField = new JPasswordField();
        confField.setFont(new Font("Serif", Font.BOLD, 18));
        confirmInPanel.setLayout(null);
        confField.setBounds(10,0,300,35);
        confirmInPanel.add(confField);

        //confirmPanel.setBackground(Color.RED);
        //confirmInPanel.setBackground(Color.green);
        //imageInsertPanel.setBackground(Color.RED);
        //owner_renteePanel.setBackground(Color.green);

        JLabel username = new JLabel();
        username.setText("Username");
        username.setFont(new Font("Serif", Font.BOLD, 18));
        userPanel.setLayout(new BorderLayout());

        userPanel.add(username);
        username.setHorizontalAlignment(JLabel.LEFT);

        userField = new JTextField();
        userField.setFont(new Font("Serif", Font.BOLD, 18));
        userInPanel.setLayout(null);
        userField.setBounds(10,0,300,35);
        userInPanel.add(userField);


        JToggleButton owner = new JToggleButton();
        owner.setText("Owner");
        JToggleButton Rentee = new JToggleButton();
        Rentee.setText("Rentee");
        owner_renteePanel.add(owner);
        owner_renteePanel.add(Rentee);

        JButton profileBtn = new JButton("Select Profile");
        JLabel profileLabel = new JLabel();

        profileBtn.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showOpenDialog(null);//select file to open

            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                String fileS = fileChooser.getSelectedFile().getAbsolutePath();
                profileLabel.setText(fileS);
            }
        });

        imageInsertPanel.add(profileLabel);
        imageInsertPanel.add(profileBtn);


        JPanel logBtnLabel = new JPanel();
        logBtnLabel.setBounds(0,460,400,50);

        registerSubmit = new JButton();
        registerSubmit.setText("Register");
        registerSubmit.setBackground(new Color(128,128,128));
        registerSubmit.setFont(new Font("Serif", Font.BOLD, 18));
        logBtnLabel.add(registerSubmit);

        JPanel noAccount = new JPanel();
        noAccount.setBounds(0,495,400,50);

        JButton loginBtn = new JButton();
        loginBtn.setText("Login");
        loginBtn.setForeground(Color.red);
        //this is to make the button transparent i have no idea about the code :)
        loginBtn.setBorderPainted(false);
        loginBtn.setContentAreaFilled(false);
        loginBtn.setFocusPainted(false);
        loginBtn.setOpaque(false);

        loginBtn.setFont(new Font("Serif", Font.BOLD, 18));

        JLabel loginLabel = new JLabel("Have Account?");
        loginLabel.setFont(new Font("Serif", Font.BOLD, 22));

        noAccount.add(loginLabel);
        noAccount.add(loginBtn);
        registerFrame.add(noAccount);
        registerFrame.add(logBtnLabel);

        registerSubmit.addActionListener(e -> {
            registersubmit();
        });
        loginBtn.addActionListener(e -> {
            loginWindow();
        });


    }

    void registersubmit(){
        Dfname = firstNameField.getText().toString();
        Dlname = lastNameField.getText().toString();
        Dpassword = String.valueOf(passField.getPassword());
        Dusername = userField.getText().toString();
        System.out.println(Dusername);
        addUserToDatabase(Dfname, Dlname, Dpassword, Dusername);
    }
    void addUserToDatabase(String Dfname,String Dlname,String Dpassword,String Dusername){
        try {
            Statement stmt = connection.createStatement();

            String sql = "INSERT INTO users (fname, lname, username, password)" + "VALUES (?,?,?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, Dfname);
            preparedStatement.setString(2, Dlname);
            preparedStatement.setString(3, Dusername);
            preparedStatement.setString(4, Dpassword);
            preparedStatement.executeUpdate();
            System.out.println("registered");
//            stmt.close();
//            connection.close();
        }catch(Exception e){
            System.out.println("not added to sql!");
            e.printStackTrace();
        }

    }

     void validateUser(String username, String password){
         System.out.println(username);
         System.out.println(password);
         String checker = "SELECT * FROM users WHERE username='"+username+"' AND password='"+password+"'";
        try{
            Statement statement = connection.createStatement();

            System.out.println(checker);
            PreparedStatement preparedStatement = connection.prepareStatement(checker);

            ResultSet results = preparedStatement.executeQuery();

            if(results.next()){
                System.out.println("Login Successfull");
            }
            else {
                System.out.println("Login Failed");
            }

        }catch (Exception e){
            System.out.println("Error logging in");

        }
    }

}
