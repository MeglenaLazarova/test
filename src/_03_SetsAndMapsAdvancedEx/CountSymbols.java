package _03_SetsAndMapsAdvancedEx;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        Map<Character, Integer> pairs = new TreeMap<>();

        for (char ch : input.toCharArray()) {
            pairs.put(ch, pairs.getOrDefault(ch, 0) + 1);
        }

        for (Map.Entry<Character, Integer> pair : pairs.entrySet()) {
            System.out.println(pair.getKey() + ": " + pair.getValue() + " time/s");
        }
    }
}
