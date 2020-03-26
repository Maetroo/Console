package ru.ifmo.cs.pb.lab5;

import ru.ifmo.cs.pb.lab5.command.Script;
import ru.ifmo.cs.pb.lab5.exception.io.InvalidArgumentException;
import ru.ifmo.cs.pb.lab5.exception.io.NoCommandException;
import ru.ifmo.cs.pb.lab5.exception.io.NumberArgumentException;

import java.util.Scanner;

/**
 * The {@code Console} class is the basic class of application.
 *
 * @author  Bobur Zakirov
 * @since   2020-03-15
 */
public class Console {

    /** {@link Collection} - it's a basic object of application */

    private static Collection collection = new Collection(System.getenv("CSVFile"));

    /**
     * The {@code main()} method is the basic method of the class.
     * Current method was build for running work of the application.
     *
     * @param args      array of String
     */
    public static void main(String[] args) {

        String input;
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nPlease type 'help' to get information about available commands.");

        while (true) {

            System.out.print("\n@laboratory/console> ");

            if (Script.file.hasNextLine()) System.out.println(input = Script.file.nextLine());
            else {
                input = scanner.nextLine();
                Script.empty = true;
            }

            if (input.trim().equals("")) continue;

            try {
                Commander.execute(input.trim(), collection);
            } catch (NoCommandException e) {
                System.out.println("Could not find this command in list of available commands!");
            } catch (NumberArgumentException e) {
                System.out.println("Number of arguments might be zero (0) or one (1)!");
            } catch (InvalidArgumentException e) {
                System.out.println("Invalid format of argument or current command doesn't need it!");
            }
        }
    }
}
