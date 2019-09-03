package cn.tedu.spring.Service.ex;

/**
 * @author Eumenides
 */
public class UsernameAlreadyExistsException extends Exception {

    private static final long serialVersionUID = 6271490380979397621L;

    public UsernameAlreadyExistsException() {
        super();
    }

    public UsernameAlreadyExistsException(String message) {
        super(message);
    }
}
