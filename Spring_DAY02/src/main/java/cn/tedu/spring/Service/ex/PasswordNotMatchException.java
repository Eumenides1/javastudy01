package cn.tedu.spring.Service.ex;

/**
 * 密码不匹配的异常
 * @author Eumenides
 */
public class PasswordNotMatchException extends Exception{
    private static final long serialVersionUID = -647050505211910676L;

    public PasswordNotMatchException() {
        super();
    }

    public PasswordNotMatchException(String message) {
        super(message);
    }
}
