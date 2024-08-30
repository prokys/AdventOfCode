package utils;

import java.util.Objects;

public class PositionOfChar extends Position{

    private String movedFrom;

    public PositionOfChar(int column, int row) {
        super(column, row);
    }

    public PositionOfChar(PositionOfChar position){
        this.setColumnPosition(position.getColumnPosition());
        this.setRowPosition(position.getRowPosition());
        this.movedFrom = position.movedFrom;
    }

    public PositionOfChar() {

    }


    public String getMovedFrom() {
        return movedFrom;
    }

    public void setMovedFrom(String movedFrom) {
        this.movedFrom = movedFrom;
    }

    @Override
    public String toString() {
        return "PositionOfChar{" +
                "columnPosition=" + getColumnPosition() +
                ", rowPosition=" + getRowPosition() +
                ", movedFrom='" + movedFrom + '\'' +
                '}';
    }



    @Override
    public int hashCode() {
        return Objects.hash(movedFrom);
    }
}
