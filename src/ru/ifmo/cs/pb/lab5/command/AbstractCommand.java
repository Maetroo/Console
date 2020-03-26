package ru.ifmo.cs.pb.lab5.command;

import ru.ifmo.cs.pb.lab5.Collection;
import ru.ifmo.cs.pb.lab5.exception.io.InvalidArgumentException;

/**
 * The {@code AbstractCommand} abstract class of commands
 *
 * @author  Bobur Zakirov
 * @since   2020-03-15
 */
public abstract class AbstractCommand {

    /**
     * command name
     */
    protected String name;

    /**
     * information about command
     */
    protected String description;

    /**
     * The {@code execute()} method executes command
     *
     * @param args          arguments
     * @param collection    collection
     * @throws              InvalidArgumentException if incorrect format in argument
     */
    public abstract void execute(String[] args, Collection collection)
            throws InvalidArgumentException;

    /**
     * Getter
     *
     * @return      name of current command (String)
     */
    public String getName() { return name; }
}
