package _03_SetsAndMapsAdvancedEx;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        Set<String> words = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {

            words.add(scan.nextLine());
        }

        for (String word : words){
            System.out.println(word);
        }
    }
}
