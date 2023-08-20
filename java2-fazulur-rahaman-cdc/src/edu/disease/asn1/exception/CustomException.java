package edu.disease.asn1.exception;

public class CustomException extends Exception {
    public CustomException() {
        super("A custom exception occurred.");
    }

    public CustomException(String message) {
        super(message);
    }
}

