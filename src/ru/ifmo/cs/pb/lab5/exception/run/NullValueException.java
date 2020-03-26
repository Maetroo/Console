package ru.ifmo.cs.pb.lab5.exception.run;

/**
 * @author Bobur Zakirov
 */
public class NullValueException extends RuntimeException {

    public NullValueException() { }

    public NullValueException(String field) {
        super("Null value in field: " + "\"" + field + "\"");
    }
}
