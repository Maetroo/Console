package ru.ifmo.cs.pb.lab5.command;

import ru.ifmo.cs.pb.lab5.Collection;
import ru.ifmo.cs.pb.lab5.exception.io.InvalidArgumentException;

public class RemoveByID extends AbstractCommand {

    public RemoveByID() {

        this.name = "remove_by_id";
        this.description = "remove an element from  the collection by" +
                           "\n                                       " +
                           "its 'id'";
    }

    @Override
    public void execute(String[] args, Collection collection)
            throws InvalidArgumentException {

        Long ID;

        try {
            ID = Long.parseLong(args[args.length-1]);

        } catch (NumberFormatException e) {
            throw new InvalidArgumentException();
        }

        int size = collection.getLaboratories().size();

        for (int i = 0; i < collection.getLaboratories().size(); i ++)
            if (ID.equals(collection.getLaboratories().get(i).getId()))
                collection.getLaboratories().remove(i);

        if (size == 0) System.out.println("Collection is empty!");

        else if (size - 1 == collection.getLaboratories().size())
            System.out.println("Successfully removed element of collection, " +
                    "whose 'id' = " + ID + ".");

        else System.out.println("Doesn't exist element in the collection, " +
                    "whose 'id' = " + ID + ".");

    }
}
