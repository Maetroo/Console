package ru.ifmo.cs.pb.lab5.command;

import ru.ifmo.cs.pb.lab5.Collection;
import ru.ifmo.cs.pb.lab5.exception.io.InvalidArgumentException;

public class Clear extends AbstractCommand {

    public Clear() {

        this.name = "clear";
        this.description = "clear collection";
    }

    @Override
    public void execute(String[] args, Collection collection)
            throws InvalidArgumentException {

        if (args.length != 1) throw new InvalidArgumentException();

        collection.getLaboratories().clear();

        System.out.println("Collection successfully cleared.");
    }
}
