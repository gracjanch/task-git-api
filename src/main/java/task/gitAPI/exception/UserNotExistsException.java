package task.gitAPI.exception;

public class UserNotExistsException extends RuntimeException {

    public UserNotExistsException() {
        super("Wrong User name");
    }
}
