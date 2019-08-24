
package business.model;

import java.io.Serializable;

/**
 *
 * @author Renan Costa
 */
public class User implements Serializable {
    private String login;
    private String pass;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
}
