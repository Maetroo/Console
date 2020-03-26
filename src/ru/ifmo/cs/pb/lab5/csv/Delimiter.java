package ru.ifmo.cs.pb.lab5.csv;

/**
 * The {@code Delimiter} enum contains types of delimiter in .csv file
 *
 * @author  Bobur Zakirov
 * @since   2020-03-15
 */
public enum Delimiter {

    COMMA, PIPE, COLON, SEMICOLON, SPACE;

    /**
     * The {@code getDelimiter} method gets a String value of delimiter
     *
     * @param delimiter     type of delimiter
     * @return              String value of delimiter
     */
    public static String getDelimiter(Delimiter delimiter) {

        switch (delimiter) {

            case COMMA:
                return ",";
            case PIPE:
                return "|";
            case COLON:
                return ":";
            case SEMICOLON:
                return ";";
            case SPACE:
                return " ";
            default:
                return ",";
        }
    }
}