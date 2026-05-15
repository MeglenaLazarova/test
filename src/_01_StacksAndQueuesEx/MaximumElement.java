package _01_StacksAndQueuesEx;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split(" ");
            switch (input[0]){
                case "1" -> numbers.push(Integer.parseInt(input[1]));
                case "2" -> numbers.pop();
                case "3" -> {
                    int maxNumb = Integer.MIN_VALUE;
                    for (int number :numbers){
                        if (number > maxNumb){
                            maxNumb = number;
                        }
                    }
                    System.out.println(maxNumb);
                }
            }
        }
    }
}
