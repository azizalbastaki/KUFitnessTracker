import java.util.*;
import javax.swing.*;

public class Main extends JFrame {
    protected static List<Account> users = new ArrayList<>();

    public static List<Account> getUsers() {
        return users;
    }

    public static int idx;
    public static boolean checked;

    // // Save users, activities, and goals to a file
	// public static void saveUsers() {
	// 	try (PrintWriter fout = new PrintWriter(new FileWriter("Users.txt"))) {
	// 		for (Account user : users) {
	// 			fout.println(user.toString());

	// 			// Save Activities
	// 			for (Activity activity : ((User) user).getActivities()) {
	// 				fout.println("START_ACTIVITY");
	// 				fout.println(activity.toString()); // Uses Activity's toString method
	// 				fout.println("END_ACTIVITY");
	// 			}

	// 			// Save Goals
	// 			for (Goal goal : ((User) user).getGoals()) {
	// 				fout.println("START_GOAL");
	// 				fout.println(goal.toString()); // Uses Goal's toString method
	// 				fout.println("END_GOAL");
	// 			}
	// 			fout.println("END_USER");
	// 		}
	// 	} catch (IOException e) {
	// 		JOptionPane.showMessageDialog(null, "Error saving user data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	// 	}
	// }

    // // Load users, activities, and goals from a file
	// public static void loadUsers() {
	// 	File file = new File("Users.txt");
	// 	if (!file.exists() || file.length() == 0) {
	// 		initializeAdminAccount();
	// 		return;
	// 	}

	// 	try (Scanner fin = new Scanner(file)) {
	// 		User currentUser = null;
	// 		List<String> userLines = new ArrayList<>();
	// 		String line;

	// 		while (fin.hasNextLine()) {
	// 			line = fin.nextLine();

	// 			if (line.equals("START_USER")) {
	// 				userLines = new ArrayList<>();
	// 			} else if (line.equals("END_USER")) {
	// 				// Convert user lines to a User object and add to users list
	// 				users.add(User.fromString(userLines));
	// 			} else if (line.equals("START_GOAL")) {
	// 				// Start reading goal data
	// 				List<String> goalData = new ArrayList<>();
	// 				while (!(line = fin.nextLine()).equals("END_GOAL")) {
	// 					goalData.add(line);
	// 				}
	// 				if (currentUser != null) {
	// 					Goal goal = Goal.fromString(goalData.toArray(new String[0]));
	// 					currentUser.addGoal(goal);
	// 				}
	// 			} else if (line.equals("START_ACTIVITY")) {
	// 				// Start reading activity data
	// 				while (!(line = fin.nextLine()).equals("END_ACTIVITY")) {
	// 					Activity activity = Activity.fromString(line);
	// 					if (currentUser != null) {
	// 						currentUser.addActivity(activity);
	// 					}
	// 				}
	// 			} else {
	// 				userLines.add(line);
	// 			}
	// 		}
	// 	} catch (IOException | NumberFormatException e) {
	// 		JOptionPane.showMessageDialog(null, "Error loading user data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	// 	}
	// }

    // // Initialize the default admin account
    // private static void initializeAdminAccount() {
    //     Admin admin = new Admin("admin", "admin2024");
    //     JOptionPane.showMessageDialog(null, "Default admin account created (username: admin, password: admin2024).",
    //             "Info", JOptionPane.INFORMATION_MESSAGE);
    // }

    // private static void redirectToPage() {
    //     if (checked) {
    //         if (idx == 0) {
    //             UserPage userPage = new UserPage();
    //             userPage.pack();
    //             userPage.setLocationRelativeTo(null);
    //             userPage.setVisible(true);
    //         } else {
    //             // Uncomment for admin functionality
    //             // AdminPage adminPage = new AdminPage();
    //             // adminPage.pack();
    //             // adminPage.setLocationRelativeTo(null);
    //             // adminPage.setVisible(true);
    //         }
    //     }
    // }

    public static void main(String[] args) {
		users = Database.loadUsers(); // No exception is propagated here
		SignIn signInFrame = new SignIn();
		signInFrame.pack();
		signInFrame.setLocationRelativeTo(null);
		signInFrame.setVisible(true);
		// Database.saveUsers(users);
        // System.out.println("Application data saved successfully."); // Exception is handled internally
		// redirectToPage(); // No IOException thrown here
		// Database.saveUsers(users);
		System.out.println("Loading Activities: " + ((User) users.get(0)).getActivities());
		System.out.println("Loading Goals: " + ((User) users.get(0)).getGoals());
	}	
}
