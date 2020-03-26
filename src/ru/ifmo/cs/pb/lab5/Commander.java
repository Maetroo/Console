package ru.ifmo.cs.pb.lab5;

import ru.ifmo.cs.pb.lab5.command.*;
import ru.ifmo.cs.pb.lab5.exception.io.InvalidArgumentException;
import ru.ifmo.cs.pb.lab5.exception.io.NoCommandException;
import ru.ifmo.cs.pb.lab5.exception.io.NumberArgumentException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * The {@code Commander} class contains all available commands.
 * It helps to searching a necessary command with a typed user.
 *
 * @author  Bobur Zakirov
 * @since   2020-03-15
 */
public class Commander {

    /**
     * Static method to keeping available commands in application.
     */
    private static Map<String, AbstractCommand> availableCommands = new HashMap<String, AbstractCommand>() {
        {
            put(new Add());
            put(new AddIfMin());
            put(new Clear());
            put(new Exit());
            put(new FilterGreaterDifficulty());
            put(new FilterLessDiscipline());
            put(new Help());
            put(new Info());
            put(new PrintMinimalPoint());
            put(new RemoveByID());
            put(new RemoveFirst());
            put(new RemoveLower());
            put(new Save());
            put(new Script());
            put(new Show());
            put(new UpdateID());
        }

        private void put(AbstractCommand command) {
            put(command.getName(), command);
        }
    };

    /**
     * The {@code execute()} method helps to analysis typings of user
     * and to executing necessary command.
     *
     * @param input         user input
     * @param collection    collection {@link Collection}
     * @throws              NoCommandException if command does not exist
     * @throws              NumberArgumentException if number of arguments greater than 1
     * @throws              InvalidArgumentException if incorrect type of argument
     */
    public static void execute(String input, Collection collection)
            throws NoCommandException, NumberArgumentException, InvalidArgumentException {

        String[] get = input.split(" ");

        if (!(availableCommands.containsKey(get[0].toLowerCase())))
            throw new NoCommandException();

        int counter = -1;
        for (String arg : get) if (!arg.trim().equals("")) counter ++;

        if (counter != 0 && counter != 1)
            throw new NumberArgumentException();

        Commander.availableCommands.get(get[0].toLowerCase()).execute(get, collection);
    }

    /**
     * Getter
     *
     * @return          {@link ArrayList} of {@code AbstractCommand} class
     */
    public static ArrayList<AbstractCommand> getAvailableCommands() {
        return new ArrayList<>(availableCommands.values());
    }
}
