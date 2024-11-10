

public class Main {	
    protected static String[] emails = new String[20];
    protected static String[] passwords = new String[20];
    
    public static String[] getEmails(){return emails;}
    public static String[] getPasswords(){return passwords;}
	public static void main(String[] args) {

		SignIn SignInFrame = new SignIn();
        SignInFrame.pack();
		SignInFrame.setLocationRelativeTo(null); 
	}
		
    // public static void main(String[] args) {

    //     Login SignInFrame = new Login();
    //     SignInFrame.setVisible(true);
    //     SignInFrame.pack();
    //     SignInFrame.setLocationRelativeTo(null); 
    // }
    
}
