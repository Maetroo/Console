package ru.ifmo.cs.pb.lab5.exception.run;

/**
 * @author Bobur Zakirov
 */
public class MinOrMaxOutException extends RuntimeException {
    
    public MinOrMaxOutException() { }

    public MinOrMaxOutException(String input) {
        super("For invalid value: " + input);
    }
}
