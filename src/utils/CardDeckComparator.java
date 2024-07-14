package utils;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class CardDeckComparator implements Comparator<String> {
    private static final Map<Character, Integer> customOrder = new HashMap<>();

    static {
        customOrder.put('2', 2);
        customOrder.put('3', 3);
        customOrder.put('4', 4);
        customOrder.put('5', 5);
        customOrder.put('6', 6);
        customOrder.put('7', 7);
        customOrder.put('8', 8);
        customOrder.put('9', 9);
        customOrder.put('T', 10);
        customOrder.put('J', 11);
        customOrder.put('Q', 12);
        customOrder.put('K', 13);
        customOrder.put('A', 14);
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
