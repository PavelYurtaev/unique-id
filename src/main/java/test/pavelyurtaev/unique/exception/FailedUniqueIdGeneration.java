package test.pavelyurtaev.unique.exception;

public class FailedUniqueIdGeneration extends RuntimeException {

    public FailedUniqueIdGeneration(final String message) {
        super(message);
    }

}
