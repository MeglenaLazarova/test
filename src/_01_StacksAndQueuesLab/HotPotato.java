package _01_StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(" ");
        int n = Integer.parseInt(scan.nextLine());

        ArrayDeque<String> names = new ArrayDeque<>();


        for (int i = 0; i < input.length; i++) {
            names.offer(input[i]);

        }

        while (names.size() > 1){
            for (int i = 1; i < n; i++) {
                String name = names.pollFirst();
                names.offer(name);
            }
            System.out.println("Removed " + names.pollFirst());
        }

        System.out.println("Last is " + names.pollFirst());
    }
}
