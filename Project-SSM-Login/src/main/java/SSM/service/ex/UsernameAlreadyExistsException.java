package SSM.service.ex;

public class UsernameAlreadyExistsException extends RuntimeException {


    private static final long serialVersionUID = -7123488998115344559L;

    public UsernameAlreadyExistsException(String s) {
        super(s);
    }

    public UsernameAlreadyExistsException() {
    }
}
