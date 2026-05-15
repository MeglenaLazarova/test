package _01_StacksAndQueuesEx;

import java.util.ArrayDeque;
import java.util.Scanner;

public class ReverseNumbersWithStack {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] n = scan.nextLine().split(" ");

        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        for (int i = 0; i < n.length; i++) {
            int number = Integer.parseInt(n[i]);

            numbers.push(number);
        }

        for (int number : numbers){
            System.out.print(number + " ");
        }

    }
}
