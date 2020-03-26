package ru.ifmo.cs.pb.lab5.command;

import ru.ifmo.cs.pb.lab5.Collection;
import ru.ifmo.cs.pb.lab5.csv.Delimiter;
import ru.ifmo.cs.pb.lab5.exception.io.InvalidArgumentException;
import ru.ifmo.cs.pb.lab5.object.Laboratory;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Save extends AbstractCommand {

    public Save() {

        this.name = "save";
        this.description = "save collection to file";
    }

    @Override
    public void execute(String[] args, Collection collection)
            throws InvalidArgumentException {

        if (args.length != 1) throw new InvalidArgumentException();

        String header = "id,name,coordinates_x,coordinates_y,creationDate,minimalPoint," +
                "personalQualitiesMinimum,tunedInWorks,difficulty,discipline_name," +
                "discipline_selfStudyHours,discipline_labsCount";

        String path = collection.getManager().getFile().getPath();
        String delimiter = Delimiter.getDelimiter(collection.getManager().getFile().getDelimiter());

        StringBuilder builder = new StringBuilder(header).append("\n");
        for (Laboratory laboratory : collection.getLaboratories()) {
            builder.append(laboratory.getId()).append(delimiter);
            builder.append(laboratory.getName()).append(delimiter);
            builder.append(laboratory.getCoordinates().getX()).append(delimiter);
            builder.append(laboratory.getCoordinates().getY()).append(delimiter);
            builder.append(laboratory.getCreationDate()).append(delimiter);
            builder.append(laboratory.getMinimalPoint()).append(delimiter);
            builder.append(laboratory.getPersonalQualitiesMinimum()).append(delimiter);
            builder.append(laboratory.getTunedInWorks()).append(delimiter);
            if (laboratory.getDifficulty() == null) builder.append(delimiter);
            else builder.append(laboratory.getDifficulty()).append(delimiter);
            builder.append(laboratory.getDiscipline().getName()).append(delimiter);
            if (laboratory.getDiscipline().getSelfStudyHours() == null) builder.append(delimiter);
            else builder.append(laboratory.getDiscipline().getSelfStudyHours()).append(delimiter);
            if (laboratory.getDiscipline().getLabsCount() == null) builder.append(delimiter);
            else builder.append(laboratory.getDiscipline().getLabsCount());
            builder.append("\n");
        }

        try {
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(path));
            stream.write(builder.toString().getBytes());
            stream.close();
            System.out.println("Collection successfully saved to the file.");
        } catch (IOException e) {
            System.out.println("Here a problem with saving collection to the file!");
        }
    }
}
