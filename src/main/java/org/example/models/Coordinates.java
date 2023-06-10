package org.example.models;

public class Coordinates {

    private Integer x;
    private double y;

    public Coordinates(Integer x, double y) {
        if (!validateX(x)) {
            throw new IllegalArgumentException("Invalid value for 'x'.");
        }
        if (!validateY(y)) {
            throw new IllegalArgumentException("Invalid value for 'y'.");
        }
        this.x = x;
        this.y = y;
    }

    // Validate

    private boolean validateX(Integer x) {
        if (x == null) {
            throw new IllegalArgumentException("Field 'x' cannot be null.");
        }
        return x > -863;
    }

    private boolean validateY(double y) {
        return y > -33;
    }

    // Set and Get

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}