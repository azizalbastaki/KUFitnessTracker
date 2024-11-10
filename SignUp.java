import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.*;


public class SignUp extends JFrame implements ActionListener {
    private JPanel left, right, rightCenter, rightBottom;
    private JButton signIn, signUp;
    private JLabel kuicon, leftH1, copyright, rightH1, nameLabel, emailLabel, passLabel, signInLabel, separator1, separator2;
    private JTextField nametf, emailtf;
    private JPasswordField passtf;
    private int idx;

    // Class constructor
    public SignUp() {
        initComponents();
    }

    private void initComponents() {
        // left SubPanel
        left = new JPanel();
        kuicon = new JLabel("", SwingConstants.CENTER);
        leftH1 = new JLabel("KU Fitness Tracker", SwingConstants.CENTER);
        copyright = new JLabel("copyright © KU Fitness Tracker. All rights reserved", SwingConstants.CENTER);
        // Right SubPanel
        right = new JPanel();
        rightCenter = new JPanel();
        rightBottom = new JPanel();

        rightH1 = new JLabel("Sign Up", SwingConstants.CENTER);
        nameLabel = new JLabel("Full Name", SwingConstants.LEFT);
        nametf = new JTextField();
        emailLabel = new JLabel("Email", SwingConstants.LEFT);
        emailtf = new JTextField();
        passLabel = new JLabel("Password", SwingConstants.LEFT);
        passtf = new JPasswordField();
        signUp = new JButton(" Sign Up  ");
        signInLabel = new JLabel("You have an account?    ", SwingConstants.LEFT);
        signIn = new JButton();
        separator1 = new JLabel("   "); // just a separator
        separator2 = new JLabel("   "); // just a separator

        // default settings for the main frame
        setTitle("Sign Up");
        setLayout(new GridLayout(1,2));
        setVisible(true);
        setMinimumSize(new Dimension(600, 400));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // left SubPanel 
        left.setBackground(new Color(62, 8, 76));
        left.setLayout(new BorderLayout());

        kuicon.setIcon(new ImageIcon("KU logo.png"));
        kuicon.setAlignmentX(Component.CENTER_ALIGNMENT);
        kuicon.setBorder(BorderFactory.createEmptyBorder(20,0,-20,0));

        
        leftH1.setFont(new Font("Montserrat", 1, 24)); 
        leftH1.setForeground(new Color(255, 255, 255));
        leftH1.setBorder(BorderFactory.createEmptyBorder(-145,0,0,0));
        // leftH1.setAlignmentX(Component.CENTER_ALIGNMENT);

        copyright.setFont(new Font("Lato", 0, 14)); 
        copyright.setForeground(new Color(204, 204, 204));
        copyright.setBorder(BorderFactory.createEmptyBorder(0,20,30,20));
        copyright.setAlignmentX(Component.CENTER_ALIGNMENT);

        left.add(kuicon, BorderLayout.NORTH);
        left.add(leftH1, BorderLayout.CENTER);
        left.add(copyright, BorderLayout.SOUTH);

        // right SubPanel
        right.setMinimumSize(new Dimension(400, 250));
        right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
        right.setBackground(new Color(134, 244, 238));
        rightCenter.setLayout(new BoxLayout(rightCenter, BoxLayout.Y_AXIS));
        rightCenter.setBackground(new Color(134, 244, 238));


        rightH1.setFont(new Font("Segoe UI", 1, 36)); // NOI18N
        rightH1.setForeground(new Color(62, 8, 76));
        rightH1.setAlignmentX(Component.CENTER_ALIGNMENT);
        rightH1.setBorder(BorderFactory.createEmptyBorder(30,0,30,0));

        rightCenter.setAlignmentX(Component.CENTER_ALIGNMENT);
        rightCenter.setBorder(BorderFactory.createEmptyBorder(0,20,25,20));

        nameLabel.setBackground(new Color(0,0,0));
        nameLabel.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
        nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        nameLabel.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));

        nametf.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        nametf.setForeground(new Color(102, 102, 102));
        nametf.setAlignmentX(Component.LEFT_ALIGNMENT);

        emailLabel.setBackground(new Color(0,0,0));
        emailLabel.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
        emailLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        emailLabel.setBorder(BorderFactory.createEmptyBorder(15,0,10,0));

        emailtf.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        emailtf.setForeground(new Color(102, 102, 102));
        emailtf.setAlignmentX(Component.LEFT_ALIGNMENT);


        passLabel.setBackground(new Color(0,0,0));
        passLabel.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
        passLabel.setText("Password");
        passLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        passLabel.setBorder(BorderFactory.createEmptyBorder(15,0,10,0));


        passtf.setForeground(new Color(102, 102, 102));
        passtf.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        passtf.setAlignmentX(Component.LEFT_ALIGNMENT);

        // separator1.setBorder(BorderFactory.createEmptyBorder(0,0,5,0));

        signUp.setForeground(new Color(72, 24, 101));
        signUp.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        signUp.addActionListener(this);


        // signIn.setAlignmentX(Component.LEFT_ALIGNMENT);

        rightBottom.setLayout(new FlowLayout(0));
        rightBottom.setBorder(BorderFactory.createEmptyBorder(0,20,20,0));
        rightBottom.setBackground(new Color(134, 244, 238));


        signIn.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        signIn.setForeground(new Color(233, 28, 76));
        signIn.setText("SignIn");
        signIn.addActionListener(this);

        right.add(rightH1);
        rightCenter.add(nameLabel);
        rightCenter.add(nametf);
        rightCenter.add(emailLabel);
        rightCenter.add(emailtf);
        rightCenter.add(passLabel);
        rightCenter.add(passtf);
        rightCenter.add(separator1);
        rightCenter.add(signUp);
        rightCenter.add(separator2);
        rightBottom.add(signInLabel);
        rightBottom.add(signIn);
        right.add(rightCenter);
        right.add(rightBottom);

        add(left);
        add(right);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == signIn){
            SignIn SignInFrame = new SignIn();
            SignInFrame.setVisible(true);
            SignInFrame.pack();
            SignInFrame.setLocationRelativeTo(null); 
            this.dispose();
        }

        if(e.getSource() == signUp){
            for(String email: Main.getEmails()){
                if(emailtf.getText().equals(email)){
                    JOptionPane.showMessageDialog(null, "Email already exists!", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }    
            JOptionPane.showMessageDialog(null, "Invalid email or password!", "Error", JOptionPane.ERROR_MESSAGE);
        }
            
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}