import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.FileInputStream;
import java.sql.*;

public class Upload {
    JPanel uploadFrame;
    JLabel upImages;

    File img;

    Connection1 connection;
    JLabel upLabel;
    Color mode = new Color(0, 0, 0);
    Color mode2 = new Color(255, 255, 255);
    JLabel price;
    JLabel basicInfo;
    JLabel firstName;
    JTextField firstNameInput;
    JTextField middleNameInput;
    JLabel middleName;
    JLabel lastName;
    JTextField lastNameInput;
    JLabel genderL;
    JComboBox gender;
    JLabel contactInfo;
    JLabel Email;
    JTextField EmailInput;
    JLabel confirmEmail;
    JTextField confirmEmailInput;
    JLabel phoneNo;
    JComboBox countryCode;
    JTextField phoneNoInput;
    JLabel houseInfo;
    JLabel Region;
    JComboBox regionSelector;
    JLabel City;
    JTextField cityInput;
    JLabel StreetAddress1;
    JTextField streetAddress1Input;
    JLabel StreetAddress2;
    JTextField streetAddress2Input;
    JLabel houseSize;
    JTextField houseSizeInput;
    JLabel bedroom;
    JComboBox bedroomSize;
    JCheckBox water;
    JCheckBox electricity;
    JTextField priceInput;
    JLabel opinionL;
    JTextArea opinion;
    JScrollPane op;
    JPanel holderTemp;
    JButton imageChooser;
    JButton uploadSubmit;
    String name;
    String path;
    String usernameP;

    Upload() {
        connection = new Connection1();

        uploadFrame = new JPanel();
        uploadFrame.setBackground(new Color(30, 31, 34));
        uploadFrame.setPreferredSize(new Dimension(400, 300));
        uploadFrame.setLayout(null);

        upLabel = new JLabel("Owners Form");
        upLabel.setFont(new Font("Abyssinica SIL", Font.BOLD, 26));
        upLabel.setForeground(mode2);
        upLabel.setBounds(500, 20, 200, 50);

        basicInfo = new JLabel("Basic Info");
        basicInfo.setFont(new Font("Abyssinica SIL", Font.BOLD, 18));
        basicInfo.setForeground(mode2);
        basicInfo.setBounds(20, 60, 200, 50);

        firstName = new JLabel("First Name");
        firstName.setFont(new Font("Abyssinica SIL", Font.BOLD, 16));
        firstName.setForeground(mode2);
        firstName.setBounds(20, 120, 100, 30);

        firstNameInput = new JTextField();
        firstNameInput.setFont(new Font("Abyssinica SIL", Font.BOLD, 18));
        firstNameInput.setForeground(Color.BLACK);
        firstNameInput.setBounds(20, 150, 200, 30);
        firstNameInput.setOpaque(false);

        middleName = new JLabel("Middle Name");
        middleName.setFont(new Font("Abyssinica SIL", Font.BOLD, 16));
        middleName.setForeground(mode2);
        middleName.setBounds(240, 120, 150, 30);

        middleNameInput = new JTextField();
        middleNameInput.setFont(new Font("Abyssinica SIL", Font.BOLD, 18));
        middleNameInput.setForeground(Color.BLACK);
        middleNameInput.setBounds(240, 150, 200, 30);
        middleNameInput.setOpaque(false);

        lastName = new JLabel("Last Name");
        lastName.setFont(new Font("Abyssinica SIL", Font.BOLD, 14));
        lastName.setForeground(mode2);
        lastName.setBounds(20, 200, 100, 30);

        lastNameInput = new JTextField();
        lastNameInput.setFont(new Font("Abyssinica SIL", Font.BOLD, 18));
        lastNameInput.setForeground(Color.BLACK);
        lastNameInput.setBounds(20, 230, 200, 30);
        lastNameInput.setOpaque(false);

        genderL = new JLabel("Gender");
        genderL.setFont(new Font("Abyssinica SIL", Font.BOLD, 14));
        genderL.setForeground(mode2);
        genderL.setBounds(240, 200, 100, 30);


        gender = new JComboBox();
        gender.setFont(new Font("Abyssinica SIL", Font.BOLD, 14));
        gender.setForeground(mode2);
        gender.setBounds(240, 230, 100, 30);
        gender.setOpaque(false);
        gender.addItem("");
        gender.addItem("Male");
        gender.addItem("Female");
        gender.setBackground(new Color(30, 31, 34));
        gender.applyComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        ///////////////////////////Contact///////////////////////////////


        contactInfo = new JLabel("Contact Info");
        contactInfo.setFont(new Font("Abyssinica SIL", Font.BOLD, 18));
        contactInfo.setForeground(mode2);
        contactInfo.setBounds(650, 60, 200, 50);

        Email = new JLabel("Email");
        Email.setFont(new Font("Abyssinica SIL", Font.BOLD, 14));
        Email.setForeground(mode2);
        Email.setBounds(650, 120, 100, 30);

        EmailInput = new JTextField();
        EmailInput.setFont(new Font("Abyssinica SIL", Font.BOLD, 18));
        EmailInput.setForeground(Color.BLACK);
        EmailInput.setBounds(650, 150, 250, 30);
        EmailInput.setOpaque(false);

        confirmEmail = new JLabel("Username");
        confirmEmail.setFont(new Font("Abyssinica SIL", Font.BOLD, 14));
        confirmEmail.setForeground(mode2);
        confirmEmail.setBounds(650, 200, 200, 30);

        confirmEmailInput = new JTextField();
        confirmEmailInput.setFont(new Font("Abyssinica SIL", Font.BOLD, 18));
        confirmEmailInput.setForeground(Color.BLACK);
        confirmEmailInput.setBounds(650, 230, 250, 30);
        confirmEmailInput.setOpaque(false);

        phoneNo = new JLabel("P.No");
        phoneNo.setFont(new Font("Abyssinica SIL", Font.BOLD, 14));
        phoneNo.setForeground(mode2);
        phoneNo.setBounds(950, 120, 50, 30);

        countryCode = new JComboBox();
        countryCode.setFont(new Font("Abyssinica SIL", Font.BOLD, 14));
        countryCode.setForeground(mode2);
        countryCode.setBounds(950, 150, 70, 30);
        countryCode.setOpaque(false);
        countryCode.addItem("+251");
        countryCode.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        countryCode.setBackground(new Color(30, 31, 34));

        phoneNoInput = new JTextField();
        phoneNoInput.setFont(new Font("Abyssinica SIL", Font.BOLD, 18));
        phoneNoInput.setForeground(Color.BLACK);
        phoneNoInput.setBounds(1020, 150, 150, 30);
        phoneNoInput.setOpaque(false);


        ///////////////////////////////////////////////////////////
        //info about the house

        houseInfo = new JLabel("House Info");
        houseInfo.setFont(new Font("Abyssinica SIL", Font.BOLD, 18));
        houseInfo.setForeground(mode2);
        houseInfo.setBounds(20, 300, 200, 50);

        Region = new JLabel("Region");
        Region.setFont(new Font("Abyssinica SIL", Font.BOLD, 14));
        Region.setForeground(mode2);
        Region.setBounds(20, 360, 100, 30);

        regionSelector = new JComboBox();
        regionSelector.setFont(new Font("Abyssinica SIL", Font.BOLD, 14));
        regionSelector.setForeground(mode2);
        regionSelector.setBounds(20, 390, 150, 30);
        regionSelector.setOpaque(false);
        regionSelector.setBackground(new Color(30, 31, 34));
        regionSelector.addItem("");
        regionSelector.addItem("Addis Ababa");
        regionSelector.addItem("Tigray");
        regionSelector.addItem("Afar");
        regionSelector.addItem("Amhara");
        regionSelector.addItem("Oromia");
        regionSelector.addItem("Somali");
        regionSelector.addItem("Benishangul-Gumuz");
        regionSelector.addItem("SNNPR");
        regionSelector.addItem("Gambella");
        regionSelector.addItem("Harari");
        regionSelector.applyComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);


        City = new JLabel("City");
        City.setFont(new Font("Abyssinica SIL", Font.BOLD, 14));
        City.setForeground(mode2);
        City.setBounds(240, 360, 100, 30);

        cityInput = new JTextField();
        cityInput.setFont(new Font("Abyssinica SIL", Font.BOLD, 18));
        cityInput.setForeground(Color.BLACK);
        cityInput.setBounds(240, 390, 200, 30);
        cityInput.setOpaque(false);

        StreetAddress1 = new JLabel("Street Address");
        StreetAddress1.setFont(new Font("Abyssinica SIL", Font.BOLD, 14));
        StreetAddress1.setForeground(mode2);
        StreetAddress1.setBounds(20, 440, 200, 30);

        streetAddress1Input = new JTextField();
        streetAddress1Input.setFont(new Font("Abyssinica SIL", Font.BOLD, 18));
        streetAddress1Input.setForeground(Color.BLACK);
        streetAddress1Input.setBounds(20, 470, 200, 30);
        streetAddress1Input.setOpaque(false);

        StreetAddress2 = new JLabel("Street Address2(Optional)");
        StreetAddress2.setFont(new Font("Abyssinica SIL", Font.BOLD, 14));
        StreetAddress2.setForeground(mode2);
        StreetAddress2.setBounds(240, 440, 200, 30);

        streetAddress2Input = new JTextField();
        streetAddress2Input.setFont(new Font("Abyssinica SIL", Font.BOLD, 18));
        streetAddress2Input.setForeground(Color.BLACK);
        streetAddress2Input.setBounds(240, 470, 200, 30);
        streetAddress2Input.setOpaque(false);

        houseSize = new JLabel("House Size(sqCare)");
        houseSize.setFont(new Font("Abyssinica SIL", Font.BOLD, 14));
        houseSize.setForeground(mode2);
        houseSize.setBounds(20, 520, 200, 30);

        houseSizeInput = new JTextField();
        houseSizeInput.setFont(new Font("Abyssinica SIL", Font.BOLD, 18));
        houseSizeInput.setForeground(Color.BLACK);
        houseSizeInput.setBounds(20, 550, 200, 30);
        houseSizeInput.setOpaque(false);

        bedroom = new JLabel("How Many Bed rooms?");
        bedroom.setFont(new Font("Abyssinica SIL", Font.BOLD, 14));
        bedroom.setForeground(mode2);
        bedroom.setBounds(240, 520, 200, 30);

        bedroomSize = new JComboBox();
        bedroomSize.setFont(new Font("Abyssinica SIL", Font.BOLD, 14));
        bedroomSize.setForeground(mode2);
        bedroomSize.setBounds(240, 550, 200, 30);
        bedroomSize.setOpaque(false);
        bedroomSize.addItem("1");
        bedroomSize.addItem("2");
        bedroomSize.addItem("3");
        bedroomSize.addItem("4");
        bedroomSize.addItem("5");
        bedroomSize.addItem("more");
        bedroomSize.setBackground(new Color(30, 31, 34));
        bedroomSize.applyComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        water = new JCheckBox("Water is Available");
        water.setBounds(20, 600, 200, 30);
        water.setForeground(mode2);
        water.setFocusPainted(false);
        water.setFont(new Font("Abyssinica SIL", Font.BOLD, 16));
        water.setBackground(new Color(30, 31, 34));

        electricity = new JCheckBox("Electricity is Available");
        electricity.setBounds(20, 635, 200, 30);
        electricity.setForeground(mode2);
        electricity.setFont(new Font("Abyssinica SIL", Font.BOLD, 16));
        electricity.setBackground(new Color(30, 31, 34));
        electricity.setFocusPainted(false);

        price = new JLabel("Price");
        price.setFont(new Font("Abyssinica SIL", Font.BOLD, 16));
        price.setForeground(mode2);
        price.setBounds(240, 600, 200, 30);

        priceInput = new JTextField();
        priceInput.setFont(new Font("Abyssinica SIL", Font.BOLD, 18));
        priceInput.setForeground(Color.BLACK);
        priceInput.setBounds(240, 630, 200, 30);
        priceInput.setOpaque(false);

        opinionL = new JLabel("Additional Information (Optional)");
        opinionL.setFont(new Font("Abyssinica SIL", Font.BOLD, 16));
        opinionL.setForeground(mode2);
        opinionL.setBounds(650, 360, 300, 30);

        opinion = new JTextArea();
        opinion.setFont(new Font("Abyssinica SIL", Font.BOLD, 18));
        opinion.setForeground(mode2);
        opinion.setBounds(650, 390, 270, 270);
        opinion.setBackground(new Color(61, 62, 68));

        op = new JScrollPane(opinion);
        op.setPreferredSize(new Dimension(250, 250));

        holderTemp = new JPanel();
        holderTemp.setBackground(new Color(61, 62, 68));
        holderTemp.setBounds(950, 390, 200, 150);


        imageChooser = new JButton("Select Image");
        imageChooser.setFont(new Font("Abyssinica SIL", Font.BOLD, 16));
        imageChooser.setBounds(950, 560, 200, 40);
        imageChooser.setBackground(new Color(47, 47, 47));
        imageChooser.setBorderPainted(false);
        imageChooser.setFocusPainted(false);
        imageChooser.setForeground(mode2);
        imageChooser.setFocusPainted(false);


        upImages = new JLabel();
        upImages.setForeground(mode2);
        upImages.setBounds(950, 395, 190, 140);

        uploadFrame.add(upImages);

        imageChooser.addActionListener(e -> {
            JFileChooser file = new JFileChooser();
            file.setCurrentDirectory(new File(System.getProperty("user.home")));
            //filter the files
            FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg", "gif", "png");
            file.addChoosableFileFilter(filter);
            int result = file.showSaveDialog(null);
            //if the user click on save in Jfilechooser
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = file.getSelectedFile();
                path = selectedFile.getAbsolutePath();
                img = new File(path);
                upImages.setIcon(ResizeImage(path));
            }
        });


        uploadSubmit = new JButton("UPLOAD");
        uploadSubmit.setFont(new Font("Abyssinica SIL", Font.BOLD, 16));
        uploadSubmit.setBounds(950, 620, 200, 40);
        uploadSubmit.setBackground(new Color(0, 119, 56));
        uploadSubmit.setBorderPainted(false);
        uploadSubmit.setFocusPainted(false);
        uploadSubmit.setForeground(mode2);
        uploadSubmit.setFocusPainted(false);

        uploadSubmit.addActionListener(e -> {
            String uploadFirstName = firstNameInput.getText();
            String uploadMiddleName = middleNameInput.getText();
            String uploadLastName = lastNameInput.getText();
            String uploadGender = (String) gender.getSelectedItem();
            String uploadRegion = (String) regionSelector.getSelectedItem();
            String uploadCity = cityInput.getText();
            String uploadStreetAddress1 = streetAddress1Input.getText();
            String uploadStreetAddress2 = streetAddress2Input.getText();
            String uploadHouseSize = houseSizeInput.getText();
            String noBedRooms = (String) bedroomSize.getSelectedItem();
//            String uploadWater = ;
//            String uploadElectricity;
            String uploadPrice = priceInput.getText();
            String uploadEmail = EmailInput.getText();
            String uploadURL = confirmEmailInput.getText();
            String uploadPhoneNo = phoneNoInput.getText();
            String uploadAdditionalInfo = opinion.getText();


            uploadHouseToDb(img, uploadEmail, uploadURL, uploadPhoneNo, uploadAdditionalInfo, uploadFirstName, uploadMiddleName, uploadLastName, uploadGender, uploadRegion, uploadCity, uploadStreetAddress1, uploadStreetAddress2, uploadHouseSize, noBedRooms, uploadPrice);

            name = uploadFirstName + " " + uploadMiddleName + " " + uploadLastName;

//            new Post(name, path);
        });

        /////////////////////////////////////////////////////////////////////


        uploadFrame.add(upLabel);
        uploadFrame.add(basicInfo);
        uploadFrame.add(firstName);
        uploadFrame.add(firstNameInput);
        uploadFrame.add(middleName);
        uploadFrame.add(middleNameInput);
        uploadFrame.add(lastName);
        uploadFrame.add(lastNameInput);
        uploadFrame.add(genderL);
        uploadFrame.add(gender);
        uploadFrame.add(contactInfo);
        uploadFrame.add(Email);
        uploadFrame.add(EmailInput);
        uploadFrame.add(confirmEmail);
        uploadFrame.add(confirmEmailInput);
        uploadFrame.add(phoneNo);
        uploadFrame.add(countryCode);
        uploadFrame.add(phoneNoInput);
        uploadFrame.add(houseInfo);
        uploadFrame.add(Region);
        uploadFrame.add(regionSelector);
        uploadFrame.add(City);
        uploadFrame.add(cityInput);
        uploadFrame.add(StreetAddress1);
        uploadFrame.add(StreetAddress2);
        uploadFrame.add(streetAddress1Input);
        uploadFrame.add(streetAddress2Input);
        uploadFrame.add(houseSize);
        uploadFrame.add(houseSizeInput);
        uploadFrame.add(bedroom);
        uploadFrame.add(bedroomSize);
        uploadFrame.add(water);
        uploadFrame.add(electricity);
        uploadFrame.add(price);
        uploadFrame.add(priceInput);
        uploadFrame.add(opinion);
        uploadFrame.add(opinionL);
        uploadFrame.add(holderTemp);
        uploadFrame.add(imageChooser);
        uploadFrame.add(uploadSubmit);


    }

    public ImageIcon ResizeImage(String ImagePath) {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(upImages.getWidth(), upImages.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

    public JPanel getUploadPane() {
        return uploadFrame;
    }

    void uploadHouseToDb(File img, String uploadEmail, String uploadURL, String uploadPhoneNo, String uploadAdditionalInfo, String uploadFirstName, String uploadMiddleName, String uploadLastName, String uploadGender, String uploadRegion, String uploadCity, String uploadStreetAddress1, String uploadStreetAddress2, String uploadHouseSize, String noBedRooms, String uploadPrice) {
        try (FileInputStream fin = new FileInputStream(img)) {
//            Statement stmt = connection.createStatement();
            String sql = "INSERT INTO uploadhouse (uploadfirstname,uploadmiddlename,uploadlastname,uploadgender,uploadregion,uploadcity,uploadstreetaddress1,uploadstreetaddress2,uploadhousesize,nobedrooms,uploadprice,uploademail,uploadurl,uploadphoneno,uploadadditionalinfo,uploadimage, id) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            String sql2 = "SELECT COUNT (id) FROM uploadhouse ";
            Statement statement1 = connection.conn.createStatement();
            ResultSet resultSet1 = statement1.executeQuery(sql2);
            resultSet1.next();
            int count = resultSet1.getInt(1);

            PreparedStatement preparedStatement = connection.conn.prepareStatement(sql);
            preparedStatement.setString(1, uploadFirstName);
            preparedStatement.setString(2, uploadMiddleName);
            preparedStatement.setString(3, uploadLastName);
            preparedStatement.setString(4, uploadGender);
            preparedStatement.setString(5, uploadRegion);
            preparedStatement.setString(6, uploadCity);
            preparedStatement.setString(7, uploadStreetAddress1);
            preparedStatement.setString(8, uploadStreetAddress2);
            preparedStatement.setString(9, uploadHouseSize);
            preparedStatement.setString(10, noBedRooms);
            preparedStatement.setString(11, uploadPrice);
            preparedStatement.setString(12, uploadEmail);
            preparedStatement.setString(13, uploadURL);
            preparedStatement.setString(14, uploadPhoneNo);
            preparedStatement.setString(15, uploadAdditionalInfo);
            preparedStatement.setBinaryStream(16, fin, (int) img.length());
            preparedStatement.setInt(17, count + 1);

            preparedStatement.executeUpdate();
            System.out.println("uploaded");
            SuccessDisplay("Uploaded");


        } catch (Exception e) {
            ErrorDisplay("Please Fill Correctly");
            System.out.println("not added to sql!");
            e.printStackTrace();
        }

    }

    private void SuccessDisplay(String text) {
        JFrame errorFrame = new JFrame();
        errorFrame.setUndecorated(true);
        errorFrame.setSize(255, 300);
        errorFrame.setLayout(null);
        errorFrame.setShape(new RoundRectangle2D.Double(0, 0, 255, 300, 50, 50));


        JPanel message = new JPanel();
        message.setBounds(0, 0, 255, 50);
        message.setBackground(new Color(242, 242, 242));

        JLabel messagelabel = new JLabel(text);
        messagelabel.setForeground(new Color(37, 36, 36));
        messagelabel.setFont(new Font("serif", Font.BOLD, 22));
        message.add(messagelabel);
        messagelabel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));

        JPanel panel = new JPanel();
        panel.setBounds(0, 50, 255, 250);
        panel.setBackground(new Color(242, 242, 242));

        ImageIcon image = new ImageIcon(this.getClass().getResource("successfull.gif"));
        JLabel label = new JLabel();
        label.setIcon(image);

        panel.add(label);
        errorFrame.add(message);
        errorFrame.add(panel);

        errorFrame.setLocationRelativeTo(null);
        errorFrame.setVisible(true);

        new Timer(4000, (e) -> {
            errorFrame.setVisible(false);
            errorFrame.dispose();
        }).start();


    }

    private void ErrorDisplay(String text) {
        JFrame errorFrame = new JFrame();
        errorFrame.setUndecorated(true);
        errorFrame.setSize(255, 300);
        errorFrame.setLayout(null);
        errorFrame.setShape(new RoundRectangle2D.Double(0, 0, 255, 300, 50, 50));


        JPanel message = new JPanel();
        message.setBounds(0, 0, 255, 50);
        message.setBackground(new Color(255, 149, 149));

        JLabel messagelabel = new JLabel(text);
        messagelabel.setForeground(Color.WHITE);
        messagelabel.setFont(new Font("serif", Font.BOLD, 22));
        message.add(messagelabel);
        messagelabel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));

        JPanel panel = new JPanel();
        panel.setBounds(0, 50, 255, 250);
        panel.setBackground(new Color(255, 149, 149));

        ImageIcon image = new ImageIcon(this.getClass().getResource("error.gif"));
        JLabel label = new JLabel();
        label.setIcon(image);

        panel.add(label);
        errorFrame.add(panel);
        errorFrame.add(message);


        errorFrame.setLocationRelativeTo(null);
        errorFrame.setVisible(true);

        new Timer(2400, (e) -> {
            errorFrame.setVisible(false);
            errorFrame.dispose();
        }).start();


    }
}
