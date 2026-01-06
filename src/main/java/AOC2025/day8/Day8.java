package AOC2025.day8;

import utils.Coordinates3D;

import java.util.*;

public class Day8 {

    public static int partOne(List<String> input, int numOfPairs){

        List<Coordinates3D> coordinates = getCoordinates(input);
        List<List<Integer>> distances = getDistances(coordinates);
        List<Integer> allDistances = getAllDistances(distances);
        Collections.sort(allDistances);
        List<Integer> subDistances = allDistances.subList(0,numOfPairs);
        List<Coordinates3D> pairs = getPairs(distances, coordinates, subDistances);
        Set<Set<Coordinates3D>> circuits = getCircuits(pairs);

        return getTopThreeMultiplied(circuits);
    }

    private static int getTopThreeMultiplied(Set<Set<Coordinates3D>> circuits){
        int highest = 0;
        int second = 0;
        int third = 0;
        for (Set<Coordinates3D> set: circuits){
            if (set.size() > highest){
                third = second;
                second = highest;
                highest = set.size();
            } else if (set.size() > second) {
                third = second;
                second = set.size();
            } else if (set.size() > third){
                third = set.size();
            }
        }

        return highest*second*third;
    }

    private static Set<Set<Coordinates3D>> getCircuits(List<Coordinates3D> pairs){
        Set<Set<Coordinates3D>> circuits = new HashSet<>();

        for (int i = 0; i < pairs.size(); i+=2) {
            Set<Coordinates3D> coordinates3DS = new HashSet<>();
            coordinates3DS.add(pairs.get(i));
            coordinates3DS.add(pairs.get(i+1));
            for (int j = 0; j < pairs.size(); j++) {
                if (coordinates3DS.contains(pairs.get(j)) && j%2 == 1 && !coordinates3DS.contains(pairs.get(j-1))){
                    coordinates3DS.add(pairs.get(j-1));
                    j=0;
                } else if (coordinates3DS.contains(pairs.get(j)) && j%2 == 0 && !coordinates3DS.contains(pairs.get(j+1))) {
                    coordinates3DS.add(pairs.get(j+1));
                    j=0;
                } else if (!coordinates3DS.contains(pairs.get(j)) && j%2 == 1 && coordinates3DS.contains(pairs.get(j-1))) {
                    coordinates3DS.add(pairs.get(j));
                    j=0;
                } else if (!coordinates3DS.contains(pairs.get(j)) && j%2 == 0 && coordinates3DS.contains(pairs.get(j+1))) {
                    coordinates3DS.add(pairs.get(j));
                    j=0;
                }
            }
            circuits.add(coordinates3DS);
        }
        return circuits;
    }

    private static List<Coordinates3D> getPairs(List<List<Integer>> distances, List<Coordinates3D> coordinates, List<Integer> subDistances){

        List<Coordinates3D> pairs = new ArrayList<>();

        for (int i = 0; i < distances.size(); i++) {
            for (int j = i; j < distances.get(0).size(); j++) {
                if (subDistances.contains(distances.get(i).get(j))){
                    pairs.add(coordinates.get(i));
                    pairs.add(coordinates.get(j));
                }
            }
        }
        return pairs;
    }

    private static List<Integer> getAllDistances(List<List<Integer>> distances){

        List<Integer> allDistances = new ArrayList<>();

        for (int i = 0; i < distances.size(); i++) {
            for (int j = i; j < distances.get(0).size(); j++) {
                if (distances.get(i).get(j) > 0) allDistances.add(distances.get(i).get(j));
            }
        }
        return allDistances;
    }

    private static List<List<Integer>> getDistances(List<Coordinates3D> coordinates){

        List<List<Integer>> distances = new ArrayList<>();

        for (int i = 0; i < coordinates.size(); i++) {
            Coordinates3D coordinate = coordinates.get(i);
            List<Integer> tempList = new ArrayList<>();
            for (int j = 0; j < coordinates.size(); j++) {
                if (j > i){
                    Coordinates3D coordinate2 = coordinates.get(j);
                    tempList.add(coordinate.getDistance(coordinate2));
                }else tempList.add(0);

            }
            distances.add(tempList);
        }
        return distances;
    }

    private static List<Coordinates3D> getCoordinates(List<String> input){

        List<Coordinates3D> coordinates = new ArrayList<>();

        for (String value : input){

            Coordinates3D coordinate = new Coordinates3D();

            int dash1 = value.indexOf(',');
            int dash2 = value.lastIndexOf(',');

            coordinate.setX(Integer.parseInt(value.substring(0,dash1).trim()));
            coordinate.setY(Integer.parseInt(value.substring(dash1+1,dash2).trim()));
            coordinate.setZ(Integer.parseInt(value.substring(dash2+1).trim()));

            coordinates.add(coordinate);
        }
        return coordinates;
    }
}
