// // import javax.swing.*;
// // import javax.swing.table.DefaultTableModel;
// // import java.awt.event.*;

// // public class AdminPage extends JFrame {
// //     private JTable activityTable;
// //     private JTable userTable;
// //     private DefaultTableModel activityTableModel;
// //     private DefaultTableModel userTableModel;

// //     public AdminPage() {
// //         // Setting up JFrame
// //         setTitle("Admin Dashboard");
// //         setSize(800, 600);
// //         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// //         setLayout(null);

// //         // Tabbed Pane for Activities and Users
// //         JTabbedPane tabbedPane = new JTabbedPane();
// //         tabbedPane.setBounds(10, 10, 760, 500);

// //         // Activity Management Tab
// //         JPanel activityPanel = new JPanel();
// //         activityPanel.setLayout(null);

// //         // User Management Tab
// //         JPanel userPanel = new JPanel();
// //         userPanel.setLayout(null);

// //         // Add Tabs to TabbedPane
// //         tabbedPane.addTab("Activity Management", activityPanel);
// //         tabbedPane.addTab("User Management", userPanel);
// //         add(tabbedPane);

// //         // Activity Table
// //         String[] activityColumns = {"Activity Name", "User", "Status", "Action"};
// //         activityTableModel = new DefaultTableModel(activityColumns, 0);
// //         activityTable = new JTable(activityTableModel);
// //         JScrollPane activityScrollPane = new JScrollPane(activityTable);
// //         activityScrollPane.setBounds(10, 10, 730, 300);
// //         activityPanel.add(activityScrollPane);

// //         // User Table
// //         String[] userColumns = {"Name", "Activity Count", "Goals"};
// //         userTableModel = new DefaultTableModel(userColumns, 0);
// //         userTable = new JTable(userTableModel);
// //         JScrollPane userScrollPane = new JScrollPane(userTable);
// //         userScrollPane.setBounds(10, 10, 730, 300);
// //         userPanel.add(userScrollPane);

// //         // Load Data Buttons
// //         JButton loadActivitiesBtn = new JButton("Load Activities");
// //         loadActivitiesBtn.setBounds(10, 320, 150, 30);
// //         activityPanel.add(loadActivitiesBtn);

// //         JButton loadUsersBtn = new JButton("Load Users");
// //         loadUsersBtn.setBounds(10, 320, 150, 30);
// //         userPanel.add(loadUsersBtn);

// //         // Action Buttons
// //         JButton approveActivityBtn = new JButton("Approve");
// //         approveActivityBtn.setBounds(180, 320, 100, 30);
// //         activityPanel.add(approveActivityBtn);

// //         JButton rejectActivityBtn = new JButton("Reject");
// //         rejectActivityBtn.setBounds(300, 320, 100, 30);
// //         activityPanel.add(rejectActivityBtn);

// //         JButton addUserBtn = new JButton("Add User");
// //         addUserBtn.setBounds(180, 320, 100, 30);
// //         userPanel.add(addUserBtn);

// //         JButton editUserBtn = new JButton("Edit User");
// //         editUserBtn.setBounds(300, 320, 100, 30);
// //         userPanel.add(editUserBtn);

// //         JButton deleteUserBtn = new JButton("Delete User");
// //         deleteUserBtn.setBounds(420, 320, 100, 30);
// //         userPanel.add(deleteUserBtn);

// //         // Search Field and Button
// //         JTextField searchField = new JTextField();
// //         searchField.setBounds(10, 360, 200, 30);
// //         activityPanel.add(searchField);

// //         JButton searchBtn = new JButton("Search");
// //         searchBtn.setBounds(220, 360, 100, 30);
// //         activityPanel.add(searchBtn);

// //         // Event Listeners
// //         loadActivitiesBtn.addActionListener(e -> loadActivities());
// //         loadUsersBtn.addActionListener(e -> loadUsers());
// //         approveActivityBtn.addActionListener(e -> approveActivity());
// //         rejectActivityBtn.addActionListener(e -> rejectActivity());
// //         addUserBtn.addActionListener(e -> addUser());
// //         editUserBtn.addActionListener(e -> editUser());
// //         deleteUserBtn.addActionListener(e -> deleteUser());
// //         searchBtn.addActionListener(e -> searchActivity(searchField.getText()));

// //         setVisible(true);
// //     }

// //     private void loadActivities() {
// //         // Clear existing rows
// //         activityTableModel.setRowCount(0);

// //         // Load activities from the user list
// //         Main.getUsers().forEach(user -> {
// //             ((User) user).getActivities().forEach(activity -> {
// //                 activityTableModel.addRow(new Object[]{
// //                     activity.getName(),
// //                     user.getName(),
// //                     activity.getStatus(),
// //                     "Pending" // Example status
// //                 });
// //             });
// //         });
// //     }

// //     private void loadUsers() {
// //         // Clear existing rows
// //         userTableModel.setRowCount(0);

// //         // Load users from the list
// //         Main.getUsers().forEach(user -> {
// //             userTableModel.addRow(new Object[]{
// //                 user.getName(),
// //                 ((User) user).getActivities().size(),
// //                 "Example Goal" // Placeholder for goals
// //             });
// //         });
// //     }

// //     private void approveActivity() {
// //         int selectedRow = activityTable.getSelectedRow();
// //         if (selectedRow != -1) {
// //             activityTableModel.setValueAt("Approved", selectedRow, 2);
// //         }
// //     }

// //     private void rejectActivity() {
// //         int selectedRow = activityTable.getSelectedRow();
// //         if (selectedRow != -1) {
// //             activityTableModel.setValueAt("Rejected", selectedRow, 2);
// //         }
// //     }

// //     private void addUser() {
// //         // Logic for adding a user (e.g., show a dialog to input user details)
// //         JOptionPane.showMessageDialog(this, "Add User functionality to be implemented.");
// //     }

// //     private void editUser() {
// //         // Logic for editing a user
// //         JOptionPane.showMessageDialog(this, "Edit User functionality to be implemented.");
// //     }

// //     private void deleteUser() {
// //         int selectedRow = userTable.getSelectedRow();
// //         if (selectedRow != -1) {
// //             userTableModel.removeRow(selectedRow);
// //         }
// //     }

// //     private void searchActivity(String query) {
// //         for (int i = 0; i < activityTableModel.getRowCount(); i++) {
// //             String activityName = (String) activityTableModel.getValueAt(i, 0);
// //             if (activityName.contains(query)) {
// //                 activityTable.setRowSelectionInterval(i, i);
// //                 break;
// //             }
// //         }
// //     }

// //     public static void main(String[] args) {
// //         new AdminPage();
// //     }
// // }

// import javax.swing.*;
// import javax.swing.table.DefaultTableModel;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;

// public class AdminPage extends JFrame {
//     private JTable activitiesTable;
//     private DefaultTableModel tableModel;
//     private JButton approveButton;
//     private JButton rejectButton;
//     private JButton manageUsersButton;
//     private JButton logoutButton;

//     public AdminPage() {
//         setTitle("Admin Dashboard");
//         setSize(800, 600);
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         setLayout(null);

//         JLabel titleLabel = new JLabel("Welcome, Admin");
//         titleLabel.setBounds(20, 20, 200, 25);
//         add(titleLabel);

//         // Table for Activities
//         String[] columns = {"Activity Name", "User", "Status"};
//         tableModel = new DefaultTableModel(columns, 0);
//         activitiesTable = new JTable(tableModel);
//         JScrollPane scrollPane = new JScrollPane(activitiesTable);
//         scrollPane.setBounds(20, 60, 740, 300);
//         add(scrollPane);

//         // Populate the table with user-submitted activities
//         Main.getUsers().forEach(user -> {
//             ((User)user).getActivities().forEach(activity -> {
//                 tableModel.addRow(new Object[]{activity.getName(), user.getName(), activity.getStatus()});
//             });
//         });

//         // Approve Button
//         approveButton = new JButton("Approve");
//         approveButton.setBounds(20, 380, 120, 30);
//         add(approveButton);

//         // Reject Button
//         rejectButton = new JButton("Reject");
//         rejectButton.setBounds(160, 380, 120, 30);
//         add(rejectButton);

//         // Manage Users Button
//         manageUsersButton = new JButton("Manage Users");
//         manageUsersButton.setBounds(300, 380, 150, 30);
//         add(manageUsersButton);

//         // Logout Button
//         logoutButton = new JButton("Logout");
//         logoutButton.setBounds(640, 380, 120, 30);
//         add(logoutButton);

//         // Button Actions
//         approveButton.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 handleApproval();
//             }
//         });

//         rejectButton.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 handleRejection();
//             }
//         });

//         logoutButton.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 JOptionPane.showMessageDialog(null, "Logged out successfully!");
//                 new SignIn(); // Redirect back to SignIn page
//                 dispose();
//             }
//         });

//         setVisible(true);
//     }

//     private void handleApproval() {
//         int selectedRow = activitiesTable.getSelectedRow();
//         if (selectedRow != -1) {
//             String activityName = (String) tableModel.getValueAt(selectedRow, 0);
//             tableModel.setValueAt("Approved", selectedRow, 2);
//             JOptionPane.showMessageDialog(this, "Activity '" + activityName + "' approved!");
//         } else {
//             JOptionPane.showMessageDialog(this, "Please select an activity to approve.");
//         }
//     }

//     private void handleRejection() {
//         int selectedRow = activitiesTable.getSelectedRow();
//         if (selectedRow != -1) {
//             String activityName = (String) tableModel.getValueAt(selectedRow, 0);
//             tableModel.setValueAt("Rejected", selectedRow, 2);
//             JOptionPane.showMessageDialog(this, "Activity '" + activityName + "' rejected!");
//         } else {
//             JOptionPane.showMessageDialog(this, "Please select an activity to reject.");
//         }
//     }

//     public static void main(String[] args) {
//         new AdminPage();
//     }
// }
