package ru.ifmo.cs.pb.lab5.command;

import ru.ifmo.cs.pb.lab5.Collection;
import ru.ifmo.cs.pb.lab5.exception.io.InvalidArgumentException;

public class Exit extends AbstractCommand {

    public Exit() {

        this.name = "exit";
        this.description = "terminate  the program (without saving to" +
                           "\n                                       " +
                           "a file)";
    }

    @Override
    public void execute(String[] args, Collection collection)
            throws InvalidArgumentException {

        if (args.length != 1) throw new InvalidArgumentException();

        System.exit(0);
    }
}
