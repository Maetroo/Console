package ru.ifmo.cs.pb.lab5.command;

import ru.ifmo.cs.pb.lab5.Collection;
import ru.ifmo.cs.pb.lab5.exception.io.InvalidArgumentException;
import ru.ifmo.cs.pb.lab5.object.Discipline;
import ru.ifmo.cs.pb.lab5.object.Laboratory;

import java.util.Scanner;

public class FilterLessDiscipline extends AbstractCommand {

    private Scanner scanner = new Scanner(System.in);

    public FilterLessDiscipline() {

        this.name = "filter_less_than_discipline";
        this.description = "display   elements ,  whose  'discipline'" +
                           "\n                                       " +
                           "field value is less than the given";
    }

    @Override
    public void execute(String[] args, Collection collection)
            throws InvalidArgumentException {

        if (args.length != 1) throw new InvalidArgumentException();

        String input;
        boolean success = true;

        Discipline discipline = new Discipline();

        while (success) {

            if (Script.empty) System.out.print("Enter 'Discipline Name': ");
            if ((input = getLine()) == null) success = false;

            if (input != null && input.equals("")) {
                if(Script.empty) System.out.println("INCORRECT! Name cannot be null!\n");
                continue;
            }
            discipline.setName(input);
            break;
        }

        while (success) {

            if (Script.empty) System.out.print("Enter 'Discipline Self Study Hours'(Integer or null): ");
            if ((input = getLine()) == null) success = false;

            try {
                if (input != null && !input.equals("")) discipline.setSelfStudyHours(Integer.parseInt(input));
                break;
            } catch (NumberFormatException e) {
                if (Script.empty) System.out.println("INCORRECT! Please enter Integer number or click 'ENTER'!\n");
            }
        }

        while (success) {

            if (Script.empty) System.out.print("Enter 'Discipline Labs Count'(Long or null): ");
            if ((input = getLine()) == null) success = false;

            try {
                if (input != null && !input.equals("")) discipline.setLabsCount(Long.parseLong(input));
                break;
            } catch (NumberFormatException e) {
                if (Script.empty) System.out.println("INCORRECT! Please enter Long number or click 'ENTER'!\n");
            }
        }

        if (!Script.empty && !success) {

            System.out.println("Command failed!");

        } else {

            int iterator = 0;
            for (Laboratory laboratory : collection.getLaboratories())
                if (discipline.compareTo(laboratory.getDiscipline()) > 0){
                    System.out.println(laboratory.toString());
                    iterator ++;
                }

            if (collection.getLaboratories().size() == 0) System.out.println("Collection is empty!");
            else if (iterator == 0) System.out.println("Could not find element, whose 'discipline' value less than entered!");
        }
    }

    private String getLine() {

        if (Script.empty) return this.scanner.nextLine().trim();
        else if (Script.file.hasNextLine()) return Script.file.nextLine().trim();
        else return null;
    }
}
