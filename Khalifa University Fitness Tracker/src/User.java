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
    private List<String> activityHistory;
    private List<String> goals;

    // Existing constructor
    public User(String name, String email, String password, KUDate birthdate, String phoneNumber, String address) {
        super(name, password);
        this.email = email;
        this.birthdate = birthdate;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.activityHistory = new ArrayList<>();
        this.goals = new ArrayList<>();
        this.id = generateUniqueId();
        this.totalCaloriesBurned = 0;
    }

    // New constructor with explicit ID
    public User(String id, String name, String email, String phoneNumber, String address, String password, 
                List<String> activityHistory, List<String> goals) {
        super(name, password);
        this.id = id;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.activityHistory = new ArrayList<>(activityHistory);
        this.goals = new ArrayList<>(goals);
        this.totalCaloriesBurned = 0;
        this.birthdate = null; // Default value if birthdate is not passed
    }

    // Existing methods remain unchanged
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
        try (PrintWriter writer = new PrintWriter(ID_FILE)) {
            writer.write(String.valueOf(id));
        }
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public List<String> getActivityHistory() {
        return activityHistory;
    }

    public void setActivityHistory(List<String> activityHistory) {
        this.activityHistory = activityHistory;
    }

    public List<String> getGoals() {
        return goals;
    }

    public void setGoals(List<String> goals) {
        this.goals = goals;
    }

    public void addActivity(String activity) {
        if (activity != null && !activity.isEmpty()) {
            activityHistory.add(activity);
        }
    }

    public void addGoal(String goal) {
        if (goal != null && !goal.isEmpty()) {
            goals.add(goal);
        }
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public KUDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(KUDate birthdate) {
		this.birthdate = birthdate;
	}

	public int getTotalCaloriesBurned() {
		return totalCaloriesBurned;
	}

	public void setTotalCaloriesBurned(int totalCaloriesBurned) {
		this.totalCaloriesBurned = totalCaloriesBurned;
	}

	public static String getIdFile() {
		return ID_FILE;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
