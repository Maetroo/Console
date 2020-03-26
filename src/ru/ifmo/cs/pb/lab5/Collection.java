package ru.ifmo.cs.pb.lab5;

import ru.ifmo.cs.pb.lab5.csv.CSVFile;
import ru.ifmo.cs.pb.lab5.csv.CSVManager;
import ru.ifmo.cs.pb.lab5.exception.io.EmptyFileException;
import ru.ifmo.cs.pb.lab5.exception.run.DuplicatedIdException;
import ru.ifmo.cs.pb.lab5.exception.run.MinOrMaxOutException;
import ru.ifmo.cs.pb.lab5.exception.run.NullValueException;
import ru.ifmo.cs.pb.lab5.object.Laboratory;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * The {@code Collection} class works with collection.
 * It keeps collection, with type is {@link LinkedList} with
 * objects of {@code Laboratory} class.
 *
 * @author  Bobur Zakirov
 * @since   2020-03-15
 */
public class Collection {

    /**
     * Collection
     */
    private LinkedList<Laboratory> laboratories = new LinkedList<>();

    /**
     * Initialization Date of the collection
     */
    private LocalDate initializationDate = LocalDate.now();

    /**
     * Object of {@link CSVManager} class
     */
    private CSVManager manager;

    /**
     * Constructor
     *
     * @param path      it's a path to a needed .csv file
     */
    public Collection(final String path) {

        try {

            this.manager = new CSVManager(new CSVFile(path));
            for (Laboratory laboratory : (laboratories = this.manager.getLaboratories()))
                this.checkFields(laboratory);

        } catch (EmptyFileException e) {

            System.out.println("File is empty!");
            System.exit(0);

        } catch (IOException e) {

            System.out.println("File does not exist!");
            System.exit(0);

        }
        this.checkID();
    }

    /**
     * The {@code checkFields()} method checks fields of {@code Laboratory}
     * class.
     *
     * @param laboratory    object of {@code Laboratory} class
     */
    private void checkFields(Laboratory laboratory) {

        if (laboratory.getId() == null)
            throw new NullValueException("id");
        if (laboratory.getId() <= 0)
            throw new MinOrMaxOutException(String.valueOf(laboratory.getId()));
        if (laboratory.getName() == null)
            throw new NullValueException("name");
        if (laboratory.getCoordinates().getX() > 547)
            throw new MinOrMaxOutException(String.valueOf(laboratory.getCoordinates().getX()));
        if (laboratory.getCoordinates().getY() <= -583)
            throw new MinOrMaxOutException(String.valueOf(laboratory.getCoordinates().getY()));
        if (laboratory.getCreationDate() == null)
            throw new NullValueException("creationDate");
        if (laboratory.getMinimalPoint() == null)
            throw new NullValueException("minimalPoint");
        if (laboratory.getMinimalPoint() <= 0)
            throw new MinOrMaxOutException(String.valueOf(laboratory.getMinimalPoint()));
        if (laboratory.getPersonalQualitiesMinimum() == null)
            throw new NullValueException("personalQualitiesMinimum");
        if (laboratory.getPersonalQualitiesMinimum() <= 0)
            throw new MinOrMaxOutException(String.valueOf(laboratory.getPersonalQualitiesMinimum()));
        if (laboratory.getTunedInWorks() == null)
            throw new NullValueException("tunedInWorks");
        if (laboratory.getDiscipline().getName() == null)
            throw new NullValueException("discipline_name");
    }

    /**
     * The {@code checkID()} method checks IDs elements of the collection,
     * if he'll find the equal ids throws DuplicatedIdException.
     *
     * @throws DuplicatedIdException    if here in the collection two element with equal IDs
     */
    private void checkID() throws DuplicatedIdException {

        int i = 0;
        Set<Long> IDs = new HashSet<>();

        for (Laboratory laboratory : this.laboratories) {

            IDs.add(laboratory.getId());
            if (++ i != IDs.size())
                throw new DuplicatedIdException(String.valueOf(laboratory.getId()));
        }
    }

    /**
     * The {@code findUniqueID()} method generates a new unique ID to
     * a new element.
     *
     * @return          object if {@code Long} class
     */
    public Long findUniqueID() {

        Long ID = Long.MAX_VALUE;
        Set<Long> ids = new HashSet<>();

        for (Laboratory laboratory : this.laboratories) ids.add(laboratory.getId());

        long size = ids.size();
        while (ids.size() == size) ids.add(-- ID);

        return ID;
    }

    /**
     * Getter
     *
     * @return          object of {@code LinkedList} class
     */
    public LinkedList<Laboratory> getLaboratories() { return laboratories; }

    /**
     * Getter
     *
     * @return          object of {@code LocalDate} class
     */
    public LocalDate getInitializationDate() { return initializationDate; }

    /**
     * Getter
     *
     * @return          object of {@code Manager} class
     */
    public CSVManager getManager() { return manager; }
}
