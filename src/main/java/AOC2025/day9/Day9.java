package AOC2025.day9;

import utils.Coordinates2D;

import java.util.ArrayList;
import java.util.List;

public class Day9 {

    public static long partOne(List<String> input){

        List<Coordinates2D> coordinates = getCoordinates(input);

        return getArea(coordinates);
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
