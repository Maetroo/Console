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

public class UpdateID extends AbstractCommand {

    private Scanner scanner = new Scanner(System.in);

    public UpdateID() {

        this.name = "update";
        this.description = "update the value of a collection element," +
                           "\n                                       " +
                           "whose 'id' is equal to the specified";
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

        Laboratory example = null;

        for (Laboratory laboratory : collection.getLaboratories())
            if (ID.equals(laboratory.getId())) example = laboratory;

        if (example != null) {

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
                    if (Script.empty) System.out.println("INCORRECT! Name cannot be null!\n");
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

                if (Script.empty)
                    System.out.print("Enter 'Difficulty'(VERY_EASY, NORMAL, HARD, IMPOSSIBLE, TERRIBLE): ");
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
                    if (Script.empty) System.out.println("INCORRECT! Name cannot be null!\n");
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

                example.setName(laboratory.getName());
                example.setCoordinates(laboratory.getCoordinates());
                example.setCreationDate(laboratory.getCreationDate());
                example.setMinimalPoint(laboratory.getMinimalPoint());
                example.setPersonalQualitiesMinimum(laboratory.getPersonalQualitiesMinimum());
                example.setTunedInWorks(laboratory.getTunedInWorks());
                example.setDifficulty(laboratory.getDifficulty());
                example.setDiscipline(laboratory.getDiscipline());

                System.out.println("Successfully update element, whose 'id' = " + ID + ".");
            }
        } else {
            if (collection.getLaboratories().size() == 0) System.out.println("Collection is empty!");
            else System.out.println("Could not find element in collection, whose 'id' = " + ID + "!");
        }
    }

    private String getLine() {

        if (Script.empty) return this.scanner.nextLine().trim();
        else if (Script.file.hasNextLine()) return Script.file.nextLine().trim();
        else return null;
    }
}
