import java.util.*;
import javax.swing.*;

public class Main extends JFrame {
    protected static List<User> users = new ArrayList<User>();

    public static List<User> getUsers() {
        return users;
    }

    public static int idx;
    public static boolean checked;

    public static void main(String[] args) {
		users = Database.loadUsers(); // No exception is propagated here
		SignIn signInFrame = new SignIn();
		signInFrame.pack();
		signInFrame.setLocationRelativeTo(null);
		signInFrame.setVisible(true);
        Database.saveUsers(users);
	}	
}
