package utils;

import java.util.Objects;

public class PositionOfChar {
    private int columnPosition;
    private int rowPosition;

    public PositionOfChar(int column, int row){
        this.columnPosition= column;
        this.rowPosition = row;
    }

    public PositionOfChar() {
    }

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

    @Override
    public String toString() {
        return "PositionOfChar{" +
                "columnPosition=" + columnPosition +
                ", rowPosition=" + rowPosition +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositionOfChar that = (PositionOfChar) o;
        return columnPosition == that.columnPosition && rowPosition == that.rowPosition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(columnPosition, rowPosition);
    }
}
