package cn.tedu.store.service.ex;

public class UsernameNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 6812241203399644188L;

    public UsernameNotFoundException() {
        super();
    }

    public UsernameNotFoundException(String message) {
        super(message);
    }
}
