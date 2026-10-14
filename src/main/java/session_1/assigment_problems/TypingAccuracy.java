package main.java.session_1.assigment_problems;

import java.util.*;

public class TypingAccuracy {
    static void checkTypingAccuracy(String original, String typed) {
        int matched = 0;
        int first = -1;
        int len = Math.min(original.length(), typed.length());

        for (int i = 0; i < len; i++) {
            if (original.charAt(i) == typed.charAt(i))
                matched++;
            else if (first == -1)
                first = i;
        }

        double accuracy = (matched * 100.0) / original.length();

        System.out.printf("Matched: %d/%d | Accuracy: %.2f%%%n",
                matched, original.length(), accuracy);

        if (first == -1 && original.length() == typed.length()) {
            System.out.println("No Mismatches");
        } else if (first != -1) {
            System.out.println("First Mismatch at position " + (first + 1)
                    + " ('" + original.charAt(first) + "' vs '"
                    + typed.charAt(first) + "')");
        } else {
            System.out.println("Length mismatch: Original = "
                    + original.length() + ", Typed = " + typed.length());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter original passage: ");
        String original = sc.nextLine();

        System.out.print("Enter typed passage: ");
        String typed = sc.nextLine();

        checkTypingAccuracy(original, typed);
        sc.close();
    }
}