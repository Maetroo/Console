package ru.ifmo.cs.pb.lab5.command;

import ru.ifmo.cs.pb.lab5.Collection;
import ru.ifmo.cs.pb.lab5.exception.io.InvalidArgumentException;

public class RemoveFirst extends AbstractCommand {

    public RemoveFirst() {

        this.name = "remove_first";
        this.description = "remove the first element from the collec-" +
                           "\n                                       " +
                           "tion";
    }

    @Override
    public void execute(String[] args, Collection collection)
            throws InvalidArgumentException {

        if (args.length != 1) throw new InvalidArgumentException();

        if (collection.getLaboratories().size() != 0) {
            collection.getLaboratories().removeFirst();
            System.out.println("Successfully removed the first element from the collection.");
        } else System.out.println("Collection is empty!");
    }
}
