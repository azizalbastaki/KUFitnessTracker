import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class AdminPage extends JFrame implements ActionListener {
    private JPanel leftPanel, rightPanel, cardPanel;
    private JButton activityButton, userButton, logoutButton;
    private CardLayout cardLayout;
    private List<User> userList = new ArrayList<>(); // To store User objects

    public AdminPage() {
        initComponents();
    }

    private void initComponents() {
        // Frame settings
        setTitle("Admin Page - KU Fitness Tracker");
        setSize(1280, 720);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Left Sidebar
        setupSidebar();

        // Right Panel with Card Layout
        setupCardPanel();

        // Add Panels to Frame
        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private void setupSidebar() {
        leftPanel = new JPanel(new BorderLayout());
        leftPanel.setBackground(new Color(62, 8, 76));
        leftPanel.setPreferredSize(new Dimension(250, getHeight()));

        // Sidebar Buttons Panel
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));
        buttonsPanel.setBackground(new Color(62, 8, 76));

        JLabel kuLogo = new JLabel(new ImageIcon("KU logo22.jpg"));
        kuLogo.setAlignmentX(Component.CENTER_ALIGNMENT);
        kuLogo.setBorder(BorderFactory.createEmptyBorder(30, 0, 20, 0));

        activityButton = createSidebarButton("Activity Management");
        userButton = createSidebarButton("User Management");
        logoutButton = createSidebarButton("Logout");

        buttonsPanel.add(kuLogo);
        buttonsPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        buttonsPanel.add(activityButton);
        buttonsPanel.add(userButton);
        buttonsPanel.add(Box.createVerticalGlue());

        leftPanel.add(buttonsPanel, BorderLayout.NORTH);
        leftPanel.add(logoutButton, BorderLayout.SOUTH);
    }

    private void setupCardPanel() {
        rightPanel = new JPanel(new BorderLayout());
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Add panels for different sections
        cardPanel.add(createActivityPanel(), "Activity");
        cardPanel.add(createUserPanel(), "User");

        rightPanel.add(cardPanel, BorderLayout.CENTER);
    }

    private JButton createSidebarButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setForeground(Color.WHITE);
        button.setBackground(null);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.addActionListener(this);
        button.setMaximumSize(new Dimension(200, 50));
        return button;
    }

    private JPanel createActivityPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        // Title Label
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel title = new JLabel("Activity Management");
        title.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titlePanel.add(title);

        // Table for activities
        String[] columnNames = {"Activity Name", "User", "Status"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable activityTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(activityTable);

        // Buttons Panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        JButton addActivityButton = new JButton("Add Activity");
        JButton editActivityButton = new JButton("Edit Activity");
        JButton deleteActivityButton = new JButton("Delete Activity");

        // Add Activity Logic
        addActivityButton.addActionListener(e -> {
            JTextField activityNameField = new JTextField();
            JTextField userField = new JTextField();
            JComboBox<String> statusComboBox = new JComboBox<>(new String[]{"Pending", "Approved", "Rejected"});

            Object[] message = {
                "Activity Name:", activityNameField,
                "User:", userField,
                "Status:", statusComboBox
            };

            int option = JOptionPane.showConfirmDialog(this, message, "Add Activity", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                String activityName = activityNameField.getText().trim();
                String user = userField.getText().trim();
                String status = statusComboBox.getSelectedItem().toString();

                if (!activityName.isEmpty() && !user.isEmpty()) {
                    tableModel.addRow(new Object[]{activityName, user, status});
                    JOptionPane.showMessageDialog(this, "Activity added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "All fields must be filled.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Edit Activity Logic
        editActivityButton.addActionListener(e -> {
            int selectedRow = activityTable.getSelectedRow();
            if (selectedRow >= 0) {
                String activityName = (String) tableModel.getValueAt(selectedRow, 0);
                String user = (String) tableModel.getValueAt(selectedRow, 1);
                String status = (String) tableModel.getValueAt(selectedRow, 2);

                JTextField activityNameField = new JTextField(activityName);
                JTextField userField = new JTextField(user);
                JComboBox<String> statusComboBox = new JComboBox<>(new String[]{"Pending", "Approved", "Rejected"});
                statusComboBox.setSelectedItem(status);

                Object[] message = {
                    "Activity Name:", activityNameField,
                    "User:", userField,
                    "Status:", statusComboBox
                };

                int option = JOptionPane.showConfirmDialog(this, message, "Edit Activity", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                    tableModel.setValueAt(activityNameField.getText().trim(), selectedRow, 0);
                    tableModel.setValueAt(userField.getText().trim(), selectedRow, 1);
                    tableModel.setValueAt(statusComboBox.getSelectedItem().toString(), selectedRow, 2);
                    JOptionPane.showMessageDialog(this, "Activity updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "No activity selected. Please select a row to edit.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Delete Activity Logic
        deleteActivityButton.addActionListener(e -> {
            int selectedRow = activityTable.getSelectedRow();
            if (selectedRow >= 0) {
                int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this activity?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    tableModel.removeRow(selectedRow);
                    JOptionPane.showMessageDialog(this, "Activity deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "No activity selected. Please select a row to delete.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Add buttons to the button panel
        buttonPanel.add(addActivityButton);
        buttonPanel.add(editActivityButton);
        buttonPanel.add(deleteActivityButton);

        // Add components to the panel
        panel.add(titlePanel, BorderLayout.NORTH);
        panel.add(tableScrollPane, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createUserPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        // Title Label
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel title = new JLabel("User Management");
        title.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titlePanel.add(title);

        // Table for users
        String[] columnNames = {"Name", "Activity History", "Goals"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(table);

        // Buttons Panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        JButton addUserButton = new JButton("Add User");
        JButton editUserButton = new JButton("Edit User");
        JButton deleteUserButton = new JButton("Delete User");

        // Add User Logic
        addUserButton.addActionListener(e -> {
            JTextField nameField = new JTextField();
            JTextField emailField = new JTextField();
            JTextField passwordField = new JTextField();
            JTextField phoneField = new JTextField();
            JTextField addressField = new JTextField();
            JTextField activityField = new JTextField();
            JTextField goalsField = new JTextField();

            Object[] message = {
                "Name:", nameField,
                "Email:", emailField,
                "Password:", passwordField,
                "Phone Number:", phoneField,
                "Address:", addressField,
                "Activity History (comma-separated):", activityField,
                "Goals (comma-separated):", goalsField
            };

            int option = JOptionPane.showConfirmDialog(this, message, "Add User", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                String name = nameField.getText().trim();
                String email = emailField.getText().trim();
                String password = passwordField.getText().trim();
                String phone = phoneField.getText().trim();
                String address = addressField.getText().trim();
                List<String> activityHistory = List.of(activityField.getText().split("\\s*,\\s*"));
                List<String> goals = List.of(goalsField.getText().split("\\s*,\\s*"));

                if (!name.isEmpty() && !email.isEmpty() && !password.isEmpty() &&
                    !phone.isEmpty() && !address.isEmpty()) {
                    User newUser = new User("KU" + userList.size() + 1, name, email, phone, address, password, activityHistory, goals);

                    userList.add(newUser); // Add full user details to the list
                    tableModel.addRow(new Object[]{name, activityHistory.size() + " activities", goals.size() + " goals"});
                    JOptionPane.showMessageDialog(this, "User added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "All fields must be filled.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Edit User Logic
        editUserButton.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow >= 0) {
                User selectedUser = userList.get(selectedRow);

                JTextField nameField = new JTextField(selectedUser.getName());
                JTextField emailField = new JTextField(selectedUser.getEmail());
                JTextField passwordField = new JTextField(selectedUser.getPassword());
                JTextField phoneField = new JTextField(selectedUser.getPhoneNumber());
                JTextField addressField = new JTextField(selectedUser.getAddress());
                JTextArea activityArea = new JTextArea(String.join(", ", selectedUser.getActivityHistory()));
                JTextArea goalsArea = new JTextArea(String.join(", ", selectedUser.getGoals()));

                Object[] message = {
                    "Name:", nameField,
                    "Email:", emailField,
                    "Password:", passwordField,
                    "Phone Number:", phoneField,
                    "Address:", addressField,
                    "Activity History (comma-separated):", activityArea,
                    "Goals (comma-separated):", goalsArea
                };

                int option = JOptionPane.showConfirmDialog(this, message, "Edit User", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                    selectedUser.setName(nameField.getText().trim());
                    selectedUser.setEmail(emailField.getText().trim());
                    selectedUser.setPassword(passwordField.getText().trim());
                    selectedUser.setPhoneNumber(phoneField.getText().trim());
                    selectedUser.setAddress(addressField.getText().trim());
                    selectedUser.setActivityHistory(List.of(activityArea.getText().split("\\s*,\\s*")));
                    selectedUser.setGoals(List.of(goalsArea.getText().split("\\s*,\\s*")));

                    tableModel.setValueAt(selectedUser.getName(), selectedRow, 0);
                    tableModel.setValueAt(selectedUser.getActivityHistory().size() + " activities", selectedRow, 1);
                    tableModel.setValueAt(selectedUser.getGoals().size() + " goals", selectedRow, 2);
                    JOptionPane.showMessageDialog(this, "User updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "No user selected. Please select a row to edit.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Delete User Logic
        deleteUserButton.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow >= 0) {
                int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this user?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    userList.remove(selectedRow);
                    tableModel.removeRow(selectedRow);
                    JOptionPane.showMessageDialog(this, "User deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "No user selected. Please select a row to delete.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        buttonPanel.add(addUserButton);
        buttonPanel.add(editUserButton);
        buttonPanel.add(deleteUserButton);

        panel.add(titlePanel, BorderLayout.NORTH);
        panel.add(tableScrollPane, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == activityButton) {
            cardLayout.show(cardPanel, "Activity");
        } else if (e.getSource() == userButton) {
            cardLayout.show(cardPanel, "User");
        } else if (e.getSource() == logoutButton) {
            int choice = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to log out?",
                "Logout Confirmation",
                JOptionPane.YES_NO_OPTION
            );
            if (choice == JOptionPane.YES_OPTION) {
                this.dispose();
                new SignIn().setVisible(true);
            }
        }
    }

    public static void main(String[] args) {
        new AdminPage();
    }
}
