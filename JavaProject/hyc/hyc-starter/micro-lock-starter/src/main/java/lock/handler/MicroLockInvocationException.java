package lock.handler;

/**
 * @author wanglaomo
 * @since 2019/4/16
 **/
public class MicroLockInvocationException extends RuntimeException {

    public MicroLockInvocationException() {
    }

    public MicroLockInvocationException(String message) {
        super(message);
    }

    public MicroLockInvocationException(String message, Throwable cause) {
        super(message, cause);
    }
}
