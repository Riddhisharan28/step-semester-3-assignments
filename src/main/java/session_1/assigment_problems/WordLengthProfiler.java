package main.java.session_1.assigment_problems;

import java.util.*;

public class WordLengthProfiler {
    static void classifyWordLengths(String review) {
        String[] words = review.trim().split("\\s+");

        int shortCount = 0, mediumCount = 0, longCount = 0;

        for (String word : words) {
            int len = word.replaceAll("[^a-zA-Z]", "").length();

            if (len == 0)
                continue;
            else if (len <= 4)
                shortCount++;
            else if (len <= 8)
                mediumCount++;
            else
                longCount++;
        }

        System.out.println("Short: " + shortCount
                + " | Medium: " + mediumCount
                + " | Long: " + longCount);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter movie review: ");
        String review = sc.nextLine();

        classifyWordLengths(review);
        sc.close();
    }
}