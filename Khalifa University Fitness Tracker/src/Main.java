import java.util.*;
import java.io.*;
import javax.swing.*;

public class Main extends JFrame {	
    protected static List<Account> users = new ArrayList<>();
    public static List<Account> getUsers(){return users;}
	public static int idx;
	public static boolean checked;

	private static void redirectToPage() {
		if (checked) {
			if (idx == 0) {
				UserPage userPage = new UserPage();
				userPage.pack();
				userPage.setLocationRelativeTo(null);
				userPage.setVisible(true);
			} else {
				// AdminPage adminPage = new AdminPage();
				// adminPage.pack();
				// adminPage.setLocationRelativeTo(null);
				// adminPage.setVisible(true);
			}
		}
	}

	public static void saveUsers() throws IOException {
		PrintWriter fout = new PrintWriter("Users.txt");
		for(Account user: users){
			fout.printf("%s %s %s %d %d %d %s %s%n", ((User)user).getName(), ((User)user).getEmail(), ((User)user).getPassword(), ((User)user).getBirthdate().getDay(), ((User)user).getBirthdate().getMonth(), ((User)user).getBirthdate().getYear(), ((User)user).getPhoneNumber(), ((User)user).getAddress());
		}
		fout.close();
	}

	public static void loadUsers() throws IOException {
		Scanner fin = new Scanner(new FileReader("Users.txt"));
		while(fin.hasNextLine()){
			Scanner line = new Scanner(fin.nextLine());
			String name = line.next();
			String email = line.next();
			String pass = line.next();
			int day = Integer.parseInt(line.next());
			int month = Integer.parseInt(line.next());
			int year = Integer.parseInt(line.next());
			String phone = line.next();
			String address = line.next();
			User newUser = new User(name, email, pass, new Date(day, month, year), phone, address);
			users.add(newUser);
			line.close();
		}
		fin.close();
	}

	public static void main(String[] args) throws IOException {
		loadUsers();
		SignIn SignInFrame = new SignIn();
		SignInFrame.pack();
		SignInFrame.setLocationRelativeTo(null); 
		saveUsers();
		redirectToPage();	
	}
    
}
