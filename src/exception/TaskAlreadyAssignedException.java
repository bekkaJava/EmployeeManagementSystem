package exception;

public class TaskAlreadyAssignedException extends RuntimeException {

    public TaskAlreadyAssignedException(String message) {
        super(message);
    }
}
