package ch.bissbert.battleSim.exception;

public class OutOfRangeException extends RuntimeException {
    public OutOfRangeException(double range) {
        super("the range " + range + " is not a valid value");
    }
}
