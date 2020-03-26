package ru.ifmo.cs.pb.lab5.command;

import ru.ifmo.cs.pb.lab5.Collection;
import ru.ifmo.cs.pb.lab5.exception.io.InvalidArgumentException;
import ru.ifmo.cs.pb.lab5.exception.run.DifficultyParseException;
import ru.ifmo.cs.pb.lab5.object.Coordinates;
import ru.ifmo.cs.pb.lab5.object.Difficulty;
import ru.ifmo.cs.pb.lab5.object.Discipline;
import ru.ifmo.cs.pb.lab5.object.Laboratory;

import java.time.LocalDate;
import java.util.Scanner;

public class AddIfMin extends AbstractCommand {

    private Scanner scanner = new Scanner(System.in);

    public AddIfMin() {

        this.name = "add_if_min";
        this.description = "add a new  element to the  collection, if" +
                           "\n                                       " +
                           "it's value is less than from the value of" +
                           "\n                                       " +
                           "smallest element in this collection";
    }

    @Override
    public void execute(String[] args, Collection collection)
            throws InvalidArgumentException {

        if (args.length != 1) throw new InvalidArgumentException();

        String input;
        boolean success = true;

        Laboratory laboratory = new Laboratory();
        Coordinates coordinates = new Coordinates();
        Discipline discipline = new Discipline();

        laboratory.setId(collection.findUniqueID());
        laboratory.setCreationDate(LocalDate.now());

        while (success) {

            if (Script.empty) System.out.print("Enter 'Name': ");
            if ((input = getLine()) == null) success = false;

            if (input != null && input.equals("")) {
                if(Script.empty) System.out.println("INCORRECT! Name cannot be null!\n");
                continue;
            }
            laboratory.setName(input);
            break;
        }

        while (success) {

            if (Script.empty) System.out.print("Enter 'Coordinates X'(long <= 547): ");
            if ((input = getLine()) == null) success = false;

            try {
                if (input != null) coordinates.setX(Long.parseLong(input));
                if (coordinates.getX() > 547) throw new NumberFormatException();
                break;
            } catch (NumberFormatException e) {
                if (Script.empty) System.out.println("INCORRECT! Please enter long number not greater than 547!\n");
            }
        }

        while (success) {

            if (Script.empty) System.out.print("Enter 'Coordinates Y'(double > -583): ");
            if ((input = getLine()) == null) success = false;

            try {
                if (input != null) coordinates.setY(Double.parseDouble(input));
                if (coordinates.getY() <= -583) throw new NumberFormatException();
                break;
            } catch (NumberFormatException e) {
                if (Script.empty) System.out.println("INCORRECT! Please enter double number greater than -583!\n");
            }
        }

        while (success) {

            if (Script.empty) System.out.print("Enter 'Minimal Point'(Float > 0): ");
            if ((input = getLine()) == null) success = false;

            try {
                if (input != null) laboratory.setMinimalPoint(Float.parseFloat(input));
                if (laboratory.getMinimalPoint() <= 0) throw new NumberFormatException();
                break;
            } catch (NumberFormatException e) {
                if (Script.empty) System.out.println("INCORRECT! Please enter positive Float number!\n");
            }
        }

        while (success) {

            if (Script.empty) System.out.print("Enter 'Personal Qualities Minimum'(Double > 0): ");
            if ((input = getLine()) == null) success = false;

            try {
                if (input != null) laboratory.setPersonalQualitiesMinimum(Double.parseDouble(input));
                if (laboratory.getPersonalQualitiesMinimum() <= 0) throw new NumberFormatException();
                break;
            } catch (NumberFormatException e) {
                if (Script.empty) System.out.println("INCORRECT! Please enter positive Double number!\n");
            }
        }

        while (success) {

            if (Script.empty) System.out.print("Enter 'Tuned In Works'(Integer): ");
            if ((input = getLine()) == null) success = false;

            try {
                if (input != null) laboratory.setTunedInWorks(Integer.parseInt(input));
                break;
            } catch (NumberFormatException e) {
                if (Script.empty) System.out.println("INCORRECT! Please enter Integer number!\n");
            }
        }

        while (success) {

            if (Script.empty) System.out.print("Enter 'Difficulty'(VERY_EASY, NORMAL, HARD, IMPOSSIBLE, TERRIBLE): ");
            if ((input = getLine()) == null) success = false;

            try {
                if (input != null && !input.equals("")) laboratory.setDifficulty(Difficulty.parseDifficulty(input));
                break;
            } catch (DifficultyParseException e) {
                if (Script.empty) System.out.println("INCORRECT! Please enter Difficulty type or click 'ENTER'!\n");
            }
        }

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

        laboratory.setCoordinates(coordinates);
        laboratory.setDiscipline(discipline);

        if (!Script.empty && !success) {

            System.out.println("Command failed!");

        } else {

            boolean done = true;
            int size = collection.getLaboratories().size();

            for (int i = collection.getLaboratories().size() - 1; i >= 0; i --)
                if (laboratory.compareTo(collection.getLaboratories().get(i)) >= 0)
                    done = false;

            if (done) collection.getLaboratories().add(laboratory);

            if (size < collection.getLaboratories().size())
                System.out.println("Successfully added new element to the collection.");
            else
                System.out.println("Entered element isn't lower than elements of the collection!");
        }

    }

    private String getLine() {

        if (Script.empty) return this.scanner.nextLine().trim();
        else if (Script.file.hasNextLine()) return Script.file.nextLine().trim();
        else return null;
    }
}
