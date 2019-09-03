package cn.tedu.spring.Service.ex;

/**
 * @author Eumenides
 */
public class UserNameNotExistsException extends Exception {

    private static final long serialVersionUID = -6988322946619592229L;

    public UserNameNotExistsException() {
        super();
    }

    public UserNameNotExistsException(String message) {
        super(message);
    }
}
