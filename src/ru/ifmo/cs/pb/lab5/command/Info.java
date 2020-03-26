package ru.ifmo.cs.pb.lab5.command;

import ru.ifmo.cs.pb.lab5.Collection;
import ru.ifmo.cs.pb.lab5.exception.io.InvalidArgumentException;

public class Info extends AbstractCommand {

    public Info() {

        this.name = "info";
        this.description = "display information  about the collection" +
                           "\n                                       " +
                           "(type, initialization date, number of ele-" +
                           "\n                                       " +
                           "ments, etc.) in the standard output stream";
    }

    @Override
    public void execute(String[] args, Collection collection) throws InvalidArgumentException {

        if (args.length != 1) throw new InvalidArgumentException();

        System.out.printf("%-36s - %s\n", "type of collection", collection.getLaboratories().getClass().getName());
        System.out.printf("%-36s - %s\n", "number of elements", collection.getLaboratories().size());
        System.out.printf("%-36s - %s\n", "initialization date" , collection.getInitializationDate());
    }
}
