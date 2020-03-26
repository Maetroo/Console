package ru.ifmo.cs.pb.lab5.command;

import ru.ifmo.cs.pb.lab5.Collection;
import ru.ifmo.cs.pb.lab5.exception.io.InvalidArgumentException;
import ru.ifmo.cs.pb.lab5.object.Laboratory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrintMinimalPoint extends AbstractCommand {

    public PrintMinimalPoint() {

        this.name = "print_field_descending_minimal_point";
        this.description = "print  the 'minimalPoint' field values of" +
                           "\n                                       " +
                           "all elements in descending order";
    }

    @Override
    public void execute(String[] args, Collection collection)
            throws InvalidArgumentException {

        if (args.length != 1) throw new InvalidArgumentException();

        List<Float> list = new ArrayList<>();
        for (Laboratory laboratory : collection.getLaboratories())
            list.add(laboratory.getMinimalPoint());

        Collections.sort(list);

        for (int i = list.size() - 1; i >= 0; i --) System.out.println(list.get(i));
        if (list.size() == 0) System.out.println("Collection is empty!");
    }
}
