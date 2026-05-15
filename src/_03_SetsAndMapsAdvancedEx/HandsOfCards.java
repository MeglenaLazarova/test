package _03_SetsAndMapsAdvancedEx;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Set<String>> cards = new LinkedHashMap<>();

        String[] input = scan.nextLine().split(": ");

        while (!input[0].equals("JOKER")){

            String name = input[0];
            String[] decks = input[1].split(", ");
            Set<String> current = new HashSet<>();

            for (String deck : decks){
                current.add(deck);
                cards.computeIfPresent(name, (k,v) -> {
                    v.add(deck);
                    return v;
                });
            }

            cards.putIfAbsent(name, current);

            input = scan.nextLine().split(": ");
        }

        for (Map.Entry<>)
     }
}
