package utils;

import java.util.Objects;

public class Coordinates2D {

    private int x;
    private int y;

    public Coordinates2D() {
    }

    public Coordinates2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coordinates2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates2D that = (Coordinates2D) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public long getArea(Coordinates2D coordinates2D){
        return (long) (this.x - coordinates2D.x + 1) *(this.y-coordinates2D.y+1);
    }
}
