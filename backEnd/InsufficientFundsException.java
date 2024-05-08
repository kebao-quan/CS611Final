/**
 * InsufficientFundsException is thrown when a user tries to withdraw more money than they have in their account.
 */

package backEnd;
public class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }

    public InsufficientFundsException(String message, Throwable cause) {
        super(message, cause);
    }

    public InsufficientFundsException(Throwable cause) {
        super(cause);
    }

    public InsufficientFundsException() {
        super();
    }
}
