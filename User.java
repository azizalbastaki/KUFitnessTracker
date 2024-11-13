import java.util.*;
import java.io.*;

public class User extends Account {

    private String email;
    private Date birthdate;
    private int phoneNumber;
    private List<Activity> activities = new ArrayList<>();
    private List<Goal> goals = new ArrayList<>();
    
    public User(String name, String id, String password, Date birthdate, int phoneNumber, String email, Activity[] activities, Goal[] goals) {
        super(name, id, password);
        this.birthdate = birthdate;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.activities = new ArrayList<>(Arrays.asList(activities));
        this.goals = new ArrayList<>(Arrays.asList(goals));
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
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
}
