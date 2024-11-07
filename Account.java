public class Account {
    private String name, id, password; 
    
    public Account(String name, String id, String password) {
        this.name = name;
        this.id = id;
        this.password = password;
    }

    public String getName(){return name;}
    public String getId(){return id;}
    public String getPassword(){return password;}

    public void setName(name){this.name = name;}
    public void setId(id){this.id = id;}
    public void setPassword(password){this.password = password;}
    
}
