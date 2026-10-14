package main.java.session_1.class_problems;

import java.util.*;

public class FirstNonRepeating {

    static char findFirstNonRepeatingChar(String s) {
        int[] freq = new int[65536];

        for (int i = 0; i < s.length(); i++)
            freq[s.charAt(i)]++;

        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i)] == 1)
                return s.charAt(i);
        }

        return '\0';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a word or sentence: ");
        String s = sc.nextLine();

        char result = findFirstNonRepeatingChar(s);

        if (result == '\0')
            System.out.println("No Non-Repeating Character Found");
        else
            System.out.println("First Non-Repeating Character: '" + result + "'");

        sc.close();
    }
}
