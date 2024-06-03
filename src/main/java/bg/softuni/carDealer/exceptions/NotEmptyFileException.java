package bg.softuni.carDealer.exceptions;

public class NotEmptyFileException extends RuntimeException {
    private final String message = "The file is not empty";

    public NotEmptyFileException(String message) {
        super(message);
    }
}
