package ru.ifmo.cs.pb.lab5.exception.run;

/**
 * @author Bobur Zakirov
 */
public class DifficultyParseException extends RuntimeException {

    public DifficultyParseException() { }

    public DifficultyParseException(String input) {
        super("For input string: " + "\"" + input + "\"");
    }
}
