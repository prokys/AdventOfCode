package utils;

import java.util.Objects;

public class Position {
    private int columnPosition;
    private int rowPosition;

    public int getRowPosition() {
        return rowPosition;
    }

    public void setRowPosition(int rowPosition) {
        this.rowPosition = rowPosition;
    }

    public int getColumnPosition() {
        return columnPosition;
    }

    public void setColumnPosition(int columnPosition) {
        this.columnPosition = columnPosition;
    }

    public Position(int column, int row){
        this.columnPosition= column;
        this.rowPosition = row;
    }

    public Position() {

    }

    public Position(PositionOfChar position) {
        this.columnPosition = position.getColumnPosition();
        this.rowPosition = position.getRowPosition();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return columnPosition == position.columnPosition && rowPosition == position.rowPosition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(columnPosition, rowPosition);
    }

    @Override
    public String toString() {
        return "Position{" +
                "columnPosition=" + columnPosition +
                ", rowPosition=" + rowPosition +
                '}';
    }
}
