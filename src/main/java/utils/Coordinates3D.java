package utils;

import java.util.Objects;

import static java.lang.Math.*;

public class Coordinates3D {

    private int x;
    private int y;
    private int z;

    public Coordinates3D() {
    }

    public Coordinates3D(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public String toString() {
        return "Coordinates3D{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates3D that = (Coordinates3D) o;
        return x == that.x && y == that.y && z == that.z;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    public int getDistance(Coordinates3D otherCoordinate){
        return (int)sqrt(pow(this.x-otherCoordinate.getX(),2) + pow(this.y-otherCoordinate.getY(),2) + pow(this.z-otherCoordinate.getZ(),2));
    }
}
