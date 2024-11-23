// // // import java.awt.*;
// // // import java.awt.event.*;
// // // import java.io.*;
// // // import javax.swing.*;
// // // import javax.swing.border.*;

// // // import com.toedter.calendar.JDateChooser;

// // // public class UserPage extends JFrame implements ActionListener {
// // //     private JPanel left, right, profilePanel, fitnessPanel, goalPanel;
// // //     private JButton profileButton, fitnessButton, goalButton;
// // //     private JLabel kuicon, rightH1, userLabel, separator1, separator2;
// // //     private CardLayout cardLayout;


// // //     // Profile Page Components
// // //     private JLabel nameLabel, emailLabel, bdLabel, phoneLabel, addressLabel, passLabel;
// // //     private JTextField nametf, emailtf, phonetf, addresstf;
// // //     private JDateChooser bdCalender;
// // //     private JPasswordField passtf;
// // //     private JButton edit, save, progressReport;

// // //     // Class constructor
// // //     public UserPage() {
// // //         initComponents();
// // //     }

// // //     private void initComponents() {
// // //         // default settings for the main frame
// // //         setTitle("User Page - KU Fitness Tracker");
// // //         setSize(1280, 720);
// // //         setMinimumSize(new Dimension(900, 600));
// // //         setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
// // //         setLayout(new BorderLayout());
        
// // //         // left SubPanel
// // //         left = new JPanel();
// // //         kuicon = new JLabel("", SwingConstants.LEFT);
// // //         profileButton = new JButton("My Profile");
// // //         fitnessButton = new JButton("Fitness Activity");
// // //         goalButton = new JButton("Goals");

// // //         // left SubPanel 
// // //         left.setBackground(new Color(62, 8, 76));
// // //         left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
// // //         left.setPreferredSize(new Dimension(250, getHeight()));

// // //         JLabel kuIcon = new JLabel(new ImageIcon("KU logo2.png"), SwingConstants.CENTER);
// // //         kuIcon.setAlignmentX(Component.CENTER_ALIGNMENT);
// // //         kuIcon.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

// // //         profileButton = createSidebarButton("My Profile");
// // //         fitnessButton = createSidebarButton("Fitness Activity");
// // //         goalButton = createSidebarButton("Goals");

// // //         left.add(kuIcon);
// // //         left.add(Box.createRigidArea(new Dimension(0, 20))); // Spacer
// // //         left.add(profileButton);
// // //         left.add(fitnessButton);
// // //         left.add(goalButton);

// // //         profileButton.setForeground(new Color(72, 24, 101));
// // //         profileButton.setFont(new Font("Segoe UI", 1, 14));
// // //         profileButton.addActionListener(this);
// // //         profileButton.setAlignmentX(Component.LEFT_ALIGNMENT);


// // //         fitnessButton.setForeground(new Color(72, 24, 101));
// // //         fitnessButton.setFont(new Font("Segoe UI", 1, 14));
// // //         fitnessButton.addActionListener(this);
// // //         fitnessButton.setAlignmentX(Component.LEFT_ALIGNMENT);


// // //         goalButton.setForeground(new Color(72, 24, 101));
// // //         goalButton.setFont(new Font("Segoe UI", 1, 14));
// // //         goalButton.addActionListener(this);
// // //         goalButton.setAlignmentX(Component.LEFT_ALIGNMENT);



// // //         left.add(kuicon, BorderLayout.NORTH);
// // //         left.add(profilButton, BorderLayout.CENTER);
// // //         left.add(fitnessButton, BorderLayout.SOUTH);
// // //         left.add(goalButton, BorderLayout.SOUTH);

// // //         // Right SubPanel
// // //         right = new JPanel();
// // //         profilePanel = new JPanel();
// // //         fitnessPanel = new JPanel();
// // //         goalPanel = new JPanel();

// // //         // Profile Page
// // //         rightH1 = new JLabel(String.format("Welcome,"), SwingConstants.CENTER);
// // //         nameLabel = new JLabel("Full Name", SwingConstants.LEFT);
// // //         nametf = new JTextField();
// // //         emailLabel = new JLabel("Email", SwingConstants.LEFT);
// // //         emailtf = new JTextField();
// // //         bdLabel = new JLabel("Date of Birth", SwingConstants.LEFT);
// // //         bdCalender = new JDateChooser();
// // //         phoneLabel = new JLabel("Phone Number", SwingConstants.LEFT);
// // //         phonetf = new JTextField();
// // //         addressLabel = new JLabel("Address", SwingConstants.LEFT); 
// // //         addresstf = new JTextField();
// // //         passLabel = new JLabel("Password", SwingConstants.LEFT);
// // //         passtf = new JPasswordField();
// // //         save = new JButton(" Save  ");
// // //         edit = new JButton();
// // //         separator1 = new JLabel("   "); // just a separator
// // //         separator2 = new JLabel("   "); // just a separator


// // //         // right SubPanel
// // //         right.setMinimumSize(new Dimension(400, 250));
// // //         right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
// // //         right.setBackground(new Color(134, 244, 238));
// // //         // rightCenter.setLayout(new BoxLayout(rightCenter, BoxLayout.Y_AXIS));
// // //         // rightCenter.setBackground(new Color(134, 244, 238));


// // //         rightH1.setFont(new Font("Segoe UI", 1, 36)); // NOI18N
// // //         rightH1.setForeground(new Color(62, 8, 76));
// // //         rightH1.setAlignmentX(Component.CENTER_ALIGNMENT);
// // //         rightH1.setBorder(BorderFactory.createEmptyBorder(30,0,30,0));

// // //         // rightCenter.setAlignmentX(Component.CENTER_ALIGNMENT);
// // //         // rightCenter.setBorder(BorderFactory.createEmptyBorder(0,20,25,20));

// // //         nameLabel.setBackground(new Color(0,0,0));
// // //         nameLabel.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
// // //         nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
// // //         nameLabel.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));

// // //         nametf.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
// // //         nametf.setForeground(new Color(102, 102, 102));
// // //         nametf.setAlignmentX(Component.LEFT_ALIGNMENT);

// // //         emailLabel.setBackground(new Color(0,0,0));
// // //         emailLabel.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
// // //         emailLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
// // //         emailLabel.setBorder(BorderFactory.createEmptyBorder(15,0,10,0));

// // //         emailtf.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
// // //         emailtf.setForeground(new Color(102, 102, 102));
// // //         emailtf.setAlignmentX(Component.LEFT_ALIGNMENT);

// // //         bdLabel.setBackground(new Color(0,0,0));
// // //         bdLabel.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
// // //         bdLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
// // //         bdLabel.setBorder(BorderFactory.createEmptyBorder(15,0,10,0));

// // //         bdCalender.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
// // //         bdCalender.setForeground(new Color(102, 102, 102));
// // //         bdCalender.setAlignmentX(Component.LEFT_ALIGNMENT);

// // //         phoneLabel.setBackground(new Color(0,0,0));
// // //         phoneLabel.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
// // //         phoneLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
// // //         phoneLabel.setBorder(BorderFactory.createEmptyBorder(15,0,10,0));

// // //         phonetf.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
// // //         phonetf.setForeground(new Color(102, 102, 102));
// // //         phonetf.setAlignmentX(Component.LEFT_ALIGNMENT);

// // //         addressLabel.setBackground(new Color(0,0,0));
// // //         addressLabel.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
// // //         addressLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
// // //         addressLabel.setBorder(BorderFactory.createEmptyBorder(15,0,10,0));

// // //         addresstf.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
// // //         addresstf.setForeground(new Color(102, 102, 102));
// // //         addresstf.setAlignmentX(Component.LEFT_ALIGNMENT);

// // //         passLabel.setBackground(new Color(0,0,0));
// // //         passLabel.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
// // //         passLabel.setText("Password");
// // //         passLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
// // //         passLabel.setBorder(BorderFactory.createEmptyBorder(15,0,10,0));


// // //         passtf.setForeground(new Color(102, 102, 102));
// // //         passtf.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
// // //         passtf.setAlignmentX(Component.LEFT_ALIGNMENT);

// // //         // separator1.setBorder(BorderFactory.createEmptyBorder(0,0,5,0));

// // //         // signUp.setForeground(new Color(72, 24, 101));
// // //         // signUp.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
// // //         // signUp.addActionListener(this);


// // //         // signIn.setAlignmentX(Component.LEFT_ALIGNMENT);

// // //         // rightBottom.setLayout(new FlowLayout(0));
// // //         // rightBottom.setBorder(BorderFactory.createEmptyBorder(0,20,20,0));
// // //         // rightBottom.setBackground(new Color(134, 244, 238));


// // //         // signIn.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
// // //         // signIn.setForeground(new Color(233, 28, 76));
// // //         // signIn.setText("SignIn");
// // //         // signIn.addActionListener(this);

// // //         right.add(rightH1);
// // //         // rightCenter.add(nameLabel);
// // //         // rightCenter.add(nametf);
// // //         // rightCenter.add(emailLabel);
// // //         // rightCenter.add(emailtf);
// // //         // rightCenter.add(bdLabel);
// // //         // rightCenter.add(bdCalender);
// // //         // rightCenter.add(phoneLabel);
// // //         // rightCenter.add(phonetf);
// // //         // rightCenter.add(addressLabel);
// // //         // rightCenter.add(addresstf);
// // //         // rightCenter.add(passLabel);
// // //         // rightCenter.add(passtf);
// // //         // rightCenter.add(separator1);
// // //         // rightCenter.add(signUp);
// // //         // rightCenter.add(separator2);
// // //         // rightBottom.add(signInLabel);
// // //         // rightBottom.add(signIn);
// // //         // right.add(rightCenter);
// // //         // right.add(rightBottom);

// // //         add(left);
// // //         add(right);
// // //     }



// // //     @Override
// // //     public void actionPerformed(ActionEvent e) {
// // //         // TODO Auto-generated method stub
// // //         throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
// // //     }
    
// // // }
// // import java.awt.*;
// // import java.awt.event.*;
// // import javax.swing.*;

// // public class UserPage extends JFrame implements ActionListener {
// //     private JPanel left, right, cardPanel;
// //     private JButton profileButton, fitnessButton, goalButton;
// //     private CardLayout cardLayout;

// //     public UserPage() {
// //         initComponents();
// //     }

// //     private void initComponents() {
// //         // Frame settings
// //         setTitle("User Page - KU Fitness Tracker");
// //         setSize(1280, 720);
// //         setMinimumSize(new Dimension(900, 600));
// //         setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
// //         setLayout(new BorderLayout());

// //         // Left Panel (Sidebar)
// //         left = new JPanel();
// //         left.setBackground(new Color(62, 8, 76));
// //         left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
// //         left.setPreferredSize(new Dimension(250, getHeight()));

// //         JLabel kuIcon = new JLabel(new ImageIcon("KU logo22.jpg"), SwingConstants.LEFT);
// //         kuIcon.setAlignmentX(Component.CENTER_ALIGNMENT);
// //         kuIcon.setBorder(BorderFactory.createEmptyBorder(30, 0, 20, 0));

// //         profileButton = createSidebarButton("My Profile");
// //         fitnessButton = createSidebarButton("Fitness Activity");
// //         goalButton = createSidebarButton("Goals");

// //         profileButton.setForeground(new Color(72, 24, 101));
// //         profileButton.setFont(new Font("Segoe UI", 1, 14));

// //         left.add(kuIcon);
// //         left.add(Box.createRigidArea(new Dimension(0, 20))); // Spacer
// //         left.add(profileButton);
// //         left.add(fitnessButton);
// //         left.add(goalButton);

// //         // Right Panel (Main Content Area)
// //         right = new JPanel();
// //         cardLayout = new CardLayout();
// //         cardPanel = new JPanel(cardLayout);

// //         // Adding sub-panels to cardPanel
// //         cardPanel.add(createProfilePanel(), "Profile");
// //         cardPanel.add(createFitnessPanel(), "Fitness");
// //         cardPanel.add(createGoalPanel(), "Goals");

// //         right.setLayout(new BorderLayout());
// //         right.add(cardPanel, BorderLayout.CENTER);

// //         // Adding panels to frame
// //         add(left, BorderLayout.WEST);
// //         add(right, BorderLayout.CENTER);

// //         setVisible(true);
// //     }

// //     private JButton createSidebarButton(String text) {
// //         JButton button = new JButton(text);
// //         button.setFont(new Font("Segoe UI", Font.BOLD, 14));
// //         button.setForeground(new Color(72, 24, 101));
// //         button.setAlignmentX(Component.CENTER_ALIGNMENT);
// //         button.addActionListener(this);
// //         button.setMaximumSize(new Dimension(200, 50));
// //         return button;
// //     }

// //     private JPanel createProfilePanel() {
// //         JPanel panel = new JPanel();
// //         panel.setBackground(new Color(134, 244, 238));
// //         panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

// //         JLabel title = new JLabel("My Profile", SwingConstants.CENTER);
// //         title.setFont(new Font("Segoe UI", Font.BOLD, 24));
// //         title.setForeground(new Color(62, 8, 76));
// //         title.setAlignmentX(Component.CENTER_ALIGNMENT);

// //         panel.add(Box.createRigidArea(new Dimension(0, 20)));
// //         panel.add(title);
// //         return panel;
// //     }

// //     private JPanel createFitnessPanel() {
// //         JPanel panel = new JPanel();
// //         panel.setBackground(new Color(204, 229, 255));
// //         panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

// //         JLabel title = new JLabel("Fitness Activity", SwingConstants.CENTER);
// //         title.setFont(new Font("Segoe UI", Font.BOLD, 24));
// //         title.setForeground(new Color(62, 8, 76));
// //         title.setAlignmentX(Component.CENTER_ALIGNMENT);

// //         panel.add(Box.createRigidArea(new Dimension(0, 20)));
// //         panel.add(title);
// //         return panel;
// //     }

// //     private JPanel createGoalPanel() {
// //         JPanel panel = new JPanel();
// //         panel.setBackground(new Color(204, 255, 204));
// //         panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

// //         JLabel title = new JLabel("Goals", SwingConstants.CENTER);
// //         title.setFont(new Font("Segoe UI", Font.BOLD, 24));
// //         title.setForeground(new Color(62, 8, 76));
// //         title.setAlignmentX(Component.CENTER_ALIGNMENT);

// //         panel.add(Box.createRigidArea(new Dimension(0, 20)));
// //         panel.add(title);
// //         return panel;
// //     }

// //     @Override
// //     public void actionPerformed(ActionEvent e) {
// //         if (e.getSource() == profileButton) {
// //             cardLayout.show(cardPanel, "Profile");
// //         } else if (e.getSource() == fitnessButton) {
// //             cardLayout.show(cardPanel, "Fitness");
// //         } else if (e.getSource() == goalButton) {
// //             cardLayout.show(cardPanel, "Goals");
// //         }
// //     }

// //     public static void main(String[] args) {
// //         new UserPage();
// //     }
// // }

// // import java.awt.*;
// // import java.awt.event.*;
// // import javax.swing.*;
// // import com.toedter.calendar.JDateChooser;

// // public class UserPage extends JFrame implements ActionListener {
// //     private JPanel left, right, cardPanel;
// //     private JButton profileButton, fitnessButton, goalButton;
// //     private CardLayout cardLayout;

// //     // Profile components
// //     private JTextField nametf, emailtf, phonetf, addresstf;
// //     private JDateChooser bdCalender;
// //     private JPasswordField passtf;
// //     private JButton editButton, saveButton;

// //     public UserPage() {
// //         initComponents();
// //     }

// //     private void initComponents() {
// //         // Frame settings
// //         setTitle("User Page - KU Fitness Tracker");
// //         setSize(1280, 720);
// //         setMinimumSize(new Dimension(900, 600));
// //         setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
// //         setLayout(new BorderLayout());

// //         // Left Panel (Sidebar)
// //         left = new JPanel();
// //         left.setBackground(new Color(62, 8, 76));
// //         left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
// //         left.setPreferredSize(new Dimension(250, getHeight()));

// //         JLabel kuIcon = new JLabel(new ImageIcon("KU logo22.jpg"), SwingConstants.LEFT);
// //         kuIcon.setAlignmentX(Component.CENTER_ALIGNMENT);
// //         kuIcon.setBorder(BorderFactory.createEmptyBorder(30, 0, 20, 0));

// //         profileButton = createSidebarButton("My Profile");
// //         fitnessButton = createSidebarButton("Fitness Activity");
// //         goalButton = createSidebarButton("Goals");

// //         left.add(kuIcon);
// //         left.add(Box.createRigidArea(new Dimension(0, 20))); // Spacer
// //         left.add(profileButton);
// //         left.add(fitnessButton);
// //         left.add(goalButton);

// //         // Right Panel (Main Content Area)
// //         right = new JPanel();
// //         cardLayout = new CardLayout();
// //         cardPanel = new JPanel(cardLayout);

// //         // Adding sub-panels to cardPanel
// //         cardPanel.add(createProfilePanel(), "Profile");
// //         cardPanel.add(createFitnessPanel(), "Fitness");
// //         cardPanel.add(createGoalPanel(), "Goals");

// //         right.setLayout(new BorderLayout());
// //         right.add(cardPanel, BorderLayout.CENTER);

// //         // Adding panels to frame
// //         add(left, BorderLayout.WEST);
// //         add(right, BorderLayout.CENTER);

// //         setVisible(true);
// //     }

// //     private JButton createSidebarButton(String text) {
// //         JButton button = new JButton(text);
// //         button.setFont(new Font("Segoe UI", Font.BOLD, 14));
// //         button.setForeground(new Color(72, 24, 101));
// //         button.setAlignmentX(Component.CENTER_ALIGNMENT);
// //         button.addActionListener(this);
// //         button.setMaximumSize(new Dimension(200, 50));
// //         return button;
// //     }

// //     private JPanel createProfilePanel() {
// //         JPanel panel = new JPanel();
// //         panel.setBackground(new Color(134, 244, 238));
// //         panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
// //         panel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

// //         JLabel title = new JLabel("My Profile", SwingConstants.CENTER);
// //         title.setFont(new Font("Segoe UI", Font.BOLD, 24));
// //         title.setForeground(new Color(62, 8, 76));
// //         title.setAlignmentX(Component.CENTER_ALIGNMENT);

// //         JLabel nameLabel = new JLabel("Full Name:");
// //         nametf = new JTextField(20);
// //         JLabel emailLabel = new JLabel("Email:");
// //         emailtf = new JTextField(20);
// //         JLabel bdLabel = new JLabel("Date of Birth:");
// //         bdCalender = new JDateChooser();
// //         JLabel phoneLabel = new JLabel("Phone Number:");
// //         phonetf = new JTextField(20);
// //         JLabel addressLabel = new JLabel("Address:");
// //         addresstf = new JTextField(20);
// //         JLabel passLabel = new JLabel("Password:");
// //         passtf = new JPasswordField(20);

// //         editButton = new JButton("Edit");
// //         saveButton = new JButton("Save");

// //         // Add components to the panel
// //         panel.add(title);
// //         panel.add(Box.createRigidArea(new Dimension(0, 20)));
// //         panel.add(nameLabel);
// //         panel.add(nametf);
// //         panel.add(emailLabel);
// //         panel.add(emailtf);
// //         panel.add(bdLabel);
// //         panel.add(bdCalender);
// //         panel.add(phoneLabel);
// //         panel.add(phonetf);
// //         panel.add(addressLabel);
// //         panel.add(addresstf);
// //         panel.add(passLabel);
// //         panel.add(passtf);
// //         panel.add(Box.createRigidArea(new Dimension(0, 10)));
// //         panel.add(editButton);
// //         panel.add(saveButton);

// //         return panel;
// //     }

// //     private JPanel createFitnessPanel() {
// //         JPanel panel = new JPanel();
// //         panel.setBackground(new Color(204, 229, 255));
// //         panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

// //         JLabel title = new JLabel("Fitness Activity", SwingConstants.CENTER);
// //         title.setFont(new Font("Segoe UI", Font.BOLD, 24));
// //         title.setForeground(new Color(62, 8, 76));
// //         title.setAlignmentX(Component.CENTER_ALIGNMENT);

// //         panel.add(Box.createRigidArea(new Dimension(0, 20)));
// //         panel.add(title);
// //         return panel;
// //     }

// //     private JPanel createGoalPanel() {
// //         JPanel panel = new JPanel();
// //         panel.setBackground(new Color(204, 255, 204));
// //         panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

// //         JLabel title = new JLabel("Goals", SwingConstants.CENTER);
// //         title.setFont(new Font("Segoe UI", Font.BOLD, 24));
// //         title.setForeground(new Color(62, 8, 76));
// //         title.setAlignmentX(Component.CENTER_ALIGNMENT);

// //         panel.add(Box.createRigidArea(new Dimension(0, 20)));
// //         panel.add(title);
// //         return panel;
// //     }

// //     @Override
// //     public void actionPerformed(ActionEvent e) {
// //         if (e.getSource() == profileButton) {
// //             cardLayout.show(cardPanel, "Profile");
// //         } else if (e.getSource() == fitnessButton) {
// //             cardLayout.show(cardPanel, "Fitness");
// //         } else if (e.getSource() == goalButton) {
// //             cardLayout.show(cardPanel, "Goals");
// //         }
// //     }

// //     public static void main(String[] args) {
// //         new UserPage();
// //     }
// // }

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import com.lgooddatepicker.components.TimePicker;
import com.lgooddatepicker.components.TimePickerSettings;
// 
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import java.util.Scanner;

import javax.swing.table.*;
import com.toedter.calendar.JDateChooser;


public class UserPage extends JFrame implements ActionListener {
    private JPanel left, right, cardPanel, leftNorth;
    private JButton profileButton, fitnessButton, goalButton, logoutButton;
    private CardLayout cardLayout;

    // Profile components
    private JTextField nametf, emailtf, phonetf, addresstf, idtf;
    private JPasswordField passtf;
    private JButton editButton, saveButton;

    // Simulated user object
    private User user;

    public UserPage() {
        user = (User) Main.users.get(Main.idx);
        initComponents();
    }

    private void initComponents() {
        // Frame settings
        setTitle("User Page - KU Fitness Tracker");
        setSize(1280, 720);
        setMinimumSize(new Dimension(900, 600));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Left Panel (Sidebar)
        left = new JPanel();
        left.setBackground(new Color(62, 8, 76));
        left.setLayout(new BorderLayout());
        left.setPreferredSize(new Dimension(250, getHeight()));

        leftNorth = new JPanel();
        leftNorth.setBackground(new Color(62, 8, 76));
        leftNorth.setPreferredSize(new Dimension(250, getHeight()));
        leftNorth.setLayout(new BoxLayout(leftNorth, BoxLayout.Y_AXIS));


        JLabel kuIcon = new JLabel(new ImageIcon("KU logo22.jpg"), SwingConstants.LEFT);
        kuIcon.setAlignmentX(Component.CENTER_ALIGNMENT);
        kuIcon.setBorder(BorderFactory.createEmptyBorder(30, 0, 20, 0));

        profileButton = createSidebarButton("My Profile");
        fitnessButton = createSidebarButton("Fitness Activity");
        goalButton = createSidebarButton("Goals");
        logoutButton = createSidebarButton("Logout");
        logoutButton.setMaximumSize(new Dimension(200, 30));
        logoutButton.setVisible(true);
        left.setBorder(BorderFactory.createEmptyBorder(0,20,20,20));



        leftNorth.add(kuIcon);
        leftNorth.add(Box.createRigidArea(new Dimension(0, 20))); // Spacer
        leftNorth.add(profileButton);
        leftNorth.add(fitnessButton);
        leftNorth.add(goalButton);
        left.add(leftNorth, BorderLayout.NORTH);
        left.add(logoutButton, BorderLayout.SOUTH);
        left.revalidate();
        left.repaint();

        // Right Panel (Main Content Area)
        right = new JPanel();
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Adding sub-panels to cardPanel
        cardPanel.add(createProfilePanel(), "Profile");
        cardPanel.add(createFitnessPanel(), "Fitness");
        cardPanel.add(createGoalPanel(), "Goals");

        right.setLayout(new BorderLayout());
        right.add(cardPanel, BorderLayout.CENTER);

        // Adding panels to frame
        add(left, BorderLayout.WEST);
        add(right, BorderLayout.CENTER);

        setVisible(true);
    }

    private JButton createSidebarButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setForeground(new Color(255, 255, 255));
        button.setBackground(null);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.addActionListener(this);
        button.setMaximumSize(new Dimension(200, 50));
        return button;
    }

    private JPanel createProfilePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(134, 244, 238));
        panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
    
        JLabel title = new JLabel("My Profile", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 24));
        title.setForeground(new Color(62, 8, 76));
        title.setBorder(BorderFactory.createEmptyBorder(0,0,20,0));
        panel.add(title, BorderLayout.NORTH);

        
        // Profile Details Section
        JPanel detailsPanel = new JPanel(new GridLayout(3, 2, 10, 10)); // Adjust grid layout as needed
        detailsPanel.setBackground(new Color(134, 244, 238));
    
        idtf = createTextField(user.getId(), "User Id");
        nametf = createTextField(user.getName(), "Full Name");
        emailtf = createTextField(user.getEmail(), "Email");
        phonetf = createTextField(user.getPhoneNumber(), "Phone Number");
        addresstf = createTextField(user.getAddress(), "Address");
        passtf = new JPasswordField(user.getPassword());
        passtf.setBorder(BorderFactory.createTitledBorder("Password"));
        passtf.setEditable(false);
    
        JTextField progressField = new JTextField("Calories Burned: " + user.getTotalCaloriesBurned());
        progressField.setBorder(BorderFactory.createTitledBorder("Progress"));
        progressField.setEditable(false);
    
        detailsPanel.add(idtf);
        detailsPanel.add(nametf);
        detailsPanel.add(emailtf);
        detailsPanel.add(phonetf);
        detailsPanel.add(addresstf);
        detailsPanel.add(passtf);

        // detailsPanel.add(progressField);

        // Buttons Panel with FlowLayout
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        editButton = new JButton("Edit");
        editButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        editButton.setForeground(new Color(62, 8, 76));
        editButton.addActionListener(this);
        editButton.setMaximumSize(new Dimension(100, 40));
        saveButton = new JButton("Save");
        saveButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        saveButton.setForeground(new Color(62, 8, 76));
        saveButton.addActionListener(this);
        saveButton.setMaximumSize(new Dimension(100, 40));
        saveButton.setEnabled(false);
    
        // Button actions
        editButton.addActionListener(e -> enableEditing(true));
        saveButton.addActionListener(e -> saveChanges());
    
        buttonPanel.add(editButton);
        buttonPanel.add(saveButton);
    
        // Button Section
        JButton printReportButton = new JButton("Print Progress Report");
        printReportButton.addActionListener(e -> user.generateProgressReport());
        buttonPanel.add(printReportButton);
    
        panel.add(title, BorderLayout.NORTH);
        panel.add(detailsPanel, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);
    
        return panel;
    }
    
//     // private JPanel createProfilePanel() {
//     //     JPanel panel = new JPanel();
//     //     panel.setLayout(new BorderLayout());
//     //     panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

    
//     //     // Title Label
//     //     JLabel title = new JLabel("My Profile", SwingConstants.CENTER);
//     //     title.setFont(new Font("Segoe UI", Font.BOLD, 24));
//     //     title.setForeground(new Color(62, 8, 76));
//     //     title.setBorder(BorderFactory.createEmptyBorder(0,0,20,0));
//     //     panel.add(title, BorderLayout.NORTH);
    
//     //     // Text Fields Panel with GridLayout
//     //     JPanel textFieldPanel = new JPanel(new GridLayout(3, 2, 10, 10));
//     //     nametf = createTextField(user.getName(), "Full Name");
//     //     emailtf = createTextField(user.getEmail(), "Email");
//     //     phonetf = createTextField(user.getPhone(), "Phone Number");
//     //     addresstf = createTextField(user.getAddress(), "Address");
//     //     passtf = new JPasswordField(user.getPassword());
//     //     passtf.setBorder(BorderFactory.createTitledBorder("Password"));
//     //     passtf.setEditable(false);
    
//     //     textFieldPanel.add(nametf);
//     //     textFieldPanel.add(emailtf);
//     //     textFieldPanel.add(phonetf);
//     //     textFieldPanel.add(addresstf);
//     //     textFieldPanel.add(passtf);
    
//     //     // Buttons Panel with FlowLayout
//     //     JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
//     //     editButton = new JButton("Edit");
//     //     saveButton = new JButton("Save");
//     //     saveButton.setEnabled(false);
    
//     //     // Button actions
//     //     editButton.addActionListener(e -> enableEditing(true));
//     //     saveButton.addActionListener(e -> saveChanges());
    
//     //     buttonPanel.add(editButton);
//     //     buttonPanel.add(saveButton);
    
//     //     // Add components to Profile Panel
//     //     panel.add(textFieldPanel, BorderLayout.CENTER);
//     //     panel.add(buttonPanel, BorderLayout.SOUTH);
    
//     //     return panel;
//     // }
    

    private JTextField createTextField(String text, String placeholder) {
        JTextField textField = new JTextField(text);
        textField.setBorder(BorderFactory.createTitledBorder(placeholder));
        textField.setEditable(false);
        return textField;
    }

    private void enableEditing(boolean editable) {
        nametf.setEditable(editable);
        emailtf.setEditable(editable);
        phonetf.setEditable(editable);
        addresstf.setEditable(editable);
        passtf.setEditable(editable);

        editButton.setEnabled(!editable);
        saveButton.setEnabled(editable);
    }

    private void saveChanges() {
        // Save updated info to the user object
        user.setName(nametf.getText());
        user.setEmail(emailtf.getText());
        user.setPhone(phonetf.getText());
        user.setAddress(addresstf.getText());
        user.setPassword(new String(passtf.getPassword()));

        // Disable editing
        enableEditing(false);

        JOptionPane.showMessageDialog(this, "Profile updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    private JPanel createFitnessPanel() {
        // JPanel panel = new JPanel();
        // panel.setBackground(new Color(204, 229, 255));
        // panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // JLabel title = new JLabel("Fitness Activity", SwingConstants.CENTER);
        // title.setFont(new Font("Segoe UI", Font.BOLD, 24));
        // title.setForeground(new Color(62, 8, 76));
        // title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(204, 229, 255));
        panel.setBorder(BorderFactory.createEmptyBorder(0,20,20,20));

    
        JLabel title = new JLabel("Fitness Activity", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 24));
        title.setForeground(new Color(62, 8, 76));
        title.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        
        // Table for displaying activities
        String[] columnNames = {"Name", "Duration", "Calories Burned", "Date", "Time"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable activityTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(activityTable);
    
        // Buttons for managing activities
        JButton addButton = new JButton("Add Activity");
        JButton editButton = new JButton("Edit Activity");
        JButton deleteButton = new JButton("Delete Activity");
    
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
    
        // Add Action Listeners for buttons
        addButton.addActionListener(e -> addActivity(tableModel));
        editButton.addActionListener(e -> editActivity(activityTable, tableModel));
        deleteButton.addActionListener(e -> deleteActivity(activityTable, tableModel));
    
        // Add components to the panel
        panel.add(title, BorderLayout.NORTH);
        panel.add(tableScrollPane, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);
    
        return panel;
    }
    
    // Add Activity
    private void addActivity(DefaultTableModel tableModel) {
        JTextField nameField = new JTextField();
        JTextField durationField = new JTextField();
        JTextField caloriesField = new JTextField();
        JDateChooser dateField = new JDateChooser(); // Format: "yyyy-MM-dd"
        JTextField timeField = new JTextField(); // Format: "hh:mm AM/PM"
        
        int day, month, year;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateField.getDate());
        day = calendar.get(Calendar.DAY_OF_MONTH);
        month = calendar.get(Calendar.MONTH) + 1; // Months are 0-based in Calendar
        year = calendar.get(Calendar.YEAR);

        Object[] message = {
            "Name:", nameField,
            "Duration (hh mm ss):", durationField,
            "Calories Burned:", caloriesField,
            "Date:", dateField,
            "Time (hh:mm AM/PM):", timeField
        };
    
        int option = JOptionPane.showConfirmDialog(this, message, "Add New Activity", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try {
                String name = nameField.getText();
                Scanner cin = new Scanner(durationField.getText());
                int hours, minutes, seconds;
                hours = cin.nextInt();
                minutes = cin.nextInt();
                seconds = cin.nextInt();
                Time duration = new Time(hours,minutes,seconds);
                int calories = Integer.parseInt(caloriesField.getText());
                Date date = new Date(day, month, year);
                String time = timeField.getText();
    
                Activity activity = new Activity(name, duration, calories, date, time);
                tableModel.addRow(new Object[]{activity.getName(), activity.getDuration(), activity.getCaloriesBurned(),
                                                new SimpleDateFormat("yyyy-MM-dd").format(activity.getActivityDate()), activity.getTime()});
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid input! Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    // Edit Activity
    private void editActivity(JTable activityTable, DefaultTableModel tableModel) {
        int selectedRow = activityTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "No activity selected!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    
        String name = (String) tableModel.getValueAt(selectedRow, 0);
        String duration = (String) tableModel.getValueAt(selectedRow, 1);
        String calories = tableModel.getValueAt(selectedRow, 2).toString();
        String date = (String) tableModel.getValueAt(selectedRow, 3);
        String time = (String) tableModel.getValueAt(selectedRow, 4);
    
        JTextField nameField = new JTextField(name);
        JTextField durationField = new JTextField(duration);
        JTextField caloriesField = new JTextField(calories);
        JDateChooser dateField = new JDateChooser();
        JTextField timeField = new JTextField(time);
    
        Object[] message = {
            "Name:", nameField,
            "Duration:", durationField,
            "Calories Burned:", caloriesField,
            "Date:", dateField,
            "Time:", timeField
        };
    
        int option = JOptionPane.showConfirmDialog(this, message, "Edit Activity", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try {
                tableModel.setValueAt(nameField.getText(), selectedRow, 0);
                tableModel.setValueAt(durationField.getText(), selectedRow, 1);
                tableModel.setValueAt(Integer.parseInt(caloriesField.getText()), selectedRow, 2);
                tableModel.setValueAt(dateField.getDate(), selectedRow, 3);
                tableModel.setValueAt(timeField.getText(), selectedRow, 4);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid input! Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    // Delete Activity
    private void deleteActivity(JTable activityTable, DefaultTableModel tableModel) {
        int selectedRow = activityTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "No activity selected!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        tableModel.removeRow(selectedRow);
    }

    private JPanel createGoalPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(204, 255, 204));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Goals", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 24));
        title.setForeground(new Color(62, 8, 76));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(title);
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        profileButton.setBackground(null);
        fitnessButton.setBackground(null);
        goalButton.setBackground(null);

        if (e.getSource() == profileButton) {
            cardLayout.show(cardPanel, "Profile");
            profileButton.setBackground(Color.CYAN);
            profileButton.setForeground(new Color(62, 8, 76));
            goalButton.setForeground(new Color(255, 255, 255));
            fitnessButton.setForeground(new Color(255, 255,255));
        } else if (e.getSource() == fitnessButton) {
            cardLayout.show(cardPanel, "Fitness");
            fitnessButton.setBackground(Color.CYAN);
            profileButton.setForeground(new Color(255, 255, 255));
            fitnessButton.setForeground(new Color(62, 8, 76));
            goalButton.setForeground(new Color(255, 255, 255));


        } else if (e.getSource() == goalButton) {
            cardLayout.show(cardPanel, "Goals");
            goalButton.setBackground(Color.CYAN);
            goalButton.setForeground(new Color(62, 8, 76));
            profileButton.setForeground(new Color(255, 255, 255));
            fitnessButton.setForeground(new Color(255, 255,255));
        }

        else if (e.getSource() == logoutButton) {
            int choice = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to log out?",
                "Logout Confirmation",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
            );
        
            if (choice == JOptionPane.YES_OPTION) {
                // Proceed to logout
                SignIn SignInFrame = new SignIn();
                SignInFrame.setVisible(true);
                SignInFrame.pack();
                SignInFrame.setLocationRelativeTo(null); 
                this.dispose();
            }
            // If NO is selected, do nothing and return to the current frame
        }
    }
}
