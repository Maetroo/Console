package ru.ifmo.cs.pb.lab5.csv;

import ru.ifmo.cs.pb.lab5.exception.io.EmptyFileException;
import ru.ifmo.cs.pb.lab5.object.*;

import java.time.LocalDate;
import java.util.LinkedList;

/**
 * The {@code CSVManager} class converts data of file to collection
 *
 * @author  Bobur Zakirov
 * @since   2020-03-15
 */
public class CSVManager {

    /**
     * Needed .csv file
     */
    private CSVFile file;

    /**
     * Constructor
     *
     * @param file      .csv file
     */
    public CSVManager(CSVFile file) { this.file = file; }

    /**
     * The {@code getLaboratories()} method gets collections
     *
     * @return      collection of objects {@code Laboratory} class
     * @throws      EmptyFileException if file id empty
     */
    public LinkedList<Laboratory> getLaboratories() throws EmptyFileException {

        LinkedList<Laboratory> laboratories = new LinkedList<>();

        if (file.header == null) throw new EmptyFileException();
        if (file.body == null) return laboratories;

        for (String[] body : file.body)
            laboratories.add(this.getObject(file.header, body));

        return laboratories;
    }

    /**
     * The {@code getObject()} method converts to objects
     *
     * @param header        array of fields' names
     * @param body          array of values' names
     * @return              object of {@code Laboratories} class
     */
    private Laboratory getObject(String[] header, String[] body) {

        Laboratory laboratory = new Laboratory();
        Coordinates coordinates = new Coordinates();
        Discipline discipline = new Discipline();

        for (int i = 0, j = 0; i < header.length && j < body.length; i ++, j ++) {

            if (body[j].equals("")) continue;

            switch (header[i]) {

                case "id":                        laboratory.setId(Long.parseLong(body[j]));
                    break;
                case "name":                      laboratory.setName(String.valueOf(body[j]));
                    break;
                case "coordinates_x":             coordinates.setX(Long.parseLong(body[j]));
                    break;
                case "coordinates_y":             coordinates.setY(Double.parseDouble(body[j]));
                    break;
                case "creationDate":              laboratory.setCreationDate(LocalDate.parse(body[j]));
                    break;
                case "minimalPoint":              laboratory.setMinimalPoint(Float.parseFloat(body[j]));
                    break;
                case "personalQualitiesMinimum":  laboratory.setPersonalQualitiesMinimum(Double.parseDouble(body[j]));
                    break;
                case "tunedInWorks":              laboratory.setTunedInWorks(Integer.parseInt(body[j]));
                    break;
                case "difficulty":                laboratory.setDifficulty(Difficulty.parseDifficulty(body[j]));
                    break;
                case "discipline_name":           discipline.setName(String.valueOf(body[j]));
                    break;
                case "discipline_selfStudyHours": discipline.setSelfStudyHours(Integer.parseInt(body[j]));
                    break;
                case "discipline_labsCount":      discipline.setLabsCount(Long.parseLong(body[j]));
                    break;
            }
        }

        laboratory.setCoordinates(coordinates);
        laboratory.setDiscipline(discipline);

        return laboratory;
    }

    /**
     * Getter
     *
     * @return      object of {@code CSVFile} class
     */
    public CSVFile getFile() { return file; }
}
