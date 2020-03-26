package ru.ifmo.cs.pb.lab5.object;

import java.time.LocalDate;

public class Laboratory implements Comparable {

    private Long id;
    private String name;
    private Coordinates coordinates;
    private LocalDate creationDate;
    private Float minimalPoint;
    private Double personalQualitiesMinimum;
    private Integer tunedInWorks;
    private Difficulty difficulty;
    private Discipline discipline;

    public Laboratory() { }

    public Laboratory(String name,
                      Coordinates coordinates,
                      Float minimalPoint,
                      Double personalQualitiesMinimum,
                      Integer tunedInWorks,
                      Difficulty difficulty,
                      Discipline discipline) {
        this.name = name;
        this.coordinates = coordinates;
        this.minimalPoint = minimalPoint;
        this.personalQualitiesMinimum = personalQualitiesMinimum;
        this.tunedInWorks = tunedInWorks;
        this.difficulty = difficulty;
        this.discipline = discipline;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Coordinates getCoordinates() { return coordinates; }

    public void setCoordinates(Coordinates coordinates) { this.coordinates = coordinates; }

    public LocalDate getCreationDate() { return creationDate; }

    public void setCreationDate(LocalDate creationDate) { this.creationDate = creationDate; }

    public Float getMinimalPoint() { return minimalPoint; }

    public void setMinimalPoint(Float minimalPoint) { this.minimalPoint = minimalPoint; }

    public Double getPersonalQualitiesMinimum() { return personalQualitiesMinimum; }

    public void setPersonalQualitiesMinimum(Double personalQualitiesMinimum) { this.personalQualitiesMinimum = personalQualitiesMinimum; }

    public Integer getTunedInWorks() { return tunedInWorks; }

    public void setTunedInWorks(Integer tunedInWorks) { this.tunedInWorks = tunedInWorks; }

    public Difficulty getDifficulty() { return difficulty; }

    public void setDifficulty(Difficulty difficulty) { this.difficulty = difficulty; }

    public Discipline getDiscipline() { return discipline; }

    public void setDiscipline(Discipline discipline) { this.discipline = discipline; }

    @Override
    public String toString() {
        return "Laboratory: {\n" +
                "\tid = " + id + "\n" +
                "\tname = " + name + "\n" +
                "\tCoordinates: {\n" +
                "\t\tx = " + coordinates.getX() + "\n" +
                "\t\ty = " + coordinates.getY() + "\n" +
                "\t}\n" +
                "\tcreationDate = " + creationDate + "\n" +
                "\tminimalPoint = " + minimalPoint + "\n" +
                "\tpersonalQualitiesMinimum = " + personalQualitiesMinimum + "\n" +
                "\ttunedInWorks = " + tunedInWorks + "\n" +
                "\tdifficulty = " + difficulty + "\n" +
                "\tDiscipline: {\n" +
                "\t\tname = " + discipline.getName() + "\n" +
                "\t\tselfStudyHours = " + discipline.getSelfStudyHours() + "\n" +
                "\t\tlabsCount = " + discipline.getLabsCount() + "\n" +
                "\t}\n" +
                "}";
    }

    @Override
    public int compareTo(Object o) {

        Laboratory laboratory = (Laboratory) o;

        if (this.difficulty == null && laboratory.getDifficulty() == null) return 0;

        else if (this.difficulty == null) return -1;

        else if (laboratory.getDifficulty() == null) return 1;

        else return Difficulty.getDifficultyMap.get(this.difficulty)
                .compareTo(Difficulty.getDifficultyMap.get(laboratory.getDifficulty()));
    }
}
