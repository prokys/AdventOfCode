package AOC2023.utils;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class CardDeckComparator implements Comparator<String> {

    private static Map<Character, Integer> customOrder = new HashMap<>();

    public CardDeckComparator(Map<Character, Integer> customOrderMap) {
        customOrder = customOrderMap;
    }

    @Override
    public int compare(String d1, String d2) {

        int length = Math.min(d1.length(), d2.length());
        for (int i = 0; i < length; i++) {
            char card1 = d1.charAt(i);
            char card2 = d2.charAt(i);

            int value1 = customOrder.get(card1);
            int value2 = customOrder.get(card2);

            if (value1 != value2) {
                return Integer.compare(value1, value2);
            }
        }
        return Integer.compare(d1.length(), d2.length());
    }
}
