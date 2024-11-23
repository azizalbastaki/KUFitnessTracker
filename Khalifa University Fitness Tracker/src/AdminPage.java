import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AdminPage extends JFrame implements ActionListener {
    private JPanel leftPanel, rightPanel, cardPanel;
    private JButton activityButton, userButton, logoutButton;
    private CardLayout cardLayout;

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
        JTable table = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(table);

        // Buttons Panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        JButton approveButton = new JButton("Approve");
        JButton rejectButton = new JButton("Reject");
        JButton searchButton = new JButton("Search");

        // Add action listeners to the buttons
        approveButton.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow >= 0) {
                tableModel.setValueAt("Approved", selectedRow, 2);
            } else {
                JOptionPane.showMessageDialog(this, "No activity selected.");
            }
        });

        rejectButton.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow >= 0) {
                tableModel.setValueAt("Rejected", selectedRow, 2);
            } else {
                JOptionPane.showMessageDialog(this, "No activity selected.");
            }
        });

        searchButton.addActionListener(e -> {
            String searchName = JOptionPane.showInputDialog(this, "Enter Activity Name or User to Search:", "Search", JOptionPane.QUESTION_MESSAGE);
            if (searchName != null && !searchName.trim().isEmpty()) {
                boolean found = false;
                for (int i = 0; i < tableModel.getRowCount(); i++) {
                    String activityName = tableModel.getValueAt(i, 0).toString();
                    String userName = tableModel.getValueAt(i, 1).toString();

                    if (activityName.equalsIgnoreCase(searchName.trim()) || userName.equalsIgnoreCase(searchName.trim())) {
                        found = true;
                        JOptionPane.showMessageDialog(this, "Found: " + activityName + " by " + userName, "Search Result", JOptionPane.INFORMATION_MESSAGE);
                        table.setRowSelectionInterval(i, i);
                        break;
                    }
                }
                if (!found) {
                    JOptionPane.showMessageDialog(this, "No matching activity or user found.", "Search Result", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        // Add buttons to the button panel
        buttonPanel.add(approveButton);
        buttonPanel.add(rejectButton);
        buttonPanel.add(searchButton);

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

        buttonPanel.add(addUserButton);
        buttonPanel.add(editUserButton);
        buttonPanel.add(deleteUserButton);

        // Add components to the panel
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
