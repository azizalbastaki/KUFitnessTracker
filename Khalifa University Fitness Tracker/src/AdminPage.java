import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AdminPage extends JFrame implements ActionListener {
    private JPanel left, right, cardPanel;
    private JButton activityButton, userButton, logoutButton;
    private CardLayout cardLayout;

    // Admin credentials
    private static final String ADMIN_NAME = "admin";
    private static final String ADMIN_PASSWORD = "admin2023";

    public AdminPage() {
        initComponents();
    }

    private void initComponents() {
        // Frame settings
        setTitle("Admin Page - KU Fitness Tracker");
        setSize(1280, 720);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Left Panel (Sidebar)
        left = new JPanel();
        left.setBackground(new Color(62, 8, 76));
        left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
        left.setPreferredSize(new Dimension(250, getHeight()));

        activityButton = createSidebarButton("Activity Management");
        userButton = createSidebarButton("User Management");
        logoutButton = createSidebarButton("Logout");

        left.add(Box.createRigidArea(new Dimension(0, 20)));
        left.add(activityButton);
        left.add(userButton);
        left.add(Box.createVerticalGlue());
        left.add(logoutButton);

        // Right Panel (Main Content Area)
        right = new JPanel();
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Adding sub-panels to cardPanel
        cardPanel.add(createActivityPanel(), "Activity");
        cardPanel.add(createUserPanel(), "User");

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
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(62, 8, 76));
        button.setFocusPainted(false);
        button.addActionListener(this);
        button.setMaximumSize(new Dimension(200, 50));
        return button;
    }

    private JPanel createActivityPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel title = new JLabel("Activity Management", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 24));

        String[] columnNames = {"Activity Name", "User", "Status"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable activityTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(activityTable);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        JButton approveButton = new JButton("Approve");
        JButton rejectButton = new JButton("Reject");
        buttonPanel.add(approveButton);
        buttonPanel.add(rejectButton);

        approveButton.addActionListener(e -> {
            int selectedRow = activityTable.getSelectedRow();
            if (selectedRow >= 0) {
                tableModel.setValueAt("Approved", selectedRow, 2);
            } else {
                JOptionPane.showMessageDialog(this, "No activity selected.");
            }
        });

        rejectButton.addActionListener(e -> {
            int selectedRow = activityTable.getSelectedRow();
            if (selectedRow >= 0) {
                tableModel.setValueAt("Rejected", selectedRow, 2);
            } else {
                JOptionPane.showMessageDialog(this, "No activity selected.");
            }
        });

        panel.add(title, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createUserPanel() {
    JPanel panel = new JPanel(new BorderLayout());
    JLabel title = new JLabel("User Management", SwingConstants.CENTER);
    title.setFont(new Font("Segoe UI", Font.BOLD, 24));

    // Updated column names to include only Name, Activity History, and Goals
    String[] columnNames = {"Name", "Activity History", "Goals"};
    DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
    JTable userTable = new JTable(tableModel);
    JScrollPane scrollPane = new JScrollPane(userTable);

    JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
    JButton addUserButton = new JButton("Add User");
    JButton editUserButton = new JButton("Edit User");
    JButton deleteUserButton = new JButton("Delete User");

    // Add User functionality
    addUserButton.addActionListener(e -> {
        JTextField nameField = new JTextField();
        JTextField activityField = new JTextField();
        JTextField goalsField = new JTextField();

        Object[] message = {
            "Name:", nameField, 
            "Activity History:", activityField, 
            "Goals:", goalsField
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Add User", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            tableModel.addRow(new Object[]{nameField.getText(), activityField.getText(), goalsField.getText()});
        }
    });

    // Edit User functionality
    editUserButton.addActionListener(e -> {
        int selectedRow = userTable.getSelectedRow();
        if (selectedRow >= 0) {
            String name = (String) tableModel.getValueAt(selectedRow, 0);
            String activity = (String) tableModel.getValueAt(selectedRow, 1);
            String goals = (String) tableModel.getValueAt(selectedRow, 2);

            JTextField nameField = new JTextField(name);
            JTextField activityField = new JTextField(activity);
            JTextField goalsField = new JTextField(goals);

            Object[] message = {
                "Name:", nameField, 
                "Activity History:", activityField, 
                "Goals:", goalsField
            };

            int option = JOptionPane.showConfirmDialog(this, message, "Edit User", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                tableModel.setValueAt(nameField.getText(), selectedRow, 0);
                tableModel.setValueAt(activityField.getText(), selectedRow, 1);
                tableModel.setValueAt(goalsField.getText(), selectedRow, 2);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No user selected.");
        }
    });

    // Delete User functionality
    deleteUserButton.addActionListener(e -> {
        int selectedRow = userTable.getSelectedRow();
        if (selectedRow >= 0) {
            tableModel.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "No user selected.");
        }
    });

    buttonPanel.add(addUserButton);
    buttonPanel.add(editUserButton);
    buttonPanel.add(deleteUserButton);

    panel.add(title, BorderLayout.NORTH);
    panel.add(scrollPane, BorderLayout.CENTER);
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
