package _01_StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _01BrowserHistory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String current = "";

        ArrayDeque<String> urls = new ArrayDeque<>();

        while (!input.equals("Home")){

            if (input.equals("back")){
                if (urls.isEmpty()){
                    System.out.println("no previous URLs");
                } else {
                    System.out.println(urls.pop());
                }
            } else {
                if (!current.isEmpty()) {
                    urls.push(current);
                }
                current = input;
                    System.out.println(input);

            }

            input = scan.nextLine();
        }
    }
}
