import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.raven.swing.TimePicker;
import com.toedter.calendar.JDateChooser;

public class UserPage extends JFrame implements ActionListener {

    // Sidebar and Card Layout Components
    private JPanel leftPanel, rightPanel, cardPanel, sidebarButtonsPanel;
    private JButton profileButton, fitnessButton, goalButton, logoutButton;
    private CardLayout cardLayout;

    // Profile Components
    private JTextField nametf, emailtf, phonetf, addresstf, idtf;
    private JPasswordField passtf;
    private JButton editButton, saveButton;

    // Simulated User Object
    private User user;

    /**
     * Constructor: Initializes the UserPage frame and components.
     */
    public UserPage() {
        user = (User) Main.users.get(Main.idx); // Simulated user object from Main
        initComponents();
    }

    /**
     * Initializes and organizes all components in the UserPage.
     */
    private void initComponents() {
        setTitle("User Page - KU Fitness Tracker");
        setSize(1280, 720);
        setMinimumSize(new Dimension(900, 600));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        setupSidebar();
        setupCardPanel();

        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    /**
     * Sets up the sidebar (left panel) with navigation buttons.
     */
    private void setupSidebar() {
        leftPanel = new JPanel(new BorderLayout());
        leftPanel.setBackground(new Color(62, 8, 76));
        leftPanel.setPreferredSize(new Dimension(250, getHeight()));

        // Sidebar Buttons Panel
        sidebarButtonsPanel = new JPanel();
        sidebarButtonsPanel.setLayout(new BoxLayout(sidebarButtonsPanel, BoxLayout.Y_AXIS));
        sidebarButtonsPanel.setBackground(new Color(62, 8, 76));

        JLabel kuIcon = new JLabel(new ImageIcon("KU logo22.jpg"));
        kuIcon.setAlignmentX(Component.CENTER_ALIGNMENT);
        kuIcon.setBorder(BorderFactory.createEmptyBorder(30, 0, 20, 0));

        // Create Navigation Buttons
        profileButton = createSidebarButton("My Profile");
        fitnessButton = createSidebarButton("Fitness Activity");
        goalButton = createSidebarButton("Goals");
        logoutButton = createSidebarButton("Logout");

        // Add components to the sidebar
        sidebarButtonsPanel.add(kuIcon);
        sidebarButtonsPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        sidebarButtonsPanel.add(profileButton);
        sidebarButtonsPanel.add(fitnessButton);
        sidebarButtonsPanel.add(goalButton);

        leftPanel.add(sidebarButtonsPanel, BorderLayout.NORTH);
        leftPanel.add(logoutButton, BorderLayout.SOUTH);
    }

    /**
     * Sets up the main content area with a CardLayout for switching views.
     */
    private void setupCardPanel() {
        rightPanel = new JPanel(new BorderLayout());
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Add sub-panels for each section
        cardPanel.add(createProfilePanel(), "Profile");
        cardPanel.add(createFitnessPanel(), "Fitness");
        cardPanel.add(createGoalPanel(), "Goals");
        rightPanel.add(cardPanel, BorderLayout.CENTER);
    }

    /**
     * Creates a styled button for the sidebar.
     * @param text The text to display on the button.
     * @return The styled JButton.
     */
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

    /**
     * Creates the Profile Panel with user details and actions.
     * @return JPanel representing the Profile view.
     */
    private JPanel createProfilePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(134, 244, 238));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel title = new JLabel("My Profile", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 24));
        title.setForeground(new Color(62, 8, 76));
        title.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

        // User Details Form
        JPanel detailsPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        detailsPanel.setBackground(new Color(134, 244, 238));

        idtf = createTextField(user.getId(), "User Id");
        idtf.setEditable(false);
        nametf = createTextField(user.getName(), "Full Name");
        nametf.setEditable(false);
        emailtf = createTextField(user.getEmail(), "Email");
        emailtf.setEditable(false);
        phonetf = createTextField(user.getPhoneNumber(), "Phone Number");
        phonetf.setEditable(false);
        addresstf = createTextField(user.getAddress(), "Address");
        addresstf.setEditable(false);
        passtf = createPasswordField(user.getPassword(), "Password");
        passtf.setEditable(false);

        detailsPanel.add(idtf);
        detailsPanel.add(nametf);
        detailsPanel.add(emailtf);
        detailsPanel.add(phonetf);
        detailsPanel.add(addresstf);
        detailsPanel.add(passtf);

        // Action Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        editButton = createButton("Edit", e -> enableEditing(true));
        saveButton = createButton("Save", e -> saveChanges());
        saveButton.setEnabled(false);

        JButton printReportButton = createButton("Print Progress Report", e -> user.generateProgressReport());

        buttonPanel.add(editButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(printReportButton);

        panel.add(title, BorderLayout.NORTH);
        panel.add(detailsPanel, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    /**
     * Creates a JTextField with specified text and placeholder.
     */
    private JTextField createTextField(String text, String placeholder) {
        JTextField textField = new JTextField(text);
        textField.setBorder(BorderFactory.createTitledBorder(placeholder));
        textField.setEditable(true);
        return textField;
    }

    /**
     * Creates a JPasswordField with specified text and placeholder.
     */
    private JPasswordField createPasswordField(String text, String placeholder) {
        JPasswordField passwordField = new JPasswordField(text);
        passwordField.setBorder(BorderFactory.createTitledBorder(placeholder));
        passwordField.setEditable(false);
        return passwordField;
    }

    /**
     * Creates a JButton with specified text and ActionListener.
     */
    private JButton createButton(String text, ActionListener action) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setForeground(new Color(62, 8, 76));
        button.addActionListener(action);
        return button;
    }

    /**
     * Enables or disables editing of user profile fields.
     */
    private void enableEditing(boolean editable) {
        nametf.setEditable(editable);
        emailtf.setEditable(editable);
        phonetf.setEditable(editable);
        addresstf.setEditable(editable);
        passtf.setEditable(editable);

        editButton.setEnabled(!editable);
        saveButton.setEnabled(editable);
    }

    /**
     * Saves the changes made to the user profile.
     */
    private void saveChanges() {
        try {
            user.setName(nametf.getText());
            user.setEmail(emailtf.getText());
            user.setPhoneNumber(phonetf.getText());
            user.setAddress(addresstf.getText());
            user.setPassword(new String(passtf.getPassword()));
            enableEditing(false);
            JOptionPane.showMessageDialog(this, "Profile upKUDated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Failed to upKUDate profile. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Creates the Fitness Activity Panel.
     * @return JPanel representing the Fitness view.
     */
    private JPanel createFitnessPanel() {
        JPanel fitnessPanel = new JPanel(new BorderLayout());
        fitnessPanel.setBackground(new Color(200, 255, 200));
        fitnessPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    
        // Title label
        JLabel title = new JLabel("Fitness Activities", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 24));
        title.setForeground(new Color(62, 8, 76));
        title.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
    
        // Table for displaying fitness activities
        String[] columns = {"Name", "Duration", "Calories Burned", "KUDate", "Time"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
        JTable fitnessTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(fitnessTable);
    
        // Buttons for managing activities
        JPanel buttonPanel = createButtonPanel(tableModel, fitnessTable);
    
        // Add components to the panel
        fitnessPanel.add(title, BorderLayout.NORTH);
        fitnessPanel.add(tableScrollPane, BorderLayout.CENTER);
        fitnessPanel.add(buttonPanel, BorderLayout.SOUTH);
    
        return fitnessPanel;
    }
    
    // Create button panel with Add, Edit, and Delete buttons
    private JPanel createButtonPanel(DefaultTableModel tableModel, JTable fitnessTable) {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        
        // Add button
        JButton addButton = new JButton("Add Activity");
        addButton.addActionListener(e -> addActivity(tableModel));
    
        // Edit button (Functionality can be added)
        JButton editButton = new JButton("Edit Activity");
        editButton.addActionListener(e -> editActivity(fitnessTable, tableModel));
    
        // Delete button
        JButton deleteButton = new JButton("Delete Activity");
        deleteButton.addActionListener(e -> deleteActivity(fitnessTable, tableModel));
    
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
    
        return buttonPanel;
    }
    
    // Add Activity
    private void addActivity(DefaultTableModel tableModel) {
        JTextField nameField = new JTextField();
        
        // Create Duration Panel
        JPanel durationPanel = new JPanel(new FlowLayout());
        durationPanel.setSize(200, 30);
        
        // Duration Fields
        JTextField hoursField = createTextField("", "Hours");
        JTextField minutesField = createTextField("", "Minutes");
        JTextField secondsField = createTextField("", "Seconds");
        
        // Add Duration Fields to Panel
        durationPanel.add(hoursField);
        durationPanel.add(minutesField);
        durationPanel.add(secondsField);

        // Create Calories Field
        JTextField caloriesField = createTextField("", "Calories Burned");

        // Create Date Field
        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setDateFormatString("yyyy-MM-dd");

        // Create Time Button
        JButton timeButton = new JButton("Select Time");
        TimePicker timePicker = new TimePicker();
        timePicker.setBorder(BorderFactory.createTitledBorder("Select Time"));

        // Action Listener for Time Button
        timeButton.addActionListener(e -> {
            int result = JOptionPane.showConfirmDialog(this, timePicker, "Select Time", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                // Capture selected time
                String selectedTime = timePicker.getSelectedTime(); // Assuming TimePicker provides this method
                timeButton.setText(selectedTime); // Update button text with selected time
            }
        });

        // Displaying input fields in dialog
        Object[] message = {
            "Name:", nameField,
            "Duration (Hours, Minutes, Seconds):", durationPanel,
            "Calories Burned:", caloriesField,
            "Date:", dateChooser,
            "Time:", timeButton
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Add New Activity", JOptionPane.OK_CANCEL_OPTION);
        
        if (option == JOptionPane.OK_OPTION) {
            try {
                // Validate and parse input
                String name = nameField.getText().trim();
                if (name.isEmpty()) throw new IllegalArgumentException("Activity name is required.");

                // Parse Duration (hours, minutes, seconds)
                int hours = Integer.parseInt(hoursField.getText().trim());
                int minutes = Integer.parseInt(minutesField.getText().trim());
                int seconds = Integer.parseInt(secondsField.getText().trim());
                Time duration = new Time(hours, minutes, seconds);

                int calories = Integer.parseInt(caloriesField.getText().trim());
                if (calories <= 0) throw new IllegalArgumentException("Calories must be a positive number.");

                // Parse Date
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(dateChooser.getDate());
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH) + 1; // Calendar months are 0-based
                int year = calendar.get(Calendar.YEAR);
                KUDate activityDate = new KUDate(day, month, year);

                // Time validation
                String time = timeButton.getText();
                if (time.equals("Select Time")) {
                    throw new IllegalArgumentException("Time must be selected.");
                }

                // Create Activity object and add to table
                Activity activity = new Activity(name, duration, calories, activityDate, time);
                tableModel.addRow(new Object[]{
                    activity.getName(), activity.getDuration(), activity.getCaloriesBurned(),
                    activity.getActivityDate(), activity.getTime()
                });
                
                // Clear input fields
                nameField.setText("");
                hoursField.setText("");
                minutesField.setText("");
                secondsField.setText("");
                caloriesField.setText("");
                dateChooser.setDate(null);
                timeButton.setText("Select Time");
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Invalid input!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    // Edit Activity (Placeholder, functionality to be implemented)
    private void editActivity(JTable fitnessTable, DefaultTableModel tableModel) {
        // Add logic for editing an activity if needed
    }
    
    // Delete Activity
    private void deleteActivity(JTable fitnessTable, DefaultTableModel tableModel) {
        int selectedRow = fitnessTable.getSelectedRow();
        if (selectedRow != -1) {
            tableModel.removeRow(selectedRow);
            JOptionPane.showMessageDialog(this, "Activity deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "No activity selected for deletion.", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * Creates the Goals Panel.
     * @return JPanel representing the Goals view.
     */
    private JPanel createGoalPanel() {
        JPanel goalPanel = new JPanel(new BorderLayout());
        goalPanel.setBackground(new Color(255, 229, 204));
        goalPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel title = new JLabel("Goals", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 24));
        title.setForeground(new Color(62, 8, 76));
        title.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

        // Goal list
        DefaultTableModel goalTableModel = new DefaultTableModel(new String[]{"Goal", "Target", "Progress"}, 0);
        JTable goalTable = new JTable(goalTableModel);
        JScrollPane goalScrollPane = new JScrollPane(goalTable);

        // Input fields for adding goals
        JPanel goalInputPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        goalInputPanel.setBackground(new Color(255, 229, 204));

        JTextField goalField = createTextField("", "Goal Description");
        JTextField targetField = createTextField("", "Target Value");
        JTextField progressField = createTextField("", "Current Progress");

        goalInputPanel.add(goalField);
        goalInputPanel.add(targetField);
        goalInputPanel.add(progressField);

        // Add and Remove Goal Buttons
        JPanel goalButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        JButton addGoalButton = createButton("Add Goal", e -> {
            try {
                String goal = goalField.getText();
                int target = Integer.parseInt(targetField.getText());
                int progress = Integer.parseInt(progressField.getText());

                if (progress > target) {
                    JOptionPane.showMessageDialog(this, "Progress cannot exceed target!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                goalTableModel.addRow(new Object[]{goal, target, progress});
                JOptionPane.showMessageDialog(this, "Goal added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

                // Clear input fields
                goalField.setText("");
                targetField.setText("");
                progressField.setText("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Failed to add goal. Check your inputs.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        JButton removeGoalButton = createButton("Remove Selected Goal", e -> {
            int selectedRow = goalTable.getSelectedRow();
            if (selectedRow != -1) {
                goalTableModel.removeRow(selectedRow);
                JOptionPane.showMessageDialog(this, "Goal removed successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "No goal selected for removal.", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        });

        goalButtonPanel.add(addGoalButton);
        goalButtonPanel.add(removeGoalButton);

        goalPanel.add(title, BorderLayout.NORTH);
        goalPanel.add(goalScrollPane, BorderLayout.CENTER);
        goalPanel.add(goalInputPanel, BorderLayout.WEST);
        goalPanel.add(goalButtonPanel, BorderLayout.SOUTH);

        return goalPanel;
    }


    /**
     * Handles button actions for navigation and other operations.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        profileButton.setBackground(null);
        fitnessButton.setBackground(null);
        goalButton.setBackground(null);

        if (e.getSource() == profileButton) {
            cardLayout.show(cardPanel, "Profile");
            profileButton.setBackground(Color.CYAN);
        } else if (e.getSource() == fitnessButton) {
            cardLayout.show(cardPanel, "Fitness");
            fitnessButton.setBackground(Color.CYAN);
        } else if (e.getSource() == goalButton) {
            cardLayout.show(cardPanel, "Goals");
            goalButton.setBackground(Color.CYAN);
        } else if (e.getSource() == logoutButton) {
            this.dispose(); // Close current frame
            new SignIn().setVisible(true); // Redirect to login page
        }
    }
}
