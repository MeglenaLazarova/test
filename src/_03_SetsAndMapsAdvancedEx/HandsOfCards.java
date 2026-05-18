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


        for (Map.Entry<String, Set<String>> c : cards.entrySet()){
            Set<String> c2 = c.getValue();
            String name = c.getKey();

            int sum = 0;

            for (String c3 : c2){
                String rank = c3.substring(0, c3.length() - 1); // 2, 3, 10, J, Q, K, A
                char suit = c3.charAt(c3.length() - 1);         // S, H, D, C

                int power;
                switch (rank) {
                    case "J" -> power = 11;
                    case "Q" -> power = 12;
                    case "K" -> power = 13;
                    case "A" -> power = 14;
                    default -> power = Integer.parseInt(rank);
                }

                int type = switch (suit) {
                    case 'S' -> 4;
                    case 'H' -> 3;
                    case 'D' -> 2;
                    case 'C' -> 1;
                    default -> 0;
                };

                sum += power * type;
            }

            System.out.println(name + ": " + sum);
        }
     }
}
