package ru.ifmo.cs.pb.lab5.object;

import ru.ifmo.cs.pb.lab5.exception.run.DifficultyParseException;

import java.util.HashMap;
import java.util.Map;

public enum Difficulty {

    VERY_EASY, NORMAL, HARD, IMPOSSIBLE, TERRIBLE;

    public static Map<Difficulty, Integer> getDifficultyMap = new HashMap<Difficulty, Integer>() {
        {
            put(VERY_EASY, 1);
            put(NORMAL, 2);
            put(HARD, 3);
            put(IMPOSSIBLE, 4);
            put(TERRIBLE, 5);
        }
    };

    public static Difficulty parseDifficulty(String difficulty) {

        switch (difficulty) {

            case "VERY_EASY":
                return VERY_EASY;
            case "NORMAL":
                return NORMAL;
            case "HARD":
                return HARD;
            case "IMPOSSIBLE":
                return IMPOSSIBLE;
            case "TERRIBLE":
                return TERRIBLE;
            default:
                throw new DifficultyParseException(difficulty);
        }
    }
}
