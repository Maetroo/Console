package ru.ifmo.cs.pb.lab5.exception.io;

import java.io.IOException;

/**
 * @author Bobur Zakirov
 */
public class InvalidArgumentException extends IOException {

    public InvalidArgumentException() { }

    public InvalidArgumentException(String message) {
        super(message);
    }
}
