package task.gitAPI.exception;

public class RepositoryNotExistsException extends RuntimeException {

    public RepositoryNotExistsException() {
        super("User don't have repository with this name");
    }
}
