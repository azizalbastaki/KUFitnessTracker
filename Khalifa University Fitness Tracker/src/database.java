import java.io.FileNotFoundException;
import java.util.*;
import java.io.*;

public class database {
    private ArrayList<User> users;

    public database() throws FileNotFoundException {
        users = new ArrayList<User>();
        Scanner scanner = new Scanner(new FileReader("userbase.txt"));
        int currentID = 0;
        while (scanner.hasNextLine()) {
            String entry = scanner.nextLine();
            String name = getElementFromLine(entry, 2);
            String email = getElementFromLine(entry, 3);
            String password = getElementFromLine(entry, 4);
            KUDate userBD = new KUDate(getElementFromLine(entry, 5));
            String pNumber = getElementFromLine(entry, 6);
            String address = getElementFromLine(entry, 7);
            int totalBurned = Integer.parseInt(getElementFromLine(entry, 8));
            String userID = Integer.toString(currentID);
            users.add(new User(userID, name, email, password, userBD, pNumber, address));
        }
        scanner.close();
    }

    private String getElementFromLine(String line, int number) {
        int currentCount = 0;
        String currentString = "";
        int currentIndex = 0;
        while (currentCount != number) {
            if (line.charAt(currentIndex) == '|') {
                currentCount++;
                if (currentCount != number) {
                    currentString = "";
                }
            } else {
                currentString = currentString + line.charAt(currentIndex);
            }
            currentIndex++;
        }
        return currentString;
    }
    public void update_file() throws FileNotFoundException {
        PrintWriter writer = new PrintWriter("userbase.txt");
        for (User user : users) {
            writer.println(user.toString());
        }
        writer.close();
    }

    public void addUser(User user) throws FileNotFoundException {
        users.add(user);
        update_file();
    }
    // TODO: addUser methods with string parameters, method will instantiate a user object itself.

    public User getUserById(String userId) {
        for (User user : users) {
            if (user.getId().equals(userId)) {
                return user;
            }
        }
        return null; 
    }

    public void deleteUser(String userId) throws FileNotFoundException {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(userId)) {
                users.remove(i);
                update_file();
                return;
            }
        }
    }
}
