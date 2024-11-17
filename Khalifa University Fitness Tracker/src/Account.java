public class Account {
    private String name, id, password; 
    
    public Account(String name, String password) {
        this.name = name;
        this.password = password;
        id = "100064692";
    }

    public String getName(){return name;}
    public String getId(){return id;}
    public String getPassword(){return password;}

    public void setName(String name){this.name = name;}
    public void setPassword(String password){this.password = password;}
    
}