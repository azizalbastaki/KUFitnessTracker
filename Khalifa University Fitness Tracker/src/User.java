import java.util.*;
import java.io.*;

public class User extends Account {
    private static final String ID_FILE = "id_counter.txt";
    private String email;
    private KUDate birthdate;
    private String phoneNumber;
    private String address;
    private String id;
    private int totalCaloriesBurned;
    private List<Activity> activities = new ArrayList<>();
    private List<Goal> goals = new ArrayList<>();
    
    public User (String name, String email, String password, KUDate birthdate, String phoneNumber, String address) {
        super(name, password);
        this.birthdate = birthdate;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.activities = new ArrayList<>();
        this.goals = new ArrayList<>();
        id = generateUniqueId();
    }

    public User (String id, String name, String email, String password, KUDate birthdate, String phoneNumber, String address, int totalCaloriesBurned) {
        super(name, password);
        this.birthdate = birthdate;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.activities = new ArrayList<>();
        this.goals = new ArrayList<>();
        this.id = id;
        this.totalCaloriesBurned = totalCaloriesBurned;
    }
        
    public User(String name, String password, KUDate birthdate, String phoneNumber, String email, String address, Activity[] activities, Goal[] goals) {
        super(name, password);
        this.birthdate = birthdate;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.totalCaloriesBurned = 0;
        this.activities = new ArrayList<>(Arrays.asList(activities));
        this.goals = new ArrayList<>(Arrays.asList(goals));
    }

    private static String generateUniqueId() {
        int currentId = 1000; // Default starting ID
        File file = new File(ID_FILE);

        try {
            // Check if the file exists, otherwise create it
            if (!file.exists()) {
                file.createNewFile();
                writeIdToFile(currentId); // Write the starting ID
            } else {
                // Read the last used ID
                Scanner reader = new Scanner(new FileReader(file));
                currentId = Integer.parseInt(reader.nextLine().trim());
                reader.close();
            }

            // Increment and save the new ID
            int newId = currentId + 1;
            writeIdToFile(newId);

            return "KU" + currentId; // Return unique ID
        } catch (IOException | NumberFormatException e) {
            throw new RuntimeException("Error generating unique ID: " + e.getMessage());
        }
    }

    private static void writeIdToFile(int id) throws IOException {
        PrintWriter writer = new PrintWriter(ID_FILE);
        writer.write(String.valueOf(id));
        writer.close();
    }

    public void generateProgressReport() {
        String fileName = this.id + "_Progress_Report.txt"; // Unique file for each user
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            // Write user information and progress data to the file
            writer.println("Progress Report for User: " + getEmail());
            writer.println("User ID: " + this.id);
            writer.println("Total Calories Burned: " + this.totalCaloriesBurned);
            writer.println("\nFitness Activities:");
            if (activities.isEmpty()) {
                writer.println("No activities logged yet.");
            } else {
                for (Activity activity : activities) {
                    writer.println("- " + activity);
                }
            }
            writer.println("\nGoals:");
            if (goals.isEmpty()) {
                writer.println("No goals set yet.");
            } else {
                for (Goal goal : goals) {
                    writer.println("- " + goal);
                }
            }
            writer.println("\nThank you for using the KU Fitness Tracker!");
            System.out.println("Progress report saved as: " + fileName); // Confirmation message
        } catch (IOException e) {
            System.err.println("Error generating progress report: " + e.getMessage());
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public KUDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(KUDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhone(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
    public String getId() {
        return id;
    }

    public void setGoals(List<Goal> goals) {
        this.goals = goals;
    }
    public void logCalories(int calories) {
        this.totalCaloriesBurned += calories;
    }
    public int getTotalCaloriesBurned() {
        return totalCaloriesBurned;
    }

    public void addActivity(Activity newActivity) {
        activities.add(newActivity);
    } 

    @Override
    public String toString() {
        return id + "|" + getName() + "|" + email + "|" + getPassword() + "|" + birthdate + "|" + phoneNumber + "|" + address + "|" + totalCaloriesBurned + "|";
    }

}
