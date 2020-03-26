package ru.ifmo.cs.pb.lab5.command;

import ru.ifmo.cs.pb.lab5.Collection;
import ru.ifmo.cs.pb.lab5.exception.io.InvalidArgumentException;
import ru.ifmo.cs.pb.lab5.object.Laboratory;

public class Show extends AbstractCommand {

    public Show() {

        this.name = "show";
        this.description = "output  to  the  standard  output  stream" +
                           "\n                                       " +
                           "all the elements of  the collection  in a" +
                           "\n                                       " +
                           "string representation";
    }

    @Override
    public void execute(String[] args, Collection collection)
            throws InvalidArgumentException {

        if (args.length != 1) throw new InvalidArgumentException();

        for (Laboratory laboratory : collection.getLaboratories())
            System.out.println(laboratory.toString());

        if (collection.getLaboratories().size() == 0)
            System.out.println("Collection is empty!");
    }
}
