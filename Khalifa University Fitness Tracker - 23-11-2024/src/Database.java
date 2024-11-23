import java.io.*;
import java.util.*;

public class Database {

    private static final String USER_FILE = "Users.txt";

    // Save all users to a file
    public static void saveUsers(List<Account> users) {
        try (PrintWriter fout = new PrintWriter(new FileWriter(USER_FILE))) {
            for (Account user : users) {
                fout.println(serializeUser((User) user));
                fout.print("END_USER");
            }
            System.out.println("Users saved successfully to " + USER_FILE);
        } catch (IOException e) {
            System.err.println("Error saving users: " + e.getMessage());
        }
    }

    // Load all users from a file
    public static List<Account> loadUsers() {
        List<Account> users = new ArrayList<>();
        File file = new File(USER_FILE);

        // Check if the file exists
        if (!file.exists()) {
            System.out.println("User file not found. Starting with an empty user list.");
            return users;
        }

        try (Scanner fin = new Scanner(new FileReader(file))) {
            List<String> userLines = new ArrayList<>();
            while (fin.hasNextLine()) {
                String line = fin.nextLine();
                if (line.equals("END_USER")) {
                    users.add(deserializeUser(userLines));
                    userLines.clear();
                } else {
                    userLines.add(line);
                }
            }
            System.out.println("Users loaded successfully from " + USER_FILE);
        } catch (IOException e) {
            System.err.println("Error loading users: " + e.getMessage());
        }
        return users;
    }

    // Serialize a User object into a string representation
    private static String serializeUser(User user) {
        StringBuilder sb = new StringBuilder();
        sb.append("START_USER\n");
        sb.append("Name|").append(user.getName()).append("\n");
        sb.append("Email|").append(user.getEmail()).append("\n");
        sb.append("Password|").append(user.getPassword()).append("\n");
        sb.append("Birthdate|").append(user.getBirthdate().toString()).append("\n");
        sb.append("PhoneNumber|").append(user.getPhoneNumber()).append("\n");
        sb.append("Address|").append(user.getAddress()).append("\n");
    
        // Serialize Goals
        for (Goal goal : user.getGoals()) {
            sb.append("START_GOAL\n");
            sb.append(serializeGoal(goal));
            sb.append("\nEND_GOAL\n");
            System.out.println("Saving goal: " + goal.getGoalDescription()); // Debugging line
        }
    
        // Serialize Activities
        for (Activity activity : user.getActivities()) {
            sb.append("START_ACTIVITY\n");
            sb.append(serializeActivity(activity));
            sb.append("\nEND_ACTIVITY\n");
            System.out.println("Saving activity: " + activity.getName()); // Debugging line
        }
        return sb.toString();
    }
    

    // Deserialize a User object from a list of strings
    private static User deserializeUser(List<String> lines) {
        User user = new User();
        List<String> currentGoalData = null;
        List<String> currentActivityData = null;

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
                System.out.println(line);
            } else if (line.equals("START_GOAL")) {
                currentGoalData = new ArrayList<>();
                System.out.println(currentGoalData);
            } else if (line.equals("END_GOAL")) {
                if (currentGoalData != null) {
                    Goal goal = deserializeGoal(currentGoalData);
                    user.addGoal(goal);
                    currentGoalData = null;
                    System.out.println("Loaded goal: " + goal.getGoalDescription()); // Debugging line
                }
            } else if (line.equals("START_ACTIVITY")) {
                currentActivityData = new ArrayList<>();
            } else if (line.equals("END_ACTIVITY")) {
                if (currentActivityData != null) {
                    Activity activity = deserializeActivity(currentActivityData);
                    user.addActivity(activity);
                    currentActivityData = null;
                    System.out.println("Loaded activity: " + activity.getName()); // Debugging line
                }
            } else {
                // Collect the goal or activity data until END_GOAL or END_ACTIVITY is found
                if (currentGoalData != null) {
                    currentGoalData.add(line);
                    System.out.println(line);
                } else if (currentActivityData != null) {
                    currentActivityData.add(line);
                }
            }
        }
        return user;
    }


    // Serialize a Goal object
    private static String serializeGoal(Goal goal) {
        return String.format(
            "Description|%s\nTargetValue|%d\nProgress|%d\nStartDate|%s\nEndDate|%s\nStatus|%s",
            goal.getGoalDescription(), goal.getTargetValue(), goal.getProgress(),
            goal.getStartDate().toString(), goal.getEndDate().toString(), goal.getStatus()
        );
    }
    

    // Deserialize a Goal object
    private static Goal deserializeGoal(List<String> lines) {
        Map<String, String> goalData = new HashMap<>();
        for (String line : lines) {
            String[] parts = line.split("\\|", 2);
            if (parts.length == 2) {
                goalData.put(parts[0], parts[1]);
            }
        }
        return new Goal(
            goalData.get("Description"),
            Integer.parseInt(goalData.get("TargetValue")),
            Integer.parseInt(goalData.get("Progress")),
            KUDate.fromString(goalData.get("StartDate")),
            KUDate.fromString(goalData.get("EndDate")),
            goalData.get("Status")
        );
    }
    

    // Serialize an Activity object
    private static String serializeActivity(Activity activity) {
        return String.format(
            "Name|%s\nDuration|%s\nCaloriesBurned|%d\nActivityDate|%s\nTime|%s",
            activity.getName(), activity.getDuration(), activity.getCaloriesBurned(),
            activity.getActivityDate().toString(), activity.getTime()
        );
    }
    

    // Deserialize an Activity object
    private static Activity deserializeActivity(List<String> lines) {
        Map<String, String> activityData = new HashMap<>();
        for (String line : lines) {
            String[] parts = line.split("\\|", 2);
            if (parts.length == 2) {
                activityData.put(parts[0], parts[1]);
            }
        }
        System.out.println(activityData);
        return new Activity(
            activityData.get("Name"),
            Time.fromString(activityData.get("Duration")),  // Assuming Time.fromString is correct
            Integer.parseInt(activityData.get("CaloriesBurned")),
            KUDate.fromString(activityData.get("ActivityDate")),
            activityData.get("Time")
        );
    }    
}