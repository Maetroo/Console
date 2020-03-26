package ru.ifmo.cs.pb.lab5.exception.io;

import java.io.IOException;

/**
 * @author Bobur Zakirov
 */
public class NumberArgumentException extends IOException {
    
    public NumberArgumentException() { }

    public NumberArgumentException(String message) {
        super(message);
    }
}
