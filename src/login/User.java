
package login;

/**
 * This class is modelling the user. We can have an object
 * that encapsulates everything that has to do with the user
 * The following code has been sourced from Amilcar Aponte
 * @
 */
public class User {
    
    private String un;
    private String pw;
    
    public User(String un, String pw){
        this.un = un;
        this.pw = pw;
    }

    public String getUn() {
        return un;
    }

    public String getPw() {
        return pw;
    }
    
}
