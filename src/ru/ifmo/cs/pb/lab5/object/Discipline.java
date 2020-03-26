package ru.ifmo.cs.pb.lab5.object;

public class Discipline implements Comparable {

    private String name;
    private Integer selfStudyHours;
    private Long labsCount;

    public Discipline() {}

    public Discipline(String name, Integer selfStudyHours, Long labsCount) {
        this.name = name;
        this.selfStudyHours = selfStudyHours;
        this.labsCount = labsCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSelfStudyHours() {
        return selfStudyHours;
    }

    public void setSelfStudyHours(Integer selfStudyHours) {
        this.selfStudyHours = selfStudyHours;
    }

    public Long getLabsCount() {
        return labsCount;
    }

    public void setLabsCount(Long labsCount) {
        this.labsCount = labsCount;
    }

    @Override
    public int compareTo(Object o) {

        Discipline discipline = (Discipline) o;
        return this.name.compareTo(discipline.getName());
    }
}
