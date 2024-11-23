import java.io.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.*;

public class SignInx extends JFrame implements ActionListener{
    // Class variables
    private JPanel Right, Left, jPanel1;
    private JButton jButton1, jButton2;
    private JLabel jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7;
    private JTextField jTextField1, jTextField2;
    // End of class variables
    
    // Class constructor
    public SignInx() {
        initComponents();
    }

    private void initComponents() {
        // Main Panel
        jPanel1 = new JPanel();
        // Left SubPanel
        Left = new JPanel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        // Right SubPanel
        Right = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jTextField1 = new JTextField();
        jLabel3 = new JLabel();
        jTextField2 = new JTextField();
        jButton1 = new JButton();
        jLabel4 = new JLabel();
        jButton2 = new JButton();

        // Default Settings
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("SignIn");
        setSize(600,300);
        setLayout(null);
        setResizable(false);

        // JPanel 1
        jPanel1.setSize(600, 300);
        jPanel1.setLayout(new GridLayout(1,2));

        Left.setBackground(new Color(62, 8, 76));
        Left.setSize(300, 300);
        Left.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        jLabel5.setIcon(new ImageIcon("KU logo.png")); 

        jLabel6.setFont(new Font("Montserrat", 1, 24)); 
        jLabel6.setForeground(new Color(255, 255, 255));
        jLabel6.setText("KU Fitness Tracker");

        jLabel7.setFont(new Font("Lato", 0, 14)); 
        jLabel7.setForeground(new Color(204, 204, 204));
        jLabel7.setText("copyright © KU Fitness Tracker. All Lefts reserved");
        jLabel7.setBorder(BorderFactory.createEmptyBorder(100,0,0,0));
        Left.add(jLabel5);
        Left.add(jLabel6);
        Left.add(jLabel7);

        jPanel1.add(Left);

        Right.setBackground(new java.awt.Color(255, 255, 255));
        Right.setMinimumSize(new java.awt.Dimension(400, 400));

        jLabel1.setFont(new Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new Color(0, 102, 102));
        jLabel1.setText("SignIn");

        jLabel2.setBackground(new Color(102, 102, 102));
        jLabel2.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Email");

        jTextField1.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        jTextField1.setForeground(new Color(102, 102, 102));

        jLabel3.setBackground(new Color(102, 102, 102));
        jLabel3.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Password");

        jButton1.setBackground(new Color(0, 102, 102));
        jButton1.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setForeground(new Color(255, 255, 255));
        jButton1.setText("SignIn");

        jLabel4.setText("I don't have an account");

        jButton2.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        jButton2.setForeground(new Color(255, 51, 51));
        jButton2.setText("Sign Up");
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        // GroupLayout RightLayout = new GroupLayout(Right);
        // Right.setLayout(RightLayout);
        // RightLayout.setHorizontalGroup(
        //     RightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
        //     .addGroup(RightLayout.createSequentialGroup()
        //         .addGroup(RightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
        //             .addGroup(RightLayout.createSequentialGroup()
        //                 .addGap(138, 138, 138)
        //                 .addComponent(jLabel1))
        //             .addGroup(RightLayout.createSequentialGroup()
        //                 .addGap(30, 30, 30)
        //                 .addGroup(RightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
        //                     .addGroup(RightLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
        //                         .addComponent(jLabel2)
        //                         .addComponent(jTextField1)
        //                         .addComponent(jLabel3)
        //                         .addComponent(jTextField2, GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
        //                         .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
        //                     .addGroup(RightLayout.createSequentialGroup()
        //                         .addComponent(jLabel4)
        //                         .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
        //                         .addComponent(jButton2)))))
        //         .addContainerGap(27, Short.MAX_VALUE))
        // );
        // RightLayout.setVerticalGroup(
        //     RightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
        //     .addGroup(RightLayout.createSequentialGroup()
        //         .addGap(51, 51, 51)
        //         .addComponent(jLabel1)
        //         .addGap(40, 40, 40)
        //         .addComponent(jLabel2)
        //         .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
        //         .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        //         .addGap(18, 18, 18)
        //         .addComponent(jLabel3)
        //         .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
        //         .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        //         .addGap(26, 26, 26)
        //         .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
        //         .addGap(33, 33, 33)
        //         .addGroup(RightLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        //             .addComponent(jLabel4)
        //             .addComponent(jButton2))
        //         .addContainerGap(77, Short.MAX_VALUE))
        // );

        jPanel1.add(Right);
        Right.setBounds(400, 0, 300, 300);

        add(jPanel1);
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        SignUpx SignUpFrame = new SignUpx();
        SignUpFrame.setVisible(true);
        SignUpFrame.pack();
        SignUpFrame.setLocationRelativeTo(null); 
        this.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
