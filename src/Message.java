import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Message extends JPanel {
    JPanel frame;
    JPanel mesSenter[];
    JLabel fromName[];
    JLabel themess[];
    JPanel themessHolder[];
    JPanel messages;
    JPanel messageArea;
    Connection1 connection;
    String fromusername;
    String themessage;
    JLabel firstLabel;
    JLabel secondLabel;
    JPanel[] messagesenter;
    JPanel[] messagePart;

    JPanel[] additionalMessagePart;
    JLabel[] prof;
    JLabel[] date;
    JLabel[] from;
    JLabel[] message;
    JPanel messpart[];

    JScrollPane scroller;
    JScrollPane scroller2;

    JLabel[] newFrom;

    ImageIcon images;
    Image image;
    int alldata = 0;
    int Y;

    int j;
    int i;
    JPanel emoji;
    JPanel theimage1;
    JPanel theimage2;
    JPanel theimage;
    JPanel fmessage;
    JLabel[] topHolderPP;
    Map<String, ArrayList<String>> multipleMessagesfromOneUser;
    JPanel topHolder;
    JPanel lowHolder;
    JTextField search;
    JPanel centerHolder;

    Message() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception ignored) {
        }

        String lastStatus = "";

        connection = new Connection1();


        frame = new JPanel();
        frame.setLayout(new BorderLayout());
        frame.setBackground(new Color(28, 29, 33));
        centerHolder = new JPanel();
        centerHolder.setLayout(new BorderLayout());

        topHolder = new JPanel();
        topHolder.setPreferredSize(new Dimension(50, 50));
        topHolder.setLayout(new FlowLayout(FlowLayout.LEFT));
        topHolder.setBackground(new Color(28, 29, 33));

        lowHolder = new JPanel();
        lowHolder.setPreferredSize(new Dimension(50, 100));
        lowHolder.setBackground(new Color(28, 29, 33));

        search = new JTextField();
        search.setPreferredSize(new Dimension(750, 50));
        search.setOpaque(false);
        search.setFont(new Font("Abyssinica SIL", Font.BOLD, 22));
        search.setBackground(new Color(103, 98, 98));
        search.setForeground(new Color(241, 241, 241));


        ImageIcon ima = new ImageIcon(this.getClass().getResource("send.png"));
        JLabel send = new JLabel(ima);
        send.setPreferredSize(new Dimension(50, 50));


        lowHolder.add(search);
        lowHolder.add(send);


        messages = new JPanel();
        messages.setBackground(new Color(28, 29, 33));
        messages.setPreferredSize(new Dimension(400, 1000));

        JPanel basugram = new JPanel();
        basugram.setBackground(new Color(114, 161, 248));
        basugram.setPreferredSize(new Dimension(300, 70));

        JLabel basugramL = new JLabel("DelalaGram");
        basugramL.setFont(new Font("sarif", Font.BOLD, 22));
        basugramL.setForeground(Color.white);

        JLabel gramIcon = new JLabel(new ImageIcon(this.getClass().getResource("send.png")));
        gramIcon.setPreferredSize(new Dimension(50, 50));


        basugram.add(basugramL);
        basugram.add(gramIcon);

        JPanel savedMessages = new JPanel();
        savedMessages.setBackground(new Color(114, 161, 248));
        savedMessages.setPreferredSize(new Dimension(395, 70));
        savedMessages.setLayout(null);

        JLabel savedMmessagesL = new JLabel("Saved Messages");
        savedMmessagesL.setFont(new Font("sarif", Font.BOLD, 18));
        savedMmessagesL.setForeground(Color.white);
        savedMmessagesL.setBounds(50, 20, 200, 30);

        JLabel savedIcon = new JLabel(new ImageIcon(this.getClass().getResource("saved.png")));
        savedIcon.setBounds(10, 20, 30, 30);

        savedMessages.add(savedMmessagesL);
        savedMessages.add(savedIcon);

        messages.add(basugram);
        messages.add(savedMessages);

        theimage = new JPanel();
        theimage.setPreferredSize(new Dimension(400, 200));
        theimage.setVisible(false);
        theimage.setBackground(new Color(66, 66, 66));

        Icon imgIcon = new ImageIcon(this.getClass().getResource("underconstraction.gif"));
        JLabel label = new JLabel(imgIcon);

        theimage.add(label);
        ////////////////////////////////////////////////////
        theimage1 = new JPanel();
        theimage1.setPreferredSize(new Dimension(400, 200));
        theimage1.setVisible(false);
        theimage1.setBackground(new Color(66, 66, 66));

        Icon imgIcon1 = new ImageIcon(this.getClass().getResource("programmer.gif"));
        JLabel label1 = new JLabel(imgIcon1);

        theimage1.add(label1);
        ///////////////////////////////////////////////////////
        theimage2 = new JPanel();
        theimage2.setPreferredSize(new Dimension(400, 200));
        theimage2.setVisible(false);
        theimage2.setBackground(new Color(66, 66, 66));

        Icon imgIcon2 = new ImageIcon(this.getClass().getResource("monkey.gif"));
        JLabel label2 = new JLabel(imgIcon2);

        theimage2.add(label2);
        /////////////////////////////////////////////////////////////

        messageArea = new JPanel();
        messageArea.setBackground(new Color(66, 66, 66));
        messageArea.setBounds(0, 0, 300, 1200);
        messageArea.setLayout(new FlowLayout(FlowLayout.RIGHT));

        emoji = new JPanel();
        emoji.setPreferredSize(new Dimension(600, 450));
        emoji.setBackground(new Color(66, 66, 66));
        emoji.setVisible(false);
        messageArea.add(emoji);

        fmessage = new JPanel();
        fmessage.setPreferredSize(new Dimension(1200, 800));
        fmessage.setBackground(new Color(66, 66, 66));

        firstLabel = new JLabel("WELCOM to CheapDelala!");
        firstLabel.setFont(new Font("sarif", Font.BOLD, 30));
        firstLabel.setPreferredSize(new Dimension(700, 50));
        firstLabel.setForeground(Color.white);

        secondLabel = new JLabel("This is just a Simplified verson of Telegram");
        secondLabel.setFont(new Font("sarif", Font.ITALIC, 18));
        secondLabel.setPreferredSize(new Dimension(700, 30));
        secondLabel.setForeground(Color.white);

        fmessage.add(firstLabel);
        fmessage.add(secondLabel);

        messageArea.add(fmessage, FlowLayout.CENTER);

        getUserData();

        scroller = new JScrollPane(messages);
        scroller.getVerticalScrollBar().setUnitIncrement(16);
        scroller.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroller2 = new JScrollPane(messageArea);
        scroller2.getVerticalScrollBar().setUnitIncrement(16);
        scroller2.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
        scroller2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);


        savedMessages.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                for (int l = 0; l < uniqueValues; l++) {
                    if (messpart[l] != null)
                        messpart[l].setVisible(false);
                }
                theimage.setVisible(true);
                theimage1.setVisible(true);
                theimage2.setVisible(true);

                emoji.setVisible(true);

                emoji.add(theimage);
                emoji.add(theimage1);
                emoji.add(theimage2);

                emoji.setPreferredSize(new Dimension(400, 500));
                messageArea.setBounds(0, 0, 300, 500);
                savedMessages.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//                scroller2.setVisible(false);
//                frame.add(messageArea);
                fmessage.setVisible(false);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                savedMessages.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
        });

        centerHolder.add(scroller2, BorderLayout.CENTER);
        frame.add(scroller, BorderLayout.WEST);
        frame.add(centerHolder, BorderLayout.CENTER);
        centerHolder.add(topHolder, BorderLayout.NORTH);
        centerHolder.add(lowHolder, BorderLayout.SOUTH);

    }

    JPanel getMessagePanel() {
        return frame;
    }

    SideProfile h;
    int uniqueValues = 0;

    void getUserData() {
        h = new SideProfile();
        String checker = "SELECT * FROM messages WHERE tousername=?";
        String un = "SELECT * FROM loginchecker";
        String unique = "select distinct fromusername  from messages where tousername = ?";
        String all = "Select * from messages";
        String last = "";
        try {
            PreparedStatement stmt = connection.conn.prepareStatement(un);
            ResultSet results = stmt.executeQuery();

            while (results.next()) {
                last = results.getString("username");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Statement statement = connection.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            PreparedStatement preparedStatement = connection.conn.prepareStatement(checker);
            PreparedStatement preparedStatement2 = connection.conn.prepareStatement(unique);
            PreparedStatement preparedStatement3 = connection.conn.prepareStatement(all);


            preparedStatement2.setString(1, last);
            preparedStatement.setString(1, last);

            ResultSet results2 = preparedStatement2.executeQuery();
            ResultSet results = preparedStatement.executeQuery();
            ResultSet results3 = preparedStatement3.executeQuery();

            while (results3.next()) {
                alldata++;
            }

            while (results2.next()) {
                uniqueValues++;
            }

            int messageNumberCounter = alldata;

            messagesenter = new JPanel[messageNumberCounter];
            messagePart = new JPanel[messageNumberCounter];


            date = new JLabel[messageNumberCounter];
            prof = new JLabel[messageNumberCounter];
            topHolderPP = new JLabel[messageNumberCounter];

            from = new JLabel[messageNumberCounter];
            message = new JLabel[messageNumberCounter];


            MouseListener ml = new MouseListener() {

                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    JPanel p = (JPanel) evt.getSource();
                   int i = p.getY();

                    int a;
                    for (a = 0; a < 50; a++) {
                        int x = 5 + 75 * a;
                        if (i / x == 0) {
                            break;
                        }
                    }

                    //////////the uniqe key values of the map is 4//////////////////////////
                    for (int l = 0; l < uniqueValues; l++) {
                        if (messpart[l] != null)
                            messpart[l].setVisible(false);
                        if (topHolderPP[l] != null)
                            topHolderPP[l].setVisible(false);
                    }

                    messpart[a - 3].setVisible(true);
                    topHolderPP[a - 3].setVisible(true);

                    emoji.setVisible(false);
                    fmessage.setVisible(false);
                    messageArea.setBounds(0, 0, 300, 1000);


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
            };
            i = 0;
            while (results.next()) {
                fromusername = results.getString("fullname");
                themessage = results.getString("themessage");


                messagesenter[i] = new JPanel();

                messagePart[i] = new JPanel();
                messagePart[i].setBackground(new Color(68, 124, 75));
                messagePart[i].setPreferredSize(new Dimension(400, 70));
                messagePart[i].setLayout(null);
                messagePart[i].setVisible(false);

                from[i] = new JLabel();
                from[i].setText(fromusername);
                from[i].setBounds(60, 30, 200, 30);
                from[i].setForeground(Color.white);
                from[i].setFont(new Font("sarif", Font.BOLD, 18));

                message[i] = new JLabel();
                message[i].setText(themessage);
                message[i].setForeground(Color.white);
                message[i].setFont(new Font("Sarif", Font.ITALIC, 18));
                message[i].setBounds(10, 10, 400, 30);
                i++;
                j = i;
                if (i == 50) {
                    break;
                }

            }
            ////////////////////////////////////////////////////////////

            multipleMessagesfromOneUser = new HashMap<String, ArrayList<String>>();

            //////////////////only here is the problem

            // only 4 people are unique
            for (int h = 0; h < uniqueValues; h++) {
                ArrayList<String> values = new ArrayList<String>();
                if (from[h] != null) {
                    if (!multipleMessagesfromOneUser.containsKey(from[h])) {
                        values.add(message[h].getText());
                        for (int g = h + 1; g < alldata; g++) {
                            if (from[g] != null) {
                                if (from[h].getText().equals(from[g].getText())) {
                                    values.add(message[g].getText());
                                }
                            }
                        }
                    }
                    if (from[h] != null)
                        multipleMessagesfromOneUser.put(from[h].getText(), values);

                }
            }

            mesSenter = new JPanel[multipleMessagesfromOneUser.size()];
            fromName = new JLabel[multipleMessagesfromOneUser.size()];
            themess = new JLabel[10];
            themessHolder = new JPanel[10];
            messpart = new JPanel[uniqueValues];
            int cnt = 0;
            for (Map.Entry<String, ArrayList<String>> data : multipleMessagesfromOneUser.entrySet()) {
                mesSenter[cnt] = new JPanel();
                mesSenter[cnt].setBackground(new Color(66, 66, 66));
                mesSenter[cnt].setPreferredSize(new Dimension(395, 70));
                mesSenter[cnt].setLayout(null);
                mesSenter[cnt].addMouseListener(ml);

                fromName[cnt] = new JLabel();
                fromName[cnt].setText(data.getKey());
                fromName[cnt].setBounds(60, 20, 200, 30);
                fromName[cnt].setForeground(new Color(241, 241, 241));
                fromName[cnt].setFont(new Font("sarif", Font.BOLD, 18));

                messpart[cnt] = new JPanel();
                messpart[cnt].setBackground(new Color(61, 61, 61));
                messpart[cnt].setPreferredSize(new Dimension(500, 1200));
                messpart[cnt].setLayout(new FlowLayout(FlowLayout.RIGHT));
                messpart[cnt].setVisible(false);
                // int yy = 0;
                ///////only 5 messages available
                for (int y = 0; y < 10; y++) {
                    themessHolder[y] = new JPanel();
                    themessHolder[y].setBackground(new Color(114, 114, 114));
                    themessHolder[y].setPreferredSize(new Dimension(400, 100));
                    messpart[cnt].add(themessHolder[y]);
                    //yy += 120;
                }
                for (int y = 0; y < 10; y++) {
                    themess[y] = new JLabel();
                    themess[y].setForeground(new Color(241, 241, 241));
                    themess[y].setFont(new Font("Abyssinica SIL", Font.PLAIN, 18));
                    themess[y].setBounds(10, 10, 400, 30);

                    if (data.getValue().size() > y)
                        themess[y].setText(data.getValue().get(y));

                    themessHolder[y].add(themess[y]);
                }

                date[cnt] = new JLabel("12/6/2023");
                date[cnt].setForeground(new Color(241, 241, 241));
                date[cnt].setBounds(250, 20, 100, 30);
                date[cnt].setFont(new Font("sarif", Font.BOLD, 14));

                prof[cnt] = new JLabel();
                prof[cnt].setBounds(10, 20, 30, 30);
                prof[cnt].setIcon(new ImageIcon(this.getClass().getResource("profile.png")));

                topHolderPP[cnt] = new JLabel(fromName[cnt].getText());
                topHolderPP[cnt].setForeground(new Color(241, 241, 241));
                topHolderPP[cnt].setBounds(250, 20, 100, 30);
                topHolderPP[cnt].setFont(new Font("sarif", Font.BOLD, 22));
                topHolderPP[cnt].setVisible(false);
                topHolderPP[cnt].setHorizontalAlignment(JLabel.LEFT);

                mesSenter[cnt].add(prof[cnt]);
                mesSenter[cnt].add(date[cnt]);
                mesSenter[cnt].add(fromName[cnt]);
                messages.add(mesSenter[cnt]);
                messageArea.add(messpart[cnt]);
                topHolder.add(topHolderPP[cnt]);
                cnt++;
            }


        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Errorrrrrrrrrrrrrrrrrr logging in");

        }
    }

    public ImageIcon ResizeImage(String ImagePath) {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(1080, 720, Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }
}


