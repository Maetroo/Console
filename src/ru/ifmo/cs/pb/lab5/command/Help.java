package ru.ifmo.cs.pb.lab5.command;

import ru.ifmo.cs.pb.lab5.Collection;
import ru.ifmo.cs.pb.lab5.Commander;
import ru.ifmo.cs.pb.lab5.exception.io.InvalidArgumentException;

import java.util.List;

public class Help extends AbstractCommand {

    public Help() {

        this.name = "help";
        this.description = "display help for available commands";
    }

    @Override
    public void execute(String[] args, Collection collection)
            throws InvalidArgumentException {

        if (args.length != 1) throw new InvalidArgumentException();

        List<AbstractCommand> commands = Commander.getAvailableCommands();

        for (AbstractCommand command : commands)
            System.out.printf("%-36s - %s.\n", command.name, command.description);
    }
}
