public class Admin extends Account {
    private final String adminId = "1";

    // Constructors
    public Admin(String name, String password) {
        super(name, password);
    }

    // Method to set the status of a goal
    public void setGoalStatus(Goal goal, String status) {
        if (goal != null) {
            goal.setStatus(status);
            System.out.println("Goal status updated to: " + status);
        } else {
            System.out.println("Goal cannot be null.");
        }
    }

    // // Method to get a user by name
    // public User getUser(String name) {
    //     for (User user : Database.getUsers()) { // Assuming a static database class
    //         if (user.getName().equalsIgnoreCase(name)) {
    //             return user;
    //         }
    //     }
    //     System.out.println("User not found.");
    //     return null;
    // }

    // // Method to add a user
    // public void addUser(User user) {
    //     if (user != null) {
    //         Database.addUser(user); // Assuming a static database class
    //         System.out.println("User added successfully.");
    //     } else {
    //         System.out.println("User cannot be null.");
    //     }
    // }

    // // Method to delete a user
    // public void deleteUser(User user) {
    //     if (user != null) {
    //         Database.removeUser(user); // Assuming a static database class
    //         System.out.println("User deleted successfully.");
    //     } else {
    //         System.out.println("User cannot be null.");
    //     }
    // }

    // // Method to edit user details
    // public User editUser(User user) {
    //     if (user != null) {
    //         // Modify the user details (example: changing the name)
    //         user.setName(user.getName() + "_updated");
    //         System.out.println("User details updated.");
    //         return user;
    //     } else {
    //         System.out.println("User cannot be null.");
    //         return null;
    //     }
    // }

    // // Method to view an activity
    // public String viewActivity(Activity activity) {
    //     if (activity != null) {
    //         return activity.toString();
    //     } else {
    //         return "Activity not found.";
    //     }
    // }

    // // Method to add a goal to a user
    // public void addGoal(Goal goal, User user) {
    //     if (user != null && goal != null) {
    //         user.addGoal(goal);
    //         System.out.println("Goal added successfully.");
    //     } else {
    //         System.out.println("User or Goal cannot be null.");
    //     }
    // }

    // // Method to add an activity to a user
    // public void addActivity(Activity activity, User user) {
    //     if (user != null && activity != null) {
    //         user.addActivity(activity);
    //         System.out.println("Activity added successfully.");
    //     } else {
    //         System.out.println("User or Activity cannot be null.");
    //     }
    // }

    // // Method to delete an activity
    // public void deleteActivity(Activity activity) {
    //     if (activity != null) {
    //         Database.removeActivity(activity); // Assuming a static database class
    //         System.out.println("Activity deleted successfully.");
    //     } else {
    //         System.out.println("Activity cannot be null.");
    //     }
    // }

    // // Method to delete a goal
    // public void deleteGoal(Goal goal) {
    //     if (goal != null) {
    //         Database.removeGoal(goal); // Assuming a static database class
    //         System.out.println("Goal deleted successfully.");
    //     } else {
    //         System.out.println("Goal cannot be null.");
    //     }
    // }

    // // Method to edit a goal
    // public Goal editGoal(Goal goal) {
    //     if (goal != null) {
    //         // Example: Update the description
    //         goal.setGoalDescription(goal.getGoalDescription() + " (edited)");
    //         System.out.println("Goal edited successfully.");
    //         return goal;
    //     } else {
    //         System.out.println("Goal cannot be null.");
    //         return null;
    //     }
    // }

    // // Method to edit an activity
    // public Activity editActivity(Activity activity) {
    //     if (activity != null) {
    //         // Example: Update the activity details
    //         activity.setName(activity.getName() + " (edited)");
    //         System.out.println("Activity edited successfully.");
    //         return activity;
    //     } else {
    //         System.out.println("Activity cannot be null.");
    //         return null;
    //     }
}