package AOC2025.day9;

import utils.Coordinates2D;
import utils.PositionOfChar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day9 {

    public static long partOne(List<String> input){

        List<Coordinates2D> coordinates = getCoordinates(input);

        return getArea(coordinates);
    }

    public static long partTwo(List<String> input){

        long start = System.nanoTime();
        long area = 0;
        List<Coordinates2D> coordinates = getCoordinates(input);
        List<PositionOfChar> positions = getPositions(coordinates);
        List<PositionOfChar> outsidePositions = getOutsidePositions(positions);

        List<PositionOfChar> borders = new ArrayList<>();
        borders.addAll(positions);
        borders.addAll(outsidePositions);

        List<PositionOfChar> insidePositions = getInsidePositions(outsidePositions, borders);

        List<PositionOfChar> allPositions = new ArrayList<>();
        allPositions.addAll(borders);
        allPositions.addAll(insidePositions);

        for (int i = 0; i < positions.size(); i++) {
            for (int j = i; j < positions.size(); j++) {

                PositionOfChar p1 = positions.get(i);
                PositionOfChar p2 = positions.get(j);
                long tempArea = p1.getArea(p2);
                PositionOfChar p3 = new PositionOfChar(p1.getColumnPosition(), p2.getRowPosition());
                PositionOfChar p4 = new PositionOfChar(p2.getColumnPosition(), p1.getRowPosition());

                if ((tempArea > area)){
                    if (allPositions.contains(p1) && allPositions.contains(p2) && allPositions.contains(p3) && allPositions.contains(p4)){
                        area = tempArea;
                    }
                }


            }
        }

        long end = System.nanoTime();
        System.out.println(end-start);
        return area;
    }

    private static List<PositionOfChar> getInsidePositions(List<PositionOfChar> outsidePositions, List<PositionOfChar> borders) {

        Set<PositionOfChar> positions = new HashSet<>();

        for (PositionOfChar position : outsidePositions){
            PositionOfChar newPosition;
            switch (position.getMovedFrom()){
                case "left":{
                    int i = position.getRowPosition();
                    while (!borders.contains( new PositionOfChar(position.getColumnPosition(),i+1))){
                        i++;
                        newPosition = new PositionOfChar(position.getColumnPosition(),i);
                        positions.add(newPosition);
                    }
                    break;
                }
                case "right":{
                    int i = position.getRowPosition();
                    while (!borders.contains( new PositionOfChar(position.getColumnPosition(),i-1))){
                        i--;
                        newPosition = new PositionOfChar(position.getColumnPosition(),i);
                        positions.add(newPosition);
                    }
                    break;
                }
                case "top":{
                    int i = position.getColumnPosition();
                    while (!borders.contains(new PositionOfChar(i-1,position.getRowPosition()))){
                        i--;
                        newPosition = new PositionOfChar(i,position.getRowPosition());
                        positions.add(newPosition);
                    }
                    break;
                }
                case "bot":{
                    int i = position.getColumnPosition();
                    while (!borders.contains(new PositionOfChar(i+1,position.getRowPosition()))){
                        i++;
                        newPosition = new PositionOfChar(i,position.getRowPosition());
                        positions.add(newPosition);
                    }
                    break;
                }
            }
        }


        return positions.stream().toList();
    }

    private static List<PositionOfChar> getOutsidePositions(List<PositionOfChar> positions) {

        List<PositionOfChar> outsidePositions = new ArrayList<>();

        for (int j = 0; j < positions.size(); j++) {
            PositionOfChar currentPosition = positions.get(j);
            PositionOfChar nextPosition;
            if (j < positions.size()-1){
                 nextPosition = positions.get(j+1);
            }else nextPosition = positions.get(0);

            switch (nextPosition.getMovedFrom()){
                case "left":{
                    for (int i = currentPosition.getColumnPosition()+1; i < nextPosition.getColumnPosition(); i++) {
                        PositionOfChar newPosition = new PositionOfChar(i, currentPosition.getRowPosition());
                        newPosition.setMovedFrom(nextPosition.getMovedFrom());
                        outsidePositions.add(newPosition);
                    }
                    break;
                }
                case "right":{
                    for (int i = currentPosition.getColumnPosition()-1; i > nextPosition.getColumnPosition(); i--) {
                        PositionOfChar newPosition = new PositionOfChar(i, currentPosition.getRowPosition());
                        newPosition.setMovedFrom(nextPosition.getMovedFrom());
                        outsidePositions.add(newPosition);
                    }
                    break;
                }
                case "top":{
                    for (int i = currentPosition.getRowPosition()+1; i < nextPosition.getRowPosition(); i++) {
                        PositionOfChar newPosition = new PositionOfChar(currentPosition.getColumnPosition(), i);
                        newPosition.setMovedFrom(nextPosition.getMovedFrom());
                        outsidePositions.add(newPosition);
                    }
                    break;
                }
                case "bot":{
                    for (int i = currentPosition.getRowPosition()-1; i > nextPosition.getRowPosition(); i--) {
                        PositionOfChar newPosition = new PositionOfChar(currentPosition.getColumnPosition(), i);
                        newPosition.setMovedFrom(nextPosition.getMovedFrom());
                        outsidePositions.add(newPosition);
                    }
                    break;
                }
            }


        }



        return outsidePositions;
    }

    private static List<PositionOfChar> getPositions(List<Coordinates2D> coordinates){

        List<PositionOfChar> positions = new ArrayList<>();

        PositionOfChar currentPosition = new PositionOfChar(coordinates.get(0).getX(), coordinates.get(0).getY());
        PositionOfChar lastPosition = new PositionOfChar(coordinates.get(coordinates.size()-1).getX(), coordinates.get(coordinates.size()-1).getY());
        currentPosition.setMovedFrom(getDirection(currentPosition, lastPosition));
        positions.add(currentPosition);

        for (int i = 1; i < coordinates.size(); i++) {
            lastPosition = currentPosition;
            currentPosition = new PositionOfChar(coordinates.get(i).getX(), coordinates.get(i).getY());
            currentPosition.setMovedFrom(getDirection(currentPosition, lastPosition));
            positions.add(currentPosition);
        }

        return positions;
    }

    private static String getDirection(PositionOfChar current, PositionOfChar last){

        if (current.getRowPosition() > last.getRowPosition()){
            return "top";
        } else if (current.getRowPosition() < last.getRowPosition()) {
            return "bot";
        } else if (current.getColumnPosition() < last.getColumnPosition()) {
            return "right";
        } else if (current.getColumnPosition() > last.getColumnPosition()) {
            return "left";
        }
        return "";
    }

    private static long getArea(List<Coordinates2D> coordinates){
        long area = 0;

        for (int i = 0; i < coordinates.size(); i++) {
            for (int j = i; j < coordinates.size(); j++) {

                if (coordinates.get(i).getArea(coordinates.get(j)) > area){
                    area = coordinates.get(i).getArea(coordinates.get(j));
                }

            }
        }
        return area;
    }

    private static List<Coordinates2D> getCoordinates(List<String> input){

        List<Coordinates2D> coordinates = new ArrayList<>();

        for (String value : input){

            Coordinates2D coordinate = new Coordinates2D();

            int dash1 = value.indexOf(',');

            coordinate.setX(Integer.parseInt(value.substring(0,dash1).trim()));
            coordinate.setY(Integer.parseInt(value.substring(dash1+1).trim()));

            coordinates.add(coordinate);
        }

        return coordinates;
    }
}
