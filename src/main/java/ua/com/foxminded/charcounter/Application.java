package ua.com.foxminded.charcounter;

import java.util.Map;
import java.util.Scanner;
import java.util.stream.*;

public class Application {

    private static final String YES = "y";

    public static void main(String args[]) {
        CharCountFormatter formatter = new CharCountFormatter();
        CharCounter wordsCash = new CharCounter();
        boolean isContinue = true;
        try (Scanner in = new Scanner(System.in);) {
            while (isContinue) {
                System.out.println("Please enter line to count characteres:");
                String input = in.nextLine();
                Map<Character, Integer> result = wordsCash.calculateCharsAmount(input);
                String formattedResult = formatter.formatResult(result);
                System.out.println(formattedResult);
                System.out.println("Press 'y' to proceed");
                isContinue = YES.equalsIgnoreCase(in.nextLine());
            }
        }
        System.out.println("Application was stopped...");
    }
}
