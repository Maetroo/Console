package ru.ifmo.cs.pb.lab5.command;

import ru.ifmo.cs.pb.lab5.Collection;
import ru.ifmo.cs.pb.lab5.exception.io.InvalidArgumentException;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Script extends AbstractCommand {

    public static Scanner file = new Scanner("");
    public static boolean empty = true;

    public Script() {

        this.name = "execute_script";
        this.description = "read and execute the script from the spe-" +
                           "\n                                       " +
                           "cified file, the script contains commands" +
                           "\n                                       " +
                           "in the same form in which they are entered" +
                           "\n                                       " +
                           "by the user interactively";
    }

    @Override
    public void execute(String[] args, Collection collection)
            throws InvalidArgumentException {

        if (args.length == 1) throw new InvalidArgumentException();

        try {

            Script.file = new Scanner(Paths.get(args[args.length-1]));
            Script.empty = false;

        } catch (IOException e) {

            System.out.println("File not found!");
        }
    }
}
