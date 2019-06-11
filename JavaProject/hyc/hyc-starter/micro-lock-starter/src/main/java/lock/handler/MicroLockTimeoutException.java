package lock.handler;

/**
 * @author wanglaomo
 * @since 2019/4/16
 **/
public class MicroLockTimeoutException extends RuntimeException {

    public MicroLockTimeoutException() {
    }

    public MicroLockTimeoutException(String message) {
        super(message);
    }

    public MicroLockTimeoutException(String message, Throwable cause) {
        super(message, cause);
    }
}
