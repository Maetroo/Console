package ru.ifmo.cs.pb.lab5.command;

import ru.ifmo.cs.pb.lab5.Collection;
import ru.ifmo.cs.pb.lab5.exception.io.InvalidArgumentException;
import ru.ifmo.cs.pb.lab5.exception.run.DifficultyParseException;
import ru.ifmo.cs.pb.lab5.object.Difficulty;
import ru.ifmo.cs.pb.lab5.object.Laboratory;

public class FilterGreaterDifficulty extends AbstractCommand {

    public FilterGreaterDifficulty() {

        this.name = "filter_greater_than_difficulty";
        this.description = "display  elements,  whose  'difficulty' " +
                           "\n                                       " +
                           "field value isgreater than the given";
    }

    @Override
    public void execute(String[] args, Collection collection)
            throws InvalidArgumentException {

        Difficulty difficulty;

        try {
            difficulty = Difficulty.parseDifficulty(args[args.length - 1]);

        } catch (DifficultyParseException e) {
            throw new InvalidArgumentException();
        }

        int iterator = 0;
        for (Laboratory laboratory : collection.getLaboratories()) {

            if (laboratory.getDifficulty() != null &&
                    Difficulty.getDifficultyMap.get(laboratory.getDifficulty())
                            .compareTo(Difficulty.getDifficultyMap.get(difficulty)) > 0){
                System.out.println(laboratory.toString());
                iterator ++;
            }
        }

        if (collection.getLaboratories().size() == 0)
            System.out.println("Collection is empty!");
        else if (iterator == 0)
            System.out.println("Could not find element, " +
                    "whose 'difficulty' value greater than entered!");
    }
}
