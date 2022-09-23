package org.example.objects;

public class Coordinates {
    private Double x; //Поле не может быть null
    private int y;

    public Double getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "\n\t\tx=" + x +
                ",\n\t\ty=" + y +
                "\n\t}";
    }
}
