package ru.ifmo.cs.pb.lab5.exception.io;

import java.io.IOException;

/**
 * @author Bobur Zakirov
 */
public class NoCommandException extends IOException {

    public NoCommandException() { }

    public NoCommandException(String message) {
        super(message);
    }
}
