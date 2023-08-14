package ru.mikhailov.socialmedia.exception;

public class ConflictingRequestException extends RuntimeException {
    public ConflictingRequestException(String message) {
        super(message);
    }
}
