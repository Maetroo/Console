package ru.ifmo.cs.pb.lab5.exception.io;

import java.io.IOException;

/**
 * @author Bobur Zakirov
 */
public class EmptyFileException extends IOException {

    public EmptyFileException() { }

    public EmptyFileException(String message) {
        super(message);
    }
}
