package ru.ifmo.cs.pb.lab5.object;

public class Coordinates {

    private long x;
    private double y;

    public Coordinates() { }

    public Coordinates (long x, double y) {
        this.x = x;
        this.y = y;
    }

    public long getX() {
        return x;
    }

    public void setX(long x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
