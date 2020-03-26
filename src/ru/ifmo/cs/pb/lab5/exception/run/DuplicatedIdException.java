package ru.ifmo.cs.pb.lab5.exception.run;

/**
 * @author Bobur Zakirov
 */
public class DuplicatedIdException extends RuntimeException {

    public DuplicatedIdException() { }

    public DuplicatedIdException(String id) {
        super("For duplicated 'id': " + id);
    }
}
