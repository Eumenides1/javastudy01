package cn.tedu.store.service.ex;

public class UsernameAlreadyExistsException extends RuntimeException {

    private static final long serialVersionUID = -2598961330632073367L;

    public UsernameAlreadyExistsException() {
        super();
    }

    public UsernameAlreadyExistsException(String message) {
        super(message);
    }
}

