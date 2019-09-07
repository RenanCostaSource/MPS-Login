package exceptions;

/**
 *
 * @author Renan Costa
 */
public class userSignInException extends Exception {
     public userSignInException(String errorMessage) {
        super(errorMessage);
    }
}
