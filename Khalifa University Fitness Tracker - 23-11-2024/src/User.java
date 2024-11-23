import java.util.*;
import java.io.*;

public class User extends Account {
    private static final String ID_FILE = "id_counter.txt";
    private String email;
    private KUDate birthdate;
    private String phoneNumber;
    private String address;
    private static String id;
    private int totalCaloriesBurned;
    private List<Activity> activities = new ArrayList<>();
    private List<Goal> goals = new ArrayList<>();

    public User() {}

    public User(String name, String email, String password, KUDate birthdate, String phoneNumber, String address) {
        super(name, password);
        setEmail(email);
        setBirthdate(birthdate);
        setPhone(phoneNumber);
        setAddress(address);
        this.totalCaloriesBurned = 0;
        generateUniqueId();
    }

    // New constructor with explicit ID
    public User(String name, String email, String phoneNumber, String address, String password) {
        super(name, password);
        generateUniqueId();
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.totalCaloriesBurned = 0;
        this.birthdate = null; // Default value if birthdate is not passed
    }

    // Validation logic for email
    public void setEmail(String email) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty.");
        }
        this.email = email;
    }

    // Validation logic for phone number
    public void setPhone(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            throw new IllegalArgumentException("Phone number cannot be null or empty.");
        }
        this.phoneNumber = phoneNumber;
    }

    // Validation logic for birthdate
    public void setBirthdate(KUDate birthdate) {
        if (birthdate == null) {
            throw new IllegalArgumentException("Birthdate cannot be null.");
        }
        this.birthdate = birthdate;
    }

    // Validation logic for address
    public void setAddress(String address) {
        if (address == null || address.isEmpty()) {
            throw new IllegalArgumentException("Address cannot be null or empty.");
        }
        this.address = address;
    }

    // Validation for total calories burned
    public void logCalories(int calories) {
        if (calories < 0) {
            throw new IllegalArgumentException("Calories burned cannot be negative.");
        }
        this.totalCaloriesBurned += calories;
    }

    // Getter methods
    public String getEmail() {
        return email;
    }

    public KUDate getBirthdate() {
        return birthdate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public int getTotalCaloriesBurned() {
        return totalCaloriesBurned;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    public List<Goal> getGoals() {
        return goals;
    }

    public void setGoals(List<Goal> goals) {
        this.goals = goals;
    }

    private static void generateUniqueId() {
        int currentId = 1000; // Default starting ID
        File file = new File(ID_FILE);

        try {
            if (!file.exists()) {
                file.createNewFile();
                writeIdToFile(currentId); // Write the starting ID
            } else {
                Scanner reader = new Scanner(new FileReader(file));
                if (reader.hasNextLine()) {
                    currentId = Integer.parseInt(reader.nextLine().trim());
                }
                reader.close();
            }

            int newId = currentId + 1;
            writeIdToFile(newId);

            id = "KU" + currentId;
        } catch (IOException | NumberFormatException e) {
            throw new RuntimeException("Error generating unique ID: " + e.getMessage());
        }
    }

    private static void writeIdToFile(int id) throws IOException {
        try (PrintWriter writer = new PrintWriter(ID_FILE)) {
            writer.write(String.valueOf(id));
        }
    }

    public void addActivity(Activity activity){
        activities.add(activity);
    }
    
    public void addGoal(Goal goal){
        goals.add(goal);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("START_USER\n");
        sb.append("Name|").append(getName()).append("\n");
        sb.append("Email|").append(email).append("\n");
        sb.append("Password|").append(getPassword()).append("\n");
        sb.append("Birthdate|").append(birthdate.toString()).append("\n");
        sb.append("PhoneNumber|").append(phoneNumber).append("\n");
        sb.append("Address|").append(address).append("\n");

        // Save goals and activities in a structured way
        sb.append("Goals:\n");
        for (Goal goal : goals) {
            sb.append(goal.toString()).append("\n");
        }

        sb.append("Activities:\n");
        for (Activity activity : activities) {
            sb.append(activity.toString()).append("\n");
        }
        sb.append("END_USER\n");
        return sb.toString();
    }

    public void generateProgressReport() {
        String fileName = this.id + "_Progress_Report.txt"; // Unique file for each user
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            // Write user information and progress data to the file
            writer.println("Progress Report for User: " + getEmail());
            writer.println("User ID: " + this.id);
            writer.println("Total Calories Burned: " + this.totalCaloriesBurned);
            writer.println("\nFitness Activities:");
    
            // Check if the user has logged any activities
            if (activities.isEmpty()) {
                writer.println("No activities logged yet.");
            } else {
                for (Activity activity : activities) {
                    writer.println(activity.toString()); // Uses Activity's toString method
                }
            }
    
            writer.println("\nGoals:");
    
            // Check if the user has set any goals
            if (goals.isEmpty()) {
                writer.println("No goals set yet.");
            } else {
                for (Goal goal : goals) {
                    writer.println(goal.toString()); // Uses Goal's toString method
                }
            }
    
            writer.println("\nThank you for using the KU Fitness Tracker!");
            System.out.println("Progress report saved as: " + fileName); // Confirmation message
        } catch (IOException e) {
            System.err.println("Error generating progress report: " + e.getMessage());
        }
    }
    

    public static User fromString(List<String> lines) {
        User user = new User();
        for (String line : lines) {
            if (line.startsWith("Name|")) {
                user.setName(line.split("\\|", 2)[1]);
            } else if (line.startsWith("Email|")) {
                user.setEmail(line.split("\\|", 2)[1]);
            } else if (line.startsWith("Password|")) {
                user.setPassword(line.split("\\|", 2)[1]);
            } else if (line.startsWith("Birthdate|")) {
                user.setBirthdate(KUDate.fromString(line.split("\\|", 2)[1]));
            } else if (line.startsWith("PhoneNumber|")) {
                user.setPhone(line.split("\\|", 2)[1]);
            } else if (line.startsWith("Address|")) {
                user.setAddress(line.split("\\|", 2)[1]);
            } else if (line.startsWith("GoalId|")) {
                String[] goalData = line.split("\n");
                Goal goal = Goal.fromString(goalData);
                user.addGoal(goal);
            } else if (line.startsWith("Activity|")) {
                Activity activity = Activity.fromString(line);
                user.addActivity(activity);
            }
        }
        return user;
    }

    public boolean removeActivity(String activityName) {
        for (Activity activity : activities) { // Assuming activities is a list of Activity objects
            if (activity.getName().equals(activityName)) {
                activities.remove(activity); // Remove the activity
                return true;
            }
        }
        return false; // Activity not found
    }
    

    public boolean removeGoal(String goalName) {
        for (Goal goal : goals) {
            if (goal.getGoalDescription().equals(goalName)) {
                goals.remove(goal);
                return true; // Indicate successful removal
            }
        }
        return false; // Goal not found
    }

    // Update an activity by its name
    public boolean updateActivity(String oldActivityName, Activity newActivity) {
        for (int i = 0; i < activities.size(); i++) {
            if (activities.get(i).getName().equals(oldActivityName)) {
                activities.set(i, newActivity);
                return true;
            }
        }
        return false; // Activity not found
    }
}