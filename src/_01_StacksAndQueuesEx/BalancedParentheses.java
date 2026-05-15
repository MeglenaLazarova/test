package _01_StacksAndQueuesEx;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("");

        ArrayDeque<String> symbols = new ArrayDeque<>();

        if (input.length <= 1){
            System.out.println("NO");
        } else {
            if (input.length % 2 != 0){
                System.out.println("NO");
            } else {
                for (int i = 0; i < input.length; i++) {

                    if (input[i].equals("(") || input[i].equals("{") || input[i].equals("[")){
                        symbols.push(input[i]);
                    }

                    if (input[i].equals(")") || input[i].equals("}") || input[i].equals("]")){
                        String pop = symbols.pop();
                        if (input[i].equals(")") && !pop.equals("(") ||
                                input[i].equals("}") && !pop.equals("{") ||
                                input[i].equals("]") && !pop.equals("[")){
                            System.out.println("NO");
                            return;
                        }
                    }

                }
                if (symbols.isEmpty()){
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }

    }
}
